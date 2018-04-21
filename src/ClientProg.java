public class ClientProg
{
//    public static void main (String[] args)
    public static void main(String args[])
    {
        SystemManager res = new SystemManager();

//create airports

//ORIGINAL TEST
//        http://www.chegg.com/homework-help/questions-and-answers/assignment-test-skills-object-oriented-programming-multiple-classes-use-arraylists-data-st-q19364184
//        res.createAirport("YHZ");
//        res.createAirport("R34");//invalid
//        res.createAirport("bei");
//        res.createAirport("JFK");
//        res.createAirport("YYC");
//        res.createAirport("BEIJING"); //invalid
//        res.createAirport("123");//invalid
//        res.createAirport("YEG");

        res.createAirport("DEN");
        res.createAirport("DFW");
        res.createAirport("LON");
        res.createAirport("JPN");
        res.createAirport("DE"); // invalid
        res.createAirport("DEH");
        res.createAirport("DEN");
        res.createAirport("NCE");
        res.createAirport("TRIord9"); // invalid
        res.createAirport("DEN");

//create airlines

//ORIGINAL TEST
//        res.createAirline("AC");
//        res.createAirline("CA");
//        res.createAirline("HNAIR");
//        res.createAirline("WSJET");
//        res.createAirline("FRONTIER"); //invalid

        res.createAirline("DELTA");
        res.createAirline("AMER");
        res.createAirline("JET");
        res.createAirline("DELTA");
        res.createAirline("SWEST");
        res.createAirline("AMER");
        res.createAirline("FRONT");
        res.createAirline("FRONTIER"); //invalid

//create flights

//ORIGINAL TEST
//        res.createFlight("AC", "YHZ", "JFK", "3867", 2018);
//        res.createFlight("CA", "YEG", "YYC", "567", 2018);
//        res.createFlight("HNAIR", "YHZ", "JFK", "3867", 2018);
//        res.createFlight("AC", "YYC", "YHZ", "3867", 2018);//invalid. same ID for the same airline
//        res.createFlight("HNAIR", "YEG", "YEG", "3579", 2018);//invalid. Airport is the same
//        res.createFlight("WSJET", "YHZ", "BOS", "3867", 2018);

        res.createFlight("DELTA", "DEN", "LON", 2018, 10, 10, "123");
        res.createFlight("DELTA", "DEN", "DEH", 2018, 8, 8, "567");
        res.createFlight("DELTA", "DEN", "NCE", 2019, 9, 8, "567"); // invalid
        res.createFlight("JET", "LON", "DEN", 20018, 5, 7, "123");
        res.createFlight("AMER", "DEN", "LON", 2019, 10, 1, "123");
        res.createFlight("JET", "DEN", "LON", 2018, 6, 10, "786");
        res.createFlight("JET", "DEN", "LON", 2019, 1, 12, "909");


//find available flights

//ORIGINAL TEST
//        res.findAvailableFlights("YHZ", "JFK");


//create seats
        res.createSeats("DELTA", "123", 40);
//        res.createSeats("HNAIR", "7842", 25);//invalid-7842 not created
        res.createSeats("WSJET", "3867", 36);

//Create sections
        res.createSeats("JET","123", 2);
        res.createSection("JET","123", 2, "economy");
//        res.createSection("JET","123", 1, 3, SeatClass.economy);
//        res.createSection("JET","123", 2, 3, SeatClass.first);
//        res.createSection("DELTA","123", 1, 1, SeatClass.business);
//        res.createSection("DELTA","123", 1, 2, SeatClass.economy);
//        res.createSection("SWSERTT","123", 5, 5, SeatClass.economy); // invalid



//display system details and check available flights
        System.out.println("SECTION 2");
//        res.displaySystemDetails();
//        res.findAvailableFlights("DEN", "LON");


//book seats
        res.bookSeat("AC", "3867", 15, 'C');
        res.bookSeat("AC", "3867", 20, 'N'); //invalid - N doesn't exist
        res.bookSeat("WSJET", "2671", 2, 'F'); // invalid - 2671 not created
        res.bookSeat("AC", "3867", 78, 'C'); // invalid - row 78 doesn't exist

//        res.bookSeat("DELTA", "123", 1, 'A');
//        res.bookSeat("DELTA", "123", SeatClass.economy, 1, ’A’);
//        res.bookSeat("DELTA", "123", SeatClass.economy, 1, ’B’);
//        res.bookSeat("DELTA", "123", SeatClass.business, 1, ’A’); // already booked

//Rechecking system system details after flights are booked
//        res.displaySystemDetails();
//        res.findAvailableFlights("DEN", "LON");
    }
}

/*
The name of airport DE should be only three alphabetic characters.
The Airport DEN has already been created.
The name of airport TRIord9 should be only three alphabetic characters.
The Airport DEN has already been created.
The Airline DELTA has already been created.
The Airline AMER has already been created.
The name of airline FRONTIER should have less than 6 characters.
The flight Id 567 for Airline DELTA has already been used.
The flight 7842 does not exist.

The flight 3867 does not exist.

SECTION 2
The flight does not exist.
The flight does not exist.
The flight does not exist.
The flight does not exist.

Process finished with exit code 0


 */

/*
The name of airport DE should be only three alphabetic characters.
The Airport DEN has already been created.
The name of airport TRIord9 should be only three alphabetic characters.
The Airport DEN has already been created.
The Airline DELTA has already been created.
The Airline AMER has already been created.
The name of airline FRONTIER should have less than 6 characters.
The flight Id 567 for Airline DELTA has already been used.
The flight 3867 does not exist.

Exception in thread "main" java.lang.NullPointerException
	at Airline.addSection(Airline.java:20)
	at SystemManager.createSection(SystemManager.java:103)
	at ClientProg.main(ClientProg.java:82)

Process finished with exit code 1
 */