/**
 * TheatreScreen class Initializes the screen arrangement and stores its information.
 */
public class TheatreScreen {
    private int[][] seatingArrangement;
    public int maximumCapacity;
    private int currentCapacity;
    private int seatGap;
    private int rowGap;

    /**
     * constructor for the class TheatreScreen which initializes screen with maximum capacity.
     * @param noOfRows total rows.
     * @param seatsPerRow seats in a row.
     * @param seatGap distance between bookings.
     * @param rowGap distance between booked rows.
     */
    public TheatreScreen(int noOfRows,int seatsPerRow, int seatGap, int rowGap){
        maximumCapacity = (noOfRows * seatsPerRow) / 2;
        currentCapacity = 0;
        this.seatGap = seatGap;
        this.rowGap = rowGap;
        initializeSeating(noOfRows, seatsPerRow);
    }

    /**
     * It intializes the seating arrangement for the screen.
     * @param noOfRows total rows.
     * @param seatsPerRow seats in a row.
     */
    public void initializeSeating(int noOfRows, int seatsPerRow){
        seatingArrangement = new int[noOfRows][seatsPerRow];
        for(int i=1;i<seatingArrangement.length;i++){
            seatingArrangement[i][0] = -1;
            i = i + rowGap;
        }
    }

    /**
     * Getter method to check the current occupancy of the screen.
     * @return returns the current occupancy of the theatre.
     */
    public int getOccupancy(){
        return currentCapacity;
    }

    /**
     * Setter method to update the current occupancy of the screen.
     * @param noOfPeople  no of people in the screen.
     */
    public void setOccupancy(int noOfPeople){
        currentCapacity = noOfPeople;
    }

    /**
     * Getter method to check the screens seating arrangement.
     * @return returns the screens seating arrangement
     */
    public int[][] getSeatingArrangement(){
        return seatingArrangement;
    }

    /**
     * Setter method to update the current Seating Arrangement of the screen.
     * @param newArrangement  Seating Arrangement in the screen.
     */
    public void setSeatingArrangement(int[][] newArrangement){
        seatingArrangement = newArrangement;
    }

    /**
     * Getter method to check the gap between bookings in a row.
     * @return returns gap between bookings in a row.
     */
    public int getSeatGap(){
        return seatGap;
    }

    /**
     * Setter method to update the Gap between the bookings.
     * @param gap gap between two bookings in a row.
     */
    public void setSeatGap(int gap){
        seatGap = gap;
    }
}
