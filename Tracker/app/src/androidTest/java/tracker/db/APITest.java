package tracker.db;

import org.junit.Test;

import static org.junit.Assert.*;

public class APITest {

    @Test
    public void encrypt() {
    }

    @Test
    public void addToDb() {
        API dbapi = new API();

        dbapi.addToDb("Patient", "John", "Doe", 1);

    }

    @Test
    public void updateDb() {
    }

    @Test
    public void removeFromDb() {
    }
}