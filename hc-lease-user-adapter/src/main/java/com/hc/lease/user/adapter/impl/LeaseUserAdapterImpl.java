package com.hc.lease.user.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.service.api.LeaseOrganizationStructureService;
import com.hc.lease.baseInfo.vo.OrganizationStructureSelectByTypeVo;
import com.hc.lease.common.core.constant.OrganizationStructureType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.user.adapter.api.LeaseUserAdapter;
import com.hc.lease.user.model.*;
import com.hc.lease.user.service.api.*;
import com.hc.lease.user.vo.ExportUserVo;
import com.hc.lease.user.vo.FindPageV1Vo;
import com.hc.lease.user.vo.InsertUerOrganization;
import com.hc.lease.user.vo.InsertUserAuthoRole;
import hc.lease.common.util.ListUtil;
import hc.lease.common.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 后台用户AdapterImpl
 *
 * @author Tong
 * @version 2017-06-26
 */
@Service("leaseUserAdapter")
public class LeaseUserAdapterImpl implements LeaseUserAdapter {

    @Autowired
    private LeaseUserService leaseUserService;

    @Autowired
    private LeaseUserSessionService leaseUserSessionService;

    @Autowired
    private LeaseUserLoginLogService leaseUserLoginLogService;

    @Autowired
    private LeaseOrganizationStructureService leaseOrganizationStructureService;

    @Autowired
    private LeaseAuthoRoleService leaseAuthoRoleService;

    @Autowired
    private LeaseAuthoUserOrganizationService leaseAuthoUserOrganizationService;

    @Autowired
    private LeaseAuthoUserRoleService leaseAuthoUserRoleService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {

        List list = new ArrayList();
        list.add(OrganizationStructureType.department.value());
        list.add(OrganizationStructureType.group.value());
        List<OrganizationStructureSelectByTypeVo> leaseOrganizationStructureList = leaseOrganizationStructureService.selectByType(list);

        List<LeaseAuthoRole> leaseAuthoRoleList = leaseAuthoRoleService.findAll(null);
        Map<String, Object> backMap = Maps.newHashMap();
        backMap.put("leaseOrganizationStructureList", leaseOrganizationStructureList);
        backMap.put("leaseAuthoRoleList", leaseAuthoRoleList);
        return backMap;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseUserService.deleteByPrimaryKey(id);
        leaseAuthoUserOrganizationService.deleteByUserId(id);
        leaseAuthoUserRoleService.deleteByUserId(id);
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
        int row = leaseUserService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseUser record) throws GMException {
        record = leaseUserService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 处理 插入 用户-公司、部门、组中间表，用户所属的组织 数据
     *
     * @param record
     */
    public void dualAuthoUserOrganization(LeaseUser record) throws GMException {
        //插入 用户-公司、部门、组中间表，用户所属的组织 数据
        List<LeaseAuthoUserOrganization> leaseAuthoUserOrganizationList = new ArrayList<LeaseAuthoUserOrganization>();
        List<InsertUerOrganization> organizationList = record.getOrganizationList();
        if (organizationList != null && organizationList.size() > 0) {
            LeaseAuthoUserOrganization leaseAuthoUserOrganization = null;
            for (int i = 0; i < organizationList.size(); i++) {
                InsertUerOrganization insertUerOrganizationDepartment = organizationList.get(i);
                leaseAuthoUserOrganization = new LeaseAuthoUserOrganization();
                leaseAuthoUserOrganization.setUserId(record.getId());
                leaseAuthoUserOrganization.setOrganizationStructureId(insertUerOrganizationDepartment.getId());
                leaseAuthoUserOrganization.setOrganizationStructureType(insertUerOrganizationDepartment.getType());
                leaseAuthoUserOrganizationList.add(leaseAuthoUserOrganization);
            }
        }
        leaseAuthoUserOrganizationService.insertList(leaseAuthoUserOrganizationList);
        //插入 用户-公司、部门、组中间表，用户所属的组织 数据
    }

    /**
     * 处理 插入 用户-角色 数据
     *
     * @param record
     */
    public void dualAuthoUserRole(LeaseUser record) throws GMException {
        //处理 插入 用户-角色 数据
        List<LeaseAuthoUserRole> leaseAuthoUserRoleList = new ArrayList<LeaseAuthoUserRole>();
        List<InsertUserAuthoRole> roleListOneList = record.getRoleListOne();
        List<InsertUserAuthoRole> roleListZeroList = record.getRoleListZero();
        LeaseAuthoUserRole leaseAuthoUserRole = null;
        if (roleListOneList != null && roleListOneList.size() > 0) {
            for (int i = 0; i < roleListOneList.size(); i++) {
                InsertUserAuthoRole iInsertUserAuthoRole = roleListOneList.get(i);
                leaseAuthoUserRole = new LeaseAuthoUserRole();
                leaseAuthoUserRole.setUserId(record.getId());
                leaseAuthoUserRole.setRoleId(iInsertUserAuthoRole.getId());
                leaseAuthoUserRole.setType(iInsertUserAuthoRole.getType());
                leaseAuthoUserRoleList.add(leaseAuthoUserRole);
            }
        }
        if (roleListZeroList != null && roleListZeroList.size() > 0) {
            for (int i = 0; i < roleListZeroList.size(); i++) {
                InsertUserAuthoRole iInsertUserAuthoRole = roleListZeroList.get(i);
                leaseAuthoUserRole = new LeaseAuthoUserRole();
                leaseAuthoUserRole.setUserId(record.getId());
                leaseAuthoUserRole.setRoleId(iInsertUserAuthoRole.getId());
                leaseAuthoUserRole.setType(iInsertUserAuthoRole.getType());
                leaseAuthoUserRoleList.add(leaseAuthoUserRole);
            }
        }
        leaseAuthoUserRoleService.insertList(leaseAuthoUserRoleList);
        //处理 插入 用户-角色 数据
    }

    /**
     * 新增后台用户
     *
     * @param record
     * @return
     * @throws GMException
     */
    public ResultHashMap insertSelective(LeaseUser record) throws GMException {
        //检测手机号是否已被注册
        Map paramsMap = Maps.newHashMap();
        paramsMap.put("phone", record.getPhone());
        paramsMap.put("id", record.getId());
        List<LeaseUser> leaseUserList = leaseUserService.findByPhone(paramsMap);
        if (leaseUserList != null) {
            if (leaseUserList.size() > 0) {
                throw new GMException(GMExceptionConstant.USER_PHONE_IS_REPEAT);
            }
        }
        //检测手机号是否已被注册
        //初始化密码
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        record.setSalt(randomNumberGenerator.nextBytes().toHex());
        String accountPassword = MD5Util.string2MD5(record.getPassword() + record.getPhone() + record.getCredentialsSalt());
        record.setPassword(accountPassword);
        //初始化密码
        record = leaseUserService.insertSelective(record);
        dualAuthoUserOrganization(record);//处理 插入 用户-公司、部门、组中间表，用户所属的组织 数据
        dualAuthoUserRole(record);//处理 插入 用户-角色 数据
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 修改
     *
     * @param record
     * @return
     * @throws GMException
     */
    public int updateByPrimaryKeySelective(LeaseUser record) throws GMException {
        //检测手机号是否已被注册
        Map paramsMap = Maps.newHashMap();
        paramsMap.put("phone", record.getPhone());
        paramsMap.put("id", record.getId());
        List<LeaseUser> leaseUserList = leaseUserService.findByPhone(paramsMap);
        if (leaseUserList != null) {
            if (leaseUserList.size() > 0) {
                throw new GMException(GMExceptionConstant.ACCOUNT_PHONE_IS_REPEAT);
            }
        }
        //检测手机号是否已被注册
        int row = leaseUserService.updateByPrimaryKeySelective(record);
        leaseAuthoUserOrganizationService.deleteByUserId(record.getId());
        leaseAuthoUserRoleService.deleteByUserId(record.getId());
        dualAuthoUserOrganization(record);//处理 插入 用户-公司、部门、组中间表，用户所属的组织 数据
        dualAuthoUserRole(record);//处理 插入 用户-角色 数据
        return row;
    }

    public int updateByPrimaryKey(LeaseUser record) throws GMException {

        //检测手机号是否已被注册
        Map paramsMap = Maps.newHashMap();
        paramsMap.put("phone", record.getPhone());
        paramsMap.put("id", record.getId());
        List<LeaseUser> leaseUserList = leaseUserService.findByPhone(paramsMap);
        if (leaseUserList != null) {
            if (leaseUserList.size() > 0) {
                throw new GMException(GMExceptionConstant.ACCOUNT_PHONE_IS_REPEAT);
            }
        }
        //检测手机号是否已被注册

        int row = leaseUserService.updateByPrimaryKey(record);

        dualAuthoUserOrganization(record);//处理 插入 用户-公司、部门、组中间表，用户所属的组织 数据
        dualAuthoUserRole(record);//处理 插入 用户-角色 数据

        return row;
    }

    public LeaseUser selectByPrimaryKey(Long id) throws GMException {
        LeaseUser leaseUser = leaseUserService.selectByPrimaryKey(id);
        return leaseUser;
    }

    public int insertList(List<LeaseUser> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseUser> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseUser> page = leaseUserService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseUser> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUser> leaseUserList = leaseUserService.findAll(paramsMap);
        return leaseUserList;
    }

    public List<LeaseUser> findByPhone(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUser> leaseUserList = leaseUserService.findAll(paramsMap);
        return leaseUserList;
    }

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @param deviceId
     * @return
     * @throws GMException
     */
    public ResultHashMap accountLogin(String phone, String password, String deviceId, String ipAddr) throws GMException {
        DateTime dateTime = DateTime.now();
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("phone", phone);
        //paramsMap.put("deviceId", deviceId);

        List<LeaseUser> leaseUserList = leaseUserService.findByPhone(paramsMap);

        //组装 后台用户登录日志 数据
        LeaseUserLoginLog leaseUserLoginLog = new LeaseUserLoginLog();
        leaseUserLoginLog.setDeviceId(deviceId);
        leaseUserLoginLog.setLoginInTime(dateTime.toDate());
        leaseUserLoginLog.setPhone(phone);
        leaseUserLoginLog.setLoginIp(ipAddr);
        //组装 后台用户登录日志 数据

        if (leaseUserList == null || leaseUserList.size() <= 0) {

            //插入 后台用户登录日志 数据
            leaseUserLoginLog.setLoginError("账号未注册");
            leaseUserLoginLogService.addSelective(leaseUserLoginLog);
            //插入 后台用户登录日志 数据

            throw new GMException(GMExceptionConstant.ACCOUNT_PHONE_IS_NOT_REPEAT);//账号未注册
        }
        LeaseUser leaseUser = leaseUserList.get(0);

        String accountPassword = MD5Util.string2MD5(password + leaseUser.getPhone() + leaseUser.getCredentialsSalt());
        if (!leaseUser.getPassword().equals(accountPassword)) {

            //插入 后台用户登录日志 数据
            leaseUserLoginLog.setUserId(leaseUser.getId());
            leaseUserLoginLog.setLoginError(GMExceptionConstant.ACCOUNT_PHONE_IS_NOT_REPEAT.getErrMsg());
            leaseUserLoginLogService.addSelective(leaseUserLoginLog);
            //插入 后台用户登录日志 数据

            throw new GMException(GMExceptionConstant.ACCOUNT_PASSWORD_IS_ERROR);//账号密码错误
        }

        //后台用户登录状态session
        LeaseUserSession leaseUserSession = new LeaseUserSession();
        leaseUserSession.setUserId(leaseUser.getId());
        leaseUserSession.setPhone(leaseUser.getPhone());
        leaseUserSession.setRealName(leaseUser.getRealName());
        leaseUserSession.setDeviceId(deviceId);
        leaseUserSession.setSessionLoginTime(dateTime.toDate());
        DateTime limitDateTime = dateTime.plusMinutes(120);//120分钟后过期
        leaseUserSession.setSessionLimitTime(limitDateTime.toDate());
        String token = MD5Util.string2MD5(MD5Util.string2MD5(MD5Util.string2MD5(accountPassword) + deviceId) + System.currentTimeMillis());//token加密
        leaseUserSession.setSessionCurrent(token);
        leaseUserSessionService.deleteByDeviceIdAndPhone(paramsMap);
        leaseUserSessionService.insertSelective(leaseUserSession);
        //后台用户登录状态session

        //登录用户实体
        LoginLeaseUser loginUser = new LoginLeaseUser();
        loginUser.setAccountId(leaseUser.getId());
        loginUser.setRealName(leaseUser.getRealName());
        loginUser.setPhone(leaseUser.getPhone());
        loginUser.setIcon(StringUtils.isEmpty(leaseUser.getIcon()) ? null : leaseUser.getIcon());
        loginUser.setToken(token);
        //登录用户实体

        //插入 后台用户登录日志 数据
        leaseUserLoginLog.setUserId(leaseUser.getId());
        leaseUserLoginLog.setSessionCurrent(token);
        leaseUserLoginLog.setLoginError(GMExceptionConstant.LOGIN_SUCCESS.getErrMsg());
        leaseUserLoginLogService.addSelective(leaseUserLoginLog);
        //插入 后台用户登录日志 数据

        Object object = ListUtil.objectIsNullToList(loginUser);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.LOGIN_SUCCESS);
        return resultHashMap;
    }

    /**
     * 退出登录
     *
     * @param userSession
     * @return
     * @throws GMException
     */
    public ResultHashMap accountLoginOut(UserSession userSession) throws GMException {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("phone", userSession.getPhone());
        //paramsMap.put("deviceId", userSession.getDeviceId());
        leaseUserSessionService.deleteByDeviceIdAndPhone(paramsMap);

        //组装 后台用户登录日志 数据
        LeaseUserLoginLog leaseUserLoginLog = new LeaseUserLoginLog();
        leaseUserLoginLog.setLoginOutTime(DateTime.now().toDate());
        leaseUserLoginLog.setSessionCurrent(userSession.getSessionCurrent());
        leaseUserLoginLogService.updateBySessionCurrent(leaseUserLoginLog);
        //组装 后台用户登录日志 数据

        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.LOGIN_SUCCESS_OUT);
        return resultHashMap;
    }

    /**
     * 用户分页数据
     *
     * @param pageNum
     * @param pageSize
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public PageInfo<FindPageV1Vo> findPageV1(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<FindPageV1Vo> page = leaseUserService.findPageV1(pageNum, pageSize, paramsMap);
        return page;
    }

    @Override
    public List<ExportUserVo> exportUser(Map<String, Object> paramsMap) throws GMException {
        List<ExportUserVo> leaseUserList = leaseUserService.exportUser(paramsMap);
        return leaseUserList;
    }
}
