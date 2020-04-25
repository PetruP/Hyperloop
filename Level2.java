package ro.codingContenst;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Level2 {
    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner(new FileReader("/Users/petru/Downloads/level2/level2-1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output2.txt"));
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
        String element2 = fileScanner.nextLine();
        String[] arr3 = element2.split(" ");
        double x1 = 0, x2 = 0, x3 = 0, x4 = 0, y1 = 0, y2 = 0, y3 = 0, y4 = 0;
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
            if (cities.get(i).get("city").equals(arr3[0]))
            {
                x3=Double.parseDouble((String)cities.get(i).get("x"));
                y3=Double.parseDouble((String)cities.get(i).get("y"));
            }
            if (cities.get(i).get("city").equals(arr3[1]))
            {
                x4=Double.parseDouble((String)cities.get(i).get("x"));
                y4=Double.parseDouble((String)cities.get(i).get("y"));
            }
        }
        double x = (double)((x4-x1)*(x4-x1) + (y4-y1) * (y4-y1));
        double distance = Math.sqrt(Math.abs(x));
        double time = distance / 15;

        double y = (double)((x4-x2)*(x4-x2) + (y4-y2) * (y4-y2));
        double distance2 = Math.sqrt(Math.abs(y));
        double time2 = distance2 / 250 + 200;

        double z = (double)((x2-x3)*(x2-x3) + (y2-y3) * (y2-y3));
        double distance3 = Math.sqrt(Math.abs(z));
        double time3 = distance3 / 15;

        double sum = Math.round(time + time2 + time3);
        writer.write(String.valueOf(sum));
        writer.close();
    }
}



