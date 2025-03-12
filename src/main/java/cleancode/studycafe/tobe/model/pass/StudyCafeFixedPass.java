package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.StudyCafePassType;

public class StudyCafeFixedPass implements StudyCafePass{
    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafeFixedPass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafeFixedPass of(StudyCafePassType passType, int duration, int price, double discountRate){
        return new StudyCafeFixedPass(passType, duration, price, discountRate);
    }

    @Override
    public String display() {
        return String.format("%s주권 - %d원", duration, price);
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
