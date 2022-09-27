package models;

import java.util.Date;
import java.util.Objects;

public class Account {
//Fields
private Long accountID;
private Double availBalance;
private Double pendingBalance;
private String status;
private Date openDate;
private Date lastActivity;
private Date closeDate;
private Long custID;
private Long branchID;
private Long empID;
private String productCD;

//Constructors
    public Account(Long accountID, Double availBalance, Double pendingBalance, String status, Date openDate, Date lastActivity, Date closeDate, Long custID, Long branchID, Long empID, String productCD) {
        this.accountID = accountID;
        this.availBalance = availBalance;
        this.pendingBalance = pendingBalance;
        this.status = status;
        this.openDate = openDate;
        this.lastActivity = lastActivity;
        this.closeDate = closeDate;
        this.custID = custID;
        this.branchID = branchID;
        this.empID = empID;
        this.productCD = productCD;
    }
//HashCode-Equals & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(accountID, account.accountID) && Objects.equals(availBalance, account.availBalance) && Objects.equals(pendingBalance, account.pendingBalance) && Objects.equals(status, account.status) && Objects.equals(openDate, account.openDate) && Objects.equals(lastActivity, account.lastActivity) && Objects.equals(closeDate, account.closeDate) && Objects.equals(custID, account.custID) && Objects.equals(branchID, account.branchID) && Objects.equals(empID, account.empID) && Objects.equals(productCD, account.productCD);
    }
    @Override
    public int hashCode() {
        return Objects.hash(accountID, availBalance, pendingBalance, status, openDate, lastActivity, closeDate, custID, branchID, empID, productCD);
    }
    @Override
    public String toString() {
        return "account{" +
                "accountID=" + accountID +
                ", availBalance=" + availBalance +
                ", pendingBalance=" + pendingBalance +
                ", status='" + status + '\'' +
                ", openDate=" + openDate +
                ", lastActivity=" + lastActivity +
                ", closeDate=" + closeDate +
                ", custID=" + custID +
                ", branchID=" + branchID +
                ", empID=" + empID +
                ", productCD='" + productCD + '\'' +
                '}';
    }

//Getters & Setters
    public Long getAccountID() {
        return accountID;
    }
    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }
    public Double getAvailBalance() {
        return availBalance;
    }
    public void setAvailBalance(Double availBalance) {
        this.availBalance = availBalance;
    }
    public Double getPendingBalance() {
        return pendingBalance;
    }
    public void setPendingBalance(Double pendingBalance) {
        this.pendingBalance = pendingBalance;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getOpenDate() {
        return openDate;
    }
    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
    public Date getLastActivity() {
        return lastActivity;
    }
    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }
    public Date getCloseDate() {
        return closeDate;
    }
    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }
    public Long getCustID() {
        return custID;
    }
    public void setCustID(Long custID) {
        this.custID = custID;
    }
    public Long getBranchID() {
        return branchID;
    }
    public void setBranchID(Long branchID) {
        this.branchID = branchID;
    }
    public Long getEmpID() {
        return empID;
    }
    public void setEmpID(Long empID) {
        this.empID = empID;
    }
    public String getProductCD() {
        return productCD;
    }
    public void setProductCD(String productCD) {
        this.productCD = productCD;
    }
}
