/**
 *  Copyright 2017, nu1silva (nuwan@nu1silva.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.nu1silva.extracker.datacore.dao.impl;

import com.nu1silva.extracker.datacore.dao.UserDAO;
import com.nu1silva.extracker.datacore.datasource.impl.MySQLDataSource;
import com.nu1silva.extracker.datacore.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDAO {

    private final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private final String GET_USER = "SELECT id, email, fname, lname, user_type, status FROM user_accounts WHERE";

    private User returnUser = new User();

    @Override
    public User getUserByID(String userID) {

        final String query = GET_USER + " id = ?";

        try (Connection connection = MySQLDataSource.getHKDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, userID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                returnUser.setUserId(resultSet.getInt("id"));
                returnUser.setEmail(resultSet.getString("email"));
                returnUser.setFirstName(resultSet.getString("fname"));
                returnUser.setLastName(resultSet.getString("lname"));
                returnUser.setUserType(User.UserType.valueOf(resultSet.getString("user_type")));
                returnUser.setStatus(User.UserStatus.valueOf(resultSet.getString("status")));
            }
            return returnUser;
        } catch (SQLException e) {
            logger.error("error getting user", e);
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        final String query = GET_USER + " email = ?";

        try (Connection connection = MySQLDataSource.getHKDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                returnUser.setUserId(resultSet.getInt("id"));
                returnUser.setEmail(resultSet.getString("email"));
                returnUser.setFirstName(resultSet.getString("fname"));
                returnUser.setLastName(resultSet.getString("lname"));
                returnUser.setUserType(User.UserType.valueOf(resultSet.getString("user_type")));
                returnUser.setStatus(User.UserStatus.valueOf(resultSet.getString("status")));
            }
            return returnUser;
        } catch (SQLException e) {
            logger.error("error getting user", e);
            return null;
        }
    }
}
