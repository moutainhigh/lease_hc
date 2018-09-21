package com.allinpay.model;

import com.allinpay.param.query.QTDetail;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 通联支付 接口返回 报文 封装
 * Created by tong on 2017/6/2.
 */
public class QuickReturnMessage implements Serializable {

    @ApiModelProperty(value = "交易代码/接口类型,如:310001 协议支付签约短信触发", hidden = false, required = true)
    private String trxCode;

    @ApiModelProperty(value = "通联返回的 头部 状态码,如:0000 提交通联接口成功", hidden = false, required = true)
    private String aipgrspRetCode;
    @ApiModelProperty(value = "通联返回的 头部 状态结果描述", hidden = false, required = true)
    private String aipgrspErrmsg;

    @ApiModelProperty(value = "协议号", hidden = false, required = true)
    private String agrmno;

    @ApiModelProperty(value = "通联返回的 明细 状态码", hidden = false, required = true)
    private String rnpaRetRetCode;
    @ApiModelProperty(value = "通联返回的 明细 状态结果描述", hidden = false, required = true)
    private String rnpaRetErrmsg;

    @ApiModelProperty(value = "交易查询 操作结果状态", hidden = false, required = true)
    private List<QTDetail> queryDetails;

    @ApiModelProperty(value = "通联返回的 文件名", hidden = false, required = true)
    private String reqSn;

    @ApiModelProperty(value = "记录序号 通联批量代收 每条数据的 序号", hidden = false, required = true)
    private String sn;

    @ApiModelProperty(value = "通联返回的 操作日期", hidden = false, required = true)
    private String repTime;

    @ApiModelProperty(value = "通联返回的 交易完成日期", hidden = false, required = true)
    private String finTime;

    @ApiModelProperty(value = "单笔或批量/0:单笔; 1:批量", hidden = false, required = true)
    private Integer singleOrBatch;

    @ApiModelProperty(value = "月供月份/融租合同-还款主键id", hidden = false, required = true)
    private Long repaymentId;

    @ApiModelProperty(value = "支付状态汇总管理主键id", hidden = false, required = true)
    private Long repaymentStatusId;

    @ApiModelProperty(value = "融租合同主键id", hidden = false, required = true)
    private Long contractId;

    @ApiModelProperty(value = "款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款", hidden = false, required = true)
    private Integer type;

    @ApiModelProperty(value = "代收流水主键id", hidden = false)
    private Long allinpayLogId;

    @ApiModelProperty(value = "合计金额", hidden = false, required = true)
    private BigDecimal totlePrice;

    @ApiModelProperty(value = "扣款日", hidden = false, required = true)
    private String repaymentDate;

    @ApiModelProperty(value = "总笔数", hidden = false, required = true)
    private Integer totalItem;

    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long accountId;

    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "款项类型 0:月租;1:挂靠", hidden = false)
    private Integer overdueType;

    @ApiModelProperty(value = "通联交易处理结果编码", hidden = false, required = true)
    private String retCode;
    @ApiModelProperty(value = "通联交易处理结果描述", hidden = false, required = true)
    private String errMsg;

    @ApiModelProperty(value = "超额拆分交易明细流水主键Id", hidden = false)
    private Long allinpaySplitLogId;

    @ApiModelProperty(value = "超额拆分交易明细主键Id", hidden = false, required = true)
    private Long allinpaySplitId;

    @ApiModelProperty(value = "手动扣款提交的数据主键id", hidden = false, required = true)
    Long dataId;
    @ApiModelProperty(value = "手动扣款流水主键Id", hidden = false, required = true)
    private Long payLogId;

    @ApiModelProperty(value = "手动扣款统计主键id", hidden = false, required = true)
    private Long statistId;
    @ApiModelProperty(value = "总金额", hidden = false)
    private BigDecimal totalPrice;

    public String getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(String trxCode) {
        this.trxCode = trxCode;
    }

    public String getAipgrspRetCode() {
        return aipgrspRetCode;
    }

    public void setAipgrspRetCode(String aipgrspRetCode) {
        this.aipgrspRetCode = aipgrspRetCode;
    }

    public String getAipgrspErrmsg() {
        return aipgrspErrmsg;
    }

    public void setAipgrspErrmsg(String aipgrspErrmsg) {
        this.aipgrspErrmsg = aipgrspErrmsg;
    }

    public String getAgrmno() {
        return agrmno;
    }

    public void setAgrmno(String agrmno) {
        this.agrmno = agrmno;
    }

    public String getRnpaRetRetCode() {
        return rnpaRetRetCode;
    }

    public void setRnpaRetRetCode(String rnpaRetRetCode) {
        this.rnpaRetRetCode = rnpaRetRetCode;
    }

    public String getRnpaRetErrmsg() {
        return rnpaRetErrmsg;
    }

    public void setRnpaRetErrmsg(String rnpaRetErrmsg) {
        this.rnpaRetErrmsg = rnpaRetErrmsg;
    }

    public List<QTDetail> getQueryDetails() {
        return queryDetails;
    }

    public void setQueryDetails(List<QTDetail> queryDetails) {
        this.queryDetails = queryDetails;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getRepTime() {
        return repTime;
    }

    public void setRepTime(String repTime) {
        this.repTime = repTime;
    }

    public String getFinTime() {
        return finTime;
    }

    public void setFinTime(String finTime) {
        this.finTime = finTime;
    }

    public Integer getSingleOrBatch() {
        return singleOrBatch;
    }

    public void setSingleOrBatch(Integer singleOrBatch) {
        this.singleOrBatch = singleOrBatch;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getRepaymentStatusId() {
        return repaymentStatusId;
    }

    public void setRepaymentStatusId(Long repaymentStatusId) {
        this.repaymentStatusId = repaymentStatusId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getAllinpayLogId() {
        return allinpayLogId;
    }

    public void setAllinpayLogId(Long allinpayLogId) {
        this.allinpayLogId = allinpayLogId;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getOverdueType() {
        return overdueType;
    }

    public void setOverdueType(Integer overdueType) {
        this.overdueType = overdueType;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Long getAllinpaySplitLogId() {
        return allinpaySplitLogId;
    }

    public void setAllinpaySplitLogId(Long allinpaySplitLogId) {
        this.allinpaySplitLogId = allinpaySplitLogId;
    }

    public Long getAllinpaySplitId() {
        return allinpaySplitId;
    }

    public void setAllinpaySplitId(Long allinpaySplitId) {
        this.allinpaySplitId = allinpaySplitId;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getPayLogId() {
        return payLogId;
    }

    public void setPayLogId(Long payLogId) {
        this.payLogId = payLogId;
    }

    public Long getStatistId() {
        return statistId;
    }

    public void setStatistId(Long statistId) {
        this.statistId = statistId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "QuickReturnMessage{" +
                "trxCode='" + trxCode + '\'' +
                ", aipgrspRetCode='" + aipgrspRetCode + '\'' +
                ", aipgrspErrmsg='" + aipgrspErrmsg + '\'' +
                ", agrmno='" + agrmno + '\'' +
                ", rnpaRetRetCode='" + rnpaRetRetCode + '\'' +
                ", rnpaRetErrmsg='" + rnpaRetErrmsg + '\'' +
                ", queryDetails=" + queryDetails +
                ", reqSn='" + reqSn + '\'' +
                ", sn='" + sn + '\'' +
                ", repTime='" + repTime + '\'' +
                ", finTime='" + finTime + '\'' +
                ", singleOrBatch=" + singleOrBatch +
                ", repaymentId=" + repaymentId +
                ", repaymentStatusId=" + repaymentStatusId +
                ", contractId=" + contractId +
                ", type=" + type +
                ", allinpayLogId=" + allinpayLogId +
                ", totlePrice=" + totlePrice +
                ", repaymentDate='" + repaymentDate + '\'' +
                ", totalItem=" + totalItem +
                ", accountId=" + accountId +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", overdueType=" + overdueType +
                ", retCode='" + retCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", allinpaySplitLogId=" + allinpaySplitLogId +
                ", allinpaySplitId=" + allinpaySplitId +
                ", dataId=" + dataId +
                ", payLogId=" + payLogId +
                ", statistId=" + statistId +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
