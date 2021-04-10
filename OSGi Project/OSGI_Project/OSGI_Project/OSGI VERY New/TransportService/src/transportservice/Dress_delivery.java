package transportservice;

public class Dress_delivery implements TransportInterFa {
	@Override
	public float calculate(float distance) {
		if (distance <= 2) {
			return 150;
		} else {
			return (150 + (distance - 2) * 25);
		}
	}

}
