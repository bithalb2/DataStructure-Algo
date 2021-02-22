package com.subhra.ds.linear.dynamic.queue.array_impl;

import com.subhra.ds.linear.dynamic.queue.Queue;

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

public class QueueArrayDriver {

	public static void main(String[] args) {
		
		Queue<Student> queue = new QueueArray<Student>(3);
		
		queue.enqueue(new Student(1, "Subhra Prakash Jena", 7));
		queue.enqueue(new Student(2, "Saumya Prakash Jena", 4));
		queue.enqueue(new Student(3, "Sambit Pradhan", 5));
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		
/*		Queue<Integer> queue = new QueueArrayGrowable<Integer>(5);
		
		
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		queue.enqueue(90);
		
/*		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
/*		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		queue.enqueue(90);
		//queue.enqueue(100);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		
*/
	}

}
