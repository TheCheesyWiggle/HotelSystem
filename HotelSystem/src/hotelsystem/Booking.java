
package hotelsystem;


public class Booking {
    private String name;
    private String roomType;
    private String board;
    private double price;
    private int days;

    public Booking(String name, String roomType, String board, double price, int days) {
        this.name = name;
        this.roomType = roomType;
        this.board = board;
        this.price = price;
        this.days = days;
    }


    public String toString(){
        return name+" , "+roomType+" , "+board+" , "+price+" , "+days;
    }    


    public String getRoomType() {
        return roomType;
    }

    public String getBoard() {
        return board;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
