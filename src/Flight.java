import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Flight extends Transport
{
    private String id;
    private String orig, dest;
    private int year;
    private int month;
    private int day;
    private Calendar departure;
    private String departureStatus;
    private String fuel;
    private ArrayList<FlightSection> sections;

    //constructor
    public Flight(String orig, String dest, int year, int month, int day, String flightId){
        id = flightId;
        this.orig = orig;
        this.dest = dest;
        this.year = year;
        this.month = month ;
        this.day = day;
        sections = new ArrayList<>();
        departure = Calendar.getInstance();
        departure.set(year, month, day, 0, 0);
    }

    //set and get methods
    public void setID(String id) { this.id = id; }
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

    public void addSection(int rows, int cols, SeatClass seatClass){
        boolean classNotFound = true;
        for(int i=0; i < sections.size(); i++){
            if(sections.get(i).getSeatClass().equals(seatClass)){
                System.out.println("ERROR: Section class " + seatClass + " already exists");
                classNotFound = false;
            }
        }
        if (classNotFound)
            sections.add(new FlightSection(rows, cols, seatClass));
    }

    public void bookSeat (SeatClass seatClass, int row, char col){
        boolean classNotFound = true;
        for(int i=0; i < sections.size(); i++){
            if(sections.get(i).getSeatClass().equals(seatClass)){
                classNotFound = false;
                sections.get(i).bookSeat(row, col);
            }
        }
        if (classNotFound) System.out.println("ERROR: Section class "
                + seatClass + " not found");
    }

    // Returns true if section has at least one seat available, otherwise returns false
    public boolean hasAvailableSeats(){
        boolean output = false;
        for(int i=0; i < sections.size(); i++){
            if(sections.get(i).hasAvailableSeats()){
                output = true;
            }
        }
        return output;
    }


    public boolean checkSeatStatus(int rows, char cols, SeatClass seatClass) {
        for(int i=0; i < sections.size(); i++){
            if(sections.get(i).getSeatClass().equals(seatClass)){
                return sections.get(i).checkSeatStatus(rows, cols);
            }
        }
        System.out.println("Seat not found");
        return false;
    }

    public String getDepartureStatus(){
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        if (today.after(departure)){
            departureStatus = "departed";
        } else {
            departureStatus = "scheduled";
        }
        return departureStatus;
    }

    public String toString(){
        return "Flight " + id + " from " + orig + " to " + dest + " on the date " + month + "." + day + "." + year;
    }
}