package java0406;

/*
1 매개변수로 받은 메시지 문자열에서 적절한 제품정보를 추출하여 
  콘솔에 출력하는 handleMessage() 메서드를 구현하시오.
  단, 메시지 형식은 "제품아이디:제품명:가격:수량:제조사" 
    순서로 구성되어야 한다.
 만약 메시지를 구성하는 요소가 적을 경우
   실행 결과와 동일한 메시지를 사용자에게 보여줘야 한다.
  
2 출력결과
<< 첫 번째 메시지 >>
제품 아이디 : PROD-00001
제품명 : iPhone4
가격 : 940000
수량 : 4
제조사 : 애플
<< 두 번째 메시지 >>
메시지 형식이 잘못되었습니다.
메시지는 제품아이디:제품명:가격:수량:제조사 형식이어야 합니다.

 */

public class Exc01 {
	public static void main(String[] args) {
		handleMessage("DF:#33:df:df:df");
	}
	private static void handleMessage(String str) {
		String output = "";
		String[] msg = str.split(":");
		String[] categories = {"Product ID","Product name", "Price", "Amount", "Manufacturer"};
		if(msg.length!=categories.length) {
			output = "Wrong format";
			return;
		}
		for(int i = 0; i < msg.length; i++) {
			output += categories[i]+": "+ msg[i] + "\n";
		}
		System.out.println(output);
	}
}
