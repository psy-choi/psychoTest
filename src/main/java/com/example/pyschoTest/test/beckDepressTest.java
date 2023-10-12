package com.example.pyschoTest.test;

import com.example.pyschoTest.exception.customException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class beckDepressTest implements pyschoTest{
    @Override
    public String diagnoseResult(List<?> responses) {
        Integer totalScore = diagnoseTotalScore(responses) - 16;

        if (totalScore >= 24) {
            return diagnosis.HARDDEPRESS.toString();
        } else if (totalScore >= 16 ){
            return diagnosis.MIDDLEDEPRESS.toString();
        } else if (totalScore >= 10 ) {
            return diagnosis.MILDDEPRESS.toString();
        } else {
            return diagnosis.NOTDEPRESS.toString();
        }

    }


    @Override
    public Integer diagnoseTotalScore(List<?> responses) {
        if (responses.size() != countQuestions()) {
            throw new customException("문항 수가 알맞지 않습니다.");
        }

        Integer totalScore = responses.stream()
                .mapToInt(response -> {
                    if ((int)response < 0 && 4 <= (int)response) {return 1;}
                    return (int) response;
                })
                .sum();

        return totalScore;
    }

    @Override
    public Integer countQuestions() {
        return 21;
    }


    public enum diagnosis{
        NOTDEPRESS,
        MILDDEPRESS,
        MIDDLEDEPRESS,
        HARDDEPRESS
    }
}
