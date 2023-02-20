package com.company;
import java.util.Random;

import com.company.attacks.AbilityAttack;
import com.company.attacks.Attack;
import com.company.attacks.NormalAttack;
import com.company.attacks.SpecialAttack;
import com.company.factories.PokemonFactory;

public class Arena extends Thread{
    Trainer trainer1;
    Trainer trainer2;

    Random random1 = new Random();
    Random random2 = new Random();
    int rand1 = random1.nextInt(3);
    int rand2 = random2.nextInt(3);

    public Pokemon[] init(){
        Pokemon neutrel1 = PokemonFactory.createPokemon("Neutrel1","","","");
        Pokemon neutrel2 = PokemonFactory.createPokemon("Neutrel2","","","");
        Pokemon pokemon1 = trainer1.getPokemons().get(rand1);
        Pokemon pokemon2 = trainer2.getPokemons().get(rand2);
        Pokemon[] pokemons = new Pokemon[5];
        pokemons[0] = neutrel1;
        pokemons[1] = neutrel2;
        pokemons[2] = pokemon1;
        pokemons[3] = pokemon2;
        return pokemons;
    }


    public Arena(Trainer trainer1, Trainer trainer2) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
    }

    public void applyItems(Pokemon pokemon){
        if(pokemon.getAttack() > 0)
        {
            pokemon.setAttack(pokemon.getAttack() + pokemon.getItems().get(0).getAttack());
            pokemon.setAttack(pokemon.getAttack() + pokemon.getItems().get(1).getAttack());
            pokemon.setAttack(pokemon.getAttack() + pokemon.getItems().get(2).getAttack());
        }

        pokemon.setMaxHP(pokemon.getMaxHP() +  pokemon.getItems().get(0).getHP());
        pokemon.setMaxHP(pokemon.getMaxHP() +  pokemon.getItems().get(1).getHP());
        pokemon.setMaxHP(pokemon.getMaxHP() +  pokemon.getItems().get(2).getHP());

        pokemon.setHP(pokemon.getHP() +  pokemon.getItems().get(0).getHP());
        pokemon.setHP(pokemon.getHP() +  pokemon.getItems().get(1).getHP());
        pokemon.setHP(pokemon.getHP() +  pokemon.getItems().get(2).getHP());

        pokemon.setDefense(pokemon.getDefense() +  pokemon.getItems().get(0).getDefense());
        pokemon.setDefense(pokemon.getDefense() +  pokemon.getItems().get(1).getDefense());
        pokemon.setDefense(pokemon.getDefense() +  pokemon.getItems().get(2).getDefense());

        pokemon.setSpecialDefense(pokemon.getSpecialDefense() + pokemon.getItems().get(0).getSpecialDefense());
        pokemon.setSpecialDefense(pokemon.getSpecialDefense() + pokemon.getItems().get(1).getSpecialDefense());
        pokemon.setSpecialDefense(pokemon.getSpecialDefense() + pokemon.getItems().get(2).getSpecialDefense());

        if(pokemon.getSpecialAttack() > 0)
        {
            pokemon.setSpecialAttack(pokemon.getSpecialAttack() + pokemon.getItems().get(0).getSpecialAttack());
            pokemon.setSpecialAttack(pokemon.getSpecialAttack() + pokemon.getItems().get(1).getSpecialAttack());
            pokemon.setSpecialAttack(pokemon.getSpecialAttack() + pokemon.getItems().get(2).getSpecialAttack());
        }
    }

    public Attack findTypeOfAttack(String attackName){
        Attack[] attackType = { new NormalAttack(), new AbilityAttack(),new SpecialAttack() };
        for (Attack attack : attackType) {
            if (attack.acceptBattle(attackName))
                return attack;
        }
        return null;
    }


    public void neutrel_battle(int index,Pokemon pok1, Pokemon pok2){
        String[] attackType = {"attack","specialAttack","ability1","ability2"};
        Random rand = new Random();

        Pokemon neutrel1 = init()[0];
        Pokemon neutrel2 = init()[1];

        if(index == 1){

            while(pok1.getHP()>0 && (neutrel1.getHP()>0))
            {
                int random;
                if(pok1.getCooldown() > 0)
                {
                    random = rand.nextInt(2);
                    pok1.decreaseCooldown(1);
                }
                else
                    random = rand.nextInt(4);

                int ok = 0;

                String typeOfAttack1 = attackType[random];
                if(typeOfAttack1.equals("attack") && pok1.getAttack() == 0)
                {
                    typeOfAttack1 = "specialAttack";
                    ok = 1;
                }
                if(typeOfAttack1.equals("specialAttack") && pok1.getSpecialAttack() == 0 && ok ==0)
                    typeOfAttack1 = "attack";


                Attack attackToNeutrel = findTypeOfAttack(typeOfAttack1);
                System.out.println(pok1.getName() + " " + typeOfAttack1  + " / " + neutrel1.getName() + " attack " );
                int damageDealtToNeutrel = attackToNeutrel.attack(pok1,typeOfAttack1,neutrel1,"attack");
                int damageDealtToPokemon = attackToNeutrel.attack(neutrel1,"attack", pok1,"attack");
                pok1.setHP(pok1.getHP()-damageDealtToPokemon);
                neutrel1.setHP(neutrel1.getHP()-damageDealtToNeutrel);
                System.out.println(pok1.getName() + " HP: " + pok1.getHP() + ", cooldown: " + pok1.getCooldown());
                System.out.println(neutrel1.getName() + " HP: " + neutrel1.getHP() + ", cooldown: " + neutrel1.getCooldown() + "\n");
            }
            System.out.println(pok1.getName() + " won\n");
            pok1.buff();
            System.out.println(pok1.getName() + " got buffed\n");
            pok1.showStats();
            pok1.setHP(pok1.getMaxHP());
            neutrel1.setHP(neutrel1.getMaxHP());

            while(pok2.getHP()>0 && (neutrel1.getHP()>0))
            {
                int random;
                if(pok2.getCooldown() > 0)
                {
                    random = rand.nextInt(2);
                    pok2.decreaseCooldown(1);
                }
                else
                    random = rand.nextInt(4);

                int ok = 0;

                String typeOfAttack1 = attackType[random];
                if(typeOfAttack1.equals("attack") && pok2.getAttack() == 0)
                {
                    typeOfAttack1 = "specialAttack";
                    ok = 1;
                }
                if(typeOfAttack1.equals("specialAttack") && pok2.getSpecialAttack() == 0 && ok ==0)
                    typeOfAttack1 = "attack";

                Attack attackToNeutrel = findTypeOfAttack(typeOfAttack1);
                System.out.println(pok2.getName() + " " + typeOfAttack1 + " / " + neutrel1.getName() + " attack ");
                int damageDealtToNeutrel = attackToNeutrel.attack(pok2,typeOfAttack1,neutrel1,"attack");
                int damageDealtToPokemon = attackToNeutrel.attack(neutrel1,"attack", pok2,"attack");
                pok2.setHP(pok2.getHP()-damageDealtToPokemon);
                neutrel1.setHP(neutrel1.getHP()-damageDealtToNeutrel);
                System.out.println(pok2.getName() + " HP: " + pok2.getHP() + ", cooldown: " + pok2.getCooldown());
                System.out.println(neutrel1.getName() + " HP: " + neutrel1.getHP() + ", cooldown: " + neutrel1.getCooldown() + "\n");
            }
            System.out.println(pok2.getName() + " won\n");
            pok2.buff();
            System.out.println(pok2.getName() + " got buffed\n");
            pok2.showStats();
            pok2.setHP(pok2.getMaxHP());
            neutrel1.setHP(neutrel1.getMaxHP());
        }

        if(index == 2){
            while(pok1.getHP()>0 && (neutrel2.getHP()>0))
            {
                int random;
                if(pok1.getCooldown() > 0)
                {
                    random = rand.nextInt(2);
                    pok1.decreaseCooldown(1);
                }
                else
                    random = rand.nextInt(4);

                int ok = 0;

                String typeOfAttack1 = attackType[random];
                if(typeOfAttack1.equals("attack") && pok1.getAttack() == 0)
                {
                    typeOfAttack1 = "specialAttack";
                    ok = 1;
                }
                if(typeOfAttack1.equals("specialAttack") && pok1.getSpecialAttack() == 0 && ok ==0)
                    typeOfAttack1 = "attack";

                Attack attackToNeutrel = findTypeOfAttack(typeOfAttack1);
                System.out.println(pok1.getName() + " " + typeOfAttack1 +  " / " + neutrel2.getName() + " attack " );
                int damageDealtToNeutrel = attackToNeutrel.attack(pok1,typeOfAttack1,neutrel2,"attack");
                int damageDealtToPokemon = attackToNeutrel.attack(neutrel2,"attack", pok1,"attack");
                pok1.setHP(pok1.getHP()-damageDealtToPokemon);
                neutrel2.setHP(neutrel2.getHP()-damageDealtToNeutrel);
                System.out.println(pok1.getName() + " HP: " + pok1.getHP() + ", cooldown: " + pok1.getCooldown());
                System.out.println(neutrel2.getName() + " HP: " + neutrel2.getHP() + ", cooldown: " + neutrel2.getCooldown()+ "\n");
            }
            System.out.println(pok1.getName() + " won\n");
            pok1.buff();
            System.out.println(pok1.getName() + " got buffed\n");
            pok1.showStats();
            pok1.setHP(pok1.getMaxHP());
            neutrel2.setHP(neutrel2.getMaxHP());

            while(pok2.getHP()>0 && (neutrel2.getHP()>0))
            {
                int random;
                if(pok2.getCooldown() > 0)
                {
                    random = rand.nextInt(2);
                    pok2.decreaseCooldown(1);
                }
                else
                    random = rand.nextInt(4);

                int ok = 0;

                String typeOfAttack1 = attackType[random];
                if(typeOfAttack1.equals("attack") && pok2.getAttack() == 0)
                {
                    typeOfAttack1 = "specialAttack";
                    ok = 1;
                }
                if(typeOfAttack1.equals("specialAttack") && pok2.getSpecialAttack() == 0 && ok ==0)
                    typeOfAttack1 = "attack";

                Attack attackToNeutrel = findTypeOfAttack(typeOfAttack1);
                System.out.println(pok2.getName() + " " + typeOfAttack1  + " / " + neutrel2.getName() + " attack " );
                int damageDealtToNeutrel = attackToNeutrel.attack(pok2,typeOfAttack1,neutrel2,"attack");
                int damageDealtToPokemon = attackToNeutrel.attack(neutrel2,"attack", pok2,"attack");
                pok2.setHP(pok2.getHP()-damageDealtToPokemon);
                neutrel2.setHP(neutrel2.getHP()-damageDealtToNeutrel);
                System.out.println(pok2.getName() + " HP: " + pok2.getHP() + ", cooldown: " + pok1.getCooldown());
                System.out.println(neutrel2.getName() + " HP: " + neutrel2.getHP() + ", cooldown: " + pok1.getCooldown() + "\n");
            }
            System.out.println(pok2.getName() + " won\n");
            pok2.buff();
            System.out.println(pok2.getName() + " got buffed\n");
            pok2.showStats();
            pok2.setHP(pok2.getMaxHP());
            neutrel2.setHP(neutrel2.getMaxHP());
        }
    }


    @Override
    public void run() {

        int battleNo = 1;

        Pokemon pokemon1 = init()[2];
        Pokemon pokemon2 = init()[3];
        System.out.println("\nPre-battle stats:\n");
        pokemon1.showStats();
        System.out.println();
        pokemon2.showStats();
        applyItems(pokemon1);
        applyItems(pokemon2);
        System.out.println("\nStats after equipping items:\n");
        pokemon1.showItems();
        System.out.println();
        pokemon1.showStats();
        System.out.println();
        pokemon2.showItems();
        System.out.println();
        pokemon2.showStats();

        Random rand = new Random();
        int rand_event;

        int exit = 0;
        System.out.println("\n =====Preparation Battles===== \n ");
        while(exit == 0)
        {
            rand_event = rand.nextInt(3);
            if(rand_event!=0)
            {
                System.out.println("\nBattle number " + battleNo + "\n");
                battleNo++;
            }
            if(rand_event == 1)
                neutrel_battle(1,pokemon1,pokemon2);
            if(rand_event == 2)
                neutrel_battle(2,pokemon1,pokemon2);
            if (rand_event == 0)
                exit = 1;
        }
        System.out.println("\nEnd of preparation battles\n");

        System.out.println("\nStats before main battle:\n");
        pokemon1.showStats();
        System.out.println();
        pokemon2.showStats();

        System.out.println("\n=====Battle started=====\n");
        String[] attackType = {"attack","specialAttack","ability1","ability2"};
        int random;
        System.out.println("\nBattle number " + battleNo + "\n");
        while(pokemon1.getHP()> 0 && pokemon2.getHP() > 0){
            if(pokemon1.getCooldown() > 0)
            {
                random = rand.nextInt(2);
                pokemon1.decreaseCooldown(1);
            }
            else
                random = rand.nextInt(4);

            int ok = 0;

            String typeOfAttack1 = attackType[random];
            if(typeOfAttack1.equals("attack") && pokemon1.getAttack() == 0)
            {
                typeOfAttack1 = "specialAttack";
                ok = 1;
            }
            if(typeOfAttack1.equals("specialAttack") && pokemon1.getSpecialAttack() == 0 && ok ==0)
                typeOfAttack1 = "attack";

            ok = 0;

            if(pokemon2.getCooldown() > 0)
            {
                random = rand.nextInt(2);
                pokemon2.decreaseCooldown(1);
            }
            else
                random = rand.nextInt(4);

            String typeOfAttack2 = attackType[random];

            if(typeOfAttack2.equals("attack") && pokemon2.getAttack() == 0)
            {
                typeOfAttack2 = "specialAttack";
                ok = 1;
            }

            if(typeOfAttack2.equals("specialAttack") && pokemon2.getSpecialAttack() == 0 && ok == 0)
                typeOfAttack2 = "attack";


            Attack attack1 = findTypeOfAttack(typeOfAttack1);
            Attack attack2 = findTypeOfAttack(typeOfAttack2);

            System.out.println(pokemon1.getName() + " " + typeOfAttack1  + " / " + pokemon2.getName() + " " + typeOfAttack2 );

            pokemon2.setHP(pokemon2.getHP() - attack1.attack(pokemon1,typeOfAttack1,pokemon2,typeOfAttack2));
            pokemon1.setHP(pokemon1.getHP() - attack2.attack(pokemon2,typeOfAttack2,pokemon1,typeOfAttack1));
            System.out.println(pokemon1.getName() + " HP " + pokemon1.getHP() + ", cooldown: " + pokemon1.getCooldown());
            System.out.println(pokemon2.getName() + " HP " + pokemon2.getHP() + ", cooldown: " + pokemon2.getCooldown() + "\n");
        }
        if(pokemon1.getHP() <=  0 && pokemon2.getHP() <=  0)
            System.out.println("Battle ended as a draw\n");

        if (pokemon1.getHP()> 0)
        {
            System.out.println( pokemon1.getName() + " won\n");
            pokemon1.buff();
            System.out.println(pokemon1.getName() + " got buffed\n");
            pokemon1.showStats();
            System.out.println("\n" + trainer1.getName() + " is the winner\n");
        }
        else if(pokemon2.getHP()> 0)
        {
            System.out.println( pokemon2.getName() + " won\n");
            pokemon2.buff();
            System.out.println(pokemon2.getName() + " got buffed\n");
            pokemon2.showStats();
            System.out.println("\n" + trainer2.getName() + " is the winner\n");
        }
        pokemon2.setHP(pokemon2.getMaxHP());
        pokemon1.setHP(pokemon1.getMaxHP());
    }
}
