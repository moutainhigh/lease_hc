package com.hc.lease.user.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseUser;
import com.hc.lease.user.vo.ExportUserVo;
import com.hc.lease.user.vo.FindAllUserVo;
import com.hc.lease.user.vo.FindPageV1Vo;

import java.util.List;
import java.util.Map;

/**
 * 后台用户
 */
public interface LeaseUserMapper extends BaseDao<LeaseUser> {

    List<LeaseUser> findByPhone(Map<String, Object> paramsMap) throws GMException;

    /**
     * 组织结构用到的用户数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<FindAllUserVo> findOrganizationUser(Map<String, Object> paramsMap) throws GMException;

    /**
     * 用户分页数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<FindPageV1Vo> findPageV1(Map<String, Object> paramsMap) throws GMException;

    /**
     * 用户管理导出
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<ExportUserVo> exportUser(Map<String, Object> paramsMap) throws GMException;

}