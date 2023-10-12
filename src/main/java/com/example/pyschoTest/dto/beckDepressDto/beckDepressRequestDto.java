package com.example.pyschoTest.dto.beckDepressDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class beckDepressRequestDto{

    @NotNull
    private String name;

    @NotNull
    private List<Integer> responses;

    @NotNull
    private Boolean isDiet;
}
