package com.hc.lease.order.adapter.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.order.vo.FindByPlateNumberAndRepaymentDateVo;

import java.util.List;
import java.util.Map;

/**
 * 月供的状态、滞纳金的状态、挂靠费的状态、提前还款的状态、尾付的状态，一个合同的某一期对应的这几种款项只有一条记录，可能每一种款项会操作多次扣款，每次操作的状态都更新Adapter
 *
 * @author Tong
 * @version 2017-08-17
 */

public interface LeaseSchemeRepaymentStatusAdapter extends BaseAdapter<LeaseSchemeRepaymentStatus> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 查询某个合同某一期的某种款项的数据
     *
     * @param paramsMap
     * @return
     */
    LeaseSchemeRepaymentStatus findByType(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 定时轮询通联超额拆分交易结果 批量更新
     *
     * @param list
     * @return
     */
    int batchUpdateBySplitCheck(List<LeaseSchemeRepaymentStatus> list);

    /**
     * 车牌号和扣款日期查询还款计划
     *
     * @param paramsMap
     * @return
     */
    FindByPlateNumberAndRepaymentDateVo findByPlateNumberAndRepaymentDate(Map<String, Object> paramsMap);

    /**
     * 备份数据
     *
     * @param paramsMap
     * @return
     */
    int backData(Map<String, Object> paramsMap);

    /**
     * 合同是否存在还款中的还款计划
     *
     * @param paramsMap
     * @return
     */
    Boolean findContractPayStatusByContractId(Map<String, Object> paramsMap);

}
