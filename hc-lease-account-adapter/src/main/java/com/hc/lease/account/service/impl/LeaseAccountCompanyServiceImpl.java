package com.hc.lease.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.account.dao.LeaseAccountCompanyMapper;
import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.model.LeaseAccountBankCard;
import com.hc.lease.account.model.LeaseAccountCompany;
import com.hc.lease.account.service.api.LeaseAccountCompanyService;
import com.hc.lease.account.vo.LeaseAccountCompanyExcel;
import com.hc.lease.common.core.exception.GMException;
import hc.lease.common.util.JsonUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 注册公司类型用户/承租人ServiceImpl
 *
 * @author Tong
 * @version 2017-11-02
 */
@Service("leaseAccountCompanyService")
public class LeaseAccountCompanyServiceImpl implements LeaseAccountCompanyService {

    @Autowired
    private LeaseAccountCompanyMapper leaseAccountCompanyMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAccountCompanyMapper.deleteByPrimaryKey(id);
        return row;
    }

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     * @throws GMException
     */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAccountCompanyMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAccountCompany insert(LeaseAccountCompany leaseAccountCompany) throws GMException {
        leaseAccountCompany.setCreateTime(DateTime.now().toDate());
        leaseAccountCompany.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountCompanyMapper.insert(leaseAccountCompany);
        return leaseAccountCompany;
    }

    public LeaseAccountCompany insertSelective(LeaseAccountCompany leaseAccountCompany) throws GMException {
        leaseAccountCompany.setCreateTime(DateTime.now().toDate());
        leaseAccountCompany.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountCompanyMapper.insertSelective(leaseAccountCompany);
        return leaseAccountCompany;
    }

    public int insertList(List<LeaseAccountCompany> list) throws GMException {
        int row = leaseAccountCompanyMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAccountCompany leaseAccountCompany) throws GMException {
        leaseAccountCompany.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountCompanyMapper.updateByPrimaryKeySelective(leaseAccountCompany);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountCompany leaseAccountCompany) throws GMException {
        leaseAccountCompany.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountCompanyMapper.updateByPrimaryKey(leaseAccountCompany);
        return row;
    }

    public LeaseAccountCompany selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountCompany leaseAccountCompany = leaseAccountCompanyMapper.selectByPrimaryKey(id);
        return leaseAccountCompany;
    }

    @Override
    public LeaseAccount selectBy(Long id) {
        LeaseAccount leaseAccount = leaseAccountCompanyMapper.selectBy(id);
        return leaseAccount;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountCompany> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAccountCompany> leaseAccountCompanyList = leaseAccountCompanyMapper.findPage(paramsMap);
        PageInfo<LeaseAccountCompany> page = new PageInfo<LeaseAccountCompany>(leaseAccountCompanyList);
        return page;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccount> findByPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAccount> leaseAccountList = leaseAccountCompanyMapper.findByPage(paramsMap);
        if(leaseAccountList!=null && leaseAccountList.size()>0){
            for (int i = 0; i < leaseAccountList.size(); i++) {
                LeaseAccount leaseAccount = leaseAccountList.get(i);
                if(leaseAccount!=null){
                    List<LeaseAccountBankCard> leaseAccountBankCards = leaseAccount.getLeaseAccountBankCards();
                    if(leaseAccountBankCards!=null&& leaseAccountBankCards.size()>0){
                        String leaseAccountBankCardsJson = JsonUtil.stringify(leaseAccountBankCards);
                        leaseAccount.setLeaseAccountBankCardsJson(leaseAccountBankCardsJson);
                    }
                }
            }
        }
        PageInfo<LeaseAccount> page = new PageInfo<LeaseAccount>(leaseAccountList);
        return page;
    }

    public List<LeaseAccountCompanyExcel> findAllByCompanyExcel(Object o) {

        List<LeaseAccountCompanyExcel>   leaseAccountCompanyExcels=  leaseAccountCompanyMapper.findAllByCompanyExcel(o);
        return leaseAccountCompanyExcels;
    }

    public List<LeaseAccountCompany> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountCompany> leaseAccountCompanyList = leaseAccountCompanyMapper.findAll(paramsMap);
        return leaseAccountCompanyList;
    }

    public int deleteByAccountId(Long id) {
        int row = leaseAccountCompanyMapper.deleteByAccountId(id);
        return row;
    }

    public int updateByAccountId(LeaseAccountCompany leaseAccountCompany) {
        int row = leaseAccountCompanyMapper.updateByAccountId(leaseAccountCompany);
        return row;
    }
}
