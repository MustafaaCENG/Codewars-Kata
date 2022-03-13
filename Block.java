package KatasSolution;

public class Block {
    private int width;
    private int length;
    private int height;

    public Block (int[] arr){
        width = arr[0];
        length = arr[1] ;
        height = arr[2] ;

    }
    public int getSurfaceArea(){
        return (2 * height * length) + (2 *height * width) + (2* length * width);
    }

    public int getVolume(){
        return height * length * width;
    }

    public int getWidth() {
        return width;
    }


    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }


}

