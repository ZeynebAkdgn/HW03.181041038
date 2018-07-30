package part3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

import part1.CourseNode;
import part2.MyCustomLinkedList;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		/**
		 * myCircularCustomList adında bir list oluşturuldu.
		 */
		MyMultiCircularLinkedList myCircularCustomList = new MyMultiCircularLinkedList();


		//////////////LOAD COURSES
		
		try {
			String line;
			CourseNode node = null;
			BufferedReader bufferedReader = new BufferedReader(new FileReader("Courses(CSV)(Updated).csv"));
			line = bufferedReader.readLine(); // Read first line		
			while ((line = bufferedReader.readLine()) != null) // Read second and below lines
			{
				    node = new CourseNode();
					String items[] =  line.split(";");//Split function returns string array that is seperated from line
					node.setSemester( Integer.parseInt(items[0]));
					node.setCourseCode(items[1]);
					node.setCourseTitle(items[2]);
					node.setECTSCredits( Integer.parseInt(items[3]) );
					node.setGTUCredits( Integer.parseInt(items[4]) );
					node.setHTL(items[5]);
					myCircularCustomList.add(node);
			}
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println("Error happened when reading a file");
		}
		/////////////END LOAD COURSES
		
	
		System.out.println(myCircularCustomList.get(0));
		System.out.println(myCircularCustomList.get(1));
		System.out.println(myCircularCustomList.get(2));
		
		
		Iterator<CourseNode> it = myCircularCustomList.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("**********");
		
		SemesterIterator<CourseNode> it2 = myCircularCustomList.nextInSemesterIterator(2);
		while(it2.hasNextInSemester()){
			System.out.println(it2.nextInSemester());
		}
		
		

	}

}
