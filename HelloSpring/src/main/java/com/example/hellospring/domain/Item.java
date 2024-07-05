package com.example.hellospring.domain;

import lombok.Builder;
import lombok.Getter;
//import lombok.Setter;

@Getter
//@Setter // getter, setter 메소드 자동으로 생성\

public class Item {
    private Long id; // 물건의 고유 id
    private String name; // 물건의 이름
    private Long count; // 물건의 개수(재고)

    @Builder
    public Item(String name, Long count){
        this.name = name;
        this.count = count;
    }

    public void initId(Long id){
        this.id = id;
    }

    public void updateItem(String name, Long count){
        this.name = name;
        this.count = count;
    }
}
