package kr.sadalmelik.euler.problem011to020;

import java.util.*;

/**
 * 양의 정수 n에 대하여, 다음과 같은 계산 과정을 반복하기로 합니다.
 * n → n / 2 (n이 짝수일 때)
 * n → 3 n + 1 (n이 홀수일 때)
 * <p>
 * 13에 대하여 위의 규칙을 적용해보면 아래처럼 10번의 과정을 통해 1이 됩니다.
 * <p>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * 아직 증명은 되지 않았지만, 이런 과정을 거치면 어떤 수로 시작해도 마지막에는 1로 끝나리라 생각됩니다.
 * (역주: 이것은 콜라츠 추측 Collatz Conjecture이라고 하며, 이런 수들을 우박수 hailstone sequence라 부르기도 합니다)
 * <p>
 * 그러면, 백만(1,000,000) 이하의 수로 시작했을 때 1까지 도달하는데 가장 긴 과정을 거치는 숫자는 얼마입니까?
 * <p>
 * 참고: 계산 과정 도중에는 숫자가 백만을 넘어가도 괜찮습니다.
 */
public class Problem014 {

    public static void main(String[] args) {
        HailstoneSequence hailstoneSequence = new HailstoneSequence();
        List<Integer> longestNumberList = new ArrayList<>();

        for (int i = 1; i <= 1 * 1000 * 1000; i++) {
            List<Integer> seqList = hailstoneSequence.getList(i);
            if(seqList.size() >= longestNumberList.size()){
                longestNumberList = seqList;
            }

            if(i % 1000 == 0){
                System.out.println(seqList);
            }
        }
        System.out.println(longestNumberList);
    }
}

class HailstoneSequence {
    Map<Integer, List<Integer>> hailstoneSequenceList = new HashMap<>();

    public List<Integer> getList(int number) {
        int target = number;

        List<Integer> resultList = new ArrayList<>();
        resultList.add(number);
        while (target != 1) {
            if (hailstoneSequenceList.containsKey(target)) {
                resultList.addAll(hailstoneSequenceList.get(target));
                break;
            } else {
                if (target % 2 == 0)
                    target = target / 2;
                else
                    target = target * 3 + 1;

                resultList.add(target);
            }

        }
        hailstoneSequenceList.put(number, resultList);
        return resultList;
    }


}
