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
        res.createSeats("HNAIR", "7842", 25);//invalid-7842 not created
        res.createSeats("WSJET", "3867", 36);

//Create sections
        res.createSeats("JET","123", 2);
//        res.createSection("JET","123", 2, 2, SeatClass.economy);
//        res.createSection("JET","123", 1, 3, SeatClass.economy);
//        res.createSection("JET","123", 2, 3, SeatClass.first);
//        res.createSection("DELTA","123", 1, 1, SeatClass.business);
//        res.createSection("DELTA","123", 1, 2, SeatClass.economy);
//        res.createSection("SWSERTT","123", 5, 5, SeatClass.economy); // invalid



//display system details and check available flights
        System.out.println("SECTION 2");
        res.displaySystemDetails();
        res.findAvailableFlights("DEN", "LON");


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
        res.displaySystemDetails();
        res.findAvailableFlights("DEN", "LON");
    }
}

/*
BACK:
1.  update the createSeat method to be createSection
    1.1:  DATE ADDED
    1.2: add checks for whether date and seat are available.  could simplify and only include flight-date as an instance.  don't need to reuse flight numbers.
    1.3: print out date along with other information on a flight
2.  update createFlight arguments
3.  update bookSeat arguments (need to add a SeatClass to createSection() and Flight object.  this should be an enum type)
4.  update findAvailableFlights method to include date parameter
*/






/*
output

The name of airport R34 should be only three alphabetic characters.
The name of airport BEIJING should be only three alphabetic characters.
The name of airport 123 should be only three alphabetic characters.
The name of airline FRONTIER should have less than 6 characters.

The flight Id 3867 for Airline AC has already been used.
The originating and destination airport YEG cannot be the same.

The flights from YHZ to JFK:
Airline: AC Flight ID: 3867 Originating Airport: YHZ Destination Airpot: JFK Reserved seat: None
Airline: HNAIR Flight ID: 3867 Originating Airport: YHZ Destination Airpot: JFK Reserved seat: None

The flight 7842 does not exist.

Seat (20,N) is invaild.
The flight does not exist.
Seat (78,C) is invaild.

Airports:
Airport Name: YHZ
Airport Name: bei
Airport Name: JFK
Airport Name: YYC
Airport Name: YEG

Airlines:
Airline Name: AC
Airline Name: CA
Airline Name: HNAIR
Airline Name: WSJET

Flights:
Airline: AC Flight ID: 3867 Originating Airport: YHZ Destination Airpot: JFK Reserved seat: 15C
Airline: CA Flight ID: 567 Originating Airport: YEG Destination Airpot: YYC Reserved seat: None
Airline: HNAIR Flight ID: 3867 Originating Airport: YHZ Destination Airpot: JFK Reserved seat: None
Airline: WSJET Flight ID: 3867 Originating Airport: YHZ Destination Airpot: BOS Reserved seat: Not reserved
*/