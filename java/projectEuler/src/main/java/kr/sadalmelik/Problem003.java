package kr.sadalmelik;

import java.util.List;

/**
 * 어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고, 이 소수들을 그 수의 소인수라고 합니다.
 * 예를 들면 13195의 소인수는 5, 7, 13, 29 입니다.
 * <p/>
 * 600851475143의 소인수 중에서 가장 큰 수를 구하세요.
 */
public class Problem003 {
    public static void main(String... args) {
        long target = 600851475143L;
        long divideNum = 2;

        while (target != 1) {

            System.out.println(divideNum);

            if (isPrime(divideNum)) {
                if (target % divideNum == 0) {
                    target = target / divideNum;
                    System.out.println("target = " + target + "  divideNum = " + divideNum);
                    continue;
                }
            }

            System.out.println("aaa" + divideNum);
            divideNum += 1;
        }
    }

    //최적화는 귀찮다..
    public static boolean isPrime(long num) {
        if(num==2){
            return true;
        }
        for (int i = 2; i <= (num + 1) / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
