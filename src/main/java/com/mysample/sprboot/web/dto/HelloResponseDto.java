package com.mysample.sprboot.web.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;

    /*
    public HelloResponseDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
    */
}
