package db;

import webshop.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Db {
    final private String JDBC_Driver="com.mysql.jdbc.Driver";
    final private String URL="jdbc:mysql://remotemysql.com:3306/5nMIC67K91";
    final private String USERNAME="5nMIC67K91";
    final private String PASSWORD="JeEwfrh2X8";
    Connection conn =null;
    Statement cStatement = null;
    DatabaseMetaData metadata = null;
    public Db()  {
        try{
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException ex){
            System.out.println("nem jó");
        }

        if(conn!=null){
            try {
                cStatement =conn.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            metadata=conn.getMetaData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (metadata!=null){
            try {
                ResultSet rsl =metadata.getTables(null,"APP", "Products",null);
                if (!rsl.next()){
                    cStatement.execute("CREATE TABLE Products( ID INT PRIMARY KEY AUTO_INCREMENT, price INT,productName varchar(100), description varchar(300),imgSrc varchar(300))");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (metadata!=null){
            try {
                ResultSet rsl =metadata.getTables(null,"APP", "Purchaser",null);
                if (!rsl.next()){
                    cStatement.execute("CREATE TABLE Purchaser( ID INT PRIMARY KEY AUTO_INCREMENT,purchaserName varchar(100),purchaserPhone varchar(100),purchaserEmail varchar(100),purchaserPostalCode varchar(100),purchaserAddress varchar(100))");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (metadata!=null){
            try {
                ResultSet rsl =metadata.getTables(null,"APP", "Orders",null);
                if (!rsl.next()){
                    cStatement.execute("CREATE TABLE Orders( ID INT PRIMARY KEY AUTO_INCREMENT, ProductID INT,PurchaserID INT)");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void addProduct(Product product){
        String sql = "INSERT INTO Products (price,productName, description,imgSrc) VALUES (?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, product.getPrice());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getDescription());
            ps.setString(4, product.getImgSrc());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void addPurchaser(String purchaserName,String purchaserPhone,String purchaserEmail,String purchaserPostalCode,String purchaserAddress) {
        String sql = "INSERT INTO Purchaser(purchaserName,purchaserPhone,purchaserEmail,purchaserPostalCode,purchaserAddress) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, purchaserName);
            ps.setString(2, purchaserPhone);
            ps.setString(3, purchaserEmail);
            ps.setString(4, purchaserPostalCode);
            ps.setString(5, purchaserAddress);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void addOrder(int purchaserID,int productID){
        String sql="INSERT INTO Orders(ProductID,PurchaserID) VALUES (?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1,productID);
            ps.setInt(2,purchaserID);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Product> getProducts(){
        String sql="SELECT * FROM Products;";
        List<Product> products=new ArrayList<Product>();
        try {
            ResultSet rs =cStatement.executeQuery(sql);
            while (rs.next()){
               Product product=new Product(rs.getInt("ID"),rs.getInt("price"),rs.getString("productName"),rs.getString("description"),rs.getString("imgSrc"));
               products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
    public int getPurchaser(){
        String sql="SELECT * FROM Purchaser;";
        int id=0;
        try {
            ResultSet rs =cStatement.executeQuery(sql);
            while (rs.next()){
               id= rs.getInt("ID");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }



}
