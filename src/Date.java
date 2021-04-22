import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable <Date>{

  public int day;

  public int month;

  public int year;

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public static void main(String[] args) {
    Date d= new Date();
    System.out.println("Dia: " +d.day +" Mes: " +d.month + " Ano: " +d.year);
    System.out.println(d.toString());
  }
  public Date() {
    GregorianCalendar c=new GregorianCalendar();
    this.day = c.get(Calendar.DAY_OF_MONTH);
    this.month = c.get(Calendar.MONTH)+1;
    this.year = c.get(Calendar.YEAR);
  }
public Date(Date d){
    this.day =d.day;
    this.month =d.month;
    this.year =d.year;
}
  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    if(day<32 && day>0){
    this.day = day;}
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    if(month>0 && month<13){
    this.month = month;
  }}

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    if(year<0){
    this.year = year;
  }}

  public boolean beforeDate(Date d) {
    if(this.year == d.year){
      if(this.month == d.month){
        if(this.day == d.day){
          return false;
        }
        else{
          if(this.day > d.day){
            return false;
          }else{
            return true;
          }
        }
      }
      else {
        if(this.month > d.month){
          return false;
        } else {
          return true;
        }
      }
    } else {
      if(this.year > d.year){
        return false;
      }
      else{
        return true;
      }
    }
  }

  public boolean afterDate(Date d) {
  //if(this.compareTo(d)>0 ){
    //return true;
  //}
  //return false;
    return this.compareTo(d) > 0;
    //return !this.beforeDate(d);
  }

  public boolean isLeapYear(int year) {
    return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

  }

  @Override
  public String toString() {
    return "Date{" +
            "day=" + day +
            ", month=" + month +
            ", year=" + year +
            '}';
  }

  public void incrementDate() {
    if(this.day < daysMonth(this.month,this.year)){
      day+=1;
    }
    else{
      if(this.month==12){
        month=1;
        year+=1;
        day=1;
      }else{
      month+=1;
      day=1;
    }
    }

  }
  private   int differnceYear(Date d){
    if(this.year==d.year){
      return differenceMonths(this,d);
    }

    int ndias=differenceMonths(this,new Date(31,12,this.year));
      while(this.year <d.year){
        if(isLeapYear(this.year)){
          ndias+=366;
        }else{
          ndias+=365;
        }
        this.year+=1;
      }
    ndias+=differenceMonths(new Date(1,1,this.year),d);
      return ndias;
  }

  private static  int differenceMonths(Date begin,Date end) {
    if(begin.month==end.month){
      return end.day- begin.day;
    }
  int ndias= begin.daysMonth(begin.month, begin.year);
  int daycounter=ndias-begin.day;
  begin.setMonth(begin.month+1);
  begin.setDay(1);
  while(begin.month<end.month){
    daycounter= begin.daysMonth(begin.month, begin.year);
    begin.setMonth(begin.month+1);

  }
  daycounter+=end.day;
  return daycounter;
  }
  private static int daysCrawlerAux(Date begin,Date end){
    if(begin.equals(end)){
      return 0;
    }
    begin.incrementDate();
    return 1+daysCrawlerAux(begin, end);
  }
  private static int daysCrawlerRecursive(Date begin,Date end){
   if(end.year- begin.year<10){
     return daysCrawlerAux(begin, end);
   }
   int daysCount=0;
   while(end.year- begin.year>10){
     Date b2=new Date(begin);
     b2.year= b2.year+10;
     daysCount+=daysCrawlerAux(begin,b2);
   }
   daysCount+=daysCrawlerAux(begin, end);
   return daysCount;
  }

  public int compareTo(Date d) {
  if(this.year ==d.year && this.month == d.month && this.day == d.day){
    return 0;
  }else{
    if(this.year == d.year){
      if(this.month == d.month){
        return this.day- d.day /Math.abs(this.day - d.day);
      }else{
        return this.month - d.month /Math.abs(this.month - d.month);
      }
    }else{
      return this.year - d.year /Math.abs(this.year - d.year);
    }
  }
  }

  public int daysMonth(int month,int year) {
    switch (month){
         case 4:
         case 6:
         case 9:
         case 11:return 30;
         case 2:if(this.isLeapYear(year)){
                return 29;
         }
         else return 28;
      default:return 31;
    }
  }

}