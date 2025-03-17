package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassOrderTest {


    @Test
    @DisplayName("주문 목록의 총 가격을 계산한다.")
    void getTotalPrice() {
        // given
        StudyCafePassOrder order = StudyCafePassOrder.of(
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 20, 30000, 0.5),
            StudyCafeLockerPass.of(StudyCafePassType.FIXED, 20, 30000)
        );
        // when
        int result = order.getTotalPrice();
        // then
        assertThat(result).isEqualTo(45000);
    }

    @Test
    @DisplayName("주문의 락커패스가 존재한다면 Optional<LockerPass>를 반환한다.")
    void getLockerPass() {
        // given
        StudyCafePassOrder order = StudyCafePassOrder.of(
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 20, 30000, 0.5),
            StudyCafeLockerPass.of(StudyCafePassType.FIXED, 20, 30000)
        );
        // when
        Optional<StudyCafeLockerPass> result = order.getLockerPass();
        // then
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getPrice()).isEqualTo(30000);
        assertThat(result.get().getDuration()).isEqualTo(20);
    }

    @Test
    @DisplayName("주문의 락커패스가 존재하지 않는다면 빈 Optional을 반환한다.")
    void getLockerPassIsNull() {
        // given
        StudyCafePassOrder order = StudyCafePassOrder.of(
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 20, 30000, 0.5),
            null
        );
        // when
        Optional<StudyCafeLockerPass> result = order.getLockerPass();
        // then
        assertThat(result.isEmpty()).isTrue();

    }
}
