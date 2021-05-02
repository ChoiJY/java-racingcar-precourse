package util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Description : InputUtils test class
 *
 * Created by jychoi on 2021/05/02.
 */
class InputUtilsTest {

	InputUtils inputUtils = new InputUtils();

	@Test
	@DisplayName("정상 입력 케이스")
	void splitInputStr() {
		String givenStr = "chars,devs,kakao,naver";
		Set<String> given = new HashSet<>();
		given.add("chars");
		given.add("devs");
		given.add("kakao");
		given.add("naver");
		Set<String> when = inputUtils.splitInputStr(givenStr);

		assertThat(given).isEqualTo(when);
	}

	@Test
	@DisplayName("빈 문장이 들어갈 경우에 정상 작동 처리")
	void splitInputStrHasEmptyStr() {

		String givenStr = "chars,devs.,,kakao.naver,";
		Set<String> given = new HashSet<>();
		given.add("chars");
		given.add("devs.");
		given.add("kakao");
		Set<String> when = inputUtils.splitInputStr(givenStr);

		assertThat(when).isEqualTo(given);
	}

	@Test
	@DisplayName("5글자 제한보다 긴 문장이 들어갈 경우에 정상 작동 처리")
	void splitInputStrHasLongStr() {

		String givenStr = "chars,devs.3333,,kakao.naver,";
		Set<String> given = new HashSet<>();
		given.add("chars");
		// 요기가 포인트
		given.add("devs.");
		given.add("kakao");
		Set<String> when = inputUtils.splitInputStr(givenStr);

		assertThat(when).isEqualTo(given);
	}

	@Test
	@DisplayName("str -> int 관련 테스트 nfe 기대")
	void testStrToInt() {
		String givenStr = "d";
		assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt(givenStr);
		});
	}

	@Test
	@DisplayName("게임 시도 회수 가져오기 테스트 - 정상 케이스")
	void getRunSize() {
		String givenStr = "3";
		int given = 3;
		int when = inputUtils.getRunSize(givenStr);
		assertThat(given).isEqualTo(when);
	}

	@Test
	@DisplayName("게임 시도 회수 가져오기 테스트 - 잘못된 문자 들어온 경우 그냥 0으로 간주")
	void getRunSizeHasNotNumberFormat() {

		String givenStr = "dd";
		int given = 0;
		int when = inputUtils.getRunSize(givenStr);
		assertThat(given).isEqualTo(when);
	}
}
