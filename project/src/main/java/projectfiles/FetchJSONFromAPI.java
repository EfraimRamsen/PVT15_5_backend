package projectfiles;

import com.google.gson.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class FetchJSONFromAPI{
	HashMap<Integer, OutdoorGym> outdoorGymHashMap = new HashMap<>();

	public void parse(){
		try {
			URL url = new URL(
				"http://api.stockholm.se/ServiceGuideService/ServiceUnitTypes/96a67da3-938b-487e-ac34-49b155cb277b/ServiceUnits/json?apikey=52f545a2957c4615a67ac2025ad9795f");
			InputStreamReader reader = new InputStreamReader(url.openStream());
			JsonParser parser = new JsonParser();
			JsonElement rootElement = parser.parse(reader);
			JsonArray rootAsArray = rootElement.getAsJsonArray();

			for(int i = 0; i < rootAsArray.size(); i++){
				JsonObject position = rootAsArray.get(i).getAsJsonObject().getAsJsonObject("GeographicalPosition");
				String gymName = rootAsArray.get(i).getAsJsonObject().get("Name").getAsString();
				Location l = parseLocation(position);
				String gymDescription = "This is gym no. " + i; //TODO Get real description from API
				parseGym(i,l,gymName,gymDescription);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Location parseLocation(JsonObject position){
		int x = position.get("X").getAsInt();
		int y = position.get("Y").getAsInt();
		Location location = new Location(x,y);
		return location;
	}

	public void parseGym(int i, Location position, String gymName, String gymDescription){
		outdoorGymHashMap.put(i, new OutdoorGym(position,gymName,gymDescription));
	}

}