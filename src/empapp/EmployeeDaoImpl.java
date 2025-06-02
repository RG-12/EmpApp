package empapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class EmployeeDaoImpl implements EmployeeDaoIntrf {
    Connection con;

    @Override
    public void createEmployee(Employee emp) {
        con =DBConnection.createDBConnetion();
        String query="INSERT INTO employee VALUES(?,?,?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Added Successfully!");


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showAllEmployee() {
        con=DBConnection.createDBConnetion();
        String query="SELECT * FROM employee";
        System.out.println("Employee Details: ");
        System.out.println("Employee Details: ");
        System.out.println("---------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\n","ID","Name        ","Salary","        Age");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));


            }
            System.out.println("---------------------------------------------");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con=DBConnection.createDBConnetion();
        String query="SELECT * FROM employee WHERE id="+id;
        System.out.println("Employee Details: ");
        System.out.println("---------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\n","ID","Name        ","Salary","        Age");
        System.out.println("---------------------------------------------");
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name, double salary, int age) {
        con=DBConnection.createDBConnetion();
        String query="UPDATE employee SET name=?, salary=?, age=? WHERE id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setDouble(2,salary);
            pstm.setInt(3,age);
            pstm.setInt(4,id);
            int cnt = pstm.executeUpdate();
            if(cnt!=0) {
                System.out.println("Employee details updated successfully.");
                System.out.println("---------------------------------------------");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        con=DBConnection.createDBConnetion();
        String query="DELETE FROM employee WHERE id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt= pstm.executeUpdate();
            if(cnt!=0) {
                System.out.println("Employee Deleted Successfully. " + id);
                System.out.println("---------------------------------------------");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}

    }
}
