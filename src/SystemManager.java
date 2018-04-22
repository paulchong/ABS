import java.util.ArrayList;

public class SystemManager
{
    private ArrayList<Airport> airport;
    private ArrayList<Airline> airline;
    private ArrayList<Flight> flight;

    public SystemManager()
    {
        airport = new ArrayList <Airport>();
        airline = new ArrayList <Airline>();
        flight = new ArrayList <Flight>();
    }

    //create Airport
    public void createAirport(String n)
    {
        boolean check = true;
        String pattern = "[a-zA-Z][a-zA-Z][a-zA-Z]";
        if (!n.matches(pattern))//check pattern
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

        else{
            if(airline.size() != 0)//check if already been contained
                for(int i=0; i<airline.size()&& check; i++)
                    if(airline.get(i).getName() == n){
                        System.out.printf("The Airline %s has already been created.\n",n);
                        check = false;
                    }
            if(check)
                airline.add(new Airline(n));

        }
    }

    //create flight
    public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id)
    {
        boolean check = true;
        if(flight.size() != 0)//check if already been contained
            for(int i=0; i<flight.size()&& check; i++)
                if(flight.get(i).getId().equals(id) && flight.get(i).getLine().equals(aname)){
                    System.out.printf("The flight Id %s for Airline %s has already been used.\n",id,aname);
                    check = false;
                }
        if(orig == dest){
            check = false;
            System.out.printf("The originating and destination airport %s cannot be the same.\n",orig);
        }
        if(check)
            flight.add(new Flight(aname,orig,dest,year,month,day,id));
    }

    //create seat
    public void createSeats(String air, String flID, int rows)
    {
        boolean check = true;
        for(int j=0;j<flight.size()&& check;j++)
            if(flight.get(j).getId() == flID && flight.get(j).getLine() == air){
                flight.get(j).createSeat(rows);
                check = false;
            }
        if (check)//check if the flID is correct
            System.out.printf("The flight %s does not exist.\n\n",flID);
    }

    // THIS IS NEW CODE!!

    //Creates a FlightSection
    public void createSection(String air, String flID, int rows, String seatClass){
        if(airline.isEmpty() == true){
            System.out.println("ERROR:"+"Cannot add a section, airline does not exist");
        }
        else {
            boolean airlineNotFound = true;
            // First, find airline

            for (int i=0; i<flight.size();i++){
                if(flight.get(i).getId().equals(flID)){
                    airlineNotFound = false;

                    flight.get(i).addSection(rows, seatClass);
                }
            }
            if (airlineNotFound) System.out.println("ERROR: Cannot add a section, "
                    + air + " airline does not exist");
        }
    }

    // THIS IS WHERE NEW CODE ENDS!!


    //find flight
    public void findAvailableFlights(String orig, String dest)
    {
        int count=0;
        System.out.println("\nThe flights from " + orig + " to " + dest + ":");

        for(int i=0; i<flight.size(); i++)
            if (flight.get(i).getOrig()== orig && flight.get(i).getDest() == dest){
                System.out.println(flight.get(i));
                count++;
            }
        System.out.println();
        if(count==0)
            System.out.println("No flight is available.");
    }

    //book seat
    public void bookSeat(String air, String fl, int row, char col)
    {
        boolean check = true;
        for(int i=0; i<flight.size()&& check; i++)
            if (flight.get(i).getLine()== air && flight.get(i).getId() == fl){
                flight.get(i).bookSeat(row,col);
                check = false;
            }
        if (check)
            System.out.println("The flight does not exist.");
    }

    public void displaySystemDetails()
    {
/*        System.out.println("\nAirports:");
        for (int i = 0; i < airport.size(); i++)
            System.out.println(airport.get(i));
        System.out.println("\nAirlines:");
        for (int i = 0; i < airline.size(); i++)
            System.out.println(airline.get(i));
        System.out.println("\nFlights:");
        for (int i = 0; i < flight.size(); i++)
            System.out.println(flight.get(i));
        System.out.println("\nSections:");
        for (int i = 0; i < flight.size(); i++)
            System.out.println(flight.get(i)); */
        for (int i = 0; i < flight.size(); i++)
            System.out.println(flight.get(i));
        for (int i = 0; i < flight.size(); i++)
            flight.get(i).output();
    }
}