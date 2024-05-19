package ex_240501_2;

import java.util.Vector;

import util.CollectionUtils;

public class Collection_Vector_test {

	public static void main(String[] args) {
		// 배열 , 크기 고정, 공간3개에서만 관리를 해야해요.
		String[] array = new String[3];

		// Collection 하위의 Vector 이용하자. 가변 길이로
		// 기본적인 crud 테스트 해보기.
		// 기본 문법 : Vector<E> v = new Vector<E>();
		Vector<String> vectorStrings = new Vector<String>();
		System.out.println("Vector의 기본 용량 알아보기 vectorStrings.capacity() : " + vectorStrings.capacity());
		// add
		vectorStrings.add("초밥");
		// 출력하는 함수 이용해서, 출력해보기.
		CollectionUtils.showVectorElem(vectorStrings);
		System.out.println();
		System.out.println("========================================");
		// add
		vectorStrings.add("이상용씨는 불고기 돌솥비빔밥 우정 8000");
		// 출력 .
		System.out.println();
		System.out.println("========================================");
		System.out.println("벡터의 크기 : " + vectorStrings.size());
		CollectionUtils.showVectorElem(vectorStrings);
		// remove , 첫번째 요소 삭제.
		vectorStrings.remove(0);
		// 출력.
		System.out.println();
		System.out.println("========================================");
		System.out.println("벡터의 크기 : " + vectorStrings.size());
		CollectionUtils.showVectorElem(vectorStrings);

		// 원하는 갯수 만큼 더미데이터 넣기 반복문으로.
		CollectionUtils.addVectorElem(20, vectorStrings);

		// 출력 확인.
		System.out.println();
		System.out.println("========================================");
		System.out.println("벡터의 크기 : " + vectorStrings.size());
		CollectionUtils.showVectorElem(vectorStrings);
		System.out.println();
		System.out.println("Vector의 기본 용량 알아보기 vectorStrings.capacity() : " + vectorStrings.capacity());

		// 추가 넣기.
		// 원하는 갯수 만큼 더미데이터 넣기 반복문으로.
		CollectionUtils.addVectorElem(20, vectorStrings);

		// 출력 확인.
		System.out.println();
		System.out.println("========================================");
		System.out.println("벡터의 크기 : " + vectorStrings.size());
		CollectionUtils.showVectorElem(vectorStrings);
		System.out.println();
		System.out.println("Vector의 기본 용량 알아보기 vectorStrings.capacity() : " + vectorStrings.capacity());

		// 마지막 값 출력.
		System.out.println("vectorStrings.lastElement();" + vectorStrings.lastElement());

		// 모든 값 삭제.
		vectorStrings.removeAllElements();

		// 출력 확인.
		System.out.println();
		System.out.println("========================================");
		System.out.println("벡터의 크기 : " + vectorStrings.size());
		CollectionUtils.showVectorElem(vectorStrings);
		System.out.println();
		System.out.println("Vector의 기본 용량 알아보기 vectorStrings.capacity() : " + vectorStrings.capacity());
		
		// 오토 박싱(기본형 -> 참조형), 언박싱(참조형 -> 기본형)
		// 제너릭에 타입은 무조건 참조형만 가능. 
		Vector<Integer> vectorIntegers = new Vector<Integer>();
		vectorIntegers.add(Integer.valueOf(30));	
		vectorIntegers.add(30);
		//출력. 
		CollectionUtils.showVectorElem(vectorIntegers);
		
		
		

	}

}





