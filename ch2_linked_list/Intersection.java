import java.util.*;

class Intersection{

	public static void main(String []args){
		int []arr = {1, 2, 3 , 4};
		Node<Integer> head = CreateLinkedList(4, arr);
		int []arr2 = {5 , 6};
		Node<Integer> head2 = CreateLinkedList(2, arr2);
		head2.next.next = head.next;

		
		// using the information of the length head length = 4 and head2 length = 2
		int diff = (4 > 2) ? (4-2)-1 : (2-4)-1; // of course this is dummy but I image that there will be two vairables that holds the lengths of the both LL
		while(diff != 0){
			head2 = head2.next;
			diff--;
		} // Now they both of the same length, we now iterate of both of them to get the intersection

		while(head != null && head2 != null){
			if(head == head2){
				System.out.println(head.value);
				break;
			}
			head = head.next;
			head2 = head2.next;
		}// This will take O(A+B)
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