import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.swing.SwingUtilities2;

import static org.junit.jupiter.api.Assertions.*;

class FlightSectionTest {
    private FlightSection section;

    @BeforeEach
    void setUp() {
        section = new FlightSection(1, 2, SeatClass.economy);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void bookSeat() {
        section.bookSeat(1, 'A');
        Assert.assertEquals("Book Seat", true, section.checkSeatStatus(1, 'A'));
        Assert.assertEquals("Book Seat", false, section.checkSeatStatus(1, 'B'));
    }

    @Test
    void hasAvailableSeats() {
        Assert.assertEquals("Has Available Seat", true, section.hasAvailableSeats());
        section.bookSeat(1, 'A');
        section.bookSeat(1, 'B');
        Assert.assertEquals("Has Available Seat", false, section.hasAvailableSeats());

    }

    @Test
    void getSeatClass() {
        Assert.assertEquals("Get Seat Class", SeatClass.economy, section.getSeatClass());
    }

    @Test
    void getNumRows() {
        Assert.assertEquals("Get Number of Rows", 1, section.getNumRows());
    }

    @Test
    void getNumCols() {
        Assert.assertEquals("Get Number of Rows", 2, section.getNumCols());
    }
}