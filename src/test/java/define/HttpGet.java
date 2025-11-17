package define;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class HttpGet {

    private static List<Map<String, String>> data;
    private static int currentRowIndex = 0;

    public static void main(String... args) throws Exception {
        loadDataFromApi();
    }


    public static void loadDataFromApi() throws Exception {
        String url = "http://10.121.203.2:7111/api/getData";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            System.out.println("API success: " + response.statusCode());
            String responseBody = response.body();
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> responseMap = objectMapper.readValue(responseBody, Map.class);
            Object dataObj = responseMap.get("data");
            data = (List<Map<String, String>>) dataObj;
            System.out.println("data from api");
        } else {
            throw new RuntimeException("Getting error from api");
        }

    }


    public static Map<String, String> getNextRow() {
        System.out.println("Getting row at: " + currentRowIndex);
        if (currentRowIndex >= data.size()) {
            System.out.println("No more rows to read.");
            return null;
        }
        Map<String, String> rowData = data.get(currentRowIndex);
        currentRowIndex++;
        return rowData;
    }

    public static boolean hasNextRow() {
        return currentRowIndex < data.size();
    }
}
