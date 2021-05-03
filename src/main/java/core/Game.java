package core;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import domain.Car;
import domain.CarCollection;
import util.InputUtils;

/**
 * Description : Game class
 *
 * Created by jychoi on 2021/05/02.
 */
public class Game {

	public Game() {
	}

	private final InputUtils inputUtils = new InputUtils();
	private final ResultView resultView = new ResultView();
	private final Scanner sc = new Scanner(System.in);

	private static final String WELCOME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_GAME_SIZE_MESSAGE = "시도할 회수는 몇회인가요?";

	/**
	 * Description: 게임 실행 main class
	 */
	public void run() {

		CarCollection carCollection = initializeCarSet();
		int gameSize = initializeGameSize();

		for (int idx = 0; idx < gameSize; idx++) {
			carCollection.move();
		}

		// 게임 결과 출력
		resultView.printWinner(carCollection);
	}

	/**
	 * Description: welcome msg 출력 및 Car setting
	 *
	 * @return CarCollection
	 */
	private CarCollection initializeCarSet() {
		// welcome msg 출력 및 Car setting
		System.out.println(WELCOME_MESSAGE);
		Set<String> carNameList = inputUtils.splitInputStr(sc.nextLine());

		Set<Car> carSet = new HashSet<>();
		carNameList.forEach(each -> carSet.add(new Car(each)));

		return new CarCollection(carSet);
	}

	/**
	 * Description: 게임 회수 msg 출력 및 game size setting
	 *
	 * @return 입력한 게임 회수
	 */
	private int initializeGameSize() {
		System.out.println(INPUT_GAME_SIZE_MESSAGE);
		return inputUtils.getRunSize(sc.nextLine());
	}
}
