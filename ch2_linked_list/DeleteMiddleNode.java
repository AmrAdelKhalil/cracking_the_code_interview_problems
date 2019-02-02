import java.util.*;

class DeleteMiddleNode{

	public static void main(String []args){
		int[] array = {1,2,3,4,5,6,7};
		Node<Integer> head = CreateLinkedList(7, array);
		delete_node(head.next); // delete second node so expect to see 1, 3, 4, 5, 6, 7
		printLL(head);
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

	public static void delete_node(Node<Integer> node){ // O(N - Node position need to be deleted)
		if(node == null || node.next == null)
			return;

		while(node.next.next != null){
			node.value = node.next.value;
			node = node.next;
		}
		node.value = node.next.value; // for the last node
		node.next = null;
	}
}