package com.example.hellospring.dto;

import lombok.Data;
import lombok.Builder;

@Data

public class ItemDto {
    private Long id;
    private String name;
    private Long count;

    @Builder
    public ItemDto(Long id, String name, Long count){
        this.id = id;
        this.name = name;
        this.count = count;
    }
}

// ItemDto 클래스는 dto 클래스에요.
// 데이터를 주고 받을 때 사용해요.
