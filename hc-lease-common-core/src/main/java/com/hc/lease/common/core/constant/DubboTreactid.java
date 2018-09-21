package com.hc.lease.common.core.constant;

/**
 * dubbo接口跟踪类型
 * Created by Tong on 2017/11/8.
 */
public enum DubboTreactid {
    traceId("traceId", "键"),
    MonthlyPaymentController_FindPostLending("MonthlyPaymentController:findPostLending", "月供管理列表 / 租金支付计划表 / 还款历史"),
    MonthlyPaymentController_monthlyPaymentOverdue("MonthlyPaymentController:monthlyPaymentOverdue", "通联支付 单人综合扣款"),
    MonthlyPaymentController_findQueryTradeNew("MonthlyPaymentController:findQueryTradeNew", "需要轮询通联 的 交易流水"),
    MonthlyPaymentController_queryTradeNew("MonthlyPaymentController:queryTradeNew", "交易查询/轮询"),
    MonthlyPaymentController_findIsOverdueLog("MonthlyPaymentController:findIsOverdueLog", "定时 检测 逾期的 月租/挂靠费 并插入 逾期流水"),
    MonthlyPaymentController_batchPostlendingPayment("MonthlyPaymentController:batchPostlendingPayment", "通联批扣 查询所有月供/挂靠/统计数据"),
    MonthlyPaymentController_dualBatchPostlendingPayment("MonthlyPaymentController:dualBatchPostlendingPayment", "提交批量代收 / 提交批扣"),
    MonthlyPaymentController_findContractInfo("MonthlyPaymentController:findContractInfo", "融资租赁标的物及租金支付表"),
    MonthlyPaymentController_contractAllinpayLog("MonthlyPaymentController:contractAllinpayLog", "还款历史/合同还款明细"),
    MonthlyPaymentController_allinpayLogBatch("MonthlyPaymentController:allinpayLogBatch", "通联日志 批扣"),
    MonthlyPaymentController_allinpayBatchStatisticsByCity("MonthlyPaymentController:allinpayBatchStatisticsByCity", "通联日志 查看统计"),
    MonthlyPaymentController_paymentLogDetailBatch("MonthlyPaymentController:paymentLogDetailBatch", "通联日志 查看明细"),
    MonthlyPaymentController_paymentLogDetailSingle("MonthlyPaymentController:paymentLogDetailSingle", "通联日志 单笔"),
    MonthlyPaymentController_findRepaymentExcept("MonthlyPaymentController:findRepaymentExcept", "批量补录的数据"),
    MonthlyPaymentController_repaymentExcept("MonthlyPaymentController:repaymentExcept", "提交批量补录"),
    MonthlyPaymentController_findPostLendingOverdueSms("MonthlyPaymentController:findPostLendingOverdueSms", "逾期短信通知列表"),
    MonthlyPaymentController_overdueSmsPreview("MonthlyPaymentController:overdueSmsPreview", "逾期通知短信 预览"),
    MonthlyPaymentController_sendOverdueSms("MonthlyPaymentController:sendOverdueSms", "发送逾期通知短信"),
    MonthlyPaymentController_queryTradeNewSplit("MonthlyPaymentController:queryTradeNewSplit", "交易查询/轮询/超额拆分交易");

    private String value;
    private String description;

    private DubboTreactid(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String value() {
        return value;
    }

    public String description() {
        return description;
    }

}
