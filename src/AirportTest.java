import org.junit.Assert;

class AirportTest {

    private Airport airport;

    @org.junit.jupiter.api.BeforeEach
    void setUp() { airport = new Airport("ABC", "10E", "46N" ); }

    @org.junit.jupiter.api.Test
    void getName() {
        Assert.assertEquals("ABC", airport.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        airport.setName("XXX");
        Assert.assertEquals("SetName Method", "XXX", airport.getName());
    }

    @org.junit.jupiter.api.Test
    void getLocation() {
        Assert.assertEquals("46N 10E", airport.getLocation());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Assert.assertEquals("Airport Name: ABC", airport.toString());
       }
}