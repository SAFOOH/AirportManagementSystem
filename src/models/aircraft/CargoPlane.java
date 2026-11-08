package models.aircraft;

import enums.PropulsionType;
import exceptions.CapacityExceededException;

import java.util.Stack;

public class CargoPlane extends Aircraft {

    private double maximumLoadCapacityInTons; // ﺳﻌﺔ اﻟﺣﻣوﻟﺔ اﻟﻘﺻوى ﺑﺎﻟطن
    private final boolean freezerOrNot; // مجمد أم لا
    Stack<CargoGoods> cargoHold;

    public CargoPlane(int tailNumber, String theManufacturingCompany, String model, double operatingCostPerHour, PropulsionType propulsionType,
                      boolean available, double maximumLoadCapacityInTons, boolean freezerOrNot) {
        super(tailNumber, theManufacturingCompany, model,propulsionType, operatingCostPerHour, available);
        setMaximumLoadCapacityInTons(maximumLoadCapacityInTons);
        this.freezerOrNot = freezerOrNot;
        cargoHold = new Stack<>();
    }

    public double getMaximumLoadCapacityInTons(){return this.maximumLoadCapacityInTons;}
    public void setMaximumLoadCapacityInTons(double maximumLoadCapacityInTons){
        if (maximumLoadCapacityInTons < 70 || maximumLoadCapacityInTons > 140)
            throw new CapacityExceededException("The maximum load capacity must be between 70 and 140 tons");
        this.maximumLoadCapacityInTons = maximumLoadCapacityInTons;
    }

    boolean getFreezerOrNot(){return this.freezerOrNot;}

    Stack<CargoGoods> getCargoHold(){return this.cargoHold;}

    public void loadingGoodsIntoTruckContainers(CargoGoods good){cargoHold.push(good);}
    public void UnloadingGoodsIntoTruckContainers(){cargoHold.pop();}
    public void searchGoodsIntoTruckContainers(CargoGoods good){
        System.out.println("----- search goods into truck containers -----");
        int foundGood = cargoHold.search(good);
        if (foundGood == -1){
            System.out.println("These " + good.getName() + " is not in the truck containers");
        }
        else {
            System.out.println("These goods " + good.getName() + " were found in truck containers");
        }
    }
    public void printingForAllGoods(){
        if (cargoHold.empty()){
            System.out.println("There are no goods to display");
            return;
        }
        for (CargoGoods goods : cargoHold){
            System.out.println(goods);
        }
    }

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
                "\nMaximum Load Capacity In Tons: " + getMaximumLoadCapacityInTons() +
                "\nfreezer ? : " + getFreezerOrNot();
    }
}
