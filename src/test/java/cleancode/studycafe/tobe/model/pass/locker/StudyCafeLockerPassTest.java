package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudyCafeLockerPassTest {


    @Test
    @DisplayName("패스타입을 비교하고 같다면 true를 반환한다")
    void isSamePassType() {
        // given
        StudyCafeLockerPass result = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 0, 0);
        // when
        // then
        assertThat(result.isSamePassType(StudyCafePassType.FIXED)).isTrue();
    }

    @Test
    @DisplayName("패스타입을 비교하고 다르다면 false를 반환한다")
    void isNotSamePassType() {
        // given
        StudyCafeLockerPass result = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 0, 0);
        // when
        // then
        assertThat(result.isSamePassType(StudyCafePassType.WEEKLY)).isFalse();
    }
    @Test
    @DisplayName("Duration 을 비교하고 같다면 true를 반환한다")
    void isSameDuration() {
        // given
        StudyCafeLockerPass result = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 5, 10000);
        // when
        // then
        assertThat(result.isSameDuration(5)).isTrue();
    }
    @Test
    @DisplayName("Duration 을 비교하고 다르다면 false를 반환한다")
    void isNotSameDuration() {
        // given
        StudyCafeLockerPass result = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 5, 10000);
        // when
        // then
        assertThat(result.isSameDuration(50)).isFalse();
    }
}
