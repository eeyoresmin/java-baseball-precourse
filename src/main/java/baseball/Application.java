package baseball;

import baseball.service.BaseballService;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static BaseballService baseballService = new BaseballService();

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        startGame();
    }

    public static void startGame() {
        Map<String, Integer> comNumbersMap;
        Map<String, Integer> userNumbersMap;

        comNumbersMap = baseballService.makeComNumber();
        userNumbersMap = baseballService.inputUserNumber();

        System.out.println("comNumbersMap" + comNumbersMap.toString());
        System.out.println("userNumbersMap" + userNumbersMap.toString());
    }
}
