package com.company.builders;

import com.company.Item;

public class ItemBuilder {
    private final Item item;

    public ItemBuilder(){
        this.item= new Item();
    }

    public void buildHP(int HP){
        item.setHP(HP);
    }

    public void buildName(String name){
        item.setName(name);
    }

    public void buildAttack(int attack){
        item.setAttack(attack);
    }

    public void buildSpecialAttack(int SA){
        item.setSpecialAttack(SA);
    }

    public void buildDefense(int defense){
        item.setDefense(defense);
    }

    public void buildSpecialDefense(int SD){
        item.setSpecialDefense(SD);
    }

    public Item build(){
        return item;
    }
}
