package com.study.shopping.domain;

import com.study.shopping.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CategoryItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
