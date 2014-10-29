package kr.sadalmelik.euler.problem001to010;

import kr.sadalmelik.euler.util.PrimeNumberGenerator;

/**
 * Created by SejongPark on 14. 10. 28..
 * <p>
 * 10 이하의 소수를 모두 더하면 2 + 3 + 5 + 7 = 17 이 됩니다.
 * 이백만(2,000,000) 이하 소수의 합은 얼마입니까?
 */
public class Problem010 {
    public static void main(String[] args) {
        Long primeSum = 0L;
        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();

        //리팩토링
        while (primeNumberGenerator.generateNext() < 2 * 1000 * 1000) {
            //doNotiong
        }

        primeNumberGenerator.getPrimeNumbers().stream().reduce(0L, (a, b) -> a + b);
        System.out.println(primeSum);
    }
}
