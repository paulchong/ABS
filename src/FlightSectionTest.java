import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.swing.SwingUtilities2;

import static org.junit.jupiter.api.Assertions.*;

class FlightSectionTest {
    private FlightSection section;
    private Seat[][] seatArray;

    @BeforeEach
    void setUp() {
        section = new FlightSection(1, 6, SeatClass.economy);

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
    }

    @Test
    void getSeatClass() {
    }

    @Test
    void getNumRows() {
    }

    @Test
    void getNumCols() {
    }
}