import java.util.Scanner;

public class Lab9_Sosa {
    public static void main(String[] args) {
        //Get the questions of the file into an array.
        Question[] questions = QuestionLoader.getQuestions("computer_science_questions.csv");

        //create a dungeon
        Dungeon myDungeon = new Dungeon(questions);
        int lives = 3;

        //Print the dungeon in traverse order
        System.out.println("Want to traverse the dungeon in preOrder? (y/n)");
        Scanner traverseInput = new Scanner(System.in);
        String input = traverseInput.nextLine();
        if(input.equals("y")){
            myDungeon.printPre(myDungeon.getRoot());
        }

        //greet the user
        System.out.println("Welcome user, are you good enough to enter and leave this dungeon alive???");
        System.out.println("You have " + lives + " lives.");
        System.out.println("");

        //while loop that runs until the player is dead or exits the dungeon
        while (myDungeon.root != null) {
            //Display the question and options
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println(myDungeon.root.description + " Deep Level: " + myDungeon.root.deepLevel);
            myDungeon.root.question.displayInformation();
            System.out.println("Which answer is the correct one?... one, two, three or four?... (1-4)");
            System.out.println("");
            //get user input
            int answer = numberScanner(false);

            //if the user get the correct answer
            if(myDungeon.root.question.isCorrect(answer)){
                System.out.println("Very well... You answered correctly... Now... chose a path... left or right?");
                System.out.println("(l - r)");
                System.out.println("");

                //get user input
                String path = pathScanner(false);
                if(path.equals("l")){
                    //Current room becomes the room at the left
                    myDungeon.root = myDungeon.root.left;
                    if(myDungeon.root == null){
                        //there is no room so the player escaped the dungeon
                        System.out.println("You found the exit to the dungeon!!!");
                        return;
                    }
                }
                else{
                    //Current room becomes the room at the right
                    myDungeon.root = myDungeon.root.right;
                    if(myDungeon.root == null){
                        //there is no room so the player escaped the dungeon
                        System.out.println("You found the exit to the dungeon!!!");
                        return;
                    }
                }
            }
            else{
                //wrong answer selected
                System.out.println("WRONG ANSWER!!!!");
                //player loosses one live
                lives--;
                if(lives == 0){
                    //if player have no more lives
                    System.out.println("You're dead!!! STUDY MOREEEE!");
                    return;
                }
                System.out.println("You have " + lives + " lives left.");
                System.out.println("You're still alive, so, chose a path... left or right?");
                System.out.println("(l - r)");
                System.out.println("");
                String path = pathScanner(false);
                if(path.equals("l")){
                    myDungeon.root = myDungeon.root.left;
                    if(myDungeon.root == null){
                        System.out.println("You found the exit to the dungeon!!!");
                        return;
                    }
                }
                else{
                    myDungeon.root = myDungeon.root.right;
                    if(myDungeon.root == null){
                        System.out.println("You found the exit to the dungeon!!!");
                        return;
                    }
                }
            }
        }
        traverseInput.close();
        System.out.println("You escaped the dungeon!!! how smart");
        return;
    }

    public static int numberScanner(boolean notNumber){
        //Bolean for recursive method
        //if notNumber is true
        if(notNumber == true){
            System.out.println("That's not a number! Try again");
        }
        int num;
        Scanner scanner = new Scanner(System.in);
        try {
            //if scanned line is a number return the number
            num = Integer.parseInt(scanner.nextLine());
            
            return num;
        } catch (NumberFormatException e) {
            // code to handle error
            //if not a number call the function again until a valid number is entered
            return numberScanner(true);
        }
    }

    public static String pathScanner(boolean notPath){
        //Bolean for recursive method
        //if notNumber is true
        if(notPath == true){
            System.out.println("That's not a path! Try again");
        }
        String path;
        Scanner scannerPath = new Scanner(System.in);
        try {
            //if scanned line is a number return the number
            path = scannerPath.nextLine();
            if(path.equals("l") || path.equals("r")){
                return path;
            }
            return pathScanner(true);
        } catch (NumberFormatException e) {
            // code to handle error
            return pathScanner(true);
        }
    }
}
