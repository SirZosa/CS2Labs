import java.util.Random;

public class Dungeon {
    //atribute
    Room root;

    Dungeon(){}
    //constructor
    public Dungeon(Question[] questions){
        createDungeon(questions);
    }

    public Room getRoot(){
        return root;
    }

    //print dungeon on preOrder traversal
    public void printPre(Room node){
        //PreOrder is node, left and right
        if(node == null) return;
    
        node.question.displayInformation();
        System.out.println("");
        printPre(node.left);
        printPre(node.right);
    }


    //method to create a dungen in a binary tree randomly balanced given an array of questions
    public Room createDungeon(Question[] questions){
        //index i to get track of the question's array
        int i = 0;
        root = null;

        //while there are questions left on the array
        while(i<questions.length){
            //first question is the root
            if(root == null){
                root = new Room("You're going to loose!", questions[i]);
                root.deepLevel = 0;
            }
            else{
                //method to insert the question on the left or right child of the current node
                randomSide(root, questions[i], 0);
            }
            //go to the next question
            i++;
        }
        return root;
    }
    
    private void randomSide(Room root, Question question, int deep){
        //random number between 0 and 1
        int randomNum = new Random().nextInt(2);
        int levelDeep = deep +1;
        if(root == null) return;
        //if random number is 0 inspect the left child
        else if(randomNum == 0){
            //if the left child is null then introduce the question there
            if(root.left == null){
                root.left = new Room("You're going to loose!", question);
                root.left.deepLevel = levelDeep;
                return;
            }
            else{
                //recursive method to decide in which side of the left child is going to be the question
                randomSide(root.left, question, levelDeep);
            }
        }
        //if random number is 1 inpect the right child
        else{
            if(root.right == null){
                root.right = new Room("You're going to loose!", question);
                root.right.deepLevel = levelDeep;
                return;
            }
            else{
                randomSide(root.right, question, levelDeep);
            }
        }
    }
}
