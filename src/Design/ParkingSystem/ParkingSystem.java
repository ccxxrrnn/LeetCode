package Design.ParkingSystem;

/**
 * @Author xiongwei
 * @WriteTime 2021-03-19 21:16
 */

//1603. 设计停车系统
class ParkingSystem {
    int[] park;

    public ParkingSystem(int big, int medium, int small) {
        this.park = new int[]{0,big,medium,small};
    }

    public boolean addCar(int carType) {
        if(park[carType] == 0) return false;
        park[carType]--;
        return true;
    }
}
