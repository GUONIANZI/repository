package arenzhenjava;

import java.util.Scanner;

public class Test {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("������ѧ�������������֣�");//����λ�û�Ӱ���Ƿ����
	int length=sc.nextInt();
	
	Student[] stus=new Student[length];
	
	for(int i=1;i<=length;i++){
		System.out.println("�������"+(i+1)+"��ѧ��������");
		String name=sc.next();
		System.out.println("�������"+(i+1)+"��ѧ�����Ա�");
		String sex=sc.next();
		System.out.println("�������"+(i+1)+"��ѧ��������");
		int age=sc.nextInt();
	}
}
}
