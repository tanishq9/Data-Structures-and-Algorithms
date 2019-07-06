package OOPS3;

class Bicycle {
	public int gear;
	public int speed;

	public Bicycle(int gear, int speed) {
		this.gear = gear;
		this.speed = speed;
	}

	public void applyBrake(int dec) {
		speed -= dec;
	}

	public void speedUp(int inc) {
		speed += inc;
	}

	public String toString() {
		return gear + " " + speed;
	}
}

class MountainBike extends Bicycle {
	int seatHeight;

	MountainBike(int gear, int speed, int sh) {
		super(gear, speed);
		this.seatHeight = sh;
	}

	void setHeight(int newval) {
		this.seatHeight = newval;
	}

	@Override
	public String toString() {
		return gear + " " + speed + " " + seatHeight;
	}
}

public class Inheritance101 {
	public static void main(String[] args) {
		MountainBike mb = new MountainBike(10, 20, 15);
		System.out.println(mb.toString());
		mb.speedUp(5);
		System.out.println(mb.toString());
	}
}
