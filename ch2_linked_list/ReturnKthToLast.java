import java.util.*;

public class ReturnKthToLast{

	public static void main(String []args){
		int[] array = {1,2,3,4,5};
		Node<Integer> head = CreateLinkedList(5, array); // O(length)
		// printLL(head);
		int kth = kthToLast(3, 5, head); //O((length - kth))
		System.out.println(kth);
	} 

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

	public static int kthToLast(int kth, int length, Node<Integer> head){
		if(length - kth < 0)
			return -1;

		Node<Integer>iter = head;
		for(int i = 0 ; i < length - kth; i++){ // O(kth)
			if(iter.next != null)
				iter = iter.next;
		}
		return iter.value;
	}

}
