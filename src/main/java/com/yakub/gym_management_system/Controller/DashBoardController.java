package com.yakub.gym_management_system.Controller;

import com.yakub.gym_management_system.DBConnection.DBConnection;
import com.yakub.gym_management_system.Model.CustomerModel;
import com.yakub.gym_management_system.Model.EmployeeModel.Cleaner;
import com.yakub.gym_management_system.Model.EmployeeModel.Employee;
import com.yakub.gym_management_system.Model.EmployeeModel.Teacher;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class DashBoardController implements Initializable {

    private static int totalCustomer = 0;
    private DBConnection dbConnection;
    private ObservableList<CustomerModel> customerData;

    private void initDashBoardValues() {
        totalCustomerLabel.setText(String.valueOf(totalCustomer));
        totalIncomeLabel.setText(new String(totalCustomer*100+" $"));


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbConnection = new DBConnection();
        loadCustomerData(new ActionEvent());
        loadEmployeeData(new ActionEvent());

        initDashBoardValues();



    }


    //DASHBOARD PAGE

    @FXML
    private Label totalCustomerLabel;
    @FXML
    private Label totalIncomeLabel;
    @FXML
    private Label totalEmployeeLabel;
    @FXML
    private Label totalExpensesLabel;



    //CUSTOMER PAGE

    @FXML
    private TextField customerId;
    @FXML
    private TextField customerName;
    @FXML
    private TextField customerPhoneNumber;
    @FXML
    private TextField customerEmail;
    @FXML
    private TextField customerMembership;

    @FXML
    private TableView<CustomerModel> customerTable;
    @FXML
    private TableColumn<CustomerModel, String> customerIdColumn;
    @FXML
    private TableColumn<CustomerModel, String> customerNameColumn;
    @FXML
    private TableColumn<CustomerModel, String> customerPhoneColumn;
    @FXML
    private TableColumn<CustomerModel, String> customerEmailColumn;
    @FXML
    private TableColumn<CustomerModel,String> customerMembershipColumn;

    @FXML
    private Button customerAdd;


    @FXML
    private void addCustomerButtonAction(ActionEvent event){
       addCustomer(event);
       loadCustomerData(event);

    }

    private void loadCustomerData(ActionEvent event)
    {
        try
        {
            Connection conn = dbConnection.getConnection();
            this.customerData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                totalCustomer ++;
                this.customerData.add(new CustomerModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error " + e);
        }
        this.customerIdColumn.setCellValueFactory(new PropertyValueFactory("ID"));
        this.customerNameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        this.customerPhoneColumn.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
        this.customerEmailColumn.setCellValueFactory(new PropertyValueFactory("email"));
        this.customerMembershipColumn.setCellValueFactory(new PropertyValueFactory("membership"));

        this.customerTable.setItems(null);
        this.customerTable.setItems(this.customerData);
    }



    private void addCustomer(ActionEvent event)
    {
        String sql = "INSERT INTO `customers`(`ID`, `name`, `phoneNumber`, `email`, `membership`) VALUES (? , ?, ?, ?, ?)";
        try
        {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.customerId.getText());
            stmt.setString(2, this.customerName.getText());
            stmt.setString(3, this.customerPhoneNumber.getText());
            stmt.setString(4, this.customerEmail.getText());
            stmt.setString(5, this.customerMembership.getText());

            stmt.execute();
            conn.close();
        }
        catch (SQLException e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }


    // EMPLOYEE PAGE

    private static int totalEmployee = 0;

    private ObservableList<Employee> employeeData;


    @FXML
    private TextField employeeId;
    @FXML
    private TextField employeeName;
    @FXML
    private TextField employeeEmail;
    @FXML
    private TextField employeeRole;
    @FXML
    private TextField employeeSalary;
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, String> employeeIdColumn;
    @FXML
    private TableColumn<Employee, String> employeeNameColumn;
    @FXML
    private TableColumn<Employee, String> employeeEmailColumn;
    @FXML
    private TableColumn<Employee,String> employeeRoleColumn;
    @FXML
    private TableColumn<Employee,String> employeeSalaryColumn;
    @FXML
    private Button employeeAdd;


    @FXML
    private void addEmployeeButtonAction(ActionEvent event){
        addEmployee(event);
        loadEmployeeData(event);

    }

    private void loadEmployeeData(ActionEvent event)
    {
        try
        {
            Connection conn = dbConnection.getConnection();
            this.employeeData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                totalEmployee ++;
                this.employeeData.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error " + e);
        }
        this.employeeIdColumn.setCellValueFactory(new PropertyValueFactory("ID"));
        this.employeeNameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        this.employeeEmailColumn.setCellValueFactory(new PropertyValueFactory("email"));
        this.employeeRoleColumn.setCellValueFactory(new PropertyValueFactory("role"));
        this.employeeSalaryColumn.setCellValueFactory(new PropertyValueFactory("salary"));

        this.employeeTable.setItems(null);
        this.employeeTable.setItems(this.employeeData);
    }



    private void addEmployee(ActionEvent event)
    {
        String sql = "INSERT INTO `employee`(`ID`, `name`, `email`, `role`, `salary`) VALUES (? , ?, ?, ?, ?)";
        try
        {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, this.employeeId.getText());
            stmt.setString(2, this.employeeName.getText());
            stmt.setString(3, this.employeeEmail.getText());
            stmt.setString(4, this.employeeRole.getText());
            stmt.setString(5, this.employeeSalary.getText());

            stmt.execute();
            conn.close();
        }
        catch (SQLException e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }





}




