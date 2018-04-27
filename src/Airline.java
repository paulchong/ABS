//Airline.java
import java.util.ArrayList;


public class Airline extends Company
{
    private String name;
    private ArrayList<Flight> flight;

    //constructor
    public Airline(String n)
    {
        name = n;
    }


    // NEW CODE !!!!
    //Adds a new FlightSection to a Flight
    public void addSection(String fid, int rows, String seatClass){
        if(false){
            System.out.println("ERROR: There are no flights "
                    + "associated with this Airline");
        } else{
            for(int i = 0; i < flight.size(); i++){
                if(flight.get(i).getId().equals(fid)){
                    // Needs updated parameters
                    if (flight.get(i).checkSectionExists(seatClass) < 0){
                        flight.get(i).addSection(rows, seatClass);
                    }
                }
            }
        }
    }
/*
    public void addSection(String fid, int rows, String seatClass){
        if(flight.isEmpty() == true){
            System.out.println("ERROR: There are no flights "
                    + "associated with this Airline");
        } else{
            for(int i = 0; i < flight.size(); i++){
                if(flight.get(i).getId().equals(fid)){
                    // Needs updated parameters
                    if (flight.get(i).checkSectionExists(seatClass) < 0){
                        flight.get(i).addSection(rows, seatClass);
                    }
                }
            }
        }
    }
*/


    // NEW CODE ENDS!!!!
    //get and set name
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name = n;
    }

    public String toString()
    {
        return "Airline Name: "+name;
    }
}