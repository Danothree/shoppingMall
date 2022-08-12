package com.study.shopping.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("F")
public class Food extends Item {

    private String kind;

    public Food(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}
