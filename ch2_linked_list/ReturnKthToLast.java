import java.util.*;

public class ReturnKthToLast{

	public static void main(String []args){
		int[] array = {1,2,3,4,5};
		Node<Integer> head = CreateLinkedList(5, array); // O(length)
		// printLL(head);
		Node<Integer> kth = kthToLast(3, head); //O(kth + (length - kth)) = O(length)
		printLL(kth);
	} // total O(2length) = O(length)

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

	public static Node<Integer> kthToLast(int kth, Node<Integer> head){
		Node<Integer>iter = head;
		for(int i = 0 ; i < kth-1; i++){ // O(kth)
			if(iter.next != null)
				iter = iter.next;
		}
		return makeCopy(iter);
	}

	public static Node<Integer> makeCopy(Node<Integer> start){ // O(legth - kth)
		Node<Integer> copy = null;
		Node<Integer> pointerToCopy = null;
		while(start != null){
			if(copy == null){
				copy = new Node<Integer>(start.value);
				pointerToCopy = copy;
			}else{
				pointerToCopy.next = new Node<Integer>(start.value);
				pointerToCopy = pointerToCopy.next;	
			}
			start = start.next;
		}
		return copy;
	}
}
