package kr.sadalmelik;

/**
 * Created by SejongPark on 14. 10. 28..
 * <p>
 * http://euler.synap.co.kr/prob_detail.php?id=9
 * <p>
 * 세 자연수 a, b, c 가 피타고라스 정리 a^2 + b^2 = c^2 를 만족하면 피타고라스 수라고 부릅니다 (여기서 a < b < c ).
 * 예를 들면 32 + 42 = 9 + 16 = 25 = 52이므로 3, 4, 5는 피타고라스 수입니다.
 * <p>
 * a + b + c = 1000 인 피타고라스 수 a, b, c는 한 가지 뿐입니다. 이 때, a × b × c 는 얼마입니까?
 */
public class Problem009 {

    public static int solve(int s) {

        for (int m = 2; m < Integer.MAX_VALUE; m++) {
            for (int n = 1; n < m; n++) {
                int a = m * m - n * n;
                int b = 2 * m * n;
                int c = m * m + n * n;
                if (s % (a + b + c) == 0) {
                    int k = s / (a + b + c);
                    return k * a * k * b * k * c;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solve(1000));
    }
}
