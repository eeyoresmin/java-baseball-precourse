package baseball;

import java.util.Objects;

public class Ball {
	private int number;
	private int position;

	public Ball(int number, int position) {
		this.number = number;
		this.position = position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return number == ball.number && position == ball.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, position);
	}

	public BallStatus play(Ball targetBall) {
		if (this.equals(targetBall)) {
			return BallStatus.STRIKE;
		}
		if (this.isSameNumber(targetBall)) {
			return BallStatus.BALL;
		}

		return BallStatus.NOTHING;
	}

	private boolean isSameNumber(Ball targetBall) {
		return this.number == targetBall.number;
	}
}
