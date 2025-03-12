package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.model.Order;
import cleancode.studycafe.tobe.model.locker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.pass.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;
import cleancode.studycafe.tobe.model.reader.LockerReader;
import cleancode.studycafe.tobe.model.reader.PassReader;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final LockerReader lockerReader = new LockerReader();
    private final PassReader passReader = new PassReader();

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();
            List<StudyCafePass> studyCafePasses = passReader.readStudyCafePasses();

            Order order = selectPass(studyCafePasses, studyCafePassType);

            if (studyCafePassType == StudyCafePassType.FIXED) {
                order = selectLockerPass(order);
            }
            outputHandler.showPassOrderSummary(order);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private Order selectLockerPass(Order order) {
        List<StudyCafeLockerPass> lockerPasses = lockerReader.readLockerPasses();
        StudyCafeLockerPass lockerPass = lockerPasses.stream()
            .filter(option ->
                option.getPassType() == order.getPass().getPassType()
                    && option.getDuration() == order.getPass().getDuration()
            )
            .findFirst()
            .orElse(null);

        boolean lockerSelection = false;
        if (lockerPass != null) {
            outputHandler.askLockerPass(lockerPass);
            lockerSelection = inputHandler.getLockerSelection();
        }

        if (lockerSelection) {
            return order.createOrderWithLockerPass(lockerPass);
        }
        return order;
    }

    private Order selectPass(List<StudyCafePass> studyCafePasses, StudyCafePassType type){
            List<StudyCafePass> passes = studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == type)
            .toList();
            outputHandler.showPassListForSelection(passes);
            StudyCafePass selectedPass = inputHandler.getSelectPass(passes);
            return Order.createOrder(selectedPass);
    }
}
