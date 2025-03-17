package cleancode.studycafe.tobe.io.provider;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPasses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LockerPassFileReaderTest {

    private final LockerPassFileReader reader = new LockerPassFileReader();
    private final String PATH = "src/test/resources/cleancode/studycafe/locker.csv";

    @Test
    @DisplayName("Locker pass 데이터를 읽어와 StudyCafeLockerPasses를 반환한다.")
    void getLockerPassesTest() {
        // given
        // when
        StudyCafeLockerPasses result = reader.getLockerPassesTest(PATH);
        // then
        assertThat(result.size()).isEqualTo(2);
    }
}
