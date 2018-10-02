package oqqa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubsetLib 
{
     
    static Double[] Logic(Double[] a, Double[] b)
    {
        if ( ( a[0] > b[1] ) || ( a[1] < b[0] ) )
        {
            return null;
        }

        Double[] result = new Double[] {
            ( a[0] >  b[0] ) ? a[0] : b[0],
            ( a[1] <  b[1] ) ? a[1] : b[1]
        };

        return result;
    }

    static List<Double[]> FindIntersections(List<Double[]> subset1, List<Double[]> subset2)
    {
        List<Double[]> localIntersections = new ArrayList<Double[]>();
        
        for (Double[] arr1 : subset1)
            for (Double[] arr2 : subset2)
            {
                Double[] arr = Logic(arr1, arr2);
                if (arr != null)
                {
                    localIntersections.add(arr);
                }
            }

        return localIntersections;
    }

    static List<Double[]> GetIntersections(List<List<Double[]>> Subsets)
    {
        if (Subsets.size() < 2) return null;

        List<Double[]> activIntersections = Subsets.get(0);

        for (int i = 1; i < Subsets.size(); i++)
        {
            //  activIntersections = activIntersections пересекает? Subsets[i]

            activIntersections = FindIntersections(activIntersections, Subsets.get(i));
        }

        return activIntersections;
    }

    static List<List<Double[]>> Parser(List<String> badSubsets)
    {
        List<List<Double[]>> goodSubsets = new ArrayList<List<Double[]>>();

        for( String st : badSubsets)
        {
            List<Double[]> localSubsets = new ArrayList<Double[]>();
            
            String s;
            s = st.replace('(', '[');
            s = s.replace(')', ']');

            do
            {
                int i1 = s.indexOf('[');
                if (i1 < 0) break;

                int i2 = s.indexOf(',');
                int i3 = s.indexOf(']');

                String s1 = s.substring(i1 + 1, i2);
                String s2 = s.substring(i2 + 1, i3);

                localSubsets.add( new Double[]
                    {
                        ( s1.contains("-∞") ) ? Double.NEGATIVE_INFINITY : ( s1.contains("+∞") ) ? Double.POSITIVE_INFINITY : Double.parseDouble( s1 ),
                        ( s2.contains("-∞") ) ? Double.NEGATIVE_INFINITY : ( s2.contains("+∞") ) ? Double.POSITIVE_INFINITY : Double.parseDouble( s2 )
                    }
                    
                );
                
                s = s.substring(i3 + 1);
            } while (true);

            goodSubsets.add(localSubsets);
        }

        return goodSubsets;
    }

    static List<Double[]> Task2_DeepStart(List<String> badSubsets)
    {
        return GetIntersections(Parser(badSubsets));
    }

    static List<Double[]> Task2_Start(List<String> veryBadSubsets, Map<String, Double> param)
    {
        // подмена на значения
        for (int i = 0; i < veryBadSubsets.size(); i++)
        {
            for (Map.Entry<String, Double> k : param.entrySet())
            {
                veryBadSubsets.set(i, veryBadSubsets.get(i).replace(k.getKey(), k.getValue().toString() ) );
            }
        }

        return Task2_DeepStart(veryBadSubsets);
    }
   
    static Double Task1_Start(Double num, List<Double[]> Intersections)
    {
        Double minNum = 0.;
        Double minPath = Double.POSITIVE_INFINITY;

        for ( Double[] Inter : Intersections)
        {
            if ( Inter[1] < num )
            {
                Double path = num - Inter[1];
                if ( path < minPath )
                {
                    minNum = Inter[1];
                    minPath = path;
                }
                continue;
            }
            if ( Inter[0] > num )
            {
                Double path = Inter[0] - num;
                if (path < minPath)
                {
                    minNum = Inter[0];
                    minPath = path;
                }
                continue;
            }

            minNum = num;
            break;
        }

        return minNum;
    }

}
