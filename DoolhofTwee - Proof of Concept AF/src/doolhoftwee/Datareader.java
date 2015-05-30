/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhoftwee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Remco
 */
public class Datareader {
    
    /**
     * 
     * @param fileName is the name of the file in src/doolhoftwee/levels/
     * @return the layout of the map in the file.
     */
    public static String[][] getData(String fileName) {
        try {
            File file = new File("src/doolhoftwee/levels/" + fileName + ".txt").getAbsoluteFile();
            Scanner in = new Scanner(file);
            
            String[][] data = null;
            
            Queue<String[]> dataLines = new LinkedList<>();
            
            /**
             * adds all the data lines to the Queue
             * is done if the size isnt right or if there are no next lines
             */
            while(in.hasNextLine()) {
                String[] line = in.nextLine().split("");
                if(!dataLines.isEmpty()) {
                    if(line.length != dataLines.peek().length) {
                        break;
                    }
                }
                dataLines.add(line);                
            }
            
            data = new String[dataLines.size()][dataLines.peek().length];
            
            int amountOfLines = dataLines.size();
            
            /**
             * put all the data from the Queue in the data[][]
             */
            for(int i = 0; i < amountOfLines; i++) {
                String[] line = dataLines.poll();
                for(int j = 0; j < line.length; j++) {
                    data[i][j] = line[j];
                }
            }
            
            return data;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Datareader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
