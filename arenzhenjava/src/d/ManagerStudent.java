package d;
import java.util.Scanner;
//�����ع�
public class ManagerStudent {
	Student[] stus; //Student[] stus=null;
	Scanner sc = new Scanner(System.in);
	int index;
	public void inPutStudent() {
		System.out.println("��¼��ѧ������(ע��ֻ��������)");
		int length = sc.nextInt();
		if(stus==null){// if{}�����еĹ��������ܹ��洢�տ�ʼ��������ݣ�
			stus = new Student[length];//��һ��ѭ��ִֻ����һ��ֱ�������´�forѭ��ʵ��
		}
		else{
			//�½���һ�����飬���ݣ���ת����
			Student[] temps=new Student[stus.length+length];
//			��ԭ��������ݸ�ֵ��������
			for(int i=0;i<stus.length;i++){
				temps[i]=stus[i];//�����������һ��
			}
			stus=temps;	//��¼���ݲ�����	
		}
		for (int i = 0; i <length; i++) {
			System.out.println("������ѧ��������" + (index + 1) + "��ѧ��������");
			String name = sc.next();
			System.out.println("������ѧ��������" + (index + 1) + "��ѧ�����Ա�");
			String sex = sc.next();
			System.out.println("������ѧ��������" + (index + 1) + "��ѧ��������");
			int age = sc.nextInt();
			// ��ʼ����������Student������
			Student stu = new Student();
			stu.setName(name);
			stu.setSex(sex);
			stu.setAge(age);
			stus[index] = stu;// ������������
			index++;
		}
	}

	public void showStudent(){
		if(stus!=null){
		for(int i=0;i<stus.length;i++){
			System.out.println(" ������"+stus[i].getName()+" �Ա�"
					+ ""+stus[i].getSex()+" ���䣺"+stus[i].getAge());
		}
		}
		else{
			System.out.println("û��ѧ������");
	}
	}
	public void searchStudent() {
		if(stus!=null){
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
		else{
			System.out.println("û��ѧ������");
		}

	}
	public void searchByName() {
		System.out.println("������Ҫ����ѧ��������");
		String name = sc.next();
		boolean flag = true;
		for (int i = 0; i < stus.length; i++) {// ���forѭ�������鿴�Ƿ�����ͬ��
			if (stus[i].getName().equals(name)) {
				flag = false;
				System.out.println(" ������" + stus[i].getName() + " �Ա�" + ""
						+ stus[i].getSex() + " ���䣺" + stus[i].getAge());
			}
			break;
		}
		if (flag == true) {
			System.out.println("���޴���");
		}
		}
	public void searchBySex() {
		System.out.println("������Ҫ����ѧ�����Ա�");
		String sex = sc.next();
		boolean flag = true;
		for (int i = 0; i < stus.length; i++) {// ���forѭ�������鿴�Ƿ�����ͬ��
			if (stus[i].getSex().equals(sex)) {
				flag = false;
				System.out.println(" ������" + stus[i].getName() + " �Ա�" + ""
						+ stus[i].getSex() + " ���䣺" + stus[i].getAge());
			}
			break;
		}
		if (flag == true) {
			System.out.println("���޴���");
		}

	}
	public void searchByAge() {
		System.out.println("������Ҫ����ѧ��������");
		int age = sc.nextInt();
		boolean flag = true;
		for (int i = 0; i < stus.length; i++) {// ���forѭ�������鿴�Ƿ�����ͬ��
			if (stus[i].getAge() == age) {
				flag = false;
				System.out.println(" ������" + stus[i].getName() + " �Ա�" + ""
						+ stus[i].getSex() + " ���䣺" + stus[i].getAge());
			}
			break;
		}
		if (flag == true) {
			System.out.println("���޴���");
		}
	}
//	public void xunhuan(){
//		System.out.println("��ӭ����ѧ������ϵͳ��");
//		for(int j=0;;j++){
//			System.out.println("1 ¼�� 2 չʾ 3 ��ѯ ");
//			int type=sc.nextInt();
//		if(type==1){
////			
//			for(int i=0;i<1;i++){
//				inPutStudent();
////				
//				continue;
//				}
//			
//			}
//		if(type==2){
//			boolean flag=true;
//			for(int i=0;i<2;i++){
//				if(i==0){
//					System.out.println("����������ѧ������!");
//					flag=false;
//					continue;	
//				}
//				if(flag){
//					showStudent();
//				}
//			}
//			}	
//		else if(type==3){
//			boolean flag=true;
//			for(int i=0;i<2;i++){
//				if(i==0){
//					System.out.println("����������ѧ������");
//					flag=false;
//					continue;
//				}
//				if(flag){
//				searchStudent();
//				}
//			}
//		}	
//	}
//	}
	public static void main(String[] args) {
		// ����ģʽ
		ManagerStudent ms=new ManagerStudent();
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

