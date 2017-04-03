import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.*;
/**
 * Created by Jaime on 3/19/2017.
 */
public class DataParser {
    public static Space[] parseInitialData(String filepath){
        ArrayList<Space> spaces = new ArrayList<>();

        try {
            FileReader dataFile = new FileReader(filepath);
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(dataFile);
            for(int i=0;i< jsonArray.size(); i++){
                JSONObject object = (JSONObject) jsonArray.get(i); //each space of the board
                spaces.add(returnProperty(object, i));
            }
            Space[] board = spaces.toArray(new Space[spaces.size()]);
            return board;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Space returnProperty(JSONObject object, int i){
        String spaceType = (String) object.get("spaceType");
        switch(spaceType){
            case "Property":
                return new Property(i,(String) object.get("name"),(int) (long) object.get("credits"));
            case "Railroad":
                return new Railroad(i, (String) object.get("name"));
            case "TaxOffice":
                return new TaxOffice(i, (String) object.get("name"), (int) (long) object.get("credits"));
            case "Supplier":
                return new Supplier(i, (String) object.get("name"), (int) (long) object.get("credits"));
            case "CommunityChest":
                return new CommunityChest(i, (String) object.get("name"));
            case "Chance":
                return new Chance(i, (String) object.get("name"));
            case "Other":
                return new Other(i, (String) object.get("name"), (int) (long) object.get("credits"));
        }
        return null;
    }

}
