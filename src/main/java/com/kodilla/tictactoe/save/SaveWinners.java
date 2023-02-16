package com.kodilla.tictactoe.save;

import java.io.*;
import java.time.LocalDate;

public class SaveWinners implements Serializable {

    String winner;
    public static File savedHashMaps;

    public SaveWinners(String winner, LocalDate date) {
        this.winner = winner;
        File savedHashMaps = new File("ranking.txt");
        saveGame(String.valueOf(winner), date, savedHashMaps);
        System.out.print("\nRanking of winners:\n");
        loadGame(savedHashMaps);
    }

    public void saveGame(String winner, LocalDate date, File savedHashMaps) {
        try {
            FileOutputStream oos = new FileOutputStream((savedHashMaps), true);
            byte[] strToBytes = winner.getBytes();
            String dateString = date.toString();
            byte[] dateToBytes = dateString.getBytes();
            oos.write(strToBytes);
            oos.write(' ');
            oos.write(':');
            oos.write(' ');
            oos.write(dateToBytes);
            oos.write('\n');//new line
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadGame(File savedHashMaps) {
        try {
            FileInputStream ois = new FileInputStream(savedHashMaps);;
            int character;
            while ((character = ois.read()) != -1) {
                System.out.print((char)character);
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}