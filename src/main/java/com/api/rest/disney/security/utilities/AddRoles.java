package com.api.rest.disney.security.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
@PropertySource("classpath:application.properties")
public class AddRoles {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${PASS}")
    private String password;

    private static final String INSERT_ROLES_SQL = "INSERT INTO role" +
            "  (id, role_name) VALUES " +
            " (?, ?);";

    public void insertRecordUser() throws SQLException {
        System.out.println(INSERT_ROLES_SQL);
        try (Connection connection = DriverManager.getConnection(url,username,password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROLES_SQL);

                preparedStatement.setInt(1,1);
                preparedStatement.setString(2,"ROLE_USER");
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            throw new SQLException(exception);
        }
    }

    public void insertRecordAdmin() throws SQLException {
        System.out.println(INSERT_ROLES_SQL);
        try (Connection connection = DriverManager.getConnection(url,username,password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROLES_SQL);

            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"ROLE_ADMIN");
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            throw new SQLException(exception);
        }
    }
}
