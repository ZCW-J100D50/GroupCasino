package com.github.zipcodewilmington.GameTests.TriviaTests;

import com.github.zipcodewilmington.casino.games.Trivia.Quiz;
import org.junit.Assert;
import org.junit.Test;

public class QuizTest {

    @Test
    public void getScore() {
        Quiz quiz = new Quiz();
        int expectedScore = 3;

        quiz.setScore(3);
        int actualScore = quiz.getScore();

        Assert.assertEquals(expectedScore,actualScore);

    }

    @Test
    public void setScore() {
    }
}
