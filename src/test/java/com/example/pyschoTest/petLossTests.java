package com.example.pyschoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.pyschoTest.service.petLossService;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class petLossTests {


    @Autowired
    private petLossService petLossService;

    @Test
    public void petLossServiceTest() {
        // what
        List<Integer> responses = new ArrayList<>();
        for (int i = 0; i < 16; i++){
            responses.add(4);
        }

        // do
        String result = petLossService.checkingState(responses);

        // result
        Assertions.assertNotEquals( "NORMAL", result);
        Assertions.assertEquals( "PETLOSS", result);
    }


}
