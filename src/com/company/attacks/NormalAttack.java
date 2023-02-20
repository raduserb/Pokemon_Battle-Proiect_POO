package com.company.attacks;

import com.company.Pokemon;

public class NormalAttack implements Attack{
    @Override
    public boolean acceptBattle(String attack) {
        return attack.equals("attack");
    }

    @Override
    public int attack(Pokemon pokemon1, String attack1, Pokemon pokemon2, String attack2) {
        if(pokemon1.isStunned()) {
            pokemon1.removeStun();
            return 0;
        }
        if(attack2.equals("ability1"))
            if(pokemon2.getAbility1().isDodge())
            {
                System.out.println(pokemon2.getName() + " dodged");
                return 0;
            }
        if(attack2.equals("ability2"))
            if(pokemon2.getAbility2().isDodge())
            {
                System.out.println(pokemon2.getName() + " dodged");
                return 0;
            }
        if(pokemon1.getAttack() > pokemon2.getDefense())
            return pokemon1.getAttack() - pokemon2.getDefense();

        return 0;
    }
}
