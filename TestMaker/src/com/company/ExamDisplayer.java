package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamDisplayer extends JFrame implements ActionListener {

    List<Exam> examArrayList = new ArrayList<>();
    JList listWithExamNames;
    JScrollPane scrollPane, scrollPane2;
    JTextArea tPreview;
    JButton bSaveExamAsTxt;
    JButton bAssign;
    public ExamAssingment examAssingment;
    public JButton bExit;
    public JLabel lListOfExams,lPreviewOfWritingVersion;


    public ExamDisplayer (JFrame owner) throws IOException, ClassNotFoundException {
        setSize(800, 700);
        setTitle("Baza testów");
        setLayout(null);

        FileInputStream f0 = new FileInputStream((new File("myExams.bin")));
        ObjectInputStream o0 = new ObjectInputStream(f0);
        if(!o0.toString().equals(null))examArrayList =(List<Exam>) o0.readObject();


        List <String> examNameList = new ArrayList<>();
        for (int i = 0; i<examArrayList.size();i++)
        {
            examNameList.add(examArrayList.get(i).getExamName());
        }

        listWithExamNames = new JList(examNameList.toArray());
        scrollPane = new JScrollPane(listWithExamNames);
        scrollPane.setBounds(50,50,300,400);
        add(scrollPane);
        listWithExamNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



        tPreview= new JTextArea();
        scrollPane2 = new JScrollPane(tPreview);
        scrollPane2.setBounds(400, 50,300,400);
        add(scrollPane2);
        listWithExamNames.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if(!arg0.getValueIsAdjusting())
                {
                    int i = listWithExamNames.getAnchorSelectionIndex();
                    Exam examToDisplay = examArrayList.get(i);
                    tPreview.setText(examToDisplay.toStringWritingVersion());
                }
            }
        });


        lListOfExams = new JLabel("Dostępne testy");
        lListOfExams.setBounds(50,20,300,20);
        add(lListOfExams);

        lPreviewOfWritingVersion = new JLabel("Podgląd wersji dla ucznia");
        lPreviewOfWritingVersion.setBounds(400,20,300,20);
        add(lPreviewOfWritingVersion);





        bSaveExamAsTxt = new JButton("Zapisz test jako plik txt");
        bSaveExamAsTxt.setBounds(50,550, 300, 75);
        bSaveExamAsTxt.addActionListener(this);
        add(bSaveExamAsTxt);


        bAssign = new JButton("Wrowadź odpowiedzi ucznia");
        bAssign.setBounds(400,550, 300, 75);
        bAssign.addActionListener(this);
        add(bAssign);

        //bExit = new JButton("Wróć do głównego menu");
        //bExit.setBounds(500,500,100,100);
        //bExit.addActionListener(this);
        //add(bExit);







    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventSource = e.getSource();
        if(eventSource == bSaveExamAsTxt)
        {
            int i = listWithExamNames.getAnchorSelectionIndex();
            if(i==-1)
            {
                WarningMessage2 warningMessage2 = new WarningMessage2(this);
                warningMessage2.setVisible(true);
            }
            else {

                JFileChooser fc = new JFileChooser();
                if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File plik = fc.getSelectedFile();
                    try {
                        PrintWriter pw = new PrintWriter(plik);
                        Scanner scanner = new Scanner(tPreview.getText());
                        while (scanner.hasNext()) {
                            pw.println(scanner.nextLine() + '\n');
                        }
                        pw.close();

                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        }
        if(eventSource == bAssign)
        {
            int i = listWithExamNames.getAnchorSelectionIndex();
            if(i==-1)
            {
                WarningMessage2 warningMessage2 = new WarningMessage2(this);
                warningMessage2.setVisible(true);
            }

            else {
                Exam selectedExam = examArrayList.get(i);

                examAssingment = new ExamAssingment(this, selectedExam);
                examAssingment.setVisible(true);
            }
        }
        if(eventSource == bExit)
        {
            dispose();
        }

    }



}
