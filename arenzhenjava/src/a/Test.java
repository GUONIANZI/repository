package a;

import java.util.Scanner;

public class Test {
public static void main(String[] args) {
	//����̨����ѧ����������
//	��ʾ�����i��ѧ�����������Ա�����
	//������ɺ���ʾ��i��ѧ������Щ��Ϣ
	//Ȼ���������������
	//������ҵ���ʾ���ҵ�ѧ����Ϣ ���û���ҵ����²���
Scanner sc= new Scanner(System.in);
System.out.println("������ѧ��������(ע��ֻ��������)");
int length=sc.nextInt();
Student[] stus=new Student[length];
//����̨����ѧ�����������
for(int i=0;i<length;i++){
	System.out.println("�������"+(i+1)+"��ѧ��������");
	String name=sc.next();
	System.out.println("�������"+(i+1)+"��ѧ�����Ա�");
	String sex=sc.next();
	System.out.println("�������"+(i+1)+"��ѧ��������");
	int age=sc.nextInt();
	Student stu=new Student();
	stu.setName(name);
	stu.setSex(sex);
	stu.setAge(age);
	stus[i]=stu;
}
for(int i=0;i<length;i++){
System.out.println("��"+(i+1)+"��ѧ������Ϣ�ǣ� "+" ������"+stus[i].getName()+
		" �Ա�"+stus[i].getSex()+" ����"+stus[i].getAge());
}
System.out.println("��������Ҫ���ҵ�ѧ����Ϣ 1.����  2.�Ա� 3.����");
int type=sc.nextInt();
if(type==1){
	System.out.println("��������Ҫ���ҵ�ѧ������");
	String name=sc.next();
	for(int i=0;i<length;i++){
		if(name.equals(stus[i].name)){
			System.out.println("��"+(i+1)+"��ѧ������Ϣ�ǣ� "+" ������"+stus[i].getName()+
					" �Ա�"+stus[i].getSex()+" ����"+stus[i].getAge());
		} 
		
	}
}
if(type==2){
	System.out.println("��������Ҫ���ҵ�ѧ���Ա�");
    String sex=sc.next();
    for(int i=0;i<length;i++){
		if(sex.equals(stus[i].name)){
			System.out.println("��"+(i+1)+"��ѧ������Ϣ�ǣ� "+" ������"+stus[i].getName()+
					" �Ա�"+stus[i].getSex()+" ����"+stus[i].getAge());
		}
	}
}
if(type==3){
	System.out.println("��������Ҫ���ҵ�ѧ������");
    int age=sc.nextInt();
    for(int i=0;i<length;i++){
		if(age==stus[i].age){
			System.out.println("��"+(i+1)+"��ѧ������Ϣ�ǣ� "+" ������"+stus[i].getName()+
					" �Ա�"+stus[i].getSex()+" ����"+stus[i].getAge());
		}
	}
}


}
}
