package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
	private final List<Ball> balls;

	public Balls(List<Integer> numbers) {
		balls = new ArrayList<>();
		int position = 1;
		for (int number : numbers) {
			balls.add(new Ball(number, position++));
		}
	}

	public BallStatus play(Ball comBall) {
		BallStatus result = balls.stream()
			.map(ball-> ball.play(comBall))
			.filter(status -> status != BallStatus.NOTHING)
			.findFirst()
			.orElse(BallStatus.NOTHING);
		return result;
	}

	public PlayResult play(Balls comBalls) {
		PlayResult playResult = new PlayResult();

		for (Ball comBall: comBalls.balls) {
			BallStatus result = this.play(comBall);
			playResult.setResult(result);
		}

		return playResult;
	}
}
