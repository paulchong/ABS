public class FlightSection {

    private Seat[][] seatArray;
    private SeatClass seatClass; // first, business or economy

    private final int maxRows = 100; // Maximum number of rows
    private final int maxCols = 10; //  Maximum number of columns

    private int tRows; // 100 Max
    private int tCol = 10;  // 10 Max

    //constructor
    public FlightSection (int rows, int cols, SeatClass seatClass){
        this.seatClass = seatClass;

        if (1 <= rows && rows <= maxRows)
            tRows = rows;
        else
            System.out.println("The number of Rows must be equal or less than " + maxRows);

        // Create the 2D array of seats
        seatArray = new Seat[tRows][tCol];

        for (int i = 0; i < tRows; i++){
            for (int j = 0; j < tCol; j++){
                seatArray[i][j] = new Seat(i, (char)(j + 65));
            }
        }
    }

    public void bookSeat(int row, char col){// Books the seat
        int column;
        column = (Character.getNumericValue(col) - 10);
        if (seatArray[row-1][column].getStatus() == false) {
            seatArray[row-1][column].setStatus();
            System.out.println("Seat booked at " + (row) + col);
        }

        else System.out.println("ERROR: Seat at " + row + " " + col +
                " already booked");
    }


    public int numOfFreeSeats(){
        // Returns the total number of available seats
        int total = 0;
        for (int i = 0; i < tRows; i++){
            for (int j = 0; j < tCol; j++){
                if (seatArray[i][j].getStatus() == false) total++;
            }
        }
        return total;
    }

    public SeatClass getSeatClass(){
        return seatClass;
    }

    public int getNumRows(){
        return tRows;
    }

    public int getNumCols(){
        return tCol;
    }

}