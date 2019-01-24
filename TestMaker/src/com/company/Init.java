/*
package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Init {


    public static void main(String[] args) throws IOException {
        // write your code here

        FileOutputStream f = new FileOutputStream(new File("myExams.bin"));
        ObjectOutputStream o = new ObjectOutputStream(f);
        List<Exam> examArrayList = new ArrayList<>();
        o.writeObject(examArrayList);
        o.close();

        FileOutputStream f1 = new FileOutputStream(new File("myCompletedExams.bin"));
        ObjectOutputStream o1 = new ObjectOutputStream(f1);
        List<Exam> completedExamArrayList = new ArrayList<>();
        o1.writeObject(completedExamArrayList);
        o1.close();


    }
}
*/

package com.company;

        import java.io.*;
        import java.util.ArrayList;
        import java.util.List;

public class Init {

    public static void main(String[] args) throws IOException {
        // write your code here
        /*
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
        String section = "Geografia";
        int points = 1;
        QuizQuestion quizQuestion = new QuizQuestion(prompt, options,answer,section,points);
        quizQuestionArrayList.add(quizQuestion);
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
        */
    }
}
