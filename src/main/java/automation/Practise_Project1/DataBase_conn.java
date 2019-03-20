/**
 * 
 */
package automation.Practise_Project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * @author Pratik
 *
 */
public class DataBase_conn {

	// define global variables
	final static Logger log = Logger.getLogger(DataBase_conn.class.getName()); // for log4j.properties file config
	private String URL = "";
	private String User = "";
	private String Password = "";
	Connection conn = null;
	Statement s = null;

	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return User;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword() {
		Password = "root";
	}

	/**
	 * @param user the user to set
	 */
	public void setUser() {
		User = "root";
	}

	/**
	 * @param uRL the uRL to set
	 */
	public void setURL() {
		URL = "jdbc:mysql://localhost:3306/Project1";
	}

	public Statement connect_mySQL_DB() {

		// Setting up private variables for DB connection
		setURL();
		setUser();
		setPassword();
		

		/*
		 * Connection to MY SQL Database public static Connection getConnection(String
		 * URL, String user, String password);
		 */
		try {
			log.debug("trying to connect the MYSQL DB");
			conn = DriverManager.getConnection(getURL(), getUser(), getPassword());
			log.info("DB COnnection Success");

			/*
			 * get the connection Object 'conn' into Statement variable; so that this
			 * statement variable will be used to write statements to query DB
			 */
			log.debug("Setting Connection Object to Statement Object");
			s = conn.createStatement();
			log.info("Success: Statement Object is successfully initialized");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error in connecting to Database @ URL: " + getURL());
			log.error("Please find the Stack Trace Below: ");
			e.printStackTrace();
		}
		return s;
	}
	
	public void closeDBConnection() throws SQLException
	{
		log.debug("Trying to Close an Openn Connnection");
		conn.close();
		conn = null;
		log.info("success: Connection Closed; Reference set to NULL");
	}

}
