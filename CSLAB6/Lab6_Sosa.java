import java.util.Arrays;

public class Lab6_Sosa {

    // Problem 1 - while loop with nested for loop

    // Time complexity: O(n*log2(n))
    /*
     * Explanation: ...                                      number of operations
     * j = 1 ----------------------------------------------> 1
     * n = arr.length -------------------------------------> 1
     * while(j<n){ ----------------------------------------> log2(n) since j is double each iteration
            for (int k = 0; k < arr.length; k++){
                k=0 --------------------------------------->1-----|
                k < arr.length = k < n -------------------->n+1   |---  for loop total 4n + 2
                k++ = k=k=1-------------------------------->2n    |     multiply (4n + 2) * log2(n) since is repeating that many times
                System.out.print("* ") -------------------->n ----|     result 4n*log2(n) +2log2(n)
            }
            System.out.println("$ ") ---------------------->log2(n) 1 operation repeating log2(n) times
            j = j*2 --------------------------------------->2log(n) 2 operations repeating log2(n) times
        }
        System.out.println()------------------------------->1

        equation = (4n*log2(n) +2log2(n)) + 3log2(n) + log2(n)  + 1 + 1 + 1
        == 4n*log2(n) + 6log2(n) + 3
        eliminating constants = n*log2(n) + log2(n)
        taking the bigger value = n*log2(n)
     */
    public static void foo1(int[] arr) {
        int j = 1;
        int n = arr.length;
        while (j < n) {
            for (int k = 0; k < arr.length; k++) {
                System.out.print("* ");
            }
            System.out.println("$ ");
            j = j * 2;
        }
        System.out.println();
    }

    // Problem 2 - a for loop

    // Time complexity: O(log2(n))
    /*
     * Explanation: ...                                  number of operations
     * let's supose n = arr.length
     * for (int i = 1; i < n; i *= 2) {
     *      i = 1 --------------------------------------> 1
     *      i < n --------------------------------------> log2(n) + 1 since each loop i is doubled 
     *      i *= 2 ----> i = i* 2 ----- 2 operations ---> 2log2(n)
     *      System.out.print("# ")----------------------> log2(n)
     * }
     * System.out.println(); ---------------------------> 1
     * equation = 4log2(n) + 2 
     * take away constants = log2(n)
     */
    public static void foo2(int[] arr) {
        for (int i = 1; i < arr.length; i *= 2) {
            System.out.print("# ");
        }
        System.out.println();
    }

    // Problem 3 - two for loops

    // Time complexity: O(n)
    /*
     * Explanation: ...
     * let's suppose n = arr.length
     * for (int i = 1; i < n; i *= 2) from previous calculations --> 4log2(n) + 2
     * for (int j = 0; j < arr.length; j++) {
     *      j = 0 -------------------------------------------------> 1
     *      j < n -------------------------------------------------> n + 1 
     *      j++ --------------- j = j + 1 -------------------------> 2n      total 4n+2
     *      System.out.print("& ") --------------------------------> n
     * }
     * equation = 4n + 4log2(n) + 4
     * removing constants = n + log2(n)
     * taking the bigger value = n
     */
    public static void foo3(int[] arr) {
        for (int i = 1; i < arr.length; i *= 2) {
            System.out.print("@ ");
        }
        System.out.println();
        for (int j = 0; j < arr.length; j++) {
            System.out.print("& ");
        }
        System.out.println();

    }

    // Problem 4 - a for loop

    // Time complexity: O(n)
    /*
     * Explanation: ...
     * let's suppose n = arr.length
     * for (int j = 0; j < arr.length; j++) {
            System.out.print("% "); ---------------------------> from previous calculations for loop = 4n + 2
        }
        System.out.println();----------------------------------> 1
        equation = 4n + 2 + 1 = 4n + 3
        removing constants = n    
     */
    public static void foo4(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print("% ");
        }
        System.out.println();
    }

    // Problem 5 - two nested for loops looking for two numbers that sum up to
    // target

    // Time complexity: O(n^2)
    /*
     * Explanation: ...
     * let's suppose n = num.length
     * for (int i = 0; i < nums.length; i++) {
     *      i = 0 -----------------------------------------------------------------> 1---------|
     *      i < n -----------------------------------------------------------------> n + 1     |
     *      i++ ---------- i = i + 1 ------- two operations -----------------------> 2n        |---total = 5n + 2
     *      System.out.print(nums[i] + ":\t ") -- 1 operation ---------------------> n         |
     *      System.out.println(); ----- one operation -----------------------------> n --------|
     *      for (int j = i + 1; j < nums.length; j++) {
     *          j = i -------------------------------------------------------------> 1     -----|
     *          j < n -------------------------------------------------------------> n + 1      |
     *          j++ ----- j = j + 1 -----------------------------------------------> 2n         | multiply by n because is inside a for loop running n times
     *          System.out.print(nums[j] + ", "); ---------------------------------> n          | 2n + 2n + (n + 1) + n + 1 + 1 = 6n + 3
     *          if (nums[i] + nums[j] == target) -- 1 addition and 1 comparison ---> 2n         | (6n + 3) * n = 6n^2 +3n
     *          return new int[] { i, j } -- can only happen once -----------------> 1 ---------|
     *      }
     * }
     * equation = 6n^2 + 3n + 5n + 2 = 6n^2 +8n +2
     * removing constants = n^2 + n
     * bigger value = n^2
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ":\t ");
            for (int j = i + 1; j < nums.length; j++) {
                System.out.print(nums[j] + ", ");
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
            System.out.println();
        }
        return null;
    }

    // Problem 6 - two nested for loops sorting a given array.
    // It is being sorted by first going though the array and assuming the first
    // element is the min index, we then go through the array again skipping the
    // first element and comparing the elements. If it is less than the current
    // minimum element we make that element the current minimum. We then move the
    // minimum element to its correct position by storing element in the current
    // position, making the current position the correct minimum element, and then
    // doing the reverse for the element that was moved. Essentially swapping the
    // elements.

    // Best time complexity: O(n^2)
    // Worse time complexity: O(n^2)
    // Average time complexity: O(n^2)
    /*
     * Explanation for best: ...
     * Explanation for worst: ...
     * Explanation for average: ...
     * Best: Even if the array is already sorted the algorithm will still perform all of it's operations but the operation inside the if statement.
     * Average: Same as the best case but the operation inside the if statement will be excecuted some times.
     * Worst: Same as the Average case but the operation inside the if statement will perform every time.
     * In any case a nested for loop running n times will have a time complexity of O(n^2)
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + ":\t ");
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                System.out.print(arr[j] + ", ");
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
            System.out.println();
        }
    }

    // Problem 7 - utilize a nested for loop to traverse the array multiple times
    // while sorting

    // Time complexity: O(n^2)
    /*
     * Explanation: nested for loop, each loop running n times.
     */
    static void bubblesort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        //for loop to traverse the array
        for(int i = 0; i<n; i++){
            //for loop to traverse the array (n-1) to decrease the range.
            for(int j = 1; j<(n-i); j++){
                //comparing values, if criteria is meet swap values
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // Problem 8.1 - swap two characters from indices i1 and i2

    // Time complexity: O(1)
    /*
     * Explanation: 
     * temp = arr[i1] -------------> 1
     * arr[i1] = arr[i2]; ---------> 1
     * arr[i2] = temp; ------------> 1
     * equation = 3
     * This function have a time complexity of a constant meaning is O(1)
     */
    public static void swap(char[] arr, int i1, int i2) {
        char temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
        return; 
    }

    // Problem 8.2 - traverse array, swapping values to make combinations of indices
    // recursive call to traverse for each index final swap for backtracking so each
    // permutation is drawn from the original order of the array

    // Time complexity: O(n!)
    /*
     * Explanation: A permutation function like this consists of making all possible combinations of the given elements.
     * In this case an array of characters, the function will print every combination with the given letters.
     * Permutation formula:
     * PermutationFunction(n,r) = n! ÷ (n-r)!
     * Where:
     * n is the number of elements
     * r are the number of elements taken for the permutation.
     * If we only get the bigger value would be n!. In that case time complexity of this algorithm is O(n!)
     */
    public static void printPermutations(char[] arr, int index) {
        //base case, the index have reached the last element of the array
        if(index == arr.length){
            for(char letter : arr){
                System.out.print(letter);
            }
            System.out.print(" ");
            return;
        }
        //for loop to traverse the array
        for(int i = index; i < arr.length; i++){
            char temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            //recursive call doing the same but with the next letter in the array
            printPermutations(arr, index + 1);
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr1 = fillIntArray(20, 2);
        int[] arr2 = fillIntArray(10, 1);
        int[] arr3 = fillIntArray(40, 5);
        int[] arr4 = fillIntArray(7, -1);
        int[] arr5 = { 64, 25, 12, 22, 11 };
        int[] arr6 = { 64, 34, 25, 12, 22, 11, 90 };
        int[] arr7 = fillIntArray(9, -2);
        char[] arr8 = { 'a', 'b', 'c' };
        char[] arr9 = { 'z', 'y', 'x', 'w', 'v' };
        char[] arr10 = { 'a', 'b', 'c' };
        // twoSum testing
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 26;
        int[] nums2 = { 4, 5, 6, 7, 8, 9, 10, 12, 15, 17, 90 };
        int target2 = 107;

        // Problem 1: foo1
        System.out.println("Testing foo1:");
        System.out.println("Input: " + Arrays.toString(arr1));
        foo1(arr1);
        System.out.println("Input: " + Arrays.toString(arr4));
        foo1(arr4);
        System.out.println();

        // Problem 2: foo2
        System.out.println("Testing foo2:");
        System.out.println("Input: " + Arrays.toString(arr1));
        foo2(arr1);
        System.out.println();
        System.out.println("Input: " + Arrays.toString(arr4));
        foo2(arr4);
        System.out.println();

        // Problem 3: foo3
        System.out.println("Testing foo3:");
        System.out.println("Input: " + Arrays.toString(arr3));
        foo3(arr3);
        System.out.println();
        System.out.println("Input: " + Arrays.toString(arr2));
        foo3(arr2);
        System.out.println();

        // Problem 4: foo4
        System.out.println("Testing foo4:");
        System.out.println("Input: " + Arrays.toString(arr5));
        foo4(arr5);
        System.out.println();
        System.out.println("Input: " + Arrays.toString(arr1));
        foo4(arr1);
        System.out.println();

        // Problem 5: twoSum
        System.out.println("Testing twoSum:");
        System.out.println("Input: " + Arrays.toString(nums1) + ", Target: " +
                target1);
        System.out.println("Output: " + Arrays.toString(twoSum(nums1, target1)));
        System.out.println();
        System.out.println("Input: " + Arrays.toString(nums2) + ", Target: " +
                target2);
        System.out.println("Output: " + Arrays.toString(twoSum(nums2, target2)));
        System.out.println();

        // Problem 6: selectionSort
        System.out.println("Testing selectionSort:");
        System.out.println("Input: " + Arrays.toString(arr5));
        selectionSort(arr5);
        System.out.println("Output: " + Arrays.toString(arr5));
        System.out.println();
        System.out.println("Input: " + Arrays.toString(arr4));
        selectionSort(arr4);
        System.out.println("Output: " + Arrays.toString(arr4));
        System.out.println();

        // Problem 7: bubbleSort
        System.out.println("Testing bubbleSort:");
        System.out.println("Input: " + Arrays.toString(arr6));
        bubblesort(arr6);
        System.out.println("Output: " + Arrays.toString(arr6));
        System.out.println();
        System.out.println("Input: " + Arrays.toString(arr7));
        bubblesort(arr7);
        System.out.println("Output: " + Arrays.toString(arr7));
        System.out.println();

        // Problem 8.1: swap
        System.out.println("Testing swap:");
        System.out.println("Input: " + Arrays.toString(arr10) + ", Index1: " + 0 + ", Index2: " + 2);
        swap(arr10, 0, 2);
        System.out.println("Output: " + Arrays.toString(arr10));
        System.out.println();
        System.out.println("Input: " + Arrays.toString(arr9) + ", Index1: " + 1 + ", Index2: " + 4);
        swap(arr9, 1, 4);
        System.out.println("Output: " + Arrays.toString(arr9));
        System.out.println();

        // Problem 8.2: printPermutations
        System.out.println("Testing printPermutations:");
        System.out.println("Input: " + Arrays.toString(arr8));
        printPermutations(arr8, 0);
        System.out.println();
        System.out.println("Input: " + Arrays.toString(arr9));
        printPermutations(arr9, 0);
        System.out.println();
    }

    /* ------------------ DO NOT TOUCH CODE ------------------ */

    public static int[] fillIntArray(int size, int increments) {
        int[] newArr = new int[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = i * increments;
        }
        return newArr;
    }
}
