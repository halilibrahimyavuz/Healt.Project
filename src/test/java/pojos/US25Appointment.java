package pojos;

public class US25Appointment {

    private String firstname;
    private String lastname;
    private String Ssn;
    private String email;
    private String phone;
    private String  DateTime;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSsn() {
        return Ssn;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSsn(String ssn) {
        Ssn = ssn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public US25Appointment() {
    }

    public US25Appointment(String firstname, String lastname, String ssn, String email, String phone, String dateTime) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.Ssn = ssn;
        this.email = email;
        this.phone = phone;
        this.DateTime = dateTime;
    }

    @Override
    public String toString() {
        return "US25Appointment{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", Ssn='" + Ssn + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", DateTime='" + DateTime + '\'' +
                '}';
    }
}
