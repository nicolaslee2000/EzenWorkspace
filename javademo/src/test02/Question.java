package test02;
/*
 * Parent c = new Child();
 * 
 * 질문: 객채생성할때 업캐스팅이 왜 필요한가?
 * Parent c = new Child();
 * Child c = new Child(); 의 차이
 * 
 */

public class Question {
	public static void main(String[] args) {
		//1.
		LgTv lgtv = new LgTv();
		watchTv(lgtv);
		
		SamsungTv samsungTv = new SamsungTv();
		watchTv(samsungTv);
		
		HomeTv hometvLg = new LgTv();
		watchTv(hometvLg);
		
		HomeTv hometv = lgtv;
		watchTv(hometv);
		//
		//2.
		ExamB bb = new ExamB();
		System.out.println(bb instanceof ExamA);
		System.out.println(bb instanceof ExamB);
		
		ExamA ea = new ExamB();
		System.out.println(ea instanceof ExamB);
		System.out.println(ea instanceof ExamA);
		//
		 
	}
	public static void watchTv(HomeTv tv) {
		tv.watching();
	}
}

class HomeTv {
	public void watching() {
		System.out.println("watching");
	}
}
class LgTv extends HomeTv {
	@Override
	public void watching() {
		System.out.println("Watching LG");
	}
}
class SamsungTv extends HomeTv {
	
}

class ExamA{
	
}
class ExamB extends ExamA{
	
}
	
