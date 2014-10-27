package com.devsejong;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SejongPark on 14. 10. 27..
 * <p/>
 * 소수를 크기 순으로 나열하면 2, 3, 5, 7, 11, 13, ... 과 같이 됩니다.<br/>
 * 이 때 10,001번째의 소수를 구하세요.
 */
public class Problem007 {
    public static void main(String[] args) {
        Long primeNumber = 0L;
        // 순서대로 소수를 만들어나간다.
        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();
        while (primeNumberGenerator.getPrimeNumbersSize() < 10001) {
            primeNumber = primeNumberGenerator.generateNext();
        }

        System.out.println("10001번째 소수는 : " +  primeNumber);
    }

}

class PrimeNumberGenerator {
    List<Long> primeNumbers;

    PrimeNumberGenerator() {
        primeNumbers = new ArrayList<Long>();

        //소수의 시작은 2이다.
        primeNumbers.add(2L);
    }

    public long generateNext() {
        long target = primeNumbers.get(primeNumbers.size() - 1);
        boolean isPrimeNumber = false;

        //리스트의 마지막 숫자에서 1을 더하면서 primeNumber인지 확인한다.
        while (isPrimeNumber == false) {
            target += 1;

            if (isPrimeNumber(target)) {
                primeNumbers.add(target);
                isPrimeNumber = true;
            }
        }

        return target;
    }

    private boolean isPrimeNumber(long target) {
        //지금까지 나온 모든 소수로 나눈다.
        //만약 나누어 질 경우 소수가 아니다.
        for (long prevPrimeNumber : primeNumbers) {
            if (target % prevPrimeNumber == 0)
                return false;
        }
        return true;
    }

    public List<Long> getPrimeNumbers() {
        return primeNumbers;
    }

    public int getPrimeNumbersSize() {
        return primeNumbers.size();
    }


}
