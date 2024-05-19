package exam_240510;

public class Phone02 {
	private String name;
	private String tel;
	private String address;
//Phone02 안에 선언된 인스턴스 변수

	public Phone02(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	// Phone02 클래스의 생성자 정의

	// 연락처의 이름을 반환하는 메서드
	public String getName() {
		return name;
	}

	// 연락처의 전화번호를 설정하는 메서드
	public void setTel(String tel) {
		this.tel = tel;
	}

	// 연락처의 주소를 설정하는 메서드
	public void setAddress(String address) {
		this.address = address;
	}
	// 연락처 정보를 출력하는 메서드
	public void printInfo() {
		System.out.println(name + "의 번호와 주소는 " + tel + ", " + address + " 입니다.");
	}
}