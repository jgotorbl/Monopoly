/**
 * Created by Jaime on 3/19/2017.
 */
public class CommunityChest extends Space {
    private static final int TYPES_OF_COMMUNITY_CARDS = CommunityChestCard.values().length;
    public CommunityChest(int boardIndex, String name){
        super(boardIndex, name);
    }

    public int getCredits(CommunityChestCard card) {
        System.out.println(card.getS());
        return card.getI();
    }
}

