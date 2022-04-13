package java0413_collection;

import java.util.LinkedList;
/*Queue(큐)
 * 1. FIFO(First in First out) : 제일 먼저 저장한 요소를
 *                제일 먼저 꺼낸온다.
 * 2. 최근사용문서 , 인쇄작업대기목록, 버퍼              
 */
//stack, queue when getting an element, remove from memory
public class Java191_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> nQueue = new LinkedList<String>();
		
		nQueue.offer("java");
		nQueue.offer("sql");
		nQueue.offer("python");
		nQueue.offer("jsp");
		
		while(!nQueue.isEmpty()) {
			System.out.println(nQueue.poll());
		}
		System.out.println(nQueue.isEmpty());
	}
}
