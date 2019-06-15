package videoHelpers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAuthorization extends ResourceManager {

    public Boolean validateUser(ReproductionRequestData requestData) throws Exception {

        String queryForVerifyUser = "SELECT * FROM USERS WHERE username = '" + requestData.getUsername() + "' AND password = '" + requestData.getPassword()+"'";

        try {
            initConnectionDb();
            PreparedStatement resultValidateUser = connection.prepareStatement(queryForVerifyUser);
            resultSet = resultValidateUser.executeQuery();
            return resultSet.next();

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new Exception("User not found");
        }
    }
}
