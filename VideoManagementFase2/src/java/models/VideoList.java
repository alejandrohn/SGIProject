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

    private void setVideo(Video v) throws SQLException {
        v.title = resultSet.getString("title");
        v.autor = resultSet.getString("autor");
        v.format = resultSet.getString("format");
        v.description = resultSet.getString("description");
        v.reproductionNumber = resultSet.getInt("reproductions");
        v.createdDate = resultSet.getDate("createdDate");
        v.duration = resultSet.getTime("duration");
        v.videoPath = resultSet.getString("videoPath");
    }
}
