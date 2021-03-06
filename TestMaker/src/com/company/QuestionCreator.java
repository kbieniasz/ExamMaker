package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QuestionCreator extends JFrame implements ActionListener {

    private JLabel lTresc, lAOption, lBOtion, lCOption, lDOption, lCorrectAnswer, lCategory, lPoints;
    public JTextArea tATresc, tAAOption, tABOption, tACOption, tADOption, tACorrectAnswer, tACategory, tAPoints;
    public JButton jAddQuestionConfirm;
    public JComboBox categoryCombo;
    public JComboBox answerCombo;
    public String corectAnswerFromComboBox;
    public JScrollPane scrollPane1;
    //Category cat;
    public WarningMessage warningMessage;



    public QuestionCreator (JFrame owner)
    {
        setSize(400,700);
        setTitle("Nowe pytanie");
        setLayout(null);

        lTresc = new JLabel("Treść pytania");
        lTresc.setBounds(20,20, 120,20);
        add(lTresc);

        tATresc = new JTextArea("");
        scrollPane1 = new JScrollPane(tATresc);

        scrollPane1.setBounds(150, 20, 200,50);
        add(scrollPane1);

        lAOption = new JLabel("Odpowiedź A");
        lAOption.setBounds(20,80, 120,20);
        add(lAOption);

        tAAOption = new JTextArea("");
        tAAOption.setBounds(150, 80, 200,30);
        add(tAAOption);

        lBOtion = new JLabel("Odpowiedź B");
        lBOtion.setBounds(20,130, 120,20);
        add(lBOtion);

        tABOption = new JTextArea("");
        tABOption.setBounds(150, 130, 200,30);
        add(tABOption);

        lCOption = new JLabel("Odpowiedź C");
        lCOption.setBounds(20,180, 120,20);
        add(lCOption);

        tACOption = new JTextArea("");
        tACOption.setBounds(150, 180, 200,30);
        add(tACOption);

        lDOption = new JLabel("Odpowiedź D");
        lDOption.setBounds(20,230, 120,20);
        add(lDOption);

        tADOption = new JTextArea("");
        tADOption.setBounds(150, 230, 200,30);
        add(tADOption);

        lCorrectAnswer = new JLabel("Poprawna odpowiedź");
        lCorrectAnswer.setBounds(20,280, 120,20);
        add(lCorrectAnswer);

        //tACorrectAnswer = new JTextArea("");
        //tACorrectAnswer.setBounds(150, 280, 200,30);
        //add(tACorrectAnswer);

        answerCombo =  new JComboBox();
        answerCombo.setBounds(150, 280, 200,30);
        answerCombo.addItem("a");
        answerCombo.addItem("b");
        answerCombo.addItem("c");
        answerCombo.addItem("d");
        add(answerCombo);
        answerCombo.addActionListener(this);
        answerCombo.setSelectedIndex(1);


        lCategory = new JLabel("Kategoria");
        lCategory.setBounds(20,330, 120,20);
        add(lCategory);

        tACategory = new JTextArea("");
        tACategory.setBounds(150, 330, 200,30);
        add(tACategory);


        lPoints = new JLabel("Liczba punktów");
        lPoints.setBounds(20,380, 120,20);
        add(lPoints);


        tAPoints = new JTextArea("");
        tAPoints.setBounds(150, 380, 200,30);
        add(tAPoints);

        jAddQuestionConfirm = new JButton("Dodaj");
        jAddQuestionConfirm.setBounds(100,450, 75, 75);
        jAddQuestionConfirm.addActionListener(this);
        add(jAddQuestionConfirm);


        /*
        categoryCombo = new JComboBox();
        categoryCombo.setBounds(100, 550, 100, 100);
        categoryCombo.addItem("GEOGRAPHY");
        categoryCombo.addItem("UNIX");
        categoryCombo.addItem("OTHER");
        add(categoryCombo);
        categoryCombo.addActionListener(this);
        */
        tATresc.setText("");
        tAPoints.setText("");
        tAAOption.setText("");
        tABOption.setText("");
        tACOption.setText("");
        tADOption.setText("");
        tACategory.setText("");

    }





    @Override
    public void actionPerformed(ActionEvent e) {

        Object eventSource = e.getSource();
        if(eventSource == jAddQuestionConfirm)
        {
           String probablyNumber = tAPoints.getText();
           boolean probablyNumberbool = true;
           for(int i=0;i<probablyNumber.length();i++)
           {
               Character c = probablyNumber.charAt(i);
               if(!Character.isDigit(c)) probablyNumberbool = false;

           }

            String prompt = tATresc.getText();
            String a = tAAOption.getText();
            String b = tABOption.getText();
            String c = tACOption.getText();
            String d = tADOption.getText();
            String section = tACategory.getText();

            if(prompt.equals("")||(!probablyNumberbool)||a.equals("")
                    ||b.equals("")||c.equals("")||d.equals("")||section.equals(""))
            {
                warningMessage = new WarningMessage(this);
                warningMessage.setVisible(true);
                //System.out.println("hybhyby");

            }
            else {
                //String prompt = tATresc.getText();
                //String a = tAAOption.getText();
                //String b = tABOption.getText();
                //String c = tACOption.getText();
                //String d = tADOption.getText();
                List<String> options = new ArrayList<>();
                options.add(a);
                options.add(b);
                options.add(c);
                options.add(d);
                //String answer = tACorrectAnswer.getText();
                String answer = corectAnswerFromComboBox;
                int points = Integer.parseInt(tAPoints.getText());
                //String section = tACategory.getText();

                //if (cat == null) cat = Category.GEOGRAPHY;
                //cat = Enum.valueOf(Category.class, tACategory.getText());
                QuizQuestion quizQuestion =
                        new QuizQuestion(prompt, options, answer, section, points);

                PrintWriter zapis = null;
                try {
                    FileWriter file = new FileWriter("ala.txt", true);
                    BufferedWriter out = new BufferedWriter(file);
                    //zapis = new PrintWriter("ala.txt");
                    out.write(quizQuestion.toString());
                    out.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }


                ObjectOutputStream zapisObiektu = null;
                try {
                    List<QuizQuestion> quizQuestionArrayList = new ArrayList<>();
                    FileInputStream f0 = new FileInputStream(new File("myObjects2.bin"));
                    //System.out.println("Wypisdaasd");
                    ObjectInputStream o0 = new ObjectInputStream(f0);
                    quizQuestionArrayList = (List<QuizQuestion>) o0.readObject();

                    FileOutputStream f = new FileOutputStream(new File("myObjects2.bin"));
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    quizQuestionArrayList.add(quizQuestion);
                    o.writeObject(quizQuestionArrayList);
                    o.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }

                dispose();
            }
        }

        if(eventSource == answerCombo)
        {
            corectAnswerFromComboBox = (String) answerCombo.getSelectedItem();
        }

    }
}
