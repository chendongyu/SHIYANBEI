import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class TestJSONPath {

	public static void main(String[] args) {
		String jsonText = " {\"board\":[{\"id\":1,\"players\":[2,1],\"decks\":[2,1],\"play\": {\"2\":{\"status\": \"playing\",\"handsize\":0,\"decksize\":40},\"1\":{\"status\": \"playing\",\"handsize\":0,\"decksize\":40}}}]}";
		DocumentContext dc = JsonPath.parse(jsonText);
		String query = " \"board.play.\"+2+\".decksize\"";
		List<Map<String, Object>> jPathResult = dc.read(query);
		System.out.println(jPathResult);
	}

}
