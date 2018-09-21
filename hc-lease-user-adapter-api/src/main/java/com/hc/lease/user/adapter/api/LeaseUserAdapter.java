package com.hc.lease.user.adapter.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.user.model.LeaseUser;
import com.hc.lease.user.vo.ExportUserVo;
import com.hc.lease.user.vo.FindPageV1Vo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 后台用户Adapter
 *
 * @author Tong
 * @version 2017-06-26
 */

public interface LeaseUserAdapter extends BaseAdapter<LeaseUser> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @param deviceId
     * @return
     * @throws GMException
     */
    ResultHashMap accountLogin(String phone, String password, String deviceId, String ipAddr) throws GMException;

    /**
     * 退出登录
     *
     * @param userSession
     * @return
     * @throws GMException
     */
    ResultHashMap accountLoginOut(UserSession userSession) throws GMException;

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
