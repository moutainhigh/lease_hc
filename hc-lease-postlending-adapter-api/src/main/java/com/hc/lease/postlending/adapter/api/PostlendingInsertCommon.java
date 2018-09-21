package com.hc.lease.postlending.adapter.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.vo.StrategySplitVo;
import com.hc.lease.postlending.vo.StrategyVo;

import java.util.List;

/**
 * 贷后代收
 * 策略模式 公共处理
 * Created by Administrator on 2017/8/28.
 */
public interface PostlendingInsertCommon {

    Object pstlendingCommon(List<StrategyVo> strategyVoList, DubboTreaceParames dubboTreaceParames) throws GMException;

    Object pstlendingCommonSplit(List<StrategySplitVo> strategySplitVoList, DubboTreaceParames dubboTreaceParames) throws GMException;

}
