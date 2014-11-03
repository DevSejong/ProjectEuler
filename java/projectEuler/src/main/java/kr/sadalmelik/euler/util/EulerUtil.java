package kr.sadalmelik.euler.util;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 * Created by SejongPark on 14. 10. 30..
 */
public class EulerUtil {

    //성능 향상을 위해서 1씩 더하는게 아니라 소수만을 검사하는 방법 고려할 것.
    public static List<Long> getIntegerFactorization(long num) {
        List<Long> factors = new ArrayList<>();

        long target = num;

        for (long i = 2; i <= num; i++) {
            while (target % i == 0) {
                factors.add(i);
                target /= i;
            }
        }

        return factors;
    }

    public static int getDivisorNumber(long num){
        List<Long> factors = getIntegerFactorization(num);


        //각 숫자별 약수의 갯수를 구한다.
        Map<Long, Integer> groupedIntegerFactorization = new HashMap<>();
        for(long element : factors){
            if(!groupedIntegerFactorization.containsKey(element)){
                groupedIntegerFactorization.put(element, 1);
            }else{
                groupedIntegerFactorization.put(element, groupedIntegerFactorization.get(element) + 1);
            }
        }

        int result = groupedIntegerFactorization.values().stream().reduce(1, (a, b) -> a * (b + 1));
        return result;
    }



}
