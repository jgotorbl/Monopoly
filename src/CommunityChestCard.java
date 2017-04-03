import java.util.Random;

/**
 * Created by Jaime on 3/24/2017.
 */
public enum CommunityChestCard {
    BANK_ERROR("Bank error in your favor. Collect 200 credits", 200),
    SALE_OF_STOCK("From sale of stock, you get 50 credit.", 50),
    GOTOJAIL("Go to Jail", 0),
    HOLIDAY_FUNDS("Holiday Fund matures. Receive 100 credits.", 100),
    INCOME_TAX_REFUND("Income tax refund. Collect 20 credits.", 20);

    private String s;
    private int i;

    private CommunityChestCard(String s, int i) {
        this.s = s;
        this.i = i;
    }

    public String getS(){return s;}

    public int getI(){return  i;}

    public static CommunityChestCard pickCard(){
        Random rn = new Random();
        int index = rn.nextInt(CommunityChestCard.values().length);
        CommunityChestCard cardPicked = CommunityChestCard.values()[index];
        return cardPicked;
    }
}
