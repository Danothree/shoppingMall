package com.study.shopping.domain.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("P")
public class Phone extends Item {

    private String kind;
    private String number;

}
