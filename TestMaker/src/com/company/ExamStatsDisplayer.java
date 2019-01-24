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

public class ExamStatsDisplayer extends JFrame implements ActionListener {
    public List<Exam> completedExamsList = new ArrayList<>();
    public List<List<Exam>> groupedExams = new ArrayList<>();//new ArrayList<List<Exam>>();
    public List<ExamStats> examStatsList = new ArrayList<>();
    JList listWithExamNames;
    JScrollPane scrollPane, scrollPane1;
    JLabel lAssignedTests, lDetails;
    JTextArea tPreview;


    public ExamStatsDisplayer (JFrame owner) throws IOException, ClassNotFoundException {
        setSize(750, 700);
        //System.out.println("lololo");
        setTitle("Ocenione testy");
        setLayout(null);

        FileInputStream f0 = new FileInputStream((new File("myCompletedExams.bin")));
        ObjectInputStream o0 = new ObjectInputStream(f0);
        if (!o0.toString().equals(null)) completedExamsList = (List<Exam>) o0.readObject();

        for(int i= 0; i<completedExamsList.size();i++)
        {
            boolean alreadyExist =false;
            for(int j=0; j<groupedExams.size();j++)
            {
                if(groupedExams.get(j).get(0).getExamName().equals(completedExamsList.get(i).getExamName()))
                {
                    groupedExams.get(j).add(completedExamsList.get(i));
                    alreadyExist = true;
                }
            }
            if(alreadyExist ==false)
            {
                List<Exam> examList = new ArrayList<>();
                examList.add(completedExamsList.get(i));
                groupedExams.add(examList);
            }
        }
        for(int i = 0; i<groupedExams.size();i++)
        {
            String examName = groupedExams.get(i).get(0).getExamName();
            int numberOfAttempts = groupedExams.get(i).size();
            double totalPercentages =0.0;
            for(int k=0;k<groupedExams.get(i).size();k++)
            {
                totalPercentages+=groupedExams.get(i).get(k).getOverallREsult();
            }
            totalPercentages=totalPercentages/numberOfAttempts;
            totalPercentages*=100;
            totalPercentages = Math.round(totalPercentages);
            totalPercentages/=100;
            ExamStats examStats = new ExamStats(examName,numberOfAttempts,totalPercentages);
            examStatsList.add(examStats);
        }

        List <String> examNamesList = new ArrayList<>();
        for (int i = 0; i<examStatsList.size();i++)
        {
            examNamesList.add(examStatsList.get(i).getExamName());
        }

        listWithExamNames = new JList(examNamesList.toArray());
        scrollPane = new JScrollPane(listWithExamNames);
        scrollPane.setBounds(50,50,300,400);
        add(scrollPane);


        listWithExamNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lAssignedTests = new JLabel("Ocenione testy");
        lAssignedTests.setBounds(50,20,300,30);
        add(lAssignedTests);


        lDetails = new JLabel("Statystyki");
        lDetails.setBounds(400,20,300,30);
        add(lDetails);

        tPreview= new JTextArea();
        //tPreview.setBounds(400, 50,300,200);
        //add(tPreview);

        scrollPane1 = new JScrollPane(tPreview);
        scrollPane1.setBounds(400, 50,300,200);
        add(scrollPane1);



        listWithExamNames.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if(!arg0.getValueIsAdjusting())
                {
                    int i = listWithExamNames.getAnchorSelectionIndex();
                    ExamStats examStatsToDisplay = examStatsList.get(i);
                    tPreview.setText(examStatsToDisplay.toString());
                }
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
