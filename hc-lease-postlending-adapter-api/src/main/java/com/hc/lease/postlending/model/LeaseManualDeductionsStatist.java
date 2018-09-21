package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 手动扣款统计
 */
public class LeaseManualDeductionsStatist implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "任务ID/编号", hidden = false)
    private String number;
    @ApiModelProperty(value = "总数量", hidden = false)
    private Integer totalSum;
    @ApiModelProperty(value = "成功数量", hidden = false)
    private Integer successNumber;
    @ApiModelProperty(value = "失败数量", hidden = false)
    private Integer failNumber;
    @ApiModelProperty(value = "总金额/应扣总额", hidden = false)
    private BigDecimal totalPrice;
    @ApiModelProperty(value = "已扣总额/实扣总额/成功总额", hidden = false)
    private BigDecimal receiptsPrice;
    @ApiModelProperty(value = "未扣总额", hidden = false)
    private BigDecimal unPrice;
    @ApiModelProperty(value = "失败总额", hidden = false)
    private BigDecimal failPrice;
    @ApiModelProperty(value = "是否已下载核对 0否 1是", hidden = false)
    private Integer isCheck;
    @ApiModelProperty(value = "是否已提交支付 0否 1是", hidden = false)
    private Integer isPay;
    @ApiModelProperty(value = "是否已下载结果 0否 1是", hidden = false)
    private Integer isDownloadResult;
    @ApiModelProperty(value = "是否可重新上传 0否 1是", hidden = false)
    private Integer isImportAgain;
    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期/操作日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人/操作人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人/操作人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    public Integer getSuccessNumber() {
        return successNumber;
    }

    public void setSuccessNumber(Integer successNumber) {
        this.successNumber = successNumber;
    }

    public Integer getFailNumber() {
        return failNumber;
    }

    public void setFailNumber(Integer failNumber) {
        this.failNumber = failNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getReceiptsPrice() {
        return receiptsPrice;
    }

    public void setReceiptsPrice(BigDecimal receiptsPrice) {
        this.receiptsPrice = receiptsPrice;
    }

    public BigDecimal getUnPrice() {
        return unPrice;
    }

    public void setUnPrice(BigDecimal unPrice) {
        this.unPrice = unPrice;
    }

    public BigDecimal getFailPrice() {
        return failPrice;
    }

    public void setFailPrice(BigDecimal failPrice) {
        this.failPrice = failPrice;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Integer getIsDownloadResult() {
        return isDownloadResult;
    }

    public void setIsDownloadResult(Integer isDownloadResult) {
        this.isDownloadResult = isDownloadResult;
    }

    public Integer getIsImportAgain() {
        return isImportAgain;
    }

    public void setIsImportAgain(Integer isImportAgain) {
        this.isImportAgain = isImportAgain;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "LeaseManualDeductionsStatist{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", totalSum=" + totalSum +
                ", successNumber=" + successNumber +
                ", failNumber=" + failNumber +
                ", totalPrice=" + totalPrice +
                ", receiptsPrice=" + receiptsPrice +
                ", unPrice=" + unPrice +
                ", failPrice=" + failPrice +
                ", isCheck=" + isCheck +
                ", isPay=" + isPay +
                ", isDownloadResult=" + isDownloadResult +
                ", isImportAgain=" + isImportAgain +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", remarks='" + remarks + '\'' +
                ", ids=" + ids +
                '}';
    }
}