public class PlayWithQueues {
    public static void main(String[] args){
        //Create your own queue here  
        //Call all methods from this class and Queue class     
        Queue myQueue = new Queue();
        System.out.println("Enqueue 5");
        myQueue.enqueue(5);
        System.out.println("Enqueue 6");
        myQueue.enqueue(6);
        System.out.println("Current Queue:");
        printQueue(myQueue);
        System.out.println("Enqueue 7");
        myQueue.enqueue(7);
        System.out.println("Enqueue 10");
        myQueue.enqueue(10);
        System.out.println("Peak of queue: " + myQueue.peek());
        System.out.println("Clear queue");
        myQueue.dequeueAll();
        System.out.println("Is empty: " + myQueue.isEmpty());
        System.out.println("Enqueue 10");
        myQueue.enqueue(10);
        System.out.println("Current size: " + myQueue.getSize());

        Queue myQueue2 = new Queue();
        myQueue2.enqueue(1);
        myQueue2.enqueue(1);
        myQueue2.enqueue(2);
        myQueue2.enqueue(3);
        myQueue2.enqueue(4);
        myQueue2.enqueue(5);
        System.out.println("Queue2:");
        printQueue(myQueue2);
        System.out.println("Is 3 in the queue? " + inQueue(3, myQueue2));
        System.out.println("How many times does number 1 is on the queue? " + countNum(myQueue2, 1));
        System.out.println("The queue is in ascending order: " + ascendingOrder(myQueue2));
    }
    
    /* Method : printQueue()
	 * Prints the whole queue
     * Note: you will call methods from your Queue.java class
	 */
    public static void printQueue(Queue Q){
        int size = Q.size();
        for(int i = 0; i<size; i++){
            //read the first value and then enqueue it, at the end of the for loop the queue remains the same
            int temp = (int) Q.dequeue();
            Q.enqueue(temp);
            System.out.println(temp);
        }
    }  

    /* Method : inQueue()
	 * Checks to see if an item is in the queue
     * Note: you will call methods from your Queue.java class
	 */
    public static boolean inQueue(int n, Queue Q){
        boolean flag = false;
        int size = Q.size();
        for(int i = 0; i<size; i++){
            int temp = (int) Q.dequeue();
            Q.enqueue(temp);
            if(temp == n) {
                flag = true;
            }
        }
        return flag;
    }

    /* Method : countNum() -- BONUS 
	 * Checks to see how many times a number appears in a queue
	 */
    public static int countNum(Queue Q, int num){
        int count = 0;
        int size = Q.size();
        for(int i = 0; i<size; i++){
            int temp = (int) Q.dequeue();
            Q.enqueue(temp);
            //if number is equal to the current value increase the count
            if(temp == num) {
                count++;
            }
        }
        return count;
    }

    /* Method : ascendingOrder() -- BONUS
	 * Checks to see if the queue of integers are sorted in ascending order
	 */
    public static boolean ascendingOrder(Queue Q){
        boolean flag = true;
        int size = Q.size();
        for(int i = 0; i<size-1; i++){
            //retreive the two values to compare
            int first = (int) Q.dequeue();
            int second = (int) Q.peek();
            Q.enqueue(first);
            //compare the values
            if(first > second) {
                //if the first value on the queue is greater than the next one then it's not in ascending order
                flag = false;
            }
        }
        return flag;
    }
}
