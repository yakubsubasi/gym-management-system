package com.yakub.gym_management_system;

import com.yakub.gym_management_system.DBConnection.DBConnection;
import com.yakub.gym_management_system.Model.LoginModel;

import java.sql.SQLException;

public class Test {

    private static LoginModel loginModel = new LoginModel();
    private static DBConnection dbConnection = new DBConnection();

    public static void main(String[] args) throws SQLException {




        if (dbConnection.isDBConnected())
            System.out.println("Veri tabanı bağlantısı başarılı");
        else
            System.out.println("veri tabanı bağlantısı başarısız");


        try {
            if (loginModel.isLogin("yakub", "subasi"))
                System.out.println("Başarı ile giriş yapıldı");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
