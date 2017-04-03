/**
 * Created by Jaime on 3/19/2017.
 */
public class Chance extends Space{
    public Chance(int boardIndex, String name){
        super(boardIndex, name);
    }

    public int getCredits(ChanceCard card){
        System.out.println(card.getS());
        return card.getI();
    }
}
