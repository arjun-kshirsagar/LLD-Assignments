package exercise;

public class EmployeeDBAdapter implements Employee {
    private EmployeeDB e;
    public EmployeeDBAdapter(EmployeeDB e){
        this.e = e;
    }

    @Override
    public String getId(){
        return String.valueOf(e.getId());
    }

    @Override
    public String getFirstName(){
        return e.getFirstName();
    }

    @Override
    public String getLastName(){
        return e.getSurname();
    }
    
    @Override
    public String getEmail(){
        return e.getEmailAddress();
    }
    
}
