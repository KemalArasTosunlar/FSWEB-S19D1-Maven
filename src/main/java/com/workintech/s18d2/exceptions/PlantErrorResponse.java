package com.workintech.s18d2.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlantErrorResponse {

    private  Integer status;
    private String message;
    private Long timestamp;

    public PlantErrorResponse(String message) {
        this.message = message;
    }
}