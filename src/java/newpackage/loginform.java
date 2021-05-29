package newpackage;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name="lign1")
public class loginform {
    private String username,password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    public void Login() {
        if(dbconnection.Validate(username, password)){
            System.out.println("Login successfully");
        }
        else{
            System.out.println("Uername or password is incorrect");
        }
    }


}

