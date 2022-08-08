package com.study.shopping.domain.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("F")
public class Food extends Item {

    private String kind;
}
