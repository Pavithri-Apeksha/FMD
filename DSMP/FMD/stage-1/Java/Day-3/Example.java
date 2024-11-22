import java.util.Scanner;
class Example{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        /*int x,y,z;
        System.out.println("Enter Number 1 :");
        x = input.nextInt();
        System.out.println("Enter Number 2 :");
        y=input.nextInt();
        z=x+y;
        System.out.println(x+"+"+y+"="+z);*/

        /*System.out.println("Enter Your age : ");
        int age = input.nextInt();
        System.out.println("Your age is : "+ age);
        System.out.println("After 10 years your Age is : "+(age+10));*/

        //primitive data types
        /*byte x;
        x  = 100;//[-128,128)
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.err.println(Short.MIN_VALUE);
        System.err.println(Integer.MAX_VALUE);
        System.err.println(Integer.MIN_VALUE);*/

        /*byte b = 10;
        short sh = 100;
        int i = 200;
        long l = 200L;
        float f = 10.5F;
        double d = 10.5;
        char ch = 'A';
        boolean bool = true;*/

        //Conversion and casting
        //conversion
        /*int x;
        byte b = 100;
        x = b;*/

        //casting
        final int x  = 100;
        byte b = x;

        int y = 1000;
        byte by = (byte)y;
    }
}