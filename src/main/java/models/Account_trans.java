package models;

import java.util.Date;
import java.util.Objects;

public class Account_trans extends AbstractEntity {
private Double amount;
private Date fundsAvailDate;
private Date txnDate;
private String txnTypeCD;
private Long accountID;
private Long executionBranchID;
private Long tellerEmpID;

    public Account_trans(Long id, Double amount, Date fundsAvailDate, Date txnDate, String txnTypeCD, Long accountID, Long executionBranchID, Long tellerEmpID) {
        super(id);
        this.amount = amount;
        this.fundsAvailDate = fundsAvailDate;
        this.txnDate = txnDate;
        this.txnTypeCD = txnTypeCD;
        this.accountID = accountID;
        this.executionBranchID = executionBranchID;
        this.tellerEmpID = tellerEmpID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account_trans)) return false;
        Account_trans that = (Account_trans) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount) && Objects.equals(fundsAvailDate, that.fundsAvailDate) && Objects.equals(txnDate, that.txnDate) && Objects.equals(txnTypeCD, that.txnTypeCD) && Objects.equals(accountID, that.accountID) && Objects.equals(executionBranchID, that.executionBranchID) && Objects.equals(tellerEmpID, that.tellerEmpID);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, amount, fundsAvailDate, txnDate, txnTypeCD, accountID, executionBranchID, tellerEmpID);
    }
    @Override
    public String toString() {
        return "account_trans{" +
                "id=" + id +
                ", amount=" + amount +
                ", fundsAvailDate=" + fundsAvailDate +
                ", txnDate=" + txnDate +
                ", txnTypeCD='" + txnTypeCD + '\'' +
                ", accountID=" + accountID +
                ", executionBranchID=" + executionBranchID +
                ", tellerEmpID=" + tellerEmpID +
                '}';
    }

    public Long getTxnID() {
        return id;
    }
    public void setTxnID(Long id) {
        this.id = id;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Date getFundsAvailDate() {
        return fundsAvailDate;
    }
    public void setFundsAvailDate(Date fundsAvailDate) {
        this.fundsAvailDate = fundsAvailDate;
    }
    public Date getTxnDate() {
        return txnDate;
    }
    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }
    public String getTxnTypeCD() {
        return txnTypeCD;
    }
    public void setTxnTypeCD(String txnTypeCD) {
        this.txnTypeCD = txnTypeCD;
    }
    public Long getAccountID() {
        return accountID;
    }
    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }
    public Long getExecutionBranchID() {
        return executionBranchID;
    }
    public void setExecutionBranchID(Long executionBranchID) {
        this.executionBranchID = executionBranchID;
    }
    public Long getTellerEmpID() {
        return tellerEmpID;
    }
    public void setTellerEmpID(Long tellerEmpID) {
        this.tellerEmpID = tellerEmpID;
    }
}
