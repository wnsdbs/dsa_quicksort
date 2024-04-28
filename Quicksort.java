public class Quicksort {
    public static void main(String[] args) {
        // initialize the array to sort (8 randomized values)
        int[] arr = new int [8];
        for (int i = 0; i < arr.length; i++) {
        	arr[i] = (int)(Math.random() * 100);
        }
        // initialize the low index
        int low = 0;
        // initialize the high index
        int high = arr.length - 1;
        System.out.println("Original array:");
        printArr(arr);
        // quickSort the array from low to high        
        quickSort(arr, low, high);
        System.out.println("Sorted array:");
        printArr(arr);
    }
    
    // modular
    public static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }
    
    // modular 
    public static void swap(int[] arr, int i, int j) {
    	// allows the array values arr[i] and arr[j] to be swapped
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // recursive method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
        	// partition the array against the value in the high index
            int index = partition(arr, low, high);
            System.out.println("Now partitioning from: " + low + " to " + high);
            printArr(arr);
            // quickSort the values to the "left" of the partition value (-1)
            quickSort(arr, low, index - 1);
            // and to the "right" of the partition value (+1)
            quickSort(arr, index + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivotValue = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
}
