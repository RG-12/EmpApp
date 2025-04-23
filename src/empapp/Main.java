package empapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int id;
        double salary;
        int age;
        EmployeeDaoIntrf dao=new EmployeeDaoImpl();
        System.out.println("---------------------------------------");
        System.out.println("Welcome to EmpApp!");
        System.out.println("---------------------------------------");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Add an Employee\n" +
                    "2. Show All Employees\n" +
                    "3. Show Employee based on ID \n" +
                    "4. Update credentials of a Employee\n" +
                    "5. Delete an Employee\n" +
                    "6. Exit\n" +
                    "---------------------------------------");

            System.out.println("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    Employee emp=new Employee();
                    System.out.println("Enter ID: ");
                    id=sc.nextInt();
                    System.out.println("Enter name: ");
                    sc.nextLine();
                    name=sc.nextLine();
                    System.out.println("Enter Salary: ");
                    salary=sc.nextDouble();
                    System.out.println("Enter age: ");
                    age=sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter ID to show the details: ");
                    int empid=sc.nextInt();
                    dao.showEmployeeBasedOnID(empid);
                    break;
                case 4:
                    System.out.println("Enter ID to update the details: ");
                    int empid1=sc.nextInt();
                    System.out.println("Enter the new name:");
                    sc.nextLine();
                    name=sc.nextLine();
                    System.out.println("Enter the new salary:");
                    salary = sc.nextDouble();
                    System.out.println("Enter the new age:");
                    age = sc.nextInt();
                    dao.updateEmployee(empid1,name,salary,age);
                    break;
                case 5:
                    System.out.println("Enter the ID to delete");
                    id=sc.nextInt();
                    dao.deleteEmployee(id);
                    break;

                case 6:
                    System.out.println("Thank you for using our Application!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice!");
                    break;


            }

        }while (true);


    }
}
