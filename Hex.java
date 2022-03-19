package KatasSolution;
class Hex {
    static int parse(String string) {
        return Integer.parseInt(string.replace("0x", ""), 16);
    }

    private final int value;
    // Via https://www.codewars.com/users/ParanoidUser

    Hex(int value) {
        this.value = value;
    }

    int valueOf() {
        return value;
    }

    Hex plus(Hex other) {
        return plus(other.value);
    }

    Hex plus(int number) {
        return new Hex(value + number);
    }

    Hex minus(Hex other) {
        return minus(other.value);
    }

    Hex minus(int number) {
        return new Hex(value - number);
    }

    String toJSON() {
        return toString();
    }

    @Override
    public String toString() {
        return "0x" + Integer.toHexString(value).toUpperCase();
    }


    @Override
    public boolean equals(Object o) {
        return value == ((Hex) o).value;
    }
}