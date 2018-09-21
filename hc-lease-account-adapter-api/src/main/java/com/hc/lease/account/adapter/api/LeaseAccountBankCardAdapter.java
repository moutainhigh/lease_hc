package com.hc.lease.account.adapter.api;

import com.hc.lease.account.model.LeaseAccountBankCard;
import com.hc.lease.account.vo.LeaseAccountBankExcel;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountBankExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountBankImportExcelBackInfo;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 承租人银行卡Adapter
 * @author Qiang
 * @version 2018-01-15
 */

public interface LeaseAccountBankCardAdapter extends BaseAdapter<LeaseAccountBankCard> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    List<LeaseAccountBankExcel> findAllByExcel(Object o);

    LeaseAccountBankImportExcelBackInfo importAccountBankCardExcel(List<LeaseAccountBankExcelTemplate> leaseAccountBankExcelTemplates) throws GMException;

    LeaseAccountBankCard findByAccountIdAndId(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据 手机、身份证、银行主键Id、银行卡或存折号码 查询
     *
     * @param params
     * @return
     */
    List<LeaseAccountBankCard> findByAccountInfo(Map<String, Object> params);

    int updateAccountNameByAccountId(LeaseAccountBankCard leaseAccountBankCard);

}
