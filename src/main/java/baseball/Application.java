package baseball;

import baseball.service.BaseballService;
import nextstep.utils.Console;

import java.util.HashMap;
import java.util.Map;

public class Application {
	public static BaseballService baseballService = new BaseballService();

	public static void main(String[] args) {
		do {
			startGame();
		} while (endGame());
	}

	public static void startGame() {
		Map<String, Integer> comNumbersMap;
		Map<String, Integer> userNumbersMap;
		Map<String, Integer> resultMap = new HashMap();
		baseballService.initResultMap(resultMap);

		comNumbersMap = baseballService.makeComNumber();
		System.out.println("comNumbersMap" + comNumbersMap.toString());

		while (!resultMap.get("S").equals(3)) {
			baseballService.initResultMap(resultMap);
			userNumbersMap = baseballService.inputUserNumber();

			baseballService.countNumbers(resultMap, comNumbersMap, userNumbersMap);

			System.out.println(baseballService.makeMessage(resultMap));
		}

	}

	public static boolean endGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		if (Console.readLine().equals("1")) {
			return true;
		}

		System.out.println("게임 끝");
		return false;
	}
}
