package baseball;

import baseball.service.BaseballService;
import org.assertj.core.internal.bytebuddy.matcher.ElementMatcher;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballServiceTest {

    BaseballService baseballService = new BaseballService();

    @Test
    void 변환_테스트() {

        Map<String, Integer> map = new HashMap<>();
        map.put("3", 1);
        map.put("2", 2);
        map.put("1", 3);

        assertThat(map).isEqualTo(baseballService.changeNumberToMap("321"));
    }
}
