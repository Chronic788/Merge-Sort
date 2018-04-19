import java.util.Random;

public class MergeSort {
       
    private static int[] merge(int[] leftSide, int[] rightSide) {
        
        //The array to merge the sides into
        int[] fullArray = new int[leftSide.length + rightSide.length];
        
        //Indeces to help with looking at each array
        int i = 0, j = 0;
        //For the size of the full array
        for (int k = 0; k < fullArray.length; k++) {
            
            //If we have overrun the left array, we have consumed it, so
            //we must add from the right array
            if(i >= leftSide.length)
                fullArray[k] = rightSide[j++];
            
            //If we have overrun the right array, we have consumed it, so
            //we must add from the left array
            else if(j >= rightSide.length) 
                fullArray[k] = leftSide[i++];
            
            //If the item in the left side array is less than the one on the right side
            //then add it to the array, incrementing i for the next pass
            else if(leftSide[i] <= rightSide[j]) 
                fullArray[k] = leftSide[i++];
            
            //If the item on the left side array is greater than the one on the right
            //side then add it to the array, incrementing j for the next pass
            else 
                fullArray[k] = rightSide[j++];
   
        }
        
        return fullArray;
    }
    
    private static int[] mergeSort(int[] merging) {
        //Record the size of the merging array
        int size = merging.length;
        
        //If the array is a single entry, return it
        if(size <= 1) {
            return merging;
        }
        
        //Allocate the left array
        int[] leftSide = new int[size / 2];
        //Allocate the right array
        int[] rightSide = new int[size - (size / 2)];
        
        //Copy the merging array into both side arrays
        for (int i = 0; i < leftSide.length; i++)
            leftSide[i] = merging[i];
        for (int i = 0; i < rightSide.length; i++)
            rightSide[i] = merging[i + (size / 2)]; //We just add the size of half the array each iteration
        
        //Merge the Merge sorted sides
        return merge(mergeSort(leftSide), mergeSort(rightSide));
    }
        
    public static void main(String[] args) {
        
        Random rand = new Random();
        
        int numbers = 9999999;
        
        int[] values = new int[numbers];
        
        for (int i = 0; i < values.length; i++) {
            int random = rand.nextInt((10000 - 0) + 1 + 0);
            values[i] = random;
        }
        
        
        System.out.println("Sorting " + numbers + " elements...\n");
        long start = System.currentTimeMillis();
        values = mergeSort(values);
        long stop = System.currentTimeMillis();
        
        System.out.println("Done Sorting " + numbers + " elements.\n\nSorting took " + (stop - start) + " ms");
        
    }
    
}
