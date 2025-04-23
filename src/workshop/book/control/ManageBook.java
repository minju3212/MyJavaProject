package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;

public class ManageBook {

	public static void main(String[] args) {
		//Publication 타입 배열을 선언 및 생성
		Publication[] pubs = new Publication[5];
		pubs[0] = new Magazine("마이크로소프트","2007-10-01",328,9900,"매월");
		
		//Magazine 객체 생성
		Magazine mz = new Magazine();
		//mz. 이건 호출할 수 있는 범위가 자기 자신과 부모의 메소드(총 5개)
		Publication pub = new Magazine();
		//pub. 이건 호출할 수 있는 범위가 부모의 메소드(총 4개) but 확장성이 커서 이걸 주로 사용
		
		//Novel 객체 생성
		Novel novel = new Novel();
		Publication pub2 = new Novel();
	}

}
