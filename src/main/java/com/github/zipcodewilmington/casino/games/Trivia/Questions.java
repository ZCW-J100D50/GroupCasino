package com.github.zipcodewilmington.casino.games.Trivia;

import java.util.HashMap;
import java.util.Map;

public class Questions {
//    private String answer1 = "Honey";
//    private String answer2 = "Antarctica";
//    private String answer3 = "Java";
//    private String answer4 = "Gangstagrass";
//    private String answer5 = "Earth";

    String[] answerArray = {"Honey", "Antarctica", "Java", "Gangstagrass", "Earth" };
    HashMap<Integer, String> questions = new HashMap<Integer, String>();

    public Questions() {
    }

    public void addQuestions() {
        questions.put(1,"What food never spoils? ");
        questions.put(2,"What is the largest desert in the world? ");
        questions.put(3,"What computer language is 10.0 learning? ");
        questions.put(4,"What band does Dolio play in? ");
        questions.put(5,"What planet is called the blue planet? ");

//        HashMap questionValues = (HashMap) questions.values();
//        for(HashMap qv = questionValues()){
//            System.out.println(qv);
//        }
    }

//    public String getAllQuestions() {
//
////        for(Map.Entry<Integer, String> entry : questions.entrySet()){
////            String entryValue =
////            Integer key = entry.getKey();
////            String value = entry.getValue();
////        }
//        return null;
//    }

    public String getQuestions() {
        return questions.get(1);
    }


}
