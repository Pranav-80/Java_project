/*
 * This program is for managing liberary, it uses arraylist, it only take the given parameter and does not 
 * account for error in the input and name of the book. For issueing or borrowing the book, you can simpily
 * type the name as it is not case sensitive.
 */


import java.util.*;

class liberary{
    ArrayList <String> availableBooks = new ArrayList <>();
    ArrayList <String> issuedBooks = new ArrayList <>();
    String bkname = "";
    Scanner sc = new Scanner(System.in);

    //To initilize the Constructor
    public liberary() {
        String [] Books = {"To Kill a Mockingbird", "1984","The Great Gatsby","The Catcher in the Rye","Harry Potter and the Sorcerer's Stone","The Lord of the Rings","Pride and Prejudice","The Hobbit","The Hunger Games","The Book Thief","The Chronicles of Narnia","Animal Farm","Jane Eyre","The Kite Runner","The Da Vinci Code","The Alchemist","The Girl with the Dragon Tattoo","The Fault in Our Stars","Gone Girl","The Handmaid's Tale","Moby-Dick","War and Peace","Wuthering Heights","A Tale of Two Cities","Brave New World","The Grapes of Wrath","Frankenstein","The Picture of Dorian Gray","Dracula","Les Misérables","The Shining",
                            "The Stand","Great Expectations","Little Women","Crime and Punishment","The Brothers Karamazov","Anna Karenina","Fahrenheit 451","Slaughterhouse-Five","The Catch-22","The Road","Life of Pi","The Time Traveler's Wife","The Hitchhiker's Guide to the Galaxy","The Curious Incident of the Dog in the Night-Time","The Perks of Being a Wallflower","The Lovely Bones","Memoirs of a Geisha","The Help", "The Girl on the Train"};
        availableBooks.addAll(Arrays.asList(Books));
    }
    
    //To add Books in The liberary
    public void addBooks(){
        System.out.println("Enter the book name you want to add to the liberary: ");
        String name = sc.nextLine();
        this.availableBooks.add(name);
        System.out.println("Book added to the liberary...");
    } 

    //To return The books to liberary
    public void returnBooks(){
        System.out.println("Enter the book name you want to return to the liberary: ");
        String returnBook = sc.nextLine();
        Boolean Found = false;
        if (issuedBooks.size() > 0){
            for (String Books: issuedBooks){
                if (returnBook.equalsIgnoreCase(Books)){
                    availableBooks.add(returnBook);
                    issuedBooks.remove(Books);
                    System.out.println("You successfully return the book...");
                    Found = true; 
                    break; 
                }
            }

            invalidReturn(Found);
        }
        else{
            System.out.println("You don't have any issued book.");
        }    
        
    }
    public void invalidReturn(Boolean found){
        if (!found){
            System.out.println("Enter the valid book to return.");
        }
    }

    //To issue the book
    public void issueBooks(){
        availableBooks();
        System.out.println("Enter the name of the book you want to borrow: ");
        String bookName = sc.nextLine();
        Boolean b = false;

        for (String books: availableBooks){
            if (bookName.equalsIgnoreCase(books)){
                b = true;
                bkname = books;
                break;
            }
            else{
                b = false;
            }
        }
        if (b){
                System.out.println("The book you requested is available at the liberary...");
                System.out.println("You can borrow: "+bkname+". Please return it before time else you will be fined appropiately. ");
                availableBooks.remove(bkname);
                issuedBooks.add(bkname);
            }
        else{
                System.out.println("Sorry. The book you requested is not available at this moment in liberary.");
                System.out.println("You can choose any other book from the liberary.");
            }
    }

    // Print Available books in the liberary
    public void availableBooks(){
        System.out.println("Available books in the liberarys are: ");
        for(String bookName: availableBooks){
            System.out.println(bookName);
        }
    }

    //Print Issued book
    public void issuedBooks(){
        System.out.println("Issued books: ");
        if (issuedBooks.size() > 0){
            for (String issue: issuedBooks){
                System.out.println(issue);
            }
        }
        else{
            System.out.println("None");
        }
    }
}
public class OnlineLiberary{
    public static void main(String[] args) {
        liberary lib = new liberary();
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter 1. If you want to add any book to the liberary.");
        System.out.println("Enter 2. If you want to borrow any book from the liberary.");
        System.out.println("Enter 3. If you want to return any book to the liberary.");
        System.out.println("Enter 4. If you want to exit.");
        int choice = 0;
        Boolean b = false;
        while (true){
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    lib.addBooks();
                    System.out.println();
                    lib.availableBooks();
                    System.out.println();
                    lib.issuedBooks();
                    break;

                case 2:
                    lib.issueBooks();
                    System.out.println();
                    lib.availableBooks();
                    System.out.println();
                    lib.issuedBooks();
                    break;

                case 3:
                    lib.returnBooks();
                    System.out.println();
                    lib.availableBooks();
                    System.out.println();
                    lib.issuedBooks();
                    break;

                case 4:
                    System.out.println("Exiting the liberary...");
                    b = true;
                    break;

                default:
                    System.out.println("Enter valid choice");
            }
            if (b){
                break;
            }
        }
    }
}