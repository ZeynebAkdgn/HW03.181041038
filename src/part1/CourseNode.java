package part1;

public class CourseNode implements Cloneable {

	public CourseNode next;
 
	
	private int Semester;
	private String CourseCode;
	private String CourseTitle;
	private int ECTSCredits;
	private int GTUCredits;
	private String HTL;
	
	public CourseNode(){
		
	}
	public CourseNode(int semester, String courseCode, String courseTitle, int eCTSCredits, int gTUCredits,
			String hTL) {
		super();
		Semester = semester;
		CourseCode = courseCode;
		CourseTitle = courseTitle;
		ECTSCredits = eCTSCredits;
		GTUCredits = gTUCredits;
		HTL = hTL;
	}
	
	public int getSemester() {
		return Semester;
	}
	public void setSemester(int semester) {
		Semester = semester;
	}
	public String getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}
	public String getCourseTitle() {
		return CourseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		CourseTitle = courseTitle;
	}
	public int getECTSCredits() {
		return ECTSCredits;
	}
	public void setECTSCredits(int eCTSCredits) {
		ECTSCredits = eCTSCredits;
	}
	public int getGTUCredits() {
		return GTUCredits;
	}
	public void setGTUCredits(int gTUCredits) {
		GTUCredits = gTUCredits;
	}
	public String getHTL() {
		return HTL;
	}
	public void setHTL(String hTL) {
		HTL = hTL;
	}

	@Override
	protected CourseNode clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (CourseNode)super.clone();
	}

}
