import Library.EmployeePayRollData;
import org.junit.jupiter.api.Test;

public class EmployeePayrollTest {
    @Test
    void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayRollData[] arrayOfEmps={
                new EmployeePayRollData(1,"Jeff Bezos", 100000.0),
                new EmployeePayRollData(2,"Bill Gates", 200000.0);
                new EmployeePayRollData(3,"Mark Zuckerberg", 300000.0);
        };
        EmployeePayrollTest employeePayrollTest;
        employeePayrollTest= new EmployeePayrollTest(Array.asList(arryOfEmps));
        employeePayrollTest.writeEmployeePayrollData(FILE_IO);
        employeePayrollTest.PrintData(FILE_IO);
        long entries = employeePayrollTest.countEntries(FILE_IO);
        Assert.assertEquals(3,entries);
    }

    @Test
    void void givenFileOnReadingFromFileShoukdMathEmployeeCount() {
        EmployeePayrollTest employeePayrollTest = new EmployeePayrollTest();
        long entries = employeePayrollTest.readEmployeePayrollData(FILE_IO);
        assert.AssertEquals(3,entries);
    }
}
