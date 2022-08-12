package com.study.shopping.service;

import com.study.shopping.domain.item.Item;
import com.study.shopping.domain.item.ItemStatus;
import com.study.shopping.dto.ItemDTO;
import com.study.shopping.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public Long saveItem(Item item) {
        Item saveItem = itemRepository.save(item);
        return saveItem.getId();
    }

    public void updateItem(Long itemId, String name, int price, int stockQuantity, ItemStatus status) throws Exception {
        Item findItem = itemRepository.findById(itemId).orElseThrow(() -> new Exception("no item"));
        findItem.updateItem(name, price, stockQuantity, status);
    }

    @Transactional(readOnly = true)
    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    public Item findItem(Long itemId) throws Exception {
        return itemRepository.findById(itemId).orElseThrow(() -> new Exception("no item"));
    }
}
