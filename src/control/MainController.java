package control;

import model.Employee;
import view.PanelHandler;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainController {
    //TODO move to Model
    private Employee currentEmployee;
    private ArrayList<Employee> employees;  //müsste eigentlich in Model
    private DefaultComboBoxModel employeeNames; //müsste eigentlich in Model
    private PanelHandler panelHandler;
    public MainController(){
        employees=new ArrayList<Employee>();
    }

    public void createEmployee (String pName, String pAge, String pSalary, String pEmployment, String pWork) {
        try {
            currentEmployee = new Employee(pName, Integer.parseInt(pAge), Double.parseDouble(pSalary), Double.parseDouble(pEmployment), pWork);
            //TODO einspeichern des currentEmployees und hinzufügen zur des currentEmployees zur ComboBox
            employees.add(currentEmployee);
            for(int i=0;i<employees.toArray().length;i++){
                employeeNames.addElement(employees.get(i));
            }
            panelHandler.setEmployeeChoiceBox(new JComboBox(employeeNames));
        } catch (Exception e) {
            System.err.println("Bitte gebe korrekte Eingaben an");
        }
    }

    public String getEmployeeString (){
        try {
            return "Employee: " + currentEmployee.getName()+"\n\tAge: "+ currentEmployee.getAge()+"\n\tSalary: "+ currentEmployee.getSalary()+"\n\tEmployment: "+ currentEmployee.getEmploymentTime()+"\n\tWork: "+ currentEmployee.getCurrentWork();
        } catch (Exception e) {
            System.err.println("Konnte Angestellten nicht als Text ausgeben");
            return "";
        }
    }
    public void updateEmployee (String pName, String pAge, String pSalary, String pEmployment, String pWork) {
        currentEmployee.setName(pName);
        currentEmployee.setAge(Integer.parseInt(pAge));
        currentEmployee.setSalary(Double.parseDouble(pSalary));
        currentEmployee.setEmploymentTime(Double.parseDouble(pEmployment));
        currentEmployee.setCurrentWork(pWork);
    }

    public ArrayList<Employee> getEmployees (){
        return employees;
    }
    public void setPanelHandler(PanelHandler panelHandler) {
        this.panelHandler = panelHandler;
    }
    public Employee getCurrentEmployee() {
        return currentEmployee;
    }
    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
