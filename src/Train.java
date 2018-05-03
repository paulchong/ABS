import java.util.ArrayList;
import java.util.Calendar;

public class Train extends Transport {
    private String id;
    private String orig, dest;
    private int year;
    private int month;
    private int day;
    private Calendar departure;
    private String departureStatus;
    private String fuel;

    //constructor
    public Train(String orig, String dest, int year, int month, int day, String trainId){
        id = trainId;
        this.orig = orig;
        this.dest = dest;
        this.year = year;
        this.month = month ;
        this.day = day;
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
}
