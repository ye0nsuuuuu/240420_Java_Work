package exam_240510;

import java.awt.Point;

public class ColorPoint03 extends Point {

	private String color;

	public ColorPoint03(int x, int y, String color) {
		super(x, y);// 부모 클래스(Point)의 생성자 호출
		this.color = color;
	}

	// 점의 좌표를 설정하는 메서드
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 색상 설정
	public void setColor(String color) {
		this.color = color;
	}

	public void show() {
		// 색상, x 좌표, y 좌표를 출력
		System.out.println(color + "색으로 (" + getX() + ", " + getY() + ")");
	}

	public static void main(String[] args) {
		// ColorPoint03 객체 생성
		ColorPoint03 cp = new ColorPoint03(5, 5, "YELLOW");
		cp.setPoint(10, 20);// 좌표 변경
		cp.setColor("GREEN");// 색상 변경
		cp.show();
	}
}
