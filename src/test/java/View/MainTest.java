package View;

import com.sparta.Lovedeep.Controller.SortFactory;
import com.sparta.Lovedeep.Controller.Sorter;

import com.sparta.Lovedeep.Model.*;
import com.sparta.Lovedeep.View.Starter;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class MainTest {

    private static final int smallLen= 1000;
    private static final int mediumLen = 5000;
    private static final int largeLen = 15000;

    private static int[] smallSample= null;
    private static int[] mediumSample = null;
    private static int[] largeSample= null;
    private Sorter bubbleSort = null;
    private Sorter mergeSort = null;
    private Sorter binarySort = null;


    @Test
    void nullTestBinary() {
        SortFactory sorterFactory = new SortFactory();
        Sorter binarySort = SortFactory.getSort("BinarySort");
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> binarySort.sortArray(null));
        Assertions.assertEquals("Array is null!", exception.getMessage());
    }


    @Test
    void nullTestBubble() {
        SortFactory sorterFactory = new SortFactory();
        Sorter bubbleSort = SortFactory.getSort("BubbleSort");
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> bubbleSort.sortArray(null));
        Assertions.assertEquals("Array is null!", exception.getMessage());
    }
    @Test
    void nullTestMerge() {
        SortFactory sorterFactory = new SortFactory();
        Sorter mergeSort = SortFactory.getSort("MergeSort");
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> mergeSort.sortArray(null));
        Assertions.assertEquals("Array is null!", exception.getMessage());
    }



    @Test
    @DisplayName("Testing Bubble Sort")
    public void testBubbleSort() throws SmallArrayException, EmptyArrayException {
        BubbleSort bubbleSort=new BubbleSort();
        int[] array1 = {11, 63, 40, 39, 88, 33};  // random
        int[] array2 = {58, 57, 56, 55, 54, 53};  // descending (reverse) order
        int[] array3 = {113, 114, 115, 116, 117, 118};  // ascending (correct) order
        int[] array4 = {50, 20, 80, 20, 80, 50};  // few unique value (not realistic input)
        int[] array5 = {-43, 13, -5, 0, 109, 8};  // negative value (not realistic input)

        int[] array1Sorted = {11, 33, 39, 40, 63, 88};
        int[] array2Sorted = {53, 54, 55, 56, 57, 58};
        int[] array3Sorted = {113, 114, 115, 116, 117, 118};
        int[] array4Sorted = {20, 20, 50, 50, 80, 80};
        int[] array5Sorted = {-43, -5, 0, 8, 13, 109};

        Assertions.assertArrayEquals(array1Sorted, bubbleSort.sortArray(array1));
        Assertions.assertArrayEquals(array2Sorted, bubbleSort.sortArray(array2));
        Assertions.assertArrayEquals(array3Sorted, bubbleSort.sortArray(array3));
        Assertions.assertArrayEquals(array4Sorted, bubbleSort.sortArray(array4));
        Assertions.assertArrayEquals(array5Sorted, bubbleSort.sortArray(array5));
    }
    @Test
    void sortTestBubble() throws EmptyArrayException, SmallArrayException {
        SortFactory sorterFactory = new SortFactory();
        Sorter bubbleSort = SortFactory.getSort("BubbleSort");
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, bubbleSort.sortArray(new int[]{5, 4,3,2,1}));
    }


    @Test
    void checkBubbleSort() throws SmallArrayException, EmptyArrayException {
        int[] arr = new int[]{5, 3, 10, 3, 8, 9, 15, 12, 11};
        BubbleSort bs = new BubbleSort();
        boolean workBubbleSort = bs.isSorted(bs.sortArray(arr));
        Assertions.assertEquals(true, workBubbleSort);
    }

    //Performance Tests
  @Test
  void bubbleSortSmallSample() throws SmallArrayException, EmptyArrayException {
      BubbleSort bubbleSort= new BubbleSort();
     ExecutionTime timer = new ExecutionTime();
      timer.start();
      Assertions.assertEquals(smallLen, bubbleSort.sortArray(smallSample).length);
      float timeTaken = timer.end();
      String resultBubbleS = "BubbleSorter SMALL(" + smallLen + "): " + timeTaken + "ms.";
      System.out.println(resultBubbleS);
  }
    @Test
    void bubbleSortMediumSample() throws SmallArrayException, EmptyArrayException {
        BubbleSort bubbleSort= new BubbleSort();
        ExecutionTime timer = new ExecutionTime();
        timer.start();
        Assertions.assertEquals(mediumLen, bubbleSort.sortArray(mediumSample).length);
        float timeTaken = timer.end();
        String resultBubbleM = "BubbleSorter MEDIUM(" + mediumLen + "): " + timeTaken + "ms.";
    }

    @Test
    void bubbleSortLargeSample() throws SmallArrayException, EmptyArrayException {
        BubbleSort bubbleSort= new BubbleSort();
        ExecutionTime timer = new ExecutionTime();
        timer.start();
        Assertions.assertEquals(largeLen, bubbleSort.sortArray(largeSample).length);
        float timeTaken = timer.end();
       String resultBubbleL = "BubbleSorter LARGE(" + largeLen + "): " + timeTaken + "ms.";
    }
    @Test
    void mergeSortSmallSample() throws SmallArrayException, EmptyArrayException {
        ExecutionTime timer = new ExecutionTime();
        MergeSort mergeSort=new MergeSort();
        timer.start();
        Assertions.assertEquals(smallLen, mergeSort.sortArray(smallSample).length);
        float timeTaken = timer.end();
       String resultMergeS = "MergeSorter SMALL(" + smallLen + "): " + timeTaken + "ms.";
    }

    @Test
    void mergeSortMediumSample() throws SmallArrayException, EmptyArrayException {
        ExecutionTime timer = new ExecutionTime();
        MergeSort mergeSort=new MergeSort();
        timer.start();
       Assertions. assertEquals(mediumLen, mergeSort.sortArray(mediumSample).length);
        float timeTaken = timer.end();
       String  resultMergeM = "MergeSorter MEDIUM(" + mediumLen+ "): " + timeTaken + "ms.";
    }

    @Test
    void mergeSortLargeSample() throws SmallArrayException, EmptyArrayException {
        ExecutionTime timer = new ExecutionTime();
        MergeSort mergeSort=new MergeSort();
        timer.start();
        Assertions.assertEquals(largeLen, mergeSort.sortArray(largeSample).length);
        float timeTaken = timer.end();
       String resultMergeL = "MergeSorter LARGE(" + largeLen + "): " + timeTaken + "ms.";
    }
    @Test
    void binaryTreeSortSmallSample() throws SmallArrayException, EmptyArrayException {
        ExecutionTime timer = new ExecutionTime();
        BinarySort binarySort=new BinarySort();
        timer.start();
        Assertions.assertEquals(smallLen, binarySort.sortArray(smallLen).length);
        float timeTaken = timer.end();
        String resultBinaryS = "BinarySorter SMALL(" + smallLen + "): " + timeTaken + "ms.";
    }

    @Test
    void binaryTreeSortMediumSample() throws SmallArrayException, EmptyArrayException {
        ExecutionTime timer = new ExecutionTime();
        BinarySort binarySort=new BinarySort();
        timer.start();
        Assertions.assertEquals(mediumLen, binarySort.sortArray(mediumSample).length);
        float timeTaken = timer.end();
       String  resultBinaryM = "BinarySorter MEDIUM(" + mediumLen + "): " + timeTaken + "ms.";
    }

    @Test
    void binaryTreeLargeSample() throws EmptyArrayException,SmallArrayException {
        ExecutionTime timer = new ExecutionTime();
        BinarySort binarySort=new BinarySort();
        timer.start();
        Assertions.assertEquals(largeLen,
                binarySort.sortArray(largeSample).length);
        float timeTaken = timer.end();
       String resultBinaryL = "BinarySort LARGE(" + largeLen+ "): " + timeTaken + "ms.";
    }



}