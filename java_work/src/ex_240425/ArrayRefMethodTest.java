package ex_240425;

import java.util.Scanner;

import ex_240424.TodayPickLunchWithWeatherWhile3;

public class ArrayRefMethodTest {
	// 이 메서드는 크기3개인, 문자열 타입의 배열을 생성 해주는 메서드. 
	public static String[] makeStringArray() {
		String [] tempStringArray = new String[3];
		for (int i = 0; i < tempStringArray.length; i++) {
			tempStringArray[i] = "먹고 싶은 점심 메뉴"+i;
		}
		return tempStringArray;
		
	}
	
	public static void main(String[] args) {
		// 위에서 만든 메서드를 이용해서, 1차원 배열을 만들어서, 참조형 변수를 할당
		String[] lunchMenuLsy;
		// makeStringArray() 리턴 1차원 배열 -> 참조형 변수 -> 메모리 위치 주솟값
		lunchMenuLsy = makeStringArray();
		for (int i = 0; i < lunchMenuLsy.length; i++) {
			System.out.println("기본값 출력 : " + lunchMenuLsy[i]);
		}
		int lunchMenuLsyMemoryAddress = System.identityHashCode(lunchMenuLsy);
		System.out.println("lunchMenuLsy 의 메모리 위치 주솟값 : " + lunchMenuLsyMemoryAddress);
		
		String[] lunchMenuLsy2;
		// makeStringArray() 리턴 1차원 배열 -> 참조형 변수 -> 메모리 위치 주솟값
		lunchMenuLsy2 = makeStringArray();
		for (int i = 0; i < lunchMenuLsy2.length; i++) {
			System.out.println("기본값 출력 : " + lunchMenuLsy2[i]);
		}
		int lunchMenuLsyMemoryAddress2 = System.identityHashCode(lunchMenuLsy2);
		System.out.println("lunchMenuLsy2 의 메모리 위치 주솟값 : " + lunchMenuLsyMemoryAddress2);
		
		Scanner scanner = new Scanner(System.in);
		TodayPickLunchWithWeatherWhile3.recommendFood(scanner);

	}
	

}




