package com.company;

import java.io.Serializable;
import java.util.List;

public class QuizQuestion implements Serializable {
    private String prompt;
    private List<String> options;
    private String answer;
    private String section;
    private int points;
    private String studentAnswer;

    ///private Category category;
    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public QuizQuestion(String prompt, List<String> options, String answer, String section, int points) {
        this.prompt = prompt;
        this.options = options;
        this.answer = answer;
        this.section = section;
        this.points = points;
    }

    /*
    public QuizQuestion(String prompt, String answer, Category category, int points) {
        this.prompt = prompt;
        this.answer = answer;
        this.category = category;
        this.points = points;
    }
    */


    /*public String toString() {
        return "QuizQuestion{" +
                prompt.toString() + '\n' +
                "Odpowiedź to " + answer + '\n' +
                "Kategoria: " + category + '\n' +
                "Liczba punktów: " + points +
                '}';
    }
    */
    public String toStringWritingVersion()
    {
        String s = this.prompt + " ("+ this.points+ " pkt)" +'\n';
        String [] letters = {"a) ","b) ","c) ","d) "};
        for(int i=0;i<options.size();i++)
        {
            s=s+letters[i]+options.get(i)+'\n';
        }
        return s;
    }
    @Override

    public String toString() {
        String optionsString = "";
        String [] letters = {"a) ","b) ","c) ","d) ", "e) ", "f) "};
        for(int i=0; i< this.options.size();i++) {
            optionsString= optionsString + letters[i] +options.get(i) + '\n';

        }


        return "Treść pytania: " + prompt + '\n' +
                "Możliwe odpowiedzi: " + '\n' + optionsString +
                "Odpowiedź: "  + answer + '\n' +
                "Kategoria: " + section + '\n' +
                "Liczba punktów: " + points ;
    }


    public int getPoints() {
        return points;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getAnswer() {
        return answer;
    }
}