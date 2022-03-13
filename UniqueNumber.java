package KatasSolution;

public class UniqueNumber {
    public static double findUniq(double arr[]) {
        double ans = 0;
        for (int i =0; i<arr.length;i++){
            if (arr[i] != arr[i+1]) {
                return arr[i + 1];
            }
            else ans = arr[i];
        }
        return ans;
    }}
