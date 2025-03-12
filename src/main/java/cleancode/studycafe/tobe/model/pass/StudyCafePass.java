package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.StudyCafePassType;

public interface StudyCafePass {
    String display();
    double getDiscountRate();
    int getPrice();
    StudyCafePassType getPassType();
    int getDuration();

}
