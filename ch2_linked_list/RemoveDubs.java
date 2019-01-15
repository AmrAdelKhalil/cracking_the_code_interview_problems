import java.util.*;

public class RemoveDubs{

	public static void main(String[] args){

		if(args.length < 2){ // NOWAY for dublication
			for(String s : args){
				System.out.println(s);
			}		
			return ;	
		} 

		// printing args input
		// for(String s : args){
		// 	System.out.println(s);
		// }

		Map<String, Integer> hash_table = new HashMap<String, Integer>();
		
		Node<String> head = new Node<String>(args[0]);
		Node<String> iter = head;
		Node<String> prev = null;
		
		// creating LINKED LIST from INPUT
		for(int i = 1; i < args.length; i++){
			Node<String> new_node = new Node<String>(args[i]);
			iter.next = new_node;
			iter = new_node;
		}

		prev = head;
		iter = prev.next;

		// mark first node as a part of the new LL
		hash_table.put(prev.value, 1);

		while(iter != null){
			if(hash_table.get(iter.value) == null){ // if it is new, it remains and mark it as included
				hash_table.put(iter.value, 1);
				iter = iter.next;
			}else{ // we have to neglect iter node
				prev.next = iter.next;
				iter = iter.next;
				if(iter!=null) iter = iter.next;
			}
			prev = prev.next;
		}

		iter = head;
		while(iter != null){
			System.out.println("value = " + iter.value);
			iter = iter.next;
		}
	}
}