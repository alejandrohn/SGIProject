package models;

import java.sql.PreparedStatement;


public class RegisterVideo extends ResourceManager {

    private String QUERY_MAX_ID = "SELECT MAX(ID) as MAXID FROM VIDEOS";

    public void insertVideo(String autor, String title, String description, String format, String createdDate, int reproductionNumber, int hour, int minutes, int seconds) throws Exception {
        try {
            initConnectionDb();
            int maxId = getMaxId(QUERY_MAX_ID);
            String queryInsertVideo = getQueryInsertVideo(maxId, autor, title, description, createdDate, format, reproductionNumber, hour, minutes, seconds);
            PreparedStatement insertVideo = connection.prepareStatement(queryInsertVideo);
            insertVideo.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error in insert Video");
        } finally {
            closeConnection();
        }
    }

    private String getQueryInsertVideo(int idVideo, String autor, String title, String description, String createdDate, String format, int reproductionNumber, int hour, int minutes, int seconds) {

        String hourFormat = hour < 10 ? '0' + Integer.toString(hour) : Integer.toString(hour);
        String minutesFormat = minutes < 10 ? '0' + Integer.toString(minutes) : Integer.toString(minutes);
        String secondsFormat = seconds < 10 ? '0' + Integer.toString(seconds) : Integer.toString(seconds);

        String duration = hourFormat + ':' + minutesFormat + ':' + secondsFormat;

        return "INSERT INTO VIDEOS (ID,TITLE, AUTOR, DESCRIPTION, CREATEDDATE, DURATION, REPRODUCTIONS,FORMAT) "
                + "VALUES(" + idVideo + ",'" + title + "', '" + autor + "','" + description + "','" + createdDate + "','" + duration + "'," + reproductionNumber + ",'" + format + "')";

    }
}
