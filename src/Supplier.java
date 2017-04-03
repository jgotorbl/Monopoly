/**
 * Created by Jaime on 3/19/2017.
 */
public class Supplier extends Space{
    private static int multiplier;
    public Supplier(int boardIndex, String name, int multiplier){
        super(boardIndex, name);
        this.multiplier = multiplier;
    }



    public int getCredits(int[] dices) {
        int credits = 0;
        for(int i=0;i< dices.length; i++){
            credits += multiplier*dices[i];
        }
        System.out.println(super.getName() + " awards " +
                "(" + dices[0] + " + " + dices[1] + ") x "
                + multiplier + " = " + credits + " credits.");
        return credits;
    }


}
