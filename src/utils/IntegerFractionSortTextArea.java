/**
 * File: BinaryTreeSortTextArea
 * Author: Michelle John
 * Date 18 February 2018
 * Purpose: Week 6: Binary Search Tree Sort
 */
package utils;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * Custom implementation of {@link JTextArea} for this application.
 */
public class IntegerFractionSortTextArea extends JTextArea {

  private static final long serialVersionUID = 1L;
  
  /**
   * Constructor.
   * 
   * @param editable if the text area should be editable
   */
  public IntegerFractionSortTextArea(boolean editable) {
    super();
    setEditable(editable);
    setBackground(WHITE);
    setForeground(BLACK);
    setColumns(20);
    setBorder(new LineBorder(BLACK));
  }
}
