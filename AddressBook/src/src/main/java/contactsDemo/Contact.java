package contactsDemo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Contact {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)String id;
    //private @Id String id;
    private String firstname;
    private String familyname;
    private String phonenumber;
    private String email;


    public Contact(String firstname, String familyname, String phonenumber, String email) {
        //this.id = id;
        this.firstname = firstname;
        this.familyname = familyname;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public Contact(){};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

