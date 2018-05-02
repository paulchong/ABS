import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    private Flight flight;

    @BeforeEach
    void setUp() {
        flight= new Flight("DEN", "LON", 2018, 5, 21, "321");
    }

    @Test
    void setID() {
        flight.setID("333");
        Assert.assertEquals("Set ID", "333", flight.getId());
    }

    @Test
    void setOrig() {
        flight.setOrig("AKL");
        Assert.assertEquals("Set Origin", "AKL", flight.getOrig());
    }

    @Test
    void setDest() {
        flight.setDest("BNE");
        Assert.assertEquals("Set Destination", "BNE", flight.getDest());
    }

    @Test
    void setYear() {
        flight.setYear(2019);
        Assert.assertEquals("Set Year", 2019, flight.getYear());
    }

    @Test
    void setMonth() {
        flight.setMonth(2);
        Assert.assertEquals("Set Month", 2, flight.getMonth());
    }

    @Test
    void setDay() {
        flight.setDay(9);
        Assert.assertEquals("Set Day", 9, flight.getDay());
    }

    @Test
    void getId() {
        Assert.assertEquals("Get ID", "321", flight.getId());
    }

    @Test
    void getOrig() {
        Assert.assertEquals("Get Origin", "DEN", flight.getOrig());
    }

    @Test
    void getDest() {
        Assert.assertEquals("Get Destination", "LON", flight.getDest());
    }

    @Test
    void getYear() {
        Assert.assertEquals("Get Year", 2018, flight.getYear());
    }

    @Test
    void getMonth() {
        Assert.assertEquals("Get Month", 5, flight.getMonth());
    }

    @Test
    void getDay() {
        Assert.assertEquals("Get Day", 21, flight.getDay());
    }

    @Test
    void addSection() {
        Assert.assertEquals("Has Available Seat", false, flight.hasAvailableSeats());
        flight.addSection(1,1,SeatClass.business);
        Assert.assertEquals("Has Available Seat", true, flight.hasAvailableSeats());
    }

    @Test
    void bookSeat() {
        Assert.assertEquals("Has Seat Booked", false, flight.checkSeatStatus(1,'A',
                SeatClass.economy));
        flight.addSection(1,1,SeatClass.economy);
        flight.bookSeat(SeatClass.economy,1,'A');
        Assert.assertEquals("Has Seat Booked", true, flight.checkSeatStatus(1,'A',
                SeatClass.economy));
    }

    @Test
    void hasAvailableSeats() {
        flight.addSection(1,1,SeatClass.economy);
        Assert.assertEquals("Has Available Seat", true, flight.hasAvailableSeats());
        flight.bookSeat(SeatClass.economy,1,'A');
        Assert.assertEquals("Has Available Seat", false, flight.hasAvailableSeats());
    }

    @Test
    void getDepartureStatus() {
        Assert.assertEquals("Get Departure Status", "scheduled", flight.getDepartureStatus());
        flight= new Flight("DEN", "LON", 2011, 5, 21, "321");
        Assert.assertEquals("Get Departure Status", "departed", flight.getDepartureStatus());
    }

    @Test
    void testToString() {
        Assert.assertEquals("To String summary", "Flight 321 from DEN to LON on the date 5.21.2018",
                flight.toString());
    }
}