package model;

import java.util.Date;
import lombok.Data;

/**
 * Table: account
 */
@Data
public class Account {
    /**
     * Column: ACCOUNT_ID
     * Type: INT
     */
    private Integer accountId;

    /**
     * Column: AVAIL_BALANCE
     * Type: FLOAT
     */
    private Float availBalance;

    /**
     * Column: PENDING_BALANCE
     * Type: FLOAT
     */
    private Float pendingBalance;

    /**
     * Column: STATUS
     * Type: VARCHAR(45)
     */
    private String status;

    /**
     * Column: OPEN_DATE
     * Type: DATE
     */
    private Date openDate;

    /**
     * Column: LAST_ACTIVITY_DATE
     * Type: DATE
     */
    private Date lastActivityDate;

    /**
     * Column: CLOSE_DATE
     * Type: DATE
     */
    private Date closeDate;

    /**
     * Column: customer_CUST_ID
     * Type: INT
     */
    private Integer customerCustId;

    /**
     * Column: branch_BRANCH_ID
     * Type: INT
     */
    private Integer branchBranchId;

    /**
     * Column: employee_EMP_ID
     * Type: INT
     */
    private Integer employeeEmpId;

    /**
     * Column: product_PRODUCT_CD
     * Type: VARCHAR(20)
     */
    private String productProductCd;
}