package DSA;

import javax.xml.transform.Source;
import java.util.*;

public class Arrays {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the size of your array: ");
        int n = scn.nextInt();
        // Declaration of an Array
        int[] array = new int[n]; // Array of datatype integers of size 5

//      int array1[] = new int[5]; //Another way of declaring an array
//      int[] array2 = {1,2,3,4,5}; //Another way of declaring an array. Here an array is also initialized with the respective values.

    inputElements(array, scn);

    System.out.println("The array is: ");
    printArray(array);

    System.out.println(" ");

    int[] arr = removeEvenIntegers(array);
    System.out.println("The array after removing even integers is: ");
    printArray(arr);

    System.out.println(" ");

    reverseArray(array);
    System.out.println("The array after reversal is: ");
    printArray(array);

    System.out.println(" ");
    int min = minimumValueInAnArray(array);
    System.out.print("Minimum value in an array is: " + min);

    System.out.println(" ");
    int max = maximumValueInAnArray(array);
    System.out.print("Maximum value in an array is: " + max);

    System.out.println(" ");
    sendingToLast(array, n, scn);
    printArray(array);




    scn.close();

    }
    //Function for taking input of elements into an array
    static void inputElements(int[] arr, Scanner scn){
//        for(int i=0;i<n;i++){
//            System.out.print("Your " + (i+ 1)+"st element is: " );
//            arr[i] = scn.nextInt();
//        }

        //This is  for taking input using enhanced for loop. Here we don't use 'i' anywhere.
        int index=0; //First we initialize the index to keep track of the position
        for(int i : arr) {
            System.out.print("Enter element " + (index + 1) + " : ");
            arr[index] = scn.nextInt();
            index++;
        }
    }
    //Function to print elements in an array
    static void printArray(int[] arr){

//        System.out.println("The array is: ");
//        for(int i=0;i< arr.length;i++){
//            System.out.print(arr[i] + " ");

        //This for printing using enhanced for loop
        int index=0;
        for(int i: arr){
            System.out.print(arr[index] + " ");
            index ++;
    }
    }

    static int[] removeEvenIntegers(int[] arr){
        //First we need to find the number of odd integers in the array
        int oddints = 0;
        for(int num:arr){
            if(num%2 !=0){
                oddints++;
            }
        }

        //Now with the number of odd integers, we create an array and push the elements from the original array into a new array.
        int[] result = new int[oddints];
        int index =0;
        for(int num: arr) {
            if (num % 2 != 0) {
                result[index] = num;
                index++;
            }
        }
        return result;
    }

    static void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end ){ //here we need to swap the last element with the first element and second element with the second-last element and so on.
            int temp = arr[start];
           arr[start] = arr[end];
            arr[end] = temp;

            start++;//we do this bcz the first index which is 0 after swapping it should become 1.
            end--;//similar to the above one but it should decrease.
        }
    }

    //Finding minimum value in an array
    static int minimumValueInAnArray(int[] arr){
        int val=arr[0]; // initially we give the first element in the array to be minimum element.
        for(int i=0;i<arr.length;i++) {
            if (arr[i] < val) { // If any other element is found less than the val then it is swapped
                val = arr[i];
            }
        }
        return val;
    }

    //Finding maximum value in an array
    static int maximumValueInAnArray(int[] arr){
        int val=arr[0]; // initially we give the first element in the array to be maximum element.
        for(int i=0; i<arr.length;i++) {
            if (arr[i] > val) { // If any other element is found more than the val then it is swapped
                val = arr[i];
            }
        }
        return val;
    }

    //sending a particular number to the end of an array - the element is n
    static void sendingToLast(int[] arr, int n, Scanner scn){
        int j = 0; //This is used for the n's in an array

        System.out.print("Enter the value of n: ");
        n = scn.nextInt();

        for(int i=0;i< arr.length;i++){
            if (arr[i] != n && arr[j] == n) { //Here we are checking for the condition that the i should be the non-zero element
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != n ){ //This to move to next element if it is not n.
                j++;
            }
        }
    }
}
