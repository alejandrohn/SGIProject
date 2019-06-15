/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoHelpers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VideoService extends ResourceManager {

    private int newReproductionsNumber;

    public int getNewReproductionsNumber() {
        return newReproductionsNumber;
    }

    public void updateReproductionsNumber(int videoId) throws Exception {
        try {
            this.newReproductionsNumber = getNewReproductionsNumber(videoId);
            String queryUpdateReproductionsNumber = getQueryForUpdateReproductionsNumber(videoId, this.newReproductionsNumber);
            PreparedStatement updateVideo = connection.prepareStatement(queryUpdateReproductionsNumber);
            updateVideo.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error in update reproduction number");
        }
    }

    private int getReproductionsNumber(int videoId) throws Exception {
        String queryForReproductionsNumber = "SELECT VIDEOS.REPRODUCTIONS FROM VIDEOS WHERE ID = " + videoId;

        try {
            initConnectionDb();
            PreparedStatement resultReproductionsNumber = connection.prepareStatement(queryForReproductionsNumber);
            resultSet = resultReproductionsNumber.executeQuery();

            if (resultSet.next()) {
                int reproductionsNumber = resultSet.getInt("reproductions");
                return reproductionsNumber;
            } else {
                throw new Exception("Nor found this videoId");
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new Exception("Error get reproduction number");
        }
    }

    private int getNewReproductionsNumber(int videoId) throws Exception {
        int reproductionsNumber = getReproductionsNumber(videoId);
        reproductionsNumber = incrementReproductions(reproductionsNumber);
        return reproductionsNumber;
    }

    private String getQueryForUpdateReproductionsNumber(int videoId, int newReproductionsNumber) {
        return "UPDATE VIDEOS SET REPRODUCTIONS = " + newReproductionsNumber + " WHERE ID = " + videoId;
    }

    private int incrementReproductions(int reproductionsNumber) {
        reproductionsNumber = reproductionsNumber + 1;
        return reproductionsNumber;
    }
}
