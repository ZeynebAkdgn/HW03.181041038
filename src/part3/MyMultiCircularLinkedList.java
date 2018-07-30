package part3;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import part1.CourseNode;

/**
 * Custom iterator interface yaratılır.
 * @param <E>
 */
interface SemesterIterator<E> extends Iterator<E>{ // Custom iterator interface yaratılır.

	public boolean hasNextInSemester(); 
	public CourseNode nextInSemester();

}


public class MyMultiCircularLinkedList implements Iterator<CourseNode>, SemesterIterator<CourseNode>{

		private CourseNode head;
		private int nextIndex = 0;
		private int sizeCount = 0;

	/**
	 * Hashtable ile semesterların circular linked list referansları tutulur.
	 */
	private Hashtable<Integer,ArrayList<CourseNode>> circularLinkedListRefs = new Hashtable<Integer,ArrayList<CourseNode>>(); // Hashtable ile semesterların circular linked list referansları tutulur.
	
	public MyMultiCircularLinkedList() {
	}

	/**
	 * add a new item to list
	 * @param node
	 */
	
	public void add(CourseNode node) //Add new item to list
	{
		CourseNode hop = head; 
		CourseNode lastNodeBeforereRef = null;
		
		node.next = null;

		/**
		 * Linked listin sonuna kadar dönüp, sondan bir önceki referansı ele geçirir.
		 */
		while( hop != null){ // Linked listin sonuna kadar dönüp, sondan bir önceki referansı ele geçirir.
			lastNodeBeforereRef = hop; 
			hop = hop.next; 
		}

		/**
		 * ilk node eklenir
		 */
		if(lastNodeBeforereRef == null){
			head = node; // ilk node eklenir
		}else{
			/**
			 * sonraki nodelar eklenir.
			 */
			lastNodeBeforereRef.next = node; // sonraki nodelar eklenir
		}
		
		if(!circularLinkedListRefs.containsKey(node.getSemester()))
			circularLinkedListRefs.put(node.getSemester(), new ArrayList<>());
		circularLinkedListRefs.get(node.getSemester()).add(node);
		
		sizeCount++;
	}

	/**
	 * Delete specified item from list
	 * @param courseCode
	 */
	
	public void remove(String courseCode) //Delete specified item from list
	{
		CourseNode hop = head;
		CourseNode beforeRef = null;

		/**
		 * Linked listin sonuna kadar dönüp tarıyoruz.
		 */
		while( hop != null){ // Linked listin sonuna kadar dönüp tarıyoruz.
			if( courseCode.equalsIgnoreCase(hop.getCourseCode()))
			{
				if(beforeRef == null) // headi silme
				{
					beforeRef = head;
					head = head.next;
					beforeRef = null;
					
					circularLinkedListRefs.get(head.getSemester()).remove(0); //Circular referans� sildik. Head.					
					
				}else{  // diğerlerini silme
					beforeRef.next = hop.next;
					
					for (CourseNode cn : circularLinkedListRefs.get(hop.getSemester())) {
						if(cn.getCourseCode().equals(courseCode))
						{
							circularLinkedListRefs.get(hop.getSemester()).remove(cn); //Circular referansı sildik. Head olmayan.
							break;
						}
					}					
					hop = null;
				}
				break;
			}
			beforeRef = hop;
			hop = hop.next; 
		}

		sizeCount--;
	}
	
	public CourseNode get(int index) { 
		CourseNode hop = head;
		int counter = 0;
		while( hop != null){ 
				if( counter++ == index)
					return hop;
			hop = hop.next;
		}
		return  null;
	}
	public CourseNode set(int index, CourseNode cn) {
		CourseNode hop = head;
		CourseNode beforeRef = null;

		int counter = 0;
		while( hop != null){ 
				if( counter++ == index)
				{
					beforeRef.next = cn;
					cn.next = hop.next;
					return hop;
				}
			
			beforeRef = hop;
			hop = hop.next;
		}
		return  null;

	}

	 int selectedNextSemester;
	 int currentSemesterIndex;

	/**
	 * Custom iterator döndürüldü.
	 * @param semester
	 * @return
	 */
	public SemesterIterator<CourseNode> nextInSemesterIterator(int semester){ //Custom iterator döndürüldü.
		 selectedNextSemester = semester;
		 currentSemesterIndex = 0;
	     return this; 
	 }

	/**
	 * Custom iterator, circular linked liste bakarak bir sonraki elemanın olup olmadığını kontrol eder.
	 * @return
	 */

	public boolean hasNextInSemester() {//Custom iterator, circular linked liste bakarak bir sonraki elemanın olup olmadığını kontrol eder.
		if (  currentSemesterIndex  < circularLinkedListRefs.get(selectedNextSemester).size() - 1 ){ //Seçilen semesterda bir sonraki eleman var m�?
			currentSemesterIndex++;
			return true;
			}
			return false;
	}

	/**
	 * Custom iteratorda bir sonraki elemanı dondürür. Seçilen semesterda bir sonraki elemanı döndürür.
	 * @return
	 */
	 
	public CourseNode nextInSemester() {//Custom iteratorda bir sonraki elemanı dondürür
		if (  currentSemesterIndex  < circularLinkedListRefs.get(selectedNextSemester).size()  ){ //Seçilen semesterda bir sonraki elemanı döndürür.
			return circularLinkedListRefs.get(selectedNextSemester).get(currentSemesterIndex);
		}
		return null;
	}
	
	
	
	public int size() {
		return sizeCount;
	}

	/**
	 * Iterator dondürür.
	 * @return
	 */
	public Iterator<CourseNode> iterator() { // Iterator dondürür.
		nextIndex = 0;
        return this;
    }

	/**
	 * Normal linked list de bir sonraki eleman var mı kontrolü yapılır.
	 * @return
	 */
	@Override
	public boolean hasNext() { //Normal linked list de bir sonraki eleman var mı kontrolü yapılır.
		if (nextIndex < size()-1){ 
			nextIndex++;
			return true;
		}
		return false;
	}

	/**
	 * Normal linked list de bir sonraki eleman döndürürler.
	 * @return
	 */
	@Override
	public CourseNode next() { //Normal linked list de bir sonraki eleman döndürürler.
		if (nextIndex < size()){ 
			return get(nextIndex);
		}
		return null;
	}

	
}
