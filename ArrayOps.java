public class ArrayOps {
    public static void main(String[] args) {

        /* testing...

        int[] array = new int[] {-202,48,13,7,8};
        int[] array2 = new int[] {2,1};
        System.out.println("The missing integer is " + findMissingInt(array));
        System.out.println("The second max Value is " + secondMaxValue(array));
        System.out.println(containsTheSameElements(array, array2)); 
        System.out.println(isSorted(array));
         */
    }

    /*
    finds a missing integer in an array that contains every integer between 0
    and the kength of the array - except for one.
     */  
    public static int findMissingInt (int [] array) {
        int n = array.length;
        for (int i = 0; i <= n; i++) {
            if (!contains(array, i)) return i;
        }
        return -1;
    }

    public static int secondMaxValue(int [] array) {
        int max, secondMax;
        
        max = Math.max(array[0], array[1]);
        secondMax = Math.min(array[0], array[1]);
        for (int i = 2; i< array.length; i++) {
            if (array[i] >= max){
                secondMax = max;
                max = array[i];
                continue;
            }
            if (array[i] >= secondMax) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }
  
    //checks if to arrays contain the same elements
    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean same = true;
        for (int i = 0; i < array1.length ; i++) {
            if (!contains(array2, array1[i])) {
                same = false;
            }
        }
        for (int i = 0; i < array2.length ; i++) {
            if (!contains(array1, array2[i])) {
                same = false;
            }
        }
        return same;
    }
    //checks if an array is sorted in an increasing order or a decreasing order;
    public static boolean isSorted(int [] array) {
        boolean increasing = false;
        for (int i = 0; i < array.length; i++) { // if array[i+1] == array[i] we will continuew to check 
            if (array[i+1] > array[i]) {
                increasing = true; //array is increaing. we will check if sorted increasingly.
                break;
            }
            else if (array[i+1] < array[i]) {
                increasing = false; //array is decreasing. we will check if sorted decreasingly.
                break;
            } 
        }
        if (increasing) {
            for (int i = 0; i < array.length - 1; i++) {
                if (!(array[i+1] >= array[i])) return false;
            }
        }
        else if (!increasing) {
            for (int i = 0; i < array.length - 1; i++) {
                if (!(array[i+1] <= array[i])) return false;
        }
            }    
        return true;
    }

    //contains - checks if an integer exists in the array
    public static boolean contains (int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) return true;
        }
        return false; 
    }

    //return maximum value in an integer array
    public static int max (int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        } 
        return max;
    }

    //return min value in an integer array
    public static int min (int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
