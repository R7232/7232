package com.example.r7232.a7232;


public class UserAnswers  {

    private int[] answers ;


    public UserAnswers(int questionCount) {
        answers = new int[questionCount] ;
    }

    public int getAnswers(int index) {
        return answers[index];
    }

    public void setAnswers(int index, int answer) {
        answers[index] = answer ;
    }
}
