package a;

public class Test01 {
public static void main(String[] args) {
	int a=5;
	int b=6;// ����������������������
	System.out.println(a);
	System.out.println(b);
	int c=0;
	c=a;
	a=b;
	b=c;
	System.out.println("������: ");
	System.out.println(a);
	System.out.println(b);
}
}
