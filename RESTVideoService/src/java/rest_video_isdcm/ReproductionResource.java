package rest_video_isdcm;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.json.JSONException;
import org.json.JSONObject;
import videoHelpers.ReproductionRequestData;
import videoHelpers.UserAuthorization;
import videoHelpers.VideoService;

@Path("")
public class ReproductionResource {

    private final String keyUnauthorizedUser = "error";
    private final String keyNotFound = "error";
    private final String messageUnauthorizedUser = "Unauthorized user, incorrect username or password";

    @GET
    @Produces("application/json")
    public String getJson() {
        return "<html><head/><body><h1>Hello World</h1></body></html>";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String content) throws JSONException, Exception {

        try {
            ReproductionRequestData newReproductionData = parseBodyJson(content);
            VideoService videoReproductionService = new VideoService();
            if (new UserAuthorization().validateUser(newReproductionData)) {
                videoReproductionService.updateReproductionsNumber(newReproductionData.getVideoId());
                return Response.ok(responseVideoReproductionsNumber(videoReproductionService).toString(), MediaType.APPLICATION_JSON).build();
            }
            return Response.status(Status.UNAUTHORIZED).entity(new JSONObject().put(keyUnauthorizedUser, messageUnauthorizedUser).toString()).build();
        } catch (Exception e) {
            return Response.status(Status.NOT_FOUND).entity(new JSONObject().put(keyNotFound, e.toString()).toString()).build();
        }
    }

    private ReproductionRequestData parseBodyJson(String content) throws JSONException {
        JSONObject requestBody = new JSONObject(content);
        ReproductionRequestData newReproductionData = new ReproductionRequestData(requestBody.getInt("videoId"), requestBody.getString("username"), requestBody.getString("password"));
        return newReproductionData;
    }

    private JSONObject responseVideoReproductionsNumber(VideoService videoReproductionService) throws JSONException {
        JSONObject responseReproductionsNumber = new JSONObject();
        responseReproductionsNumber.put("reproductionsNumber", videoReproductionService.getNewReproductionsNumber());
        return responseReproductionsNumber;
    }
}
