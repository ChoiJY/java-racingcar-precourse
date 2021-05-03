package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Description : Car class test class
 *
 * Created by jychoi on 2021/05/02.
 */
class CarTest {

	@Test
	@DisplayName("car move 변경 method 정상 작동 케이스")
	void setMove() {

		Car givenCar = new Car("kakao");
		int given = 1;
		givenCar.setMove(givenCar.getMove() + 1);
		assertThat(given).isEqualTo(givenCar.getMove());
	}

	@Test
	@DisplayName("랜덤하게 차 움직이는 거 테스트 - 정상 케이스")
	void decideMoveOrStay() {
		Car givenCar = new Car("kakao");
		for (int idx = 0; idx < 100; idx++) {
			Car given = givenCar.decideMoveOrStay();
			// System.out.println(given.getMove());
		}
		assertThat(givenCar.getMove()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(99);
	}

	@Test
	@DisplayName("랜덤 수 생성 관련 테스트 - 0~9")
	void testRandom() {
		for (int idx = 0; idx < 100; idx++) {
			Random random = new Random(System.currentTimeMillis());
			int given = random.nextInt(9);
			// System.out.println(given);
			assertThat(given).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
		}
	}

	@Test
	@DisplayName("현재 Car의 move 상태 출력")
	void printStatus() {
		Car givenCar = new Car("kakao");
		for (int idx = 0; idx < 100; idx++) {
			Car given = givenCar.decideMoveOrStay();
			System.out.println(given.getStatusStr());
		}
	}
}