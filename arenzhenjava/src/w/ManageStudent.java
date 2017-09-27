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
//方法重构,用ArrayList的方法再做一遍
public class ManageStudent {
	Scanner sc = new Scanner(System.in);
	int index;
	List<Student> list=new ArrayList<Student>();
	public void inPutStudent() {
		System.out.println("请录入学生数量(注意只能是数字)");
		int length = sc.nextInt();
		for (int i = 0; i <length; i++) {
			System.out.println("请输入学生姓名第" + (index + 1) + "个学生的名字");
			String name = sc.next();
			System.out.println("请输入学生姓名第" + (index + 1) + "个学生的性别");
			String sex = sc.next();
			System.out.println("请输入学生姓名第" + (index + 1) + "个学生的年龄");
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
			FileOutputStream fos = new FileOutputStream("f:/test/manager.txt");//避免覆盖
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
				System.out.println("姓名"+list.get(i).getName()+" 性别"+list.get(i).getSex()
			    		+" 年龄"+list.get(i).getAge());
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
//	    System.out.println("姓名"+list.get(i).getName()+" 性别"+list.get(i).getSex()
//	    		+" 年龄"+list.get(i).getAge());
//		}
//		}
//		else{
//			System.out.println("没有学生数据");
//	}
	}
	public void searchStudent() {
		if(index!=0){
		for (int j = 0; ; j++) {// 死循环让其可以一直查找
			System.out.println("请输入要查找的条件   1 姓名  2 性别  3 年龄");
			int type = sc.nextInt();
			if (type == 1) {
				searchByName();
			} else if (type == 2) {
				searchBySex();
			} else if (type == 3) {
				searchByAge();
			} else {
				System.out.println("请输入1-3的数字");
			}
		}
		}
		else {
			System.out.println("没有学生数据");
		}

	}
	public void searchByName() {
		System.out.println("请输入要查找学生的姓名");
		String name = sc.next();
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {// 这个for循环用来查看是否有相同的
			if (list.get(i).getName().equals(name)) {
				flag = false;
				    System.out.println("姓名"+list.get(i).getName()+" 性别"+list.get(i).getSex()
				    		+" 年龄"+list.get(i).getAge());
					
			}
			continue;
		}
		if (flag == true) {
			System.out.println("查无此人");
		}
		}
	public void searchBySex() {
		System.out.println("请输入要查找学生的性别");
		String sex = sc.next();
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {// 这个for循环用来查看是否有相同的
			if (list.get(i).getSex().equals(sex)) {
				flag = false;
				    System.out.println("姓名"+list.get(i).getName()+" 性别"+list.get(i).getSex()
				    		+" 年龄"+list.get(i).getAge());
					}
			continue;
		}
		if (flag == true) {
			System.out.println("查无此人");
		}

	}
	public void searchByAge() {
		System.out.println("请输入要查找学生的年龄");
		int age = sc.nextInt();
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {// 这个for循环用来查看是否有相同的
			if (list.get(i).getAge()==age) {
				flag = false;
				    System.out.println("姓名"+list.get(i).getName()+" 性别"+list.get(i).getSex()
				    		+" 年龄"+list.get(i).getAge());	
			}
			continue;
		}
		if (flag == true) {
			System.out.println("查无此人");
		}
	}
	public static void main(String[] args) {
		// 门面模式
		ManageStudent ms=new ManageStudent();
		while(true){
			System.out.println("1录入  2展示  3查询  0退出");
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
