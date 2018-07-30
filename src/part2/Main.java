package part2;

import part1.CourseNode;

import java.io.BufferedReader;
import java.io.FileReader;


public class Main {
	
	public static void main(String[] args) {
		
		
		MyCustomLinkedList<CourseNode> courses = new MyCustomLinkedList<>();


		//////////////LOAD COURSES
/**
 *  Read first, second and below lines. Split function returns string array that is seperated from line
 */


		
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
					courses.add(node);
			}
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println("Error happened when reading a file");
		}
		/////////////END LOAD COURSES
		
	
		
		System.out.println(courses.get(0));
		System.out.println(courses.get(1));
		System.out.println(courses.get(2));
		System.out.println(courses.get(3));
		System.out.println(courses.get(4));
		System.out.println(courses.size());
		courses.disable(1);
		courses.disable(2);
		
		
		
		courses.disable(3);
		//System.out.println(courses.get(1)); //patlad�
		System.out.println(courses.size());
		courses.showDisabled();
		//courses.set(1, courses.get(10));	//patlad�
		courses.enable(1);	
		System.out.println(courses.get(1)); //patlamad�
		courses.set(1, courses.get(10));	//patlamad�
		System.out.println(courses.size());
		courses.showDisabled();
	}

}
