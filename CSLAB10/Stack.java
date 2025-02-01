/* CS2401: Lab 10
 * Class Stack:
 * Generic Stack class implemented as a linked list that bundles a Node 
 * container -- the top of the stack --
 * and the size of the stack -- number of elements in the stack (to keep track)
 * which is also the number of nodes linked from the top of the stack
 */

/******************************************************************************
 * Note: In this implementation of a container stack, we choose to implement 
 * it as an linked list (remember: a stack can be implemented as a linked list 
 * or as an array).
******************************************************************************/


public class Stack<T> {
	
	// Attributes *****************************************************************
	private Node<T> top;
	private int size;
	
    // Constructors ****************************************************************
	public Stack() {}

	
	public Stack(T data) {
		top = null;
		size = 1;
	}

    // Getters *********************************************************************
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/* Note: we do not provide a method to getting the top data because in stack 
	 * manipulations, it is called peek. So instead, below, you can find a method peek
	 */
	
	/* Similarly we do not provide setters. Indeed setters would be: 
	 * 	- setting the size (which does not make complete sense because size depends 
	 * 		on the content, so it should not be set independently), 
	 * 	- and setting the top, which, in stack manipulation, is called push.
	 */


	/* Method : push
	 * Takes data T and adds it to the stack 
	 */
	public void push(Object data) {
		//the top of the stack is the new item
		top = new Node<>(data, top);
		size ++;
	}
	
	/* Method : pop
	 * Removes the top element of the stack and returns the data that was just
	 * removed from the stack.
	 * Note: if the stack was empty, nothing can be popped and pop then returns null.
	 * Complete the code below, as instructed.
	 */
	public Object pop() {
		if(isEmpty()){
			System.out.println("Stack is empty");
			return null;
		}
		else{
			//temp variable to store the top
			Node<T> temp = top;
			//the new top is the next value on the stack
			top = top.next;
			size--;
			//return the temp variable
			return temp.data;
		}
	}

	
	/* Method : peek
	 * Returns the data at the top of the stack.
	 * The stack itself is not modified: we are just peeking.
	 * Complete the code below, as instructed.
	 */
	public Object peek() {
		if(isEmpty()){
			System.out.println("Stack is empty");
			return null;
		}
		//return current value data
		return top.data;
	}

	/* Method : clear
	 * Completely empties the stack, nothing will be in there
	 * Complete the code below, as instructed.
	 */
	public void clear() {
		//make top null
		top = null;
	}
	
	/* Method: isEmpty
	 * Checks if the stack is empty. It returns true if the stack is empty, false
	 * otherwise.
	 * Complete the code below, as instructed.
	 */
	public boolean isEmpty() {
		//if top is null return true
		return top == null;
	}
	
}
