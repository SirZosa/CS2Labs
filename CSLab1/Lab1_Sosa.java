import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Lab1_Sosa{
    public static void main(String[] args) {
        //Read file
        File myObj = new File("array4x5.txt");

        //Store the values into a 2D array
        int[][] myArr = get2DArr(myObj);

        //print elements of 2dArray
        for(int i = 0; i < myArr.length; i++){
            for(int j = 0;j< myArr[0].length; j++){
                System.out.print(myArr[i][j]+ " ");
            }
            System.out.println("");
        }
        
        //store the sum of each orbital into an array
        int[] sumArr = orbitalSum(myArr);

        //comparing the sums to see if they are equal
        int sameSum = 0;
        if(sumArr.length>1){
            for(int i =0; i< sumArr.length-1; i++){
                for(int j = i+1; j<sumArr.length; j++){
                    if(sumArr[i] == sumArr[j]){
                        sameSum++;
                    }
                }
            }   
        }

        System.out.println("");
        for(int i = 0; i< sumArr.length; i++){
            System.out.println("The sum of orbit " + i + " is: " + sumArr[i]);
        }
        System.out.println("There are " + sameSum + " pair of orbits with the same sum");
    }

    public static int[][] get2DArr(File arr){
        try{
            Scanner myReader = new Scanner(arr);
            
            //Store the number of lines in a variable
            int lines = numOfLines(arr);
            //Separate the elements in order to get the number of rows
            String[] dataArr = myReader.nextLine().replace(" ","").split(",");
            int rows = (dataArr.length);
            //restart the scanner
            myReader.close();
            myReader = new Scanner(arr);

            //initialize the 2d array
            int[][] arr2D = new int[lines][rows];

            //Nested "for" loops to store each element in their corresponding row and column
            for(int i=0; i < arr2D.length; i++){
                String[] lineNums = myReader.nextLine().replace(" ","").split(",");
                for(int j=0; j<rows; j++){
                    arr2D[i][j] = Integer.parseInt(lineNums[j]);
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

    public static int[] orbitalSum(int[][] myArr){
        int rows = myArr[0].length;
        int columns = myArr.length;

        //Detect if even or odd to determine how to proceed with the sum at the center of the array

        // Ternary notation: if rows is equals to columns and the remainder of dividing the rows by two is zero then evenPair is true else is false.
        boolean evenPair = rows == columns && rows % 2 == 0 ? true : false;

        // Ternary notation: if rows is equals to columns and the remainder of dividing the rows by two is not zero then oddPair is true else is false.
        boolean oddPair = rows == columns && rows % 2 != 0 ? true : false;

        // Ternary notation: if the remainder of dividing the min number between rows an colums is zero then noInnerOrbit is true else is false.
        boolean noInnerOrbit = Math.min(rows, columns) % 2 == 0 ? true : false;

        //Ternary notation: If evenPair or noInnerOrbit are true then number of orbit is equal to the min value betwwen colums and rows divided by two Else is the min value between columns and rows divided by 2 plus one.
        int numberOfOrbits = evenPair || noInnerOrbit ? Math.min(columns, rows)/2: Math.min(columns, rows)/2+1;
        //Variable to get track of the current orbit
        int orbitNum = 1;
        int[] orbitSum = new int[numberOfOrbits];


        while(orbitNum < numberOfOrbits+1){
            //Defining the limits of the current orbit
            int top = orbitNum -1;
            int bottom = columns - orbitNum;
            int left = orbitNum -1;
            int right = rows - orbitNum;
            int currentOrbitSum = 0;
            
            //Sum the single element at the center of the array on an oddPair array
            if(oddPair && top == numberOfOrbits-1){
                currentOrbitSum += myArr[top][top];
            } 
            //sum the four elements at the center of the array on an even pair array
            else if(evenPair && top == numberOfOrbits-1){
                currentOrbitSum += myArr[top][left];
                currentOrbitSum += myArr[top][right];
                currentOrbitSum += myArr[bottom][left];
                currentOrbitSum += myArr[bottom][right];
            }
            else{
                //for loop to sum all elements on the right and left part of the orbit from top to bottom
                for(int i = top; i< bottom + 1; i++){
                    currentOrbitSum += myArr[i][left];
                    currentOrbitSum += myArr[i][right];
                }
                // for loop to sum all the elements on the top and bottom part of the orbit from left to right
                for(int i = left; i< right + 1; i++){
                    currentOrbitSum += myArr[top][i];
                    currentOrbitSum += myArr[bottom][i];
                }

                //substract the duplicates made on the corners of the orbit
                currentOrbitSum -= myArr[top][left];
                currentOrbitSum -= myArr[top][right];
                currentOrbitSum -= myArr[bottom][left];
                currentOrbitSum -= myArr[bottom][right];
            }
            
            //store the sum into the array
            orbitSum[orbitNum-1] = currentOrbitSum;
            orbitNum++;
        }
        
        return orbitSum;

    }
}
