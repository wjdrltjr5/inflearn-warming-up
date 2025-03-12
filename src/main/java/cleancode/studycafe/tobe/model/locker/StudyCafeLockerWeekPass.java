package cleancode.studycafe.tobe.model.locker;

import cleancode.studycafe.tobe.model.StudyCafePassType;

public class StudyCafeLockerWeekPass implements StudyCafeLockerPass{
    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    private StudyCafeLockerWeekPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerWeekPass of(final StudyCafePassType type, final int duration, final int price) {
        return new StudyCafeLockerWeekPass(type, duration, price);
    }

    @Override
    public String display() {
        return String.format("%s주권 - %d원", duration, price);
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
