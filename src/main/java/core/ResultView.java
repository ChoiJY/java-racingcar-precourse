package core;

import java.util.List;

import domain.CarCollection;

/**
 * Description : 결과 ui class
 *
 * Created by jychoi on 2021/05/04.
 */
public class ResultView {

	/**
	 * Description: 승자 출력 method
	 *
	 * @param carCollection 게임에 참여하는 차 목록
	 */
	public void printWinner(CarCollection carCollection) {

		System.out.println();
		List<String> winnerList = carCollection.getWinnerList();
		System.out.println(String.join(",", winnerList) + " 가 최종 우승 했습니다.");
	}
}
