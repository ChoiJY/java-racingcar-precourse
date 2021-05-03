package domain;

import java.util.Random;

/**
 * Description : Car class
 *
 * Created by jychoi on 2021/05/02.
 */
public class Car {

	public Car(String name) {
		this.name = name;
		this.move = 0;
	}

	private final String name;
	private int move;

	public int getMove(){
		return this.move;
	}

	public String getName() {
		return name;
	}

	public void setMove(int move) {

		this.move = move;
	}

	/**
	 * Description: 개별 차 move 관련 method
	 *
	 * @return (Car) 현재 차 class
	 */
	public Car decideMoveOrStay() {

		Random random = new Random(System.currentTimeMillis());
		if (random.nextInt(9) >= 4) {
			this.setMove(this.move + 1);
		}

		return this;
	}

	/**
	 * Description: 현재 차 class ui method
	 *
	 * @return String (출력 포맷)
	 */
	public String getStatusStr() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.name).append(" : ");

		for (int idx = 0; idx < this.move; idx++) {
			stringBuilder.append("-");
		}

		return stringBuilder.toString();
	}
}
