package com.hc.lease.workflow.service.api;

import com.hc.lease.workflow.vo.ActHistoricActivityVO;
import com.hc.lease.workflow.vo.ActHistoricFlowQuery;
import com.hc.lease.workflow.vo.ActHistoricTaskVO;
import com.hc.lease.workflow.vo.ActProcessStartDTO;
import com.hc.lease.workflow.vo.ActTaskClaimDTO;
import com.hc.lease.workflow.vo.ActTaskCompleteDTO;
import com.hc.lease.workflow.vo.ActTaskDeleteDTO;
import com.hc.lease.workflow.vo.ActTaskPageQuery;
import com.hc.lease.workflow.vo.ActTaskVO;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.util.List;

/**
 * 流程定义相关Service
 * Created by LJ on 2018/3/28
 */
public interface ActTaskService {

    /**
     * 分页查询未签收任务
     */
    PageInfo<ActTaskVO> pageFindAwaitClaimTask(ActTaskPageQuery actTaskPageQuery);

    /**
     * 分页查询已签收任务
     */
    PageInfo<ActTaskVO> pageFindAlreadyClaimTask(ActTaskPageQuery actTaskPageQuery);

    /**
     * 分页查询已办任务
     */
    PageInfo<ActHistoricTaskVO> pageHistoricTask(ActTaskPageQuery actTaskPageQuery);

    /**
     * 获取流转历史列表
     */
    List<ActHistoricActivityVO> historicFlowList(ActHistoricFlowQuery actHistoricFlowQuery);

    /**
     * 启动流程
     */
    String startProcess(ActProcessStartDTO actProcessStartVo) throws IOException;

    /**
     * 获取任务
     */
    ActTaskVO getTaskById(String taskId);

    /**
     * 查询流程状态（判断流程正在执行，还是结束）
     *
     * @param processInstanceId 流程实例ID
     */
    Boolean isProcessEnd(String processInstanceId);

    /**
     * 删除任务
     */
    void deleteTask(ActTaskDeleteDTO actTaskDeleteVo);

    /**
     * 签收任务
     */
    void claimTask(ActTaskClaimDTO actTaskClaimVo);

    /**
     * 提交任务, 并保存意见
     */
    void completeTask(ActTaskCompleteDTO actTaskCompleteVo) throws IOException;
}
