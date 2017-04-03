/**
 * Created by Jaime on 3/19/2017.
 */
public class Property extends Space {
    public Property(int boardIndex, String name, int credits){
        super(boardIndex, name, credits);
    }

    @Override
    public int getCredits(){
        System.out.println(super.getName() + " awards " + super.getCredits() + " credits.");
        return super.getCredits();
    }
}
