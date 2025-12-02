class Train {
    private int trainNumber;
    private String trainName;
    private int totalSeats;
    private boolean[] bookedSeats;    // true = booked, false = available
    private String[] passengerNames;  // index = seatNumber - 1
    private int[] passengerAges;      // age of each passenger
    private String[] passengerBerths; // berth type for each passenger
    private double farePerSeat;       // cost of each seat

    public Train(int trainNumber, String trainName, int totalSeats, double farePerSeat) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.totalSeats = totalSeats;
        this.farePerSeat = farePerSeat;
        this.bookedSeats = new boolean[totalSeats];
        this.passengerNames = new String[totalSeats];
        this.passengerAges = new int[totalSeats];
        this.passengerBerths = new String[totalSeats];
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public double getFarePerSeat() {
        return farePerSeat;
    }

    public int getAvailableSeatCount() {
        int count = 0;
        for (boolean seat : bookedSeats) {
            if (!seat) {
                count++;
            }
        }
        return count;
    }

    public void showSeatAvailability() {
        System.out.println("Train " + trainNumber + " - " + trainName);
        System.out.println("Fare per seat: Rs." + farePerSeat);
        System.out.println("Total seats: " + totalSeats);
        System.out.println("Available seats: " + getAvailableSeatCount());
        System.out.print("Seat status (SeatNo:Status): ");
        for (int i = 0; i < totalSeats; i++) {
            String status = bookedSeats[i] ? "Booked" : "Free";
            System.out.print((i + 1) + ":" + status + "  ");
        }
        System.out.println();
    }

    public boolean isValidSeatNumber(int seatNumber) {
        return seatNumber >= 1 && seatNumber <= totalSeats;
    }

    public boolean isSeatAvailable(int seatNumber) {
        if (!isValidSeatNumber(seatNumber)) {
            return false;
        }
        return !bookedSeats[seatNumber - 1];
    }

    // Auto assign berth based on age if needed
    private String assignBerthBasedOnAge(int age) {
        if (age > 60) {
            return "Lower Berth";
        } else if (age > 30 && age <= 60) {
            return "Middle Berth";
        } else if (age >= 10 && age <= 30) {
            return "Upper Berth";
        } else {
            // For small kids, we can prefer lower-like berth
            return "Side Lower Berth";
        }
    }

    /**
     * Book seat with extra details: passenger name, age, and berth.
     * If autoAssignBerth is true or preferredBerth is null, berth is auto-assigned based on age.
     */
    public boolean bookSeat(int seatNumber, String passengerName, int age,
                            String preferredBerth, boolean autoAssignBerth) {

        if (!isValidSeatNumber(seatNumber)) {
            System.out.println("Invalid seat number! Seat numbers are from 1 to " + totalSeats + ".");
            return false;
        }
        if (bookedSeats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return false;
        }

        String finalBerth;
        if (autoAssignBerth || preferredBerth == null) {
            finalBerth = assignBerthBasedOnAge(age);
        } else {
            finalBerth = preferredBerth;
        }

        bookedSeats[seatNumber - 1] = true;
        passengerNames[seatNumber - 1] = passengerName;
        passengerAges[seatNumber - 1] = age;
        passengerBerths[seatNumber - 1] = finalBerth;

        System.out.println("Ticket booked successfully for " + passengerName +
                           " (Age: " + age + ") on seat " + seatNumber +
                           " | Berth: " + finalBerth + " | Fare: Rs." + farePerSeat);
        return true;
    }

    public boolean cancelSeat(int seatNumber) {
        if (!isValidSeatNumber(seatNumber)) {
            System.out.println("Invalid seat number! Seat numbers are from 1 to " + totalSeats + ".");
            return false;
        }
        if (!bookedSeats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is not currently booked.");
            return false;
        }
        System.out.println("Ticket cancelled for passenger: " + passengerNames[seatNumber - 1] +
                           " on seat " + seatNumber + ".");
        bookedSeats[seatNumber - 1] = false;
        passengerNames[seatNumber - 1] = null;
        passengerAges[seatNumber - 1] = 0;
        passengerBerths[seatNumber - 1] = null;
        return true;
    }

    public void showPassengerList() {
        System.out.println("Passenger list for Train " + trainNumber + " - " + trainName + ":");
        boolean anyPassenger = false;
        for (int i = 0; i < totalSeats; i++) {
            if (bookedSeats[i]) {
                System.out.println("Seat " + (i + 1) + " - " +
                                   passengerNames[i] +
                                   " | Age: " + passengerAges[i] +
                                   " | Berth: " + passengerBerths[i]);
                anyPassenger = true;
            }
        }
        if (!anyPassenger) {
            System.out.println("No tickets booked yet.");
        }
    }

    @Override
    public String toString() {
        return "Train " + trainNumber + " - " + trainName +
               " | Fare per seat: Rs." + farePerSeat +
               " | Total Seats: " + totalSeats +
               " | Available: " + getAvailableSeatCount();
    }
}
