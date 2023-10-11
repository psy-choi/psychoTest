package com.example.pyschoTest.test;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class petLossDepressTest implements pyschoTest{


    @Override
    public Integer countQuestions() {
        return 16;
    }

    @Override
    public Integer diagnoseTotalScore(List<?> responses) {
        Integer totalScore = responses.stream()
                .mapToInt(response -> {
                    if ((int)response <= 0 && 5 <= (int)response) {return 2;}
                    return (int) response;
                })
                .sum();

        return totalScore;
    }

    @Override
    public String diagnoseResult(List<?> responses) {
        Integer totalScore = diagnoseTotalScore(responses) - 16;
        if (totalScore > 36.6) {
            return diagnosis.NORMAL.toString();
        } else {
            return diagnosis.PETLOSS.toString();
        }
    }


    public enum diagnosis{
        NORMAL,
        PETLOSS
    }
}
