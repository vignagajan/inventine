package com.inventine.util;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DotEnv {

    private String path = "src/test/resources/.env";
    private Map<String, String> map = new HashMap<>();

    public Map<String,String> load(){

        try {
            File myObj = new File(this.path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if(line == "" || Character.compare(line.charAt(0),'#') == 0){
                    continue;
                }
                this.map.put(line.split("=")[0], line.split("=")[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Create .env file in project root directory.");
            e.printStackTrace();
        }

        return map;

    }

    public void configure(String new_path){

        this.path = new_path;

    }

}
