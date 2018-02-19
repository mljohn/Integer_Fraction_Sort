/**
 * File: Sorter
 * Author: Michelle John
 * Date 18 February 2018
 * Purpose: Week 6: Binary Search Tree Sort
 */
package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exceptions.MalformedInputException;

/**
 * Class that sorts an array.
 */
public class Sorter {

  private String[] textArray;
  private boolean isAscending;
  private boolean isInteger;

  /**
   * Constructor.
   * 
   * @param text the text string to sort
   * @param isAscending if the sort needs to be ascending
   * @param isInteger if the text string is a string of integers
   * @throws MalformedInputException if there is an issue with the text string
   */
  public Sorter(String text, boolean isAscending, boolean isInteger) throws MalformedInputException {

    this.isAscending = isAscending;
    this.isInteger = isInteger;
    stringSplitter(text);
    sort();
  }
  
  /**
   * Method to split the given text string into individual parts.
   * 
   * @param text the text to split
   */
  
  private void stringSplitter(String text) {
    this.textArray = text.split(" ");
  }
  

  /**
   * Sorts the text string.
   * 
   * @throws MalformedInputException if there is an issue with the text string
   */
  public void sort() throws MalformedInputException {
    if (isInteger) {
      QuickSorter<Integer> quickSorter = new QuickSorter<>();
      Integer[] intArray = new Integer[textArray.length];
      try {
        for (int i = 0; i < textArray.length; i++) {
          intArray[i] = Integer.parseInt(textArray[i]);
        }
      } catch (NumberFormatException e) {
        throw new MalformedInputException(e.getLocalizedMessage());
      }
      quickSorter.quickSort(intArray, 0, intArray.length, createComparator());
      for (int i = 0; i < intArray.length; i++) {
        textArray[i] = intArray[i].toString();
      }
    } else {
      QuickSorter<Fraction> quickSorter = new QuickSorter<>();
      Fraction[] fractionArray = new Fraction[textArray.length];
      for (int i = 0; i < textArray.length; i++) {
        fractionArray[i] = new Fraction(textArray[i]);
      }
      quickSorter.quickSort(fractionArray, 0, fractionArray.length, new Fraction());
      if (!isAscending) {
        List<Fraction> fractionList = Arrays.asList(fractionArray);
        Collections.reverse(fractionList);
        fractionArray = fractionList.toArray(fractionArray);
      }
      for (int i = 0; i < fractionArray.length; i++) {
        textArray[i] = fractionArray[i].toString();
      }
    }
  }
  
  private Comparator<Integer> createComparator() {
    if (isAscending) {
      return new Comparator<Integer>() {

        @Override
        public int compare(Integer integer1, Integer integer2) {
          return integer1 - integer2;
        }
      };
    }
    return new Comparator<Integer>() {
      @Override
      public int compare(Integer integer1, Integer integer2) {
        return integer2 - integer1;
      }
    };
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < textArray.length; i++) {
      sb.append(textArray[i] + " ");
    }
    return sb.toString();
  }

}
