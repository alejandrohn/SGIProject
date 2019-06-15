package org.me.isdcm.video.helpers;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.me.isdcm.video.SearchPatternsClasses.IVideoQuery;

public class ActionManager extends ResourceManager {

    public List<Video> getVideosByPattern(IVideoQuery searchPattern) throws Exception {
        List<Video> videos = new ArrayList<>();
        try {
            initConnectionDb();
            PreparedStatement statementCheckUser = connection.prepareStatement(searchPattern.getQuery());
            resultSet = statementCheckUser.executeQuery();
            while (resultSet.next()) {
                addVideoToList(videos);
            }
            return videos;
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            closeConnection();
            return videos;
        }
    }

    private void addVideoToList(List<Video> videos) throws SQLException {
        Video video = new Video();
        setVideo(video);
        videos.add(video);
    }

    private void setVideo(Video v) throws SQLException {
        v.id = resultSet.getInt("ID");
        v.title = resultSet.getString("title");
        v.autor = resultSet.getString("autor");
        v.format = resultSet.getString("format");
        v.description = resultSet.getString("description");
        v.reproductionNumber = resultSet.getInt("reproductions");
        v.createdDate = resultSet.getDate("createdDate");
        v.formatToDurationType(resultSet.getTime("duration"));
    }
}
