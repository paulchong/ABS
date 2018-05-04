public class Airport implements Facilities {
    private String name;
    private String longitude;
    private String latitude;

    //constructor
    public Airport(String n) {
        name = n;
    }

    //overloaded constructor
    public Airport(String n, String lat, String lon) {
        name = n;
        latitude = lat;
        longitude = lon;
    }

    //getters and setters
    public String getName()
    {
        return name;
    }
    public void setName(String n) {
        if (n.length() != 3)
            throw new IllegalArgumentException
                    ("Airport name must be 3 characters long.");
        else name = n;
    }
    public String getLocation(){
        return longitude + " " + latitude;
    }
    public String toString() { return "Airport Name: " + name; }
}