package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Description : Car 일급 콜렉션 class
 *
 *
 * Created by jychoi on 2021/05/02.
 */
public class CarCollection {

	public CarCollection(Set<Car> carSet) {
		this.carSet = carSet;
	}

	private final Set<Car> carSet;

	public Set<Car> getCarSet() {
		return carSet;
	}

	/**
	 * Description: 게임 내 승자 목록 추출
	 *
	 * @return List<String> 승자(차) 목록
	 */
	public List<String> getWinnerList() {

		int highestMove = 0;

		for (Car car : carSet) {
			highestMove = getHighestMove(car, highestMove);
		}

		return pickHighestCarName(highestMove);
	}

	/**
	 * Description: 게임 진행 (1 step), Car collection 내 차량 모두 전진
	 */
	public void move() {

		System.out.println();
		for (Car car : carSet) {
			Car eachCar = car.decideMoveOrStay();
			System.out.println(eachCar.getStatusStr());
		}
	}

	/**
	 * Description: Car collection 내 가장 멀리 움직인 거리 추출
	 *
	 * @param car 현재 Car
	 * @param highestMove 가장 멀리 움직인 거리
	 * @return 가장 멀리 움직인 거리
	 */
	private int getHighestMove(Car car, int highestMove) {

		if (car.getMove() > highestMove) {
			highestMove = car.getMove();
		}
		return highestMove;
	}

	/**
	 * Description: 가장 멀리 움직인 차 이름들 출력 (중복 가능)
	 *
	 * @param highestMove 가장 멀리 움직인 거리
	 * @return List<String> 가장 멀리 움직인 차 이름들
	 */
	private List<String> pickHighestCarName(int highestMove) {

		List<String> winnerList = new ArrayList<>();

		for (Car car : carSet) {
			addWinnerList(car, highestMove, winnerList);
		}

		return winnerList;
	}

	/**
	 * Description: 승자 목록 list에 해당 target 넣는 method
	 *
	 * @param car 현재 Car
	 * @param highestMove 가장 멀리 움직인 거리
	 * @param winnerList 승자 목록
	 */
	private void addWinnerList(Car car, int highestMove, List<String> winnerList) {

		if (car.getMove() == highestMove) {
			winnerList.add(car.getName());
		}
	}
}
