package models.aircraft;

import enums.PropulsionType;
import exceptions.CapacityExceededException;

public class CommercialPlane extends Aircraft{

    int totalNumberOfSeats;
    int numberOfAvailableSeats;
    boolean equippedWithSatelliteWIFIService; // ﻣزودة ﺑﺧدﻣﺔ إﻧﺗرﻧت ﻓﺿﺎﺋﻲ

    public CommercialPlane(int tailNumber, String theManufacturingCompany, String model, double operatingCostPerHour, PropulsionType propulsionType,
                    boolean available, int totalNumberOfSeats, int numberOfAvailableSeats, boolean equippedWithSatelliteWIFIService){
        super(tailNumber, theManufacturingCompany, model,propulsionType, operatingCostPerHour, available);
        setTotalNumberOfSeats(totalNumberOfSeats);
        setNumberOfAvailableSeats(numberOfAvailableSeats);
        this.equippedWithSatelliteWIFIService = equippedWithSatelliteWIFIService;
    }

    public int getTotalNumberOfSeats(){return this.totalNumberOfSeats;}
    public void setTotalNumberOfSeats(int totalNumberOfSeats){
        if (totalNumberOfSeats < 100 || totalNumberOfSeats > 200)
            throw new IllegalArgumentException("It must total number of seats between 100 and 200");
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public int getNumberOfAvailableSeats(){return this.numberOfAvailableSeats;}
    public void setNumberOfAvailableSeats(int numberOfAvailableSeats){
        if (numberOfAvailableSeats > totalNumberOfSeats)
            throw new CapacityExceededException("The number of available seats must be less than or equal to the total number of seats");
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public boolean getEquippedWithSatelliteWIFIService(){return this.equippedWithSatelliteWIFIService;}

    @Override
    public boolean isReadyForFlight() {
        return false;
    }

    @Override
    public void performMaintenance() {

    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTotal Number Of Seats: " + getTotalNumberOfSeats() +
                "\nNumber Of Available Seats: " + getNumberOfAvailableSeats() +
                "\nEquipped With Satellite WI-FI Service: " + getEquippedWithSatelliteWIFIService();
    }
}