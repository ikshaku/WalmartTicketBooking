
/**
 * TheatreService class  will create a reservation, Shows the reservation and
 * Stores the reservation.
 */
public class TheatreService {

    /**
     * It books seats for the particular reservation
     * @param screen object of the selected screen
     * @param reservation object with ID and number of people in the booking
     */
    public void bookSeats(TheatreScreen screen, Reservation reservation){
        // Condition to check if theatre permits for more bookings.
        if(screen.getOccupancy() + reservation.getNoOfPeople() > screen.maximumCapacity){
            reservation.setErrorMessage("Cannot Accept Reservation. Housefull.");
            return;
        }
        // Condition to check non positive no of people.
        if(reservation.getNoOfPeople() <= 0){
            reservation.setErrorMessage("Cannot accept reservation. Invalid Number of people");
            return;
        }
        // Condition to check more than our limit for a reservationId
        if(reservation.getNoOfPeople() > 20){
            reservation.setErrorMessage("Cannot accept reservation. Large number of people in reservation.");
            return;
        }
        else{
            int[][] arrangement = screen.getSeatingArrangement();
            int rows = arrangement.length;
            int seats = arrangement[0].length;
            boolean isUnavailable = true;
            for(int i=0;i<arrangement.length;i++){
                // Checking for rows that are blocked to maintain safety.
                if(arrangement[i][0] == -1){
                    continue;
                }
                //Getting first empty seat in the given row.
                int firstEmptySeat = getFirstEmptySeat(arrangement[i]);
                // Checking if a booking can be completed in a row at once.
                boolean isSeatAvailable = checkAvailability(arrangement[i], firstEmptySeat, reservation.getNoOfPeople());

                if (!isSeatAvailable){
                    continue;
                }
                // If booking can be done making the unavailability flag false.
                isUnavailable = false;
                // Looping to book seats for a reservation Id and store the ID of the seat.
                for(int person=0;person<reservation.getNoOfPeople();person++){
                    arrangement[i][firstEmptySeat] = 1;
                    String new_seat = "" + (char) ('A' + rows - i - 1) + (firstEmptySeat+1);
                    reservation.addSeat(new_seat);
                    firstEmptySeat++;
                }
                // Maintaining seat gap between each booking.
                int seatGap = screen.getSeatGap();
                while(firstEmptySeat<seats && seatGap > 0){
                    arrangement[i][firstEmptySeat] = -1;
                    firstEmptySeat++;
                    seatGap = seatGap - 1;
                }
                //Updating the Occupancy of the screen.
                screen.setOccupancy(screen.getOccupancy() + reservation.getNoOfPeople());
                //Updating the seating arrangement of the screen
                screen.setSeatingArrangement(arrangement);
                break;
            }

            if(isUnavailable){
                reservation.setErrorMessage("Cannot Accept Reservation. Not enough seats in a single row.");
            }
        }
    }

    /**
     * It gets the first empty seat in the row if exists.
     * @param row row in the theatre
     * @return returns the index of the empty seat or the row length.
     */
    private int getFirstEmptySeat(int[] row){
        for(int i = 0;i<row.length;i++){
            if(row[i] == 0){
                return i;
            }
        }
        return row.length;
    }

    /**
     * It checks whether there is availability of seats in the row for particular booking.
     * @param row row in the theatre
     * @param emptySeatIndex index of the empty seat in the row
     * @param noOfPeople no of people that needs seats in the booking
     */
    private boolean checkAvailability(int[] row, int emptySeatIndex, int noOfPeople){
        int availableSeats = row.length - emptySeatIndex;
        return (noOfPeople <= availableSeats);
    }

}

