
package finalprojectmodel;

import java.sql.*;


public class EmployeeCRUD {
    private String jdbcURL="jdbc:mysql://localhost:3306/cis144sp";
    private String jdbcUsername="root";
    private String jdbcPassword="";
    
    private static String DELETE_EMPLOYEE_SQL = "delete from employee where empid=?";
    private static String INSERT_EMPLOYEE_SQL = "insert into Employee(EmpLname, EmpFname, EmpAddress1," +
                                  "EmpAddress2, EmpCity, EmpState, EmpDOB, EmpBaseSalary)" + "values"+
                                   "(?,?,?,?,?,?,?,?);";
    private static String SELECT_EMPLOYEE_BY_ID = "select * from Employee where EmpID=?";
    
    
    public EmployeeCRUD() {    };
    
    protected Connection getConnection()
    {
        Connection conn = null;
        try
        {
            conn=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return conn;
    }
    
    public void insertEmployee(Employee emp) 
    {
        try
        (
         Connection conn =getConnection();
         PreparedStatement ps= conn.prepareStatement(INSERT_EMPLOYEE_SQL);
        )
        {
            ps.setString(1, emp.getLname());
            ps.setString(2, emp.getFname());
            ps.setString(3, emp.getAddress1());
            ps.setString(4, emp.getAddress2());
            ps.setString(5, emp.getCity());
            ps.setString(6, emp.getState());
            ps.setString(7, emp.getDOB());
            ps.setDouble(8, emp.getSalary());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public Employee selectEmployee(int empid)
    {
        Employee employee=null;
        try
        (
         Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_EMPLOYEE_BY_ID);
         
        )
        {
            ps.setInt(1, empid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String Lname = rs.getString("EmpLname");
                String Fname = rs.getString("EmpFname");
                String Address1 = rs.getString("EmpAddress1");
                String Address2 = rs.getString("EmpAddress2");
                String City = rs.getString("EmpCity");
                String State = rs.getString("EmpState");
                String DOB = rs.getString("EmpDOB");
                double Salary = rs.getDouble("EmpBaseSalary");
                employee = new Employee(empid, Lname, Fname, Address1, Address2, City, State, DOB, Salary);
                
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return employee;
    }
    
    public boolean deleteEmployee(int empid)
    {
        boolean rowDeleted = false;
        try
        (
         Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(DELETE_EMPLOYEE_SQL);
        )    
        {
            ps.setInt(1, empid);
            rowDeleted = ps.executeUpdate()>0;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return rowDeleted;
    }
}
