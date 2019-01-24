package com.company;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        FileOutputStream f = new FileOutputStream(new File("myObjects2.bin"));
        ObjectOutputStream o = new ObjectOutputStream(f);
        List<QuizQuestion> quizQuestionArrayList = new ArrayList<>();
        String prompt = "Ile ludzi mieszka w Polsce?";
        List<String> options = new ArrayList<>();
        options.add("12 milionów");
        options.add("13 milionów");
        options.add("23 miliony");
        options.add("38 miliony");
        String answer = "d";
        String section = "Geografia ogólna";
        int points = 1;
        QuizQuestion quizQuestion = new QuizQuestion(prompt, options,answer,section,points);
        quizQuestionArrayList.add(quizQuestion);


        String prompt1 = "Jaka jest stolica Maroka?";
        List<String> options1 = new ArrayList<>();
        options1.add("Algier");
        options1.add("Rabat");
        options1.add("Kair");
        options1.add("Wagadugu");
        String answer1 = "b";
        String section1 = "Stolice państw";
        int points1 = 1;
        QuizQuestion quizQuestion1 = new QuizQuestion(prompt1, options1,answer1,section1,points1);
        quizQuestionArrayList.add(quizQuestion1);


        String prompt2 = "Jaka jest stolica Angoli?";
        List<String> options2 = new ArrayList<>();
        options2.add("Algier");
        options2.add("Rabat");
        options2.add("Luanda");
        options2.add("Wagadugu");
        String answer2 = "c";
        String section2 = "Stolice państw";
        int points2 = 1;
        QuizQuestion quizQuestion2 = new QuizQuestion(prompt2, options2,answer2,section2,points2);
        quizQuestionArrayList.add(quizQuestion2);


        String prompt3 = "Jaka jest stolica Burkina Faso?";
        List<String> options3 = new ArrayList<>();
        options3.add("Kapsztad");
        options3.add("Rangun");
        options3.add("Luanda");
        options3.add("Wagadugu");
        String answer3 = "d";
        String section3 = "Stolice państw";
        int points3 = 1;
        QuizQuestion quizQuestion3 = new QuizQuestion(prompt3, options3,answer3,section3,points3);
        quizQuestionArrayList.add(quizQuestion3);


        String prompt4 = "Jaka jest stolica Czadu?";
        List<String> options4 = new ArrayList<>();
        options4.add("Kapsztad");
        options4.add("Rangun");
        options4.add("Ndżamea");
        options4.add("Wagadugu");
        String answer4 = "c";
        String section4 = "Stolice państw";
        int points4 = 1;
        QuizQuestion quizQuestion4 = new QuizQuestion(prompt4, options4,answer4,section4,points4);
        quizQuestionArrayList.add(quizQuestion4);


        String prompt5 = "Jaka jest stolica Libii?";
        List<String> options5 = new ArrayList<>();
        options5.add("Benghazi");
        options5.add("Trypolis");
        options5.add("Timbuktu");
        options5.add("Bużumbura");
        String answer5 = "b";
        String section5 = "Stolice państw";
        int points5 = 1;
        QuizQuestion quizQuestion5 = new QuizQuestion(prompt5, options5,answer5,section5,points5);
        quizQuestionArrayList.add(quizQuestion5);

        o.writeObject(quizQuestionArrayList);
        o.close();




        FileOutputStream f2 = new FileOutputStream(new File("myExams.bin"));
        ObjectOutputStream o2 = new ObjectOutputStream(f2);
        List<Exam> examArrayList = new ArrayList<>();
        o2.writeObject(examArrayList);
        o2.close();

        FileOutputStream f1 = new FileOutputStream(new File("myCompletedExams.bin"));
        ObjectOutputStream o1 = new ObjectOutputStream(f1);
        List<Exam> completedExamArrayList = new ArrayList<>();
        o1.writeObject(completedExamArrayList);
        o1.close();


        MyWindow mW = new MyWindow();
        mW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mW.setVisible(true);
    }
}
