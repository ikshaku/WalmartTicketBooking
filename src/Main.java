import java.io.*;
import java.util.*;
/**
 * Main class from where the execution starts. It contains the main method which handles the
 * input and output.
 */
public class Main {
     /**
     * It reads the input from the file and writes it into a reservations array
     * @param filename name of the file
     */
    public static List<Reservation> store_input(String filename) throws IOException {
        List<Reservation> reservations = new ArrayList<>();
        List<String> ids = new ArrayList<>(); // To store the IDs of the reservations
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                String[] splitLine = inputLine.split(" ");
                // If duplicate ID is encountered
                if (ids.contains(splitLine[0])) {
                    for(Reservation r: reservations){
                        // Update the number of people by taking sum
                        if(r.getID().equals(splitLine[0])){
                            r.setNoOfPeople(r.getNoOfPeople() + Integer.parseInt(splitLine[1]));
                        }
                    }
                } else {
                    ids.add(splitLine[0]);
                    Reservation newReservation = new Reservation(splitLine[0], Integer.parseInt(splitLine[1]));
                    reservations.add(newReservation);
                }
            }
        }
        return reservations;
    }

    /**
     * It prints out the reservations from a List of reservations
     * @param reservations List that has the reservations
     */
    public static void showReservation(List<Reservation> reservations){
        for(Reservation r: reservations){
            System.out.println(r.toString());
        }
    }

    /**
     * It writes all the reservations in array to an output file
     * @param reservations List that has the reservations
     * @param filename name of the output file
     */
    public static String storeReservation(List<Reservation> reservations, String filename) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Reservation r : reservations) {
                writer.write(r.toString() + "\n");
            }
            return new String("Directory: " + System.getProperty("user.dir") + " Filename: " + filename);
        }
    }

    /**
     * It takes the input file and creates objects for the classes and performs necessary calls.
     * @param args command line arguments
     */
    public static void main(String[] args) throws IOException {
        //String inputFilename = args[0];
        String inputFilename = args[0];
        List<Reservation> reservations = store_input(inputFilename);
        TheatreScreen screen = new TheatreScreen(10, 20, 3, 1);
        TheatreService service = new TheatreService();
        for(Reservation r: reservations){
            service.bookSeats(screen, r);
        }
        showReservation(reservations);
        String output_path = storeReservation(reservations, "output.txt");
        System.out.println(output_path);
        // TheatreTestCases test = new TheatreTestCases();
        // test.runAllTestCases();
    }
}
