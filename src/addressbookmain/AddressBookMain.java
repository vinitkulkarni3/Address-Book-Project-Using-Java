
package addressbookmain;

import java.util.ArrayList;
import java.util.Scanner;

class Person 
{   
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
 
    public Person(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }    
}

class AddressBookOperations
{
    Scanner sc = new Scanner(System.in);
    ArrayList<Person> personList = new ArrayList<Person>();
    
    public void addAndEdit()
    {
        System.out.print("Enter first name:");
        String firstName = sc.next();
        System.out.print("Enter last name:");
        String lastName = sc.next();
        System.out.print("Enter address:");
        String address = sc.next();
        System.out.print("Enter city:");
        String city = sc.next();
        System.out.print("Enter state:");
        String state = sc.next();
        System.out.print("Enter zip:");
        String zip = sc.next();
        System.out.print("Enter phoennumber:");
        String phoneNumber = sc.next();

        Person personObject = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
        personList.add(personObject);
        System.out.println("---Inserted Succesfully---");
    }
    
}

public class AddressBookMain
{
    public static void main(String[] args) 
    {
        System.out.println("*-*-* WELCOME TO ADDRESS BOOK *-*-*");   
        
        Scanner sc = new Scanner(System.in);
        AddressBookOperations operationsObject = new AddressBookOperations();
        
        int temp = 1;
        while(temp > 0)
        {
            System.out.println("[1.Check&AddPerson]");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1: operationsObject.addAndEdit();
                break;
                
                default: System.out.println("Invalid option");
                break;
            }
        }
    }    
}
