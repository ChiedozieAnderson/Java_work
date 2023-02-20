import java.util.ArrayList;

public class Clock {
   private int h;      
   private int min; 
   
   public int getMin() {
      return min;
   }
   
   public int getH() {
      return h;
   }
   public void setMin(int min) {
       this.min =min;
   }

   public void setH(int h) {
       this.h = h % 24;
   }
   
   //1st Constructor
   public Clock()
   {
       min=0;
       h=0;
   }

   public Clock(int h,int min)
   {
       this.min=min%60;
       this.h= (h + (min/60)) % 24;
   }

   public Clock(int min)
   {
           this.h=(min/60)%24;
           this.min = min%60;
   }
   
   public Clock(String time)
   {
       String hr="";
       String min = "";
       for(int i=0;i<time.length();i++)
       {
           if(time.charAt(i)==':')
           {
               hr = time.substring(0,i);
               min = time.substring(i+1);
           }
       }
       int quo =  Integer.parseInt(min) / 60;
       this.min = Integer.parseInt(min) % 60;
       this.h =  (Integer.parseInt(hr) + quo)%24 ;
   }
   
   // TODO: insert all required constructors
   
   public Clock add(int min) {
      // TODO: implementation
	   Clock newClock = new Clock();
       newClock.setH(this.h);
       newClock.setMin(this.min);

       int minute = newClock.min + min;
       newClock.min = minute%60;
       newClock.h = (newClock.h + minute / 60)%24;
       return newClock;

   }
   public Clock add(Clock c) {
      // TODO: implementation
	        Clock newClock = new Clock();
	        newClock.setH(this.h);
	        newClock.setMin(this.min);

	        int minute = newClock.min + c.min;
	        newClock.min = minute%60;
	        newClock.h = (newClock.h + (minute / 60) + c.h)%24;
	        return newClock;

   }
   
   public String toString() {
      // TODO: implementation
	   String hString;
       String mString;
       String result;

      if(this.min<10)
      {
          mString = "0" + Integer.toString(this.min); ;
      }
      else
      {
          mString = Integer.toString(this.min);;
      }
      if(this.h<10)
      {
          hString = "0" + Integer.toString(this.h) ;
      }
      else
      {
          hString = Integer.toString(this.h);
      }
      result = hString + ":" + mString;
      return result;

   }
   public static void main(String[] args) {
      // TODO: insert test cases
	   int minute = (int)(Math.random() * 121) + 1;
       int hour = (int)(Math.random() * 25) + 1;
       System.out.println("The input numbers are : " + hour + ":" + minute);
       Clock clock1 = new Clock(hour,minute);
       System.out.println(clock1.toString());

       Clock clock3 =clock1.add(60);
       System.out.println(clock3.toString());

       Clock clock2 = new Clock("01:30");
       System.out.println("The clock created by string : " + clock2.toString());

       clock3= clock3.add(clock2);
       System.out.println(clock3.toString());

   }
}


/********************************************************************************************************************

MEMBERS OF THE SAME GROUP (We did some of the work together)

Chiedozie Okolo    

Minh Hoang


**************************************************************************************************************************/ 