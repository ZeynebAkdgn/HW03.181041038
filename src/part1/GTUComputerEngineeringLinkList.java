package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GTUComputerEngineeringLinkList {

	public CourseNode head = null;
	
	
	public GTUComputerEngineeringLinkList(){} 
	public GTUComputerEngineeringLinkList(String courseDataFile) {

		/**
		 * Read first, second and below lines. Split function returns string array that is seperated from line
		 */
		String line;
				CourseNode node = null;
		   try {
			    BufferedReader bufferedReader = new BufferedReader(new FileReader(courseDataFile));

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
			    		add(node); // Added one node to linkedlist
			    }
			    
			    bufferedReader.close();
			    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		
		
		
	}

	public CourseNode getByCode (String code) {
	
		CourseNode hop = head;
		 
		while( hop != null){ // Linked listin sonuna kadar d�n�p tar�yoruz
			if( code.equalsIgnoreCase(hop.getCourseCode())) //Aranan bulundu
				 return hop;
			hop = hop.next; 
		}
		return null;
	}
	
	public GTUComputerEngineeringLinkList listSemesterCourses (int semester)
	{
		
		GTUComputerEngineeringLinkList semesterLinkList = new GTUComputerEngineeringLinkList(); // Yeni linked list tan�mlad�k. Bunun i�ine sadece istenen semesterde olan nodelar� ekliyece�iz. 
		
		CourseNode hop = head;

		/**
		 * Linked Listin sonunda kadar dönüp taranır ve clonu yeni linked liste eklenır.
		 */

		try {
			while( hop != null){ // Linked listin sonuna kadar d�n�p tar�yorum
				if( semester == hop.getSemester()) 
					semesterLinkList.add(hop.clone()); // Clonu yeni linked liste ekledim.
				hop = hop.next; 
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}		
		
		return semesterLinkList;
	}

	/**
	 * Yeni linked list tanımlanır ve bunun i�ine sadece istenen semesterde olan nodelar eklenir. Burada while döngüsü sayesinde linked
	 * listin sonuna kadar dönüp tarıyorum.
	 * @param start_index
	 * @param last_index
	 * @return
	 */
	public GTUComputerEngineeringLinkList getByRange(int start_index, int last_index){

		/**
		 * Yeni linked list tanımlanır ve bunun içine istenen semesterde olan nodelar eklenir. Buradaki while döngüsünde linked listin
		 * sonuna kadar dönüp taranıyor ve içindeki if döngüsünde range kontrol edilip, clonu yeni linked liste ekleniyor.
		 */
		GTUComputerEngineeringLinkList semesterLinkList = new GTUComputerEngineeringLinkList(); // Yeni linked list tan�mlad�k. Bunun i�ine sadece istenen semesterde olan nodelar� ekliyeceğim
		CourseNode hop = head;
		 int counter = 1;
		try {
			while( hop != null){ // Linked listin sonuna kadar d�n�p taranır.
				if(  start_index <= counter &&  counter <= last_index ) // Range-i kontrol edilir
					semesterLinkList.add(hop.clone()); // Clonu yeni linked liste eklenir.
				hop = hop.next; 
				counter++;
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}		
		
		return semesterLinkList;
	}

	/**
	 * Listeye yeni item ekleniyor. Linked listin sonuna kadar dönülüp, while döngüsüyle sondan bir önceki referansı ele geçiriyoruz.
	 * @param node
	 */
	
	public void add(CourseNode node) //Add new item to list
	{
		CourseNode hop = head;
		CourseNode lastNodeBeforereRef = null;
		
		node.next = null;
		
		while( hop != null){ // Linked listin sonuna kadar d�n�p, sondan bir �nceki referans� ele ge�iriyoruz.
			lastNodeBeforereRef = hop; 
			hop = hop.next; 
		}

		/**
		 * ilk node ve sonraki nodelar eklenir.
		 */
		if(lastNodeBeforereRef == null){
			head = node; // ilk node eklenir
		}else{
			lastNodeBeforereRef.next = node; // sonraki nodelar eklenir
		}
		
	}

	/**
	 * Listeden belirli bir item silinir. Linked listin sonuna kadar dönüp taranır.
	 * @param courseCode
	 */
	public void remove(String courseCode) //Delete specified item from list
	{
		CourseNode hop = head;
		CourseNode beforeRef = null;
		while( hop != null){ // Linked listin sonuna kadar dönüp taranır.
			if( courseCode.equalsIgnoreCase(hop.getCourseCode()))
			{
				/**
				 * head silinir.
				 */
				if(beforeRef == null) // headi silme
				{
					beforeRef = head;
					head = head.next;
					beforeRef = null;

					/**
					 * diğer nodelar silinir.
					 * diğer nodelar silinir.
					 */
				}else{  // di�erlerini silme
					beforeRef.next = hop.next;
					hop = null;
				}
				break;
			}
			beforeRef = hop;
			hop = hop.next; 
		}
		
	}

	/**
	 * Listenin genişliğini verir. While döngüsünde Linked listin sonuna kadar dönüp taranır.
	 * @return
	 */
	
	public int size() //Get size of the list
	{
		CourseNode hop = head;
		int counter=0;
		while( hop != null){ // Linked listin sonuna kadar dönüp taranır.
			counter++;
			hop = hop.next; 
		}
		return counter;
	}

	/**
	 * Sistemde bütün kurslar yazdırılır.
	 */
	public void printAllCourses(){
		CourseNode hop = head;
		while( hop != null){ // Linked listin sonuna kadar d�n�p tar�yoruz
			System.out.println(hop.getSemester() +"\t"+hop.getCourseCode() +"\t"+hop.getCourseTitle() +"\t"+hop.getECTSCredits() +"\t"+hop.getGTUCredits() +"\t"+hop.getHTL() );
			hop = hop.next; 
		}
	}
}
