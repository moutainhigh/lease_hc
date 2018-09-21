package com.hc.lease.postlending.strategy.impl;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.adapter.api.PostlendingUpdateCommon;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.TransSplitBody;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通联支付超额拆分
 * 根据 通联 轮询回来的处理结果 ，更新 代收流水 状态 / 更新 支付状态汇总管理 状态
 * Created by Administrator on 2017/8/28.
 */
public class SplitUpdateStrategy implements Strategy {

    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        PostlendingUpdateCommon postlendingUpdateCommon = (PostlendingUpdateCommon) SpringContextHolder.getBean("postlendingUpdateCommon");
        TransSplitBody transSplitBody = (TransSplitBody) object1;
        postlendingUpdateCommon.pstlendingCommonSplit(transSplitBody, dubboTreaceParames);
        return true;
    }
}
