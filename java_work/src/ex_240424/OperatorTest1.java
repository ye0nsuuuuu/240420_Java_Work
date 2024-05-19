package ex_240424;

import java.util.Scanner;

public class OperatorTest1 {

	public static void main(String[] args) {
		System.out.println("증감 연산자 앞,뒤 위치에 따른 계산 결과 확인. ");
		int a = 1; 
		int b = ++a;
		System.out.println("증감이 앞에 있는 경우 b : " + b);
		System.out.println("a 의 결과 : " + a);
		
		int c = 1; 
		int d = c++;
		System.out.println("증감이 뒤에 있는 경우 d: " + d);
		System.out.println("결론, 위치 상관없이 1 더해지는 결과는 같고, 할당 순서만 다르다. ");
		System.out.println("c 의 결과 : " + c);
		
		System.out.println("삼항 다항식 : 문법: 식 ? 참일경우 할당 : 거짓일 경우 할당");
		int x = 5;
		int y = 7;
		int result1 = (x>y) ? x:y;
		System.out.println("result1 : " + result1);
		
		// 날씨관련 음식추천 함수 사용해보기. 
		Scanner scanner = new Scanner(System.in);
		TodayPickLunchWithWeatherWhile3.recommendFood(scanner);

	}

}




