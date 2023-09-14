package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="items")
@Data
@NoArgsConstructor
public class Item {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String itemName;
    private String code;

    @ManyToMany(mappedBy = "items")//field name
    private List<Cart> cart;

    public Item(String itemName, String code) {
        this.itemName = itemName;
        this.code = code;
    }
}
