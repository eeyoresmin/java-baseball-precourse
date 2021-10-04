package baseball.service;

import nextstep.utils.Randoms;

import java.util.HashMap;
import java.util.Map;

import static nextstep.utils.Console.readLine;

public class BaseballService {

    /**
     * 컴퓨터에서 생성한 숫자가 서로 다른 수로 구성 되도록 만들어준다.
     * @return 생성된 숫자를 Key, 자릿수를 Value로 한 Map
     */
    public Map<String, Integer> makeComNumber() {
        Map<String, Integer> comNumbersMap;
        int baseInt;

        do {
            baseInt = Randoms.pickNumberInRange(111, 999);
            comNumbersMap = changeNumberToMap(String.valueOf(baseInt));
        } while (comNumbersMap.keySet().size() != 3);

        return comNumbersMap;
    }

    /**
     * 사용자가 숫자를 입력하게 한다.
     * 입력된 숫자를 Map 구조로 변경하여 반환한다.
     *
     * @return 입력된 숫자를 Key, 자릿수를 Value로 한 Map
     */
    public Map<String, Integer> inputUserNumber() {
        Map<String, Integer> userNumbersMap;
        String inputString;

        do{
            System.out.print("숫자를 입력해주세요: ");
            inputString = readLine();
            userNumbersMap = changeNumberToMap(inputString);
        } while (userNumbersMap.keySet().size() != 3);

        return userNumbersMap;
    }

    /**
     * String으로 된 숫자를 Map 구조로 변경한다.
     * @param inputs 입력된 값
     * @return 숫자를 Key, 자릿수를 Value로 한 Map
     */
    public Map<String, Integer> changeNumberToMap (String inputs) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < inputs.length(); i++) {
            map.put(String.valueOf(inputs.charAt(i)), i + 1);
        }

        return map;
    }

    /**
     * 컴퓨터 Map과  사용자 입력 Map을 비교하여 결과 값을 resultMap에 저장
     *
     * @param resultMap
     * @param comNumbersMap
     * @param userNumber
     * @param userNumberValue
     */
    public void makeResultMap(Map<String, Integer> resultMap, Map<String, Integer> comNumbersMap, String userNumber, Integer userNumberValue) {
        if (!comNumbersMap.containsKey(userNumber)) {
            return;
        }

        if (comNumbersMap.get(userNumber).equals(userNumberValue)) {
            resultMap.put("S", resultMap.get("S") + 1);
            return;
        }

        resultMap.put("B", resultMap.get("B") + 1);
    }

    /**
     * resultMap Data에 따른 메시지 생성
     *
     * @param resultMap
     * @return
     */
    public String makeMessage(Map<String, Integer> resultMap) {
        StringBuilder message = new StringBuilder();

        if (resultMap.get("S") != 0 && resultMap.get("B") != 0) {
            return String.format("%d%s %d%s",resultMap.get("S"), "스트라이크",resultMap.get("B"), "볼");
        }

        if (resultMap.get("S") != 0) {
            return String.format("%d%s",resultMap.get("S"), "스트라이크");
        }

        if (resultMap.get("B") != 0) {
            return String.format("%d%s",resultMap.get("B"), "볼");
        }

        return "낫싱";
    }

}
