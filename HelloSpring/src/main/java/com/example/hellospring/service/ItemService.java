package com.example.hellospring.service;

import com.example.hellospring.domain.Item;
import com.example.hellospring.dto.ItemDto;
import com.example.hellospring.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ItemService {

    private final ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveItem(ItemDto itemDto){
        Item item = Item.builder()
                .name(itemDto.getName())
                .count(itemDto.getCount())
                .build();
        itemRepository.save(item);
    }

//    public void saveItem(ItemDto itemDto){
//        Item item = new Item();
//        item.setName(itemDto.getName());
//        item.setId(itemDto,getId());
//
//        itemRepository.save(item);
//    }

    public ItemDto findItemById(Long id){
        Item item = itemRepository.findById(id);
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .count(item.getCount())
                .build();
    }

    public List<ItemDto> findAllItem() {
        return itemRepository.findALL()
                .stream()
                .map(item -> ItemDto.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .count(item.getCount())
                        .build())
                .toList(); // itemRepository를 통해 모든 item을 찾아서 반환
    }

    public void updateItemById(Long id, ItemDto itemDto) {
        Item findItem = itemRepository.findById(id); // itemRepository를 통해 id에 해당하는 item을 찾아서 반환
        findItem.updateItem(itemDto.getName(), itemDto.getCount()); // item의 내용을 수정

        itemRepository.updateById(id, findItem); // itemRepository를 통해 id에 해당하는 item을 찾아서 내용을 수정
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id); // itemRepository를 통해 id에 해당하는 item을 찾아서 삭제
    }
//    public ItemDto findItemById(Long id){
//        Item item = itemRepository.findById(id);
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId(item.getId()); //get from item and send to itemDTO
//        itemDto.setName(item.getName());
//        itemDto.setCount(item.getCount());
//        return itemDto;
//    }

//    public List<ItemDto> findAllItem(){
//        return itemRepository.findALL().stream().map(item -> {
//            ItemDto itemDto = new ItemDto();
//            itemDto.setId(item.getId());
//            itemDto.setName(item.getName());
//            itemDto.setCount(item.getCound());
//            return itemDto;
//        }).toList();
//    }
//
//    public void updateItemById(Long id, ItemDto itemDto){
//        Item findItem = itemRepository.findById(id);
//        findItem.setName(itemDto.getName());
//        findItem.setCount(itemDto.getCount());
//        itemRepository.updateById(id, findItem);
//    }
//
//    public void deleteItemById(Long id){
//        itemRepository.deleteById(id);
//    }
}
