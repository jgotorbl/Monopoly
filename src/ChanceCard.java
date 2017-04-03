import java.util.Random;

/**
 * Created by Jaime on 3/24/2017.
 */
public enum ChanceCard {
    GO_TO_JAIL("Go directly to Jail", 0),
    BANK_DIVIDEND("Bank pays you dividend of 50 credits", 50),
    GO_BACK("Go back 3 spaces", 0),
    CROSSWORD_COMPETITION("You have won a crossword competition. Collect 10 credits", 10),
    CHAIRMAN_OF_BOARD("You have been elected Chairman of the Board. Collect 100 credits", 100);

    String s;
    int i;

    private ChanceCard(String s, int i){
        this.s = s;
        this.i = i;
    }

    public String getS(){return s;}

    public int getI(){return i;}

    public static ChanceCard pickCard(){

        Random rn = new Random();
        int index = rn.nextInt(ChanceCard.values().length);
        ChanceCard cardPicked = ChanceCard.values()[index];
        return cardPicked;
    }
}
