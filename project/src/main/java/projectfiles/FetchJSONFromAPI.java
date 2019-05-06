package projectfiles;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class FetchJSONFromAPI {
	private String name;
	private int x;
	private int y;

	public FetchJSONFromAPI(String url) throws IOException, URISyntaxException {
		this.name = name;
//		this.x = x;
//		this.y = y;

		URL urlFoReal = new URL(url);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		OutdoorGym outdoorGym = mapper.readValue(urlFoReal, OutdoorGym.class);
//		System.out.println(outdoorGym);
		Map<String,Object> jsonMap = mapper.readValue(urlFoReal, new TypeReference<Map<String,Object>>(){});
		System.out.println(jsonMap.toString());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
