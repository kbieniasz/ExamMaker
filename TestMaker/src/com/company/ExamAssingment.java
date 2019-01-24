package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ExamAssingment extends JFrame implements ActionListener {
    public Exam exam;
    public JLabel [] tabOfJLabels;
    public JTextField [] tabOfJTextField;
    public JLabel lNameOfStudent, lExamName;
    public JTextField tNameOfStudent;
    public JButton bSaveResults;
    public JComboBox [] comboAnswers;
    public JTextArea tStudentResult;
    public JScrollPane [] scrollPanes;
    public JScrollPane scrollPane1;
    //public List<Exam> completedExamList;

    public ExamAssingment (JFrame owner)
    {
        setSize (300,300);
        setTitle("Ocenianie");
        setLayout(null);
    }

    public ExamAssingment(JFrame owner, Exam exam)
    {
        this.exam = exam;

        setSize (750,700);
        setTitle("Ocenianie");
        setLayout(null);

        lExamName = new JLabel ("Test " + exam.getExamName());
        lExamName.setBounds(10,0,300,20);
        add(lExamName);

        lNameOfStudent = new JLabel("Nazwisko i imię ucznia");
        lNameOfStudent.setBounds(10,20,170,30);
        add(lNameOfStudent);

        tNameOfStudent = new JTextField("");
        tNameOfStudent.setBounds(200,20,200,30);
        add(tNameOfStudent);

        bSaveResults = new JButton("Zapisz");
        bSaveResults.setBounds(450,20,200,50);
        add(bSaveResults);
        bSaveResults.addActionListener(this);

        tStudentResult = new JTextArea("");
        scrollPane1 = new JScrollPane(tStudentResult);
        scrollPane1.setBounds(450,150,200,200);
        add(scrollPane1);
        //tStudentResult.setBounds(450,200,200,300);
        //add(tStudentResult);




        int numberOfQuestions = exam.getQuizQuestionList().size();
        tabOfJLabels = new JLabel[numberOfQuestions];
        tabOfJTextField = new JTextField[numberOfQuestions];
        comboAnswers = new JComboBox [numberOfQuestions];
        scrollPanes = new JScrollPane[numberOfQuestions];


        for(int i = 0; i<exam.getQuizQuestionList().size();i++)
        {
            QuizQuestion q = exam.getQuizQuestionList().get(i);
            tabOfJLabels [i] = new JLabel(q.getPrompt());
            scrollPanes [i] = new JScrollPane(tabOfJLabels[i]);
            scrollPanes [i].setBounds(10,50+i*40,300,40);
            //tabOfJLabels [i].setBounds(10,50+i*30,170,30);
            //add(tabOfJLabels[i]);
            add(scrollPanes[i]);

            //tabOfJTextField [i] = new JTextField("");
            //tabOfJTextField [i].setBounds(130,50+i*30,100,30);
            //add(tabOfJTextField[i]);


            comboAnswers [i] = new JComboBox();
            comboAnswers [i].setBounds(330, 50+i*40, 70, 40);
            comboAnswers [i].addItem("a");
            comboAnswers [i].addItem("b");
            comboAnswers [i].addItem("c");
            comboAnswers [i].addItem ("d");
            comboAnswers [i].setSelectedIndex(0);
            add(comboAnswers [i]);
            comboAnswers [i].addActionListener(this);



        }
    }








    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventSource = e.getSource();
        if(eventSource == bSaveResults)
        {
            int numberOfQuestions = this.exam.getQuizQuestionList().size();
            String name = tNameOfStudent.getText();
            this.exam.setStudentName(name);
            double totalPoints=0.0;
            double studentsPoints=0.0;
            tStudentResult.setText("");

            String message ="";
            for (int iter=0;iter<numberOfQuestions;iter++)
            {
                double pointsForQuestion = 1.0*this.exam.getQuizQuestionList().get(iter).getPoints();
                totalPoints+=pointsForQuestion;
                if(this.exam.getQuizQuestionList().get(iter).getStudentAnswer().
                        equals(this.exam.getQuizQuestionList().get(iter).getAnswer()))
                {
                    studentsPoints = studentsPoints + pointsForQuestion;
                    message = "Zadanie " + (iter+1) + " poprawna odpowiedź" + '\n';
                    tStudentResult.append(message);


                }
                else
                {
                    message = "Zadanie " + (iter+1) + " niepoprawna odpowiedź" + '\n';
                    tStudentResult.append(message);
                }
            }
            double overallresult = studentsPoints/totalPoints;
            overallresult *=10000;
            overallresult = Math.round(overallresult);
            overallresult=overallresult/100;
            //Double tmpDouble =  Double.parseDouble(new DecimalFormat("###.##").format(overallresult));
            //System.out.println(tmpDouble);
            //Double tmpDouble = overallresult;

            this.exam.setOverallREsult(overallresult);
            //String message = "Uczeń " + name + '\n' +
              //      "uzyskał " + studentsPoints + "na " + totalPoints + "możliwych";
            message = "Wynik: " + studentsPoints + "/" +totalPoints +  " ( " + overallresult + "%)";

            tStudentResult.append(message);

            Exam completedExam = this.exam;

            ObjectOutputStream zapisObiektu = null;
            try {
                List<Exam> completedExamList = new ArrayList<>();
                FileInputStream f0 = new FileInputStream(new File("myCompletedExams.bin"));
                //System.out.println("Wypisdaasdsdsdsds");
                ObjectInputStream o0 = new ObjectInputStream(f0);
                completedExamList = (List<Exam>) o0.readObject();

                FileOutputStream f = new FileOutputStream(new File("myCompletedExams.bin"));
                ObjectOutputStream o = new ObjectOutputStream(f);
                completedExamList.add(completedExam);
                o.writeObject(completedExamList);
                o.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        for (int i=0; i<this.exam.getQuizQuestionList().size();i++)
        {
            if(eventSource==comboAnswers[i])
            {
                String studentAnswer = (String) comboAnswers[i].getSelectedItem();
                this.exam.getQuizQuestionList().get(i).setStudentAnswer(studentAnswer);
                //System.out.println("Przypisano " + studentAnswer);
                ///if(studentAnswer.equals("a")) this.exam.getQuizQuestionList().get(i).setStudentAnswer(studentAnswer);

            }
        }

    }
}
