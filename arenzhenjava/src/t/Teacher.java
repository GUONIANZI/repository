package t;

public class Teacher extends Person {

	String subject;
	
	public Teacher(String name ,String sex,int age,String subject){
		super(name, sex, age);
		this.subject=subject;
		
	}
	
	public void teach(){
		System.out.println("我会教学！");
	}
	public void show(){
		System.out.println(" 姓名:"+name+" 性别:"+sex+" 年龄: "+age+" 科目:"+subject);
	}
	
}
