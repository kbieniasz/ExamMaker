package com.company;

public class ExamStats {
    private String examName;
    private int numberOfAttempts;
    private double average;

    public ExamStats(String examName, int numberOfAttempts, double average) {
        this.examName = examName;
        this.numberOfAttempts = numberOfAttempts;
        this.average = average;
    }

    @Override
    public String toString() {
        return "Nazwa testu:" + examName + '\n' +
                "Liczba podejść: " + numberOfAttempts + '\n'+
                "Średnia: " + average;
    }

    public String getExamName() {
        return examName;
    }
}
