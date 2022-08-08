package com.study.shopping.service;

import com.study.shopping.domain.item.Item;
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

    @Transactional(readOnly = true)
    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    public Item findItem(Long itemId) throws Exception {
        return itemRepository.findById(itemId).orElseThrow(() -> new Exception("no item"));
    }
}
