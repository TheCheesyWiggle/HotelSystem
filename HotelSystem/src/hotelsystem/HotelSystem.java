
package hotelsystem;

import java.util.*;

public class HotelSystem {
    
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Booking> Bookinglist = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("Welcome to your virtual check-in");
        while(true){
            System.out.println("Please press a number to continue");
            System.out.println("1- Start");
            System.out.println("2- Edit Booking");
            System.out.println("3- View Booking");
            System.out.println("0 - Exit");

            int userChoice = input.nextInt();

            switch(userChoice){
                case 1:
                    booking();
                    break;
                case 2:
                    editBooking();   
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
    public static void booking(){
        System.out.println("Please enter your full name: ");
        String name = input.next();
        System.out.println("Please enter the number of days you would like to stay :");
        input.nextLine();
        int days = input.nextInt();
        String roomType = roomType();
        String board = board();
        double price = 0;
        Booking myBooking = new Booking(name,roomType,board,price,days);
        Bookinglist.add(myBooking);
        price(index(name),days);
        
        System.out.println(myBooking.toString());
    }
    
    public static void viewBooking(){
        if(Bookinglist.isEmpty()){
            System.out.println("Sorry there are no bookings in this directory");
        }
        else{
            for (int i = 0; i < Bookinglist.size(); i++) {
                System.out.println(Bookinglist.get(i).toString());
            }
        }
    }
    
    public static void editBooking() {
        

        System.out.println("Enter your full name");
        String name = input.next();
        
        int index = index(name); 
       
        if(index != -1){
            System.out.println("What would you like to edit?");
            System.out.println("1 - name");
            System.out.println("2 - Room type");
            System.out.println("3 - Board");
            System.out.println("4 - price");
            System.out.println("5 - number of Days");

            int userChoice = input.nextInt();

            switch(userChoice){
                case 1:
                    System.out.println("Please type in a name");
                    String newName = input.nextLine();
                    Bookinglist.get(index).setName(newName);
                    break;
                case 2:
                    String newRoomType = roomType();
                    Bookinglist.get(index).setRoomType(newRoomType);
                    break;
                case 3:
                    String newBoard = board();
                    Bookinglist.get(index).setBoard(newBoard);
                    break;
                case 4:
                    System.out.println("Please type in the number of days of your stay");
                    int newDays = input.nextInt();
                    Bookinglist.get(index).setDays(newDays);
                    break;
            }
            price(index,Bookinglist.get(index).getDays());
        }
        else{
            System.out.println("Book not found");
        }
    }
    
    public static String roomType(){
        System.out.println("What type of room would you like?");
        System.out.println("1- Single (1 person)");
        System.out.println("2- Double (2 people)");
        System.out.println("3- Family (4 people)");
        System.out.println("0 - Exit");
        int userChoice = input.nextInt();
        String roomType = null;
        switch(userChoice){
            case 1:
                roomType = "Single room (1 person)";
                break;
            case 2:
                roomType = "Double room (2 people)";
                break;
            case 3:
                roomType = "Family room (4 people)";
                break;
            case 0:
                System.exit(0);
                break;
        }
        return roomType;
    }
    
    public static String board(){
        System.out.println("What type of board would you like?");
        System.out.println("1- Self serve");
        System.out.println("2- Half-board");
        System.out.println("3- Full-board");
        System.out.println("0 - Exit");
        int userChoice = input.nextInt();
        String board = null;
        switch(userChoice){
            case 1:
                board = "Self serve";
                break;
            case 2:
                board = "Half-board";
                break;
            case 3:
                board = "Full-board";
                break;
            case 0:
                System.exit(0);
                break;
        }
        return board;
    }
    
    public static int index(String name){
        int index = -1; 
        
        if(!Bookinglist.isEmpty()){
            for (int i = 0; i < Bookinglist.size(); i++) {
                if(name.toUpperCase().equals(Bookinglist.get(i).getName().toUpperCase())){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    
    public static void price(int index, int days){
        double price = 0;
        if(index != -1){
            String roomType = ""+Bookinglist.get(index).getRoomType().charAt(0);
            String board = ""+Bookinglist.get(index).getBoard().charAt(0);
            switch(roomType){
                case "S":
                    price = 50;
                    break;
                case "D":
                    price = 75;
                    break;
                case "F":
                    price = 105;
                    break;
            }
            switch(board){
                case "S":
                    break;
                case "H":
                    price = price+10;
                    break;
                case "F":
                    price = price+20;
                    break;
            }
        }
        price = price*days;
        if(days>7){
            price = (price*7)+((price*(days-7)*0.8));
        }
        Bookinglist.get(index).setPrice(price);
    }
}
