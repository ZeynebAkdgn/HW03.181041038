package part1;

public class Main {

 
	public static void main(String[] args) {
		 GTUComputerEngineeringLinkList courselist = new GTUComputerEngineeringLinkList("Courses(CSV)(Updated).csv");
			
		//
		// courselist.printAllCourses();
		//	 System.out.println(courselist.size());
		 
		// CourseNode found = courselist.getByCode("CSE 495");
		 //if(found != null)
		//System.out.println(found.getSemester() +"\t"+found.getCourseCode() +"\t"+found.getCourseTitle() +"\t"+found.getECTSCredits() +"\t"+found.getGTUCredits() +"\t"+found.getHTL() );
		//else
		//System.out.println("Course_not_found");
		 
		 
		//GTUComputerEngineeringLinkList semesterlinklist = courselist.listSemesterCourses(2);
		//semesterlinklist.printAllCourses();
		 
		 GTUComputerEngineeringLinkList semesterlinklist = courselist.getByRange(11, 20);
		 semesterlinklist.printAllCourses();
		 
		 
	}

}
