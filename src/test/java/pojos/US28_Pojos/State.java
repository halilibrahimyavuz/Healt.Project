package pojos.US28_Pojos;

public class State {

    /*

    {
        "country": {
            "id": 0,
            "name": "string"
        },
        "id": 0,
        "name": "string"
    }

    */

    private Country country;
    private String id;
    private String name;

    public State() {
    }

    public State(Country country, String id, String name) {
        this.country = country;
        this.id = id;
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

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

    @Override
    public String toString() {
        return "State{" +
                "country=" + country +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
