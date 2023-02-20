package com.company.factories;

import com.company.Item;
import com.company.Pokemon;
import com.company.builders.AbilityBuilder;
import com.company.builders.PokemonBuilder;

import java.util.ArrayList;

public class PokemonFactory {
    private PokemonFactory() {}

    public static Pokemon createPokemon(String name, String item1, String item2, String item3){

        AbilityBuilder ability1 = new AbilityBuilder();
        AbilityBuilder ability2 = new AbilityBuilder();

        ArrayList<Item> items = new ArrayList<>();

        items.add(ItemFactory.createItem(item1));
        items.add(ItemFactory.createItem(item2));
        items.add(ItemFactory.createItem(item3));

        switch (name) {
            case "Neutrel1" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Neutrel1");
                pokemonBuilder.buildHP(10);
                pokemonBuilder.buildAttack(3);
                pokemonBuilder.buildDefense(1);
                pokemonBuilder.buildSpecialDefense(1);
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Neutrel2" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Neutrel2");
                pokemonBuilder.buildHP(20);
                pokemonBuilder.buildAttack(4);
                pokemonBuilder.buildDefense(1);
                pokemonBuilder.buildSpecialDefense(1);
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Pikachu" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Pikachu");
                pokemonBuilder.buildHP(35);
                pokemonBuilder.buildSpecialAttack(4);
                pokemonBuilder.buildDefense(2);
                pokemonBuilder.buildSpecialDefense(3);
                ability1.buildDamage(6);
                ability1.buildDodge(false);
                ability1.buildStun(false);
                ability1.buildCooldown(4);
                ability2.buildStun(true);
                ability2.buildDodge(true);
                ability2.buildDamage(4);
                ability2.buildCooldown(5);
                pokemonBuilder.buildAbility1(ability1.build());
                pokemonBuilder.buildAbility2(ability2.build());
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Bulbasaur" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Bulbasaur");
                pokemonBuilder.buildHP(42);
                pokemonBuilder.buildSpecialAttack(5);
                pokemonBuilder.buildDefense(3);
                pokemonBuilder.buildSpecialDefense(1);
                ability1.buildDamage(6);
                ability1.buildStun(false);
                ability1.buildDodge(false);
                ability1.buildCooldown(4);
                ability2.buildDamage(5);
                ability2.buildStun(false);
                ability2.buildDodge(false);
                ability2.buildCooldown(3);
                pokemonBuilder.buildAbility1(ability1.build());
                pokemonBuilder.buildAbility2(ability2.build());
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Charmander" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Charmander");
                pokemonBuilder.buildHP(50);
                pokemonBuilder.buildAttack(4);
                pokemonBuilder.buildDefense(3);
                pokemonBuilder.buildSpecialDefense(2);
                ability1.buildDamage(4);
                ability1.buildStun(true);
                ability1.buildDodge(false);
                ability1.buildCooldown(4);
                ability2.buildDamage(7);
                ability2.buildStun(false);
                ability2.buildDodge(false);
                ability2.buildCooldown(6);
                pokemonBuilder.buildAbility1(ability1.build());
                pokemonBuilder.buildAbility2(ability2.build());
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Squirtle" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Squirtle");
                pokemonBuilder.buildHP(60);
                pokemonBuilder.buildSpecialAttack(3);
                pokemonBuilder.buildDefense(5);
                pokemonBuilder.buildSpecialDefense(5);
                ability1.buildDamage(4);
                ability1.buildStun(false);
                ability1.buildDodge(false);
                ability1.buildCooldown(3);
                ability2.buildDamage(2);
                ability2.buildStun(true);
                ability2.buildDodge(false);
                ability2.buildCooldown(2);
                pokemonBuilder.buildAbility1(ability1.build());
                pokemonBuilder.buildAbility2(ability2.build());
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Snorlax" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Snorlax");
                pokemonBuilder.buildHP(62);
                pokemonBuilder.buildAttack(3);
                pokemonBuilder.buildDefense(6);
                pokemonBuilder.buildSpecialDefense(4);
                ability1.buildDamage(4);
                ability1.buildStun(true);
                ability1.buildDodge(false);
                ability1.buildCooldown(5);
                ability2.buildDamage(0);
                ability2.buildStun(false);
                ability2.buildDodge(true);
                ability2.buildCooldown(5);
                pokemonBuilder.buildAbility1(ability1.build());
                pokemonBuilder.buildAbility2(ability2.build());
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Vulpix" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Vulpix");
                pokemonBuilder.buildHP(36);
                pokemonBuilder.buildAttack(5);
                pokemonBuilder.buildDefense(2);
                pokemonBuilder.buildSpecialDefense(4);
                ability1.buildDamage(8);
                ability1.buildStun(true);
                ability1.buildDodge(false);
                ability1.buildCooldown(6);
                ability2.buildDamage(0);
                ability2.buildStun(false);
                ability2.buildDodge(true);
                ability2.buildCooldown(5);
                pokemonBuilder.buildAbility1(ability1.build());
                pokemonBuilder.buildAbility2(ability2.build());
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Eevee" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Eevee");
                pokemonBuilder.buildHP(39);
                pokemonBuilder.buildSpecialAttack(4);
                pokemonBuilder.buildDefense(3);
                pokemonBuilder.buildSpecialDefense(3);
                ability1.buildDamage(5);
                ability1.buildStun(false);
                ability1.buildDodge(false);
                ability1.buildCooldown(3);
                ability2.buildDamage(3);
                ability2.buildStun(true);
                ability2.buildDodge(false);
                ability2.buildCooldown(3);
                pokemonBuilder.buildAbility1(ability1.build());
                pokemonBuilder.buildAbility2(ability2.build());
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Jigglypuff" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Jigglypuff");
                pokemonBuilder.buildHP(34);
                pokemonBuilder.buildAttack(4);
                pokemonBuilder.buildDefense(2);
                pokemonBuilder.buildSpecialDefense(3);
                ability1.buildDamage(4);
                ability1.buildStun(true);
                ability1.buildDodge(false);
                ability1.buildCooldown(4);
                ability2.buildDamage(3);
                ability2.buildStun(true);
                ability2.buildDodge(false);
                ability2.buildCooldown(4);
                pokemonBuilder.buildAbility1(ability1.build());
                pokemonBuilder.buildAbility2(ability2.build());
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Meowth" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Meowth");
                pokemonBuilder.buildHP(41);
                pokemonBuilder.buildAttack(3);
                pokemonBuilder.buildDefense(4);
                pokemonBuilder.buildSpecialDefense(2);
                ability1.buildDamage(5);
                ability1.buildStun(false);
                ability1.buildDodge(true);
                ability1.buildCooldown(4);
                ability2.buildDamage(1);
                ability2.buildStun(false);
                ability2.buildDodge(true);
                ability2.buildCooldown(3);
                pokemonBuilder.buildAbility1(ability1.build());
                pokemonBuilder.buildAbility2(ability2.build());
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
            case "Psyduck" -> {
                PokemonBuilder pokemonBuilder = new PokemonBuilder("Psyduck");
                pokemonBuilder.buildHP(43);
                pokemonBuilder.buildAttack(3);
                pokemonBuilder.buildDefense(3);
                pokemonBuilder.buildSpecialDefense(3);
                ability1.buildDamage(2);
                ability1.buildStun(false);
                ability1.buildDodge(false);
                ability1.buildCooldown(4);
                ability2.buildDamage(2);
                ability2.buildStun(true);
                ability2.buildDodge(false);
                ability2.buildCooldown(5);
                pokemonBuilder.buildAbility1(ability1.build());
                pokemonBuilder.buildAbility2(ability2.build());
                pokemonBuilder.buildItems(items);
                return pokemonBuilder.build();
            }
        }

        return null;
    }
}
