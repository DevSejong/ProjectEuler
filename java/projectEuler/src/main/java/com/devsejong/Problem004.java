package com.devsejong;

/**
 * 앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 부릅니다.
 * 두 자리 수를 곱해 만들 수 있는 대칭수 중 가장 큰 수는 9009 (= 91 × 99) 입니다.
 * 세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 얼마입니까?
 */
public class Problem004 {
    public static void main(String... args) {
        int biggestNum = 0;
        for (int i = 1000 - 1; i >= 100; i--) {
            for (int j = 1000 - 1; j >= 100; j--) {
                int target = (i * j);
                if (isPalindrome(target) && target > biggestNum) {
                    biggestNum = target;
                }
            }
        }
        System.out.println(biggestNum);
    }

    public static boolean isPalindrome(long number) {
        long figureTarget = number;
        int figure = 0;
        while (figureTarget != 0) {
            figureTarget = figureTarget / 10;
            figure += 1;
        }

        for (int i = 0; i < figure / 2; i++) {
            if (getNumber(number, i) != getNumber(number, figure - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static int getNumber(Long number, int figure) {
        return Integer.valueOf(number.toString().substring(figure, figure + 1));
    }
}
