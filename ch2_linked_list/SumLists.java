import java.util.*;

public class SumLists{


	public static Node<Integer> CreateLinkedList(int length, int[] elements){
		Node<Integer> head = null;
		Node<Integer> pointerToHead = null;
		for(int i = 0; i < length; i++){
			if(head == null){
				head = new Node<Integer>(elements[i]);
				pointerToHead = head;
			}else{
				pointerToHead.next = new Node<Integer>(elements[i]);
				pointerToHead = pointerToHead.next;
			}
		}
		return head;
	}

	public static void printLL(Node<Integer> head){
		while(head != null){
			System.out.println(head.value);
			head = head.next;
		}
	}

	public static void main(String args[]){
		int []f = {7, 1, 6};
		Node<Integer> fn = CreateLinkedList(3, f);
		int []s = {5, 9 , 2};
		Node<Integer> sn = CreateLinkedList(3, s);
		printLL(sum(fn, sn)); // despite of the creation complexity, This algorithm will take O(MAX(len(fn), len(sn))) ~= O(N) where N = MAX(len(first LL), len(second LL))
	}

	public static Node<Integer> sum(Node<Integer> fn, Node<Integer> sn){
		int rem = 0, s = 0;
		Node<Integer> fn_iter = fn;
		Node<Integer> sn_iter = sn;
		Node<Integer> sumLL = null;
		Node<Integer> result = null;
		while(fn_iter != null || sn_iter != null){

			if(fn_iter != null && sn_iter != null){ // there are two digits be summed
				s = fn_iter.value + sn_iter.value;
				if(sumLL == null){
					sumLL = new Node<Integer>(s%10);
					result = sumLL;
				}else{
					sumLL.next = new Node<Integer>(s % 10 + rem);
				}
			}else if(fn_iter != null){ // first number got more digits
				sumLL.next = new Node<Integer>(fn_iter.value + rem);
			}else if(sn_iter != null){// second number got more digits
				sumLL.next = new Node<Integer>(sn_iter.value + rem);
			}
			
			if(sumLL.next != null){
				sumLL = sumLL.next;
			}
			s/=10;
			rem = s%10;
			fn_iter = fn_iter.next;
			sn_iter = sn_iter.next;
		}
		if(rem != 0)
			sumLL.next = new Node<Integer>(rem);

		return result;
	}

}