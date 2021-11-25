//package com.example.springtemplate.daos;
//
//import com.example.springtemplate.models.Order;
//
//import java.sql.*;
//import java.util.*;
//
//public class UserJdbcDao {
//    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    static final String HOST = "localhost:3306";
//    static final String SCHEMA = "db_design";
//    static final String CONFIG = "serverTimezone=UTC";
//    static final String URL =
//            "jdbc:mysql://"+HOST+"/"+SCHEMA+"?"+CONFIG;
//    static final String USERNAME = "CS5200";
//    static final String PASSWORD = "P@ssw0rd";
//
//    static Connection connection = null;
//    static PreparedStatement statement = null;
//    String CREATE_USER = "INSERT INTO users VALUES (null, ?, ?, ?, ?, ?, null)";
//    String FIND_ALL_USERS = "SELECT * FROM users";
//    String FIND_USER_BY_ID = "SELECT * FROM users WHERE id=?";
//    String DELETE_USER = "DELETE FROM users WHERE id=?";
//    String UPDATE_USER_PASSWORD = "UPDATE users SET password=? WHERE id=?";
//    String UPDATE_USER = "UPDATE users SET first_name=?, last_name=?, username=?, password=? WHERE id=?";
//
//    private Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName(DRIVER);
//        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//    }
//
//    private void closeConnection(Connection connection) throws SQLException {
//        connection.close();
//    }
//
//    public Order findUserById(Integer id) throws SQLException, ClassNotFoundException {
//        Order user = null;
//        connection = getConnection();
//        // do your work here
//        statement = connection.prepareStatement(FIND_USER_BY_ID);
//        statement.setInt(1,id);
//        ResultSet resultSet = statement.executeQuery();
//        if (resultSet.next()){
//            user = new Order(
//                    resultSet.getString("first_name"),
//                    resultSet.getString("last_name"),
//                    resultSet.getString("username"),
//                    resultSet.getString("password"),
//                    resultSet.getString("profile_picture"));
//        }
//
//        closeConnection(connection);
//        return user;
//    }
//
//    public Integer deleteUser(Integer userId) throws SQLException, ClassNotFoundException {
//        Integer rowsDeleted = 0;
//        connection = getConnection();
//
//        // do your work here
//        statement = connection.prepareStatement(DELETE_USER);
//        statement.setInt(1,userId);
//        rowsDeleted = statement.executeUpdate();
//
//        closeConnection(connection);
//        return rowsDeleted;
//    }
//
//    public Integer updateUser(Integer userId, Order newUser) throws SQLException, ClassNotFoundException {
//        Integer rowsUpdated = 0;
//        connection = getConnection();
//
//        // do your work here
//        statement = connection.prepareStatement(UPDATE_USER);
//        statement.setString(1, newUser.getFirstName());
//        statement.setString(2, newUser.getLastName());
//        statement.setString(3, newUser.getUsername());
//        statement.setString(4, newUser.getPassword());
//        statement.setInt(5, userId);
//        rowsUpdated = statement.executeUpdate();
//
//        closeConnection(connection);
//        return rowsUpdated;
//    }
//
//    public List<Order> findAllUsers() throws ClassNotFoundException, SQLException {
//        List<Order> users = new ArrayList<Order>();
//        connection = getConnection();
//
//        // do your work here
//        statement = connection.prepareStatement(FIND_ALL_USERS);
//        ResultSet resultSet = statement.executeQuery();
//        while(resultSet.next()){
//        Order user = new Order(
//            resultSet.getString("first_name"),
//            resultSet.getString("last_name"),
//            resultSet.getString("username"),
//            resultSet.getString("password"),
//            resultSet.getString("profile_picture"));
//        users.add(user);
//        }
//        closeConnection(connection);
//        return users;
//    }
//    public Integer createUser(Order user)
//            throws ClassNotFoundException, SQLException {
//        Integer rowsInserted = 0;
//        connection = getConnection();
//
//        // do your work here
//        statement = connection.prepareStatement(CREATE_USER);
//        statement.setString(1, user.getUsername());
//        statement.setString(2, user.getPassword());
//        statement.setString(3, user.getFirstName());
//        statement.setString(4, user.getLastName());
//        statement.setString(5, user.getProfilePicture());
//        rowsInserted = statement.executeUpdate();
//        closeConnection(connection);
//        return rowsInserted;
//
//    }
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        UserJdbcDao dao = new UserJdbcDao();
//
//        // do your work here
//
//        Order adam =
//                new Order("Adam", "Smith", "adams",
//                        "invisiblehand", "http://bbc.in/30gXhI4");
//        Order thomas =
//                new Order("Thomas", "Sowell", "thomas",
//                        "polymath", "http://www.tsowell.com/");
//        Order catherine =
//                new Order("Catherine", "Wood", "cathie",
//                        "bitcoinisbig", "https://ark-invest.com/");
////        dao.createUser(adam);
////        dao.createUser(thomas);
////        dao.createUser(catherine);
//
//        List<Order> users = dao.findAllUsers();
//        for(Order user: users) {
//            System.out.println(user.getUsername());
//        }
//        System.out.printf("find by ID\n");
//        Order user = dao.findUserById(3);
//        System.out.println(user.getUsername());
//
//        dao.deleteUser(9);
//        users = dao.findAllUsers();
//        for(Order afterDeleteUser: users) {
//            System.out.println(afterDeleteUser.getUsername());
//        }
//        Order newTom = new Order(
//                "Tom",
//                "Sowell",
//                "tom",
//                "knowitall",
//                thomas.getProfilePicture());
//        dao.updateUser(2, newTom);
//        Order tom = dao.findUserById(2);
//        System.out.println(tom.getUsername());
//
//
//    }
//}
