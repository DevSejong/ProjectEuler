package kr.sadalmelik;

/*
 * http://euler.synap.co.kr/prob_detail.php?id=2
 * 피보나치 수열의 각 항은 바로 앞의 항 두 개를 더한 것이 됩니다. 1과 2로 시작하는 경우 이 수열은 아래와 같습니다.
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 짝수이면서 4백만 이하인 모든 항을 더하면 얼마가 됩니까?
 */
public class Problem002 {
    public static void main(String[] args){
        int fibonacciNum0 = 1;
        int fibonacciNum1 = 2;
        long underFourMillionFibonacciSum = 0;

        while (fibonacciNum1<4000000){
            if(fibonacciNum1 %2 ==0){
                underFourMillionFibonacciSum += fibonacciNum1;
            }

            int fibonacciTemp;

            fibonacciTemp = fibonacciNum0 + fibonacciNum1;

            fibonacciNum0 = fibonacciNum1;
            fibonacciNum1 = fibonacciTemp;

        }

        System.out.println(underFourMillionFibonacciSum);

    }
}
