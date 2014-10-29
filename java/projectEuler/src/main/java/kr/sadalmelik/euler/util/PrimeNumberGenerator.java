package kr.sadalmelik.euler.util;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {
        List<Long> primeNumbers;

        public PrimeNumberGenerator() {
            primeNumbers = new ArrayList<Long>();

            //소수의 시작은 2이다.
            primeNumbers.add(2L);
        }

        public long generateNext() {
            long target = primeNumbers.get(primeNumbers.size() - 1);
            boolean isPrimeNumber = false;

            //리스트의 마지막 숫자에서 1을 더하면서 primeNumber인지 확인한다.
            while (isPrimeNumber == false) {
                target += 1;

                if (isPrimeNumber(target)) {
                    primeNumbers.add(target);
                    isPrimeNumber = true;
                }
            }

            return target;
        }

        private boolean isPrimeNumber(long target) {
            //지금까지 나온 모든 소수로 나눈다.
            //만약 나누어 질 경우 소수가 아니다.
            for (long prevPrimeNumber : primeNumbers) {
                if (target % prevPrimeNumber == 0)
                    return false;
            }
            return true;
        }

        public List<Long> getPrimeNumbers() {
            return primeNumbers;
        }

        public int getPrimeNumbersSize() {
            return primeNumbers.size();
        }


    }

