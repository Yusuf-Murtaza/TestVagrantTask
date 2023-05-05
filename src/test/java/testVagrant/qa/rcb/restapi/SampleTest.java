package testVagrant.qa.rcb.restapi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import testVagrant.qa.rcb.constants.Constants;
import java.io.IOException;

public class SampleTest extends BaseSetup{


    @Test
    public void verifyInternationalPlayersTest() throws IOException, ParseException {
        int countInternationalPlayers = 0;
        JSONArray arrayData = (JSONArray) jsonData.get("player");
        for (int i = 0; i < arrayData.size(); i++) {
            JSONObject player = (JSONObject) arrayData.get(i);
            if (!player.get("country").equals("India")) {
                countInternationalPlayers = countInternationalPlayers + 1;
            }
        }
        Assert.assertTrue(countInternationalPlayers==4, Constants.internationalPlayerCountFailureMessage);
    }

    @Test
    public void verifyWicketKeeperCount() throws IOException, ParseException {
        int countWicketKeepers = 0;
        JSONArray arrayData = (JSONArray) jsonData.get("player");
        for (int i = 0; i < arrayData.size(); i++) {
            JSONObject player = (JSONObject) arrayData.get(i);
            if (player.get("role").equals("Wicket-keeper")) {
                countWicketKeepers = countWicketKeepers + 1;
            }
        }
        Assert.assertTrue(countWicketKeepers>=1, Constants.wicketKeeperCountFailureMessage);
    }

}
