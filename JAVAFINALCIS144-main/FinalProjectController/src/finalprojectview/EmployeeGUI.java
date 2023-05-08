
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
    private Employee emp2;
    private EmployeeCRUD crud = new EmployeeCRUD();
    
    private JTabbedPane tp;
    private JPanel insertPanel;
    private JPanel selectPanel;
    
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
    
    
    // Components of panel 2 (select and delete)
    private JLabel lblTitle2;
    private JLabel lblLname2;
    private JLabel lblFname2;
    private JLabel lblAddress12;
    private JLabel lblAddress22;
    private JLabel lblCity2;
    private JLabel lblState2;
    private JLabel lblDOB2;
    private JLabel lblSalary2;
    private JLabel lblID;
    
    private JTextField txtLname2;
    private JTextField txtFname2;
    private JTextField txtAddress12;
    private JTextField txtAddress22;
    private JTextField txtCity2;
    private JTextField txtState2;
    private JTextField txtDOB2;
    private JTextField txtSalary2;
    private JTextField txtID;    
    
    private JButton btnSearch;
    private JButton btnDelete;
    private JButton btnClear2;
    
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
        btnClear.addActionListener(new Clear());
        btnClear.setBounds(230, 385, 130, 25);
        insertPanel.add(btnClear);
        
        
        //setup Select and delete panel
        selectPanel = new JPanel();
        selectPanel.setLayout(null);
        
        selectPanel.setSize(400, 480);
        lblTitle2 = new JLabel("EMPLOYEE SEARCH AND DELETE");
        lblTitle2.setFont(new Font("Verdana", Font.BOLD, 16));
        lblTitle2.setHorizontalAlignment(JLabel.CENTER);
        lblTitle2.setForeground(Color.BLUE);
        lblTitle2.setBounds(80, 20, 220, 30);
        selectPanel.add(lblTitle2);
        
        lblID = new JLabel("Emp ID: ");
        txtID = new JTextField(20);
        lblID.setHorizontalAlignment(JLabel.RIGHT);
        lblID.setBounds(100, 50, 100, 25);
        txtID.setBounds(200, 50, 100, 25);
        txtID.requestFocus();
        selectPanel.add(lblID);
        selectPanel.add(txtID);
        
        lblLname2 = new JLabel("Last Name: ");
        txtLname2 = new JTextField(20);
        lblLname2.setHorizontalAlignment(JLabel.RIGHT);
        lblLname2.setBounds(100, 100, 100, 25);
        txtLname2.setBounds(200, 100, 100, 25);
        txtLname2.setEditable(false);
        selectPanel.add(lblLname2);
        selectPanel.add(txtLname2);
        
        lblFname2 = new JLabel("First Name: ");
        txtFname2 = new JTextField(20);
        lblFname2.setHorizontalAlignment(JLabel.RIGHT);
        lblFname2.setBounds(100, 140, 100, 25);
        txtFname2.setBounds(200, 140, 100, 25);
        txtFname2.setEditable(false);
        selectPanel.add(lblFname2);
        selectPanel.add(txtFname2);
        
        lblAddress12 = new JLabel("Address 1: ");
        txtAddress12 = new JTextField(20);
        lblAddress12.setHorizontalAlignment(JLabel.RIGHT);
        lblAddress12.setBounds(100, 175, 100, 25);
        txtAddress12.setBounds(200, 175, 100, 25);
        txtAddress12.setEditable(false);
        selectPanel.add(lblAddress12);
        selectPanel.add(txtAddress12);
        
        lblAddress22 = new JLabel("Address 2:");
        txtAddress22 = new JTextField(20);
        lblAddress22.setHorizontalAlignment(JLabel.RIGHT);
        lblAddress22.setBounds(100, 210, 100, 25);
        txtAddress22.setBounds(200, 210, 100, 25);
        txtAddress22.setEditable(false);
        selectPanel.add(lblAddress22);
        selectPanel.add(txtAddress22);
        
        lblCity2 = new JLabel("City: ");
        txtCity2 = new JTextField(20);
        lblCity2.setHorizontalAlignment(JLabel.RIGHT);
        lblCity2.setBounds(100, 245, 100, 25);
        txtCity2.setBounds(200, 245, 100, 25);
        txtCity2.setEditable(false);
        selectPanel.add(lblCity2);
        selectPanel.add(txtCity2);
        
        lblState2 = new JLabel("State: ");
        txtState2 = new JTextField(20);
        lblState2.setHorizontalAlignment(JLabel.RIGHT);
        lblState2.setBounds(100, 280, 100, 25);
        txtState2.setBounds(200, 280, 100, 25);
        txtState2.setEditable(false);
        selectPanel.add(lblState2);
        selectPanel.add(txtState2);
        
        lblDOB2 = new JLabel("D.O.B: ");
        txtDOB2 = new JTextField(20);
        lblDOB2.setHorizontalAlignment(JLabel.RIGHT);
        lblDOB2.setBounds(100, 315, 100, 25);
        txtDOB2.setBounds(200, 315, 100, 25);
        txtDOB2.setEditable(false);
        selectPanel.add(lblDOB2);
        selectPanel.add(txtDOB2);
        
        lblSalary2 = new JLabel("Salary: ");
        txtSalary2 = new JTextField(20);
        lblSalary2.setHorizontalAlignment(JLabel.RIGHT);
        lblSalary2.setBounds(100, 350, 100, 25);
        txtSalary2.setBounds(200, 350, 100, 25);
        txtSalary2.setEditable(false);
        selectPanel.add(lblSalary2);
        selectPanel.add(txtSalary2);
          
       
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(new Search());
        btnSearch.setBounds(80, 390, 80, 25);
        selectPanel.add(btnSearch);
        
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new Delete());
        btnDelete.setBounds(175, 390, 80, 25);
        selectPanel.add(btnDelete);
        
        btnClear2 = new JButton("Clear");
        btnClear2.addActionListener(new Clear());
        btnClear2.setBounds(270, 390, 80, 25);
        selectPanel.add(btnClear2);
        
        
        tp.setBounds(0, 0, 400, 480);
        tp.addTab("Insert", insertPanel);
        tp.addTab("Search/Del", selectPanel);
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
    
    public class Clear implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            txtLname.setText("");
            txtFname.setText("");            
            txtAddress1.setText("");         
            txtAddress2.setText("");         
            txtCity.setText("");
            txtState.setText("");            
            txtDOB.setText("");
            txtSalary.setText("");       
        }
    
    }
    
    
    public class Search implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Searchin ...");
            int empId = Integer.parseInt(txtID.getText());
            emp2 = crud.selectEmployee(empId);
            if (emp2 != null){
                txtLname2.setText(emp2.getLname());
                txtFname2.setText(emp2.getFname());            
                txtAddress12.setText(emp2.getAddress1());         
                txtAddress22.setText(emp2.getAddress2());         
                txtCity2.setText(emp2.getCity());
                txtState2.setText(emp2.getState());            
                txtDOB2.setText(emp2.getDOB());
                txtSalary2.setText(""+emp2.getSalary()); 
                
            }
            else{
                txtID.setText("");
                txtID.requestFocus();
                JOptionPane.showMessageDialog(null, "Employee not found !!");
            }
        }
    
    }
    
    public class Delete implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
        }
    
    }
    
} 
   

