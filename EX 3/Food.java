import java.util.Arrays;
import java.util.Collections;


public class Food implements Comparable<Food> { // Interfaces AND Generics, OMG!
    
    // Do not remove something from this array, but you may add to it...
    private static final String[] TYPES = {"Apple", "Pear", "Cookie", "Grape"};
    
    String type="";
    int calories=0;
    int score=0;
    
    public Food(String type, int calories) {
        // TODO: only allow objects of types that are listed in TYPES
    	for(String allowed:TYPES)
        {
            if (type == allowed)
            {
                this.type=type;
                this.calories=calories;
            }
        }
        score = this.type.length() * this.calories;
    }
    public String toString(){
         // TODO: return a String with the attributes
    	String attri = this.type + " : " + this.calories ;
        return attri;
    }
    public int compareTo(Food o) {
        // TODO: make the food comparable

        if(score==o.score)
        {
           return 0;
        }
        else if(score>o.score)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    
    public String getType() {
        // TODO: return type
    	return this.type;
    }
    
    public int getCalories() {
        // TODO: return property
    	 return this.calories;
    }
    
    public static Food[] createSortedRandomList(int n) {
        // TODO: create a list with n random instances and sort them
    	Food[] foods = new Food[n];
        for(int i=0;i<foods.length;i++)
        {
            int index = (int)(Math.random() * 4);
            int cal = (int)(Math.random() * 100) + 1;
            foods[i]= new Food(TYPES[index],cal);

        }
        Arrays.sort(foods);
        return foods;
    }

    public static void main(String[] args) {
        // TODO: your test cases
    	 Food[] myFoods = createSortedRandomList(20);
         for(int i=0;i< myFoods.length;i++)
         {
             System.out.println(myFoods[i].toString());
         }
    }

}



/********************************************************************************************************************

MEMBERS OF THE SAME GROUP (We did some of the work together)

Chiedozie Okolo    

Minh Hoang


**************************************************************************************************************************/
