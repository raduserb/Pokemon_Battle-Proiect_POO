package com.company.builders;

import com.company.Ability;

public class AbilityBuilder {
    private final Ability ability;

    public AbilityBuilder(){
        this.ability= new Ability();
    }

    public void buildDamage(int damage){
        ability.setDamage(damage);
    }

    public void buildDodge(boolean dodge){
        ability.setDodge(dodge);
    }

    public void buildStun(boolean stun){
        ability.setStun(stun);
    }

    public void buildCooldown(int cooldown){
        ability.setCooldown(cooldown);
    }

    public Ability build(){
        return ability;
    }
}
