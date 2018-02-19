/**
 * File: Fraction
 * Author: Michelle John
 * Date 18 February 2018
 * Purpose: Week 6: Binary Search Tree Sort
 */
package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import exceptions.MalformedInputException;

/**
 * Class that holds a fraction.
 */
public class Fraction implements Comparator<Fraction> {

  private String fraction;
  private List<String> fractionIntegers;
  private double fractionValue;

  /**
   * Default constructor.
   */
  public Fraction() {
  }

  /**
   * Constructor.
   * 
   * @param fraction the fraction as a string
   * @throws MalformedInputException if the fraction is malformed
   */
  public Fraction(String fraction) throws MalformedInputException {
    this.fraction = fraction;
    checkFraction();
    fractionToDouble();
  }

  /**
   * Makes sure there only two elements in the fraction.
   * 
   * @throws MalformedInputException if there are not exactly two elements
   */
  private void checkFraction() throws MalformedInputException {
    fractionIntegers = Arrays.asList(fraction.split("/"));

    if (fractionIntegers.size() != 2) {
      throw new MalformedInputException("Malformed fraction.");
    }
  }

  /**
   * Turns the fraction into a double value.
   * 
   * @throws MalformedInputException if the elements of the fraction are not numbers
   */
  private void fractionToDouble() throws MalformedInputException {
    try {
      fractionValue = Double.parseDouble(fractionIntegers.get(0)) / Double.parseDouble(fractionIntegers.get(1));
    } catch (NumberFormatException e) {
      throw new MalformedInputException(e.getLocalizedMessage());
    }
  }

  /**
   * @return the value of the fraction
   */
  public double getFractionValue() {
    return fractionValue;
  }

  @Override
  public int compare(Fraction fraction1, Fraction fraction2) {
    if (fraction1.getFractionValue() < fraction2.getFractionValue())
      return -1;
    if (fraction1.getFractionValue() > fraction2.getFractionValue())
      return 1;
    return 0;
  }

  @Override
  public String toString() {
    return fraction;
  }
}
