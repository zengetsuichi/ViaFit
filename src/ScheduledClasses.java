import java.io.Serializable;
import java.util.ArrayList;
/**
 * A class used for creating ScheduledClasses objects
 * @author Gosia Drygala
 * @version 4.2.0
 */

public class ScheduledClasses implements Serializable
{
  private Instructor instructor;
  private Date date;
  private Time time;
  private ArrayList<Member> members;
  private double duration;
  private Class className;



  public ScheduledClasses(Instructor instructor, Date date, Time time,
      ArrayList<Member> members, double duration, Class className){

    this.instructor = instructor;
    this.date = date;
    this.time = time;
    this.members = members;
    this.duration = duration;
    this.className = className;

  }
  public ScheduledClasses(Instructor instructor, Date date, Time time,
       double duration, Class className){
    this.instructor = instructor;
    this.date = date;
    this.time = time;
    this.duration = duration;
    this.className = className;
    members = new ArrayList<>();
  }



  public void schedule(Class className, Instructor instructor,
      Date date, Time time, double duration){
    this.className = className;
    this.instructor = instructor;
    this.date = date;
    this.time = time;
    this.duration = duration;
  }

  public void setInstructor(Instructor instructor){
    this.instructor = instructor;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public void setTime(Time time)
  {
    this.time = time;
  }

  public void setMembers(ArrayList<Member> members)
  {
    this.members = members;
  }

  public void setDuration(double duration)
  {
    this.duration = duration;
  }

  public void setClassName(Class className)
  {
    this.className = className;
  }

  public void addMember(Member member){
    members.add(member);
  }

  public void removeMember(Member member){
    members.remove(member);
  }

  public ArrayList<Member> getMembers()
  {
    return members;
  }

  public double getDuration()
  {
    return duration;
  }

  public Instructor getInstructor(){
    return instructor;
  }

  public String getFullNameInstructor(){
    return instructor.getFullName();
  }

  public Date getDate(){
    return date;
  }

  public Time getTime(){
    return time;
  }

  public String getClassName(){
    return className.getClassName();
  }

  public Class getClassNameClass(){
    return className;
  }

  public String toString(){
    String returnStr = "";

    for (Member member : members)
    {
      if (member != null)
      {
        returnStr += member.getName() + " " + member.getSurname() + "\n";
      }
    }
    return className+ "." + instructor.getName() + "." + instructor.getSurname() + "." + date + "." + time + "." + duration + "." + returnStr;

  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof ScheduledClasses)){
      return false;
    }
    ScheduledClasses other = (ScheduledClasses)obj;
    return instructor.equals(other.instructor) && date.equals(other.date) &&
        time.equals(other.time) && members.equals(other.members) &&
        duration == other.duration && className .equals(other.className);
  }
}
