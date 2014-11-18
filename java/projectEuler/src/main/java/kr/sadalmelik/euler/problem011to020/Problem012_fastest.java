package kr.sadalmelik.euler.problem011to020;

/**
 * Created by SejongPark on 14. 11. 3..
 * //이건 분석 필요함.
 */
public class Problem012_fastest {
    private static int countFactors(int f) {
        int factors = 0;

        for (int i = 1; i <= Math.sqrt(f); i++) {
            if (f % i == 0)
                factors += 2;
        }

        return factors;
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int iter = 1;
        int size = 1;
        int NumFactors = 0;

        while (NumFactors <= 500) {
            NumFactors = countFactors(size);
            iter++;
            size += iter;
        }

        System.out.println(size - iter);
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
    }
}