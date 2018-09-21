package com.hc.lease.account.dao;

import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.vo.LeaseAccountExcel;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 注册用户/承租人
 * Created by Tong on 2017/3/31.
 */
public interface LeaseAccountMapper extends BaseDao<LeaseAccount> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseAccount> insertViewParames(Map<String, Object> paramsMap);

    public List<LeaseAccount> findByPhone(Map<String, Object> paramsMap) throws GMException;

    /**
     * 检测身份证号码是否存在
     *
     * @param paramsMap
     * @return
     */
    List<LeaseAccount> findByIdCard(Map<String, Object> paramsMap);

    int deleteByAccountCompany(Long id);

    LeaseAccount selectBy(Map<String, Object> paramsMap) throws GMException;

    List<LeaseAccountExcel> findAllByExcel(Object o);

    int updateAccountNameByAccountId(LeaseAccount leaseAccount);

}
