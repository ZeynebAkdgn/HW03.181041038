package part2;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Disable elemanlar�n listesini tutmak i�in liste olu�turdum
 * @param <E>
 */
public class MyCustomLinkedList<E> extends LinkedList<E>{

	ArrayList<Integer> disabledItems = new ArrayList<>(); //Disable elemanlarının listesini tutmak için liste oluşturuldu.
	
	public MyCustomLinkedList() {

	}

	/**
	 * Index disabled listesine eklenir ve silinir..
	 * @param index
	 * @throws ArrayIndexOutOfBoundsException
	 */

	public void disable(int index) throws ArrayIndexOutOfBoundsException 
	{
		if( index >= 0 && index < size())
			disabledItems.add(index); //index'i disabled listesine ekledim
		else
			throw new ArrayIndexOutOfBoundsException("Disabled Index out of range.");
	}
	public void enable(int index) throws ArrayIndexOutOfBoundsException
	{
		if( index >= 0 && index < size()){
			if(disabledItems.contains(index))
			{
				 disabledItems.remove(disabledItems.indexOf(index)); //index'i disabled listesinden sildim.
			}
		}
		else
			throw new ArrayIndexOutOfBoundsException("Index is disabled");
	}
	public void showDisabled() {
		for (int i = 0; i < size(); i++) {
			if(disabledItems.contains(i))
				System.out.println(super.get(i));
		}
		
	}

	/**
	 * E�er get istenilen index disabled ise hata f�rlat�r.
	 * @param index
	 * @return
	 * @throws ArrayIndexOutOfBoundsException
	 */
	@Override
	public E get(int index) throws ArrayIndexOutOfBoundsException
	{
			if( disabledItems.contains(index) ) // E�er get istenilen index disabled ise hata f�rlat�r.
			{
				throw new ArrayIndexOutOfBoundsException("Disabled Index out of range.");
			}
			return (E)(super.get(index));
	}


	/**
	 * Eğer set istenilen index disabled ise hata fırlat�r.
	 * @param index
	 * @param element
	 * @return
	 * @throws ArrayIndexOutOfBoundsException
	 */
	@Override
	public E set(int index, E element) throws ArrayIndexOutOfBoundsException
	{
		if( disabledItems.contains(index) )
		{
			throw new ArrayIndexOutOfBoundsException("Index is disabled"); // E�er set istenilen index disabled ise hata f�rlat�r.
		}
		return (E)(super.set(index, element));
	}


	/**
	 *
	 * @return Linkedlist eleman sayısından disabled eleman say�s�n� çıkardım.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size()-disabledItems.size(); //Linkedlist eleman say�s�ndan disabled eleman say�s�n� ��kard�m.
	}
		
}
