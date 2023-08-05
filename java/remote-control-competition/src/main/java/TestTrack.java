import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(ProductionRemoteControlCar prc1,
                                                                 ProductionRemoteControlCar prc2) {
        
        var list = List.of(prc1, prc2);
        list.sort((a, b) -> b.compareTo(a));
        return list;
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        cars.sort((a, b) -> b.compareTo(a));
        return cars;
    }
}
