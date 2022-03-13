import static org.junit.Assert.assertEquals;

class Fighter {

    public String name;
    public int health, damagePerAttack;

    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;}
    public static class Kata {
        public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
            if (firstAttacker.equals(fighter2.name)) {
                while (fighter1.health > 0 && fighter2.health > 0) {
                    fighter1.health = fighter1.health - fighter2.damagePerAttack;
                    if (fighter1.health <= 0) return fighter2.name;
                    fighter2.health = fighter2.health - fighter1.damagePerAttack;
                    if (fighter2.health <= 0) return fighter1.name;}
            } else {
                while (fighter1.health > 0 && fighter2.health > 0) {
                    fighter2.health = fighter2.health - fighter1.damagePerAttack;
                    if (fighter2.health <= 0) return fighter1.name;
                    fighter1.health = fighter1.health - fighter2.damagePerAttack;
                    if (fighter1.health <= 0) return fighter2.name;
                }
            }
            return "";
        }

        public static void main(String[] args) {
            Fighter girl = new Fighter("kseniya", 10, 2);
            Fighter girl2 = new Fighter("kseniya2", 5, 4);
            System.out.println(declareWinner(girl, girl2, girl2.name));
        }
    }
}
