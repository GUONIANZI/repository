package t;

public class Student extends Person{
	String number;
	
public Student(String name ,String sex,int age,String number){
	super(name, sex, age);
	this.number=number;
	
}
	public void study(){
		System.out.println("�һ�ѧϰ��");
		
	}
	public void show(){
		System.out.println(" ����:"+name+" �Ա�:"+sex+" ����: "+age+" ѧ��:"+number);
	}
	
}
