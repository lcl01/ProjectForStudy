package code;

public class WrapperCar implements Car {
    private Car car;

    public WrapperCar() {
    }

    public WrapperCar(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        System.out.println("5s破百..");
    }

    @Override
    public void stop() {
        car.stop();
    }

    @Override
    public String addOil(int num) {
        return null;
    }
}
