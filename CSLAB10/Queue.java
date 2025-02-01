/* CS2401: Lab 10
 * Class Queue:
 * Generic Queue class implemented as an array of generic type,
 * which bundles as attributes: 
 * 	- 	the array that holds the information in the queue
 * 	-	the index of the head of the queue
 * 	- 	the index of the tail of the queue 
 * 	- 	the size of the queue
 */

public class Queue{
	/*	ATTRIBUTES: *********************************************/
	private int QUEUE_SIZE = 50;
	private Object[] items;
	private int front, back, count;


	/* CONSTRUCTOR: *********************************************/
	
	public Queue() { 
		items = new Object[QUEUE_SIZE];
		front = 0;
		back = QUEUE_SIZE -1;
		count =0;
	}

	
	/* GETTERS: *************************************************/
	public int getSize() {
		return QUEUE_SIZE;
	}

	/* Method: isFull
	 * Checks to see if the queue has reached the max size allowed 
	 */
	public boolean isFull() {
		//if count is equal to the size of the queue return true
		return count == QUEUE_SIZE;
	}


	/* Method: isEmpty
	 * Checks to see if the queue is empty
	 */
	public boolean isEmpty() {
		//count equal to zero return true
		return count == 0;
	}
	
	
	/* Method: dequeue
	 * Removes and returns the element at the head of the Queue. 
	 * Note: if the queue was empty, nothing can be dequeued and then your method returns null.
	 * Complete the code below, as instructed.
	 */
	public Object dequeue(){
		if(isEmpty()){
			System.out.println("Queue empty");
			return null;
		}
		else{
			//temp file that gets the value of the first item on queue
			Object queueFront = items[front];
			//the front poiter is added 1
			front = (front + 1) % QUEUE_SIZE;
			//reduce the size of the queue
			count --;
			return queueFront;
		}
	}
	

	/* Method : enqueue
	 * Takes data as parameter and adds it to the queue.  
	 * Note: if the queue is full, nothing can be enqueued and then your method 
	 * prints out the following message: "The queue is full: data was not enqueued".
	 * Complete the code below, as instructed.
	 */
	public void enqueue(Object newItem){
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}
		else{
			//add new item to the back of the queue
			back = (back + 1) % QUEUE_SIZE;
			items[back] = newItem;
			count++;
			return;
		}
	}		

	/* Method : dequeueAll
	 * Resets all attributes of the queue 
	 */
	public void dequeueAll(){
		//restart the queue to default values
		items = new Object[QUEUE_SIZE];
		front = 0;
		back = QUEUE_SIZE -1;
		count = 0;
	}


	/* Method: peek
	 * Returns, without removing, the element at the head of the Queue. 
	 * Note: if the queue was empty, nothing can be peeked at and then your method returns null.
	 * Complete the code below, as instructed.
	 */
	public Object peek(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return null;
		}
		//return the first item value
		return items[front];      
	}


	/* Method : size
	 * Gets the size of the Queue  
	 */
	public int size(){
		return count;
	}
}
