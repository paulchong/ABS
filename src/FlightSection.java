public class FlightSection {

    private Seat[][] seatArray;
    private SeatClass seatClass; // first, business or economy
    private final int maxRows = 100; // Maximum number of rows
    private final int maxCols = 10; //  Maximum number of columns
    private int rows;
    private int cols;
    private String seatPreference;  // Window or Aisle

    //constructor
    public FlightSection (int rows, int cols, SeatClass seatClass){
        this.seatClass = seatClass;

        if (1 <= rows && rows <= maxRows && 1 <= cols && cols <= maxCols) {
            this.rows = rows;
            this.cols = cols;
            seatArray = new Seat[rows][cols];

            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
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
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (!seatArray[i][j].getStatus()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSeatStatus(int row, char col) {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(seatArray[i][j].getRow() == row-1 && seatArray[i][j].getCol() == col) {
                    return seatArray[i][j].getStatus();
                }
            }
        }
        System.out.println("Seat not found");
        return false;
    }

    // Getters and Setters
    public SeatClass getSeatClass() { return seatClass; }

    public int getNumRows() { return rows; }

    public int getNumCols() { return cols; }



    // Books seat with Window/Aisle Preference
    public void bookSeat(int row, char col, String seatPref){
        int column;
        seatPreference = seatPref;
        column = (Character.getNumericValue(col) - 10);
        if (seatArray[row-1][column].getStatus()) {
            System.out.println("ERROR: Seat at " + row + " " + col +
                    " is already booked");
        } else {
            seatArray[row-1][column].setStatus();
            System.out.println("Seat booked at " + row + col);
        }
    }
}