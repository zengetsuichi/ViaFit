import java.io.Serializable;
import java.util.ArrayList;

/**
 * A subclass used for creating Instructor objects
 * @author Gosia Drygala
 * @version 4.2.0
 */
public class Instructor extends Person implements Serializable
{
  private ArrayList<Class> classes;

  public Instructor(String name, String surname, String address, String email,
      String phoneNumber, ArrayList<Class> classes)
  {
    super(name, surname, address, email, phoneNumber);
    this.classes = classes;
  }

  public Instructor(String name, String surname, String address, String email,
      String phoneNumber)
  {
    super(name, surname, address, email, phoneNumber);
    classes = new ArrayList<>();
  }

  public void setName(String instructorName){
    super.setName(instructorName);
  }

  public void addClass(Class className){
    classes.add(className);
  }

  public void removeClass(Class classname){
    classes.remove(classname);
  }

  public boolean hasClass(Class className){
    boolean doesIt = false;
    for(int i = 0; i < classes.size(); i++){
      if(classes.get(i) == className){
        doesIt = true;
      }
    }
    return doesIt;
  }

  public ArrayList<Class> getAllClassesInstructorTeaches(){
    return classes;
  }

  public int numberOfClasses(){
    return classes.size();
  }

  /**
   * method used for getting all the names of classes the instructor teaches
   */
  public String getClassName()
  {
    String returnStr = "";

    for(int x = 0; x < classes.size(); x++)
    {
      if (classes.get(x) != null)
      {
        if(x == 0)
        {
          returnStr += classes.get(x).getClassName();

        }
        else if(x%3 == 0){
          returnStr += ", " + " \n" + classes.get(x).getClassName();
        }

        else
        returnStr = returnStr + ", " + classes.get(x).getClassName();
      }
    }
    return returnStr;
  }

  public String getFullName(){
    return super.getName() + " " + super.getSurname();
  }
  public boolean equals(Object obj){
    if(!(obj instanceof Instructor)){
      return false;
    }

    Instructor other = (Instructor)obj;

    return super.equals(other) && classes.equals(other.classes);
  }

  public Instructor copy(){
    return new Instructor(getName(), getSurname(),
        getAddress(), getAddress(), getPhoneNumber());//, classes);
  }

  public String toString(){
    String returnStr = "";

    for (Class className : classes)
    {
      if (className != null)
      {
        returnStr += className.getClassName() + " ";
      }
    }
    return super.toString() + "." +  returnStr + "\n";
  }


}
