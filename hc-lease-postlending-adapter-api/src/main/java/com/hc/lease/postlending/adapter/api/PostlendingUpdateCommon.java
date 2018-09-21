package com.hc.lease.postlending.adapter.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.vo.TransBody;
import com.hc.lease.postlending.vo.TransSplitBody;

/**
 * 贷后代收
 * 策略模式 公共处理
 * Created by Administrator on 2017/8/28.
 */
public interface PostlendingUpdateCommon {

    Object pstlendingCommon(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException;

    Object pstlendingCommonSplit(TransSplitBody transSplitBody, DubboTreaceParames dubboTreaceParames) throws GMException;

}
