
package addressbookmain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Predicate;

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
    
    public String getfName() {
      return firstName;
    }

    public String getCity(){
        return city;
    }
    
    public String getState(){
        return state;
    }
    
    public String getZip(){
        return zip;
    }
}

class AddressBookOperations
{
    Scanner sc = new Scanner(System.in);
    ArrayList<Person> personList = new ArrayList<Person>();
    
    public void addMultiplePerson()
    {
        System.out.print("enter firstname: ");
        String searchFirstName = sc.next();
        
        Predicate<Person> pStream = s -> s.firstName.contains(searchFirstName);
        boolean booleanResult = personList.stream().anyMatch(pStream); 
            
        if(booleanResult == true)
        {
            System.out.println("!!! Person Name Already Exist !!!");
        }
        else
        {
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

            Person personObject = new Person(searchFirstName, lastName, address, city, state, zip, phoneNumber);
            personList.add(personObject);
            System.out.println("---Person Inserted Succesfully---");
        }
    }
    
    public void editExisting()
    {
        System.out.print("enter the name to edit: ");
        String tempFirstName = sc.next();
            
        for(Iterator<Person> itrr = personList.iterator(); itrr.hasNext();)
        { 
            Person p = (Person)itrr.next();
        
            if(p.firstName.equals(tempFirstName))
            {
                System.out.println("1.lastname 2.adddress 3.city 4.state 5.zip 6.phonenumber");
                int choice = sc.nextInt();
                
                if(choice == 1)
                {
                    System.out.println("enter last name to fix");
                    String editLastName = sc.next();
                    p.lastName = editLastName;
                }
                else if(choice == 2)
                {
                    System.out.println("enter address to fix");
                    String editaddress = sc.next();
                    p.address = editaddress; 
                }                
                else if(choice == 3)
                {
                    System.out.println("enter city to fix");
                    String editCity = sc.next();
                    p.city = editCity;
                }
                else if(choice == 4)
                {
                    System.out.println("enter state to fix");
                    String editState = sc.next();
                    p.state = editState;
                }
                else if(choice == 5)
                {
                    System.out.println("enter zip to fix");
                    String editZip = sc.next();
                    p.zip = editZip;
                }
                else if(choice == 6)
                {
                    System.out.println("enter phone to fix");
                    String editPhone = sc.next();
                    p.phoneNumber = editPhone;
                }
                else
                {
                    System.out.println("Invalid choice");
                }
            }
            else
            {
                System.out.println("No name found");
            }
        }
    }
    
    public void sortFName()
    {
        System.out.println("Sorted Successfully");
        personList.sort(Comparator.comparing(Person::getfName));
    }
    
    public void deletePerson()
    {
        System.out.print("Enter name to match and Delete : ");
        String sear = sc.next();
        for(Iterator<Person> itrr = personList.iterator(); itrr.hasNext();)
        { 
            Person p = (Person)itrr.next();
            if(p.firstName.equals(sear))
            {
                System.out.println("---Removed succefully---");
                itrr.remove();
                break;
            }
            else
            {
                System.out.println("Invalid Name");
           }
        }
    }
    
    public String sortByCity()
    {
                        
        personList.sort(Comparator.comparing(Person::getCity));
        System.out.println();
        return "Sort By City Name Successful";
    }
    public String sortByState()
    {
        personList.sort(Comparator.comparing(Person::getState));
        System.out.println();
        return "Sort By State Name Successful";
    }
    
    public String sortByZip()
    {
        personList.sort(Comparator.comparing(Person::getZip));
        System.out.println();
        return "Sort By Zip Code Successful";
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
            System.out.println("[1.Check&AddPerson] [2.Edit] [3.Delete] [4.SortByFirstName]");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1: operationsObject.addMultiplePerson();
                break;
                
                case 2: operationsObject.editExisting();
                break;
                
                case 3: operationsObject.deletePerson();
                break;
                
                case 4: operationsObject.sortFName();
                break;
                
                case 5: System.out.println("---SORTING---");
                        System.out.println("1.city 2.state 3.zip");
                        int sortOption = sc.nextInt();
                        String sortResult = (sortOption == 1 ? operationsObject.sortByCity() : sortOption == 2 ? operationsObject.sortByState() : operationsObject.sortByZip());
                break;
                
                default: System.out.println("Invalid option");
                break;
            }
        }
    } 
}
