import java.io.Serializable;
/**
 * A superclass giving methods to subclasses
 * @author Gosia Drygala
 * @version 4.2.0
 */

public class Person implements Serializable
{
  private String name;
  private String surname;
  private String address;
  private String email;
  private String phoneNumber;


  public Person(String name, String surname, String address,
      String email, String phoneNumber){
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String getName()
  {
    return name;
  }

  public String getSurname()
  {
    return surname;
  }

  public String getEmail()
  {
    return email;
  }

  public String getAddress()
  {
    return address;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public boolean equals(Object obj)
  {
   if(!(obj instanceof Person)){
     return false;
   }

   Person other = (Person)obj;

   return name.equals(other.name) && surname.equals(other.surname) &&
       address.equals(other.address) && email.equals(other.email) &&
       phoneNumber.equals(other.phoneNumber);
  }

  public Person copy(){
    return  new Person(name, surname, address, email, phoneNumber);
  }

  public String toString(){
    return name + "." + surname + "." + address + "." + email +
        "." + phoneNumber;
  }

}
