package base;

import java.sql.*;
import java.util.Arrays;

public class DbManager extends GlobalTestData {

    private static Connection conn = null;

    /** postgreSQL connection **/
    public static void setDbConnection() {
            try {
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
                if (!conn.isClosed()) {
                    System.out.println("Successfully connected to postgreSQL");
                }
            } catch (Exception e) {
                System.out.println("PostgreSQL error: " + e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
            }
    }

    public static String[][] getQuery(int rows, int col, String query) throws SQLException {

        DbManager.setDbConnection();
        GlobalTestData.SQL_ROW=rows;
        GlobalTestData.SQL_COL=col;
        Statement St = conn.createStatement();
        ResultSet rs = St.executeQuery(query);
        String[][] values = new String[rows][col];
        int i = 0;
        while (rs.next()) {
            for (int j = 0; j < col; j++) {
                values[i][j] = rs.getString(j + 1);
            }
            i++;
        }
        DbManager.closeConnection();

        return values;
    }

    public static void closeConnection() {
        try{
            if (!conn.isClosed()) {
                conn.close();
            }

        }catch(Exception e){
            System.out.println("SQL connection is already closed.");
        }

    }
}
