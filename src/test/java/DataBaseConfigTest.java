import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.oc.safetyalerts.config.DataBaseConfig;

class DataBaseConfigTest {
	
	DataBaseConfig dataBaseConfig;

	/*
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	 */
	
	@BeforeEach
	void setUp() throws Exception {
		dataBaseConfig = new DataBaseConfig();
	}

	/*
	@AfterEach
	void tearDown() throws Exception {
	}
	*/

	@Test
	void ConnexionDoesNotFail() throws ClassNotFoundException, SQLException {
        Connection con = null;
		con = dataBaseConfig.getConnection();
		assertNotEquals(null, con);
	}

}
