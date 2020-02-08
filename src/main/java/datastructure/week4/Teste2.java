package datastructure.week4;

import java.util.HashMap;
import java.util.Map;

public class Teste2 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,9};
        int[] numbersb = new int[]{1,2,4,4};
        int sum = 8;

        System.out.println(hasPair(numbersb,sum));
    }

    private static boolean hasPair(int[] a, int sum){
        Map<Integer, Integer> comp = new HashMap<>();

        //1, 3, 5
        for (Integer value: a) {
            if(comp.get(value) != null && (comp.get(value) + value) == sum){
                return true;
            }else{
                comp.put(sum - value, value);
            }
        }
        return false;
    }
}
