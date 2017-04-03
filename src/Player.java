/**
 * Created by Jaime on 3/19/2017.
 */
public class Player {
    private int railRoadVisits;
    private int token;
    private int credit;
    private Game game;

    public Player(Game game){
        this.railRoadVisits = 0;
        this.token = 0;
        this.credit = 0;
        this.game = game;
    }

    public void play(int[] dices, Space[] board) {
        token += dices[0] + dices[1];
        if(this.getToken() >= board.length){
            credit += 200;
            return;
        }
        Space sp = board[token];
        System.out.println("Player landed on: " + sp.getName());
        credit += creditAwarded(sp, dices);

    }

    private int creditAwarded(Space sp, int[] dices) {
        int creditsOnRound = 0;
        if(sp instanceof Property){
            creditsOnRound = ((Property) sp).getCredits();
        }else if(sp instanceof Railroad){
            if(this.railRoadVisits < 4) this.railRoadVisits++;
            creditsOnRound = ((Railroad) sp).getCredits(this.getRailRoadVisits());
        }else if(sp instanceof TaxOffice){
            creditsOnRound = ((TaxOffice) sp).getCredits();
        }else if(sp instanceof Supplier){
            creditsOnRound = ((Supplier) sp).getCredits(dices);
        }else if(sp instanceof CommunityChest){
            CommunityChestCard card = CommunityChestCard.pickCard();
            if(card == CommunityChestCard.GOTOJAIL){ this.setToken(10);}
            creditsOnRound = ((CommunityChest) sp).getCredits(card);
        }else if(sp instanceof Chance){
            ChanceCard card = ChanceCard.pickCard();
            creditsOnRound = getCreditsForChanceCard(sp, card, creditsOnRound, dices);
        }else{
            if(this.getToken() == 30) this.setToken(10);
            creditsOnRound = sp.getCredits();
        }
        return creditsOnRound;
    }

    private int getCreditsForChanceCard(Space sp, ChanceCard card, int creditsOnRound,int[] dices){

        if(card == ChanceCard.GO_TO_JAIL){
            this.setToken(10);
            creditsOnRound = ((Chance) sp).getCredits(card);
        }else if(card == ChanceCard.GO_BACK){
            int nextToken = this.getToken() - 3;
            this.setToken(nextToken);
            Space threeBackSpaces = this.game.getBoard()[nextToken];
            creditsOnRound = creditAwarded(threeBackSpaces, dices);
        }else{
            creditsOnRound = ((Chance) sp).getCredits(card);
        }
        return creditsOnRound;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public int getToken() {
        return token;
    }

    public int getRailRoadVisits() {
        return railRoadVisits;
    }

    public void setToken(int token) {
        this.token = token;
    }


}
