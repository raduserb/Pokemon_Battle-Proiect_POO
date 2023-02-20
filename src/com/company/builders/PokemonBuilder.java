package com.company.builders;
import com.company.Ability;
import com.company.Item;
import com.company.Pokemon;

import java.util.ArrayList;

public class PokemonBuilder {
    private final Pokemon pokemon;

    public PokemonBuilder(String name){
        this.pokemon = new Pokemon();
        pokemon.setName(name);
    }

    public void buildHP(int HP){
        pokemon.setHP(HP);
        pokemon.setMaxHP(HP);
    }

    public void buildAttack(int attack){
        pokemon.setAttack(attack);
    }

    public void buildSpecialAttack(int SA){
        pokemon.setSpecialAttack(SA);
    }

    public void buildDefense(int defense){
        pokemon.setDefense(defense);
    }

    public void buildSpecialDefense(int SD){
        pokemon.setSpecialDefense(SD);
    }

    public void buildAbility1(Ability ability1) {
        pokemon.setAbility1(ability1);
    }

    public void buildAbility2(Ability ability2){
        pokemon.setAbility2(ability2);
    }

    public void buildItems(ArrayList<Item> items){
        pokemon.setItems(items);
    }

    public Pokemon build(){
        return pokemon;
    }

}
