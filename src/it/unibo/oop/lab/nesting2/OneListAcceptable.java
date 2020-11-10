package it.unibo.oop.lab.nesting2;


import java.util.ArrayList;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {
	
	private List<T> acceptableList;
	
	public OneListAcceptable(List<T> list) {
		this.acceptableList = list;
	}

	@Override
	public Acceptor<T> acceptor() {
		return new OneListAcceptor();
	}
	
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
