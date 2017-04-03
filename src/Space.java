/**
 * Created by Jaime on 3/19/2017.
 */
public abstract class Space {
    private int boardIndex;
    private String name;
    private int credits;

    public Space(int boardIndex, String name, int credits){
        this.boardIndex = boardIndex;
        this.name = name;
        this.credits = credits;
    }

    public Space(int boardIndex, String name) {
        this.boardIndex = boardIndex;
        this.name = name;
    }


    public int getBoardIndex(){
        return  boardIndex;
    }

    public void setBoardIndex(int boardIndex) {
        this.boardIndex = boardIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.boardIndex + ", " + this.name + ", " + this.credits;
    }

    public int getCredits() {
        return credits;
    }
}
