package co.udem.is3.jsfsample.controller;


import javax.faces.bean.ManagedBean;

import co.udem.is3.jsfsample.bsn.AccountLookupService;
import co.udem.is3.jsfsample.bsn.impl.AccountSimpleMap;
import co.udem.is3.jsfsample.model.Account;
import co.udem.is3.jsfsample.model.DailyDeal;
import co.udem.is3.jsfsample.utils.DealUtils;
import co.udem.is3.jsfsample.utils.FormUtils;

@ManagedBean
public class DealBean1 {
  private String accountId, countString;
  private int count;
  private DailyDeal todaysDeal = DealUtils.todaysDeal();
  private Account account;
  private static AccountLookupService lookupService =
    new AccountSimpleMap();

  public String getAccountId() {
    return(accountId);
  }
  
  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }
  
  public String getCountString() {
    return(countString);
  }
  
  /** Converting from String to int manually. Later
   *  example will let JSF do it for us.
   */
  public void setCountString(String countString) {
    try {
      count = Math.abs(Integer.parseInt(countString));
      this.countString = countString;
    } catch(NumberFormatException|NullPointerException e) {
      // Keep default values (count=0, countString=null)
    }
  }
  
  public int getCount() {
    return (count);
  }

  public DailyDeal getTodaysDeal() {
    return(todaysDeal);
  }

  public Account getAccount() {
    return(account);
  }
  
  public double getPurchaseAmount() {
    return(count * todaysDeal.getPrice());
  }
  
  public String getPurchaseDollars() {
    return(String.format("$%,.2f", getPurchaseAmount()));
  }
  
  public String buyDailyDeal() {
    if (FormUtils.isAnyMissing(accountId, countString)) {
      return("deal-error-1");
    } 
    account = lookupService.findAccount(accountId);
    if (account == null) {
      return("deal-bad-id-1");
    } 
    if (account.getBalance() < getPurchaseAmount()) {
      return("deal-insufficient-balance-1");
    }
    account.setBalance(account.getBalance() - getPurchaseAmount());
    return("deal-success-1");
  }
}

