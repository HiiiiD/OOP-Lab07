package it.unibo.oop.lab.nesting2;


import java.util.ArrayList;
import java.util.List;

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
	 * Acceptor that accepts a list
	 * @author Marco
	 *
	 */
	private class OneListAcceptor implements Acceptor<T> {

		private List<T> acceptedList = new ArrayList<T>(acceptableList.size());
		private boolean isTerminated = false;
		
		@Override
		public void accept(T newElement) throws ElementNotAcceptedException {
			if (!acceptableList.contains(newElement) || isTerminated) {
				throw new ElementNotAcceptedException(newElement);
			}
			acceptedList.add(newElement);
		}

		@Override
		public void end() throws EndNotAcceptedException {
			if (acceptedList.size() != acceptableList.size()) {
				throw new EndNotAcceptedException();
			}
			isTerminated = true;
		}
		
	}

}
