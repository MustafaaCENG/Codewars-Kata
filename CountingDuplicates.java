package KatasSolution;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        int count = 0;
        text = text.toLowerCase();
        String[] textArray = text.split("");
        for(int i = 0; i < textArray.length; i++){
            for(int b = i + 1; b < textArray.length; b++){
                if(i == -1) {
                    i = 0;
                    b = 1;
                }
                if(textArray[i].equals(textArray[b])) {
                    count += + 1;
                    text = text.replace(textArray[i], "");
                    textArray = text.split("");
                    if (i != 0){
                        i = i - 1;
                    }else{
                        i = -1;
                    }
                }
            }
        }
        return count;
    }
}