/* CS2401
 * Files needed to complete Lab 3:
 * 	- Node.java
 * 	- LinkedList.java
 *  - Lab3_Lastname.java --- the java file of your program. 
 * 
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Lab3_Sosa{
    /**
     * Make a method that takes in a file name and returns a 2D String array
     * containing the value of every row in the "itemList.csv"
     * 
     */
    public static String[][] scanItems(){
        //read file
        File data = new File("itemList.csv");
        //Scan number of lines on file
        int lines = numOfLines(data);
        try{
            //start scanner
            Scanner myReader = new Scanner(data);
            //Separate the elements in order to get the number of rows
            String[] dataArr = myReader.nextLine().split(",");
            int rows = (dataArr.length);
            //restart the scanner
            myReader.close();
            myReader = new Scanner(data);

            //initialize the 2d array
            String[][] arr2D = new String[lines-1][rows];
            //Skip first line
            myReader.nextLine();
            //Nested "for" loops to store each element in their corresponding row and column
            for(int i=0; i < arr2D.length; i++){
                String[] lineNums = myReader.nextLine().split(",");
                for(int j=0; j<rows; j++){
                    arr2D[i][j] = lineNums[j];
                }
            }
            myReader.close();
            return arr2D;
        } catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
            return null;
        }
    }

    public static int numOfLines(File arr){
        //count the number of lines on the txt file
        try{
            Scanner lineScanner = new Scanner(arr);
            int lines = 0;
            while (lineScanner.hasNextLine()) {
                lineScanner.nextLine();
                lines++;
            }
            lineScanner.close();
            return lines;
        } catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
            return 0;
        }
    }
    
    public static void main(String[] args) throws Exception{
        //Read CSV file
        String[][] items = scanItems();
        //scanner for user input
        Scanner scan = new Scanner(System.in);
        // Define your inventory
        InventoryLL inventory = new InventoryLL();
        while(true){
            System.out.println("");
            System.out.println("_______________________________________________");
            System.out.println("__        __   _                ");                           
            System.out.println("\\ \\      / /__| | ___ ___  _ __ ___   ___ ");
            System.out.println(" \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\");
            System.out.println("  \\ V  V /  __/ | (_| (_) | | | | | |  __/");
            System.out.println("   \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|");
            System.out.println("_______________________________________________");
            System.out.println("");
            System.out.println("           Welcome to SHOP_NAME              ");
            System.out.println("");
            System.out.println("Please select one of the following options:");
            System.out.println("1) View shop");
            System.out.println("2) View inventory");
            System.out.println("3) Sell item");
            System.out.println("4) Buy item");
            System.out.println("5) View item stats");
            System.out.println("6) Exit");
            int num = 0;

            //hadle error if user's input is not valid.
            try {
                num = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                // code to handle error
                num = 0;
            }
            
            //     // user presses 1 view shop
        if(num == 1){
            displayShop(items);
        }
        //     // user presses 2 view inventory
        else if(num ==2){
            System.out.println("------------------------------");
            System.out.println("Your current party is: ");
            inventory.displayItems();
            System.out.println("");
            System.out.println("---------------------------------");
        }
        //     // user pressed 3: sell item
        else if(num == 3){
            System.out.println("------------------------------");
            System.out.println("Which item do you want to sell? ");
            //Waiting for user to write the input to pass it as an argument to the removeItem method
            String itemName = scan.nextLine();
            String[] removedItem = inventory.removeItem(itemName);
            //If item removed
            if(removedItem != null){
                System.out.println(removedItem[1]);
                System.out.println("Thank you for selling me the " + removedItem[1] + ", I'll sell it for a higher price!");
            }
            //no item foud
            else{
                System.out.println("Don't waste my time trying to sell me something that you don't own >:C");
            }
            System.out.println("---------------------------------");
        }
        //     // user presses 4 buy item 
        else if(num == 4){
            if(InventoryLL.size == 5){
                System.out.println("------------------------------");
                System.out.println("You have many items already! Get rid of an item before I can sell you another one!");
                System.out.println("------------------------------");
            }
            else{
                System.out.println("------------------------------");
                System.out.println("Which item do you want to Buy? ");
                //Wait for user input
                String itemName = scan.nextLine();
                //Helper variable
                boolean isAdded = false;
                for(String[] item : items){
                    //if item is finded add to inventory and break the loop
                    if(itemName.equals(item[1])){
                        isAdded = true;
                        inventory.addToInventory(item);
                        System.out.println("Thank you for buying the " + item[1] + " now I can buy some food :D");
                        break;
                    }
                }
                //Item not found
                if(!isAdded){
                    System.out.println("Sorry, I don't have that item for you :(");
                }
                System.out.println("------------------------------");
            }
        }
        //     // user presses 5
        else if(num == 5){
            System.out.println("------------------------------");
            System.out.println("Which item do you want to see? ");
            //wait for user input
            int index = 0;
            try {
                // try to parse the string to an integer
                index = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                // code to handle error
                System.out.println("not a number");
                index = 99999;
            }
            String[] itemOnIndex = inventory.getFromInventory(index);
            //item not found
            if(itemOnIndex == null){
                System.out.println("Sorry but you don't have that many items!! or maybe negative items?");
            }
            //item found
            else{
                System.out.println(" Rarity        Magical Ability                                          HP     Cost");
                System.out.println("------------------------------------------------------------------------------------------");
                System.err.println(" " + itemOnIndex[2] + "           " + itemOnIndex[3] + "                                              " + itemOnIndex[4] + "      " + itemOnIndex[5]);
            }
            System.out.println("------------------------------");
        }
        //     // user presses 6 exit
            else if(num == 6){
                System.out.println("------------------------------");
                System.out.println("Thank you for your visit! Come back again soon!");
                System.out.println("------------------------------");
                scan.close();
                return;
            }
            else{
                System.out.println("Sorry, I didn't understand, can you say it again?");
            }
        // }
    }
}

    /*
     * 
     * 
     * DO NOT CHANGE, DISPLAYS SHOP
     * 
     * 
     * 
     */

    public static void displayShop(String[][] shop) {
    // Define column widths for each column (adjust these values to fit your data)
    int nameWidth = 32;
    int rarityWidth = 17;
    int abilityWidth = 82;
    int hpWidth = 8;
    int costWidth = 7;
    
    System.out.println();
    // Print the top border
    System.out.println("+" + "-".repeat(nameWidth) + "+" + "-".repeat(rarityWidth) + "+" 
                         + "-".repeat(abilityWidth) + "+" + "-".repeat(hpWidth) + "+" + "-".repeat(costWidth) + "+");

    // Print the header row
    System.out.printf("| %-30s | %-15s | %-80s | %-5s | %-5s |%n", 
                      "Name", "Rarity", "Magical Abilities", "HP", "Cost");

    // Print the separator after the header
    System.out.println("+" + "-".repeat(nameWidth) + "+" + "-".repeat(rarityWidth) + "+" 
                         + "-".repeat(abilityWidth) + "+" + "-".repeat(hpWidth) + "+" + "-".repeat(costWidth) + "+");

    // Loop through the 2D array and print each row
    for (int i = 0; i < shop.length; i++) {
        if(shop[i][1] == null){
            i++;
        }
        else {  // Ensure the shop row is not null
            System.out.printf("| %-30s | %-15s | %-80s | %-5s | %-5s |%n", 
                              shop[i][1] ,    // Name
                              shop[i][2] ,    // Rarity
                              shop[i][3] ,    // Magical Abilities
                              shop[i][4] ,    // HP
                              shop[i][5]      // Cost
            );
        }
    }

    // Print the bottom border
    System.out.println("+" + "-".repeat(nameWidth) + "+" + "-".repeat(rarityWidth) + "+" 
                         + "-".repeat(abilityWidth) + "+" + "-".repeat(hpWidth) + "+" + "-".repeat(costWidth) + "+");
    System.out.println();
    }
     /*
     * 
     * 
     * DO NOT CHANGE, DISPLAYS SHOP
     * 
     * 
     * 
     */

}






