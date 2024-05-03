import java.io.File;

public class Ticket extends Person {  //public class tickets and inherited person
    int row;//objects
    int seatNumber;
    double price;

    Ticket(Person person, int row,int seatNumber,double price){//constructors
        super(person.getname(),person.getsurName(),person.getemail());
        this.row = row;
        this.seatNumber = seatNumber;
        this.price = price;
    }
    //getters and setters
    public int getRow(){
        return this.row;
    }
    public void setrow(int row){
        this.row = row;
    }
    public int getSeatNumber(){
        return this.seatNumber;
    }
    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }
    public double getPrice(){
        return this.price;
    }
    public void setprice(Double price){
        this.price = price;
    }


    //method name as print
    public  void print(){
        System.out.println("-----Ticket information-----");
        System.out.println("Name: "+getname());
        System.out.println("Surname: "+getsurName());
        System.out.println("email: "+getemail());
        System.out.println("Row number: "+row);
        System.out.println("Seat number: "+seatNumber);
        System.out.println("Amount : $"+price);
    }

    public static int size() {
        return 0;
    }

    public int getrowNumber() {
        return 0;
    }

    public File getPerson() {
        return null;
    }
}
