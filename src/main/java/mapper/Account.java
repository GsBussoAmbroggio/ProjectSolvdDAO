package mapper;

import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.util.Date;

public final class Account extends AliasableSqlTable<Account> {
    public final SqlColumn<Integer> accountId = column("ACCOUNT_ID", JDBCType.INTEGER);

    public final SqlColumn<Float> availBalance = column("AVAIL_BALANCE", JDBCType.REAL);

    public final SqlColumn<Float> pendingBalance = column("PENDING_BALANCE", JDBCType.REAL);

    public final SqlColumn<String> status = column("`STATUS`", JDBCType.VARCHAR);

    public final SqlColumn<Date> openDate = column("OPEN_DATE", JDBCType.DATE);

    public final SqlColumn<Date> lastActivityDate = column("LAST_ACTIVITY_DATE", JDBCType.DATE);

    public final SqlColumn<Date> closeDate = column("CLOSE_DATE", JDBCType.DATE);

    public final SqlColumn<Integer> customerCustId = column("customer_CUST_ID", JDBCType.INTEGER);

    public final SqlColumn<Integer> branchBranchId = column("branch_BRANCH_ID", JDBCType.INTEGER);

    public final SqlColumn<Integer> employeeEmpId = column("employee_EMP_ID", JDBCType.INTEGER);

    public final SqlColumn<String> productProductCd = column("product_PRODUCT_CD", JDBCType.VARCHAR);

    public Account() {
        super("account", Account::new);
    }
}