package pojos.US16_Pojos;

public class RoomsPojo
{
   /*
    {
        "createdBy": "adminsz",
        "createdDate": "2022-04-22T16:27:14.289058Z",
        "id": 81750,
        "roomNumber": 17764,
        "roomType": "DAYCARE",
        "status": true,
        "price": 100.00,
        "description": "add sofabed"
    }
    */

    private String createdBy;
    private String createdDate;
    private String id;
    private String roomNumber;
    private String roomType;
    private String status;
    private String price;
    private String description;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoomsPojo() {}

    public RoomsPojo(String createdBy, String createdDate, String id, String roomNumber, String roomType, String status, String price, String description) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public RoomsPojo(String createdBy, String createdDate, String roomNumber, String roomType, String status, String price, String description) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public RoomsPojo(String roomNumber, String roomType, String status, String price, String description)
    {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public RoomsPojo(String id, String roomNumber, String roomType, String status, String price, String description) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "RoomsPojo{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id='" + id + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", status='" + status + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
