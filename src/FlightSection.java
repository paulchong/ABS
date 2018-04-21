public class FlightSection {

    private Seat[][] seatArray;
    private String seatClass; // first, business or economy

    private final int maxRows = 100; // Maximum number of rows
    private final int maxCols = 10; //  Maximum number of columns

    private int tRows; // 100 Max
    private int tCol = 10;  // 10 Max

    public String getSeatClass(){
        return seatClass;
    }


    //constructor
    public FlightSection (int rows, String seatClass){
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
}