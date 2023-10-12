package com.example.pyschoTest.test;

import com.example.pyschoTest.exception.customException;
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
        if (responses.size() != countQuestions()) {
            throw new customException("문항 수가 알맞지 않습니다.");
        }

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
            return diagnosis.PETLOSS.toString();
        } else {
            return diagnosis.NORMAL.toString();
        }
    }


    public enum diagnosis{
        NORMAL,
        PETLOSS
    }
}
