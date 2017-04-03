/**
 * Created by Jaime on 3/19/2017.
 * Java class for Jail Visiting or Free Parking
 */
public class Other extends Space{
    public Other(int boardIndex, String name, int credits){
        super(boardIndex, name, credits);
    }

    public int getCredits(){
        return 0;
    }
}
