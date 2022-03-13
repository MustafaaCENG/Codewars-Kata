package KatasSolution;
public class TakeWalkTime{

        public static boolean isValid(char[] walk) {
            int n = 0;
            int s = 0;
            int e = 0;
            int w = 0;
            if (walk.length != 10){
                return false; }
            for (int i = 0 ; i< walk.length ; i++){
                switch (walk[i])    {
                    case 'n':
                        n++;
                        break;
                    case 'w':
                        w++;
                        break;
                    case 'e':
                        e++;
                        break;
                    case 's':
                        s++;
                        break;
                    default:
                        break;
                }
            }
            if (n == s && w == e){
                return true;
            }
            if (n == s && w != e){
                return false;
            }
            if (n != s && w == e){
                return false;
            }
            else
                return false;

        }}
