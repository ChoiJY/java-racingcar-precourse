package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Description : Car Collection test class
 *
 * Created by jychoi on 2021/05/04.
 */
class CarCollectionTest {

	@Test
	@DisplayName("Car List 생성 및 불러오는거 정상 케이스")
	void getCarList() {

		Set<Car> given = new HashSet<>();
		given.add(new Car("kakao"));
		given.add(new Car("google"));
		given.add(new Car("fb"));

		Set<Car> carSet = new HashSet<>();
		carSet.add(new Car("kakao"));
		carSet.add(new Car("google"));
		carSet.add(new Car("fb"));
		CarCollection when = new CarCollection(carSet);

		assertThat(given).isEqualTo(when.getCarSet());
	}

	@Test
	@DisplayName("승자 추출 테스트 케이스")
	void getWinnerList() {

		Set<Car> carSet = new HashSet<>();
		carSet.add(new Car("kakao"));
		carSet.add(new Car("google"));
		carSet.add(new Car("fb"));
		CarCollection when = new CarCollection(carSet);
		when.move();
		when.move();
		when.move();
		when.move();
		when.move();
		when.move();
		when.move();
		when.move();
		List<String> winnerList = when.getWinnerList();
		// print 테스트
		String stringBuilder = String.join(", ", winnerList) + "가 최종 우승 했습니다.";
		System.out.println(stringBuilder);

	}
}
