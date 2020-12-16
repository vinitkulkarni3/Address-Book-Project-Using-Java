
package com.addressbookmain;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.*;
import java.util.stream.Collectors;


abstract class MethodCall 
{
    //used to override the different sorting methods
    abstract void runMethod();
}

class Person 
{   
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
   
    /*public Person(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }*/  
   
    //Setters
    public void setFName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setLName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public void setZip(String zip)
    {
        this.zip = zip;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    
    //Getters
    public String getfName() 
    {
      return firstName;
    }
    
    public String getLName() 
    {
      return lastName;
    }
    
    public String getAddress() 
    {
      return address;
    }

    public String getCity()
    {
        return city;
    }
    
    public String getState()
    {
        return state;
    }
    
    public String getZip()
    {
        return zip;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    @Override
    public String toString() 
    {
        return "(" + "FIRSTNAME = " + firstName + ", LASTNAME = " + lastName + ", ADDRESS = " + address + ", CITY = " + city + ", STATE = " + state + ", ZIP = " + zip + ", PHONENUMBER = " + phoneNumber + '}';
    }

}

class AddressBookOperations
{
    Scanner sc = new Scanner(System.in);
    ArrayList<Person> personList = new ArrayList<Person>();
    Map<Character, MethodCall> methodMap = new HashMap<Character, MethodCall>();
    
   
    public void addMultiplePerson()
    {
        Person personInfo = new Person();
        System.out.println("Enter first name:");
        String firstName = sc.next();
        Predicate<Person> personStreamObject = pointer -> pointer.getfName().equals(firstName);
        boolean searchResult = personList.stream().anyMatch(personStreamObject);
        
        if(searchResult == true)
        {
            System.out.println();
            System.out.println("!!! Person Name Already Exist !!!");
            System.out.println();
        }
        else
        {
            personInfo.setFName(firstName);
                        
            System.out.print("Enter last name:");
            String lastName = sc.next();
            personInfo.setLName(lastName);
            
            System.out.print("Enter address:");
            String address = sc.next();
            personInfo.setAddress(address);
            
            System.out.print("Enter city:");
            String city = sc.next();
            personInfo.setCity(city);
            
            System.out.print("Enter state:");
            String state = sc.next();
            personInfo.setState(state);
            
            System.out.print("Enter zip:");
            String zip = sc.next();
            personInfo.setZip(zip);
            
            System.out.print("Enter phoennumber:");
            String phoneNumber = sc.next();
            personInfo.setPhoneNumber(phoneNumber);
            
            personList.add(personInfo);
            System.out.println();
            System.out.println("---Information Inserted Succesfully---");
            System.out.println();
        }
    }
    
    public void editExisting()
    {
        int flag = 0;
        Person personObject  = new Person();
        
        System.out.print("Enter First Name to Edit the Information : ");
        String tempFirstName = sc.next();
        
        for(int i=0; i<personList.size(); i++)
        {
            if(personList.get(i).getfName().equals(tempFirstName))
            {   
                personObject.setFName(tempFirstName);
                                        
                System.out.print("Enter last name:");
                String lastName = sc.next();
                personObject.setLName(lastName);
                
                System.out.print("Enter your address:");
                String address = sc.next();
                personObject.setAddress(address);                                       
					                        
		System.out.print("Enter your city:");
		String city = sc.next();
                personObject.setCity(city);
                                        
		System.out.print("Enter your state:");
                String state = sc.next();
                personObject.setState(state);
                                        
		System.out.print("Enter your ZIP code:");
		String zip = sc.next();
                personObject.setZip(zip);
                                        
		System.out.print("Enter your phone number");
                String number = sc.next();
                personObject.setPhoneNumber(number);
                                        
		personList.remove(i);
		personList.add(i, personObject);
                flag = 0;
		break;
                                   
            }
            else
            {
                flag = 1;
            }
        }
        if(flag == 1)
        {
            System.out.println("NAME NOT FOUND");
        } 
    }
    
    public void sortFName()
    {
        System.out.println("\nFirstName Sorted Successfully\n");
        personList.sort(Comparator.comparing(Person::getfName));
    }
    
    public void deletePerson()
    {
        System.out.print("Enter name to match and Delete : ");
        String searchName = sc.next();
        
        for(int i=0;i<personList.size();i++)
        {
            if(personList.get(i).getfName().equals(searchName))
            {
                System.out.println("\nREMOVED SUCCESSFULLY\n");
                personList.remove(i);
                break;
            }
        }
    }
    
    public void sortElements()
    {
        //hashmap is used insted of multiple if-else
        methodMap.put('1', new MethodCall() 
        {
            @Override
            public void runMethod() 
            {                
                System.out.println("Sort by city completed");
                personList.sort(Comparator.comparing(Person::getCity));
                System.out.println();
            };
        });
        
        methodMap.put('2', new MethodCall() 
        {
            @Override
            public void runMethod() 
            {                
                System.out.println("Sort by state completed");
                personList.sort(Comparator.comparing(Person::getState));
                System.out.println();
            };
        });
        
        methodMap.put('3', new MethodCall() 
        {
            @Override
            public void runMethod() 
            {                
                System.out.println("Sort by zipcode completed");
                personList.sort(Comparator.comparing(Person::getZip));
                System.out.println();
            };
        });
        
        System.out.println();
        System.out.println("[1.SortByCity] [2.SortByState] [3.SortByZip]");
        System.out.print("select the element you want to sort : ");
        char sortOption = sc.next().charAt(0); 
        methodMap.get(sortOption).runMethod();
    }
    
    public void displayByCity()
    {
        //used streams filter to display by city
        System.out.print("enter city name to match");
        String searchCity = sc.next();
        
        personList.stream().filter(ptr -> ptr.getCity().equals(searchCity)).forEach(System.out::println); 
    }
    
    public void displayByState()
    {
        //used streams filter to display by state
        System.out.print("enter state name to match");
        String searchState = sc.next();
        
        personList.stream().filter(ptr -> ptr.getState().equals(searchState)).forEach(System.out::println); 
    }
    
    public void display()
    {      
        System.out.println("----------------------------------------");
        //forEach loop
        //personList.forEach((ShowList) -> System.out.println(ShowList));
        if(personList.isEmpty())
        {
            System.out.println("No Records");
        }
        for(int i=0;i<personList.size();i++)
        {
            System.out.println(personList.get(i));
        }
        System.out.println("----------------------------------------");
    }  
    
    public void storeInArrayList()
    {
        ArrayList<String> storeValue = new ArrayList<String>();

        for(Iterator<Person> itr1 = personList.iterator(); itr1.hasNext();)
        { 
            Person p = (Person)itr1.next();
                           
            String tempfirstname = p.getfName();
            String tempstate = p.getState();
            String tempcity = p.getCity();
                           
            storeValue.add("Name:"+tempfirstname);
            storeValue.add("City:"+tempcity);
            storeValue.add("State:"+tempstate);
            storeValue.add("\n");       
        }
        System.out.println();
        storeValue.forEach((ShowList) -> System.out.print(" "+ShowList));
        System.out.println();
    }
}//AddressBookOperation class end


public class AddressBookMain
{
    public static void main(String[] args) 
    {
        System.out.println("*-*-* WELCOME TO ADDRESS BOOK *-*-*");   
        
        Scanner sc = new Scanner(System.in);
        AddressBookOperations operationsObject = new AddressBookOperations();
        
        int tempVariable = 1;
        while(tempVariable > 0)
        {
            System.out.println("[1.Check&AddPerson] [2.Edit] [3.Delete] [4.SortByFirstName] [5.SortBy_City_State_Zip] [6.DisplayByCity] [7.DisplayByState] [8.Display] [9.Exit] [10.StoreInList]");
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
                
                case 5: operationsObject.sortElements();
                break;
                        
                case 6: operationsObject.displayByCity();    
                break;
                
                case 7: operationsObject.displayByState();        
                break;
                
                case 8: operationsObject.display();
                break;
                
                case 9: exit(0);
                break;
                
                case 10: operationsObject.storeInArrayList();
                break;
                
                default: System.out.println("Invalid option");
                break;
            }
        }
    } 
}
