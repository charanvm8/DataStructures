package mvcPractice.model;

public class EmployeeController {

    private Employee1 emp;
    private EmployeeView empView;

    public EmployeeController(Employee1 employee,EmployeeView empView){
        this.emp = employee;
        this.empView = empView;
    }

    public String getEmployeeName() {
        return emp.getFirstName();
    }
    public void setEmployeeName(String name) {
        emp.setFirstName(name);
    }
    public int getEmployeeId() {
        return emp.getEmployeeId();
    }
    public void setEmployeeId(int id) {
        emp.setEmployeeId(id);
    }

    public void view(){
        empView.printEmployeeDetails(emp.getFirstName(),emp.getEmployeeId());
    }
}
