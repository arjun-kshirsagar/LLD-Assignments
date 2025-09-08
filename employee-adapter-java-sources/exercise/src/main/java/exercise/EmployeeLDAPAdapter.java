package exercise;

public class EmployeeLDAPAdapter implements Employee {
    private EmployeeLDAP e;
    public EmployeeLDAPAdapter(EmployeeLDAP e){
        this.e = e;
    }

    @Override
    public String getId(){
        return e.get("uid");
    }

    @Override
    public String getFirstName(){
        return e.get("givenName");
    }

    @Override
    public String getLastName(){
        return e.get("sn");
    }
    
    @Override
    public String getEmail(){
        return e.get("mail");
    }
    
}
