import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lab5_Sosa{
    //Task 1
    public static int[] createArr(String filePath){
        //read file
        File document = new File(filePath);
        //count number of lines to determine the length of the array
        int numOfLines = numOfLines(document);
        //initialize array
        int[] numberArray = new int[numOfLines];
        try{
            Scanner myScanner = new Scanner(document);
            //for loop to store numbers into the array
            for(int i = 0; i<numberArray.length; i++){
                numberArray[i] = Integer.parseInt(myScanner.nextLine());
            }
            myScanner.close();
            return numberArray;
        }
        //error handling
        catch(FileNotFoundException e){
        System.out.println("File not found");
        e.printStackTrace();
        }   
        return null;
    }

    public static void printArray(int[] arr){
        System.out.println("--------------------Printing Array ----------------------");
        if(arr != null){
            //for loop to print all numbers of the array
            for(int num : arr){
                System.out.print(num + " ");
            }
        }
        else{
            System.out.println("No numbers in the array");
        }
        System.out.println("");
        System.out.println("--------------------------------------------------------");
    }

    //Task 2
    public static int linearSearch(int[] arr, int searchVal){
        //for loop to visit each item in the array
        for(int i = 0; i<arr.length; i++){
            //compare the value of the array with the given number, if they matched return the index
            if(arr[i] == searchVal) return i;
        }
        //if not found return -9999
        return -9999;
    }

    //Task 3
    public static int binarySearch(int[] arr, int searchVal){
        //setting up variables
        //low = the lowest point in the array, initially at 0
        int low = 0;
        //high = last point in the array, initially at the last item in the array
        int high = arr.length-1;
        int mid;
        while ((high >= low)){
            //mid = the center point
            mid = (low + high)/2;
            //if the item in the array is equal to the given number to search return mid (the index)
            if(searchVal == arr[mid]) return mid;
            //If the number to search is lower than the value at the mid point
            if(searchVal<arr[mid]){
                high = mid -1;
            }
            //if the value to search is greater than the value at the mid point
            else{
                low = mid +1;
            }
            //repeat until the midpoint is equal to the value to search
        }
        //if not found return -9999
        return -9999;
    }

    //main
    public static void main(String[] args){
        //creating and printing arrays
        int[] small = createArr("smallArray.txt");
        int[] medium = createArr("mediumArray.txt");
        int[] large = createArr("largeArray.txt");
        printArray(small);
        printArray(medium);
        printArray(large);

        //number to find
        search(small, medium, large);
    }

    public static int numOfLines(File document){
        //count the number of lines on the txt file
        try{
            Scanner lineScanner = new Scanner(document);
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
            scanner.close();
            return num;
        } catch (NumberFormatException e) {
            // code to handle error
            //if not a number call the function again until a valid number is entered
            return numberScanner(true);
        }
    }

    public static void search(int[] small, int[] medium, int[] large) {
        System.out.println("Which number would you like to search?");
        // number to find
        int num = numberScanner(false);
        printResults("small", "linear", linearSearch(small, num));
        printResults("medium", "linear", linearSearch(medium, num));
        printResults("large", "linear", linearSearch(large, num));
        printResults("small", "binary", binarySearch(small, num));
        printResults("medium", "binary", binarySearch(medium, num));
        printResults("large", "binary", binarySearch(large, num));
    }

/*------------------------DO NOT TOUCH------------------------*/
/*----This method will print the results of your searches---- */
public static void printResults(String name, String searchType, int index){
    System.out.println("----------------------------------------------");
    if(index == -9999){
        System.out.println("The " + searchType + " search failed to locate the value in the " + name + " array... :(");
    }else{
        System.out.println("The " + searchType + " search located the value in the " + name + " array at index " + index + "!");
    }
    System.out.println("----------------------------------------------");
    System.out.println("");
}
}//end class