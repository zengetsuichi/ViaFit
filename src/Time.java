import java.io.Serializable;
/**
 * A class used for creating time objects
 * @author Gosia Drygala
 * @version 4.2.0
 */

public class Time implements Serializable
{
  private int hour;
  private int minute;


  public Time(int hour, int minute){
    if(hour < 0 || hour > 24){
      throw  new IllegalArgumentException("Invalid hour! " + hour);
    }
    else{
      this.hour = hour;
    }
    if(minute < 0 || minute > 59){
      throw new IllegalArgumentException("Invalid minutes!" + minute);
    }
    else{
      this.minute = minute;
    }
  }

  public void setHour(int hour)
  {
    this.hour = hour;
  }

  public void setMinute(int minute)
  {
    this.minute = minute;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public boolean equals(Object obj){
    if(!(obj instanceof Time)){
      return false;
    }

    Time other = (Time)obj;

    return hour == other.hour && minute == other.minute;

  }

  public String toString(){
    String returnStr = "";
    if(hour < 10){
      returnStr += "0" + hour + ":";
    }
    else{
      returnStr += hour + ":";
    }

    if(minute < 10){
      returnStr += "0" + minute ;
    }
    else{
      returnStr += minute;
    }

    return returnStr;

  }

  public Time copy(){
    return new Time(hour, minute);
  }

}
