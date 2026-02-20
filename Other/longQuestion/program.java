package Other.longQuestion;

import Other.Date;

public class program {

}

class BasicAccount{
    protected int bankNumber;
    protected int branchNumber;
    protected int accountNumber;
    protected String id;
    protected double balance;

    public BasicAccount(int bankNumber, int branchNumber, int accountNumber, String id) {
        this.bankNumber = bankNumber;
        this.branchNumber = branchNumber;
        this.accountNumber = accountNumber;
        this.id = id;
        this.balance = 0;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if(amount > 0){
            this.balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "bankNumber=" + bankNumber +
                ", branchNumber=" + branchNumber +
                ", accountNumber=" + accountNumber +
                ", id='" + id + '\'' +
                ", balance=" + balance;
    }

    public boolean atRisk(){
        return false;
    }


    private void nothing(){
        if(deposit(0)){
            System.out.print("");
        }
    }
}

class CheckingAccount extends BasicAccount{
    protected double overdraftLimit;

    public CheckingAccount(int bankNumber, int branchNumber, int accountNumber, String id) {
        super(bankNumber, branchNumber, accountNumber, id);
    }

    public CheckingAccount(int bankNumber, int branchNumber, int accountNumber, String id, double overdraftLimit) {
        super(bankNumber, branchNumber, accountNumber, id);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        if(overdraftLimit < 0)
            throw new IllegalArgumentException("overdraft limit cannot be negative");
        this.overdraftLimit = overdraftLimit;
    }

    public boolean withdraw(double amount) {
        if(amount < 0)
            return false;
        double balance2 = this.balance - amount;
        if(balance2 < 0 && balance2 * -1 > overdraftLimit)
            return false;
        this.balance = balance2;
        return true;
    }

    @Override
    public boolean atRisk() {
        return balance < 0;
    }

    @Override
    public String toString() {
        return super.toString() + "overdraftLimit=" + overdraftLimit;
    }
}

class SavingAccount extends BasicAccount{
    protected Date finishSaving;

    public SavingAccount(int bankNumber, int branchNumber, int accountNumber, String id, Date finishSaving) {
        super(bankNumber, branchNumber, accountNumber, id);
        this.finishSaving = finishSaving;
    }

    public Date getFinishSaving() {
        return this.finishSaving;
    }

    public void setFinishSaving(Date finishSaving) {
        this.finishSaving = finishSaving;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", finishSavingDate=" + finishSaving;
    }

    public boolean withdrawal(Date date){
        if(date.after(finishSaving) || date.equals(finishSaving)){
            this.balance = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean atRisk() {
        return balance <= 0;
    }
}

class BusinessAccount extends CheckingAccount {
    protected String businessName;

    public BusinessAccount(int bankNumber, int branchNumber, int accountNumber, String id, String businessName) {
        super(bankNumber, branchNumber, accountNumber, id);
        this.businessName = businessName;
    }

    public BusinessAccount(int bankNumber, int branchNumber, int accountNumber, String id, double overdraftLimit, String businessName) {
        super(bankNumber, branchNumber, accountNumber, id, overdraftLimit);
        this.businessName = businessName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public String toString() {
        return "business Name: '" + businessName + ", " + super.toString();
    }

    public boolean pay(CheckingAccount person, double amount) {
        if(withdraw(amount)){
            person.deposit(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean atRisk() {
        return balance <= -0.9*overdraftLimit;
    }
}

class BankServices{
    protected BasicAccount[] accounts;
    int numAccounts;

    public BankServices(int accounts){
        this.accounts = new BasicAccount[accounts];
        this.numAccounts = 0;
    }

    public BasicAccount getAccount(int accountNumber){
        for(int i = 0; i < this.numAccounts; i++){
            if(accounts[i].getAccountNumber() == accountNumber){
                return accounts[i];
            }
        }
        return null;
    }

    public void setAccount(int accountNumber, BasicAccount account1){
        for(int i = 0; i < this.numAccounts; i++){
            if(accounts[i].getAccountNumber() == accountNumber){
                accounts[i] = account1;
                return;
            }
        }
    }

    public BasicAccount[] riskAccounts(){
        int length = 0;
        for(int i  = 0; i < this.numAccounts; i++){
            if(accounts[i].atRisk())
                length++;
        }
        BasicAccount[] riskAccounts = new BasicAccount[length];
        int i = 0;
        for(int j = 0; j < this.numAccounts; j++){
            if(accounts[j].atRisk())
                riskAccounts[i++] = accounts[j];
        }
        return riskAccounts;
    }

    public boolean add(BasicAccount account){
        if(this.numAccounts >= this.accounts.length){
            return false;
        }
        accounts[this.numAccounts] = account;
        this.numAccounts++;
        return true;
    }

    public String find(int accountNumber){
        for(int i = 0; i < this.numAccounts; i++){
            if(accounts[i].getAccountNumber() == accountNumber){
                return accounts[i].toString();
            }
        }
        return "";
    }

    public int countAccounts(int accountNumber){
        boolean found = false;
        String id = "";
        int first = 0;
        for (int i = 0; i < numAccounts && !found; i++)
            if(accounts[i].getAccountNumber() == accountNumber){
                found = true;
                id = accounts[i].getId();
                first = i;
            }

        if(!found)
            return 0;

        int count = 1;
        for (int i = first+1; i < numAccounts; i++) {
            if(accounts[i].getId().equals(id)){
                count++;
            }
        }
        return count;
    }

    public BasicAccount[] findAccounts(String id){
        int count = 0;
        for(int i = 0; i < this.numAccounts; i++)
            if(accounts[i].getId().equals(id))
                count++;

        BasicAccount[] accounts = new BasicAccount[count];
        int i = 0;

        for(int j = 0; j < this.numAccounts; j++)
            if(accounts[j].getId().equals(id))
                accounts[i++] = accounts[j];

        return accounts;
    }

    public String richestCustomerId() {
        String richest = "";
        double maxBalance = Integer.MIN_VALUE;
        for (BasicAccount account : this.accounts) {
            String current = account.getId();
            double totalBalance = 0;
            for (BasicAccount account2 : accounts) {
                if (account.getId().equals(current)) {
                    totalBalance += account.getBalance();
                }
            }
            if (totalBalance > maxBalance) {
                maxBalance = totalBalance;
                richest = current;
            }
        }
        return richest;
    }



}

