# WalmartTicketBooking
Walmart Challenge

# Walmart Ticket Booking

Walmart homework assignment to design and write a seat assignment
program to maximize both customer satisfaction and customer
safety. For the purpose of public safety, assuming that a buffer of three
seats and/or one row is required.

## Assumptions:
1. The seats will be allotted in the order in which reservations are present in the input file.
 (First come first serve).
2. Seats will be allotted from the top row(J) for a better viewing appearence.
4. If seats are available in any of the top rows, then, they will be allotted first while keeping in mind the COVID restrictions.
5. Breaking up a large party during a reservation is not possible since in these unprecedented times, it may not be comfortable for the customers. Therefore, if seats are not available in a single row, then, their reservation will not be accepted automatically by the application. They can then take it offline 
and discuss the placement.
6. The maximum number of seats in a particular reservation is 20. Reservations larger than that will be
 taken offline and discussed with the customers.
7. To avoid very large gathering at one particular section, alternate rows have already been marked as unavailable before reservations are even accepted. This has been implemented keeping in mind the government guidelines and safety rules.
8. In case the same reservation ID occurs multiple times, it is read as one reservation. The number of people is the total number of people given for each duplicate reservation.

## Solution

### Classes
1. TheatreScreen: Stores the information about the screen such as the occupancy, dimensions and the seating arrangement.
2. TheatreService: Implements methods to createreservations, showReservations and storeReservations in a file.
3. Reservation: Stores the information of each reservation such as the ID, seats or errorMessge if any.
4. Main: The driver class which reads from the input file, creates the necessary objects and calls the relevant functions.

### Steps to run the program
Running the Main program will read the input from Input.txt and output the directory and filename of the output file.
We have specified the input file and the name of the output file in the main program already.

The commands to run from the terminal are as follows:
``` 
javac Main.java
java Main <full-path to the Input file>
```
For example:
``` 
javac Main.java
java Main /Users/ikshakugoswami/Desktop/WalmartTicketBooking/Input.txt
```
### Output
* Prints the reservation ID and the seat alloted to each reservation in the order in which the reservations were recieved.

* In case the reservation was not accepted, the ID of the reservation and the reason for not accepted it will be printed.

* The directory and the filename of the output will also be printed.

For example:
```
R001 J1, J2
R002 H1, H2, H3, H4, H5, H6, H7, H8, H9, H10, H11, H12, H13, H14, H15, H16, H17, H18, H19, H20
R003 J6, J7, J8, J9, J10, J11, J12, J13, J14, J15, J16, J17
R004 F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13
R005 D1, D2, D3, D4, D5, D6, D7, D8, D9
R006 F17, F18, F19, F20
R007 B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20
R008 D13, D14, D15, D16, D17, D18, D19, D20
R009 Cannot Accept Reservation. Not enough seats in a single row.
R010 Cannot accept reservation. Large number of people in reservation.
Directory: /Users/ikshakugoswami/Desktop/WalmartTicketBooking/output.txt
```

## Running the tests
The function runAllTestCases() from TheatreTestCases Class needs to be called to run all the test cases.

The output after running this function is as follows:
```
R001 Cannot accept reservation. Large number of people in reservation.
R002 J1, J2, J3, J4, J5, J6, J7, J8, J9, J10, J11, J12, J13, J14, J15, J16, J17, J18, J19, J20
R003 H1, H2, H3, H4, H5, H6, H7, H8, H9, H10, H11, H12
R004 F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13
R005 D1, D2, D3, D4, D5, D6, D7, D8, D9
R006 H16, H17, H18, H19
R007 B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20
R008 D13, D14, D15, D16, D17, D18, D19, D20
R009 Cannot Accept Reservation. Not enough seats in a single row.
R010 Cannot Accept Reservation. Housefull.
Directory: /Users/ikshakugoswami/Desktop/WalmartTicketBooking/src/output.txt
==============================
Running all test cases
==============================

Testcase for Max bookings for a user
R001 J1, J2, J3, J4, J5, J6, J7, J8, J9, J10, J11, J12, J13, J14, J15, J16, J17, J18, J19, J20
R002 Cannot accept reservation. Large number of people in reservation.
When a large group comes in for reservation, the reservation is not accepted
==============================

Testcase for booking to be done in single row
R001 J1, J2, J3, J4, J5, J6, J7, J8, J9, J10
R002 H1, H2, H3, H4, H5, H6, H7, H8, H9, H10
R003 F1, F2, F3, F4, F5, F6, F7, F8, F9, F10
R004 D1, D2, D3, D4, D5, D6, D7, D8, D9, D10
R005 B1, B2, B3, B4, B5, B6, B7, B8, B9, B10
R006 J14, J15, J16, J17, J18, J19, J20
R007 Cannot Accept Reservation. Not enough seats in a single row.
When a row does not have enough seats for a group, the reservation is not accepted
==============================

Testcase for negitive no of people for a reservation
R002 Cannot accept reservation. Invalid Number of people
When a negative number of people is encountered, message is presented
==============================

Testcase for zero no of people for a reservation
R001 Cannot accept reservation. Invalid Number of people
When number of people is 0, message is presented
==============================

Testcase for passing a null file
java.lang.NullPointerException
When no file is passed as an input, NullPointerException is thrown
==============================

Testcase for duplicate reservations for an ID
R001 Cannot accept reservation. Large number of people in reservation.
R002 J1, J2, J3, J4, J5, J6, J7, J8, J9, J10, J11, J12, J13, J14, J15, J16, J17, J18, J19, J20
R003 H1, H2, H3, H4, H5, H6, H7, H8, H9, H10, H11, H12
R004 F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13
R005 D1, D2, D3, D4, D5, D6, D7, D8, D9
R006 H16, H17, H18, H19
R007 B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20
R008 D13, D14, D15, D16, D17, D18, D19, D20
R009 Cannot Accept Reservation. Not enough seats in a single row.
R010 Cannot Accept Reservation. Housefull.
When a file contains duplicate reservations, the sum of number of people is taken and treated as a single group
==============================

Testcase for passing a non existing file
java.io.FileNotFoundException: xyz.txt (No such file or directory)
When a file that does not exist is passed, FileNotFound exception is thrown
==============================

```

