package oqqa;

import oqqa.SubsetLib;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
        List<String> kek = new ArrayList<String>();

        Map<String, Double> kek2 = new HashMap<String, Double>();


        /*
        kek.Add("(-∞, x1] U [x2, +∞)");  
        kek.Add("(-∞, x1] U [x2, x3] U … U [x4, +∞)");  
        kek.Add("[x1, x2]");  
         
        kek2.put("x1", 2.);
        kek2.put("x2", 5.);
        kek2.put("x3", 10.);
        kek2.put("x4", 30.);
        */


        kek.add("[x1, x5]");
        kek.add("(-∞, x2] U [x4, +∞)");
        kek.add("[x1, x3]");

        kek2.put("x1", 2.);
        kek2.put("x2", 4.);
        kek2.put("x3", 12.);
        kek2.put("x4", 8.);
        kek2.put("x5", 10.);


        List<Double[]> data = SubsetLib.Task2_Start(kek, kek2);

        Double num = SubsetLib.Task1_Start(34., data);

        System.out.println( num );
    }
}
