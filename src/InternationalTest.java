import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternationalTest {
    private International<Flight> intFlight;
    private International<Train> intTrain;
    private Flight flight;
    private Train train;

    @BeforeEach
    void setUp() {
        flight = new Flight("DEN", "LON", 2018, 5, 21, "321");
        intFlight = new International<>(flight, "AA1042133", "departed");

        train = new Train("DEN", "LON", 2018, 5, 21, "321");
        intTrain = new International<>(train, "AA1042133", "departed");
    }

    @Test
    void getPassport() {
    }

    @Test
    void setTransportType() {

    }

    @Test
    void getTransportType() {
        Assert.assertEquals("Get Transport type", flight, intFlight.getTransportType());
        Assert.assertEquals("Get Transport type", train, intTrain.getTransportType());
    }

    @Test
    void getDepartureStatus() {
    }
}