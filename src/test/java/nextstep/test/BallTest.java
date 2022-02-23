package nextstep.test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.Ball;
import baseball.BallStatus;

public class BallTest {
	private Ball userBall;

	@BeforeEach
	void test() {
		userBall = new Ball(1, 2);
	}

	@Test
	void 스트라이크_테스트() {
		Ball comBall = new Ball(1,2);

		assertThat(userBall.play(comBall)).isEqualTo(BallStatus.STRIKE);
	}

	@Test
	void 볼_테스트() {
		Ball comBall = new Ball(1,1);

		assertThat(userBall.play(comBall)).isEqualTo(BallStatus.BALL);
	}

	@Test
	void 낫싱_테스트() {
		Ball comBall = new Ball(3,2);

		assertThat(userBall.play(comBall)).isEqualTo(BallStatus.NOTHING);
	}

}
