package com.company;

import com.company.factories.PokemonFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {
    public ArrayList<Trainer> readFromFile (String filename){
        ArrayList<Trainer> trainers = new ArrayList<>(0);
        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);


            String name1 = myReader.nextLine();
            int age1 = Integer.parseInt(myReader.nextLine());
            Trainer trainer1 = new Trainer(name1,age1);

            String pokemon1_1 = myReader.nextLine();
            String item1_1_1 = myReader.nextLine();
            String item1_1_2 = myReader.nextLine();
            String item1_1_3 = myReader.nextLine();
            trainer1.addPokemon(PokemonFactory.createPokemon(pokemon1_1,item1_1_1,item1_1_2,item1_1_3));
            String pokemon1_2 = myReader.nextLine();
            String item1_2_1 = myReader.nextLine();
            String item1_2_2 = myReader.nextLine();
            String item1_2_3 = myReader.nextLine();
            trainer1.addPokemon(PokemonFactory.createPokemon(pokemon1_2,item1_2_1,item1_2_2,item1_2_3));
            String pokemon1_3 = myReader.nextLine();
            String item1_3_1 = myReader.nextLine();
            String item1_3_2 = myReader.nextLine();
            String item1_3_3 = myReader.nextLine();
            trainer1.addPokemon(PokemonFactory.createPokemon(pokemon1_3,item1_3_1,item1_3_2,item1_3_3));

            String name2 = myReader.nextLine();
            int age2 = Integer.parseInt(myReader.nextLine());
            Trainer trainer2 = new Trainer(name2,age2);

            String pokemon2_1 = myReader.nextLine();
            String item2_1_1 = myReader.nextLine();
            String item2_1_2 = myReader.nextLine();
            String item2_1_3 = myReader.nextLine();
            trainer2.addPokemon(PokemonFactory.createPokemon(pokemon2_1,item2_1_1,item2_1_2,item2_1_3));
            String pokemon2_2 = myReader.nextLine();
            String item2_2_1 = myReader.nextLine();
            String item2_2_2 = myReader.nextLine();
            String item2_2_3 = myReader.nextLine();
            trainer2.addPokemon(PokemonFactory.createPokemon(pokemon2_2,item2_2_1,item2_2_2,item2_2_3));
            String pokemon2_3 = myReader.nextLine();
            String item2_3_1 = myReader.nextLine();
            String item2_3_2 = myReader.nextLine();
            String item2_3_3 = myReader.nextLine();
            trainer2.addPokemon(PokemonFactory.createPokemon(pokemon2_3,item2_3_1,item2_3_2,item2_3_3));

            trainers.add(trainer1);
            trainers.add(trainer2);


            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return trainers;
    }
}
