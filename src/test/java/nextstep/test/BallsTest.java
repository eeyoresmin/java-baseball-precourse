package nextstep.test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import baseball.Ball;
import baseball.BallStatus;
import baseball.Balls;
import baseball.PlayResult;

public class BallsTest {
	@Test
	void 원스트라이크_투볼() {
		Balls userBalls = new Balls(Arrays.asList(1,2,3));
		Balls comBalls = new Balls(Arrays.asList(1,3,2));

		PlayResult playResult = userBalls.play(comBalls);

		assertThat(playResult.getStrike()).isEqualTo(1);
		assertThat(playResult.getBall()).isEqualTo(2);
	}

	@Test
	void 원스트라이크_원볼() {
		Balls userBalls = new Balls(Arrays.asList(1,2,3));
		Balls comBalls = new Balls(Arrays.asList(1,4,2));

		PlayResult playResult = userBalls.play(comBalls);

		assertThat(playResult.getStrike()).isEqualTo(1);
		assertThat(playResult.getBall()).isEqualTo(1);
	}

	@Test
	void 투스트라이크() {
		Balls userBalls = new Balls(Arrays.asList(1,2,3));
		Balls comBalls = new Balls(Arrays.asList(1,2,4));

		PlayResult playResult = userBalls.play(comBalls);

		assertThat(playResult.getStrike()).isEqualTo(2);
		assertThat(playResult.getBall()).isEqualTo(0);
	}

	@Test
	void 쓰리스트라이크() {
		Balls userBalls = new Balls(Arrays.asList(1,2,3));
		Balls comBalls = new Balls(Arrays.asList(1,2,3));

		PlayResult playResult = userBalls.play(comBalls);

		assertThat(playResult.getStrike()).isEqualTo(3);
		assertThat(playResult.getBall()).isEqualTo(0);
	}

	@Test
	void 볼() {
		Balls userBall = new Balls(Arrays.asList(1,2,3));
		Ball comBall = new Ball(1,2);

		assertThat(userBall.play(comBall)).isEqualTo(BallStatus.BALL);
	}
	@Test
	void 스트라이크() {
		Balls userBall = new Balls(Arrays.asList(1,2,3));
		Ball comBall = new Ball(1,1);

		assertThat(userBall.play(comBall)).isEqualTo(BallStatus.STRIKE);
	}
	@Test
	void 낫싱() {
		Balls userBall = new Balls(Arrays.asList(1,2,3));
		Ball comBall = new Ball(8,2);

		assertThat(userBall.play(comBall)).isEqualTo(BallStatus.NOTHING);
	}


}
