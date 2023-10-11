package com.example.pyschoTest.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseDto<T> {
    private final Integer code;
    private final String msg;
    private final T dat;
}