// Omar Alexis Sosa
//[CS2401]


import java.util.Random;

class Lab7_Answers {
  public static void main(String[] args) {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * DON'T TOUCH 
     * 
    */
    ////////////////////////////////////////////////////////////////////////////////////////////////
    Concert[] concerts = createConcertArray();
    System.out.println("-----------------------------------------------------");
    System.out.println("The number of concerts in the array: " + concerts.length);
    System.out.println("Printing the Concerts information [Not sorted]");
  
    showConcertInfo(concerts);
    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Selection Sort based on duration");
    System.out.println("-----------------------------------------------------");
    long start = System.nanoTime();
    SelectionSortByDuration(concerts);
    long end = System.nanoTime();
    long timeSelectionSortDuration = (end - start);
    System.out.println("Printing the sorted array.....");
 
    showConcertInfo(concerts);

    //Restoring to initial state

    concerts = createConcertArray();

    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Selection Sort based on capacity");
    concerts = createConcertArray();
    System.out.println("-----------------------------------------------------");
    start = System.nanoTime();
    SelectionSortByCapacity(concerts);
    end = System.nanoTime();
    long timeSelectionSortCapacity = (end - start);
    System.out.println("Printing the sorted array.....");
 
    showConcertInfo(concerts);

    // Restoring the array to its initial state
    concerts = createConcertArray();

    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Selection Sort based on artist");
    concerts = createConcertArray();
    System.out.println("-----------------------------------------------------");
    start = System.nanoTime();
    SelectionSortByArtist(concerts);
    end = System.nanoTime();
    long timeSelectionSortArtist = (end - start);
    System.out.println("Printing the sorted array.....");
 
    showConcertInfo(concerts);

    // Restoring the array to its initial state
    concerts = createConcertArray();


    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Merge Sort based on duration");
    concerts = createConcertArray();

    System.out.println("-----------------------------------------------------");
    start = 0;
    end = 0;
    start = System.nanoTime();
    MergeSortByDuration(concerts);
    end = System.nanoTime();
    long timeMergeSortDuration = (end - start);
    System.out.println("Printing the sorted array.....");

    showConcertInfo(concerts);

    // Restoring the array to its initial state
    concerts = createConcertArray();

    System.out.println("-----------------------------------------------------");

    
    System.out.println("Sorting the array using Merge Sort based on capacity");
    concerts = createConcertArray();
    System.out.println("-----------------------------------------------------");
    start = 0;
    end = 0;
    start = System.nanoTime();
    MergeSortByCapacity(concerts);
    end = System.nanoTime();
    long timeMergeSortCapacity = (end - start);
    System.out.println("Printing the sorted array.....");

    showConcertInfo(concerts);

    System.out.println("-----------------------------------------------------");
    System.out.println("Sorting the array using Insertion Sort based on capacity");
    concerts = createConcertArray();
    System.out.println("-----------------------------------------------------");
    start = System.nanoTime();
    InsertionSortByCapacity(concerts);
    end = System.nanoTime();
    long timeInsertionSortCapacity = (end - start);
    System.out.println("Printing the sorted array.....");

    showConcertInfo(concerts);

    // Restoring the array to its initial state
    concerts = createConcertArray();

    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Insertion Sort based on duration");
    concerts = createConcertArray();
    System.out.println("-----------------------------------------------------");
    start = System.nanoTime();
    InsertionSortByDuration(concerts);
    end = System.nanoTime();
    long timeInsertionSortDuration = (end - start);
    System.out.println("Printing the sorted array.....");
   
    showConcertInfo(concerts);

    // Restoring the array to its initial state
    concerts = createConcertArray();


    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Insertion Sort based on artist");
    concerts = createConcertArray();
    System.out.println("-----------------------------------------------------");
    start = System.nanoTime();
    InsertionSortByArtist(concerts);
    end = System.nanoTime();
    long timeInsertionSortArtist = (end - start);
    System.out.println("Printing the sorted array.....");
   
    showConcertInfo(concerts);

    // Restoring the array to its initial state
    concerts = createConcertArray();
    

    System.out.println("-----------------------------------------------------");
    System.out.println("************ Runtime Statistics **************");
    System.out.println();
    System.out.println("Selection sort - duration: " + timeSelectionSortDuration + " ns");
    System.out.println("Selection sort - capacity: " + timeSelectionSortCapacity + " ns");
    System.out.println("Selection sort - artist: " + timeSelectionSortArtist + " ns");
    System.out.println();
    System.out.println("Merge sort - duration: " + timeMergeSortDuration + " ns");
    System.out.println("Merge sort - capacity: " + timeMergeSortCapacity + " ns");
    System.out.println();
    System.out.println("Insertion sort - duration: " + timeInsertionSortDuration + " ns");
    System.out.println("Insertion sort - capacity: " + timeInsertionSortCapacity + " ns");
    System.out.println("Insertion sort - artist: " + timeInsertionSortArtist + " ns");
    System.out.println();
    System.out.println();
    System.out.println("**********************************************");
    System.out.println("-----------------------------------------------------");
    System.out.println();
  }
  ////////////////////////////////////////////////////////////////////////////////////////////////
  /*
    * DON'T TOUCH 
    * 
  */
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Change the body of this method to arrange the Concert
   * objects in ascending order of duration.
   * The method must use Selection Sort.
   * Do NOT change the method header.
   * Consider method overloading.
   * 
   * @param allConcerts
   */

    public static void SelectionSortByDuration(Concert[] allConcerts) {
      //Outer for loop to traverse all elements minus one to avoid array overflow because of the inner loop
      for(int i =0; i< allConcerts.length-1; i++){
        //minIndex is the min value staring at i
        int minIndex = i;
        //inner for loop for comparison
        for(int j = i+1; j<allConcerts.length;j++){
          //if statement for comparison
          if(allConcerts[minIndex].getDuration()>allConcerts[j].getDuration()){
            //if the duration of concert at index minIndex is greater than the duration of concert at j index then swap
            minIndex = j;
          }
        }
        
        //If 'i' is not the minValue make the swap
        if(minIndex != i){
          Concert temp = allConcerts[i];
          allConcerts[i] = allConcerts[minIndex];
          allConcerts[minIndex] = temp;
        }
        
      }
    }


  public static void SelectionSortByCapacity(Concert[] allConcerts) {
    for(int i =0; i< allConcerts.length-1; i++){
      int minIndex = i;
      for(int j = i+1; j<allConcerts.length;j++){
        //same explanation but with .getCapacity()
        if(allConcerts[minIndex].getCapacity()>allConcerts[j].getCapacity()){
          minIndex = j;
        }
      }
      
      if(minIndex != i){
        Concert temp = allConcerts[i];
        allConcerts[i] = allConcerts[minIndex];
        allConcerts[minIndex] = temp;
      }
      
    }

  }

  public static void SelectionSortByArtist(Concert[] allConcerts) {
    for(int i =0; i< allConcerts.length-1; i++){
      int minIndex = i;
      for(int j = i+1; j<allConcerts.length;j++){
        //The only difference with the other two sorting options is that here we are comparing strings and for that we use 'compareTo()'
        //compareTo() function returns a number > 0, 0 or a number < 0, depending if is "greater", "equal" or "smaller" to the string you are comparing to.
        if(allConcerts[minIndex].getArtist().compareTo(allConcerts[j].getArtist()) > 0){
          minIndex = j;
        }
      }
      
      if(minIndex != i){
        Concert temp = allConcerts[i];
        allConcerts[i] = allConcerts[minIndex];
        allConcerts[minIndex] = temp;
      }
      
    }
  }





  /**
   * Change the body of this method to arrange the Concert
   * objects in ascending order of duration.
   * The method must use Merge Sort.
   * Do NOT change the method header.
   * Consider method overloading.
   * 
   * @param allConcerts
   */

    public static void MergeSortByDuration(Concert[] allConcerts) {
      //call the merge sort algorithm
      mergeSort(allConcerts, 0, allConcerts.length-1);
    }

  static void mergeSort(Concert[] allConcerts, int left, int right) {
    //recursive method, if statement will always be true until there is only one element on the array
    if(left < right){
      int middlePoint = left + (right -left)/2;

      //separate array into 2 halfes
      //First half from the beggining to the middle
      mergeSort(allConcerts, left, middlePoint);

      //Second half from the middle to the end
      mergeSort(allConcerts, middlePoint+1, right);

      //start merging the halfes
      merge(allConcerts, left, middlePoint, right);
    }
  }

  static void merge(Concert[] allConcerts, int left, int middle, int right) {
    //getting the two temporary arrays length
    int subArraySize1 = middle - left + 1;
    int subArraySize2 = right - middle;

    //initializing the tow temporary arrays
    Concert[] leftArray = new Concert[subArraySize1];
    Concert[] rightArray = new Concert[subArraySize2];


    //copy elements from array into the temporary arrays
    //from beggining to middle
    for(int i = 0; i< subArraySize1; i++){
      leftArray[i] = allConcerts[left + i];
    }
    //from middle to end
    for(int j = 0; j< subArraySize2; j++){
      rightArray[j] = allConcerts[middle + 1 + j];
    }

    //i:start of leftArray, j:start of rightArray, k:start index of unsorted originalArray
    int i = 0;
    int j = 0;
    int k = left;

    //while loop that runs until one of the arrays get full
    while(i<subArraySize1 && j < subArraySize2){
      //comparing between the two temporary arrays, whichever is lower goes to the k index of the original
      if(leftArray[i].getDuration() <= rightArray[j].getDuration()){
        allConcerts[k] = leftArray[i];
        i++;
      }
      else{
        allConcerts[k] = rightArray[j];
        j++;
      }
      k++;
    }


    //If one of the two arrays got to the end, then the remaining elements of the other array are introduced into the original with these two while loops
    while(i< subArraySize1){
      allConcerts[k] = leftArray[i];
      i++;
      k++;
    }

    while(j<subArraySize2){
      allConcerts[k] = rightArray[j];
      j++;
      k++;
    }
  }





  /**
   * Change the body of this method to arrange the Concert
   * objects in ascending order of capacity.
   * The method must use Merge Sort.
   * Do NOT change the method header.
   * 
   * @param allConcerts
   */
  public static void MergeSortByCapacity(Concert[] allConcerts) {
    mergeSortByCapacity(allConcerts, 0, allConcerts.length - 1);
  }

  static void mergeSortByCapacity(Concert[] allConcerts, int left, int right) {
    if(left < right){
      int middlePoint = left + (right -left)/2;

      mergeSortByCapacity(allConcerts, left, middlePoint);
      mergeSortByCapacity(allConcerts, middlePoint+1, right);
      mergeByCapacity(allConcerts, left, middlePoint, right);
    }
  }

  static void mergeByCapacity(Concert[] allConcerts, int left, int middle, int right) {
    int subArraySize1 = middle - left + 1;
    int subArraySize2 = right - middle;

    Concert[] leftArray = new Concert[subArraySize1];
    Concert[] rightArray = new Concert[subArraySize2];

    for(int i = 0; i< subArraySize1; i++){
      leftArray[i] = allConcerts[left + i];
    }
    for(int j = 0; j< subArraySize2; j++){
      rightArray[j] = allConcerts[middle + 1 + j];
    }

    int i = 0;
    int j = 0;
    int k = left;

    while(i<subArraySize1 && j < subArraySize2){
      if(leftArray[i].getCapacity() <= rightArray[j].getCapacity()){
        allConcerts[k] = leftArray[i];
        i++;
      }
      else{
        allConcerts[k] = rightArray[j];
        j++;
      }
      k++;
    }

    while(i< subArraySize1){
      allConcerts[k] = leftArray[i];
      i++;
      k++;
    }

    while(j<subArraySize2){
      allConcerts[k] = rightArray[j];
      j++;
      k++;
    }
  }

   /**
   * Change the body of this method to arrange the Concert
   * objects in ascending order of capacity.
   * The method must use Insertion Sort.
   * Do NOT change the method header.
   * 
   * @param allConcerts
   */
  public static void InsertionSortByDuration(Concert[] allConcerts) {
    //i and j are variables to traverse the array
    int i;
    int j;
    //k is the element to insert
    Concert key;
    for(i = 1; i< allConcerts.length; i++){
      key = allConcerts[i];
      //checks if the value in front of the array index at j is lower 
      for(j = i-1; (j>=0) && (allConcerts[j].getDuration() > key.getDuration()); j--){
        //if it's lower make the swap and check again
        allConcerts[j+1] = allConcerts[j];
      }
      //insert the element
      allConcerts[j+1] = key;
    }
  }

  public static void InsertionSortByCapacity(Concert[] allConcerts) {
    int i;
    int j;
    Concert key;
    for(i = 1; i< allConcerts.length; i++){
      key = allConcerts[i];
      for(j = i-1; (j>=0) && (allConcerts[j].getCapacity() > key.getCapacity()); j--){
        allConcerts[j+1] = allConcerts[j];
      }
      allConcerts[j+1] = key;
    }
  }

  public static void InsertionSortByArtist(Concert[] allConcerts) {
    int i;
    int j;
    Concert key;
    for(i = 1; i< allConcerts.length; i++){
      key = allConcerts[i];
      for(j = i-1; (j>=0) && (allConcerts[j].getArtist().compareTo(key.getArtist()) > 0); j--){
        allConcerts[j+1] = allConcerts[j];
      }
      allConcerts[j+1] = key;
    }
  }


  ////////////////////////////////////////////////////////////////////////////////////////////////
  /*
  * DON'T TOUCH 
  * 
  */
  ////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * Display all the variables of a
   * Airplane object in the same sequence
   * they appear in the parameter array.
   * 
   * @param allConcerts
   */

   static void  showConcertInfo(Concert[] allConcerts) {
    int idWidth = 7;
    int artistWidth = 22;
    int capacityWidth = 10;
    int startTimeWidth = 12;
    int endTimeWidth = 10;
    int durWidth = 10;
				
		System.out.println();
		// Print the top border
	 	System.out.println("+" + "-".repeat(idWidth) + "+" + "-".repeat(artistWidth) + "+" 
		+ "-".repeat(capacityWidth) + "+" + "-".repeat(startTimeWidth) + "+" + "-".repeat(endTimeWidth) + "+"
		+ "-".repeat(durWidth) + "+");
    //Print header
    System.out.printf("| %-5s | %-20s | %-8s | %-8s | %-8s | %-8s |%n", 
		 	"ID", "Artist", "Capacity", "Start Time", "End Time", "Duration");
    System.out.println("+" + "-".repeat(idWidth) + "+" + "-".repeat(artistWidth) + "+" 
    + "-".repeat(capacityWidth) + "+" + "-".repeat(startTimeWidth) + "+" + "-".repeat(endTimeWidth) + "+"
    + "-".repeat(durWidth) + "+");
    //Print concerts
    for (int i = 0; i < allConcerts.length; i++) {
      System.out.println(allConcerts[i].toString());
    }
    //Prints bottom border
    System.out.println("+" + "-".repeat(idWidth) + "+" + "-".repeat(artistWidth) + "+" 
    + "-".repeat(capacityWidth) + "+" + "-".repeat(startTimeWidth) + "+" + "-".repeat(endTimeWidth) + "+"
    + "-".repeat(durWidth) + "+");
    System.out.println();

  }

  static Concert[] createConcertArray() {
    //change this when doing extra credit
    Concert[] concerts = new Concert[10];
      Random rand = new Random();

      String[] artists = {"Beyoncé", "Coldplay", "Drake", "Taylor Swift", "Kendrick Lamar", "Adele", "The Weeknd", 
                      "Billie Eilish", "Post Malone", "Bruno Mars", "Sabrina Carpenter", "Chappell Roan", "Noah Khan"};
      //change length of for loop if doing extra credit
      for (int i = 0; i < 10; i++) {
          int capacity = rand.nextInt(100,1000) + 1; // generates capacity between 100 to 1000
          int startTime = rand.nextInt(2300); // generates start time between 0 to 2300
          int endTime = startTime + rand.nextInt(2400 - startTime) + 1; // ensures end time > start time

          String artist = artists[rand.nextInt(artists.length)]; //gets a random artist from the list

          concerts[i] = new Concert(i+1, artist, capacity, startTime, endTime);
      }
      return concerts;

  }
  ////////////////////////////////////////////////////////////////////////////////////////////////
  /*
  * DON'T TOUCH 
  * 
  */
  ////////////////////////////////////////////////////////////////////////////////////////////////
}
