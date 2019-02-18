import java.util.*;

public class LoopDetection {

	public static void main(String []args){
		int []arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};
		Node<Integer> head = CreateLinkedList(9, arr);

		Node<Integer> slow = head;
		Node<Integer> fast = head;
		Node<Integer> met_point = null;

		while(slow != null && fast != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				met_point = fast;
			}
		}

		if(slow != null && fast != null){ // there is a loop
			slow = head;
			while(slow != fast){
				slow = slow.next;
				fast = fast.next;
			}
			// print slow or fast value here
		}

		// This is the solution of the book, I thought in another one with an additional memory, using a hash map or set.
		// This solution depend on that, because we are using runner technique, if the slower takes k steps before entering the loop
		// this means that the fater has already made 2k steps, so k steps where spent inside the loop for the faster pointer
		// we get the point where they met which will be (loop size % k), after that we now sure that the met point is k steps before the start of the loop.
		
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