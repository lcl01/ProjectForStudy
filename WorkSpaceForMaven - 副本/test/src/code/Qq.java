package code;

public class Qq implements Car {
    @Override
    public void run() {
        System.out.println("Qq可以跑60迈...");
    }

    @Override
    public void stop() {
        System.out.println("Qq刹车...");
    }

    @Override
    public String addOil(int num) {
        return "qq加"+num+"号油...";
    }
}
