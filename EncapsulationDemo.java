package KatasSolution;

public class EncapsulationDemo{
    private int number;
    private String stringValue;
    private Object anObject;

    public EncapsulationDemo(){}
    public EncapsulationDemo(int number, String stringValue, Object anObject){
        this.anObject = anObject;
        this.number = number;
        this.stringValue = stringValue;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Object getAnObject() {
        return anObject;
    }

    public void setAnObject(Object anObject) {
        this.anObject = anObject;
    }
}