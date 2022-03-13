package KatasSolution;

public class Ghost {

        public String color;
        public Ghost(){
        }

        public String getColor() {
            int i = (int) (Math.random()*4);
            String [] renk = new String[] {"Yellow","white","purple","red"};
            return renk[i];
        }

        public void setColor(String color) {
            this.color = color;
        }
    }