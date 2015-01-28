package handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import model.FileHandler;



/**
 *
 * @author JeppeJensen
 */
public class DatabaseHandler {

    private Connection conn;
    private Statement stmt;
    private String host;
    private int portnr;
    private String database;
    private String username;
    private String password;

    private final static boolean DEBUGMODE = true;

    private static DatabaseHandler instance;

    /**
     * Opretter DatabaseHandler. Man bruger bare default til at logge på
     * MySQL-serveren.
     */
    private DatabaseHandler() {

        /*------------------LOGININFO----------------------------------*/
        /**/ host = "localhost";/* Kan erstattes med jepsens.no-ip.biz */
        /**/ portnr = 3306;                                          /**/
        /**/ database = "groengrafik";                                    /**/
        /**/ username = "schooluser"; //username til database    /**/
        /**/ password = "schooluser123";  //Password til database.       /**/ 
        /*-------------------------------------------------------------*/
    }

    public static DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    /**
     * Select-metoden bør blot returnere et resultset som vi så skal bearbejde
     * med en while(rs.next) i den klasse man kalder den i.
     *
     * @param sql-streng som man vil køre
     * @return resultset som mysqlserveren returnere
     * @throws SQLException hvis der er sket en fejl ved hentning fra 'tabel' i
     * databasen. Resultsettet vil være null.
     */
    public ResultSet select(String sql) throws SQLException {
        ResultSet rs = null;
        if (conn.isValid(800)) {
            if (DEBUGMODE) {
                System.out.println("SQL forespørgsel: \"" + sql + " \"");
            }
            rs = stmt.executeQuery(sql);
        } else {
            String str = "Databasehandler.select(" + sql + "): \nConnection is invalid";
            System.out.println(str);
            throw new SQLException(str);
        }
        return rs;
    }

    /**
     * Execution of a specific sql-string
     *
     * @param sql-string to execution
     * @throws java.sql.SQLException if the current sql-string couldnt be
     * executed
     */
    public void execute(String sql) throws SQLException {
        if (DEBUGMODE) {
            System.out.println(sql);
        }
        try {
            if(!conn.isValid(1000)){
                reOpenConn();
            }
            stmt.execute(sql);
        } catch (SQLException ex) {
            throw ex;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Specialiserede metoder">
    /**
     * @param iniFileUrl
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ParseException
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void openConn(String iniFileUrl) throws SQLException, ClassNotFoundException, ParseException, IOException, FileNotFoundException {
        if (iniFileUrl != null) {
            setLogonInfo(FileHandler.readFile(iniFileUrl));
        }

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + host + ":" + portnr + "/" + database;
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
        if (stmt == null) {
            System.out.println("stmt er null, skulle den være det?");
        }
        if (DEBUGMODE) {
            System.out.println("Connection er oprettet!");
        }
        if (!isConnectionClosed()) {
            FileHandler.writeFile("ini.txt", getLoginInfo());
            if (DEBUGMODE) {
                System.out.println("Der er skrevet en ny inifil.");

            }
        }
    }

    private void reOpenConn() throws SQLException {
        String url = "jdbc:mysql://" + host + ":" + portnr + "/" + database;
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
    }

    public boolean isConnectionClosed() throws SQLException {
        boolean closed = false;
        if (conn != null) {
            closed = conn.isClosed();
        }
        return closed;
    }

    public void closeConn() throws SQLException {
        conn.close();
        stmt.close();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SET - metoder">
    public void setHost(String host) {
        this.host = host;
    }

    public void setPortnr(int portnr) {
        this.portnr = portnr;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUdb(String username) {
        this.username = username;
    }

    public void setPdb(String password) {
        this.password = password;
    }

    /**
     * Nice to use with a inifile.
     *
     * @param lineArr 0 - host/ip 1 - portnr 2 - databasenavn 3 - username 4 -
     * password
     * @throws java.text.ParseException
     */
    public void setLogonInfo(ArrayList<String> strList) throws ArrayStoreException, NullPointerException, ParseException {
        String[] lineArr = new String[strList.size()];
        for (int i = 0; i < strList.size(); i++) {
            lineArr[i] = strList.get(i);
        }
        if (lineArr.length != 5) {
            throw new ArrayStoreException("Wrong dimension on array for loginInfo.");
        }
        for (String lineArr1 : lineArr) {
            if (lineArr1 == null) {
                System.out.println(Thread.currentThread().getStackTrace());
                throw new NullPointerException("Der er en fejl i det array 'setLoginInfo' er blevet kaldt med.");
            }
        }
        if (!lineArr[1].matches("\\d+")) {
            throw new ParseException("Portnr can not be parsed into an integer", 1);
        }
        host = lineArr[0];
        portnr = Integer.parseInt(lineArr[1]);
        database = lineArr[2];
        username = lineArr[3];
        password = lineArr[4];
    }
    // </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Get - metoder">
    public String[] getLoginInfo() {
        String[] lineArr = new String[5];
        lineArr[0] = host;
        lineArr[1] = portnr + "";
        lineArr[2] = database;
        lineArr[3] = username;
        lineArr[4] = password;
        return lineArr;
    }
    // </editor-fold>
}
