package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        DataReader dataReader = new DataReader();
        ArrayList<Trainer> trainers = dataReader.readFromFile("src\\com\\company\\TrainerData\\Fight1.txt");
        Arena arena = new Arena(trainers.get(0),trainers.get(1));
        //PrintStream o = new PrintStream(new File("outpuLogger.txt"));
        PrintStream console = System.out;
        System.setOut(console);
        arena.battle();
    }
}
