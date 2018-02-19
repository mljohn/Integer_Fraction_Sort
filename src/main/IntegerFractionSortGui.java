/**
 * File: BinaryTreeSortGui
 * Author: Michelle John
 * Date 18 February 2018
 * Purpose: Week 6: Binary Search Tree Sort
 */
package main;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.PAGE_END;
import static java.awt.BorderLayout.PAGE_START;
import static java.awt.GridBagConstraints.EAST;
import static java.awt.GridBagConstraints.HORIZONTAL;
import static java.awt.GridBagConstraints.WEST;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import exceptions.MalformedInputException;
import utils.IntegerFractionSortFrame;
import utils.IntegerFractionSortPanel;
import utils.IntegerFractionSortTextArea;

/** 
 * Main class for the BinaryTreeSort. This class builds and displays the GUI.
 */
public class IntegerFractionSortGui {
  
  /**
   * Entry point into the application. Builds the GUI.
   * 
   * @param args the arguments set at start
   */
  public static void main (String[] args) {
    
    IntegerFractionSortGui gui = new IntegerFractionSortGui();
    gui.build();
  }

  /**
   * Method that builds the expression evaluator GUI.
   */
  private void build() {
    
    IntegerFractionSortFrame frame = new IntegerFractionSortFrame("Binary Search Tree Sort", 400, 225);
    JPanel textAreaPanel = new JPanel(new GridBagLayout());
    JPanel buttonPanel = new JPanel();
    IntegerFractionSortPanel sortPanel = new IntegerFractionSortPanel("Sort Order");
    IntegerFractionSortPanel numericPanel = new IntegerFractionSortPanel("Numeric Type");
    JPanel radioButtonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
    
    JLabel originalListLabel = new JLabel("Original List");
    JLabel sortedListLabel = new JLabel("Sorted List");
    IntegerFractionSortTextArea originalListTextArea = new IntegerFractionSortTextArea(true);
    IntegerFractionSortTextArea sortedListTextArea = new IntegerFractionSortTextArea(false);
    
    JRadioButton ascendingRadioButton = new JRadioButton("Ascending", true);
    JRadioButton descendingRadioButton = new JRadioButton("Descending");
    JRadioButton integerRadioButton = new JRadioButton("Integer", true);
    JRadioButton fractionRadioButton = new JRadioButton("Fraction");
    ButtonGroup sortButtonGroup = new ButtonGroup();
    ButtonGroup numTypeButtonGroup = new ButtonGroup();
    
    JButton performButton = new JButton("Perform Sort");
    
    performButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        String list = originalListTextArea.getText();
        if (list.isEmpty() || list == null) {
          JOptionPane.showMessageDialog(frame, "Please enter a list of numbers.");
        }
        boolean isAscending = ascendingRadioButton.isSelected();
        boolean isInteger = integerRadioButton.isSelected();
        
        Sorter sorter = null;
        try {
          sorter = new Sorter(list, isAscending, isInteger);
        } catch (MalformedInputException e1) {
          JOptionPane.showMessageDialog(frame, "Invalid numbers were entered");
        }
        
        sortedListTextArea.setText(sorter.toString());
        
      }
    });
    
    sortButtonGroup.add(ascendingRadioButton);
    sortButtonGroup.add(descendingRadioButton);
    numTypeButtonGroup.add(integerRadioButton);
    numTypeButtonGroup.add(fractionRadioButton);
    
    textAreaPanel.add(originalListLabel, createConstraints(0, 0));
    textAreaPanel.add(originalListTextArea, createConstraints(1, 0));
    textAreaPanel.add(sortedListLabel, createConstraints(0, 1));
    textAreaPanel.add(sortedListTextArea, createConstraints(1, 1));
    
    buttonPanel.add(performButton);
    
    sortPanel.add(ascendingRadioButton);
    sortPanel.add(descendingRadioButton);
    numericPanel.add(integerRadioButton);
    numericPanel.add(fractionRadioButton);
    radioButtonPanel.add(sortPanel);
    radioButtonPanel.add(numericPanel);
    
    frame.add(textAreaPanel, PAGE_START);
    frame.add(buttonPanel, CENTER);
    frame.add(radioButtonPanel, PAGE_END);
    
    frame.display();
  }
  
  /**
   * Method to create {@link GridBagConstraints}.
   * 
   * @param x x-axis location
   * @param y 7-axis location
   * @return the {@link GridBagConstraings}
   */
  private GridBagConstraints createConstraints(int x, int y) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.fill = HORIZONTAL;
    gbc.anchor = x == 0 ? WEST : EAST;
    gbc.insets = new Insets(3, 3, 3, 3);
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    return gbc;
  }
}
