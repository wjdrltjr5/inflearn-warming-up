package cleancode.studycafe.tobe.model.factory;

import cleancode.studycafe.tobe.model.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeFixedPass;
import cleancode.studycafe.tobe.model.pass.StudyCafeHourPass;
import cleancode.studycafe.tobe.model.pass.StudyCafePass;
import cleancode.studycafe.tobe.model.pass.StudyCafeWeekPass;

public class StudyCafePassFactory {

    public static StudyCafePass createStudyCafePass(StudyCafePassType type, int duration, int price, double discountRate) {
        switch (type.name()){
            case "HOURLY" -> {
                return StudyCafeHourPass.of(type, duration, price, discountRate);
            }
            case "WEEKLY" -> {
                return StudyCafeWeekPass.of(type, duration, price, discountRate);
            }
            case "FIXED" -> {
                return StudyCafeFixedPass.of(type, duration, price, discountRate);
            }
        }
        throw new IllegalArgumentException("올바르지 않은 타입 입니다.");
    }
}
