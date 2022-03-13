package KatasSolution;
// KYU 6

public class Multiple3or5 {
    public static int solution(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (i%3 == 0 || i % 5 == 0){
                sum +=i;
            }

        }
        return sum;
    }
}


