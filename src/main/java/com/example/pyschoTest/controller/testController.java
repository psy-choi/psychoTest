package com.example.pyschoTest.controller;

import com.example.pyschoTest.dto.ResponseDto;
import com.example.pyschoTest.dto.petLossDto.petLossRequestDto;
import com.example.pyschoTest.dto.beckDepressDto.beckDepressRequestDto;
import com.example.pyschoTest.service.testService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class testController {

    private final testService testService;

    @GetMapping("/petloss")
    public ResponseEntity checkingTestResult(@Valid @RequestBody petLossRequestDto petLossRequestDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            return new ResponseEntity<>(new ResponseDto<>(-1, "유효성 검사 실패", errorMap), HttpStatus.BAD_REQUEST);
        }

        String result = testService.checkingState(petLossRequestDto.getResponses(), "petloss");

        return new ResponseEntity(new ResponseDto<>(1, "당신의 결과는 다음과 같습니다.", result), HttpStatus.ACCEPTED);
    }

    @GetMapping("/beckdepress")
    public ResponseEntity checkingTestResult(@Valid @RequestBody beckDepressRequestDto beckDepressRequestDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            return new ResponseEntity<>(new ResponseDto<>(-1, "유효성 검사 실패", errorMap), HttpStatus.BAD_REQUEST);
        }

        String result = testService.checkingState(beckDepressRequestDto.getResponses(), "beckDepress");

        return new ResponseEntity(new ResponseDto<>(1, "당신의 결과는 다음과 같습니다.", result), HttpStatus.ACCEPTED);
    }


}
