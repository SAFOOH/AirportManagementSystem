package main;

import enums.PropulsionType;
import models.aircraft.CargoGoods;
import models.aircraft.CargoPlane;
import services.AircraftManagement;

public class Main {
    public static void main(String[] args) {
        CargoPlane cargoPlane = new CargoPlane(5, "x", "78XX", 800,
                PropulsionType.JET_FUEL, true, 80, true);
        CargoPlane cargoPlane2 = new CargoPlane(10, "zz", "555", 700,
                PropulsionType.JET_FUEL, false, 80, true);
        AircraftManagement aircraftManagement = new AircraftManagement();

        CargoGoods cargoGoods1 = new CargoGoods(1, "xxl");
        CargoGoods cargoGoods2 = new CargoGoods(2, "mars");
        CargoGoods cargoGoods3 = new CargoGoods(3, "fws");

        cargoPlane.loadingGoodsIntoTruckContainers(cargoGoods1);
        cargoPlane.loadingGoodsIntoTruckContainers(cargoGoods2);
        cargoPlane.loadingGoodsIntoTruckContainers(cargoGoods3);

        aircraftManagement.addAircraft(5, cargoPlane);
        aircraftManagement.addAircraft(10, cargoPlane2);
        //aircraftManagement.ShowAllAircraft();
        //aircraftManagement.ShowAllCurrentlyAvailableAircraft();
        aircraftManagement.removeAircraft(5, cargoPlane);

        //cargoPlane.printingForAllGoods();


    }
}