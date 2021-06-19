public class SortBook {
    private Book tempArr[];
    private int arrLength;
    
    public SortBook(Book[] arr) {
        if (!isArrEmpty(arr)) {
            this.tempArr = arr;
            arrLength = arr.length;
        }else {
            Menu.printMessage("Books list is empty");
        }
    }
    
    public Book[] sortBooks() {
        quickSort(0, arrLength - 1);
        return this.tempArr;
    }
    
    private boolean isArrEmpty (Book arr[]) {
        return arr == null || arr.length == 0;
    }
    
    private void quickSort(int prevLower, int prevUpper) {
        int lower = prevLower;
        int upper = prevUpper;
        // getting the pivot to compare data to 
        Book pivot = tempArr[prevLower+(prevUpper-prevLower)/2];
        // separating the array into two smaller section
        while (lower <= upper) {
            while (tempArr[lower].getID() < pivot.getID()) {
                lower++;
            }
            while (tempArr[upper].getID() > pivot.getID()) {
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
        Book temp = tempArr[i];
        tempArr[i] = tempArr[j];
        tempArr[j] = temp;
    }
}