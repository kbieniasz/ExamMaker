package com.company;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MyWindow extends JFrame  implements ActionListener {


    private JButton bAddQuestion, bDisplayQuestions, bGetExam, bShowCompletedExams, bShowExamStats;
    public QuestionCreator questionCreator;
    public QuestionDisplayer questionDisplayer;
    public ExamDisplayer examDisplayer;
    public CompletedExamDisplayer completedExamDisplayer;
    public ExamStatsDisplayer examStatsDisplayer;





    public MyWindow() throws IOException {
        setSize (300,300);
        setTitle("Menadżer testów");
        setLayout(null);

        bAddQuestion = new JButton("Dodaj nowe pytanie");
        bAddQuestion.setBounds(25, 75, 250, 20);
        add(bAddQuestion);
        bAddQuestion.addActionListener(this);

        bDisplayQuestions = new JButton("Zobacz bazę pytań");
        bDisplayQuestions.setBounds(25,95,250,20);
        add(bDisplayQuestions);
        bDisplayQuestions.addActionListener(this);

        bGetExam = new JButton("Wybierz test do pobrania lub oceny");
        bGetExam.setBounds(25,115,250,20);
        add(bGetExam);
        bGetExam.addActionListener(this);

        bShowCompletedExams = new JButton("Pokaż ocenione testy");
        bShowCompletedExams.setBounds(25,135,250,20);
        add(bShowCompletedExams);
        bShowCompletedExams.addActionListener(this);

        bShowExamStats = new JButton("Pokaż statystyki testów");
        bShowExamStats.setBounds(25,155,250,20);
        add(bShowExamStats);
        bShowExamStats.addActionListener(this);


    }
    public static void main(String[] args) throws IOException {
        MyWindow mW = new MyWindow();
        mW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mW.setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventSource = e.getSource();
        if(eventSource == bAddQuestion)
        {
            if(questionCreator==null)
            {questionCreator = new QuestionCreator(this); }
            questionCreator.setVisible(true);
            // questionCreator.setFocus();
        }
        if(eventSource == bDisplayQuestions)
        {
            try {
                questionDisplayer = new QuestionDisplayer(this);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            questionDisplayer.setVisible(true);
        }
        if(eventSource==bGetExam)
        {
                try {
                    examDisplayer = new ExamDisplayer(this);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                examDisplayer.setVisible(true);

        }

        if(eventSource==bShowCompletedExams)
        {
            try {
                completedExamDisplayer = new CompletedExamDisplayer(this);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            completedExamDisplayer.setVisible(true);
        }

        if(eventSource==bShowExamStats) {
            try {
                examStatsDisplayer = new ExamStatsDisplayer(this);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            examStatsDisplayer.setVisible(true);
        }


    }
}
