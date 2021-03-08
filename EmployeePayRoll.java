import Library.EmployeePayRollData;
import Library.EmployeePayroll;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayRoll {
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_ID}
    private list<EmployeePayRollData>employeePayRollList;
    public EmployeePayRollServices() {

    }
    public EmployeePayRoll<EmployeePayRollData>employeePayrollList){

    }
    public static void main(String[] args){
        ArrayList<EmployeePayrollData> employeePayrollList=new ArrayList<>();
        Scanner consoleInputReader = new Scanner(System.in);
        EmployeePayroll.readEmployeePayrollData(consoleInputReader);
        EmployeePayroll.writeEmployeePayrollData();
    }
    private void readEmployeePayrollData(Scanner consoleInputReader){
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter EMployee Name: ");
        String name = consoleInputReader.nextDouble();
        employeePayrollList.add (new EmployeePayRollDate(id, name, salary));
    }
    private void writeEmployeePayrollData(){
        System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);

    }

    private class list<T> {
    }

    private class EmployeePayRollDate {
        public EmployeePayRollDate(int id, String name, Object p2) {
        }
    }
}

