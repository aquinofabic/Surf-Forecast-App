package SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    public static void connect() {

        // SQLite connection string
        String jdbcUrl = "jdbc:sqlite:C:\\Users\\dalef\\OneDrive\\Documents\\Programming + Notes\\Java Projects\\SQLite\\sqlite-tools-win-x64-3450200\\ForecastDatadb.db";

        // SQL statement for creating a new table
/*        String sql = """
                CREATE TABLE ForecastData (\s
                swell_height REAL,\s
                wind_speed REAL,\s
                wind_direction TEXT,\s
                );""";*/
        String sql = """
                CREATE TABLE IF NOT EXISTS ForecastData (
                swell_height REAL,
                wind_speed REAL,
                wind_direction TEXT
                );""";
/*
        public void insert(double swellHt; double windSpeed; String windDir){
            sql = "INSERT INTO ForecastData(swellHt, windSpeed, windDir)"
        }*/

        // Create a connection to the database
        try (Connection connect = DriverManager.getConnection(jdbcUrl);
             Statement statement = connect.createStatement()) {
            // create a new table
            statement.execute(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
}

/*
1. Download SQLite, place in folder and unzip.
    Inside SQLite tools, here databases will be stored.
2. In Intellij, create a new folder called SQLite and a java class called Connect.
3. Instantiate a URL object, specifying the location and database name.
    "jbdc:sqlite: <filepath\\DatabaseName.db>
    If there is a database already, it will connect to that.
    If there are no databases, it will create an empty database with the DatabaseName.
4. Create a connection to the database.
5. Create a table by instantiating a sql string with column names.
5. Instantiate a statement object that executes the sql string
 */
