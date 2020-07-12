package akm.apiPlayOnWords.one.dao;

import akm.apiPlayOnWords.one.model.UserStats;
import akm.apiPlayOnWords.one.parser.UserStatsParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserStatsDAO {
    private final static String DBURL = "jdbc:h2:~/bank";
    private final static String DBUSER = "SA";
    private final static String DBPASS = "";
    private final static String DBDRIVER = "org.h2.Driver";

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private Connection connection;
    private Statement statement;
    private String query;
    private UserStatsParser sqlUserStatsParser;

    public UserStatsDAO() {
        sqlUserStatsParser = new UserStatsParser();
    }

    public void save(UserStats userStats) {
        query = sqlUserStatsParser.createSaveQuery(userStats);
LOG.debug(query);
        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(UserStats userStats) {
        query = sqlUserStatsParser.createUpdateQuery(userStats);
        LOG.debug(query);
        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserStats find(UserStats userStats) {
        query = sqlUserStatsParser.createFindQuery(userStats);
        LOG.debug(query);
        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            userStats = null;
            while (result.next()) {
                userStats = new UserStats();
                userStats.setLogin(result.getString("LOGIN"));
                userStats.setRequestCount(result.getInt("REQUEST_COUNT"));
            }

            statement.close();
            connection.close();
            return userStats;
       }catch (Exception e) {
            e.printStackTrace();
            createTable();
            return null;
        }

    }

    public void createTable() {
        query = sqlUserStatsParser.createCreateQuery();
        LOG.debug(query);
        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}