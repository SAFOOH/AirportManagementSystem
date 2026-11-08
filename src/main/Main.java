package main;

import enums.PropulsionType;
import models.aircraft.CargoGoods;
import models.aircraft.CargoPlane;

public class Main {
    public static void main(String[] args) {
        CargoPlane cargoPlane = new CargoPlane(5, "x", "78XX", 800,
                PropulsionType.JET_FUEL, true, 80, true);

        CargoGoods cargoGoods1 = new CargoGoods(1, "xxl");
        CargoGoods cargoGoods2 = new CargoGoods(2, "mars");
        CargoGoods cargoGoods3 = new CargoGoods(3, "fws");

        cargoPlane.loadingGoodsIntoTruckContainers(cargoGoods1);
        cargoPlane.loadingGoodsIntoTruckContainers(cargoGoods2);
        cargoPlane.loadingGoodsIntoTruckContainers(cargoGoods3);

        cargoPlane.printingForAllGoods();


    }
}