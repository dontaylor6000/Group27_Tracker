package tracker.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientTest {

    @Before
    public void setUp() throws Exception {
        API dbapi = new API();
        Patient test = new Patient("John", "Doe", 1);
        dbapi.addToDb("patient", test);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFirst() {
    }

    @Test
    public void setFirst() {
    }

    @Test
    public void getLast() {
    }

    @Test
    public void setLast() {
    }

    @Test
    public void getLocationId() {
    }

    @Test
    public void setLocationId() {
    }
}