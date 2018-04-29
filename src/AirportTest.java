import org.junit.Assert;

class AirportTest {

    private Airport airport;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        airport = new Airport("ABC");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getName() {
        Assert.assertEquals("ABC", airport.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
    }

    @org.junit.jupiter.api.Test
    void getLocation() {
    }
    //   @org.junit.jupiter.api.Test
//    void toString() {
//    }
}