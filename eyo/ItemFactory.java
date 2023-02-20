package com.company.factories;

import com.company.Item;
import com.company.builders.ItemBuilder;

public class ItemFactory {
    private ItemFactory() {
    }

    public static Item createItem(String name){
        ItemBuilder itemBuilder = new ItemBuilder();
        switch (name) {
            case "Scut" -> {
                itemBuilder.buildName("Scut");
                itemBuilder.buildDefense(2);
                itemBuilder.buildSpecialDefense(2);
                return itemBuilder.build();
            }
            case "Vesta" -> {
                itemBuilder.buildName("Vesta");
                itemBuilder.buildHP(10);
                return itemBuilder.build();
            }
            case "Sabiuta" -> {
                itemBuilder.buildName("Sabiuta");
                itemBuilder.buildAttack(3);
                return itemBuilder.build();
            }
            case "Bagheta Magica" -> {
                itemBuilder.buildName("Bagheta Magica");
                itemBuilder.buildSpecialAttack(3);
                return itemBuilder.build();
            }
            case "Vitamine" -> {
                itemBuilder.buildName("Vitamine");
                itemBuilder.buildHP(2);
                itemBuilder.buildAttack(2);
                itemBuilder.buildSpecialAttack(2);
                return itemBuilder.build();
            }
            case "Brad de Craciun" -> {
                itemBuilder.buildName("Brad de Craciun");
                itemBuilder.buildAttack(3);
                itemBuilder.buildDefense(1);
                return itemBuilder.build();
            }
            case "Pelerina" -> {
                itemBuilder.buildName("Pelerina");
                itemBuilder.buildSpecialDefense(3);
                return itemBuilder.build();
            }
        }
        return null;
    }
}
