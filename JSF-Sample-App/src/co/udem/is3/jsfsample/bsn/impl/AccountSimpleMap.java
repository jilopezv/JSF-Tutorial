package co.udem.is3.jsfsample.bsn.impl;

import java.util.HashMap;
import java.util.Map;

import co.udem.is3.jsfsample.bsn.AccountLookupService;
import co.udem.is3.jsfsample.model.Account;

/** A small table of book site accounts for testing. */

public class AccountSimpleMap implements AccountLookupService {
	private Map<String, Account> accounts;

	public AccountSimpleMap() {
		accounts = new HashMap<>();
		addAccount(new Account("a1234", "Bill", "Gates", 1000));
		addAccount(new Account("a1235", "Larry", "Ellison", 2000));
		addAccount(new Account("a1236", "James", "Gosling", 3000));
	}

	/**
	 * Finds the Account with the given ID. Returns null if there is no match.
	 */

	@Override
	public Account findAccount(String id) {
		if (id != null) {
			return (accounts.get(id.toLowerCase()));
		} else {
			return (null);
		}
	}

	private void addAccount(Account account) {
		accounts.put(account.getId(), account);
	}
}
