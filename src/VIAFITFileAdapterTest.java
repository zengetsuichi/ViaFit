import java.io.File;
import java.util.ArrayList;

public class VIAFITFileAdapterTest
{
  public static void main(String[] args)
  {
   String newFile = "C:\\Users\\karl1\\Documents\\VIAFIT\\MemberFile.bin";
    VIAFITFileAdapter viafitFileAdapter = new VIAFITFileAdapter(newFile, "ClassFile.bin", "Instructor.bin", "Schedule.bin");
    //Class
    Class zumba = new Class("Zumba", 10);
    Class kickboxing = new Class("kickboxing", 15);
    ArrayList<Class> classes = new ArrayList<>();
    classes.add(zumba);
    classes.add(kickboxing);

    //Members
    Member member = new Member("Gosia", "Drygala", "Damager", "blabla@gmail.com", "601409321", true);
    Member member1 = new Member("Karlo", "Drygala", "Damager", "blablabla@gmail.com", "601409321", true);
    Member member2 = new Member("Piotr", "Drygala", "Damager", "blabla@gmail.com", "601409321", true);

    ArrayList<Member> members = new ArrayList<>();
    members.add(member);
    members.add(member1);


    //Instructors
    Instructor instructor = new Instructor("Gosia", "Drygala", "Damager", "lollol", "6546745", classes);
    Instructor instructor1 = new Instructor("Karlo", "Drygala", "Damager", "lol", "2357647", classes);

    ArrayList<Instructor> instructors = new ArrayList<>();
    instructors.add(instructor);
    instructors.add(instructor1);

    //Scheduled Classes
    Date newDate = new Date(14, 9, 2020);
    Time newTime = new Time(16, 30);

    ScheduledClasses newScheduldedClass = new ScheduledClasses(instructor, newDate, newTime, members, 1, zumba);
    ScheduledClasses newScheduldedClass1 = new ScheduledClasses(instructor1, newDate, newTime, members, 1, kickboxing);

    ArrayList<ScheduledClasses> scheduled  = new ArrayList<>();
    scheduled.add(newScheduldedClass);
    scheduled.add(newScheduldedClass1);

    viafitFileAdapter.saveMembers(members);
    viafitFileAdapter.removeMember(member);
    viafitFileAdapter.saveClasses(classes);
    viafitFileAdapter.saveInstructor(instructors);
    viafitFileAdapter.saveScheduledClasses(scheduled);
    ArrayList<Member> list = viafitFileAdapter.getMembers();
    ArrayList<Class> list1 = viafitFileAdapter.getClasses();
    ArrayList<Instructor> list2 = viafitFileAdapter.getInstructors();
    ArrayList<ScheduledClasses> list3 = viafitFileAdapter.getScheduledClasses();

    System.out.println(list);
    System.out.println("\n");
    System.out.println(list1);
    System.out.println("\n");
    System.out.println(list2);
    System.out.println("\n");
    System.out.println(list3);
    System.out.println("-----------------------------------------" + viafitFileAdapter.getMembers());



    System.out.println("-----------------------------------------" + viafitFileAdapter.getMembers());
   System.out.println(viafitFileAdapter.getInstructors());
   viafitFileAdapter.removeInstructor("2357647");
   System.out.println(viafitFileAdapter.getInstructors());

  }
}