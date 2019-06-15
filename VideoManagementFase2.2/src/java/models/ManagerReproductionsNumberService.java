package models;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class ManagerReproductionsNumberService {

    private final static String urlForReproductionsNumberService = "http://localhost:8080/RESTVideoService/reproductions";
    private final static MediaType contentType = MediaType.get("application/json; charset=utf-8");
    private final static String responseFieldKey = "reproductionsNumber";

    public static int updateReproductionsNumber(int videoId, String username) throws JSONException, Exception {
        try {
            OkHttpClient client = new OkHttpClient();
            String password = getPassword(username);
            JSONObject bodyRequest = createBodyRequest(videoId, username, password);

            RequestBody body = RequestBody.create(contentType, bodyRequest.toString());
            Request requestClient = new Request.Builder().url(urlForReproductionsNumberService).post(body).build();

            try (Response responseClient = client.newCall(requestClient).execute()) {
                return new JSONObject(responseClient.body().string()).getInt(responseFieldKey);
            }
        } catch (Exception e) {
            throw new Exception("Error in service update reproduction number");
        }
    }

    private static String getPassword(String username) throws Exception {
        UsersManager userManager = new UsersManager();
        return userManager.getPasswordOfUser(username);
    }

    private static JSONObject createBodyRequest(int videoId, String username, String password) throws JSONException {
        JSONObject requestBody = new JSONObject();
        requestBody.put("videoId", videoId);
        requestBody.put("username", username);
        requestBody.put("password", password);
        return requestBody;
    }
}
