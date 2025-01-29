public class Lab8_Sosa{
    public static void main(String[] args){
        //MANUALLY CREATE YOUR TREE
        BinTree BiTree = new BinTree();
        //Deep 0
        BiTree.root = new Treenode(1);

        //Deep 1
        BiTree.root.left = new Treenode(2);
        BiTree.root.right = new Treenode(3);

        //Deep 2 left
        BiTree.root.left.left = new Treenode(4);
        BiTree.root.left.right = new Treenode(5);

        //Deep2 Right
        BiTree.root.right.right = new Treenode(6);

        //Deep3
        BiTree.root.right.right.left = new Treenode(7);
        BiTree.root.right.right.right = new Treenode(8);

        //CALL THE TRAVERSAL METHODS
        System.out.println("---------------Pre Order---------------");
        BiTree.printPre(BiTree.root);
        System.out.println("");
        System.out.println("---------------In Order---------------");
        BiTree.printIn(BiTree.root);
        System.out.println("");
        System.out.println("---------------Post Order---------------");
        BiTree.printPost(BiTree.root);
        System.out.println("");
        System.out.println("");

 
        int key =9; //insert your own key here
        System.out.println("The sum of the node data is: " + BiTree.sumNodes(BiTree.root));
        System.out.print("Searching for " + key + ": ");
        if(BiTree.search(BiTree.root, key)){
            System.out.println(key + " found in the tree!");
        }else{
            System.out.println(key + " not found in the tree... dang :(");
        }
    }
}