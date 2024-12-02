
import java.util.Scanner;

class Example{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*System.out.println("Please Enter an Integer : ");
        int num = input.nextInt();
        if(num>100){
            System.out.println("Greater than 100");
        }*/
       System.out.println("Enter Number 1 : ");
       int num1 = input.nextInt();
       System.out.println("Enter number 2 : ");
       int num2 = input.nextInt();
       if(num1>num2){
        System.out.println(num1 + " is greater than "+num2);
       }
        if(num1<num2){
            System.out.println(num2 + "is greater than "+num1);
       }
    }
}