import java.util.ArrayList;

public class SystemManager
{
    private ArrayList<Airport> airport;
    private ArrayList<Airline> airline;

    public SystemManager() {
        airport = new ArrayList<>();
        airline = new ArrayList<>();
    }

    //creates an Airport
    public void createAirport(String n) {
        boolean validate = true;
        String nameFormat;
        nameFormat = "[a-zA-Z][a-zA-Z][a-zA-Z]";
        if (!n.matches(nameFormat))
            System.out.println("Airport names should only have three alphabet characters.");
        else{
             for(int i=0; i<airport.size() && validate; i++)
                 if(airport.get(i).getName().equals(n)){
                    System.out.println("The Airport " + n + " has already been created.");
                    validate = false;
                 }
            if(validate)
                airport.add(new Airport(n));
        }
    }

    //creates an Airline
    public void createAirline(String n) {
        boolean validate = true;
        if (n.length()>5)
            System.out.println("Airline names should have less than 6 characters.");
        else {
            for (int i = 0; i < airline.size() && validate; i++)
                if (airline.get(i).getName().equals(n)) {
                    System.out.println("The Airline " + n + " has already been created.");
                    validate = false;
                }
            if(validate)
                airline.add(new Airline(n));
        }
    }

    //creates a flight
    public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id) {
        String nameFormat = "^[a-zA-Z0-9]*$";
        if (!id.matches(nameFormat))
            System.out.println("Flight ID must be Alphanumeric characters.");
        else if(orig.equals(dest)){
            System.out.println("Origin and destination airports cannot be the same.");
        } else {
            boolean airlineNotFound = true;
            for (int i = 0; i < airline.size(); i++) {
                if (airline.get(i).getName().equals(aname)) {
                    airlineNotFound = false;
                    airline.get(i).addFlight(orig, dest, year, month, day, id);
                }
            }
            if (airlineNotFound) System.out.println("FLIGHT ERROR: Airline " + aname + " not found");
        }
    }

    public void createSection(String air, String flID, int rows, int cols, SeatClass seatClass) {
        boolean airlineNotFound = true;
        for (int i = 0; i < airline.size(); i++) {
            if (airline.get(i).getName().equals(air)) {
                airlineNotFound = false;
                airline.get(i).addSection(flID, rows, cols, seatClass);
            }
        }
            if (airlineNotFound) System.out.println("SECTION ERROR: Airline " + air + " not found");
     }

    public void bookSeat(String air, String fl, SeatClass s, int row, char col) {
        boolean airlineNotFound = true;
        for (int i = 0; i < airline.size(); i++) {
            if (airline.get(i).getName().equals(air)) {
                airlineNotFound = false;
                airline.get(i).bookSeat(fl, s, row, col);
            }
        }
        if (airlineNotFound) System.out.println("ERROR: Airline " + air + " not found");
    }

    public void displaySystemDetails()
    {
        System.out.println("\nAirports:");
        for (int i = 0; i < airport.size(); i++)
            System.out.println(airport.get(i));
        System.out.println("\nAirlines:");
        for (int i = 0; i < airline.size(); i++)
            System.out.println(airline.get(i));
    }

    public void findAvailableFlights(String orig, String dest){
        System.out.println("\nThe following flights from " + orig + " to " + dest + " have seats available:");
        for(int i=0; i<airline.size(); i++) {
            airline.get(i).hasAvailableSeats(orig, dest);
        }
    }
}