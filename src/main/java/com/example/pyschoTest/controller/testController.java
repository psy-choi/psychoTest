package com.example.pyschoTest.controller;

import com.example.pyschoTest.dto.ResponseDto;
import com.example.pyschoTest.service.petLossService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class testController {

    private final petLossService petLossService;

    @GetMapping("/petLoss")
    public ResponseEntity check(@RequestBody List<Integer> responses, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            return new ResponseEntity<>(new ResponseDto<>(-1, "유효성 검사 실패", errorMap), HttpStatus.BAD_REQUEST);
        }

        String result = petLossService.checkingState(responses);

        return new ResponseEntity(new ResponseDto<>(1, "당신은" + result + "입니다.", result), HttpStatus.ACCEPTED);
    }


}
