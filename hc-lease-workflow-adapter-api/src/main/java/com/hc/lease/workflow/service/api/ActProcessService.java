package com.hc.lease.workflow.service.api;

import com.hc.lease.workflow.vo.ActProcessDefinitionQuery;
import com.hc.lease.workflow.vo.ActProcessDefinitionVO;
import com.hc.lease.workflow.vo.ActProcessDeployDTO;
import com.hc.lease.workflow.vo.ActProcessInsVO;
import com.hc.lease.workflow.vo.ActProcessInstanceQuery;
import com.hc.lease.workflow.vo.DeleteProcInsDTO;
import com.hc.lease.workflow.vo.ProcessResourceReadDTO;
import com.hc.lease.workflow.vo.SetProcessCategoryDTO;
import com.hc.lease.workflow.vo.SetProcessStateDTO;
import com.github.pagehelper.PageInfo;

import java.io.IOException;

/**
 * Created by LJ on 2018/3/26
 */
public interface ActProcessService {

    /**
     * 流程定义列表查询
     */
    PageInfo<ActProcessDefinitionVO> processDefinitionQuery(ActProcessDefinitionQuery actProcessDefinitionQuery);

    /**
     * 流程实例查询
     */
    PageInfo<ActProcessInsVO> processInstanceList(ActProcessInstanceQuery actProcessInstanceQuery);

    ActProcessDefinitionVO getProcessDefinitionById(String procDefId);

    /**
     * 设置流程分类
     */
    void setProcessCategory(SetProcessCategoryDTO updateProcessCategory);

    /**
     * 挂起、激活流程实例
     */
    void setProcessState(SetProcessStateDTO setProcessState);

    /**
     * 流程部署
     */
    boolean processDeploy(ActProcessDeployDTO actProcessDeployDTO);

    /**
     * 将部署的流程转换为模型
     *
     * @param procDefId 流程ID
     */
    void convertToModel(String procDefId) throws Exception;

    byte[] actProcessResourceRead(ProcessResourceReadDTO processResourceReadDTO) throws IOException;

    /**
     * 删除部署的流程，级联删除流程实例
     *
     * @param deploymentId 流程部署ID
     */
    void deleteDeployment(String deploymentId);

    /**
     * 删除部署的流程实例
     */
    void deleteProcIns(DeleteProcInsDTO deleteProcIns);
}
