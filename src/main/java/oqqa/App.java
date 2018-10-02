package oqqa;

import oqqa.SubsetLib;

// интересно было бы узнать как обойтись без зависимостей..
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

        
        kek.add("[x1, x5]");
        kek.add("(-∞, x2] U [x4, +∞)");
        kek.add("[x1, x3]");

        kek2.put("x1", 2.);
        kek2.put("x2", 4.);
        kek2.put("x3", 12.);
        kek2.put("x4", 8.);
        kek2.put("x5", 10.);
        

        SubsetLib obj = new SubsetLib(kek, kek2);
        
        
        System.out.println( "Задача 1:" );

        Double number = obj.getAproxNumber(6.1);
        System.out.println( number );
        

        System.out.println( "Задача 2:" );

        List<Double[]> inters = obj.getIntersections();
        for ( Double[] inter : inters )
        {
            System.out.println( inter[0] + " " + inter[1] );
        }

    }
}
