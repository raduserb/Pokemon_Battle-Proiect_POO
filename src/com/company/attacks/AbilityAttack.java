package com.company.attacks;

import com.company.Pokemon;

public class AbilityAttack implements Attack{

    @Override
    public boolean acceptBattle(String attack) {
        return attack.equals("ability1") || attack.equals("ability2");
    }

    @Override
    public int attack(Pokemon pokemon1, String attack1, Pokemon pokemon2, String attack2) {
        if(pokemon1.isStunned()) {
            pokemon1.removeStun();
            return 0;
        }
        if(attack2.equals("ability1"))
        {
            pokemon2.setCooldown(pokemon2.getAbility1().getCooldown());
            if(pokemon2.getAbility1().isDodge())
            {
                System.out.println(pokemon2.getName() + " dodged" );
                return 0;
            }
        }
        if(attack2.equals("ability2"))
        {
            pokemon2.setCooldown(pokemon2.getAbility2().getCooldown());
            if(pokemon2.getAbility2().isDodge())
            {
                System.out.println(pokemon2.getName() + " dodged" );
                return 0;
            }
        }
        if(attack1.equals("ability1"))
        {
            pokemon1.setCooldown(pokemon1.getAbility1().getCooldown());
            if(pokemon1.getAbility1().isStun())
            {
                System.out.println(pokemon2.getName() + " got stunned");
                pokemon2.stunPokemon();
            }
            return pokemon1.getAbility1().getDamage();
        }
        if(attack1.equals("ability2"))
        {
            pokemon1.setCooldown(pokemon1.getAbility2().getCooldown());
            if(pokemon1.getAbility1().isStun())
            {
                System.out.println(pokemon2.getName() + " got stunned");
                pokemon2.stunPokemon();
            }
            return pokemon1.getAbility2().getDamage();
        }

        return 0;
    }
}
