package models;

import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import models.Video;
import java.sql.Date;
import java.sql.SQLException;

public class VideoList extends ResourceManager {

    private String QUERY_ALL_VIDEOS = "SELECT * FROM VIDEOS";

    public List<Video> getVideos() throws Exception {

        try {
            initConnectionDb();
            List<Video> videos = new ArrayList<>();
            PreparedStatement statementCheckUser = connection.prepareStatement(QUERY_ALL_VIDEOS);
            resultSet = statementCheckUser.executeQuery();
            while (resultSet.next()) {
                Video video = new Video();
                setVideo(video);
                videos.add(video);
            }

            return videos;

        } catch (Exception e) {
            closeConnection();
            throw new Exception("Error in check user");
        }
    }
}
