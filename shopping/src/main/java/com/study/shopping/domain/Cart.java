package com.study.shopping.domain;

import com.study.shopping.domain.Member;
import com.study.shopping.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Cart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
    private Member member;

    @OneToMany
    @JoinColumn(name = "item_id")
    private List<Item> items = new ArrayList<>();

    public void setMember(Member member) {
        this.member = member;
    }

    public void addItems(Item item) {
        items.add(item);
    }
}
