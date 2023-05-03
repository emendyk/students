package edu.guilford;



import java.util.Random;

public class CreditSort {
    private int credits;
    private String gradeLevel;
    
    public CreditSort() {
        this.credits = (int) (Math.random() * 151);
        if (this.credits <= 30) {
            this.gradeLevel = "First-year";
        } else if (this.credits <= 60) {
            this.gradeLevel = "Second-year";
        } else if (this.credits <= 90) {
            this.gradeLevel = "Third-year";
        } else if (this.credits <= 120) {
            this.gradeLevel = "Fourth-year";
        } else {
            this.gradeLevel = "Graduate";
        }
    }
    
    public int getCredits() {
        return credits;
    }
    
    public String getGradeLevel() {
        return gradeLevel;
    }
    
    public static void selectionSort(CreditSort[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getCredits() < array[minIndex].getCredits()) {
                    minIndex = j;
                }
            }
            CreditSort temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
    
    public static void quickSort(CreditSort[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }
    
    private static int partition(CreditSort[] array, int left, int right) {
        int pivot = array[right].getCredits();
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j].getCredits() < pivot) {
                i++;
                CreditSort temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        CreditSort temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return i + 1;
    }
    
    public static int sequentialSearch(CreditSort[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getCredits() == key) {
                return i;
            }
        }
        return -1;
    }
    
    public static int binarySearch(CreditSort[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid].getCredits() == key) {
                return mid;
            } else if (array[mid].getCredits() < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
}
