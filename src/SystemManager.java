import java.util.ArrayList;

public class SystemManager
{
    private ArrayList<Airport> airport;
    private ArrayList<Airline> airline;

    public SystemManager()
    {
        airport = new ArrayList <Airport>();
        airline = new ArrayList <Airline>();
    }

    //create Airport
    public void createAirport(String n)
    {
        boolean check = true;
        String pattern = "[a-zA-Z][a-zA-Z][a-zA-Z]";
        if (!n.matches(pattern)) //check pattern
            System.out.printf("The name of airport %s should be only three alphabetic characters.\n", n);

        else{
            if(airport.size() != 0)//check if already been contained
                for(int i=0; i<airport.size()&& check; i++)
                    if(airport.get(i).getName()== n){
                        System.out.printf("The Airport %s has already been created.\n",n);
                        check = false;
                    }
            if(check)
                airport.add(new Airport(n));
        }
    }

    //create Airline
    public void createAirline(String n)
    {
        int length = n.length();
        boolean check = true;
        if (length>=6)//check pattern
            System.out.printf("The name of airline %s should have less than 6 characters.\n",n);
        else {
            if (airline.size() != 0)//check if already been contained
                for (int i = 0; i < airline.size() && check; i++)
                    if (airline.get(i).getName() == n) {
                        System.out.printf("The Airline %s has already been created.\n", n);
                        check = false;
                    }
            if(check)
                airline.add(new Airline(n));
        }
    }

    //create flight
    public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id)
    {
        if(orig == dest){
            System.out.printf("The originating and destination airport %s cannot be the same.\n",orig);
        } else {
            boolean airlineNotFound = true;
            for (int i = 0; i < airline.size(); i++) {
                if (airline.get(i).getName().equals(aname)) {
                    airlineNotFound = false;
                    airline.get(i).addFlight(orig, dest, year, month, day, id);
//                    System.out.println("Flight " + aname + id + " " + orig + dest + " created: \n");
                }
            }
            if (airlineNotFound) System.out.println("FLIGHT ERROR: Airline "
                    + aname + " not found");
        }
    }

    public void createSection(String air, String flID, int rows, int cols, SeatClass seatClass)
    {
        boolean airlineNotFound = true;
        for (int i = 0; i < airline.size(); i++) {
            if (airline.get(i).getName().equals(air)) {
                airlineNotFound = false;
                airline.get(i).addSection(flID, rows, cols, seatClass);
//                System.out.println("Section " + seatClass + air + flID + " created: \n");
            }
        }
            if (airlineNotFound) System.out.println("SECTION ERROR: Airline "
                    + air + " not found");
     }

    public void bookSeat(String air, String fl, SeatClass s, int row, char col) {
        boolean airlineNotFound = true;
        for (int i = 0; i < airline.size(); i++) {
            if (airline.get(i).getName().equals(air)) {
                airlineNotFound = false;
                airline.get(i).bookSeat(fl, s, row, col);
            }
        }
        if (airlineNotFound) System.out.println("ERROR: Airline "
                + air + " not found");
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
        System.out.println("\n");
    }
}