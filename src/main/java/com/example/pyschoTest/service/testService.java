package com.example.pyschoTest.service;

import com.example.pyschoTest.test.beckDepressTest;
import com.example.pyschoTest.test.petLossDepressTest;
import com.example.pyschoTest.test.pyschoTest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class testService {

    public String checkingState(List<Integer> responses, String name){
        pyschoTest pyschoTest;
        if (name == "petLoss") {
            pyschoTest = new petLossDepressTest();
        } else if (name == "beckDepress") {
            pyschoTest = new beckDepressTest();
        } else {
            throw new NullPointerException("존재하는 검사 종류가 아닙니다.");
        }
        return pyschoTest.diagnoseResult(responses);

    }
}
