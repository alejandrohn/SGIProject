package videoHelpers;

public class ReproductionRequestData {

    private final int videoId;
    private final String username;
    private final String password;

    public ReproductionRequestData(int videoId, String username, String password) {
        this.videoId = videoId;
        this.username = username;
        this.password = password;
    }

    public int getVideoId() {
        return videoId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
