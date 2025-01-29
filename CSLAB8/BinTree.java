public class BinTree{
    //ATTRIBUTE
    Treenode root;

    //CONSTRUCTOR
    BinTree(){}

    BinTree(Treenode data){
        root = data;
    }

    //TRAVERSAL METHODS
    public void printPre(Treenode node){
        //PreOrder is node, left and right
        if(node == null) return;
    
        System.out.print(node.data + " ");
        printPre(node.left);
        printPre(node.right);
    }
    public void printIn(Treenode node){
        //In order is left, node, right
        if(node == null) return;
    
        printIn(node.left);
        System.out.print(node.data + " ");
        printIn(node.right);
    }
    public void printPost(Treenode node){
        //PostOrder is left right and node
        if(node == null) return;
    
        printPost(node.left);
        printPost(node.right);
        System.out.print(node.data + " ");
    }

    //SEARCH AND SUM METHODS
    public boolean search(Treenode node, int key){
        //Base case
        if (node == null) {
            return false;
        }
        //The key is found
        if (node.data == key) {
            return true;
        }
        //traverse the tree in search of the value 
        return search(node.left, key) || search(node.right, key);
    }

    public int sumNodes(Treenode node){
        if(node == null) return 0;
        //Node value plus the returning value of the left node and his childs plus the returning value of the right node and his childs
        return node.data + sumNodes(node.left) + sumNodes(node.right);
    }
}