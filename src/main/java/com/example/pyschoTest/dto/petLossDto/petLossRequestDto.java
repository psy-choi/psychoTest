package com.example.pyschoTest.dto.petLossDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class petLossRequestDto {

    @NotNull
    private String name;

    @NotNull
    private List<Integer> responses;
}
