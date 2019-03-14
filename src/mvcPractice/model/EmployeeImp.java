package mvcPractice.model;


public class EmployeeImp {

    public static void main(String[] args){
        Employee1 emp = getEmployeeFromDatabase();
        EmployeeView empView = new EmployeeView();

        EmployeeController empCtrl = new EmployeeController(emp,empView);

        empCtrl.view();

        empCtrl.setEmployeeId(5);

        empCtrl.view();
    }

    public static Employee1 getEmployeeFromDatabase() {
        Employee1 employee = new Employee1();
        employee.setFirstName("David");
        employee.setEmployeeId(1);
        return employee;
    }

}
