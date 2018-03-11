package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Log {

    String basePath = "/Users/LJM/code/team2-java-week4-pair-exercise/m1-capstone/";
    File logFile = new File(basePath + "logFile");

    PrintWriter logFileWriter;

    {
        try {
            logFileWriter = new PrintWriter(logFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ArrayList<String> transaction = new ArrayList<>();

    public void getFileToWrite(String a){
        transaction.add(a);
    }

    private void printLog(ArrayList<String> log){
        // add time to the arrayList and then print it to a file
    }

}
