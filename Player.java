package KatasSolution;

import java.util.*;

interface RockPaperScissorsPlayer {
    // Your name as displayed in match results.
    String getName();

    // Used by playground to notify you that a new match will start.
    void setNewMatch(String opponentName);

    // Used by playground to get your game shape (values: "R", "P" or "S").
    String getShape();

    // Used by playground to inform you about the shape your opponent played in the game.
    void setOpponentShape(String shape);
}


class Player implements RockPaperScissorsPlayer {
    private Random random;

    public Player() {
        random = new Random();
    }

    public String getName() {
        return "MyPlayer";
    }

    public void setNewMatch(String opponentName) {
    }

    public String getShape() {
        switch (random.nextInt(3)) {
            case 1:
                return "P";
            case 2:
                return "R";
            default:
                return "S";
        }
    }

    public void setOpponentShape(String shape) {

    }
}