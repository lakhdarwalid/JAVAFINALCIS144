
package finalprojectcontroller;

import finalprojectmodel.*;
import finalprojectview.EmployeeGUI;

public class FinalProjectController {

    static Employee emp;
    static EmployeeCRUD CRUD; 
    
    public static void main(String[] args) {
        /*
       boolean x=false;
       emp=new Employee();
       CRUD=new EmployeeCRUD();
       emp=CRUD.selectEmployee(3);
       if(emp!=null)
       {
          x = CRUD.deleteEmployee(emp.getId());
          if(x)
          {
              System.out.print("You Deleted an Employee!!!");
          }
          else
          {
              System.out.print("You Couldn't Delete!!!");
          }
       }
       else
       {
           System.out.println("Employee not found!!!!");
       }*/
        
       new EmployeeGUI();
    }
    
}
