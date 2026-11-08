package models.aircraft;

import exceptions.OperatingCostPerHourException;
import interfaces.Maintainable;
import enums.PropulsionType;

public abstract class Aircraft implements Maintainable {
    private int tailNumber;
    private String theManufacturingCompany; // الشركة المُصنِّعة
    private String model;
    private double operatingCostPerHour; //  اﻟﺗﻛﻠﻔﺔ اﻟﺗﺷﻐﯾﻠﯾﺔ ﻟﻠﺳﺎﻋﺔ
    private final PropulsionType propulsionType;
    private final boolean available;

    Aircraft(int tailNumber, String theManufacturingCompany, String model,PropulsionType propulsionType,
             double operatingCostPerHour, boolean available){
        setTailNumber(tailNumber);
        setTheManufacturingCompany(theManufacturingCompany);
        setModel(model);
        this.propulsionType = propulsionType;
        setOperatingCostPerHour(operatingCostPerHour);
        this.available = available;
    }

    public int getTailNumber(){return this.tailNumber;}
    public void setTailNumber(int tailNumber){
        if (tailNumber <= 0 || tailNumber > 9999)
            throw new IllegalArgumentException("It must Tail Number between 1 and 9999");
        this.tailNumber = tailNumber;
    }

    public String getTheManufacturingCompany(){return this.theManufacturingCompany;}
    public void setTheManufacturingCompany(String theManufacturingCompany){
        if(theManufacturingCompany == null || theManufacturingCompany.isBlank())
            throw new IllegalArgumentException("Error: The Manufacturing Company name cannot be null or empty");
        this.theManufacturingCompany = theManufacturingCompany;
    }

    public String getModel(){return this.model;}
    public void setModel(String model){
        if(model == null || model.isBlank())
            throw new IllegalArgumentException("Error: The model name cannot be null or empty");
        this.model = model;
    }

    public double getOperatingCostPerHour(){return this.operatingCostPerHour;}
    public void setOperatingCostPerHour(double operatingCostPerHour){
        switch (propulsionType){
            case JET_FUEL -> {
                if (operatingCostPerHour < 600 || operatingCostPerHour > 1000)
                    throw new OperatingCostPerHourException("The operating cost per hour for JET_FUEL must be between 600 and 1000 $");
                this.operatingCostPerHour = operatingCostPerHour;
            }
            case BIO_FUEL -> {
                if (operatingCostPerHour < 1200 || operatingCostPerHour > 2500)
                    throw new OperatingCostPerHourException("The operating cost per hour for BIO_FUEL must be between 1200 and 2500 $");
                this.operatingCostPerHour = operatingCostPerHour;
            }
            case ELECTRIC_FUEL -> {
                if (operatingCostPerHour < 200 || operatingCostPerHour > 400)
                    throw new OperatingCostPerHourException("The operating cost per hour for ELECTRIC_FUEL must be between 200 and 400 $");
                this.operatingCostPerHour = operatingCostPerHour;

            }
            default -> throw new OperatingCostPerHourException("The type of fuel must be: JET_FUEL or BIO_FUEL or ELECTRIC_FUEL");
        }
    }

    public PropulsionType getPropulsionType(){return this.propulsionType;}

    public boolean getAvailable(){return this.available;}

    @Override
    public String toString() {
        return "Tail Number: " + getTailNumber() +
               "\nThe Manufacturing Company: " + getTheManufacturingCompany() +
               "\nModel: " + getModel() +
               "\nOperating Cost Per Hour: " + getOperatingCostPerHour() +
               "\nPropulsion Type: " + getPropulsionType() +
               "\nAvailable ? : " + getAvailable();
    }
}