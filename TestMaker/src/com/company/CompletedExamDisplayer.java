package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class CompletedExamDisplayer extends JFrame implements ActionListener {

    public List<Exam> completedExamsList = new ArrayList<>();
    public JList listWithExams;
    public JScrollPane scrollPane, scrollPane2;
    public JLabel lListOfCompletedExams, lDetails;
    public JTextArea tDetails;

    public CompletedExamDisplayer (JFrame owner) throws IOException, ClassNotFoundException {
        setSize(750, 700);
        //System.out.println("lololo");
        setTitle("Ocenione testy");
        setLayout(null);

        FileInputStream f0 = new FileInputStream((new File("myCompletedExams.bin")));
        ObjectInputStream o0 = new ObjectInputStream(f0);
        if (!o0.toString().equals(null)) completedExamsList = (List<Exam>) o0.readObject();

        List<String> headlinesList = new ArrayList<>();
        for (int i = 0; i < completedExamsList.size(); i++) {
            String headline = completedExamsList.get(i).getExamName() + " "+completedExamsList.get(i).getStudentName();
            headlinesList.add(headline);
        }

        listWithExams = new JList(headlinesList.toArray());
        scrollPane = new JScrollPane(listWithExams);
        scrollPane.setBounds(50, 50, 300, 400);
        add(scrollPane);


        listWithExams.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lListOfCompletedExams = new JLabel("Ocenione testy");
        lListOfCompletedExams.setBounds(50, 20, 300, 30);
        add(lListOfCompletedExams);


        lDetails = new JLabel("Szczegóły egzaminu");
        lDetails.setBounds(400, 20, 300, 30);
        add(lDetails);

        tDetails = new JTextArea();
        scrollPane2 = new JScrollPane(tDetails);
        scrollPane2.setBounds(400, 50, 300, 200);
        add(scrollPane2);


        listWithExams.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    int i = listWithExams.getAnchorSelectionIndex();
                    Exam examToDisplay = completedExamsList.get(i);
                    tDetails.setText(examToDisplay.toString());
                }
            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
