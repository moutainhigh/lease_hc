package com.hc.lease.baseInfo.service.impl;

import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.dao.LeaseUseUsedMapper;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.common.core.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 公共处理ServiceImpl
 *
 * @author Tong
 * @version 2017-04-26
 */
@Service("leaseCommonService")
public class LeaseCommonServiceImpl implements LeaseCommonService {

    @Autowired
    private LeaseUseUsedMapper leaseUseUsedMapper;

    /**
     * 插入使用和被使用的数据
     *
     * @param useId
     * @param useName
     * @param usedId
     * @param usedName
     * @param useType
     * @param usedType
     * @return
     * @throws GMException
     */
    public int insertUseUsed(Long useId, String useName, Long usedId, String usedName, String useType, String usedType) throws GMException {

        //先清除
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("useId", useId);
        paramsMap.put("usedId", usedId);
        paramsMap.put("useType", useType);
        paramsMap.put("usedType", usedType);
        int row = leaseUseUsedMapper.deleteByUseUsed(paramsMap);

        //插入数据
        LeaseUseUsed leaseUseUsed = new LeaseUseUsed();
        leaseUseUsed.setUseId(useId);
        leaseUseUsed.setUseName(useName);
        leaseUseUsed.setUsedId(usedId);
        leaseUseUsed.setUsedName(usedName);
        leaseUseUsed.setUseType(useType);
        leaseUseUsed.setUsedType(usedType);
        int row1 = leaseUseUsedMapper.insertSelective(leaseUseUsed);
        return row1;
    }

    /**
     * 查找被使用者
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseUseUsed> selectByUsed(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUseUsed> leaseUseUsedList = leaseUseUsedMapper.selectByUsed(paramsMap);
        return leaseUseUsedList;
    }

    public Boolean checkUsed(Long used, String usedType) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("usedId", used);
        map.put("usedType", usedType);
        List<LeaseUseUsed> leaseUseUseds = leaseUseUsedMapper.selectByUsed(map);
        if (leaseUseUseds == null && leaseUseUseds.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除使用和被使用的数据
     *
     * @param useId
     * @param usedId
     * @param useType
     * @param usedType
     * @return
     * @throws GMException
     */
    public int delUseUsed(Long useId, Long usedId, String useType, String usedType) throws GMException {

        //先清除
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("useId", useId);
        paramsMap.put("usedId", usedId);
        paramsMap.put("useType", useType);
        paramsMap.put("usedType", usedType);
        int row = leaseUseUsedMapper.deleteByUseUsed(paramsMap);
        return row;
    }

}
