package models.aircraft;

import exceptions.CapacityExceededException;

public class PrivateJet {

    private int numberOfLuxurySuites; // ﻋدد أﺟﻧﺣﺔ اﻟرﻓﺎھﯾﺔ
    private int maximumFlightRange; // ﻣدى اﻟطﯾران اﻷﻗﺻﻰ
    private final boolean whetherOrNotThereIsADedicatedHospitalityCrew; //  وﺟود طﺎﻗم ﺿﯾﺎﻓﺔ ﺧﺎص أم ﻻ

    public PrivateJet(int numberOfLuxurySuites, int maximumFlightRange, boolean whetherOrNotThereIsADedicatedHospitalityCrew){
        setNumberOfLuxurySuites(numberOfLuxurySuites);
        setMaximumFlightRange(maximumFlightRange);
        this.whetherOrNotThereIsADedicatedHospitalityCrew = whetherOrNotThereIsADedicatedHospitalityCrew;
    }

    public int getNumberOfLuxurySuites(){return this.numberOfLuxurySuites;}
    public void setNumberOfLuxurySuites(int numberOfLuxurySuites){
        if (numberOfLuxurySuites < 1 || numberOfLuxurySuites > 3)
            throw new CapacityExceededException("The number of luxury suites should be between 1 and 3 suites");
        this.numberOfLuxurySuites = numberOfLuxurySuites;
    }

    public int getMaximumFlightRange(){return this.maximumFlightRange;}
    public void setMaximumFlightRange(int maximumFlightRange){
        if (maximumFlightRange < 10000 || maximumFlightRange > 15000)
            throw new CapacityExceededException("The maximum flight range should be between 10000 and 15000 Km");
        this.maximumFlightRange = maximumFlightRange;
    }

    public boolean getWhetherOrNotThereIsADedicatedHospitalityCrew(){return this.whetherOrNotThereIsADedicatedHospitalityCrew;}

    @Override
    public String toString() {
        return super.toString() +
                "Number Of Luxury Suites: " + getNumberOfLuxurySuites() +
                "Maximum Flight Range: " + getMaximumFlightRange() +
                "Whether Or Not There Is A Dedicated Hospitality Crew: " + getWhetherOrNotThereIsADedicatedHospitalityCrew();
    }
}