package com.example.pyschoTest.service;

import com.example.pyschoTest.test.petLossDepressTest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class petLossService {

    private final petLossDepressTest petLossDepressTest;

    public String checkingState(List<Integer> responses){

        return petLossDepressTest.diagnoseResult(responses);

    }
}
