/**
 * File: BinaryTreeSortPanel
 * Author: Michelle John
 * Date 18 February 2018
 * Purpose: Week 6: Binary Search Tree Sort
 */
package utils;

import static javax.swing.BorderFactory.createTitledBorder;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Custom implementation of {@link JPanel} for this application.
 */
public class IntegerFractionSortPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  
  /**
   * Constructor.
   * 
   * @param title the title of the panel
   */
  public IntegerFractionSortPanel(String title) {
    super(new GridLayout(0, 1, 3, 3));
    setBorder(createTitledBorder(title));
  }
}
