package t;

public class Student extends Person{
	String number;
	
public Student(String name ,String sex,int age,String number){
	super(name, sex, age);
	this.number=number;
	
}
	public void study(){
		System.out.println("我会学习！");
		
	}
	public void show(){
		System.out.println(" 姓名:"+name+" 性别:"+sex+" 年龄: "+age+" 学号:"+number);
	}
	
}
