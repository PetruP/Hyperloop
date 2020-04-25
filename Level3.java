package ro.codingContenst;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Level3 {
    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner(new FileReader("/Users/petru/Downloads/level3/level3-1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output3.txt"));
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
        int count = 0;
        int t2 = Integer.parseInt(fileScanner.nextLine());
        for (int i =0; i < t2; i++) {
            String element = fileScanner.nextLine();
            String[] arr = element.split(" ");
            if (arr.length == 3) {
                String city1 = arr[0];
                String city2 = arr[1];
                double time = Double.parseDouble(arr[2]);
                double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
                for (int j = 0; j<cities.size(); j++) {
                    if (cities.get(j).get("city").equals(arr[0]))
                    {
                        x1=Double.parseDouble((String)cities.get(j).get("x"));
                        y1=Double.parseDouble((String)cities.get(j).get("y"));
                    }
                    if (cities.get(j).get("city").equals(arr[1]))
                    {
                        x2=Double.parseDouble((String)cities.get(j).get("x"));
                        y2=Double.parseDouble((String)cities.get(j).get("y"));
                    }
                }
                double x = (double)((x2-x1)*(x2-x1) + (y2-y1) * (y2-y1));
                double distance = Math.sqrt(Math.abs(x));
                float time2 = Math.round(distance / 15);
                if (time < time2) {
                    count++;
                }
            }

        }
        writer.write(String.valueOf(count));
        writer.close();
    }
}

