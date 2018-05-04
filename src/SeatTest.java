import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeatTest {
    private Seat seat;

    @BeforeEach
    void setUp() {
        seat= new Seat(1, 'A');
    }

    @Test
    void setRow() {
        seat.setRow(2);
        Assert.assertEquals("Set Row", 2, seat.getRow());
    }

    @Test
    void setCol() {
        seat.setCol('B');
        Assert.assertEquals("Set Col", 'B', seat.getCol());
    }

    @Test
    void setStatus() {
        seat.setStatus();
        Assert.assertEquals("Set Status", true, seat.getStatus());
    }

    @Test
    void getRow() {
        seat.getRow();
        Assert.assertEquals("Get Row", 1, seat.getRow());
    }

    @Test
    void getCol() {
        seat.getCol();
        Assert.assertEquals("Get Col", 'A', seat.getCol());
    }

    @Test
    void getStatus() {
        seat.getStatus();
        Assert.assertEquals("Get Status", false, seat.getStatus());
    }

    @Test
    void testToString() {
        Assert.assertEquals("Seat: 1A", seat.toString());
    }
}