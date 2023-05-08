
package finalprojectview;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import finalprojectmodel.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeGUI extends JFrame {
    
    public static final int width = 410;
    public static final int height = 510;
    
    private Employee emp;
    private EmployeeCRUD crud = new EmployeeCRUD();
    
    private JTabbedPane tp;
    private JPanel insertPanel;
    
    // Components of panel 1 (insert)
    private JLabel lblTitle;
    private JLabel lblLname;
    private JLabel lblFname;
    private JLabel lblAddress1;
    private JLabel lblAddress2;
    private JLabel lblCity;
    private JLabel lblState;
    private JLabel lblDOB;
    private JLabel lblSalary;
    
    private JTextField txtLname;
    private JTextField txtFname;
    private JTextField txtAddress1;
    private JTextField txtAddress2;
    private JTextField txtCity;
    private JTextField txtState;
    private JTextField txtDOB;
    private JTextField txtSalary;
    
    private JButton btnSave;
    private JButton btnClear;
    
    public EmployeeGUI () { 
        super();
        createPanel();
        setFrame();
    }
    
    private void createPanel(){
        super.setLayout(null);
        tp = new JTabbedPane();
        insertPanel = new JPanel();
        insertPanel.setLayout(null);
        
        // Setup insertPanel
        insertPanel.setSize(400, 480);
        lblTitle = new JLabel("EMPLOYEE INPUT DATA");
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 16));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setBounds(80, 20, 220, 30);
        insertPanel.add(lblTitle);
        
        lblLname = new JLabel("Last Name: ");
        txtLname = new JTextField(20);
        lblLname.setHorizontalAlignment(JLabel.RIGHT);
        lblLname.setBounds(100, 100, 100, 25);
        txtLname.setBounds(200, 100, 100, 25);
        insertPanel.add(lblLname);
        insertPanel.add(txtLname);
        
        lblFname = new JLabel("First Name: ");
        txtFname = new JTextField(20);
        lblFname.setHorizontalAlignment(JLabel.RIGHT);
        lblFname.setBounds(100, 140, 100, 25);
        txtFname.setBounds(200, 140, 100, 25);
        insertPanel.add(lblFname);
        insertPanel.add(txtFname);
        
        lblAddress1 = new JLabel("Address 1: ");
        txtAddress1 = new JTextField(20);
        lblAddress1.setHorizontalAlignment(JLabel.RIGHT);
        lblAddress1.setBounds(100, 175, 100, 25);
        txtAddress1.setBounds(200, 175, 100, 25);
        insertPanel.add(lblAddress1);
        insertPanel.add(txtAddress1);
        
        lblAddress2 = new JLabel("Address 2:");
        txtAddress2 = new JTextField(20);
        lblAddress2.setHorizontalAlignment(JLabel.RIGHT);
        lblAddress2.setBounds(100, 210, 100, 25);
        txtAddress2.setBounds(200, 210, 100, 25);
        insertPanel.add(lblAddress2);
        insertPanel.add(txtAddress2);
        
        lblCity = new JLabel("City: ");
        txtCity = new JTextField(20);
        lblCity.setHorizontalAlignment(JLabel.RIGHT);
        lblCity.setBounds(100, 245, 100, 25);
        txtCity.setBounds(200, 245, 100, 25);
        insertPanel.add(lblCity);
        insertPanel.add(txtCity);
        
        lblState = new JLabel("State: ");
        txtState = new JTextField(20);
        lblState.setHorizontalAlignment(JLabel.RIGHT);
        lblState.setBounds(100, 280, 100, 25);
        txtState.setBounds(200, 280, 100, 25);
        insertPanel.add(lblState);
        insertPanel.add(txtState);
        
        lblDOB = new JLabel("D.O.B: ");
        txtDOB = new JTextField(20);
        lblDOB.setHorizontalAlignment(JLabel.RIGHT);
        lblDOB.setBounds(100, 315, 100, 25);
        txtDOB.setBounds(200, 315, 100, 25);
        insertPanel.add(lblDOB);
        insertPanel.add(txtDOB);
        
        lblSalary = new JLabel("Salary: ");
        txtSalary = new JTextField(20);
        lblSalary.setHorizontalAlignment(JLabel.RIGHT);
        lblSalary.setBounds(100, 350, 100, 25);
        txtSalary.setBounds(200, 350, 100, 25);
        insertPanel.add(lblSalary);
        insertPanel.add(txtSalary);
       
       
        btnSave = new JButton("Save Employee");
        btnSave.addActionListener(new Save());
        btnSave.setBounds(80, 385, 130, 25);
        insertPanel.add(btnSave);
        
        btnClear = new JButton("Clear");
       // btnClear.addActionListener(new Clear());
        btnClear.setBounds(230, 385, 130, 25);
        insertPanel.add(btnClear);
        
        
        
        
        
        
        tp.setBounds(0, 0, 400, 480);
        tp.addTab("Insert", insertPanel);
        this.add(tp);
        this.pack();
       
       
    }
    
    private void setFrame(){
        super.setTitle("Employee Dta Entry App ver 1.0");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocation(200, 100);
        super.setSize(width, height);
        super.setVisible(true);
    }
     
    private class Save implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String lname = txtLname.getText();
            String lfname = txtFname.getText();
            String address1 = txtAddress1.getText();
            String address2 = txtAddress2.getText();
            String city = txtCity.getText();
            String state = txtState.getText();
            String dob = txtDOB.getText();
            double salary = Double.parseDouble(txtSalary.getText());
            
            emp = new Employee(lname, lfname, address1, address2, city, state, dob, salary);
            
            try{
               crud.insertEmployee(emp);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
    
    
    }
    
} 
   

