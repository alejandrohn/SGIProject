package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VideoPath extends ResourceManager {

    public Video getVideoToPlay(int videoId) throws Exception {

        String queryById = "SELECT * FROM VIDEOS WHERE ID = " + videoId;

        try {
            initConnectionDb();
            PreparedStatement resultVideoById = connection.prepareStatement(queryById);
            resultSet = resultVideoById.executeQuery();
            Video video = new Video();

            if (resultSet.next()) {
                setVideo(video);
                checkFormatAndSetVideoPath(video);
            }
            return video;

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new Exception("Error get Video by Id with path");
        }
    }

    private void checkFormatAndSetVideoPath(Video video) {
        if (isYoutubeOrVimeoFormat(video)) {
            setVideoPathToYoutubeOrVimeoPath(video);
        }
    }

    private Boolean isYoutubeOrVimeoFormat(Video video) {
        return video.format.equals("youtube") || video.format.equals("vimeo");
    }

    private void setVideoPathToYoutubeOrVimeoPath(Video video) {
        if (video.format.equals("youtube")) {
            video.videoPath = video.videoPath.split("=")[1];
        }
        if (video.format.equals("vimeo")) {
            video.videoPath = video.videoPath.split("vimeo.com/")[1];
        }
    }
}
