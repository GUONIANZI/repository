package c;

import java.util.Scanner;

public class Test {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("请输入学生的数量");
	int length=sc.nextInt();
	Student[] stus=new Student[length];
	System.out.println("请输入学生的信息");
	for(int i=0;i<length;i++){
		System.out.println("请输入第"+(i+1)+"个学生的姓名");
		String name=sc.next();
		System.out.println("请输入第"+(i+1)+"个学生的性别");
		String sex=sc.next();
		System.out.println("请输入第"+(i+1)+"个学生的年龄");
		int age=sc.nextInt();
		Student stu =new Student();
		stu.setName(name);
		stu.setSex(sex);
		stu.setAge(age);
		stus[i]=stu;
	}
	for(int i=0;i<length;i++){
		System.out.println("第"+(i+1)+"个学生的信息是："+" 姓名:"+stus[i].getName()+" 性别:"+stus[i].getSex()
				        +" 年龄:"+stus[i].getAge());
	}
	System.out.println("请输入你要查找的信息 1-姓名 2-性别 3-年龄");
	int type=sc.nextInt();
	if(type==1){
		System.out.println("请输入姓名");
		String name=sc.next();
		for(int i=0;i<length;i++){
			if(name.equals(stus[i].getName())){
				System.out.println("第"+(i+1)+"个学生的信息是："+" 姓名:"+stus[i].getName()+" 性别:"+stus[i].getSex()
				        +" 年龄:"+stus[i].getAge());
			}
		}
		
	}
     if(type==2){
		System.out.println("请输入性别");
		String sex=sc.next();
		for(int i=0;i<length;i++){
			if(sex.equals(stus[i].getName())){
				System.out.println("第"+(i+1)+"个学生的信息是："+" 姓名:"+stus[i].getName()+" 性别:"+stus[i].getSex()
				        +" 年龄:"+stus[i].getAge());
			}
		}
	}
     if(type==3){
	System.out.println("请输入年龄");
	int age=sc.nextInt();
	for(int i=0;i<length;i++){
		if(age==stus[i].getAge()){
			System.out.println("第"+(i+1)+"个学生的信息是："+" 姓名:"+stus[i].getName()+" 性别:"+stus[i].getSex()
			        +" 年龄:"+stus[i].getAge());
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
