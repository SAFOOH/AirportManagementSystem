package services;

import models.aircraft.Aircraft;

public class AircraftManagement{

    GenericRepository<Integer, Aircraft> aircraftRepository = new GenericRepository<>();

    public void addAircraft(Integer tailNumber, Aircraft aircraft){
        if (tailNumber != aircraft.getTailNumber()){
            System.out.println("Addition did not take place because tail number it does not exist or wrong");
            return;
        }
        aircraftRepository.addItem(tailNumber, aircraft);
        System.out.println("The aircraft has been added successfully");
    }

    public void removeAircraft(Integer tailNumber, Aircraft aircraft){
        if (tailNumber != aircraft.getTailNumber()){
            System.out.println("Deletion did not take place because tail number it does not exist or wrong");
            return;
        }
        aircraftRepository.removeItem(tailNumber);
        System.out.println("The aircraft has been removed successfully");
    }

    public Aircraft searchForAnAircraftByTailNumber(Integer tailNumber){
        Aircraft aircraft = aircraftRepository.searchItem(tailNumber);
        if (aircraft == null){
            System.out.println("aircraft not found");
            return null;
        }
        System.out.println("The aircraft was found successfully");
        return aircraft;
    }

    public void ShowAllAircraft(){
        System.out.println("----- Show All Aircraft -----");
        aircraftRepository.showAllItems();
    }

    public void ShowAllCurrentlyAvailableAircraft(){
        boolean found = false;
        System.out.println("----- Show All Currently Available Aircraft -----");
        for (Aircraft aircraft : aircraftRepository.getAllValues()){
            if (aircraft.getAvailable()) {
                System.out.println(aircraft);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available Aircraft at the moment");
        }
    }
}