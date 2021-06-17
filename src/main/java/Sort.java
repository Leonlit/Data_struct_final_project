public class Sort {
     
    private int tempArr[];
    private int arrLength;
 
    public void sort(int[] arr) {
         
        if (arr == null || arr.length == 0) {
            return;
        }
        this.tempArr = arr;
        arrLength = arr.length;
        quickSort(0, arrLength - 1);
    }
     private void quickSort(int prevLower, int prevUpper) {
         
        int lower = prevLower;
        int upper = prevUpper;
        // getting the pivot to compare data to 
        int pivot = tempArr[prevLower+(prevUpper-prevLower)/2];
        // separating the array into two smaller section
        while (lower <= upper) {
            while (tempArr[lower] < pivot) {
                lower++;
            }
            while (tempArr[upper] > pivot) {
                upper--;
            }
            if (lower <= upper) {
                swappingValue(lower, upper);
                //move index to next position on both sides
                lower++;
                upper--;
            }
        }
        // call quickSort() method recursively
        if (prevLower < upper)
            quickSort(prevLower, upper);
        if (lower < prevUpper)
            quickSort(lower, prevUpper);
    }
 
    private void swappingValue(int i, int j) {
        int temp = tempArr[i];
        tempArr[i] = tempArr[j];
        tempArr[j] = temp;
    }
}