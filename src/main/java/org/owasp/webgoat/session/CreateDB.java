package org.owasp.webgoat.session;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.owasp.webgoat.lessons.AbstractLesson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***************************************************************************************************
 * 
 * 
 * This file is part of WebGoat, an Open Web Application Security Project utility. For details,
 * please see http://www.owasp.org/
 * 
 * Copyright (c) 2002 - 20014 Bruce Mayhew
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 * 
 * Getting Source ==============
 * 
 * Source for this application is maintained at https://github.com/WebGoat/WebGoat, a repository for free software
 * projects.
 * 
 * For details, please see http://webgoat.github.io
 * 
 * @author Jeff Williams <a href="http://www.aspectsecurity.com">Aspect Security</a>
 */
public class CreateDB {

    private static final Logger logger = LoggerFactory.getLogger(CreateDB.class);

    private void createMessageTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE messages";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop message database: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE messages (" +
                    "num int not null," +
                    "title varchar(50)," +
                    "message varchar(200)," +
                    "user_name varchar(50) not null, " +
                    "lesson_type varchar(50) not null" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating message database: {}", e.getMessage(), e);
        }
    }

    private void createMFEImagesTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE mfe_images";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop mfe_images table: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE mfe_images (" +
                    "user_name varchar(50) not null, " +
                    "image_relative_url varchar(50) not null" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating mfe_images table: {}", e.getMessage(), e);
        }
    }

    private void createProductTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE product_system_data";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop product table: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE product_system_data (" +
                    "productid varchar(6) not null primary key," +
                    "product_name varchar(20)," +
                    "price varchar(10)" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating product table: {}", e.getMessage(), e);
        }

        String insertData1 = "INSERT INTO product_system_data VALUES ('32226','Dog Bone','$1.99')";
        String insertData2 = "INSERT INTO product_system_data VALUES ('35632','DVD Player','$214.99')";
        String insertData3 = "INSERT INTO product_system_data VALUES ('24569','60 GB Hard Drive','$149.99')";
        String insertData4 = "INSERT INTO product_system_data VALUES ('56970','80 GB Hard Drive','$179.99')";
        String insertData5 = "INSERT INTO product_system_data VALUES ('14365','56 inch HDTV','$6999.99')";
        statement.executeUpdate(insertData1);
        statement.executeUpdate(insertData2);
        statement.executeUpdate(insertData3);
        statement.executeUpdate(insertData4);
        statement.executeUpdate(insertData5);
    }

    private void createUserAdminTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE user_system_data";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop user admin table: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE user_system_data (" +
                    "userid varchar(5) not null primary key," +
                    "user_name varchar(12)," +
                    "password varchar(10)," +
                    "cookie varchar(30)" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating user admin table: {}", e.getMessage(), e);
        }

        String insertData1 = "INSERT INTO user_system_data VALUES ('101','jsnow','passwd1', '')";
        String insertData2 = "INSERT INTO user_system_data VALUES ('102','jdoe','passwd2', '')";
        String insertData3 = "INSERT INTO user_system_data VALUES ('103','jplane','passwd3', '')";
        String insertData4 = "INSERT INTO user_system_data VALUES ('104','jeff','jeff', '')";
        String insertData5 = "INSERT INTO user_system_data VALUES ('105','dave','dave', '')";
        statement.executeUpdate(insertData1);
        statement.executeUpdate(insertData2);
        statement.executeUpdate(insertData3);
        statement.executeUpdate(insertData4);
        statement.executeUpdate(insertData5);
    }

    private void createUserDataTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE user_data";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop user table: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE user_data (" +
                    "userid int not null," +
                    "first_name varchar(20)," +
                    "last_name varchar(20)," +
                    "cc_number varchar(30)," +
                    "cc_type varchar(10)," +
                    "cookie varchar(20)," +
                    "login_count int" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating user table: {}", e.getMessage(), e);
        }

        String insertData1 = "INSERT INTO user_data VALUES (101,'Joe','Snow','987654321','VISA',' ',0)";
        String insertData2 = "INSERT INTO user_data VALUES (101,'Joe','Snow','2234200065411','MC',' ',0)";
        String insertData3 = "INSERT INTO user_data VALUES (102,'John','Smith','2435600002222','MC',' ',0)";
        String insertData4 = "INSERT INTO user_data VALUES (102,'John','Smith','4352209902222','AMEX',' ',0)";
        String insertData5 = "INSERT INTO user_data VALUES (103,'Jane','Plane','123456789','MC',' ',0)";
        String insertData6 = "INSERT INTO user_data VALUES (103,'Jane','Plane','333498703333','AMEX',' ',0)";
        String insertData7 = "INSERT INTO user_data VALUES (10312,'Jolly','Hershey','176896789','MC',' ',0)";
        String insertData8 = "INSERT INTO user_data VALUES (10312,'Jolly','Hershey','333300003333','AMEX',' ',0)";
        String insertData9 = "INSERT INTO user_data VALUES (10323,'Grumpy','youaretheweakestlink','673834489','MC',' ',0)";
        String insertData10 = "INSERT INTO user_data VALUES (10323,'Grumpy','youaretheweakestlink','33413003333','AMEX',' ',0)";
        String insertData11 = "INSERT INTO user_data VALUES (15603,'Peter','Sand','123609789','MC',' ',0)";
        String insertData12 = "INSERT INTO user_data VALUES (15603,'Peter','Sand','338893453333','AMEX',' ',0)";
        String insertData13 = "INSERT INTO user_data VALUES (15613,'Joesph','Something','33843453533','AMEX',' ',0)";
        statement.executeUpdate(insertData1);
        statement.executeUpdate(insertData2);
        statement.executeUpdate(insertData3);
        statement.executeUpdate(insertData4);
        statement.executeUpdate(insertData5);
        statement.executeUpdate(insertData6);
        statement.executeUpdate(insertData7);
        statement.executeUpdate(insertData8);
        statement.executeUpdate(insertData9);
        statement.executeUpdate(insertData10);
        statement.executeUpdate(insertData11);
        statement.executeUpdate(insertData12);
        statement.executeUpdate(insertData13);
    }

    private void createLoginTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE user_login";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop user_login table: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE user_login (" +
                    "userid varchar(5)," +
                    "webgoat_user varchar(20)" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating user_login table: {}", e.getMessage(), e);
        }
    }

    private void createBlindSQLLessonTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE pins";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop pins table: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE pins (" +
                    "cc_number varchar(30)," +
                    "pin int," +
                    "name varchar(20)" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating pins table: {}", e.getMessage(), e);
        }

        String insertData1 = "INSERT INTO pins VALUES ('987654321098765', 1234, 'Joe')";
        String insertData2 = "INSERT INTO pins VALUES ('1234567890123456', 4567, 'Jack')";
        String insertData3 = "INSERT INTO pins VALUES ('4321432143214321', 4321, 'Jill')";
        String insertData4 = "INSERT INTO pins VALUES ('1111111111111111', 7777, 'Jim')";
        String insertData5 = "INSERT INTO pins VALUES ('1111222233334444', 2364, 'John')";
        statement.executeUpdate(insertData1);
        statement.executeUpdate(insertData2);
        statement.executeUpdate(insertData3);
        statement.executeUpdate(insertData4);
        statement.executeUpdate(insertData5);
    }

    private void createModifyWithSQLLessonTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE salaries";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop salaries table: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE salaries (" +
                    "userid varchar(50)," +
                    "salary int" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating salaries table: {}", e.getMessage(), e);
        }

        String insertData1 = "INSERT INTO salaries VALUES ('jsmith', 20000)";
        String insertData2 = "INSERT INTO salaries VALUES ('lsmith', 45000)";
        String insertData3 = "INSERT INTO salaries VALUES ('wgoat', 100000)";
        String insertData4 = "INSERT INTO salaries VALUES ('rjones', 777777)";
        String insertData5 = "INSERT INTO salaries VALUES ('manderson', 65000)";
        statement.executeUpdate(insertData1);
        statement.executeUpdate(insertData2);
        statement.executeUpdate(insertData3);
        statement.executeUpdate(insertData4);
        statement.executeUpdate(insertData5);
    }

    private void createWeatherDataTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE weather_data";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop weather table: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE weather_data (" +
                    "station int not null," +
                    "name varchar(20) not null," +
                    "state char(2) not null," +
                    "min_temp int not null," +
                    "max_temp int not null" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating weather table: {}", e.getMessage(), e);
        }

        String insertData1 = "INSERT INTO weather_data VALUES (101,'Columbia','MD',-10,102)";
        String insertData2 = "INSERT INTO weather_data VALUES (102,'Seattle','WA',-15,90)";
        String insertData3 = "INSERT INTO weather_data VALUES (103,'New York','NY',-10,110)";
        String insertData4 = "INSERT INTO weather_data VALUES (104,'Houston','TX',20,120)";
        String insertData5 = "INSERT INTO weather_data VALUES (10001,'Camp David','MD',-10,100)";
        String insertData6 = "INSERT INTO weather_data VALUES (11001,'Ice Station Zebra','NA',-60,30)";
        statement.executeUpdate(insertData1);
        statement.executeUpdate(insertData2);
        statement.executeUpdate(insertData3);
        statement.executeUpdate(insertData4);
        statement.executeUpdate(insertData5);
        statement.executeUpdate(insertData6);
    }

    private void createTanUserDataTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE user_data_tan";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop user_data_tan table: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE user_data_tan (" +
                    "userid int not null," +
                    "first_name varchar(20)," +
                    "last_name varchar(20)," +
                    "cc_number varchar(30)," +
                    "cc_type varchar(10)," +
                    "cookie varchar(20)," +
                    "login_count int," +
                    "password varchar(20)" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating user_data_tan table: {}", e.getMessage(), e);
        }

        String insertData1 = "INSERT INTO user_data_tan VALUES (101,'Joe','Snow','987654321','VISA',' ',0, 'banana')";
        String insertData2 = "INSERT INTO user_data_tan VALUES (102,'Jane','Plane','74589864','MC',' ',0, 'tarzan')";
        String insertData3 = "INSERT INTO user_data_tan VALUES (103,'Jack','Sparrow','68659365','MC',' ',0, 'sniffy')";
        statement.executeUpdate(insertData1);
        statement.executeUpdate(insertData2);
        statement.executeUpdate(insertData3);
    }

    private void createTanTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        try {
            String dropTable = "DROP TABLE tan";
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            logger.info("Could not drop tan table: {}", e.getMessage());
        }

        try {
            String createTableStatement = "CREATE TABLE tan (" +
                    "userid int not null," +
                    "tanNr int," +
                    "tanValue int" +
                    ")";
            statement.executeUpdate(createTableStatement);
        } catch (SQLException e) {
            logger.error("Error creating tan table: {}", e.getMessage(), e);
        }

        String insertData1 = "INSERT INTO tan VALUES (101,1,15161)";
        String insertData2 = "INSERT INTO tan VALUES (101,2,4894)";
        String insertData3 = "INSERT INTO tan VALUES (101,3,18794)";
        String insertData4 = "INSERT INTO tan VALUES (101,4,1564)";
        String insertData5 = "INSERT INTO tan VALUES (101,5,45751)";
        String insertData6 = "INSERT INTO tan VALUES (102,1,15648)";
        String insertData7 = "INSERT INTO tan VALUES (102,2,92156)";
        String insertData8 = "INSERT INTO tan VALUES (102,3,4879)";
        String insertData9 = "INSERT INTO tan VALUES (102,4,9458)";
        String insertData10 = "INSERT INTO tan VALUES (102,5,4879)";
        statement.executeUpdate(insertData1);
        statement.executeUpdate(insertData2);
        statement.executeUpdate(insertData3);
        statement.executeUpdate(insertData4);
        statement.executeUpdate(insertData5);
        statement.executeUpdate(insertData6);
        statement.executeUpdate(insertData7);
        statement.executeUpdate(insertData8);
        statement.executeUpdate(insertData9);
        statement.executeUpdate(insertData10);
    }

    public void makeDB(Connection connection) throws SQLException {
        logger.info("Successful connection to database");
        createUserDataTable(connection);
        createLoginTable(connection);
        createBlindSQLLessonTable(connection);
        createUserAdminTable(connection);
        createProductTable(connection);
        createMessageTable(connection);
        createEmployeeTable(connection);
        createRolesTable(connection);
        createAuthTable(connection);
        createOwnershipTable(connection);
        createWeatherDataTable(connection);
        createTransactionTable(connection);
        createTanUserDataTable(connection);
        createTanTable(connection);
        createMFEImagesTable(connection);
        createModifyWithSQLLessonTable(connection);
        logger.info("Success: creating tables.");
    }
}
