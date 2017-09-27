package arenzhenjava;

import java.util.Scanner;

public class Test {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("请输入学生的数量（数字）");//他的位置会影响是否输出
	int length=sc.nextInt();
	
	Student[] stus=new Student[length];
	
	for(int i=1;i<=length;i++){
		System.out.println("请输入第"+(i+1)+"个学生的名字");
		String name=sc.next();
		System.out.println("请输入第"+(i+1)+"个学生的性别");
		String sex=sc.next();
		System.out.println("请输入第"+(i+1)+"个学生的年龄");
		int age=sc.nextInt();
	}
}
}
