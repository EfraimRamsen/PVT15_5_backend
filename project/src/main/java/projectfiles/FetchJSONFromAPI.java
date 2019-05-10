package projectfiles;

import com.google.gson.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

/**
 * Fetches JSON-objects from the Stockholm API and parses them by looping through the
 * array of JSON-objects and mapping the keys and values into a new java object.
 *
 * @author Efraim (& Edvin)
 */
public class FetchJSONFromAPI{
	private HashMap<Integer, OutdoorGym> outdoorGymHashMap = new HashMap<>();
//	private String uniqueId = "234oij-234-234234 (test)";
	/**
	 * Fetches a list of all outdoor gyms in Stockholm and loops through it to create
	 * OutdoorGym objects that are stored in the outdoorGymHashmap.
	 */
	public void parseFromAllOutdoorGyms(){
		try {
			//URL with a list of all outdoor gyms in Stockholm
			URL url = new URL(
				"http://api.stockholm.se/ServiceGuideService/ServiceUnitTypes/96a67da3-938b-487e-ac34-49b155cb277b/ServiceUnits/json?apikey=52f545a2957c4615a67ac2025ad9795f");
			InputStreamReader reader = new InputStreamReader(url.openStream());
			JsonParser parser = new JsonParser();
			JsonElement rootElement = parser.parse(reader);
			JsonArray rootAsArray = rootElement.getAsJsonArray();

			for(int i = 0; i < rootAsArray.size(); i++){
				JsonObject position = rootAsArray.get(i).getAsJsonObject().getAsJsonObject("GeographicalPosition");
				String gymName = rootAsArray.get(i).getAsJsonObject().get("Name").getAsString();
				String uniqueId = rootAsArray.get(i).getAsJsonObject().get("Id").getAsString();
				Location l = parseLocation(position);
				String gymDescription = "This is gym no. " + i; //TODO Get real description from API
				parseGym(i, l, gymName, uniqueId, gymDescription);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** ~~WORK IN PROGRESS!~~
	 * Gå in i gruppen "Attributes"
	 *
	 * OM "Name" == "Introduktion"
	 * Ta nästa "Value" som String description
	 *
	 * @param uniqueId
	 * @return
	 */
	public String parseDescription(String uniqueId){
			String description = null;
		try {
			URL url = new URL("http://api.stockholm.se/ServiceGuideService/DetailedServiceUnits/json?apikey=52f545a2957c4615a67ac2025ad9795f&ids="
			+ uniqueId);
			InputStreamReader reader = new InputStreamReader(url.openStream());
			JsonParser parser = new JsonParser();
			JsonElement rootElement = parser.parse(reader);
			JsonArray rootAsArray = rootElement.getAsJsonArray();
//			JsonArray attributesArray = rootAsArray.get(0);

			for(int i = 0; i < rootAsArray.size(); i++){
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
		return description;
	}

	/**
	 * Fetches the values from X & Y in the API and returns a Location object created from
	 * those values.
	 * @param position
	 * @return Location location
	 */
	public Location parseLocation(JsonObject position){
		int x = position.get("X").getAsInt();
		int y = position.get("Y").getAsInt();
		Location location = new Location(x,y);
		return location;
	}

	/**
	 * Creates a new OutdoorGym from the parameters and stores it in the outdoorGymHashMap
	 * @param i
	 * @param position
	 * @param gymName
	 * @param gymDescription
	 */
	public void parseGym(int i, Location position, String gymName, String uniqueId, String gymDescription){
		outdoorGymHashMap.put(i, new OutdoorGym(position,gymName,i, uniqueId, gymDescription));

		//TEST
		System.out.println(
				"\ngymLocation: " + position +
				"\ngymName: " + gymName +
				"\ngymId: "+ i +
				"\nuniqueId: " + uniqueId +
				"\ngymDescription: " + gymDescription +
						"\ndetailedAPIPage: http://api.stockholm.se/ServiceGuideService/DetailedServiceUnits/json?apikey=52f545a2957c4615a67ac2025ad9795f&ids="
							+ uniqueId);
	}

	public HashMap<Integer,OutdoorGym> getAllOutdoorGyms(){
		parseFromAllOutdoorGyms();
		return outdoorGymHashMap;
	}


}