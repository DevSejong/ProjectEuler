package kr.sadalmelik.euler.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SejongPark on 14. 10. 30..
 */
public class EulerUtil {

    //성능 향상을 위해서 1씩 더하는게 아니라 소수만을 검사하는 방법 고려할 것.
    public static List<Long> getPrimeFactorization(long triNum) {
        List<Long> factors = new ArrayList<>();

        long target = triNum;

        for (long i = 2; i <= triNum; i++) {
            while (target % i == 0) {
                factors.add(i);
                target /= i;
            }
        }

        return factors;
    }



}
