package KatasSolution;
import java.util.Arrays;

class PhotoManager {

    public static String generateName(PhotoManager photoManager) {
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'S', 'O', 'P', 'R', 'S', 'T', 'W', 'X', 'Z'};
        char[] array = new char[6];
        for (int i = 0; i < 6; i++) {
            char next = chars[(int) (Math.random() * chars.length - 1)];
            array[i] = next;
        }
        for (char gel : array) {
            System.out.print(gel);
        }
        return Arrays.toString(array);
    }
}