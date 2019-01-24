package com.company;

import java.io.Serializable;
import java.util.List;

public class Exam implements Serializable {
    private String examName;
    private List<QuizQuestion> quizQuestionList;
    private String studentName;
    private double overallREsult;

    public String getStudentName() {
        return studentName;
    }

    public Exam(String examName, List<QuizQuestion> quizQuestionList) {
        this.examName = examName;
        this.quizQuestionList = quizQuestionList;
    }

    public double getOverallREsult() {
        return overallREsult;
    }

    public String getExamName() {
        return examName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<QuizQuestion> getQuizQuestionList() {
        return quizQuestionList;
    }

    public String toStringWritingVersion()
    {
        String s = this.examName + '\n';
        s=s+"Nazwisko i imię: " + '\n' +'\n';
        for(int i=0; i<this.quizQuestionList.size();i++)
        {
            QuizQuestion q = quizQuestionList.get(i);
            s=s+q.toStringWritingVersion() + '\n';
        }


        return s;
    }

    @Override
    public String toString() {
        return "Nazwa egazminu: " + examName + '\n' +
                "Nazwisko i imię ucznia: " + studentName + '\n' +
                "Wynik: " + overallREsult + "%";
    }

    public void setOverallREsult(double overallREsult) {
        this.overallREsult = overallREsult;
    }
}
