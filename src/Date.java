import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;


/**
 * A class used for creating date objects
 * @author Gosia Drygala
 * @version 4.2.0
 */

public class Date implements Serializable
{
  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year){
    if(day < 1 || day > 31){
      throw new IllegalArgumentException("Invalid day: " + day);
    }
    else{
      this.day = day;
    }
    if(month < 1 || month > 12){
      throw new IllegalArgumentException("Invalid month: " + month);
    }
    else{
      this.month = month;
    }

    if(year < 0){
      throw new IllegalArgumentException("Invalid year: " + year);
    }
    else{
      this.year = year;
    }
  }


  public void setDay(int day){
    this.day = day;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public String dayOfWeek(){


    LocalDate localDate
        = LocalDate.of(year,
        month, day);


    DayOfWeek dayOfWeek
        = DayOfWeek.from(localDate);

    return String.valueOf(dayOfWeek);
  }
  public String toString(){
    String returnStr = "";
    if(day < 10){
      returnStr += "0" + day + "/";
    }
    else{
      returnStr += day + "/";
    }

    if(month < 10){
      returnStr += "0" + month + "/";
    }
    else{
      returnStr += month + "/";
    }

    return returnStr + year;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof Date)){
      return false;
    }

    Date other = (Date)obj;

    return day == other.day && month == other.month && year == other.year;
  }

  public Date copy(){
    return new Date(day, month, year);
  }
}
