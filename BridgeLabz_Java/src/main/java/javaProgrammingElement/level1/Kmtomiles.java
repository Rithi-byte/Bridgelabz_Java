package javaProgrammingElement.level1;
//Created a class Kmtomiles to convert kilometer to miles
//Return double type miles
public class Kmtomiles {
    public static void main(String[] args){
        //Create a variable to store the kilometer
        double kilometer=10.8;

        //Create a  variable to store the conversion
        //1 km=1.6 miles
        double kmtomiles=1.6;

        //Calculate the miles conversion
        double miles=kilometer*kmtomiles;

        //Print the conversion
        System.out.println("The distance " + kilometer+"km in miles is "+miles);

    }
}
