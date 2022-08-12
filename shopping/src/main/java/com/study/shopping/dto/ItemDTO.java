package com.study.shopping.dto;

import com.study.shopping.domain.item.ItemStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class ItemDTO {
    private String name;
    private int price;
    private int stockQuantity;
    private ItemStatus status;

}
