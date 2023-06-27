package tests2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {


    public static Object[][] readFromCSVFile(String filePath){



        List<List<String>> list = new ArrayList<>();
        try
                ( BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            bufferedReader.readLine();
            list = bufferedReader.lines()
                    .map(s -> new ArrayList<>(Arrays.asList(s.split(","))))
                    .collect(Collectors.toList());
        }
        catch(IOException e){
            System.out.println("File doesn't exist");
        }

        Object[][] arr = new Object[list.size()][list.get(0).size()];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }

        return arr;


    }


    public static void main(String[] args) {
        Object[][] objects = readFromCSVFile("customers.csv");

        System.out.println(Arrays.deepToString(objects));
    }
}
