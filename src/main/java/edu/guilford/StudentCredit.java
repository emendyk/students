package edu.guilford;

/**
 * Hello world!
 *
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StudentCredit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("How many random objects do you want to generate? ");
        int numObjects = input.nextInt();
        
        CreditSort[] array = new CreditSort[numObjects];
        for (int i = 0; i < numObjects; i++) {
            array[i] = new CreditSort();
        }
        
        System.out.println("Before sorting:");
        printArray(array);
        System.out.println();
        
        shuffle(array);
        long startTime = System.nanoTime();
        CreditSort.selectionSort(array);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        System.out.println("After selection sort:");
        printArray(array);
        System.out.println("Time taken by selection sort: " + duration / 1e6 + " milliseconds");
        System.out.println();
        
        shuffle(array);
        startTime = System.nanoTime();
        CreditSort.quickSort(array, 0, array.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        
        System.out.println("After quick sort:");
        printArray(array);
        System.out.println("Time taken by quick sort: " + duration / 1e6 + " milliseconds");
        System.out.println();
        
        System.out.print("Enter a number of credits to search for: ");
        int key = input.nextInt();
        
        shuffle(array);
        startTime = System.nanoTime();
        int index = CreditSort.sequentialSearch(array, key);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        
        if (index == -1) {
            System.out.println(key + " not found in the array");
        } else {
            System.out.println(key + " found at index " + index);
        }
        System.out.println("Time taken by sequential search: " + duration / 1e6 + " milliseconds");
        System.out.println();
        
        shuffle(array);
        startTime = System.nanoTime();
        index = CreditSort.binarySearch(array, key);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        
        if (index == -1) {
            System.out.println(key + " not found in the array");
        } else {
            System.out.println(key + " found at index " + index);
        }
        System.out.println("Time taken by binary search: " + duration / 1e6 + " milliseconds");
        System.out.println();
    }
    
    public static void printArray(CreditSort[] array) {
        for (CreditSort obj : array) {
            System.out.println(obj.getGradeLevel() + ": " + obj.getCredits() + " credits");
        }
    }
    public static void shuffle(CreditSort[] array) {
        
        for (int i = 0; i < array.length; i++) {
            int randomIndextoSwap = (int) (Math.random() * array.length);
            CreditSort temp = array[randomIndextoSwap];
            array[randomIndextoSwap] = array[i];
            array[i] = temp;
        }
}
    // add a static method to swap two elements in an array
    public static void swap(CreditSort[] array, int i, int j) {
        CreditSort temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
