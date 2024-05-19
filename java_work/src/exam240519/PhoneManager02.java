package exam_240510;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneManager02 {
	private Map<String, Phone02> phoneBook;
//String 키 , Phone02 밸류

	public PhoneManager02() {
		phoneBook = new HashMap<>();
	}

//새로운 연락처 추가
	//정의
	public void addPhone(String name, String tel, String address) {
		Phone02 phone = new Phone02(name, tel, address);
		phoneBook.put(name, phone);
		System.out.println("저장되었습니다...");
	}

//연락처 검색
	//정의
	public void searchPhone(String name) {
		Phone02 phone = phoneBook.get(name);//이름으로 연락처 가져오기
		if (phone != null) { //null이 아니면 
			phone.printInfo();//연락처 출력
		} else {
			System.out.println(name + " 은(는) 없습니다.");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//스캐너 입력도구
		PhoneManager02 manager = new PhoneManager02();//PhoneManager02 객체 생성

		System.out.print("인원수 >> ");
		int count = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < count; i++) {
			System.out.print("이름과 전화번호(번호는 연속적으로 입력), 주소 >> ");
			String input = scanner.nextLine();
			String[] data = input.split(" ");//공백을 기준으로 분리하여 배열에 저장
			manager.addPhone(data[0], data[1], data[2]);
			//addPhone 사용(이름 번호 주소 분리하여 데이터 0,1,2 에 담음)
		}
		while (true) {
			System.out.print("검색할 이름 >> ");
			String searchName = scanner.nextLine();//검색할 이름 입력 받기

			if (searchName.equals("exit")) { 
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			manager.searchPhone(searchName);
		}//searchPhone 사용
		scanner.close();//스캐너 반납
	}
}