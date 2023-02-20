package com.company.attacks;

import com.company.Pokemon;

public interface Attack {
    boolean acceptBattle(String attack);
    int attack(Pokemon pokemon1,String attack1,Pokemon pokemon2,String attack2);
}
