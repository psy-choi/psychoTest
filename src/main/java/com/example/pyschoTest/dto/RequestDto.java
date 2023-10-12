package com.example.pyschoTest.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class RequestDto {

    @Getter
    @RequiredArgsConstructor
    public class petLossRequestDto {
        @NotEmpty
        private String name;

        @NotEmpty
        private List<Integer> responses;


    }
}
