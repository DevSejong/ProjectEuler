package kr.sadalmelik.euler.problem001to010;

import kr.sadalmelik.euler.util.PrimeNumberGenerator;

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

