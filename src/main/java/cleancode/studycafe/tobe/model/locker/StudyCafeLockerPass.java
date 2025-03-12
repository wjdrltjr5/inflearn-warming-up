package cleancode.studycafe.tobe.model.locker;

import cleancode.studycafe.tobe.model.StudyCafePassType;

public interface StudyCafeLockerPass {

    String display();
    int getDuration();
    int getPrice();
    StudyCafePassType getPassType();
}
