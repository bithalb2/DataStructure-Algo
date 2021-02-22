package com.subhra.ds.linear.dynamic.stack.array_impl;

import com.subhra.ds.linear.dynamic.stack.Stack;

class Student {
	private Integer sId;
	private String sName;
	private Integer sRoll;
	
	public Student(Integer sId, String sName, Integer sRoll) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sRoll = sRoll;
	}

	@Override
	public String toString() {
		return "Student {"+"\n"
						+"\t\t"+"\"sId\" : " + sId + ",\n"
						+"\t\t"+"\"sName\" : " +"\"" + sName +"\""+ ",\n"
						+"\t\t"+"\"sRoll\" : " + sRoll + "\n"
						+"\t}\n";
	}
}

public class StackArrayDriver {

	public static void main(String[] args) {
		Stack<Student> stack = new StackArray<Student>(5);
		
		stack.push(new Student(1, "Subhra Prakash Jena", 7));
		stack.push(new Student(2, "Saumya Prakash Jena", 4));
		stack.push(new Student(3, "Sambit Pradhan", 5));
		
		Student peek = stack.peek();
		System.out.println(peek);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
	}

}
