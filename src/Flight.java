import java.util.ArrayList;
import java.util.List; // NEW CODE

public class Flight
{
    private String line;
    private String id;
    private Seat[][] seat; // should remove this
    private String orig, dest;
    private int year;
    private int month;
    private int day;

    //NEW CODE
//    private ArrayList<FlightSection> Sections;

    private List<FlightSection> Sections;



    //constructor
    public Flight(String l, String o, String d, int y, int m, int da, String id)
    {
        line = l;
        this.id = id;
        orig = o;
        dest = d;
        year = y;
        month = m;
        day = da;
        Sections = new ArrayList<>();
    }

    //set and get methods
    public void setLine(String l)
    {
        line = l;
    }
    public void setID(String id)
    {
        this.id = id;
    }

    public void setOrig(String o)
    {
        orig = o;
    }
    public void setDest(String d) { dest = d; }
    public void setYear(int y)
    {
        year = y;
    }
    public void setMonth(int m)
    {
        month = m;
    }
    public void setDay(int da)
    {
        day = da;
    }

    public String getLine()
    {
        return line;
    }
    public String getId()
    {
        return id;
    }
    public String getOrig()
    {
        return orig;
    }
    public String getDest()
    {
        return dest;
    }
    public int getYear()
    {
        return year;
    }
    public int getMonth()
    {
        return month;
    }
    public int getDay() { return day; }
    public Seat getSeat(int i, int j)
    {
        return seat[i][j];
    }

    //create seat and book seat
    public void createSeat(int row)
    {
        seat = new Seat[row][6];

        for (int i = 0; i < row; i++)
            for (int j = 0; j < 6; j++)
                seat[i][j] = new Seat(i, (char)(j + 65));
    }

    // NEW CODE !!!!
    public void addSection(int rows, String seatClass){
        Sections.add(new FlightSection(rows, seatClass));
    }

    public int checkSectionExists (String sc){
        // Returns -1 if section does not exist
        for (int i = 0; i < Sections.size(); i++){
            String temp = Sections.get(i).getSeatClass();
            if (temp.equals(sc))
                return i;
        }
        return -1;
    }


    public void output(){
        System.out.println("     Flight " + id + " from "
                +orig+" to "+ dest +" on the date "+month+"."
                +day+"."+year+" Seats available: ");
        for (int i = 0; i < Sections.size(); i++){
            int totalSeats = (Sections.get(i).getNumCols() *
                    (Sections.get(i).getNumRows()));
            System.out.println("          "+Sections.get(i).getSeatClass() + " class: "
                    + Sections.get(i).numOfFreeSeats() +
                    " out of " + totalSeats +
                    " seats available ");
        }
        System.out.println(""); //will say if there are seats available or not
    }




    // NEW CODE ENDS!!!!



    public void bookSeat(int row, char col)
    {
        if (row > seat.length || col > 70 || col < 65)
            System.out.printf("Seat (%d,%c) is invaild.\n",row,col);
        else{
            if(!seat[row-1][(int)col - 65].getStatus())
                seat[row-1][(int)col - 65].setStatus();
            else
                System.out.printf("Seat (%d,%c) has been reserved.\n",row,col);
        }
    }

    //toString method
    public String toString()
    {
        String seats = "";
        if (seat != null){
            for (int i = 0; i < seat.length; i++)
                for (int j = 0; j < seat[i].length; j++)
                    if (seat[i][j].getStatus())
                        seats += seat[i][j].toString()+"\t";
        }
        else
            seats = "None";
        if (seats.equals(""))
            seats = "Not reserved";
        return "Airline: "+line+" Flight ID: "+id+" Originating Airport: "+orig+" Destination Airpot: "+dest+" Reserved seat: "+seats;
    }
}