package co.edu.escuelaing;

import java.util.Arrays;
import java.util.List;

public class SearchAlgorithms{
    public static Integer linearSearch(List<Integer> numbers, int element){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == element){
                return i;
            }
        }
        return -1;
    }

    public static Integer binarySearch(List<Integer> numbers, int element){
        int start = 0;
        int end = numbers.size() - 1;
        int middle = end / 2;
        
        while(start <= end){
            if(numbers.get(middle) == element){
                return middle;
            }else if((end - start) == 1){
                middle ++;
                return middle;
            }
            if(numbers.get(middle) > element){
                end = middle;
            }
            if(numbers.get(middle) < element){
                start = middle;
            }

            middle = (end + start) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(10,13,20,40,60);
        System.out.println(linearSearch(lst, 60));
    }
}   