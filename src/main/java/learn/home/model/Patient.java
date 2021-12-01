package learn.home.model;

public class Patient {

    private Integer id;
    private String fName;
    private String lName;
    private String cEmail;
    private String phoneNumber;

    public Patient() {
    }

    public Patient(String fName, String lName, String cEmail, String phoneNumber) {
        this.fName = fName;
        this.lName = lName;
        this.cEmail = cEmail;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return cEmail;
    }

    public void setEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
