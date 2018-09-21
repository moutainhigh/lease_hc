package com.hc.lease.workflow.service.api;

import com.hc.lease.workflow.vo.ActGroupQuery;
import com.hc.lease.workflow.vo.ActGroupSaveDTO;
import com.hc.lease.workflow.vo.ActGroupVO;
import com.hc.lease.workflow.vo.ActMembershipOperateDTO;
import com.hc.lease.workflow.vo.ActUserQuery;
import com.hc.lease.workflow.vo.ActUserSaveDTO;
import com.github.pagehelper.PageInfo;
import com.hc.lease.workflow.vo.ActUserVO;

import java.util.List;

/**
 * Created by LJ on 2018/3/26
 */
public interface ActIdentityService {


    ActUserVO getActUserById(String userId);

    PageInfo<ActUserVO> queryPageActUser(ActUserQuery actUserQuery);

    List<ActUserVO> queryAllActUser(ActUserQuery actUserQuery);

    ActGroupVO getActGroupById(String groupId);

    PageInfo<ActGroupVO> queryPageActGroup(ActGroupQuery actGroupQuery);

    List<ActGroupVO> queryAllActGroup(ActGroupQuery actGroupQuery);

    void saveActUser(ActUserSaveDTO userInfo);

    void saveActGroup(ActGroupSaveDTO groupInfo);

    void deleteActUser(String userId);

    void deleteActGroup(String groupId);

    void createMembership(ActMembershipOperateDTO actMembershipOperateDTO);

    void deleteMembership(ActMembershipOperateDTO actMembershipOperateDTO);
}
