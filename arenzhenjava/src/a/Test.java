package a;

import java.util.Scanner;

public class Test {
public static void main(String[] args) {
	//控制台输入学生的数量，
//	显示输入第i个学生的姓名，性别，年龄
	//输入完成后显示第i个学生的这些信息
	//然后再输入查找命令
	//如果查找到显示查找的学生信息 如果没查找到重新查找
Scanner sc= new Scanner(System.in);
System.out.println("请输入学生的数量(注意只能是数字)");
int length=sc.nextInt();
Student[] stus=new Student[length];
//控制台输入学生的数量完成
for(int i=0;i<length;i++){
	System.out.println("请输入第"+(i+1)+"个学生的姓名");
	String name=sc.next();
	System.out.println("请输入第"+(i+1)+"个学生的性别");
	String sex=sc.next();
	System.out.println("请输入第"+(i+1)+"个学生的年龄");
	int age=sc.nextInt();
	Student stu=new Student();
	stu.setName(name);
	stu.setSex(sex);
	stu.setAge(age);
	stus[i]=stu;
}
for(int i=0;i<length;i++){
System.out.println("第"+(i+1)+"个学生的信息是： "+" 姓名："+stus[i].getName()+
		" 性别："+stus[i].getSex()+" 年龄"+stus[i].getAge());
}
System.out.println("请输入您要查找的学生信息 1.姓名  2.性别 3.年龄");
int type=sc.nextInt();
if(type==1){
	System.out.println("请输入您要查找的学生姓名");
	String name=sc.next();
	for(int i=0;i<length;i++){
		if(name.equals(stus[i].name)){
			System.out.println("第"+(i+1)+"个学生的信息是： "+" 姓名："+stus[i].getName()+
					" 性别："+stus[i].getSex()+" 年龄"+stus[i].getAge());
		} 
		
	}
}
if(type==2){
	System.out.println("请输入您要查找的学生性别");
    String sex=sc.next();
    for(int i=0;i<length;i++){
		if(sex.equals(stus[i].name)){
			System.out.println("第"+(i+1)+"个学生的信息是： "+" 姓名："+stus[i].getName()+
					" 性别："+stus[i].getSex()+" 年龄"+stus[i].getAge());
		}
	}
}
if(type==3){
	System.out.println("请输入您要查找的学生年龄");
    int age=sc.nextInt();
    for(int i=0;i<length;i++){
		if(age==stus[i].age){
			System.out.println("第"+(i+1)+"个学生的信息是： "+" 姓名："+stus[i].getName()+
					" 性别："+stus[i].getSex()+" 年龄"+stus[i].getAge());
		}
	}
}


}
}
