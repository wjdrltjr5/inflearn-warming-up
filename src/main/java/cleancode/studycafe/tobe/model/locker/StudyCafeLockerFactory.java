package cleancode.studycafe.tobe.model.locker;

import cleancode.studycafe.tobe.model.StudyCafePassType;

public class StudyCafeLockerFactory {

    public static StudyCafeLockerPass createStudyCafeLockerPass(StudyCafePassType type, int duration, int price) {
        switch (type.name()){
            case "HOURLY" -> {
                return StudyCafeLockerHourPass.of(type, duration, price);
            }
            case "WEEKLY" -> {
                return StudyCafeLockerWeekPass.of(type, duration, price);
            }
            case "FIXED" -> {
                return StudyCafeLockerFixedPass.of(type, duration, price);
            }
        }
        throw new IllegalArgumentException("올바르지 않은 타입니다.");
    }

}
