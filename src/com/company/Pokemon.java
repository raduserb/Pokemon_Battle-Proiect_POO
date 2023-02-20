package com.company;

import java.util.ArrayList;

public class Pokemon {
    String name = null;
    int HP = 0;
    int MaxHP = 0;
    int attack = 0;
    int specialAttack = 0;
    int defense = 0;
    int specialDefense = 0;
    Ability ability1 = null;
    Ability ability2 = null;
    ArrayList<Item> items = new ArrayList<>();
    boolean stunned = false;
    int cooldown = 0;

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void buff(){
        MaxHP++;
        HP = MaxHP;
        if(attack!=0)
            attack++;
        else
            specialAttack++;
        defense++;
        specialDefense++;
    }

    public void decreaseCooldown(int nr) {
        this.cooldown -= nr;
    }

    public boolean isStunned(){
        return stunned;
    }

    public void stunPokemon(){
        stunned = true;
    }

    public void removeStun(){
        stunned = false;
    }

    public void showStats(){
        System.out.println(name);
        System.out.println("HP: " + HP);
        System.out.println("Attack: " + attack);
        System.out.println("Special attack: " + specialAttack);
        System.out.println("Defense: " + defense);
        System.out.println("Special defense: " + specialDefense);
    }

    public void showItems(){
        System.out.println(name + "'s items: ");
        System.out.println(items.get(0).getName() + " " + items.get(1).getName() + " " + items.get(2).getName());
    }


    //getters and setters

    public int getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public Ability getAbility1() {
        return ability1;
    }

    public void setAbility1(Ability ability1) {
        this.ability1 = ability1;
    }

    public Ability getAbility2() {
        return ability2;
    }

    public void setAbility2(Ability ability2) {
        this.ability2 = ability2;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

}
