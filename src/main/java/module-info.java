module com.yakub.gym_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;
    requires java.sql;


    opens com.yakub.gym_management_system to javafx.fxml;
    exports com.yakub.gym_management_system;
    exports com.yakub.gym_management_system.Model;
    opens com.yakub.gym_management_system.Model to javafx.fxml;
    exports com.yakub.gym_management_system.Controller;
    opens com.yakub.gym_management_system.Controller to javafx.fxml;
}