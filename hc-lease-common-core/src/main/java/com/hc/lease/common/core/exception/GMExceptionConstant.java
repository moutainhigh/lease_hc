package com.hc.lease.common.core.exception;

import java.io.Serializable;

/**
 * 自定义异常(回显)提示名称
 * <p>
 * 要加自定义，跟着最后的编号按顺序编号，防止编号重复
 *
 * @author Tong
 */
public enum GMExceptionConstant implements Serializable {

    /**
     * 数据正常返回
     */
    DATA_LOAD_SUCCESS(1100, "DATA_LOAD_SUCCESS", "成功加载数据"),
    FAILED_SAVE_UPDATE(1101, "FAILED_SAVE_UPDATE", "无数据需要操作"),
    SUCCESS_DELETE(1102, "SUCCESS_DELETE", "成功删除数据"),
    SUCCESS_INSERT(1103, "SUCCESS_INSERT", "保存成功"),
    SUCCESS_UPDATE(1104, "SUCCESS_UPDATE", "修改成功"),
    SUCCESS_UPLOAD(1105, "SUCCESS_UPLOAD", "图片上传成功"),
    FAILE_UPLOAD(1106, "FAILE_UPLOAD", "图片上传失败"),
    UPLOAD_IMG(1107, "UPLOAD_IMG", "只允许上传图片文件"),
    UPLOAD_IMG_SIZE(1108, "UPLOAD_IMG_SIZE", "图片大小超限"),
    UPLOAD_FILE_ERROR(1109, "UPLOAD_FILE_ERROR", "读取文件出错"),
    UPLOAD_FILE_IS_NULL(1110, "UPLOAD_FILE_IS_NULL", "请选择图片"),
    REFERRER_SUCCESS_INSERT(1111, "REFERRER_SUCCESS_INSERT", "添加推荐人成功!"),


    NO_FOUND(1112, "NO_FOUND", "系统忙!"),
    FAILED_SAVE(1113, "FAILED_SAVE", "保存失败"),
    PHONE_REFERRER_SAME(1114, "PHONE_REFERRER_SAME", "用户手机号和推荐人手机号不能相同"),
    OBJECT_NULL_EXCEPTION(1115, "OBJECT_NULL_EXCEPTION", "系统忙!"),//参数异常
    GUOCE_SERVICE_ERROR(1116, "GUOCE_SERVICE_ERROR", "系统忙!"),//服务器异常
    GUOCE_DELETE_ERROR(1117, "GUOCE_DELETE_ERROR", "数据已被使用,不可删除!"),
    NAME_REPEAT(1118, "NAME_REPEAT", "名称重复!"),
    ACCOUNT_PHONE_IS_REPEAT(1119, "ACCOUNT_PHONE_IS_REPEAT", "手机号(联系电话)已被使用!"),
    ACCOUNT_PHONE_IS_NOT_REPEAT(1120, "ACCOUNT_PHONE_IS_NOT_REPEAT", "账号密码错误!"),//账号未注册
    ACCOUNT_IS_LOCK(1121, "ACCOUNT_IS_LOCKING", "账号已锁!"),
    ACCOUNT_IS_NORMAL(1122, "ACCOUNT_IS_NORMAL", "账号正常!"),
    ACCOUNT_PASSWORD_IS_WITHDRAW(1123, "ACCOUNT_PASSWORD_IS_WITHDRAW", "账号已注销!"),
    ACCOUNT_PASSWORD_IS_ERROR(1124, "ACCOUNT_PASSWORD_IS_ERROR", "账号密码错误!"),
    LOGIN_OBJECT_EXCEPTION(1125, "LOGIN_OBJECT_EXCEPTION", "系统忙!"),//登录参数异常
    API_TIME_OUT(1126, "API_TIME_OUT", "请求超时,请重试!"),
    USER_IS_LOGIN(1127, "USER_IS_LOGIN", "请登录!"),//帐号已在其他设备登录,请重新登录
    SIGNATURE_INVALID(1128, "SIGNATURE_INVALID", "请登录!"),//签名已失效
    LOGIN_SUCCESS(1129, "LOGIN_SUCCESS", "登录成功!"),
    UPLOAD_EXCEL(1130, "UPLOAD_EXCEL", "文件类型不正确!"),
    UPLOAD_EXCEL_SIZE(1131, "UPLOAD_EXCEL_SIZE", "文件大小超限"),
    EXCEL_FAILE_UPLOAD(1132, "EXCEL_FAILE_UPLOAD", "图片上传失败"),
    EXCEL_FORMAT_ERROR(1133, "EXCEL_FORMAT_ERROR", "excel读取失败,仅支持excel 97-2003格式的文档,如果是2007及以上版本的excel文档请先转换为97-2003的版本；或者检查excel表格内容格式."),
    ALLINPAY_SEND_SUCCESS(1134, "ALLINPAY_SEND_SUCCESS", "支付提交成功,10分钟内出结果,可在通联日志查看!"),
    ALLINPAY_SEND_FAIL(1135, "ALLINPAY_SEND_FAIL", "通联支付提交失败!"),
    IDCARD_REPEAT(1136, "IDCARD_REPEAT", "身份证号重复!"),
    PLATENUMBER_REPEAT(1137, "PLATENUMBER_REPEAT", "车牌号重复!"),
    ENGINENUMBER_REPEAT(1138, "ENGINENUMBER_REPEAT", "发动机号重复!"),
    CARDFRAMENUMBER_REPEAT(1139, "CARDFRAMENUMBER_REPEAT", "车架号重复!"),
    CONTRACTNUMBER_REPEAT(1140, "CONTRACTNUMBER_REPEAT", "合同编号重复!"),
    REQUESTLIMIT(1141, "REQUESTLIMIT", "访问太频繁!"),
    USER_PHONE_IS_REPEAT(1141, "USER_PHONE_IS_REPEAT", "手机号已被注册!"),
    SIGNATURE_OVER_TIME(1142, "SIGNATURE_OVER_TIME", "请重新登录!"),//签名已过期
    NO_OVERDUE(1143, "NO_OVERDUE", "无需扣取逾期款项!"),
    NO_MONTHLY(1144, "NO_MONTHLY", "无需扣取月供款项!"),
    LOGIN_SUCCESS_OUT(1145, "LOGIN_SUCCESS_OUT", "已退出登录!"),
    NO_NEED_TO_ALLINPAY(1146, "NO_NEED_TO_ALLINPAY", "无交易款项!"),
    PAY_WAY_ERROR(1147, "PAY_WAY_ERROR", "请选择正确的支付方式!"),
    ALLINPAY_TIME_OUT(1148, "ALLINPAY_TIME_OUT", "通联平台请求超时，请稍后重新操作!"),
    ALLINPAY_PARAME_ERROR(1149, "ALLINPAY_PARAME_ERROR", "系统有点忙，请稍候重新操作!"),

    ALLINPAY_VALIDRET_3999(1150, "ALLINPAY_VALIDRET_3999", "卡号所属银行与发卡行不一致!"),
    ALLINPAY_VALIDRET_3031(1151, "ALLINPAY_VALIDRET_3031", "账号户名不符!"),
    ALLINPAY_VALIDRET_3063(1152, "ALLINPAY_VALIDRET_3063", "证件类型和证件号错误!"),
    ALLINPAY_VALIDRET_3004(1153, "ALLINPAY_VALIDRET_3004", "无效卡号!"),

    ALLINPAY_PRICE_OUT_LIMIT(1154, "ALLINPAY_PRICE_OUT_LIMIT", "交易金额超限!"),
    NOTALLINPAY_SUCCESS(1155, "NOTALLINPAY_SUCCESS", "支付提交成功,可在还款历史查看!"),
    SMS_SEND_SUCCESS(1156, "SMS_SEND_SUCCESS", "短信已发送!"),
    NO_SMS_SEND(1157, "NO_SMS_SEND", "没有扣款款项需要发送短信提醒!"),
    SUCCESS_DISABLE(1158, "SUCCESS_DISABLE", "成功禁用数据!"),
    SCHEME_NAME_REPEAT(1159, "SCHEME_NAME_REPEAT", "方案名称重复!"),
    CONTRACT_UPDATE_FAILED(1160, "CONTRACT_UPDATE_FAILED", "合同已生效，不可编辑!"),

    ACCOUNT_NAME_ERROR(1161, "ACCOUNT_NAME_ERROR", "银行户名有误!"),
    ACCOUNT_IDCARD_ERROR(1162, "ACCOUNT_IDCARD_ERROR", "承租人身份证号有误!"),
    ACCOUNT_BACKCARDNUMBER_ERROR(1163, "ACCOUNT_BACKCARDNUMBER_ERROR", "承租人银行卡号有误!"),
    ACCOUNT_TYPE_ERROR(1164, "ACCOUNT_TYPE_ERROR", "请选择正确的用户类型!"),
    DUAL_SUCCESS(1165, "DUAL_SUCCESS", "操作成功!"),
    CONTRACT_NOT_EXIST(1166, "CONTRACT_NOT_EXIST", "合同编号不存在!"),
    CAR_IMPORT_EXCEL_SUCCESS(1167, "CAR_IMPORT_EXCEL_SUCCESS", "车辆数据导入处理成功!"),
    NOT_IS_EXCEL_FORMAT(1168, "NOT_IS_EXCEL_FORMAT", "文件格式异常,请另存为 Excel 97-2003工作薄 (*.xls)"),
    EXCEL_DATE_OVER_LIMIT(1169, "EXCEL_DATE_OVER_LIMIT", "Excel导入数据超限,最多200条数据"),
    EXCEL_SHEET_ERROR(1170, "EXCEL_SHEET_ERROR", "请检查Excel表格的sheet名称"),
    REDIS_CACHE_NOT_EXIST(1171, "REDIS_CACHE_NOT_EXIST", "Redis缓存查询不到"),
    ALLINPAY_SIGN_SUCCESS(1172, "ALLINPAY_SIGN_SUCCESS", "已成功签约。谢谢!"),//通联支付签约成功!
    ALLINPAY_SIGN_ERROR(1173, "ALLINPAY_SIGN_ERROR", "签约失败,请重新提交签约!"),//通联支付签约 缺少电话号码 或者银行卡号
    ALLINPAY_SIGN_BANKCARDNUMBER_ISSIGN(1174, "ALLINPAY_SIGN_BANKCARDNUMBER_ISSIGN", "银行卡已签约!"),//银行卡已签约
    BANK_CARD_SIGN_ERROR(1175, "BANK_CARD_SIGN_ERROR", "承租人银行卡未签约!"),
    ALLINPAY_QUICK_SUCCESS(1176, "ALLINPAY_QUICK_SUCCESS", "支付成功!"),//通联协议支付成功
    ALLINPAY_QUICK_FAIL(1177, "ALLINPAY_QUICK_FAIL", "支付失败!"),//通联协议支付失败
    ALLINPAY_SIZE_LIMIT(1178, "ALLINPAY_SIZE_LIMIT", "超限额只支持交易一笔!"),//超限额只能选中一条扣款计划
    SPLIT_ALLINPAY_SEND_SUCCESS(1179, "SPLIT_ALLINPAY_SEND_SUCCESS", "提交成功！（如有拆分支付单，请在“通联支付拆单”中跟进）"),
    CHECK_SAME_LEVEL_SORT(1180, "CHECK_SAME_LEVEL_SORT", "组织排序序号冲突!"),
    ORGANIZATION_TYPE_ERROR(1181, "ORGANIZATION_TYPE_ERROR", "组织类型不正确!"),
    ORGANIZATION_HAVE_CHILD_ERROR(1182, "ORGANIZATION_HAVE_CHILD_ERROR", "存在下级，不可删除!"),
    ORGANIZATION_IS_DEFAULT_ERROR(1183, "ORGANIZATION_IS_DEFAULT_ERROR", "系统默认的组织不可删除!"),
    NUMBER_REPEAT(1184, "NUMBER_REPEAT", "编号重复!"),
    MANUAL_ALLINPAY_SEND_SUCCESS(1185, "MANUAL_ALLINPAY_SEND_SUCCESS", "支付提交成功,10分钟内出结果,合同还款可在还款记录查看或者下载结果!"),//手动扣款
    MANUAL_DEDUCTIONS_IS_PAY(1186, "MANUAL_DEDUCTIONS_IS_PAY", "已经提交支付，不能重新上传!"),
    CONTRACT_IS_PAYING(1187, "CONTRACT_IS_PAYING", "合同有款项正在扣款中，不可编辑!"),
    CONTINUECONTRACT_ERROR(1188, "CONTINUECONTRACT_ERROR", "此合同不能操作续租!"),
    TRANSFERCONTRACT_ERROR(1189, "TRANSFERCONTRACT_ERROR", "此合同不能操作转租!");

    private Integer status;// 回显状态码
    private String errorCode;// 回显类型码
    private String errMsg;// 回显信息

    GMExceptionConstant(Integer status, String errorCode, String errMsg) {
        this.status = status;
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
