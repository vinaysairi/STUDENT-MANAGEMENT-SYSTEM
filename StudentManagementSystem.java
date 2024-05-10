package collectionEX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student1{
	private String s_name;
	private int s_id;
	private String dept;
	
	//constructor
	public Student1(String s_name, int s_id, String dept) {
		super();
		this.s_name = s_name;
		this.s_id = s_id;
		this.dept = dept;
	}
	
	//Getter and Setter Methods


	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "student [s_name=" + s_name + ", s_id=" + s_id + ", dept=" + dept + "]";
	}

	public void add(Student1 student) {
		// TODO Auto-generated method stub
		
	}
	
	//to String Method
	
	
}


public class StudentManagementSystem {

	public static void main(String[] args) {
      ArrayList<Student1> studentList = new ArrayList<Student1>();
      Scanner sc = new Scanner(System.in);
      int choice;
      do {
    	  System.out.println("-------MENU--------");
    	  System.out.println("1.ADD STUDENT");
    	  System.out.println("2.DISPLAY");
    	  System.out.println("3.UPDATE STUDENT");
    	  System.out.println("4.DELETE STUDENT");
    	  System.out.println("5.SEARCH STUDENT");
    	  System.out.println("6.COUNT STUDENT");
    	  System.out.println("7.Sorting");
    	  System.out.println("8.EXIT");
		System.out.println("ENTER YOUR CHOICE : ");
		choice = sc.nextInt();
		
		//switch 
		switch (choice) {
		case 1:
			addStudent(studentList, sc);
			break;
		case 2:
			display(studentList);
            break;
		case 3:
			update(studentList, sc);
			break;
		case 4:
			DeleteStudent(studentList, sc);
			break;
		case 5:
			searchStudent(studentList, sc);
			break;
		case 6:
			countStudent(studentList);
			break;
		case 7:
			sortStudent(studentList, sc);
			break;
		case 8:
			System.out.println("------EXITING-------");
		default:
			System.out.println("Invalid");
			break;
		}
	} while (choice !=8);   
	
	}

//Creating StudentList

private static void addStudent(ArrayList<Student1>studentList,Scanner sc) {
	System.out.println("Enter the name of the student : ");
	String name = sc.next();
	System.out.println("Enter the ID of the student : ");
	int id = sc.nextInt();
	System.out.println("Enter the Department of the student : ");
	String dept = sc.next();
	Student1 student=new Student1(name, id, dept);
	studentList.add(student);
	System.out.println("Student List Added Succesfully!");
 
      }
//Display

private static void display(ArrayList<Student1>studentList) {
	if(studentList.isEmpty()) {
		System.out.println("No Student Found1");
	}
	else {
		System.out.println("----List of Elements----");
		for(Student1 stu:studentList)
			System.out.println(stu);
	}
 }

//UPDATE

private static void update(ArrayList<Student1>studentList,Scanner sc) {
	if (studentList.isEmpty()) {
		System.out.println("No Student Found");
	}else {
		System.out.println("Enter student Id to Update");
		int id =sc.nextInt();
		boolean found = false;
		for(Student1 stu : studentList) {
			if(stu.getS_id()==id) {
			found=true;
			System.out.println("Enter new Student Name : ");
			String newName=sc.next();
			System.out.println("Enter new Department : ");
			String newDept = sc.next();
			stu.setS_name(newName);
			stu.setDept(newDept);
			System.out.println("Student Updated");
			break;
		}
	  }
		if (!found) {
			System.out.println("Student with Id "+id+"not found");
		}
	}
 }

//DElETE

private static void DeleteStudent(ArrayList<Student1> studentList,Scanner sc) {
	if (studentList.isEmpty()) {
		System.out.println("No Student Found");
	} else {
		System.out.println("Enter the student Id to Delete");
		int id = sc.nextInt();
		boolean found = false;
		for(Student1 stu : studentList) {
			if(stu.getS_id()==id) {
				found=true;
				studentList.remove(stu);
				System.out.println("Student Removed Succesfully");
				break;		
			}
		}
		if (!found) {
			System.out.println("Student with Id "+id+"not found");
		}
			
	}
}

//SEARCH STUDENT

private static void searchStudent(ArrayList<Student1> studentlList,Scanner sc) {
	if(studentlList.isEmpty()) {
		System.out.println("No Student Found");
	} else {
		System.out.println("Enter Student ID To Search");
		int id = sc.nextInt();
		boolean found = false;
		for(Student1 stu: studentlList) {
			if(stu.getS_id()==id) {
				found = true;
				System.out.println("Student Found");
				System.out.println(stu);
				break;
			}
		}
		if (!found) {
			System.out.println("Student with Id "+id+"not found");
		}
	}
}

//Count Number of Student

private static void countStudent(ArrayList<Student1> studentList) {
	System.out.println("Total Number Of Students : "+studentList.size());
}

//Sorting

private static void sortStudent(ArrayList<Student1> studentList,Scanner sc) {
	if (studentList.isEmpty()) {
		System.out.println("No Record found");
	}else {
		System.out.println("1.Sort By Student Name");
		System.out.println("2.Sort By Student ID");
		System.out.println("3.Sort By Student Department");
		int sortChoice = sc.nextInt();
		switch (sortChoice) {
		case 1:
			Collections.sort(studentList,Comparator.comparing(Student1::getS_name));
			System.out.println(studentList);
			break;
		case 2:
			Collections.sort(studentList,Comparator.comparing(Student1::getS_id));
			System.out.println(studentList);
			break;
		case 3:
			Collections.sort(studentList,Comparator.comparing(Student1::getDept));
			System.out.println(studentList);
			break;

		default:
			System.out.println("---Invalid----");
			break;
		}
		

	}
}

}























