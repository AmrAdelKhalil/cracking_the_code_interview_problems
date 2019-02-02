import java.util.*;

class Partition{


	public static void main(String []args){
		int []arr = {3,5,8,5,10,2,1};
		Node<Integer> head = CreateLinkedList(7, arr);
		Node<Integer> partitioned = partition_LL(head, 5);
		printLL(partitioned);
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

	public static Node<Integer> partition_LL(Node<Integer>head, int part_value){ // O(N), where N is the length of linked list, and will take O(N) for space too.
		Node<Integer> low_head=null, high_head=null, iter_low=null, iter_high=null;
		
		while(head != null){
			if(head.value < part_value){
				if(low_head == null){
					low_head = new Node<Integer>(head.value);
					iter_low = low_head;
				}else{
					iter_low.next = new Node<Integer>(head.value);
					iter_low = iter_low.next;
				}
			}else{
				if(high_head == null){
					high_head = new Node<Integer>(head.value);
					iter_high = high_head;
				}else{
					iter_high.next = new Node<Integer>(head.value);
					iter_high = iter_high.next;
				}
			}
			head = head.next;
		}
		iter_low.next = high_head;
		return low_head;
	}
}