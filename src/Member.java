import java.io.Serializable;
/**
 * A class used for creating Member objects
 * @author Gosia Drygala
 * @version 4.2.0
 */

public class Member extends Person implements Serializable
{
  private boolean premiumMembership;

  public Member(String name, String surname, String address, String email,
      String phoneNumber, boolean premiumMembership)
  {
    super(name, surname, address, email, phoneNumber);
    this.premiumMembership = premiumMembership;
  }

  public boolean isPremiumMembership(){
    return premiumMembership;
  }

  public void changeMembership(boolean premiumMembership){
    this.premiumMembership = premiumMembership;
  }

  public String getFullName(){
    return super.getName() + " " + super.getSurname();
  }

  public Member copy(){
    return new Member(getName(), getSurname(), getAddress(), getEmail(), getPhoneNumber(), premiumMembership);
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof Member)){
      return false;
    }

    Member other = (Member)obj;

    return super.equals(other) && premiumMembership == other.premiumMembership;
  }

  public String toString(){
    return "\n" + super.toString() + "." + premiumMembership ;
  }


}
