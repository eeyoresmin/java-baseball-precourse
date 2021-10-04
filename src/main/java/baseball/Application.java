package baseball;

import baseball.service.BaseballService;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static BaseballService baseballService = new BaseballService();

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        Map<String, Integer> comNumbersMap;
        Map<String, Integer> userNumbersMap;
        Map<String, Integer> resultMap = new HashMap(){
            {
                put("S", 0);
                put("B", 0);
            }
        };

        comNumbersMap = baseballService.makeComNumber();
        System.out.println("comNumbersMap" + comNumbersMap.toString());

        while (!resultMap.get("S").equals(3)) {
            userNumbersMap = baseballService.inputUserNumber();

            userNumbersMap.forEach((key, value) -> baseballService.makeResultMap(resultMap, comNumbersMap, key, value));

            System.out.println(baseballService.makeMessage(resultMap));
        }

    }
}
