package pojos.US27_Pojos;

public class MessagesPojo
{
    /*
    {
        "id": 71932,
        "name": "Louvenia",
        "email": "rayford.cremin@gmail.com",
        "subject": "Mushroom Five",
        "message": "Gary Blauman"
    }
     */

   private String id;
   private String name;
   private String email;
   private String subject;
   private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessagesPojo() {}

    public MessagesPojo(String id, String name, String email, String subject, String message)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public MessagesPojo(String name, String email, String subject, String message)
    {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
