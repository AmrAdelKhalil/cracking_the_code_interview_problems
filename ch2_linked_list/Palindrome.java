import java.util.*;

public class Palindrome {

	public static void main(String []args){
		int []arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};
		Node<Integer> head = CreateLinkedList(9, arr);
		Node<Integer> copy = null;
		Node<Integer> head_iter = head;

		while(head_iter != null){
			if(copy == null){
				copy = new Node<Integer>(head_iter.value);
			}else{
				copy = new Node<Integer>(head_iter.value, copy);
			}
			head_iter = head_iter.next;
		}

		// printLL(copy);

		head_iter = head;
		Node<Integer> copy_iter = copy;
		boolean pal = true;
		while(copy_iter != null && head_iter != null){
			if(copy_iter.value != head_iter.value)
				pal = false;
			copy_iter = copy_iter.next;
			head_iter = head_iter.next;
		}

		System.out.println(pal);
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

}