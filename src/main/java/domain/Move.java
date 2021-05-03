package domain;

/**
 * Description : 차량 이동 관련 class
 *
 * Created by jychoi on 2021/05/04.
 */
public class Move {

	public Move() {
		this.move = 0;
	}

	public int getMove() {
		return move;
	}

	public void increaseMove() {
		this.move = this.move + 1;
	}

	private int move;
}
