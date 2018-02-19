/**
 * File: QuickSorter
 * Author: Michelle John
 * Date 18 February 2018
 * Purpose: Week 6: Binary Search Tree Sort
 */
package main;

import java.util.Comparator;
import java.util.Random;

/**
 * Class that implements a quick sort method to sort a give array.
 *
 * @param <T> the type
 */
public class QuickSorter<T> {

  /**
   * Method that performs a quick sort.
   * 
   * @param inputArray the array to sort
   * @param firstIndex the index to start at
   * @param arraySize the size of the array
   * @param comparator the comparator to use
   */
  public void quickSort(T[] inputArray, int firstIndex, int arraySize, Comparator<T> comparator) {
    if (arraySize <= 1)
      return;

    Random rand = new Random();
    T arrayElement = inputArray[firstIndex + rand.nextInt(arraySize)];
    int swapIndex = firstIndex - 1;
    int startIndex = firstIndex;
    int lastIndex = firstIndex + arraySize;
    while (startIndex < lastIndex) {
      int comp = comparator.compare(inputArray[startIndex], arrayElement);
      if (comp < 0) {
        swap(inputArray, startIndex++, ++swapIndex);
      } else if (comp > 0) {
        swap(inputArray, startIndex, --lastIndex);
      } else {
        startIndex++;
      }
    }
    quickSort(inputArray, firstIndex, swapIndex - firstIndex + 1, comparator);
    quickSort(inputArray, lastIndex, arraySize - (lastIndex - firstIndex), comparator);
  }

  /**
   * Method to perform the swap if needed.
   * 
   * @param array the array to alter
   * @param firstIndex the index of one of the elements to swap
   * @param secondIndex the index of the othe relement to swap
   */
  private void swap(T[] array, int firstIndex, int secondIndex) {
    T temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
  }
}
