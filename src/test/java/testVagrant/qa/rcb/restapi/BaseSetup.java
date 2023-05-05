package testVagrant.qa.rcb.restapi;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import testVagrant.qa.rcb.constants.Constants;
import java.io.FileReader;
import java.io.IOException;

public class BaseSetup {

    public JSONObject jsonData;

    @BeforeClass
    public JSONObject retrieveJSON() throws IOException, ParseException {
        FileReader reader = new FileReader(Constants.JSONPATH);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(reader);
        jsonData = (JSONObject) obj;
        return jsonData;
    }



}