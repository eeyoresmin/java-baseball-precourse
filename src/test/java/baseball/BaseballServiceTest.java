package baseball;

import baseball.service.BaseballService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballServiceTest {

    BaseballService baseballService = new BaseballService();

    @Test
    @DisplayName("숫자 -> Map 변환 Test")
    void 변환_테스트() {

        Map<String, Integer> map = new HashMap<>();
        map.put("3", 1);
        map.put("2", 2);
        map.put("1", 3);

        assertThat(map).isEqualTo(baseballService.changeNumberToMap("321"));
    }

    @Test
    @DisplayName("결과 생성 테스트")
    void 결과_생성_테스트() {

        Map<String, Integer> map = new HashMap<>();
        map.put("S", 1);
        map.put("B", 1);

        Map<String, Integer> comNumbersMap = baseballService.changeNumberToMap("752");
        Map<String, Integer> userNumbersMap = baseballService.changeNumberToMap("251");
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("S", 0);
        resultMap.put("B", 0);

        for (Map.Entry<String, Integer> e : userNumbersMap.entrySet()) {
            baseballService.makeResultMap(resultMap, comNumbersMap, e.getKey(),e.getValue());
        }

        assertThat(map).isEqualTo(resultMap);
    }
}
