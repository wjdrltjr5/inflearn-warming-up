package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeLockerPassesTest {


    @Test
    @DisplayName("해당하는 라커타입을 찾아서 옵셔널 반환")
    void findLockerPassBy() {
        // given
        int duration = 1000;
        int price = 1000;
        List<StudyCafeLockerPass> passes = List.of(
            StudyCafeLockerPass.of(StudyCafePassType.FIXED, duration, price),
            StudyCafeLockerPass.of(StudyCafePassType.HOURLY, duration, price),
            StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, duration, price)
            );
        StudyCafeLockerPasses studyCafeLockerPasses = StudyCafeLockerPasses.of(passes);
        // when
        Optional<StudyCafeLockerPass> result = studyCafeLockerPasses.findLockerPassBy(StudyCafeSeatPass.of(StudyCafePassType.FIXED,
            duration, price, 0));
        // then
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getPassType()).isEqualTo(StudyCafePassType.FIXED);
        assertThat(result.get().getDuration()).isEqualTo(duration);
        assertThat(result.get().getPrice()).isEqualTo(price);
    }

    @Test
    @DisplayName("해당하는 라커타입이 없다면 빈옵셔널 반환")
    void notFindLockerPassBy() {
        // given
        int duration = 1000;
        int price = 1000;
        List<StudyCafeLockerPass> passes = List.of(
            StudyCafeLockerPass.of(StudyCafePassType.HOURLY, duration, price),
            StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, duration, price)
        );
        StudyCafeLockerPasses studyCafeLockerPasses = StudyCafeLockerPasses.of(passes);
        // when
        Optional<StudyCafeLockerPass> result = studyCafeLockerPasses.findLockerPassBy(StudyCafeSeatPass.of(StudyCafePassType.FIXED,
            duration, price, 0));
        // then
        assertThat(result.isEmpty()).isTrue();
    }

}
