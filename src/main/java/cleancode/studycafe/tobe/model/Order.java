package cleancode.studycafe.tobe.model;

import cleancode.studycafe.tobe.model.locker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.pass.StudyCafePass;

import java.util.List;

public class Order {
    private StudyCafePass pass;
    private StudyCafeLockerPass lockerPass;

    private Order(StudyCafePass pass) {
        this.pass = pass;
    }

    public Order(StudyCafePass pass, StudyCafeLockerPass lockerPass) {
        this.pass = pass;
        this.lockerPass = lockerPass;
    }

    public static Order createOrder(StudyCafePass pass){
        return new Order(pass);
    }

    public Order createOrderWithLockerPass(StudyCafeLockerPass lockerPass){
        return new Order(this.pass, lockerPass);
    }

    public StudyCafePass getPass() {
        return pass;
    }

    public StudyCafeLockerPass getLockerPass() {
        return lockerPass;
    }
}
