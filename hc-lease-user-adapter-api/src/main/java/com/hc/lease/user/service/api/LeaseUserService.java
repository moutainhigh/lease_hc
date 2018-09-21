package com.hc.lease.user.service.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseUser;
import com.hc.lease.user.vo.ExportUserVo;
import com.hc.lease.user.vo.FindAllUserVo;
import com.hc.lease.user.vo.FindPageV1Vo;

import java.util.List;
import java.util.Map;

/**
 * 后台用户Service
 *
 * @author Tong
 * @version 2017-06-26
 */

public interface LeaseUserService extends BaseService<LeaseUser> {

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
     * @param pageNum
     * @param pageSize
     * @param paramsMap
     * @return
     * @throws GMException
     */
    PageInfo<FindPageV1Vo> findPageV1(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException;

    /**
     * 用户管理导出
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<ExportUserVo> exportUser(Map<String, Object> paramsMap) throws GMException;

}
