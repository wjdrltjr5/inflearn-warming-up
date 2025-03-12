package cleancode.studycafe.tobe.model.locker;

import cleancode.studycafe.tobe.model.StudyCafePassType;

public class StudyCafeLockerHourPass implements StudyCafeLockerPass{
    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    private StudyCafeLockerHourPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerHourPass of(final StudyCafePassType type, final int duration, final int price) {
        return new StudyCafeLockerHourPass(type, duration, price);
    }

    @Override
    public String display() {
        return String.format("%s시간권 - %d원", duration, price);
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public StudyCafePassType getPassType() {
        return passType;
    }
}
