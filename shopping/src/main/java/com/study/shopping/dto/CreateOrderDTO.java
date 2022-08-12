package com.study.shopping.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderDTO {

    private Long memberId;
    private Long itemId;
    private int count;
}
