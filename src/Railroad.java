/**
 * Created by Jaime on 3/19/2017.
 */
public class Railroad extends Space{
    private static int baseCredits = 200;

    public Railroad(int boardIndex, String name){
        super(boardIndex, name);
    }

    public int getCredits(int n){
        int nCredits = baseCredits*n;
        System.out.println(super.getName() + " awards " + n + " x " + baseCredits + " = " + nCredits + " credits");
        return nCredits;
    }


}
