package cleancode.studycafe.tobe.io.provider;

import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPasses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeatPassFileReaderTest {

    private static final String PATH = "src/test/resources/cleancode/studycafe/pass-list.csv";
    private final SeatPassFileReader reader = new SeatPassFileReader();

    @Test
    @DisplayName("일반 패스 목록 파일을 읽어 StudyCafeSeatPasses를 반환한다.")
    void getSeatPassesTest() {
        //given
        //when
        StudyCafeSeatPasses result = reader.getSeatPassesTest(PATH);
        //then
        assertThat(result.size()).isEqualTo(13);

    }
}
