package Pojos;

public class TestItems {

/*"createdBy": "medunnaadmin",
        "createdDate": "2022-03-16T22:55:47.152296Z",
        "id": 30198,
        "name": "Na111",
        "description": "",
        "price": 50.00,
        "defaultValMin": "66",
        "defaultValMax": "100"

 */

    private String createdDate;
    private String name;
    private String description;
    private String price;
    private String nadefaultValMinme;
    private String defaultValMax;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNadefaultValMinme() {
        return nadefaultValMinme;
    }

    public void setNadefaultValMinme(String nadefaultValMinme) {
        this.nadefaultValMinme = nadefaultValMinme;
    }

    public String getDefaultValMax() {
        return defaultValMax;
    }

    public void setDefaultValMax(String defaultValMax) {
        this.defaultValMax = defaultValMax;
    }

    public TestItems(String createdDate, String name, String description, String price, String nadefaultValMinme, String defaultValMax) {
        this.createdDate = createdDate;
        this.name = name;
        this.description = description;
        this.price = price;
        this.nadefaultValMinme = nadefaultValMinme;
        this.defaultValMax = defaultValMax;
    }

    public TestItems() {
    }

    @Override
    public String toString() {
        return "testPojo{" +
                "createdDate='" + createdDate + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", nadefaultValMinme='" + nadefaultValMinme + '\'' +
                ", defaultValMax='" + defaultValMax + '\'' +
                '}';

    }
}