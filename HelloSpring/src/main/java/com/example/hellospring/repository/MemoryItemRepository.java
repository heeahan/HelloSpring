package com.example.hellospring.repository;

import com.example.hellospring.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Repository

public class MemoryItemRepository implements ItemRepository{
    private static Map<Long, Item> store = new HashMap<>();
    private static Long sequence = 0L;


    @Override
    public void save(Item item) {
        item.initId(++sequence);
        store.put(item.getId(), item);
        // generate id, then put id+item(key+value) into the hashmap
    }

    @Override
    public Item findById(Long id) {
        return store.get(id);
        // From store a.k.a hashmap, find item(value) by id(key)
    }

    @Override
    public List<Item> findALL() {
        return store.values().stream().toList();
        // store hashmap all values output as a list
    }

    @Override
    public void updateById(Long id, Item item) {
        store.put(id, item);
        // update by key
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
        // use id to find and delete
    }
}
