package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<int[]> allArray = new LinkedList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty())
                break;
            String[] strs = line.split(" ");
            int[] numArray = new int[strs.length];
            for (int j = 0; j < strs.length; j++) {
                numArray[j] = Integer.valueOf(strs[j]);
            }
            allArray.add(numArray);
        }
    }
}