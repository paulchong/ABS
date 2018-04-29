//Airport.java
public class Airport implements Facilities {
    private String name;
    private String longitude;
    private String latitude;

    //constructor
    public Airport(String n) {
        if (n.length() != 3)
            throw new IllegalArgumentException
                    ("Airport name must be 3 characters long.");
        else name = n;
    }

    public Airport(String n, String lat, String lon) {
        if (n.length() != 3)
            throw new IllegalArgumentException
                    ("Airport name must be 3 characters long.");
        else name = n;
        latitude = lat;
        longitude = lon;
    }

    //get and set name
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name = n;
    }

    public String getLocation(){
        return longitude + " " + latitude;
    }

    public String toString()
    {
        return "Airport Name: "+name;
    }
}