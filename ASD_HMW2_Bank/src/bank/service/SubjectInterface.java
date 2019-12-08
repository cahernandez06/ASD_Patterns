package bank.service;

import bank.domain.Account;

public interface SubjectInterface {
	public abstract void addObserver(ObserverInterface observer);
	public abstract void notify(Account account);
}
