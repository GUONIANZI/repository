package a;

public class Test01 {
public static void main(String[] args) {
	int a=5;
	int b=6;// “常数，字面量，常量”
	System.out.println(a);
	System.out.println(b);
	int c=0;
	c=a;
	a=b;
	b=c;
	System.out.println("交换后: ");
	System.out.println(a);
	System.out.println(b);
}
}
