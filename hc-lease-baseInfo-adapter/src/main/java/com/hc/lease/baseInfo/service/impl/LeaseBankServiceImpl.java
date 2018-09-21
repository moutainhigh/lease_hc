package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseBankMapper;
import com.hc.lease.baseInfo.model.LeaseBank;
import com.hc.lease.baseInfo.service.api.LeaseBankService;
import com.hc.lease.common.core.constant.RedisKey;
import com.hc.lease.common.core.exception.GMException;
import com.ym.common.json.JsonUtils;
import com.ym.common.redis.template.ShardedJedisTemplate;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 银行ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseBankService")
public class LeaseBankServiceImpl implements LeaseBankService {

    @Value("${redis.seconds}")
    private String redisSeconds;//redis缓存时间

    @Autowired
    private LeaseBankMapper leaseBankMapper;

    @Resource
    ShardedJedisTemplate shardedJedisTemplate;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseBankMapper.deleteByPrimaryKey(id);
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
        int row = leaseBankMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseBank insert(LeaseBank record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseBankMapper.insert(record);
        return record;
    }

    public LeaseBank insertSelective(LeaseBank record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseBankMapper.insertSelective(record);
        return record;
    }

    public LeaseBank selectByPrimaryKey(Long id) throws GMException {
        LeaseBank leaseBank = leaseBankMapper.selectByPrimaryKey(id);
        return leaseBank;
    }

    public int updateByPrimaryKeySelective(LeaseBank record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseBankMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseBank record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseBankMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseBank> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseBank> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseBank> leaseBankList = leaseBankMapper.findPage(paramsMap);
        PageInfo<LeaseBank> page = new PageInfo<LeaseBank>(leaseBankList);
        return page;
    }

    /**
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseBank> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseBank> leaseBankList = null;
        String result = shardedJedisTemplate.getAsList(RedisKey.LEASE_BANK);
        //redis缓存没有数据则查数据库
        if (result == null) {
            leaseBankList = leaseBankMapper.findAll(paramsMap);
            shardedJedisTemplate.setex(RedisKey.LEASE_BANK, JsonUtils.toJsonString(leaseBankList), Integer.parseInt(redisSeconds));
            return leaseBankList;
        }
        return JsonUtils.json2Object(result, List.class);
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseBank> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseBank> list = leaseBankMapper.insertViewParames(paramsMap);
        return list;
    }

    public List<LeaseBank> findAllNoType(Object o) {
        List<LeaseBank> leaseBankList= leaseBankMapper.findAllNoType(o);
        return leaseBankList;
    }

    public List<String> findAllBankName() {
        List<String> bankList= leaseBankMapper.findAllBankName();
        return bankList;
    }

    public LeaseBank findByBankName(String bankName) {
        LeaseBank leaseBank =leaseBankMapper.findByBankName(bankName);

        return leaseBank;
    }

}
