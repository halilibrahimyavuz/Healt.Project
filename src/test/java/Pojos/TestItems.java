package Pojos;

import io.cucumber.java.sl.In;

public class TestItems {

    /*
    "createdBy": "medunnaadmin",
            "createdDate": "2022-03-16T22:55:47.152296Z",
            "id": 30198,
            "name": "Na111",
            "description": "",
            "price": 50.00,
            "defaultValMin": "66",
            "defaultValMax": "100"

     */
    private String name;
    private String description;
    private Integer price;
    private String defaultValMin;
    private String defaultValMax;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDefaultValMin() {
        return defaultValMin;
    }

    public void setDefaultValMin(String defaultValMin) {
        this.defaultValMin = defaultValMin;
    }


    public String getDefaultValMax() {
        return defaultValMax;
    }

    public void setDefaultValMax(String defaultValMax) {
        this.defaultValMax = defaultValMax;
    }

    public TestItems() {
    }

    public TestItems(String name, String description, Integer price, String defaultValMin, String defaultValMax) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.defaultValMin = defaultValMin;
        this.defaultValMax = defaultValMax;
    }

    @Override
    public String toString() {
        return "TestItems{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", defaultValMin='" + defaultValMin + '\'' +
                ", defaultValMax='" + defaultValMax + '\'' +
                '}';
    }

}