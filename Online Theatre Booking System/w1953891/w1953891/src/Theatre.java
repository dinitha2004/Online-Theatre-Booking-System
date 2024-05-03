import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Theatre{
    //creating a static arrarylist to hold objects in tickets
    public static  ArrayList <Ticket> tickets = new ArrayList <Ticket>();

    private ArrayList <String> nameList = new ArrayList<>();
  
    public static void main(String[] args) {
        // creating a variable name called theatre to hold objects in Theatres
        Theatre theatre = new Theatre();

        System.out.println("\t\tWelcome to the New Theatre");
        boolean running = true;// used to run the while loop

        //creating 3 string arrays with the lengths of 12,16 and 20 and fill the arrays with "0" using a for loop
        String[] Row1 = new String[12];
        for(int i = 0 ; i<Row1.length;i++){
            Row1[i]="0";
        }
        String[] Row2 = new String[16];
        for(int i = 0 ; i<Row2.length;i++){
            Row2[i]="0";
        }
        String[] Row3 = new String[20];
        for(int i = 0 ; i<Row3.length;i++){
            Row3[i]="0";
        }
        

        
        Scanner sc = new Scanner(System.in);


        //Declaering the main menu
        while(running){
            System.out.println("\n");
            for(int i=0;i<50;i++){
                System.out.print("-");
            }
            System.out.println("\nPlease select an option: ");
            System.out.println("1) Buy a ticket ");
            System.out.println("2) Print seating area ");
            System.out.println("3) Cancel ticket ");
            System.out.println("4) List available seats ");
            System.out.println("5) Save to file ");
            System.out.println("6) Load from file ");
            System.out.println("7) Print ticket information and total price ");
            System.out.println("8) Sort tickets by price ");
            System.out.println("9) viva ");
            System.out.println("\t\t\t0) Quit");
            for(int i=0;i<50;i++){
                System.out.print("-");
            }

            System.out.print("\nselected your option: ");

            int option;//using try catch method to check weather the given input is a interger or not
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input try again.");
                sc.nextLine();

                continue;
            }

            //using switch case method to allow the user to select options from the menu
            switch(option){

                case 0:
                    System.out.println("Quit");
                    running = false;
                    break;
                case 1:
                    System.out.println("\nBuy a tick option is selected\n");
                    theatre.Buy_Ticket(theatre, Row1,Row2, Row3);//calling the functions

                    break;
                case 2:
                    System.out.println("Print seating area option is selected: ");
                    seating_area(Row1,Row2,Row3);//calling the functions
                    break;
                case 3:
                    System.out.println("Cancel ticket option is selected: ");
                    Delete_Ticket(theatre, Row1, Row2, Row3);//calling the functions
                    break;
                case 4:
                    System.out.println("List available seats option is selected: ");
                    available_seats(Row1, Row2, Row3);//calling the functions

                    break;
                case 5:
                    System.out.println("Save to file option is selected: ");
                    save_textfile(Row1, Row2, Row3);//calling the functions
                    break;
                case 6:
                    System.out.println("Load from file option is selected: ");
                    load_textfile(Row1, Row2, Row3);//calling the functions
                    break;
                case 7:
                    System.out.println("Print ticket information and total price option is selected: ");
                    theatre.ticket_Info(Row1, Row2, Row3);//calling the functions
                    break;
                case 8:
                    System.out.println("Sort tickets by price option is selected: ");
                    theatre.sortInfo(Row1, Row2, Row3);//calling the functions
                    break;

                case 9:
                    System.out.println("viva option is selected: ");
                    theatre.viva();
                
                    break;
                default:
                    System.out.println("\nInvalid option\n");
                    break;

            }
        }
    }

    public void viva(){
        nameList.add("chathura");
        nameList.add("odaijas");
        nameList.add("asjd");
        nameList.add("asdj");
        nameList.add("aosidj");
        nameList.add("oiasjd");

        for(int i = 0 ; i < nameList.size();i++){
            String name = nameList.get(i);
            System.out.println(name);

        }

        for( String element : nameList){
             System.out.println(element);
        }

    }

    //creating a method called Buy_Ticket and passing the parameters
    public void Buy_Ticket(Theatre theatre, String[] Row1, String[] Row2, String[] Row3) {
        Scanner select = new Scanner(System.in);

        //inputting name, surname, email, price, rownumbers and seat number to create a ticket

        System.out.print("Please enter name: ");
        String name = select.nextLine();

        System.out.print("Please enter surname: ");
        String surName = select.nextLine();

        System.out.print("Please enter your email: ");
        String email = select.nextLine();

        System.out.print("Enter price: ");
        int price = 0;
        while (true) {
            try {
                price = select.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("\nInvalid input. Please enter a valid price: ");
                select.nextLine(); // discard invalid input
            }
        }
        
        Person person = new Person(name,surName,email);//object named person
    
        //variable to hold rowNumber and seatNumber
        int rowNumber = 0, seatNumber = 0;
        while(true){
            System.out.print("Select a row number: ");
            try {
                rowNumber = select.nextInt();
                //checking if the given range is correct in row
                if(rowNumber < 1 || rowNumber > Row1.length){
                    System.out.println("Invalid row number. Please try again.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid row number.");
                select.nextLine();
            }
        }
        switch(rowNumber){
            case 1:
            while(true){
                System.out.print("Select a seat number: ");

                try {
                    seatNumber = select.nextInt();
                    //checking if the given range is correct in seat
                    if(seatNumber < 1 || seatNumber > Row2.length){
                        System.out.println("Invalid seat number. Please try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input. Please enter a valid seat number.");
                    select.nextLine();
                }
            }   //updating the array
                if (Row1[seatNumber-1].equals("0")){
                    Row1[seatNumber-1] = "x";
                    System.out.println(Arrays.toString(Row1));//displaying the updated array
                    Ticket ticket = new Ticket(person,rowNumber,seatNumber,price);//new ticket objects
                    theatre.tickets.add(ticket);//add the ticket to the tickets array lists
                }
                else {
                    System.out.println("Already booked");
                }

                break;
            case 2:
            while(true){
                System.out.print("Select a seat number: ");
                try {
                    seatNumber = select.nextInt();
                     //checking if the given range is correct in seat
                    if(seatNumber < 1 || seatNumber > 16){
                        System.out.println("Invalid seat number. Please try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input. Please enter a valid seat number.");
                    select.nextLine();
                }
            }
                if (Row2[seatNumber-1] == "0"){//updating the array
                    Row2[seatNumber-1] = "x";
                    System.out.println(Arrays.toString(Row2));//displaying the updated array
                    Ticket ticket = new Ticket(person,rowNumber,seatNumber,price);//new ticket objects
                    theatre.tickets.add(ticket);//add the ticket to the tickets array lists
                }
                else {

                    System.out.println("Already booked");
                }
                break;
            case 3:

            while(true){
                System.out.print("Select a seat number: ");
                try {
                    seatNumber = select.nextInt();
                    if(seatNumber < 1 || seatNumber > Row3.length){//checking if the given range is correct in seat
                        System.out.println("Invalid seat number. Please try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input. Please enter a valid seat number.");
                    select.nextLine();
                }
            }       //updating the array
                if (Row3[seatNumber-1] == "0"){
                    Row3[seatNumber-1] = "x";
                    System.out.println(Arrays.toString(Row3));//displaying the updated array
                    Ticket ticket = new Ticket(person,rowNumber,seatNumber,price);//new ticket objects
                    theatre.tickets.add(ticket);//add the ticket to the tickets array lists
                }
                else {
                    System.out.println("Already booked");
                }

                break;
            default:
                System.out.println("\nThere are only three rows\n");
                break;
            
        }
    }

    public static void seating_area(String[] Row1, String[] Row2, String[] Row3){

        //using for loops to print "*" for the stage border
        for(int i=0; i<12;i++ ){

            if(i == 0){
                System.out.print("\t\t\t      \t      ");
                for(int k = 0 ; k<12; k++){
                    System.out.print("*");
                }

        }

        }
        System.out.println("");

        System.out.println("\t\t\t     \t      *  STAGE   *");
        //using for loops to print "*" for the stage boder
        for(int j=0; j<12;j++ ){
            if(j == 0){
                System.out.print("             \t\t\t  ");
                for(int k = 0 ; k<12; k++){
                    System.out.print("*");
                }


        }

        }
        System.out.println("");//splitting the arrays in half and postining the accordingly
        
        String[] firstHalf = Arrays.copyOfRange(Row1,0,6);
        String[] seconttHalf = Arrays.copyOfRange(Row1,6,12);
        System.out.print("\t         " + Arrays.toString(firstHalf).replace("[", "").replace("]", ""));;
        System.out.println("\t " + Arrays.toString(seconttHalf).replace("[", "").replace("]", ""));;

        String[] halfOne = Arrays.copyOfRange(Row2, 0, 8);
        String[] halfTwo = Arrays.copyOfRange(Row2,8,16);
        System.out.print("       " + Arrays.toString(halfOne).replace("[", "").replace("]", ""));;
        System.out.println("    " + Arrays.toString(halfTwo).replace("[", "").replace("]", ""));;

        String[] half1 = Arrays.copyOfRange(Row3, 0, 10);
        String[] half2 = Arrays.copyOfRange(Row3, 10, 20);
        System.out.print(" " + Arrays.toString(half1).replace("[", "").replace("[", "").replace("]", ""));;
        System.out.println("    " + Arrays.toString(half2).replace("[", "").replace("]", ""));;
    }



    public static void Delete_Ticket(Theatre theatre, String[] Row1, String[] Row2, String[] Row3){
        Scanner select = new Scanner(System.in);
        
        int rowNumber = 0, seatNumber = 0;
        while(true){
            System.out.print("Select a row number: ");
            try {
                rowNumber = select.nextInt();//checking for the range in row number
                if(rowNumber < 1 || rowNumber > 3){
                    System.out.println("Invalid row number. Please try again.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid row number.");
                select.nextLine();
            }
        }
        switch(rowNumber){
            case 1:
            while(true){
                System.out.print("Select a seat number: ");
                try {
                    seatNumber = select.nextInt();
                    if(seatNumber < 1 || seatNumber > Row1.length){//checking for the range in seat number
                        System.out.println("Invalid seat number. Please try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input. Please enter a valid seat number.");
                    select.nextLine();
                }
            }   //removing the booked tickets form the array
                if (Row1[seatNumber-1] == "x"){
                    Row1[seatNumber-1] = "0";
                    for (int i = 0; i < tickets.size(); i++) {//removing the data from the arraylist accoring to the given input  from row and seat number
                        Ticket ticket = tickets.get(i);
                        if (ticket.getRow() == rowNumber && ticket.getSeatNumber() == seatNumber) {
                            tickets.remove(i);
                            System.out.println(Arrays.toString(Row1));
                            break;
                        }
                    }
                    
                    
                }
                else {
                    Row1[seatNumber-1] = "0";
                    System.out.println("not booked booked");
                    
                }
                break;
                
            case 2:
            while(true){
                System.out.print("Select a seat number: ");
                try {
                    seatNumber = select.nextInt();
                    if(seatNumber < 1 || seatNumber > Row2.length){//checking for the range in seat number
                        System.out.println("Invalid seat number. Please try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input. Please enter a valid seat number.");
                    select.nextLine();
                }
            }
                if (Row2[seatNumber-1] == "x"){//removing the booked tickets form the array
                    Row2[seatNumber-1] = "0";
                    for (int i = 0; i < tickets.size(); i++) {
                        Ticket ticket = tickets.get(i);
                        if (ticket.getRow() == rowNumber && ticket.getSeatNumber() == seatNumber) {//removing the data from the arraylist accoring to the given input  from row and seat number
                            tickets.remove(i);
                            System.out.print(Arrays.toString(Row2));
                            break;
                        }
                    }
                    
                    
                }
                
                else {
                    Row2[seatNumber-1] = "0";
                    System.out.println("not booked booked");
                }
                break;
            case 3:
            while(true){
                System.out.print("Select a seat number: ");
                try {
                    seatNumber = select.nextInt();
                    if(seatNumber < 1 || seatNumber > Row3.length){//checking for the range in seat number
                        System.out.println("Invalid seat number. Please try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input. Please enter a valid seat number.");
                    select.nextLine();
                }
            }
                if (Row3[seatNumber-1] == "x"){//removing the booked tickets form the array
                    Row3[seatNumber-1] = "0";
                    for (int i = 0; i < tickets.size(); i++) {
                        Ticket ticket = tickets.get(i);
                        if (ticket.getRow() == rowNumber && ticket.getSeatNumber() == seatNumber) {//removing the data from the arraylist according to the given input  from row and seat number
                            tickets.remove(i);
                            System.out.println(Arrays.toString(Row3));
                            break;
                        }
                    }
                    
                }
                else {
                    Row3[seatNumber-1] = "0";
                    System.out.println("not booked booked");
                }
                break;

            default:
                System.out.println("\nThere are only three rows\n");
                break;
        }
    }
    public static void available_seats(String[] Row1, String[] Row2, String[] Row3){
        boolean running = true;
        while(running){
            System.out.print("Row 1 is --> ");//print seating area of row 1
            for(int i = 0; i < Row1.length; i++){
                if(Row1[i].equals("0")){
                    System.out.print(i+1+" ");
                }else{
                    System.out.print(" ");

                }
            }
            System.out.print("\nRow 2 is --> ");//print seating area of row 2
            for(int i = 0; i < Row2.length; i++){
                if(Row2[i].equals("0")){
                    System.out.print(i+1+" ");
                }else{
                    System.out.print(" ");

                }
            }
            System.out.print("\nRow 3 is --> ");//print seating area of row 3
            for(int i = 0; i < Row3.length; i++){
                if(Row3[i].equals("0")){
                    System.out.print(i+1+" ");
                }else{
                    System.out.print(" ");

                }
            }
            running = false;

        }
    }
    public static void save_textfile(String[] row1, String[] row2, String[] row3) {
        try {
            FileWriter writer = new FileWriter("seats.txt");//saving data to a text file 
            writer.write("row 1 --> ");
            for (int i = 0; i < row1.length; i++) {//display the data stored on the arrays using a for loop
                writer.write(row1[i] + " ");
            }
            writer.write("\n");
            writer.write("row 2 --> ");
            for (int i = 0; i < row2.length; i++) {//display the data stored on the arrays using a for loop
                writer.write(row2[i] + " ");
            }
            writer.write("\n");
            writer.write("row 3 --> ");
            for (int i = 0; i < row3.length; i++) {//display the data stored on the arrays using a for loop
                writer.write(row3[i] + " ");
            }
            writer.close();
            System.out.println("Seats saved to file 'seats.txt'");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the seats: " + e.getMessage());
        }
    }
    public static void load_textfile(String[] row1, String[] row2, String[] row3){
        try {
            File file = new File("seats.txt");//reading the data from the file and printing them in the terminal
            Scanner file_reader = new Scanner(file);
            int i = 0;
            while (file_reader.hasNextLine()) {
                String text = file_reader.nextLine();
                System.out.println(text);
            }
            file_reader.close();
        } catch (IOException e) {
            System.out.println("Error while reading a file. ");
            e.printStackTrace();
        }
    }
    public void ticket_Info(String[] row1, String[] row2, String[] row3){
        int totalCost = 0;
        for (int i = 0; i < tickets.size(); i++){//printing ticket details saved in the arraylist
            Ticket ticket = tickets.get(i);
            if(ticket != null){
                ticket.print();
                totalCost += ticket.getPrice();
                System.out.println();
            }
        }
        System.out.println("Total cost of the ticket: $" + totalCost);//showing the total code the price for the tickets  
    }

    public void sortInfo(String[] row1, String[] row2, String[] row3) {
        // Sort tickets by price (ascending order) using bubble sort algorithm
        int n = tickets.size();
        Ticket temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tickets.get(j).getPrice() > tickets.get(j + 1).getPrice()) {
                    temp = tickets.get(j);
                    tickets.set(j, tickets.get(j + 1));
                    tickets.set(j + 1, temp);
                }
            }
        }
    
        // Print the sorted tickets information (including price) and calculate total cost
        System.out.println("");
        System.out.println("Sorted tickets by price (ascending order):");
        for (int i = 0; i < n; i++) {
            Ticket ticket = tickets.get(i);
            if (ticket != null) {
                ticket.print();
                System.out.println();
            }
        }
        
    }
     
}




