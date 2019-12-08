package bank.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import bank.domain.Account;

public class Subject implements SubjectInterface {
	
	private List<ObserverInterface> observerlist = new ArrayList<ObserverInterface>();
	  
	  public void addObserver(ObserverInterface observer){
		  observerlist.add(observer);
	  }
	  
	  public void notify(Account account){
		  Iterator<ObserverInterface> iterator = observerlist.iterator();
		  while(iterator.hasNext()){
			  ObserverInterface observer = iterator.next();
			  observer.update(account);
		  }
	  }
}

