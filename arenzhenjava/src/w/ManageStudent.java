package w;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//�����ع�,��ArrayList�ķ�������һ��
public class ManageStudent {
	Scanner sc = new Scanner(System.in);
	int index;
	List<Student> list=new ArrayList<Student>();
	public void inPutStudent() {
		System.out.println("��¼��ѧ������(ע��ֻ��������)");
		int length = sc.nextInt();
		for (int i = 0; i <length; i++) {
			System.out.println("������ѧ��������" + (index + 1) + "��ѧ��������");
			String name = sc.next();
			System.out.println("������ѧ��������" + (index + 1) + "��ѧ�����Ա�");
			String sex = sc.next();
			System.out.println("������ѧ��������" + (index + 1) + "��ѧ��������");
			int age = sc.nextInt();
			Student stu = new Student();
			stu.setName(name);
			stu.setSex(sex);	
			stu.setAge(age);
			list.add(stu);
			index++;
			output();
		}
	}
	public void output(){
		try {
			FileOutputStream fos = new FileOutputStream("f:/test/manager.txt");//���⸲��
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(list);
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Input(){
		try {
			FileInputStream fis= new FileInputStream("f:/test/manager.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			list=(ArrayList<Student>)ois.readObject();
			for(int i=0;i<list.size();i++){
				System.out.println("����"+list.get(i).getName()+" �Ա�"+list.get(i).getSex()
			    		+" ����"+list.get(i).getAge());
			}
			fis.close();
			ois.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void showStudent(){
		Input();
//		if(index!=0){
//		for( int i=0;i<list.size();i++){
//	    System.out.println("����"+list.get(i).getName()+" �Ա�"+list.get(i).getSex()
//	    		+" ����"+list.get(i).getAge());
//		}
//		}
//		else{
//			System.out.println("û��ѧ������");
//	}
	}
	public void searchStudent() {
		if(index!=0){
		for (int j = 0; ; j++) {// ��ѭ���������һֱ����
			System.out.println("������Ҫ���ҵ�����   1 ����  2 �Ա�  3 ����");
			int type = sc.nextInt();
			if (type == 1) {
				searchByName();
			} else if (type == 2) {
				searchBySex();
			} else if (type == 3) {
				searchByAge();
			} else {
				System.out.println("������1-3������");
			}
		}
		}
		else {
			System.out.println("û��ѧ������");
		}

	}
	public void searchByName() {
		System.out.println("������Ҫ����ѧ��������");
		String name = sc.next();
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {// ���forѭ�������鿴�Ƿ�����ͬ��
			if (list.get(i).getName().equals(name)) {
				flag = false;
				    System.out.println("����"+list.get(i).getName()+" �Ա�"+list.get(i).getSex()
				    		+" ����"+list.get(i).getAge());
					
			}
			continue;
		}
		if (flag == true) {
			System.out.println("���޴���");
		}
		}
	public void searchBySex() {
		System.out.println("������Ҫ����ѧ�����Ա�");
		String sex = sc.next();
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {// ���forѭ�������鿴�Ƿ�����ͬ��
			if (list.get(i).getSex().equals(sex)) {
				flag = false;
				    System.out.println("����"+list.get(i).getName()+" �Ա�"+list.get(i).getSex()
				    		+" ����"+list.get(i).getAge());
					}
			continue;
		}
		if (flag == true) {
			System.out.println("���޴���");
		}

	}
	public void searchByAge() {
		System.out.println("������Ҫ����ѧ��������");
		int age = sc.nextInt();
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {// ���forѭ�������鿴�Ƿ�����ͬ��
			if (list.get(i).getAge()==age) {
				flag = false;
				    System.out.println("����"+list.get(i).getName()+" �Ա�"+list.get(i).getSex()
				    		+" ����"+list.get(i).getAge());	
			}
			continue;
		}
		if (flag == true) {
			System.out.println("���޴���");
		}
	}
	public static void main(String[] args) {
		// ����ģʽ
		ManageStudent ms=new ManageStudent();
		while(true){
			System.out.println("1¼��  2չʾ  3��ѯ  0�˳�");
	    int type=ms.sc.nextInt();
	    if(type==0){
	    	break;
	    }
	    else if(type==1){
	    	 ms.inPutStudent();
	    }
	    else if(type==2){
	    	 ms.showStudent();
	    }
	    else if(type==3){
	    	 ms.searchStudent();
	    }
		}
	    
	   
	   
	}
}
