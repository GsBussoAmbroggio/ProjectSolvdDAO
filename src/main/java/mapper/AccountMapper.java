package mapper;

import java.util.List;
import model.Account;
import model.AccountExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AccountMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(AccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(AccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer accountId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Account row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Account row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Account> selectByExample(AccountExample example, RowBounds rowBounds);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Account> selectByExampleWithLock(AccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Account> selectByExample(AccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Account selectByPrimaryKeyWithLock(Integer accountId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Account selectByPrimaryKey(Integer accountId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Account row, @Param("example") AccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Account row, @Param("example") AccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Account row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Account row);
}