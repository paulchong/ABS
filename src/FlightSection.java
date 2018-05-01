public class FlightSection {

    private Seat[][] seatArray;
    private SeatClass seatClass; // first, business or economy
    private final int maxRows = 100; // Maximum number of rows
    private final int maxCols = 10; //  Maximum number of columns
    private int tRows;
    private int tCols;

    //constructor
    public FlightSection (int rows, int cols, SeatClass seatClass){
        this.seatClass = seatClass;

        if (1 <= rows && rows <= maxRows && 1 <= cols && cols <= maxCols) {
            tRows = rows;
            tCols = cols;
            seatArray = new Seat[tRows][tCols];

            for (int i = 0; i < tRows; i++){
                for (int j = 0; j < tCols; j++){
                    seatArray[i][j] = new Seat(i, (char)(j + 65));
                }
            }
        } else {
            System.out.println("The number of Rows and Columns must be at least 1, and equal or less than "
                    + maxRows + " and " + maxCols + ", respectively");
        }
    }

    // Actually books the seat
    public void bookSeat(int row, char col){
        int column;
        column = (Character.getNumericValue(col) - 10);
        if (seatArray[row-1][column].getStatus()) {
            System.out.println("ERROR: Seat at " + row + " " + col +
                    " is already booked");
        } else {
            seatArray[row-1][column].setStatus();
            System.out.println("Seat booked at " + row + col);
        }
    }

    // Returns true if at least one seat is available, otherwise returns false
    public boolean hasAvailableSeats(){
        for (int i = 0; i < tRows; i++){
            for (int j = 0; j < tCols; j++){
                if (!seatArray[i][j].getStatus()) {
//                    System.out.println("true!");
                    return true;
                }

            }
        }
        return false;
    }

    public SeatClass getSeatClass() { return seatClass; }

    public int getNumRows() { return tRows; }

    public int getNumCols() { return tCols; }
/*
    // Returns total number of available seats
    public int numOfFreeSeats(){
        int total = 0;
        for (int i = 0; i < tRows; i++){
            for (int j = 0; j < tCols; j++){
                if (seatArray[i][j].getStatus() == false) total++;
            }
        }
        return total;
    }
*/

}