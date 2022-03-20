import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
/**
 * A class used for adapting data between the files and the model
 * @author Gosia Drygala with help of Karlo Plepelic
 * @version 4.2.0
 */
public class VIAFITFileAdapter
{
  private MyFileIO mfio;
  private String MemberFile;
  private String ClassFile;
  private String InstructorFile;
  private String ScheduledFile;

  public VIAFITFileAdapter(String MemberFile, String ClassFile, String InstructorFile, String ScheduledFile)
  {
    mfio = new MyFileIO();
    this.MemberFile = MemberFile;
    this.ClassFile = ClassFile;
    this.InstructorFile = InstructorFile;
    this.ScheduledFile = ScheduledFile;
  }

  //Member Adapter
  /**
   * Method for getting all the member objects from Member File
   */
  public ArrayList<Member> getMembers()
  {
    ArrayList<Member> members = new ArrayList<>();

    try
    {
      members= (ArrayList<Member>) mfio.readObjectFromFile(MemberFile);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return members;
  }
  /**
   * Method for getting a specific member object from Member File
   * @param email String is used to find the member by the email
   */
  public Member getMember(String email)
  {
    Member member = null;

    ArrayList<Member> result = getMembers();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).getEmail().equals(email))
      {
        member = result.get(i);
      }
    }
    return member;
  }
  /**
   * Method for adding the member object to Member File
   * @param member Member is used in order to define information for this Member
   */
  public void addMember(Member member)
  {
    ArrayList<Member> members = getMembers();
    members.add(member);

    try
    {
      mfio.writeToFile(MemberFile, members);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   * Method for adding the member objects to Member File
   * @param members ArrayList<Member> is used in order to define the ArrayList of Member objects
   */
  public void saveMembers(ArrayList<Member> members)
  {
    try
    {
      mfio.writeToFile(MemberFile, members);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   * Method for removing the member object from Member File by email
   * @param email String is used in order to define information for this Member
   */
  public void removeMember(String email)
  {
    ArrayList<Member> result = getMembers();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).getEmail().equals(email))
      {
        result.remove(result.get(i));
      }
    }
    saveMembers(result);

  }
  /**
   * Method for removing the member object from Member File by the object
   * @param member Member is used in order to define information for this Member
   */
  public void removeMember(Member member){
    ArrayList<Member> result = getMembers();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).equals(member))
      {
        result.remove(result.get(i));
      }
    }
    saveMembers(result);
  }


  //Class Adapter
  /**
   * Method for getting all the class objects from the Class File
   */
  public ArrayList<Class> getClasses()
  {
    ArrayList<Class> classes = new ArrayList<>();

    try
    {
      classes = (ArrayList<Class>) mfio.readObjectFromFile(ClassFile);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return classes;
  }
  /**
   * Method for getting the class object from the Class File by className
   * @param className String is used in order to define information for this Class
   */
  public Class getClass(String className)
  {
    Class classGet = null;

    ArrayList<Class> result = getClasses();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).getClassName().equals(className))
      {
        classGet = result.get(i);
      }
    }
    return classGet;
  }
  /**
   * Method for adding the class object to the Class File
   * @param className String is used in order to define information for this Class
   */
  public void addClass(Class className)
  {
    ArrayList<Class> classes = getClasses();
    classes.add(className);
    try
    {
      mfio.writeToFile(ClassFile, classes);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   * Method for saving  all the class objects to the Class File
   * @param classes ArrayList<Class> is used in order to define the ArrayList of Class objects
   */
  public void saveClasses(ArrayList<Class> classes)
  {
    try
    {
      mfio.writeToFile(ClassFile, classes);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   * Method for removing the class object from the Class File by className
   *  @param className String is used in order to define information for this Class
   */
  public void removeClass(String className)
  {
    ArrayList<Class> result = getClasses();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).getClassName().equals(className))
      {
        result.remove(result.get(i));
      }
    }
    saveClasses(result);

  }
  /**
   * Method for removing the class object from the Class File by the object
   * @param className Class is used in order to define information for this Class
   */
  public void removeClass(Class className){
    ArrayList<Class> result = getClasses();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).equals(className))
      {
        result.remove(result.get(i));
      }
    }
    saveClasses(result);
  }

  //Instructor adapter
  /**
   * Method for getting all the Instructor objects from a file
   */
  public ArrayList<Instructor> getInstructors()
  {
    ArrayList<Instructor> instructors = new ArrayList<>();
    try
    {
      instructors = (ArrayList<Instructor>) mfio.readObjectFromFile(InstructorFile);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return instructors;
  }
  /**
   * Method for getting the Instructor object from a file
   *  @param phoneNumber String is used in order to define information for this Instructor
   */

  public Instructor getInstructor(String phoneNumber)
  {
    Instructor instructor = null;

    ArrayList<Instructor> result = getInstructors();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).getPhoneNumber().equals(phoneNumber))
      {
         instructor = result.get(i);
      }
    }
    return instructor;
  }
  /**
   * Method for adding the Instructor object to a file
   *  @param instructor Instructor is used in order to define information for this Instructor
   */
  public void addInstructor(Instructor instructor)
  {
    ArrayList<Instructor> instructors = getInstructors();
    instructors.add(instructor);
    try
    {
      mfio.writeToFile(InstructorFile, instructors);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   * Method for adding all the Instructor objects to a file
   * @param instructor ArrayList<Instructor> is used in order to define the ArrayList of Instructor objects
   */
  public void saveInstructor(ArrayList<Instructor> instructor)
  {
    try
    {
      mfio.writeToFile(InstructorFile, instructor);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   * Method for removing the Instructor object from the file by phoneNumber
   *  @param phoneNumber String is used in order to define information for this Instructor
   */
  public void removeInstructor(String phoneNumber)
  {
    ArrayList<Instructor> result = getInstructors();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).getPhoneNumber().equals(phoneNumber))
      {
        result.remove(result.get(i));
      }
    }
    saveInstructor(result);

  }
  /**
   * Method for removing the Instructor object from the file by the object
   * @param instructor Instructor is used in order to define information for this Instructor
   */
  public void removeInstructor(Instructor instructor){
    ArrayList<Instructor> result = getInstructors();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).equals(instructor))
      {
        result.remove(result.get(i));
      }
    }
    saveInstructor(result);
  }

  //Scheduled Classes adapter
  /**
   * Method for getting the ScheduledClasses objects from a file
   */
  public ArrayList<ScheduledClasses> getScheduledClasses()
  {
    ArrayList<ScheduledClasses> scheduledClasses = new ArrayList<>();

    try
    {
      scheduledClasses = (ArrayList<ScheduledClasses>) mfio.readObjectFromFile(ScheduledFile);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return scheduledClasses;
  }
  /**
   * Method for getting the ScheduledClasses object from a file
   *  @param date Date is used in order to define information for this ScheduledClass
   *  @param time Time is used in order to define information for this ScheduledClass
   *  @param className String is used in order to define information for this ScheduledClass
   */
  public ScheduledClasses getScheduledClass(Date date, Time time, String className)
  {
    ScheduledClasses scheduledClass = null;

    ArrayList<ScheduledClasses> result = getScheduledClasses();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).getDate().equals(date) && result.get(i).getTime().equals(time) && result.get(i).getClassNameClass().getClassName().equals(className) )
      {
        scheduledClass = result.get(i);
      }
    }
    return scheduledClass;
  }

  /**
   * Method for adding the ScheduledClasses object to a file
   *  @param scheduledClass ScheduledClass is used in order to define information for this ScheduledClass
   */
  public void addScheduledClass(ScheduledClasses scheduledClass)
  {
    ArrayList<ScheduledClasses> scheduledClasses = getScheduledClasses();
    scheduledClasses.add(scheduledClass);
    try
    {
      mfio.writeToFile(ScheduledFile, scheduledClasses);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   * Method for adding the ScheduledClasses objects to a file
   *  @param scheduledClasses ArrayList<ScheduledClasses> is used in order to define information for ArrayList of ScheduledClasses
   */
  public void saveScheduledClasses(ArrayList<ScheduledClasses> scheduledClasses)
  {
    try
    {
      mfio.writeToFile(ScheduledFile, scheduledClasses);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   * Method for removing the ScheduledClasses object from a file
   *  @param date Date is used in order to define information for this ScheduledClass
   *  @param time Time is used in order to define information for this ScheduledClass
   *  @param className String is used in order to define information for this ScheduledClass
   */
  public void removeScheduledClass(Date date, Time time, String className)
  {
    ArrayList<ScheduledClasses> result = getScheduledClasses();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).getDate().equals(date) && result.get(i).getTime().equals(time) && result.get(i).getClassNameClass().getClassName().equals(className))
      {
        result.remove(result.get(i));
      }
    }
    saveScheduledClasses(result);

  }
  /**
   * Method for removing the ScheduledClasses object from a file
   *  @param scheduledClass ScheduledClasses is used in order to define information for this ScheduledClass
   */

  public void removeScheduledClass(ScheduledClasses scheduledClass){
    ArrayList<ScheduledClasses> result = getScheduledClasses();

    for (int i = 0; i < result.size(); i++)
    {
      if (result.get(i).equals(scheduledClass))
      {
        result.remove(result.get(i));
      }
    }
    saveScheduledClasses(result);
  }
  /**
   * Method for changing the data about the Member object
   *  @param index int is used in order to define information for this Member object
   *  @param name String is used in order to define information for this Member object
   *  @param surname String is used in order to define information for this Member object
   *  @param address String is used in order to define information for this Member object
   *  @param email String is used in order to define information for this Member object
   *  @param phoneNumber String is used in order to define information for this Member object
   *  @param membership boolean is used in order to define information for this Member object
   */
  public void changeDataOfMember(int index, String name, String surname, String address, String email, String phoneNumber, boolean membership){
    ArrayList<Member> members = getMembers();
    members.remove(members.get(index));
    Member member = new Member(name, surname, address, email, phoneNumber, membership);
    members.add(index, member);
    saveMembers(members);
  }
  /**
   * Method for adding the class to the instructor
   *  @param index int is used in order to define information for this Instructor object
   *  @param className Class is used in order to define information for Class object
   */
  public void addClassToArrayInstructor(Class className, int index){
    ArrayList<Instructor> instructors = getInstructors();
    instructors.get(index).addClass(className);
    saveInstructor(instructors);
  }
  /**
   * Method for removing the class from the instructor object
   *  @param index int is used in order to define information for this Instructor object
   *  @param className Class is used in order to define information for Class object
   */
  public void removeClassToArrayInstructor(Class className, int index){
    ArrayList<Instructor> instructors = getInstructors();
    instructors.get(index).removeClass(className);
    saveInstructor(instructors);
  }
  /**
   * Method for getting the ArrayList of class objects that the instructor is teaching
   *  @param index int is used in order to define information for this Instructor object
   */
  public ArrayList<Class> getArrayOfClass(int index){
    ArrayList<Instructor> instructors = getInstructors();
    ArrayList<Class> classesTeaches = instructors.get(index).getAllClassesInstructorTeaches();
    return classesTeaches;
  }
  /**
   * Method for adding the Member object to ScheduledClasses object
   *  @param index int is used in order to define information for the ScheduledClass object
   *  @param member Member is used in order to define information for this Member object
   */
  public void addMemberToArrayScheduledClass(Member member, int index){
    ArrayList<ScheduledClasses> scheduledClasses = getScheduledClasses();
    scheduledClasses.get(index).addMember(member);
    saveScheduledClasses(scheduledClasses);
  }
  /**
   * Method for removing the Member object from ScheduledClasses object
   *  @param index int is used in order to define information for the ScheduledClass object
   *  @param member Member is used in order to define information for this Member object
   */
  public void removeMemberFromScheduledClasses(Member member, int index){
    ArrayList<ScheduledClasses> scheduledClasses = getScheduledClasses();
    scheduledClasses.get(index).removeMember(member);
    saveScheduledClasses(scheduledClasses);
  }

  /**
   * Method for getting the ArrayList of Member objects for a specific ScheduledClasses object
   *  @param index int is used in order to define information for this ScheduledClasses object
   */
  public ArrayList<Member> getArrayOfAllMembers(int index){
    ArrayList<ScheduledClasses> scheduledClasses = getScheduledClasses();
    ArrayList<Member> allMembers = scheduledClasses.get(index).getMembers();
    return allMembers;
  }
  /**
   * Method for changing the data about the Instructor object
   *  @param index int is used in order to define information for this Instructor object
   *  @param name String is used in order to define information for this Instructor object
   *  @param surname String is used in order to define information for this Instructor object
   *  @param address String is used in order to define information for this Instructor object
   *  @param email String is used in order to define information for this Instructor object
   *  @param phoneNumber String is used in order to define information for this Instructor object
   *  @param classes ArrayList<Class>  is used in order to define information for this Instructor object
   */

  public void changeDataOfInstructor(int index,String name, String surname, String address, String email, String phoneNumber, ArrayList<Class> classes ){
    ArrayList<Instructor> instructors = getInstructors();
    instructors.remove(instructors.get(index));
    Instructor instructor = new Instructor(name, surname, address, email, phoneNumber, classes);
    instructors.add(index, instructor);
    saveInstructor(instructors);
  }

  /**
   * Method for changing the data about the Class object
   *  @param index int is used in order to define information for this Class object
   *  @param className String is used in order to define information for this Class object
   *  @param maxNumberOfMembers intis used in order to define information for this Class object
   */
  public void changeDataOfClasses(int index, String className, int maxNumberOfMembers){
    ArrayList<Class> classes = getClasses();
    classes.remove(classes.get(index));
    Class newClass = new Class(className, maxNumberOfMembers);
    classes.add(index, newClass);
    saveClasses(classes);
  }
  /**
   * Method for changing the data about the ScheduledClass object
   *  @param index int is used in order to define information for this ScheduledClass object
   *  @param instructor Instructor is used in order to define information for this ScheduledClass object
   *  @param date Date is used in order to define information for this ScheduledClass object
   *  @param time Time is used in order to define information for this ScheduledClass object
   *  @param members ArrayList<Member>  is used in order to define information for this ScheduledClass object
   *  @param duration double is used in order to define information for this ScheduledClass object
   *  @param classname Class is used in order to define information for this ScheduledClass object
   */

  public void changeDataOfScheduledClasses(int index, Instructor instructor, Date date, Time time,ArrayList<Member> members, double duration, Class classname){
    ArrayList<ScheduledClasses> scheduledClasses = getScheduledClasses();
    scheduledClasses.remove(scheduledClasses.get(index));
    ScheduledClasses scheduledClass = new ScheduledClasses(instructor, date, time, members, duration, classname);
    scheduledClasses.add(index, scheduledClass);
    saveScheduledClasses(scheduledClasses);
  }
  /**
   * Method used for exporting the schedule to an xml file
   */
  public void exportSchedule() throws FileNotFoundException
  {
    ArrayList<ScheduledClasses> scheduledClasses = getScheduledClasses();

    String declaration = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    PrintWriter outputFile = new PrintWriter("scheduledClasses.xml");
    outputFile.println(declaration);
    outputFile.println("<scheduledClasses>");
    for(int i = 0; i < scheduledClasses.size(); i ++){

      outputFile.println(" <scheduledClass>");
      outputFile.println("  <" + scheduledClasses.get(i).getDate().dayOfWeek() + ">");
      outputFile.println("    <classname>" + scheduledClasses.get(i).getClassNameClass().getClassName()+ "</classname>");
      outputFile.println("    <instructor>" + scheduledClasses.get(i).getInstructor().getFullName() + "</instructor>");
      outputFile.println("    <date>" + scheduledClasses.get(i).getDate() + "</date>");
      outputFile.println("    <time>" + scheduledClasses.get(i).getTime() + "</time>");
      outputFile.println(" </" + scheduledClasses.get(i).getDate().dayOfWeek() + ">");
      outputFile.println("  </scheduledClass>");

    }
    outputFile.println("</scheduledClasses>");
    outputFile.close();
  }
}