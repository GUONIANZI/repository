package t;

public abstract class Person {
String name;
String sex;
int age;
public Person(String name ,String sex,int age){
	this.name=name;
	this.sex=sex;
	this.age=age;
}
public void eat(){
	System.out.println("�һ�Է���");
	}

public abstract void show();


}
