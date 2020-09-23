package view;

import control.MainController;
import model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelHandler {
    private JPanel panel;
    private JButton createButton;
    private JButton editButton;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField salaryField;
    private JTextField employmentField;
    private JTextField workField;
    private JTextArea currentEmployeeField;
    private JComboBox employeeChoiceBox;
    private MainController mainController;
    //TODO add a CreateWork-Button with Work-Class
    //TODO add a removeEmployee-Button to delete the entry
    public PanelHandler(MainController mainController) {
        this.mainController=mainController;
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.createEmployee(nameField.getText(),ageField.getText(),salaryField.getText(),employmentField.getText(),workField.getText());
                updateGUI();

            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.updateEmployee(nameField.getText(),ageField.getText(),salaryField.getText(),employmentField.getText(),workField.getText());
                updateGUI();
            }
        });
        employeeChoiceBox=new JComboBox(mainController.getEmployees().toArray());
        employeeChoiceBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //TODO ändere das currentEmployee
                mainController.setCurrentEmployee((Employee)(employeeChoiceBox.getSelectedItem()));
            }
        });
    }
    public JComboBox getEmployeeChoiceBox() {
        return employeeChoiceBox;
    }
    public void setEmployeeChoiceBox(JComboBox employeeChoiceBox) {
        this.employeeChoiceBox = employeeChoiceBox;
    }
    private void updateGUI(){
        //output.setText(mainController.getS());
        currentEmployeeField.setText(mainController.getEmployeeString());
    }
    public JPanel getPanel(){
        return panel;
    }
}
