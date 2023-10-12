package com.example.pyschoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.pyschoTest.service.testService;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class petLossTests {


    @Autowired
    private testService testService;

    @Test
    public void petLossServiceTest() {
        // what
        List<Integer> responses = new ArrayList<>();
        for (int i = 0; i < 16; i++){
            responses.add(4);
        }

        // do
        String result = testService.checkingState(responses, "petLoss");

        // result
        Assertions.assertNotEquals( "NORMAL", result);
        Assertions.assertEquals( "PETLOSS", result);
    }

    @Test
    public void beckDepressServiceTest() {
        // what
        List<Integer> responses = new ArrayList<>();
        for (int i = 0; i < 21; i++){
            responses.add(4);
        }

        // do
        String result = testService.checkingState(responses, "beckDepress");

        // result
        Assertions.assertNotEquals( "NOTDEPRESS", result);
        Assertions.assertEquals( "HARDDEPRESS", result);
    }


}
