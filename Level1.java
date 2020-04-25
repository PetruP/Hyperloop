package ro.codingContenst;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Level1 {
    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner(new FileReader("/Users/petru/Downloads/level1/level1-1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        int t = Integer.parseInt(fileScanner.nextLine());
        Vector<HashMap<String, Object>> cities = new Vector<HashMap<String, Object>>();
        for (int i =0; i < t; i++) {
            String element = fileScanner.nextLine();
            String[] arr = element.split(" ");
            HashMap<String, Object> e = new HashMap<String, Object>();
            e.put("city" , arr[0]);
            e.put("x" , arr[1]);
            e.put("y" , arr[2]);
            cities.add(e);
        }
        String element = fileScanner.nextLine();
        String[] arr2 = element.split(" ");
        double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        for (int i = 0; i<cities.size(); i++) {
            if (cities.get(i).get("city").equals(arr2[0]))
            {
                x1=Double.parseDouble((String)cities.get(i).get("x"));
                y1=Double.parseDouble((String)cities.get(i).get("y"));
            }
            if (cities.get(i).get("city").equals(arr2[1]))
            {
                x2=Double.parseDouble((String)cities.get(i).get("x"));
                y2=Double.parseDouble((String)cities.get(i).get("y"));
            }
        }
        double x = (double)((x2-x1)*(x2-x1) + (y2-y1) * (y2-y1));
        double distance = Math.sqrt(Math.abs(x));
        float time = Math.round(distance / 250 + 200);
        writer.write(String.valueOf(time));
        writer.close();
    }
}
