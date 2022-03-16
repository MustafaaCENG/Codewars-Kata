package KatasSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PokerHand {
    public enum Result {TIE, WIN, LOSS}

    private final String[] KINDA = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    private String[] kartlar;
    private int[] turler = new int[5];
    private int rank;
    private ArrayList<Integer> typies = new ArrayList<Integer>();

    public PokerHand(String cardsString) {
        this.kartlar = cardsString.split(" ");

        Arrays.sort(kartlar, new Comparator<String>() {


            public int compare(String o1, String o2) {
                int kind1 = Arrays.asList(KINDA).indexOf(o1.substring(0, 1));
                int kind2 = Arrays.asList(KINDA).indexOf(o2.substring(0, 1));
                return kind1 - kind2;
            }

        });

        for (int i = 0; i < this.kartlar.length; i++) {
            this.turler[i] = getKind(kartlar[i]);
        }

        boolean isStraight = isStraight();
        boolean isFlush = isFlush();

        if (isStraight && isFlush) {
            this.rank = 8;
        } else if (isFourCard()) {
            this.rank = 7;
        } else if (isThreeCard()) {
            if (isFullHouse()) {
                this.rank = 6;
            } else {
                this.rank = 3;
            }
        } else if (isFlush) {
            this.rank = 5;
            for (int i = this.turler.length - 1; i >= 0; i--) {
                this.typies.add(this.turler[i]);
            }
        } else if (isStraight) {
            this.rank = 4;
        } else if (isTwoPairs()) {
            this.rank = 2;
        } else if (isOnePair()) {
            this.rank = 1;
        } else {
            this.rank = 0;
            for (int i = this.turler.length - 1; i >= 0; i--) {
                this.typies.add(this.turler[i]);
            }
        }
    }

    public int getRank() {
        return this.rank;
    }

    public ArrayList<Integer> getTypies() {
        return this.typies;
    }

    private int getKind(String card) {
        int kind = Arrays.asList(KINDA).indexOf(card.substring(0, 1));
        return kind;
    }

    private boolean isStraight() {
        boolean isStraight = true;

        for (int i = 0; i < this.kartlar.length - 1; i++) {
             if (this.turler[i + 1] != this.turler[i] + 1) {
                 if (this.turler[i] == 3 && this.turler[i + 1] == 12) {
                    return true;
                }
                // normal cases
                return false;
            }
        }

        if (this.turler[3] == 3 && this.turler[4] == 12) {
            this.typies.add(this.turler[3]);
        } else {
            this.typies.add(this.turler[4]);
        }

        return isStraight;
    }

    private boolean isFlush() {
        boolean isFlush = true;
        for (int i = 0; i < this.kartlar.length - 1; i++) {
             if (!kartlar[i].substring(1, 2).equals(kartlar[i + 1].substring(1, 2))) {
                return false;
            }
        }
        return isFlush;
    }

    private boolean isFourCard() {
         if (this.turler[1] == this.turler[0] && this.turler[2] == this.turler[0] &&
                this.turler[3] == this.turler[0]) {
            this.typies.add(this.turler[0]);
            this.typies.add(this.turler[4]);
            return true;
        }

        // second case, 2 to 5 cards
        if (this.turler[2] == this.turler[1] && this.turler[3] == this.turler[1] &&
                this.turler[4] == this.turler[1]) {
            this.typies.add(this.turler[1]);
            this.typies.add(this.turler[0]);
            return true;
        }

        return false;
    }

    private boolean isThreeCard() {
        if (this.turler[1] == this.turler[0] && this.turler[2] == this.turler[0]) {
            this.typies.add(this.turler[0]);
            return true;
        }

        if (this.turler[2] == this.turler[1] && this.turler[3] == this.turler[1]) {
            this.typies.add(this.turler[1]);
            return true;
        }

        if (this.turler[3] == this.turler[2] && this.turler[4] == this.turler[2]) {
            this.typies.add(this.turler[2]);
            return true;
        }

        return false;
    }

    private boolean isFullHouse() {
        // first case, 1 to 3 cards
        if (this.typies.get(0) == this.turler[0]) {
            // another pair
            if (this.turler[3] == this.turler[4]) {
                this.typies.add(this.turler[3]);
                return true;
            } else {
                this.typies.add(this.turler[4]);
                this.typies.add(this.turler[3]);
                return false;
            }
        }

        if (this.typies.get(0) == this.turler[1]) {
            this.typies.add(this.turler[4]);
            this.typies.add(this.turler[0]);
            return false;
        }

        if (this.typies.get(0) == this.turler[2]) {
             if (this.turler[0] == this.turler[1]) {
                this.typies.add(this.turler[0]);
                return true;
            } else {
                this.typies.add(this.turler[1]);
                this.typies.add(this.turler[0]);
                return false;
            }
        }

        return false;
    }

    private boolean isTwoPairs() {
        if (this.turler[0] == this.turler[1] && this.turler[2] == this.turler[3]) {
            this.typies.add(this.turler[2]);
            this.typies.add(this.turler[0]);
            this.typies.add(this.turler[4]);
            return true;
        }

        if (this.turler[0] == this.turler[1] && this.turler[3] == this.turler[4]) {
            this.typies.add(this.turler[3]);
            this.typies.add(this.turler[0]);
            this.typies.add(this.turler[2]);
            return true;
        }

        if (this.turler[1] == this.turler[2] && this.turler[3] == this.turler[4]) {
            this.typies.add(this.turler[3]);
            this.typies.add(this.turler[1]);
            this.typies.add(this.turler[0]);
            return true;
        }

        return false;
    }

    private boolean isOnePair() {
         if (this.turler[0] == this.turler[1]) {
            this.typies.add(this.turler[0]);
            this.typies.add(this.turler[4]);
            this.typies.add(this.turler[3]);
            this.typies.add(this.turler[2]);
            return true;
        }

        if (this.turler[1] == this.turler[2]) {
            this.typies.add(this.turler[1]);
            this.typies.add(this.turler[4]);
            this.typies.add(this.turler[3]);
            this.typies.add(this.turler[0]);
            return true;
        }

        if (this.turler[2] == this.turler[3]) {
            this.typies.add(this.turler[2]);
            this.typies.add(this.turler[4]);
            this.typies.add(this.turler[1]);
            this.typies.add(this.turler[0]);
            return true;
        }

        if (this.turler[3] == this.turler[4]) {
            this.typies.add(this.turler[3]);
            this.typies.add(this.turler[2]);
            this.typies.add(this.turler[1]);
            this.typies.add(this.turler[0]);
            return true;
        }

        return false;
    }

    private static Result compare(ArrayList<Integer> listecik1, ArrayList<Integer> listecik2, int length) {
        for (int i = 0; i < length; i++) {
            if (listecik1.get(i) > listecik2.get(i)) {
                return Result.WIN;
            } else if (listecik1.get(i) < listecik2.get(i)) {
                return Result.LOSS;
            }
        }

        return Result.TIE;
    }

    public Result compareWith(PokerHand el) {
        if (this.rank > el.getRank()) {
            return Result.WIN;
        } else if (this.rank < el.getRank()) {
            return Result.LOSS;
        } else {
            switch (this.rank) {
                case 8:
                case 4:
                    return compare(this.getTypies(), el.getTypies(), 1);
                case 7:
                case 6:
                    return compare(this.getTypies(), el.getTypies(), 2);
                case 3:
                case 2:
                    return compare(this.getTypies(), el.getTypies(), 3);
                case 1:
                    return compare(this.getTypies(), el.getTypies(), 4);
                case 5:
                case 0:
                    return compare(this.getTypies(), el.getTypies(), 5);
                default:
                    return Result.TIE;
            }
        }
    }
}