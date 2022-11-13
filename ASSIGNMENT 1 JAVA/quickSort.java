import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;

    public class quickSort {

        static long counter = 0; // Initialize the variable counter
        
           // This function will return the finished quick sort array 

           public <P extends Comparable<P>> P[] quickSortArray(P[] sorting_Array, int m) {
               SORT(sorting_Array, 0, m); 
               counter+=2; // 1 substraction of sortArray.length - 1 and 1 call of sorting function
               counter++; // 1 return of sortArray

               System.out.println(counter);
               return (sorting_Array);
               
           }
           
           // This function swaps the element in the sorting_Array
           // the index of the 1st element is starting and the index of the 2nd element is ending

           static <P> boolean SWAP(P[] sorting_Array, int starting, int ending){
               P TEMP = sorting_Array[starting]; 
               sorting_Array[starting] = sorting_Array[ending];
               sorting_Array[ending] = TEMP;
               counter+=7; //3 assignments , 4 indexing array

               counter++; //1 return of true
               return true;
           }
       
       
           // This function compares the first_element with the second_element
           // and return true if first_element is lesser than the second_element

           static <P extends Comparable<P>> boolean LESSER(P first_element, P second_element) {
               counter+=3; // 1 return, 2 comparisons 
               return first_element.compareTo(second_element) < 0;
           }
       
           // This function is sorting sorting_Array

           private static <P extends Comparable<P>> void SORT(P[] sorting_Array, int LEFT, int RIGHT) {
               if (LEFT < RIGHT) {
                   counter++; //comparison of left < right
                   int PIVOT = PARTITION(sorting_Array, LEFT, RIGHT);
                   counter+=2; // 1 assignment of PIVOT and 1 calling of the function partition
                   SORT(sorting_Array, LEFT, PIVOT - 1);
                   counter+=2; // 1 PIVOT subtraction and 1 calling of the function doSort
                   SORT(sorting_Array, PIVOT , RIGHT);
                   counter++; // 1 calling of the function doSort
               }
           }
       
           // This function finds the pivot in the array by partitioning the sorting_Array
       
           private static <P extends Comparable<P>> int PARTITION(P[] sorting_Array, int LEFT, int RIGHT) {
               int middle = (LEFT + RIGHT) / 2; 
               counter+=3; // 1 assignment of middle, 1 addition and 1 division 

               P PIVOT = sorting_Array[middle];
               counter+=2; // 1 assignment of pivot and 1 indexing array
       
               while(LEFT <= RIGHT) {
                   counter++; // 1 comparison of left <= right 

                   while(LESSER(sorting_Array[LEFT], PIVOT)){
                       counter+=2; 
                       // 1 function call of lesser and 1 indexing of array
                       ++LEFT;
                       counter++; // addition of left
                   }
                   while(LESSER(PIVOT, sorting_Array[RIGHT])) {
                       counter+=2; 
                       // 1 function call of lesser and 1 indexing of array
                       --RIGHT;
                       counter++; // 1 addition of right
                   }
                   if(LEFT <= RIGHT) {
                       counter++; // 1 comparison of left <= right

                       SWAP(sorting_Array, LEFT, RIGHT); // 1 calling of swaping function to swap the elements' positions
                       counter++; // 1 calling of swaping function

                       ++LEFT;
                       counter++; // 1 addition of left

                       --RIGHT;
                       counter++; // 1 addition of right
                   }
               }
               counter++; // 1 return of left
               return LEFT;
           }
        
        


    // The main function that have throws to handle exception
    public static void main(String[] args) throws IOException {
        List<String> wordList;

        // get the data from the file and assign to wordList
        wordList = Files.readAllLines(Paths.get("wordList.txt"));

         // assigning the data from the list into a string array
        String[] wordArray = wordList.toArray(new String[0]);

        // Initializing the object quickSort
        quickSort quick_Sort = new quickSort();

        int m = wordArray.length - 1;
        
        System.out.println("Before sorting the array elements : " + Arrays.toString(wordArray));
        
        quick_Sort.quickSortArray(wordArray, m); // calling function quick_Sort from the class quickSort
        
        System.out.println("After sorting the array elements : " + Arrays.toString(wordArray));

          
    }
}

