import java.io.Serializable;

/**
 * A class used for creating class objects
 * @author Gosia Drygala
 * @version 4.2.0
 */
public class Class implements Serializable
{
  private String className;
  private int maxMembers;

  public Class(String className, int maxMembers){
    this.className = className;
    this.maxMembers = maxMembers;
  }

  public void setClassName(String className)
  {
    this.className = className;
  }

  public void setMaxMembers(int maxMembers)
  {
    this.maxMembers = maxMembers;
  }

  public String getClassName()
  {
    return className;
  }

  public int getMaxMembers()
  {
    return maxMembers;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof Class)){
      return false;
    }

    Class other = (Class)obj;

    return className.equals(other.className) && maxMembers == other.maxMembers;
  }

  public Class copy(){
    return new Class(className, maxMembers);
  }

  public String toString(){
    return className + "." + maxMembers;
  }
}
