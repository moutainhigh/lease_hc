package com.hc.lease.account.constant;

import lombok.Getter;

import java.io.Serializable;

/**
 * 承租人银行卡通联支付签约 状态 0:未签约 1:已签约 2签约中 3:签约失败
 *
 * @author tong
 * @since 2018-04-25
 */
public enum AccountBankPaySinStatus implements Serializable {
    AccountBankPaySinStatus_0(0, "未签约"),

    AccountBankPaySinStatus_1(1, "已签约"),

    AccountBankPaySinStatus_2(2, "签约中"),

    AccountBankPaySinStatus_3(3, "签约失败");

    Integer val;

    String desc;

    AccountBankPaySinStatus(Integer val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static AccountBankPaySinStatus parse(String val) {
        if (val != null) {
            for (AccountBankPaySinStatus item : AccountBankPaySinStatus.values()) {
                if (item.getVal().equals(val)) {
                    return item;
                }
            }
        }
        return null;
    }
}
