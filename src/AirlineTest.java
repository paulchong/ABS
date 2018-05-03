import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirlineTest {
    private Airline airline;

    @BeforeEach
    void setUp() {
        airline = new Airline("NZL");
    }

    @Test
    void addFlight() {
        Assert.assertEquals("Check Flight Exists", false, airline.checkFlightExists("321"));
        airline.addFlight("DEN","LON",2018,5,21,"321");
        Assert.assertEquals("Check Flight Exists", true, airline.checkFlightExists("321"));
    }

    @Test
    void addSection() {
        airline.addFlight("DEN","LON",2018,5,21,"321");
        Assert.assertEquals("Has Available Seat", false, airline.hasAvailableSeats("DEN","LON"));
        airline.addSection("321",1,1,SeatClass.business);
        Assert.assertEquals("Has Available Seat", true, airline.hasAvailableSeats("DEN","LON"));
    }

    @Test
    void bookSeat() {
        airline.addFlight("DEN","LON",2018,5,21,"321");
        airline.addSection("321",1,1,SeatClass.business);
        Assert.assertEquals("Has Seat Booked", false, airline.checkSeatStatus("321",1,'A',
                SeatClass.economy));
        airline.addSection("321",1,1,SeatClass.economy);
        airline.bookSeat("321",SeatClass.economy,1,'A');
        Assert.assertEquals("Has Seat Booked", true, airline.checkSeatStatus("321",1,'A',
                SeatClass.economy));
    }

    @Test
    void hasAvailableSeats() {
        airline.addFlight("DEN","LON",2018,5,21,"321");
        airline.addSection("321",1,1,SeatClass.economy);
        Assert.assertEquals("Has Available Seat", true, airline.hasAvailableSeats("DEN","LON"));
        airline.bookSeat("321",SeatClass.economy,1,'A');
        Assert.assertEquals("Has Available Seat", false, airline.hasAvailableSeats("DEN","LON"));
    }

    @Test
    void checkFlightExists() {
        Assert.assertEquals("Check Flight Exists", false, airline.checkFlightExists("321"));
        airline.addFlight("DEN","LON",2018,5,21,"321");
        Assert.assertEquals("Check Flight Exists", true, airline.checkFlightExists("321"));
    }

    @Test
    void getName() {
        Assert.assertEquals("Get Name", "Airline: NZL", airline.getName());
    }

    @Test
    void setName() {
        airline.setName("QFA");
        Assert.assertEquals("Get Name", "Airline: QFA", airline.getName());
    }

    @Test
    void testToString() {
        Assert.assertEquals("To String summary", "Airline Code is: NZL", airline.toString());
    }
}