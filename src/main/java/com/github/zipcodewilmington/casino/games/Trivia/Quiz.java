package com.github.zipcodewilmington.casino.games.Trivia;

public class Quiz {
    private int score;
    Questions questions = new Questions();

//    public static void main(String[] args) {
//        new Quiz().callQuestions();
//    }

//    public void callQuestions(){
//        for(String values : questions.questions.values()){
//            System.out.println("Question: " + values);
//        }
//    }

//    public Quiz(int score) {
//        this.score = score;
//    }





    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
