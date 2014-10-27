package kr.sadalmelik;

/**
 * 1부터 10까지 자연수를 각각 제곱해 더하면 다음과 같습니다 (제곱의 합).
 * 12 + 22 + ... + 102 = 385
 * 1부터 10을 먼저 더한 다음에 그 결과를 제곱하면 다음과 같습니다 (합의 제곱).
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * 따라서 1부터 10까지 자연수에 대해 "합의 제곱"과 "제곱의 합" 의 차이는 3025 - 385 = 2640 이 됩니다.
 * 그러면 1부터 100까지 자연수에 대해 "합의 제곱"과 "제곱의 합"의 차이는 얼마입니까?
 */
public class Problem006 {

    public static void main(String[] args){
        System.out.println(sumAndSquare(100) - squareAndSum(100));
    }

    private static long squareAndSum(long lastNumber){
           long result = 0;
          for(long idx= 1; idx<=lastNumber;idx++){
            result += idx* idx;
          }

        return result;
    }


    private static long sumAndSquare(long lastNumber){
        long result = 0;
        for(long idx= 1; idx<=lastNumber;idx++){
            result += idx;
        }

        return result* result;
    }
}