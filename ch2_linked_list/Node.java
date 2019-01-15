import java.util.*;

public class Node<V>
{
	V value;
	Node<V> next = null;

	Node(){
	}

	Node(V value){
		this.value = value;
		this.next = null;
	}

	Node(V value, Node<V> next){
		this.value = value;
		this.next = next;
	}
}