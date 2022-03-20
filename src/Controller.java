import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * A class for handling operations in GUI
 * @author Karlo Plepelic with help of Gosia Drygala
 * @version 4.2.0
 */

public class Controller
{
  @FXML
  private AnchorPane rootPane;
  @FXML
  private AnchorPane membersPlane;
  @FXML
  private AnchorPane classesPane;
  @FXML
  private AnchorPane schedulePane;
  @FXML
  private AnchorPane instructorsPlane;
  @FXML
  private AnchorPane addBtnPane;
  @FXML
  private Button btnBackFromMembers;
  @FXML
  private Button btnBackFromInstructors;
  @FXML
  private Button btnBackFromSchedule;
  @FXML
  private Button btnRemoveMember;
  @FXML
  private Button btnAddMember;
  @FXML
  private Button btnEditMember;
  @FXML
  private Button btnMembers;
  @FXML
  private Button btnRemoveInstructor;
  @FXML
  private Button btnAddInstructor;
  @FXML
  private Button btnEditInstructor;
  @FXML
  private Button btnInstrutor;
  @FXML
  private Button btnClasses;
  @FXML
  private Button btnSchedule;
  @FXML
  private Button btnBackFromClasses;
  @FXML
  private Button btnRemoveClass;
  @FXML
  private Button btnAddClass;
  @FXML
  private Button btnEditClass;
  @FXML
  private TextField textFieldAddMemberName;
  @FXML
  private TextField textFieldAddMemberSurname;
  @FXML
  private TextField textFieldAddMemberAddress;
  @FXML
  private TextField textFieldAddMemberEmail;
  @FXML
  private TextField textFieldAddMemberPhoneNumber;
  @FXML
  private CheckBox checkBoxAddMemberMembership;
  @FXML
  private Button btnAddMemberInAddMember;
  @FXML
  private TextField textFieldAddInstructorName;
  @FXML
  private TextField textFieldAddInstructorSurname;
  @FXML
  private TextField textFieldAddInstructorAddress;
  @FXML
  private TextField textFieldAddInstructorEmail;
  @FXML
  private TextField textFieldAddInstructorPhoneNumber;
  @FXML
  private TextField textFieldAddInstructorClass;
  @FXML
  private TextField textFieldClassName;
  @FXML
  private TextField textFieldMaxMembers;
  @FXML
  private Button bntClassAddEdit;
  @FXML
  private TableView<Member> tableMember;
  @FXML
  private TableColumn<Member, String> memberName;
  @FXML
  private TableColumn<Member, String> memberSurname;
  @FXML
  private TableColumn<Member, String> memberAddress;
  @FXML
  private TableColumn<Member, String> memberEmail;
  @FXML
  private TableColumn<Member, String> memberPhone;
  @FXML
  private TableColumn<Member, Boolean> memberMembership;
  @FXML
  private TableView<Class> tableClasses;
  @FXML
  private TableColumn<Class, String> classNameTable;
  @FXML
  private TableColumn<Class, Integer> maxNumbersTable;
  @FXML
  private Button btnRefreshClasses;
  @FXML
  private ChoiceBox<String> choiceBoxInstructor;
  @FXML
  private Button addClassToInstructor;
  @FXML
  private Button btnAddInstructorInAddInstructor;
  @FXML
  private Button btnEditMemberInAddMember;
  @FXML
  private TextField textFieldAddMemberIndex;
  @FXML
  private Button bntClassEdit;
  @FXML
  private TextField textFieldIndexClassesEdit;
  @FXML
  private TableView<Instructor> tableInstructors;
  @FXML
  private TableColumn<Instructor, String> instructorsName;
  @FXML
  private TableColumn<Instructor, String> instructorsSurname;
  @FXML
  private TableColumn<Instructor, String> instructorsAddress;
  @FXML
  private TableColumn<Instructor, String> instructorsEmail;
  @FXML
  private TableColumn<Instructor, String> instructorsPhoneNumber;
  @FXML
  private TableColumn<Class, String> instructorsClassName;
  @FXML
  private ChoiceBox<String> choiceBoxRemoveClass;
  @FXML
  private Button btnRemoveClassInInstructor;
  @FXML
  private TextField textFieldAddInstructorIndex;
  @FXML
  private Button btnEditInstructorInEditInstructor;
  @FXML
  private Button btnSaveInstructor;
  @FXML
  private TextField textFieldAddInstructorName2;
  @FXML
  private TextField textFieldAddInstructorSurname2;
  @FXML
  private TextField textFieldAddInstructorAddress2;
  @FXML
  private TextField textFieldAddInstructorEmail2;
  @FXML
  private TextField textFieldAddInstructorPhoneNumber2;
  @FXML
  private TableView<ScheduledClasses> tableScheduledClasses;
  @FXML
  private TableColumn<Class, String> scheduledClassName;
  @FXML
  private TableColumn<Instructor, String> scheduledClassInstructor;
  @FXML
  private TableColumn<Date, String> scheduledClassDate;
  @FXML
  private TableColumn<Time, String> scheduledClassTime;
  @FXML
  private TableColumn<ScheduledClasses, Double> scheduledClassDuration;
  @FXML
  private Button btnRemoveScheduledClass;
  @FXML
  private Button btnAddScheduledClass;
  @FXML
  private Button btnEditScheduledClass;
  @FXML
  private ListView<String> listViewMembers;
  @FXML
  private TextField textFieldAddScheduledClassTime;
  @FXML
  private TextField textFieldAddScheduledClassesDuration;
  @FXML
  private Button btnAddScheduledClassInAdd;
  @FXML
  private ChoiceBox<String> choiceBoxScheduledInstructors;
  @FXML
  private DatePicker datePickerScheduledClass;
  @FXML
  private ChoiceBox<String> choiceBoxScheduledClassesAdded;
  @FXML
  private ChoiceBox<String> choiceBoxScheduledClassesAllMembers;
  @FXML
  private Button btnAddMemberinEditSchedule;
  @FXML
  private Button btnRemoveMemberInEditSchedule;
  @FXML
  private Button btnSaveSchedule;
  @FXML
  private TextField scheduledClassesIndex;
  @FXML
  private Button btnSeeMembers;
  @FXML
  private Button btnExportSchedule;

  /**
   * Variables for declaring file path, for file adapter
   */

  String memberFilePath = "";
  String classFilePath = "";
  String instructorFilePath = "";
  String scheduleFilePath = "";

  //VIAFITFileAdapter fileAdapter = new VIAFITFileAdapter(memberFilePath, classFilePath, instructorFilePath, scheduleFilePath);
  VIAFITFileAdapter fileAdapter = new VIAFITFileAdapter("C:\\Users\\karl1\\Documents\\VIAFIT\\MemberFile.bin",
      "C:\\Users\\karl1\\Documents\\VIAFIT\\ClassFile.bin", "C:\\Users\\karl1\\Documents\\VIAFIT\\Instructor.bin",
      "C:\\Users\\karl1\\Documents\\VIAFIT\\Schedule.bin");

  /**
   * Method for handling events from GUI
   * @param e is used to detect by which event is happening
   */

  public void handleClickMe(ActionEvent e) throws FileNotFoundException
  {
    ////////////////////////////////////////////////////////////////MAIN PAGE//////////////////////////////////////////////////////////////////////////
    if(e.getSource() == btnMembers)
    {
      try
      {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Members.fxml"));
        rootPane.getChildren().setAll(pane);
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
    else if(e.getSource() == btnInstrutor)
    {
      try
      {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Instructors.fxml"));
        rootPane.getChildren().setAll(pane);
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
    else if(e.getSource() == btnSchedule)
    {
      try
      {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Schedule.fxml"));
        rootPane.getChildren().setAll(pane);
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
    else if(e.getSource() == btnClasses)
    {
      try
      {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Classes.fxml"));
        rootPane.getChildren().setAll(pane);
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
    ////////////////////////////////////////////////////////////////MEMBERS//////////////////////////////////////////////////////////////////////////
    else if(e.getSource() == btnBackFromMembers)
    {
      try
      {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("VIAFITFXML.fxml"));
        membersPlane.getChildren().setAll(pane);
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
    else if(e.getSource() == btnRemoveMember)
    {
      fileAdapter.removeMember(tableMember.getSelectionModel().getSelectedItem());
      tableMember.getItems().clear();
      for(int x = 0; x < fileAdapter.getMembers().size(); x++)
        tableMember.getItems().add(fileAdapter.getMembers().get(x));
    }
    else if(e.getSource() == btnEditMember)
    {
      if(tableMember.getSelectionModel().getSelectedItem() != null)
      {
        Parent part = null;
        try
        {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AddMember.fxml"));
          part = loader.load();
          Controller ctrl = loader.getController();
          ctrl.initializeFields(tableMember.getSelectionModel().getSelectedItem(), tableMember.getSelectionModel().getSelectedIndex());
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
        }
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.setUserData(this);
        stage.show();
      }
    }
    else if(e.getSource() == btnAddMember)
    {
      Parent part = null;
      try
      {
        part = FXMLLoader.load(getClass().getResource("AddMember.fxml"));
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
      Stage stage = new Stage();
      Scene scene = new Scene(part);
      stage.setScene(scene);
      stage.setUserData(this);
      stage.show();
    }
    else if(e.getSource() == btnAddMemberInAddMember)
    {
      if(textFieldAddMemberName.getText().equals("") ||textFieldAddMemberSurname.getText().equals("") ||textFieldAddMemberAddress.getText().equals("")
          ||textFieldAddMemberEmail.getText().equals("") || textFieldAddMemberPhoneNumber.getText().equals("")){
        System.out.println("All the fields need to be specified");
      }
      else
      {
        ArrayList<Member> allMembers = fileAdapter.getMembers();
        Member inputMember = new Member(textFieldAddMemberName.getText(),
            textFieldAddMemberSurname.getText(), textFieldAddMemberAddress.getText(),
            textFieldAddMemberEmail.getText(), textFieldAddMemberPhoneNumber.getText(),
            checkBoxAddMemberMembership.isSelected());
        for(int i = 0; i < allMembers.size();i++)
        {
          if (allMembers.get(i).equals(inputMember))
          {
            System.out.println("Member already exists!");
            inputMember = null;
          }
        }
        if(inputMember != null)
        {
          Member addMemeber = new Member(textFieldAddMemberName.getText(),
              textFieldAddMemberSurname.getText(), textFieldAddMemberAddress.getText(),
              textFieldAddMemberEmail.getText(), textFieldAddMemberPhoneNumber.getText(),
              checkBoxAddMemberMembership.isSelected());
          fileAdapter.addMember(addMemeber);

          Stage stage = (Stage) btnAddMemberInAddMember.getScene().getWindow();
          stage.close();
          ((Controller) stage.getUserData()).initialize();
        }
      }
    }
    else if(e.getSource() == btnEditMemberInAddMember)
    {
      try
      {
        if(textFieldAddMemberName.getText().equals("") ||textFieldAddMemberSurname.getText().equals("") ||textFieldAddMemberAddress.getText().equals("")
            ||textFieldAddMemberEmail.getText().equals("") || textFieldAddMemberPhoneNumber.getText().equals("")){
          System.out.println("All the fields need to be specified");
        }
        else
        {
          ArrayList<Member> allMembers = fileAdapter.getMembers();
          Member inputMember = new Member(textFieldAddMemberName.getText(),
              textFieldAddMemberSurname.getText(), textFieldAddMemberAddress.getText(),
              textFieldAddMemberEmail.getText(), textFieldAddMemberPhoneNumber.getText(),
              checkBoxAddMemberMembership.isSelected());
          for (int i = 0; i < allMembers.size(); i++)
          {
            if (allMembers.get(i).equals(inputMember))
            {
              System.out.println("Member already exists!");
              inputMember = null;
            }
          }
          if (inputMember != null)
          {
            fileAdapter.changeDataOfMember(Integer.parseInt(textFieldAddMemberIndex.getText()),
                textFieldAddMemberName.getText(), textFieldAddMemberSurname.getText(),
                textFieldAddMemberAddress.getText(), textFieldAddMemberEmail.getText(),
                textFieldAddMemberPhoneNumber.getText(),
                checkBoxAddMemberMembership.isSelected());
            Stage stage = (Stage) btnEditMemberInAddMember.getScene().getWindow();
            stage.close();
            ((Controller) stage.getUserData()).initialize();
          }
        }
      }
      catch(java.lang.NumberFormatException e1)
      {
        System.out.println("This is Edit Button, try Add Member");
      }
    }
    ////////////////////////////////////////////////////////////////INSTRUCTORS//////////////////////////////////////////////////////////////////////////
    else if(e.getSource() == btnBackFromInstructors)
    {
      try
      {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("VIAFITFXML.fxml"));
        instructorsPlane.getChildren().setAll(pane);
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
    else if(e.getSource() == btnRemoveInstructor)
    {
      fileAdapter.removeInstructor(tableInstructors.getSelectionModel().getSelectedItem());
      tableInstructors.getItems().clear();
      for(int x = 0; x < fileAdapter.getInstructors().size(); x++)
        tableInstructors.getItems().add(fileAdapter.getInstructors().get(x));
    }
    else if(e.getSource() == btnEditInstructor)
    {
      if(tableInstructors.getSelectionModel().getSelectedItem() != null)
      {
        Parent part = null;
        try
        {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AddInstructorEdit.fxml"));
          part = loader.load();
          Controller ctrl = loader.getController();
          ctrl.updateChoiceBoxInstructor();
          ctrl.updateChoiceBoxInstructorRemove(tableInstructors.getSelectionModel().getSelectedItem());
          ctrl.initializeFieldsInstructor(tableInstructors.getSelectionModel().getSelectedItem(), tableInstructors.getSelectionModel().getSelectedIndex());
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
        }
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.setUserData(this);
        stage.show();
        }
    }
    else if(e.getSource() == btnAddInstructor)
    {
      Parent part = null;
      try
      {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddInstructor.fxml"));
        part = loader.load();
        Controller ctrl = loader.getController();
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
      Stage stage = new Stage();
      Scene scene = new Scene(part);
      stage.setScene(scene);
      stage.setUserData(this);
      stage.show();
    }
    else if(e.getSource() == btnAddInstructorInAddInstructor)
    {
      if(textFieldAddInstructorName.getText().equals("") ||textFieldAddInstructorSurname.getText().equals("") || textFieldAddInstructorAddress.getText().equals("")
          ||textFieldAddInstructorEmail.getText().equals("") || textFieldAddInstructorPhoneNumber.getText().equals("")){
        System.out.println("All the fields need to be specified");
      }
      else
      {
        ArrayList<Instructor> allInstructors = fileAdapter.getInstructors();

        Instructor inputInstructor = new Instructor(textFieldAddInstructorName.getText(),
            textFieldAddInstructorSurname.getText(), textFieldAddInstructorAddress.getText(),
            textFieldAddInstructorEmail.getText(), textFieldAddInstructorPhoneNumber.getText());
        for (int i = 0; i < allInstructors.size(); i++)
        {
          if (allInstructors.get(i).equals(inputInstructor))
          {
            System.out.println("Instructor already exists!");
            inputInstructor = null;
          }
        }
        if (inputInstructor != null)
        {
          fileAdapter.addInstructor(new Instructor(textFieldAddInstructorName.getText(),
              textFieldAddInstructorSurname.getText(),
              textFieldAddInstructorAddress.getText(),
              textFieldAddInstructorEmail.getText(),
              textFieldAddInstructorPhoneNumber.getText()));
          Stage stage = (Stage) btnAddInstructorInAddInstructor.getScene().getWindow();
          stage.close();
          ((Controller) stage.getUserData()).initialize();
        }
      }
    }
    else if(e.getSource() == addClassToInstructor){
      Class newClass = null;
      for(int x = 0; x < fileAdapter.getClasses().size(); x++)
      {
        if(fileAdapter.getClasses().get(x).getClassName().equals(choiceBoxInstructor.getValue()))
          newClass = fileAdapter.getClasses().get(x);
      }
      ArrayList<Class> allClassesHeTeaches = fileAdapter.getInstructors().get(Integer.parseInt(textFieldAddInstructorIndex.getText())).getAllClassesInstructorTeaches();
      if(allClassesHeTeaches != null)
      {
        boolean  teaches = true;
        for (int i = 0; i < allClassesHeTeaches.size(); i++)
        {
          if (allClassesHeTeaches.get(i).equals(newClass))
          {
            System.out.println("The instructor already teaches this class");
            teaches = false;
          }
        }
        if(teaches){
          fileAdapter.addClassToArrayInstructor(newClass, Integer.parseInt(textFieldAddInstructorIndex.getText()));
          updateChoiceBoxInstructorRemove(fileAdapter.getInstructors().get(Integer.parseInt(textFieldAddInstructorIndex.getText())));
        }
      }
      else{
        fileAdapter.addClassToArrayInstructor(newClass, Integer.parseInt(textFieldAddInstructorIndex.getText()));
        updateChoiceBoxInstructorRemove(fileAdapter.getInstructors().get(Integer.parseInt(textFieldAddInstructorIndex.getText())));
      }
    }
    else if(e.getSource() == btnRemoveClassInInstructor)
    {
      Class newClass = null;
      for(int x = 0; x < fileAdapter.getClasses().size(); x++)
      {
        if(fileAdapter.getClasses().get(x).getClassName().equals(choiceBoxRemoveClass.getValue()))
          newClass = fileAdapter.getClasses().get(x);
      }
      fileAdapter.removeClassToArrayInstructor(newClass, Integer.parseInt(textFieldAddInstructorIndex.getText()));
      updateChoiceBoxInstructorRemove(fileAdapter.getInstructors().get(Integer.parseInt(textFieldAddInstructorIndex.getText())));
    }
    else if(e.getSource() == btnSaveInstructor)
    {
      ArrayList<Instructor> allInstructors = fileAdapter.getInstructors();

      Instructor inputInstructor = new Instructor(textFieldAddInstructorName2.getText(),
          textFieldAddInstructorSurname2.getText(), textFieldAddInstructorAddress2.getText(),
          textFieldAddInstructorEmail2.getText(), textFieldAddInstructorPhoneNumber2.getText());
      for (int i = 0; i < allInstructors.size(); i++)
      {
        if (allInstructors.get(i).equals(inputInstructor))
        {
          System.out.println("Instructor already exists!");
          inputInstructor = null;
        }
      }
      if (inputInstructor != null)
      {
        fileAdapter.changeDataOfInstructor(
            Integer.parseInt(textFieldAddInstructorIndex.getText()), textFieldAddInstructorName2.getText(),textFieldAddInstructorSurname2.getText(),
            textFieldAddInstructorAddress2.getText(), textFieldAddInstructorEmail2.getText(),textFieldAddInstructorPhoneNumber2.getText(),
            fileAdapter.getArrayOfClass(Integer.parseInt(textFieldAddInstructorIndex.getText())));
        Stage stage = (Stage) btnSaveInstructor.getScene().getWindow();
        stage.close();
        ((Controller)stage.getUserData()).initialize();
      }
    }
    ////////////////////////////////////////////////////////////////CLASSES//////////////////////////////////////////////////////////////////////////
    else if(e.getSource() == btnBackFromClasses)
    {
      try
      {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("VIAFITFXML.fxml"));
        classesPane.getChildren().setAll(pane);
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
    else if(e.getSource() == btnRemoveClass)
    {
      fileAdapter.removeClass(tableClasses.getSelectionModel().getSelectedItem());
      tableClasses.getItems().clear();
      for(int x = 0; x < fileAdapter.getClasses().size(); x++)
        tableClasses.getItems().add(fileAdapter.getClasses().get(x));
    }
    else if(e.getSource() == btnEditClass)
    {
      Parent part = null;
      try
      {
        //part = FXMLLoader.load(getClass().getResource("AddClasses.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddClasses.fxml"));
        part = loader.load();
        Controller ctrl = loader.getController();
        ctrl.initializeFieldsClasses(tableClasses.getSelectionModel().getSelectedItem(), tableClasses.getSelectionModel().getSelectedIndex());
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
      Stage stage = new Stage();
      Scene scene = new Scene(part);
      stage.setScene(scene);
      stage.setUserData(this);
      stage.show();
    }
    else if(e.getSource() == btnAddClass)
    {
      Parent part = null;
      try
      {
        part = FXMLLoader.load(getClass().getResource("AddClasses.fxml"));
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
      Stage stage = new Stage();
      Scene scene = new Scene(part);
      stage.setScene(scene);
      stage.setUserData(this);
      stage.show();
    }
    else if(e.getSource() == bntClassAddEdit)
    {
      if(textFieldClassName.getText().equals("") || textFieldMaxMembers.getText().equals("")){
        System.out.println("All the fields need to be specified");
      }
      else
      {
        ArrayList<Class> classes = fileAdapter.getClasses();
        Class inputClass = new Class(textFieldClassName.getText(),Integer.parseInt(textFieldMaxMembers.getText()));
        for (int i = 0; i < classes.size(); i++)
        {
          if (classes.get(i).equals(inputClass))
          {
            System.out.println("Class already exists!");
            inputClass = null;
          }
        }
        if (inputClass != null)
        {
          int max = Integer.parseInt(textFieldMaxMembers.getText());
          fileAdapter.addClass(new Class(textFieldClassName.getText(), max));
          Stage stage = (Stage)bntClassAddEdit.getScene().getWindow();
          stage.close();
          ((Controller)stage.getUserData()).initialize();
        }
      }


    }
    else if(e.getSource() == bntClassEdit)
    {
      try
      {
        if (textFieldClassName.getText().equals("") || textFieldMaxMembers.getText().equals(""))
        {
          System.out.println("All the fields need to be specified");
        }
        else
        {
          ArrayList<Class> classes = fileAdapter.getClasses();
          Class inputClass = new Class(textFieldClassName.getText(), Integer.parseInt(textFieldMaxMembers.getText()));
          for (int i = 0; i < classes.size(); i++)
          {
            if (classes.get(i).equals(inputClass))
            {
              System.out.println("You didnt change any data");
              inputClass = null;
            }
          }
          if (inputClass != null)
          {
            fileAdapter.changeDataOfClasses(Integer.parseInt(textFieldIndexClassesEdit.getText()),
                textFieldClassName.getText(), Integer.parseInt(textFieldMaxMembers.getText()));
            Stage stage = (Stage) bntClassAddEdit.getScene().getWindow();
            stage.close();
            ((Controller) stage.getUserData()).initialize();
          }

        }

      }
      catch(java.lang.NumberFormatException e1)
      {
        System.out.println("This is Edit Button, try Add Member");
      }
    }
    ////////////////////////////////////////////////////////////////SCHEDULE//////////////////////////////////////////////////////////////////////////
    else if(e.getSource() == btnBackFromSchedule)
    {
      try
      {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("VIAFITFXML.fxml"));
        schedulePane.getChildren().setAll(pane);
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
    else if(e.getSource() == btnAddScheduledClass){
      Parent part = null;
      try
      {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddScheduledClasses.fxml"));
        part = loader.load();
        Controller ctrl = loader.getController();
        ctrl.updateChoiceBoxInstructor();
        ctrl.updateChoiceBoxInstructors();
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
      Stage stage = new Stage();
      Scene scene = new Scene(part);
      stage.setScene(scene);
      stage.setUserData(this);
      stage.show();
    }
    else if(e.getSource() == btnAddScheduledClassInAdd){
      Class newClass = null;
      for(int x = 0; x < fileAdapter.getClasses().size(); x++)
      {
        if(fileAdapter.getClasses().get(x).getClassName().equals(choiceBoxInstructor.getValue()))
          newClass = fileAdapter.getClasses().get(x);
      }

      Instructor instructor = null;
      for(int x = 0; x < fileAdapter.getInstructors().size(); x++)
      {
        if(fileAdapter.getInstructors().get(x).getFullName().equals(choiceBoxScheduledInstructors.getValue()))
          instructor = fileAdapter.getInstructors().get(x);
      }
      if(choiceBoxInstructor.getValue().equals("") || choiceBoxScheduledInstructors.getValue().equals("") ||
          datePickerScheduledClass.getValue() == null || textFieldAddScheduledClassTime.getText().equals("")||textFieldAddScheduledClassesDuration.getText().equals("") ){
        System.out.println("All the fields need to be specified");
      }
      else
      {
        boolean switcher = false;
        for(int x = 0; x < instructor.getAllClassesInstructorTeaches().size(); x++)
        {
          if(newClass.equals(instructor.getAllClassesInstructorTeaches().get(x)))
          {
            switcher = true;
          }
        }
        if(switcher)
        {
          String[] hourMin = textFieldAddScheduledClassTime.getText().split(":");
          int hour = Integer.parseInt(hourMin[0]);
          int mins = Integer.parseInt(hourMin[1]);
          Time time = new Time(hour, mins);

          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
          LocalDate date = datePickerScheduledClass.getValue();

          String[] dateOfTheClass = (formatter.format(date)).split("/");
          int month = Integer.parseInt(dateOfTheClass[0]);
          int day = Integer.parseInt(dateOfTheClass[1]);
          int year = Integer.parseInt(dateOfTheClass[2]);
          Date date1 = new Date(day, month, year);
          double duration = Double.parseDouble(textFieldAddScheduledClassesDuration.getText());

          ArrayList<ScheduledClasses> scheduledClasses = fileAdapter.getScheduledClasses();
          ScheduledClasses inputClass = new ScheduledClasses(instructor, date1,
              time, duration, newClass);
          for (int i = 0; i < scheduledClasses.size(); i++)
          {
            if (scheduledClasses.get(i).equals(inputClass))
            {
              System.out.println("Class already exists!");
              inputClass = null;
            }
          }
          if (inputClass != null)
          {
            fileAdapter.addScheduledClass(
                new ScheduledClasses(instructor, date1, time, duration, newClass));
            Stage stage = (Stage) btnAddScheduledClassInAdd.getScene().getWindow();
            stage.close();
            ((Controller) stage.getUserData()).initialize();
          }
        }
        else
          System.out.println("Instructor can not teach classes he is not assigned to.");
      }
    }
    else if(e.getSource() == btnRemoveScheduledClass){
      fileAdapter.removeScheduledClass(tableScheduledClasses.getSelectionModel().getSelectedItem());
      tableScheduledClasses.getItems().clear();
      for(int x = 0; x < fileAdapter.getScheduledClasses().size(); x++)
        tableScheduledClasses.getItems().add(fileAdapter.getScheduledClasses().get(x));
    }
    else if(e.getSource() == btnEditScheduledClass)
    {
      try
      {
        if (tableScheduledClasses.getSelectionModel() != null)
        {
          Parent part = null;
          try
          {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddScheduledClassesEdit.fxml"));
            part = loader.load();
            Controller ctrl = loader.getController();
            ctrl.updateChoiceBoxInstructor();
            ctrl.updateChoiceBoxInstructors();
            ctrl.updateChoiceBoxAllMembers();
            ctrl.updateChoiceBoxRemoveMembers(tableScheduledClasses.getSelectionModel().getSelectedItem());
            ctrl.initializeFieldsEditScheduledClasses(tableScheduledClasses.getSelectionModel().getSelectedItem(),
                tableScheduledClasses.getSelectionModel().getSelectedIndex());
            //ctrl.updateChoiceBoxRemoveMembers(fileAdapter.getScheduledClasses().get(Integer.parseInt(scheduledClassesIndex.getText())));
          }
          catch (IOException ex)
          {
            ex.printStackTrace();
          }
          Stage stage = new Stage();
          Scene scene = new Scene(part);
          stage.setScene(scene);
          stage.setUserData(this);
          stage.show();
          //updateChoiceBoxRemoveMembers(fileAdapter.getScheduledClasses().get(Integer.parseInt(scheduledClassesIndex.getText())));
        }
      }
      catch (java.lang.NullPointerException ex)
      {
        System.out.println("No selected Scheduled Class");
      }
    }
    else if(e.getSource() == btnExportSchedule){
      System.out.println("Export schedule");
      fileAdapter.exportSchedule();
    }
    else if(e.getSource() == btnAddMemberinEditSchedule)
    {
      if(fileAdapter.getScheduledClasses().get(Integer.parseInt(scheduledClassesIndex.getText())).getClassNameClass().getMaxMembers() >
          fileAdapter.getScheduledClasses().get(Integer.parseInt(scheduledClassesIndex.getText())).getMembers().size())
      {
        Member newMember = null;
        for (int x = 0; x < fileAdapter.getMembers().size(); x++)
        {
          if (fileAdapter.getMembers().get(x).getFullName().equals(choiceBoxScheduledClassesAllMembers.getValue()))
            newMember = fileAdapter.getMembers().get(x);
        }
        for (int i = 0; i < fileAdapter.getScheduledClasses().get(Integer.parseInt(scheduledClassesIndex.getText())).getMembers()
            .size(); i++)
        {
          if (fileAdapter.getScheduledClasses().get(Integer.parseInt(scheduledClassesIndex.getText()))
              .getMembers().get(i).equals(newMember))
            newMember = null;
          System.out.println("This member is already in the list");
        }
        if (newMember != null)
        {
          fileAdapter.addMemberToArrayScheduledClass(newMember, Integer.parseInt(scheduledClassesIndex.getText()));
          updateChoiceBoxRemoveMembers(fileAdapter.getScheduledClasses().get(Integer.parseInt(scheduledClassesIndex.getText())));
        }
      }
      else
        System.out.println("Max number of members reached.");
    }
    else if(e.getSource() == btnSaveSchedule)
    {
      Class newClass = null;
      for(int x = 0; x < fileAdapter.getClasses().size(); x++)
      {
        if(fileAdapter.getClasses().get(x).getClassName().equals(choiceBoxInstructor.getValue()))
          newClass = fileAdapter.getClasses().get(x);
      }

      Instructor instructor = null;
      for(int x = 0; x < fileAdapter.getInstructors().size(); x++)
      {
        if(fileAdapter.getInstructors().get(x).getFullName().equals(choiceBoxScheduledInstructors.getValue()))
          instructor = fileAdapter.getInstructors().get(x);
      }
      boolean switcher = false;
      for(int x = 0; x < instructor.getAllClassesInstructorTeaches().size(); x++)
      {
        if(newClass.equals(instructor.getAllClassesInstructorTeaches().get(x)))
        {
          switcher = true;
        }
      }
      if(switcher)
      {
        String[] hourMin = textFieldAddScheduledClassTime.getText().split(":");
        int hour = Integer.parseInt(hourMin[0]);
        int mins = Integer.parseInt(hourMin[1]);
        Time time = new Time(hour, mins);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = datePickerScheduledClass.getValue();

        String[] dateOfTheClass = (formatter.format(date)).split("/");
        int month = Integer.parseInt(dateOfTheClass[0]);
        int day = Integer.parseInt(dateOfTheClass[1]);
        int year = Integer.parseInt(dateOfTheClass[2]);
        Date date1 = new Date(day, month, year);
        fileAdapter.changeDataOfScheduledClasses(Integer.parseInt(scheduledClassesIndex.getText()), instructor,
            date1, time, fileAdapter.getArrayOfAllMembers(Integer.parseInt(scheduledClassesIndex.getText())),
            Double.parseDouble(textFieldAddScheduledClassesDuration.getText()),
            newClass);
        Stage stage = (Stage) btnSaveSchedule.getScene().getWindow();
        stage.close();
        ((Controller) stage.getUserData()).initialize();
      }
      else
        System.out.println("Instructor can not teach classes he is not assigned to.");
    }
    else if(e.getSource() == btnRemoveMemberInEditSchedule)
    {
      Member newMember = null;
      for(int x = 0; x < fileAdapter.getMembers().size(); x++)
      {
        if(fileAdapter.getMembers().get(x).getFullName().equals(choiceBoxScheduledClassesAllMembers.getValue()))
          newMember = fileAdapter.getMembers().get(x);
      }
      fileAdapter.removeMemberFromScheduledClasses(newMember, Integer.parseInt(scheduledClassesIndex.getText()));
      updateChoiceBoxRemoveMembers(fileAdapter.getScheduledClasses().get(Integer.parseInt(scheduledClassesIndex.getText())));
    }
    else if(e.getSource() == btnSeeMembers){
        if (tableScheduledClasses.getSelectionModel().getFocusedIndex() != 0)
        {
          listViewMembers.getItems().clear();
          ArrayList<Member> members = fileAdapter.getArrayOfAllMembers(tableScheduledClasses.getSelectionModel().getSelectedIndex());
          listViewMembers.getItems().add("Members of " + fileAdapter.getScheduledClasses().get(tableScheduledClasses.getSelectionModel().getSelectedIndex()).getClassName());
          for(int i = 0; i < members.size(); i++){
            listViewMembers.getItems().add(members.get(i).getFullName());
          }
        }
        else
          System.out.println("No selected Scheduled Class");
    }
  }

  /**
   * Method for initializing tables in GUI and specifying data in tables
   */

  public void initialize()
  {
    if(tableMember!=null)
    {
      tableMember.getItems().clear();
      memberName.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
      memberSurname.setCellValueFactory(new PropertyValueFactory<Member, String>("surname"));
      memberAddress.setCellValueFactory(new PropertyValueFactory<Member, String>("address"));
      memberPhone.setCellValueFactory(new PropertyValueFactory<Member, String>("phoneNumber"));
      memberEmail.setCellValueFactory(new PropertyValueFactory<Member, String>("email"));
      memberMembership.setCellValueFactory(new PropertyValueFactory<Member, Boolean>("premiumMembership"));

      for(int x = 0; x < fileAdapter.getMembers().size(); x++)
        tableMember.getItems().add(fileAdapter.getMembers().get(x));
    }
    if(tableInstructors!=null)
    {
      tableInstructors.getItems().clear();
      instructorsName.setCellValueFactory(new PropertyValueFactory<Instructor, String>("name"));
      instructorsSurname.setCellValueFactory(new PropertyValueFactory<Instructor, String>("surname"));
      instructorsAddress.setCellValueFactory(new PropertyValueFactory<Instructor, String>("address"));
      instructorsPhoneNumber.setCellValueFactory(new PropertyValueFactory<Instructor, String>("phoneNumber"));
      instructorsEmail.setCellValueFactory(new PropertyValueFactory<Instructor, String>("email"));
      instructorsClassName.setCellValueFactory(new PropertyValueFactory<Class, String>("className"));

      for(int x = 0; x < fileAdapter.getInstructors().size(); x++)
        tableInstructors.getItems().add(fileAdapter.getInstructors().get(x));
    }
    if(tableClasses!=null)
    {
      tableClasses.getItems().clear();
      classNameTable.setCellValueFactory(new PropertyValueFactory<Class, String>("className"));
      maxNumbersTable.setCellValueFactory(new PropertyValueFactory<Class, Integer>("maxMembers"));

      for(int x = 0; x < fileAdapter.getClasses().size(); x++)
        tableClasses.getItems().add(fileAdapter.getClasses().get(x));
    }

    if(tableScheduledClasses!=null){
      tableScheduledClasses.getItems().clear();
      scheduledClassName.setCellValueFactory(new PropertyValueFactory<Class, String>("className"));
      scheduledClassInstructor.setCellValueFactory(new PropertyValueFactory<Instructor, String>("FullNameInstructor"));
      scheduledClassDate.setCellValueFactory(new PropertyValueFactory<Date, String>("date"));
      scheduledClassTime.setCellValueFactory(new PropertyValueFactory<Time, String>("time"));
      scheduledClassDuration.setCellValueFactory(new PropertyValueFactory<ScheduledClasses, Double>("duration"));

      for(int x = 0; x < fileAdapter.getScheduledClasses().size(); x++)
        tableScheduledClasses.getItems().add(fileAdapter.getScheduledClasses().get(x));
    }
  }

  /**
   * Method for initializing fields with data in edit member window
   * @param member member object in order to define information for this member
   * @param index index number in order to define information for this member
   */

  public void initializeFields(Member member, int index)
  {
    textFieldAddMemberName.setText(member.getName());
    textFieldAddMemberSurname.setText(member.getSurname());
    textFieldAddMemberAddress.setText(member.getAddress());
    textFieldAddMemberPhoneNumber.setText(member.getPhoneNumber());
    textFieldAddMemberEmail.setText(member.getEmail());
    checkBoxAddMemberMembership.setSelected(member.isPremiumMembership());
    textFieldAddMemberIndex.setText(String.valueOf(index));
  }

  /**
   * Method for initializing fields with data in edit class window
   * @param c Class object in order to define information for this Class
   * @param index index number in order to define information for this Class
   */

  public void initializeFieldsClasses(Class c, int index)
  {
    textFieldClassName.setText(c.getClassName());
    textFieldMaxMembers.setText(String.valueOf(c.getMaxMembers()));
    textFieldIndexClassesEdit.setText(String.valueOf(index));
  }

  /**
   * Method for initializing fields with data in edit schedule window
   * @param scheduledClasses ScheduledClasses object in order to define information for this scheduled class
   * @param index index number in order to define information for this scheduled class
   */

  public void initializeFieldsEditScheduledClasses(ScheduledClasses scheduledClasses, int index)
  {
    LocalDate localDate = LocalDate.of(scheduledClasses.getDate().getYear(), scheduledClasses.getDate().getMonth(), scheduledClasses.getDate().getDay());
    int x = 0;
    ArrayList<Class> allclasses = fileAdapter.getClasses();
    for(int i = 0; i < allclasses.size(); i++)
    {
      if(scheduledClasses.getClassNameClass().getClassName().equals(allclasses.get(i).getClassName()))
        x = i;
    }
    int c = 0;
    Instructor instructor = scheduledClasses.getInstructor();
    for(int y = 0; y < fileAdapter.getInstructors().size(); y++)
    {
      if(instructor.equals(fileAdapter.getInstructors().get(y))) c = y;
    }
    choiceBoxInstructor.getSelectionModel().select(x);
    choiceBoxScheduledInstructors.getSelectionModel().select(c);
    datePickerScheduledClass.setValue(localDate);
    textFieldAddScheduledClassTime.setText(scheduledClasses.getTime().toString());
    textFieldAddScheduledClassesDuration.setText(
        String.valueOf(scheduledClasses.getDuration()));
    scheduledClassesIndex.setText(String.valueOf(index));
  }

  /**
   * Method for initializing fields with data for instructor
   * @param instructor Instructor object in order to define information for this instructor fields
   * @param index index number in order to define information for this instructor fields
   */

  public void initializeFieldsInstructor(Instructor instructor, int index)
  {
    textFieldAddInstructorName2.setText(instructor.getName());
    textFieldAddInstructorSurname2.setText(instructor.getSurname());
    textFieldAddInstructorAddress2.setText(instructor.getAddress());
    textFieldAddInstructorPhoneNumber2.setText(instructor.getPhoneNumber());
    textFieldAddInstructorEmail2.setText(instructor.getEmail());
    textFieldAddInstructorIndex.setText(String.valueOf(index));
  }

  /**
   * Method for updating choice box of instructors
   */

  public void updateChoiceBoxInstructor()
  {
    int currentIndex = choiceBoxInstructor.getSelectionModel().getSelectedIndex();

    choiceBoxInstructor.getItems().clear();


    ArrayList<Class> classes = fileAdapter.getClasses();

    for (int i = 0; i < classes.size(); i++)
    {
      choiceBoxInstructor.getItems().add(classes.get(i).getClassName());
    }

    if (currentIndex == -1 && choiceBoxInstructor.getItems().size() > 0)
    {
      choiceBoxInstructor.getSelectionModel().select(0);
    }
    else
    {
      choiceBoxInstructor.getSelectionModel().select(currentIndex);
    }
  }

  /**
   * Method for updating choice box of instructors classes
   * @param instructor Instructor object in order to define information for this instructor choice box
   */

  public void updateChoiceBoxInstructorRemove(Instructor instructor)
  {
    int currentIndex = choiceBoxRemoveClass.getSelectionModel().getSelectedIndex();

    choiceBoxRemoveClass.getItems().clear();

    ArrayList<Class> classes = fileAdapter.getInstructor(instructor.getPhoneNumber()).getAllClassesInstructorTeaches();

    for (int i = 0; i < classes.size(); i++)
    {
      choiceBoxRemoveClass.getItems().add(classes.get(i).getClassName());
    }

    if (currentIndex == -1 && choiceBoxRemoveClass.getItems().size() > 0)
    {
      choiceBoxRemoveClass.getSelectionModel().select(0);
    }
    else
    {
      choiceBoxRemoveClass.getSelectionModel().select(currentIndex);
    }
  }

  /**
   * Method for updating choice box of instructors
   */

  public void updateChoiceBoxInstructors()
  {
    int currentIndex = choiceBoxScheduledInstructors.getSelectionModel().getSelectedIndex();

    choiceBoxScheduledInstructors.getItems().clear();


    ArrayList<Instructor> instructors = fileAdapter.getInstructors();

    for (int i = 0; i < instructors.size(); i++)
    {
      choiceBoxScheduledInstructors.getItems().add(instructors.get(i).getFullName());
    }

    if (currentIndex == -1 && choiceBoxScheduledInstructors.getItems().size() > 0)
    {
      choiceBoxScheduledInstructors.getSelectionModel().select(0);
    }
    else
    {
      choiceBoxScheduledInstructors.getSelectionModel().select(currentIndex);
    }
  }

  /**
   * Method for updating choice box of all members
   */

  public void updateChoiceBoxAllMembers()
  {
    int currentIndex = choiceBoxScheduledClassesAllMembers.getSelectionModel().getSelectedIndex();

    choiceBoxScheduledClassesAllMembers.getItems().clear();


    ArrayList<Member> members = fileAdapter.getMembers();

    for (int i = 0; i < members.size(); i++)
    {
      choiceBoxScheduledClassesAllMembers.getItems().add(members.get(i).getFullName());
    }

    if (currentIndex == -1 && choiceBoxScheduledClassesAllMembers.getItems().size() > 0)
    {
      choiceBoxScheduledClassesAllMembers.getSelectionModel().select(0);
    }
    else
    {
      choiceBoxScheduledClassesAllMembers.getSelectionModel().select(currentIndex);
    }
  }

  /**
   * Method for updating choice box of assigned members to the scheduled class
   * @param scheduledClasses ScheduledClasses object in order to define information for this choice box
   */

  public void updateChoiceBoxRemoveMembers(ScheduledClasses scheduledClasses)
  {
    int currentIndex = choiceBoxScheduledClassesAdded.getSelectionModel().getSelectedIndex();

    choiceBoxScheduledClassesAdded.getItems().clear();

    int index =0;
    for(int i = 0; i < fileAdapter.getScheduledClasses().size(); i++)
      if(fileAdapter.getScheduledClasses().get(i).equals(scheduledClasses)){
        index = i;
      }
    ArrayList<Member> members = fileAdapter.getScheduledClasses().get(index).getMembers();


    for (int i = 0; i < members.size(); i++)
    {
      choiceBoxScheduledClassesAdded.getItems().add(members.get(i).getFullName());
    }

    if (currentIndex == -1 && choiceBoxScheduledClassesAdded.getItems().size() > 0)
    {
      choiceBoxScheduledClassesAdded.getSelectionModel().select(0);
    }
    else
    {
      choiceBoxScheduledClassesAdded.getSelectionModel().select(currentIndex);
    }
  }
}