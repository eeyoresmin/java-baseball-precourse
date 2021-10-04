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

}
