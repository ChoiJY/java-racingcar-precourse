package util;

import java.util.HashSet;
import java.util.Set;

/**
 * Description : cmd input string util class
 *
 * Created by jychoi on 2021/05/02.
 */
public class InputUtils {

	private static final String DELIMETER = ",";
	private static final int INPUT_SIZE_LIMIT = 5;
	private static final String INPUT_SIZE_ERROR_MESSAGE = "숫자만 입력 가능합니다. 잘못된 입력은 0으로 입력됩니다.";

	/**
	 * Description : 사용자 입력 시도 회수 가져오기
	 *
	 * @param inputStr 사용자 입력 string
	 * @return (int) 게임 반복 사이즈
	 *
	 */
	public int getRunSize(String inputStr) {

		int runSize = 0;

		try {
			runSize = Integer.parseInt(inputStr);
		} catch (NumberFormatException e) {
			System.out.println(INPUT_SIZE_ERROR_MESSAGE);
		}

		return runSize;
	}

	/**
	 * Description : user input str (차 이름 배열)을 Set으로 변경
	 *
	 * @param inputStr user input str (차 이름 배열)열
	 * @return Set<String> 차 이름 배
	 */
	public Set<String> splitInputStr(String inputStr) {

		Set<String> result = new HashSet<>();
		String[] inputStrAry = inputStr.split(DELIMETER, 5);

		for (String each : inputStrAry) {
			checkItemEmptyStr(each, result);
		}

		return result;
	}

	/**
	 * Description: 해당 input 공백 체크 후, Set에 더하는 method (빈 str이 올 경우에는 그냥 넣지 않고 무시)
	 *
	 * @param input 차 이름 str 열
	 * @param targetSet 차 이름 Set
	 */
	private void checkItemEmptyStr(String input, Set<String> targetSet) {

		if (input.length() != 0) {
			targetSet.add(resizeItem(input));
		}
	}

	/**
	 * Description: 차 이름 내 요구사항보다 긴 문장이 들어올 경우 잘라서 format 맞츰
	 *
	 * @param input 차 이름 str
	 * @return 차 이름 str
	 */
	private String resizeItem(String input) {

		String result = input;

		if (input.length() > INPUT_SIZE_LIMIT) {
			result = input.substring(0, INPUT_SIZE_LIMIT);
		}

		return result;
	}
}
