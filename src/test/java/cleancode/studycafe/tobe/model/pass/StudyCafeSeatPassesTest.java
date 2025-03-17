package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class StudyCafeSeatPassesTest {


    @Test
    @DisplayName("보유하고 StudyCafePassType에 해당하는 StudyCafeSeatPass 리스트를 반환한다.")
    void findPassBy() {
        // given
        StudyCafeSeatPasses target = StudyCafeSeatPasses.of(List.of(
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1, 10000, 0.1),
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 2, 20000, 0.2),
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 3, 30000, 0.3),
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 40000, 0.4),
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 5, 50000, 0.5),
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 6, 60000, 0.6),
            StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 7, 70000, 0.7)
        ));
        // when
        List<StudyCafeSeatPass> result = target.findPassBy(StudyCafePassType.FIXED);
        // then
        assertThat(result).hasSize(2);
        assertThat(result).extracting("passType","duration","price","discountRate").
            contains(
            tuple(StudyCafePassType.FIXED,1, 10000, 0.1),
            tuple(StudyCafePassType.FIXED,2, 20000, 0.2)
        );

    }
}
