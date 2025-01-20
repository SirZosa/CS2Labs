public class InventoryLL{
    //Create a Linked List with the correct Attributes
    Node head;
    Node tail;
    static int size;

    //Inventory constructor
    InventoryLL(){
        this.head = null;
        this.tail = null;
        size = 0;
    }
    
    public void addToInventory(String[] item){
        //new node for the new item
        Node newNode = new Node(item);
        //If linked list null the new node is the start(head) and end(tail) of the linked list
        if (head == null) {
            head = newNode;
            tail = newNode;
        } 
        //else the new node is the tail(end) of the linked list
        else {
            tail.next = newNode;
            tail = newNode;
        }
        //increase size
        size++;
    } 

    public boolean inInventory(String itemName){
        //Temporary variable to go through the linked list
        Node temp = head;
        while(temp != null){
            //Return true if name in current node matches the item name
            //.equals because using "==" could lead to comparison mistakes
            if(temp.data[1].equals(itemName)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public String[] removeItem(String itemName){
        //Linked list empty
        if(head == null) return null;

        //First item is the one to be removed
        if(head.data[1].equals(itemName)){
            String[] removedItem = head.data;
            head = head.next;
            //if there is only one item on the linked list
            if(head == null){
                tail = null;
            }
            size--;
            return removedItem;
        }
        Node current = head;

        if(current.next != null){
            while(current.next != null){
                //if the next item after current item is the one to be removed
                if(current.next.data[1].equals(itemName)){
                    String[] removedItem = current.next.data;
                    //If the next item after the current is also the tail make the current item the tail(end) of the linked list
                    if(current.next == tail){
                        tail = current;
                    }
                    current.next = current.next.next;
                    //link the current item with the next item after the eliminated item
                    size--;
                    return removedItem;
                }
                current = current.next;
            }
        }
        //no item found
        return null;
    }

 
    
    public void displayItems() {
        //do nothing if empty
        if(head == null)return;
        //Print items on linked list until head is null using a temp variable
        Node temp = head;
        while(temp != null){
            String name = temp.data[1];
            String rarity = temp.data[2];
            String durability = temp.data[4];
            System.out.print(name + " [Rarity: "+rarity+ ", (Durability: " + durability + ")]  --->  ");
            temp = temp.next;
        }
    }
    
    
    public String[] getFromInventory(int index) {
        //index variable helper
        int currentIndex = 0;
        //If linked list is null or index is less than zero
        if(head == null || index < 0)return null;
        //temporary variable
        Node temp = head;
        //Searching item on the index
        while(temp != null){
            //If item on index is found
            if(currentIndex == index){
                String[] item = temp.data;
                return item;
            }
            temp = temp.next;
            currentIndex++;
        }
        //Not found or index exced linked list length
        return null;
    }
}





