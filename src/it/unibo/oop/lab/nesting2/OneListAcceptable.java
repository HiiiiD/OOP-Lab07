package it.unibo.oop.lab.nesting2;


import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * {@link Acceptable} that accepts a list
 * @author Marco
 * @param <T> Type parameter of the list
 */
public class OneListAcceptable<T> implements Acceptable<T> {
	
	private List<T> acceptableList;
	
	/**
	 * 
	 * @param list to accept
	 */
	public OneListAcceptable(List<T> list) {
		this.acceptableList = list;
	}

	/**
	 * An instance of {@link OneListAcceptor}
	 */
	@Override
	public Acceptor<T> acceptor() {
		return new OneListAcceptor();
	}
	
	/**
	 * Acceptor that accepts a list, made a separate class to make it more clear
	 * @author Marco
	 *
	 */
	private class OneListAcceptor implements Acceptor<T> {

		private final Iterator<T> iterator = acceptableList.iterator();
		
		@Override
		public void accept(T newElement) throws ElementNotAcceptedException {
			
			try {
				if (newElement.equals(iterator.next())) {
					return;
				}
			} catch (NoSuchElementException e) {
				System.out.println("There are no more elements to be evaluated");
			}
			
			throw new ElementNotAcceptedException(newElement);
		}

		@Override
		public void end() throws EndNotAcceptedException {
			if (!iterator.hasNext()) {
				return;
			}
			
			throw new EndNotAcceptedException();
		}
		
	}

}
