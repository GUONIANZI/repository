package t;

public class Teacher extends Person {

	String subject;
	
	public Teacher(String name ,String sex,int age,String subject){
		super(name, sex, age);
		this.subject=subject;
		
	}
	
	public void teach(){
		System.out.println("�һ��ѧ��");
	}
	public void show(){
		System.out.println(" ����:"+name+" �Ա�:"+sex+" ����: "+age+" ��Ŀ:"+subject);
	}
	
}
