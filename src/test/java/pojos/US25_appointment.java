package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class US25_appointment {

    private String firstname;
    private String lastname;
    private String Ssn;
    private String email;
    private String phone;
    private String DateTime;

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

    public US25_appointment(String firstname, String lastname, String Ssn, String email, String phone, String DateTime) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.Ssn = Ssn;
        this.email = email;
        this.phone = phone;
        this.DateTime = DateTime;
    }

    public US25_appointment() {

    }

    @Override
    public String toString() {
        return "US25_appointment{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", Ssn='" + Ssn + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", DateTime='" + DateTime + '\'' +
                '}';
    }
}

