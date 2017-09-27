package a;

public class Test02 {
public static void main(String[] args) {
	int a=5;
	int b=4;
	int c=a+b;
	int d=a-b;
	int e=a*b;
	int f=a/b;
    int g=a%b;
    System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g);
    a+=5;
    System.out.println(a);
    a-=4;
    System.out.println(a);
    a*=2;
    System.out.println(a);
    a/=4;
    System.out.println(a);
    a%=3;
    System.out.println(a);
    
    a=0;
    System.out.println(a);
    a=a+5;
    System.out.println(a);
    a+=5;
    System.out.println(a);
}
}

