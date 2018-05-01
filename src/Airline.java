//Airline.java
import java.util.ArrayList;


public class Airline extends Company
{
    private String name;
    private ArrayList<Flight> flights;

    //constructor
    public Airline(String n) {
        name = n;
        flights = new ArrayList<>();
    }

    public void addFlight(String orig, String dest, int year, int month, int day, String flightId){
        // TO DO: need to add validator for the code string - Alphanumeric characters, flight al
        boolean flightNotFound = true;
        for(int i=0; i < flights.size(); i++){
            if(flights.get(i).getId().equals(flightId)){
                flightNotFound = false;
                System.out.println("ERROR: Flight " + flightId + " already exists");
            }
        }
        if (flightNotFound)
            flights.add(new Flight(orig, dest, year, month, day, flightId));
    }

    //Adds a new FlightSection to a Flight
    public void addSection(String flightId, int rows, int cols, SeatClass seatClass) {
        boolean flightNotFound = true;
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getId().equals(flightId)) {
                flightNotFound = false;
                flights.get(i).addSection(rows, cols, seatClass);
            }
        }
        if (flightNotFound) System.out.println("ERROR: Flight "
                + flightId + " not found");
    }

    // refactor code so that flightNotFound is can be reused across two methods
    //Books a seat in a Flight
    public void bookSeat(String flightId, SeatClass seatClass, int row, char col) {
        boolean flightNotFound = true;
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getId().equals(flightId)) {
                flightNotFound = false;
                flights.get(i).bookSeat(seatClass, row, col);
            }
        }
        if (flightNotFound) System.out.println("ERROR: Flight "
                + flightId + " not found");
    }

    // Returns true if section has at least one seat available, otherwise returns false
    public void hasAvailableSeats(String orig, String dest){
        String output = "";
        for(int i=0; i < flights.size(); i++){
            if (flights.get(i).getOrig()== orig && flights.get(i).getDest() == dest){
                if (flights.get(i).hasAvailableSeats()){
                    output = output + flights.get(i).getId() + " ";
                    System.out.println(output);
                }
            }
        }
//        System.out.println(output);
//        return output;
    }

    //get and set name
    public String getName() { return name; }
    public void setName(String n) {name = n;}
    public String toString() { return "Airline Name: "+name; }
}