package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassTypeTest {



    @Test
    @DisplayName("해당 패스가 locker 타입이면 true를 반환한다.")
    void isLockerType() {
        // given
        // when
        // then
        assertThat(StudyCafePassType.FIXED.isLockerType()).isTrue();
    }

    @Test
    @DisplayName("해당 패스가 locker 타입이 아니면 True를 반환한다.")
    void isNotLockerType() {
        // given
        // when
        // then
        assertThat(StudyCafePassType.HOURLY.isNotLockerType()).isTrue();
        assertThat(StudyCafePassType.WEEKLY.isNotLockerType()).isTrue();
    }

}
