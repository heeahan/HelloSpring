package com.example.hellospring.repository;

import com.example.hellospring.domain.Item;
import java.util.List;

public interface ItemRepository {
    void save(Item item);
    Item findById(Long id);
    List<Item> findALL();
    void updateById(Long id, Item item);
    void deleteById(Long id);

}

// Repository는 데이터베이스와 연관되어 있는 계층이다 보니 다른 데이터베이스로 변경될 가능성이 비교적 높아요.