package com.yakub.gym_management_system.Model;

import com.yakub.gym_management_system.DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    Connection connection;

    public LoginModel(){

        try {
            this.connection = DBConnection.getConnection();

        }catch (Exception e) {
            e.printStackTrace();}
    }


    public boolean isDBConnected(){
        return this.connection != null;
    }

    public boolean isLogin(String userName, String passWord) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM login where username = ? and password = ?";

        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2,passWord);

            resultSet = preparedStatement.executeQuery();


            if (resultSet.next())
                return true;
            else
                return false;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } finally {

            {
                preparedStatement.close();
                resultSet.close();
            }
        }








    }

}
