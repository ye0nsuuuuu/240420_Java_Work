package ex_240426_4;

public class Person {
	// 인스턴스 멤버
	private String name;
	private String age;
	private String[] hobbies;
	
	//getters/setters(생략, 이유? 생성자 매개변수 3개로 등록해서)
	// 인스턴스를 한번 등록후 변경을 잘 안해서. 
	
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	
	//말하기 
	public void speak() {
		System.out.println("hello~~");
	}
	// 먹기 
	public void eat() {
		System.out.println("냠냠~~");
	}
	
	// 걷기 
	public void walk() {
		System.out.println("걷기~~");
	}
	
	// 잠자기
	public void sleep() {
		System.out.println("잠자기~~");
	}
	
}










