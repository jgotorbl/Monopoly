import org.junit.Test;

import static org.junit.Assert.*;


import java.io.IOException;

/**
 * Created by Jaime on 3/25/2017.
 */
public class MonopolyTest {
    private static String DATA_PATH;
    Game game;
    Player player;
    public void monopolyInit(){
        try {
            DATA_PATH = new java.io.File( "." ).getCanonicalPath()+  "\\BoardData.json";
            game = new Game(DataParser.parseInitialData(DATA_PATH));
            player = new Player(game);
            player.setCredit(0);
            player.setToken(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void landingOnOrientalAvenuePays100Credits(){
        monopolyInit();
        int[] dices ={2,4};
        player.play(dices, game.getBoard());
        assertEquals(player.getCredit(), 100);
    }

    @Test
    public void landingOnReadingRaildRoadPays200Credits() {
        monopolyInit();
        int[] dices ={2,3};
        player.play(dices, game.getBoard());
        assertEquals(200, player.getCredit());
    }

    @Test
    public void testAllRailroads() {
        monopolyInit();
        int[] dices =new int[]{2,3};
        player.play(dices, game.getBoard());
        dices = new int[]{5, 5};
        player.play(dices, game.getBoard());
        player.play(dices, game.getBoard());
        player.play(dices, game.getBoard());
        assertEquals(2000, player.getCredit());
    }

    @Test
    public void landingOnLuxuryTaxPays100Credits() {
        monopolyInit();
        int[] dices =new int[]{0,38};
        player.play(dices, game.getBoard());
        assertEquals(100, player.getCredit());
        System.out.println("Test OK");
    }
    @Test
    public void landingOnIncomeTaxPays200Credits() {
        monopolyInit();
        int[] dices =new int[]{1,3};
        player.play(dices, game.getBoard());
        assertEquals(200, player.getCredit());
        System.out.println("Test OK");
    }

    @Test
    public void landingOnElectricCompanyWith2And4Pays30Credits() {
        //Given
        monopolyInit();
        int[] dices =new int[]{6,6};
        player.play(dices, game.getBoard());


        assertEquals(120, player.getCredit());
    }
    @Test
    public void landingOnWaterWorksWith2And3Pays50Credits() {
        //Given
        monopolyInit();
        int[] dices =new int[]{28,0};
        player.play(dices, game.getBoard());
        assertEquals(280, player.getCredit());
    }

}
