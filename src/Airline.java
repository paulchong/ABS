//Airline.java
public class Airline
{
    private String name;

    //constructor
    public Airline(String n)
    {
        name = n;
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

    public String toString()
    {
        return "Airline Name: "+name;
    }
}