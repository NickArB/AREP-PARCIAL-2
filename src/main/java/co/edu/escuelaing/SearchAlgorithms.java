package co.edu.escuelaing;

import java.util.Arrays;
import java.util.List;

public class SearchAlgorithms{
    public static Integer linearSearch(List<Integer> numbers, int element){
        for(Integer i: numbers){
            if(i == element){
                return numbers.indexOf(i);
            }
        }
        return -1;
    }

    public static Integer binarySearch(List<Integer> numbers, int element){
        int start = 0;
        int end = numbers.size() - 1;
        int middle = end / 2;
        
        while(start != end){
            System.out.println("" + start + ", " + end);
            System.out.println(middle);
            if(numbers.get(middle) == element){
                return middle;
            }
            if(numbers.get(middle) > element){
                end = middle;
            }
            if(numbers.get(middle) < element){
                start = middle;
            }

            middle = (end + start) / 2;
            if(end - start == 1){
                middle ++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(10,20,13,40,60);
        System.out.println(binarySearch(lst, 20));
    }
}   