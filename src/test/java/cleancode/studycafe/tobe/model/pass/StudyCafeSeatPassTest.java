package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeSeatPassTest {

    @Test
    @DisplayName("locker를 사용할 수 없다면 true를 반환한다.")
    void cannotUseLocker() {
        // given
        StudyCafeSeatPass result = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 0, 0, 0);
        // when
        // then
        assertThat(result.cannotUseLocker()).isTrue();
    }


    @Test
    @DisplayName("locker를 사용할 수 있다면 false를 반환한다.")
    void canUseLocker() {
        // given
        StudyCafeSeatPass result = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 0, 0, 0);
        // when
        // then
        assertThat(result.cannotUseLocker()).isFalse();
    }

    @Test
    @DisplayName("StudyCafeLockerPass타입과 보유 타입과 Duration이 둘다 같다면 true를 반환한다.")
    void isSameDurationType() {
        // given
        StudyCafeSeatPass result = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 5, 10000, 0.1);
        // when
        // then
        assertThat(result.isSameDurationType(StudyCafeLockerPass.of(StudyCafePassType.FIXED,5,10000))).isTrue();
    }


    @Test
    @DisplayName("StudyCafeLockerPass타입과 보유 타입과 Duration이 하나라도 다르다면 false를 반환한다.")
    void isNotSameDurationType() {
        // given
        StudyCafeSeatPass result = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 5, 10000, 0.1);
        // when
        // then
        assertThat(result.isSameDurationType(StudyCafeLockerPass.of(StudyCafePassType.FIXED,0,10000))).isFalse();
    }

    @Test
    @DisplayName("보유타입과 StudyCafePassType이 같다면 true를 반환한다.")
    void isSamePassType() {
        // given
        StudyCafeSeatPass result = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 5, 10000, 0.1);
        // when
        // then
        assertThat(result.isSamePassType(StudyCafePassType.FIXED)).isTrue();
    }
    @Test
    @DisplayName("보유타입과 StudyCafePassType이 같지 않다면 False를 반환한다.")
    void isNotSamePassType() {
        // given
        StudyCafeSeatPass result = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 5, 10000, 0.1);
        // when
        // then
        assertThat(result.isSamePassType(StudyCafePassType.WEEKLY)).isFalse();
        assertThat(result.isSamePassType(StudyCafePassType.HOURLY)).isFalse();
    }

    @Test
    @DisplayName("할인가격을 반환한다.")
    void getDiscountPrice() {
        // given
        StudyCafeSeatPass pass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 50000, 0.1);
        // when
        int result = pass.getDiscountPrice();
        // then
        assertThat(result).isEqualTo(5000);
    }
}
