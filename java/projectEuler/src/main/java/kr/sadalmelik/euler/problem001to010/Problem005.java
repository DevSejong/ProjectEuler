package kr.sadalmelik.euler.problem001to010;

/**
 * 1에서 10까지 모두로 나누어지는 가장 작은 수는 2520입니다.
 * 그렇다면 1~20까지 나누어지는 가장 작은수는 얼마인가요??
 */
public class Problem005 {

    //1~20까지 최소공배수 구하기.
    public static void main(String[] args) {
        long target = 1;
        for (long idx = 1; idx <= 20; idx++) {
            target = lcm(target, idx);
        }
        System.out.println(target);
    }

    //최대공약수.
    private static long gcd(long p, long q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    private static long lcm(long p, long q) {
        return p * q / gcd(p, q);
    }

}
