import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class InternationalTest {
    private International<Flight> intFlight;
    private International<Train> intTrain;
    private Flight flight;
    private Train train;

    @BeforeEach
    void setUp() {
        flight = new Flight("DEN", "LON", 2018, 5, 21, "321");
        intFlight = new International<>(flight, "AA1042133");
        train = new Train("DEN", "LON", 2018, 5, 21, "321");
        intTrain = new International<>(train, "AA1042133");
    }

    @Test
    void getTransportType() {
        Assert.assertEquals("Get Transport type", flight, intFlight.getTransportType());
        Assert.assertEquals("Get Transport type", train, intTrain.getTransportType());
    }
}