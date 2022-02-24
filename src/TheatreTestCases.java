import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TheatreTestCases {

    /**
     * It tests the case in which a reservation has more than 20 people
     */
    public void largegroupTesting(){
        TheatreScreen screen = new TheatreScreen(10, 20, 3, 1);
        TheatreService service = new TheatreService();
        Main main = new Main();
        System.out.println();
        System.out.println("Testcase for Max bookings for a user");
        Reservation r1 = new Reservation("R001", 21);
        Reservation r2 = new Reservation("R002", 20);
        Reservation[] reservations = {r1, r2};
        for(Reservation r: reservations){
            service.bookSeats(screen, r);
        }
        main.showReservation(Arrays.asList(reservations));
        System.out.println("When a large group comes in for reservation, the reservation is not accepted");
        System.out.println("==============================");

    }

    /**
     * It tests the case in which a reservation cannot be booked since there are more than 20 people in a row
     */
    public void availabilityperrowTesting(){
        TheatreScreen screen = new TheatreScreen(10, 20, 3, 1);
        TheatreService service = new TheatreService();
        Main main = new Main();
        Reservation r1 = new Reservation("R001", 10);
        Reservation r2 = new Reservation("R002", 10);
        Reservation r3 = new Reservation("R003", 10);
        Reservation r4 = new Reservation("R004", 10);
        Reservation r5 = new Reservation("R005", 10);
        Reservation r6 = new Reservation("R006", 7);
        Reservation r7 = new Reservation("R007", 8);
        Reservation[] reservations = {r1, r2, r3, r4, r5, r6, r7};

        System.out.println();
        System.out.println("Testcase for booking to be done in single row");
        for(Reservation r: reservations){
            service.bookSeats(screen, r);
        }
        main.showReservation(Arrays.asList(reservations));
        System.out.println("When a row does not have enough seats for a group, the reservation is not accepted");
        System.out.println("==============================");
    }

    /**
     * It tests the case in which a reservation has negative number of people
     */
    public void negativeNumberOfPeopleTesting(){
        TheatreScreen screen = new TheatreScreen(10, 20, 3, 1);
        TheatreService service = new TheatreService();
        Main main = new Main();
        System.out.println();
        System.out.println("Testcase for negitive no of people for a reservation");
        Reservation r1 = new Reservation("R001", -10);
        service.bookSeats(screen, r1);
        main.showReservation(Arrays.asList(new Reservation[]{r1}));
        System.out.println("When a negative number of people is encountered, message is presented");
        System.out.println("==============================");
    }

    /**
     * It tests the case in which a reservation has 0 number of people
     */
    public void zeroNumberOfPeopleTesting(){
        TheatreScreen screen = new TheatreScreen(10, 20, 3, 1);
        TheatreService service = new TheatreService();
        Main main = new Main();
        System.out.println();
        System.out.println("Testcase for zero no of people for a reservation");
        Reservation r1 = new Reservation("R001", 0);
        service.bookSeats(screen, r1);
        main.showReservation(Arrays.asList(new Reservation[]{r1}));
        System.out.println("When number of people is 0, message is presented");
        System.out.println("==============================");
    }

    /**
     * It tests the case in which the inputFile name is not given
     */
    public void nullFilenameTesting() throws IOException {
        System.out.println();
        System.out.println("Testcase for passing a null file");
        try {
            String inputFilename = null;
            Main main = new Main();
            List<Reservation> reservations = main.store_input(inputFilename);
        }
        catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }
        System.out.println("When no file is passed as an input, NullPointerException is thrown");
        System.out.println("==============================");
    }

    /**
     * It tests the case in which the inputFile does not exist.
     */
    public void nonExistentFileTesting() throws IOException {
        System.out.println();
        System.out.println("Testcase for passing a non existing file");
        try {
            String inputFilename = "xyz.txt";
            Main main = new Main();
            List<Reservation> reservations = main.store_input(inputFilename);
        }
        catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }
        System.out.println("When a file that does not exist is passed, FileNotFound exception is thrown");
        System.out.println("==============================");
    }

    /**
     * It tests the case in which the inputFile contains duplicate values for ReservationID
     */
    public void duplicateReservations() throws IOException{
        System.out.println();
        System.out.println("Testcase for duplicate reservations for an ID");

        Main main = new Main();
        List<Reservation> reservations = main.store_input("/Users/akhilkarrothu/Desktop/WalmartChallenge/Input.txt");
        TheatreScreen screen = new TheatreScreen(10, 20, 3, 1);
        TheatreService service = new TheatreService();
        for(Reservation r: reservations){
            service.bookSeats(screen, r);
        }
        main.showReservation(reservations);
        System.out.println("When a file contains duplicate reservations, the sum of number of people is taken and treated as a single group");
        System.out.println("==============================");
    }

    /**
     * It runs all the test case functions.
     */
    public void runAllTestCases() throws IOException{
        System.out.println("==============================");
        System.out.println("Running all test cases");
        System.out.println("==============================");
        largegroupTesting();
        availabilityperrowTesting();
        negativeNumberOfPeopleTesting();
        zeroNumberOfPeopleTesting();
        nullFilenameTesting();
        duplicateReservations();
        nonExistentFileTesting();
    }
}
