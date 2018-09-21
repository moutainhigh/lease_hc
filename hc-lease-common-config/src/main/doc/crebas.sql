﻿/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2017/4/18 17:11:00                           */
/*==============================================================*/


drop table lease_account;

drop table lease_account_session;

drop table lease_account_credit;

drop table lease_archive_location;

drop table lease_bank;

drop table lease_branch_company;

drop table lease_car;

drop table lease_car_brands;

drop table lease_car_buy_financinger;

drop table lease_car_color;

drop table lease_car_insurance;

drop table lease_car_inventory;

drop table lease_car_maintain_rule;

drop table lease_car_model;

drop table lease_car_model_color;

drop table lease_car_series;

drop table lease_car_supplier;

drop table lease_company_header;

drop table lease_company_receivables_info;

drop table lease_contract;

drop table lease_contract_archive_location;

drop table lease_contract_baseinfo;

drop table lease_contract_status;

drop table lease_dealer;

drop table lease_dict;

drop table lease_gps_supplier;

drop table lease_insurance_company;

drop table lease_insurance_type;

drop table lease_invoice_header;

drop table lease_maintenance_partner;

drop table lease_package;

drop table lease_scheme;

drop table lease_scheme_car;

drop table lease_scheme_order;

drop table lease_scheme_order_status;

drop table lease_scheme_package;

drop table lease_storehouse;

drop table lease_rule;

drop table lease_area;

drop table lease_purchase_payment_history;

drop table lease_scheme_order_account;

drop table lease_purchase_contract;

drop table lease_allinpay_batch;

drop table lease_allinpay_log;

drop table lease_overdue_log;

drop table lease_allinpay_status_log;

drop table lease_scheme_repayment;

drop table lease_scheme_vehicle;

drop table lease_scheme_area;

drop table lease_car_dict_accessory;

drop table lease_use_used;

drop table lease_user;

drop table lease_user_session

drop table lease_scheme_repayment_status;

drop table lease_scheme_car_financinger;

drop table lease_contract_link;

drop table lease_contract_advance;

drop table lease_contract_link_repayment;

drop table lease_allinpay_query_log;

drop table lease_contract_repayment_except;

drop table lease_sms_log;

drop table lease_contract_sms;

drop table lease_contract_baseinfo_use;

drop table lease_scheme_car_financinger;

drop table lease_allinpay_status_sms;

drop table lease_account_company;

drop table lease_user_login_log;

drop table lease_wx_customer;

drop table lease_wx_agent;

drop table lease_wx_car;

drop table lease_wx_car_scheme;

drop table lease_wx_home_img;

drop table lease_wx_company_profile;

drop table lease_wx_title;

drop table lease_wx_agent_img;

drop table lease_wx_company_contact;

drop table lease_wx_buy_description;

drop table lease_wx_level;

drop table lease_wx_secondary;

drop table lease_wx_stores;

drop table lease_account_bank_pay_sin;

drop table lease_account_bankpaysin_log;

drop table lease_bank_allinpay_price_limit;

drop table lease_allinpay_split;

drop table lease_allinpay_split_log;

drop table lease_allinpay_split_batch;

drop table lease_allinpay_split_status_log;

drop table lease_allinpay_split_query_log;

drop table lease_allinpay_split_connect;

drop table lease_manual_deductions_statist;

drop table lease_manual_deductions_data;

drop table lease_manual_deductions_pay_log;

drop table lease_manual_deducti_status_log;

drop table lease_manual_deductio_query_log;

drop table lease_scheme_repayment_history;

drop table lease_scheme_repayment_status_h;

drop table lease_contract_deal_end;

drop table lease_contract_car_callback;

drop table lease_contract_car_lose;

drop table lease_contract_car_scrap;

drop table lease_contract_income_expe;

/*==============================================================*/
/* Table: lease_account                                         */
/*==============================================================*/
create table lease_account (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Sex                  INT4                 null,
   Phone                varchar(100)         null,
   Id_Card              varchar(100)         null,
   Marital_Status       INT4                 null,
   Real_Name            varchar(100)         null,
   Salt                 varchar(100)         null,
   Password             varchar(100)         null,
   Icon                 text         null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Address              varchar(100)         null,
   Status               INT4                 null,
   Contacts             varchar(100)         null,
   Contact_Information  varchar(100)         null,
   Reg_Way              INT4                 null,
   Company_Name         varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_ACCOUNT primary key (Id)
);

CREATE SEQUENCE lease_account_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_account alter column id set default nextval('lease_account_id_seq');

comment on table lease_account is
'注册用户/承租人';

comment on column lease_account.Id is
'主键id';

comment on column lease_account.Name is
'用户名称';

comment on column lease_account.Sex is
'性别:0:女,1:男';

comment on column lease_account.Phone is
'手机号(账号)';

comment on column lease_account.Id_Card is
'真实姓名';

comment on column lease_account.Marital_Status is
'真实姓名';

comment on column lease_account.Real_Name is
'真实姓名';

comment on column lease_account.Salt is
'加密盐';

comment on column lease_account.Password is
'密码';

comment on column lease_account.Icon is
'头像';

comment on column lease_account.Province_Id is
'省份ID';

comment on column lease_account.Province_Name is
'省份名称';

comment on column lease_account.City_Id is
'城市ID';

comment on column lease_account.City_Name is
'城市名称';

comment on column lease_account.Area_Id is
'区域ID';

comment on column lease_account.Area_Name is
'区域名称';

comment on column lease_account.Address is
'详细地址';

comment on column lease_account.Status is
'0锁定 1正常 2注销';

comment on column lease_account.Contacts is
'联系人';

comment on column lease_account.Contact_Information is
'联系方式';

comment on column lease_account.Reg_Way is
'注册渠道0:APP;1:微信;2:官网';

comment on column lease_account.Company_Name is
'公司名称(客户)';

comment on column lease_account.Create_Time is
'创建日期';

comment on column lease_account.Update_Time is
'修改日期';

comment on column lease_account.Create_By is
'创建人';

comment on column lease_account.Update_By is
'修改人';


/*==============================================================*/
/* Table: lease_account_session                                 */
/*==============================================================*/
create table lease_account_session (
   Id                   INT8                 not null,
   Device_Id            varchar(100)         null,
   Account_Id           INT4                 null,
   Phone                varchar(100)         null,
   Real_Name            varchar(100)         null,
   Session_Current      varchar(100)         null,
   Session_Code         varchar(100)         null,
   Session_Login_Time   timestamp            null,
   Session_Limit_Time   timestamp            null,
   constraint PK_LEASE_ACCOUNT_SESSION primary key (Id)
);

CREATE SEQUENCE lease_account_session_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_account_session alter column id set default nextval('lease_account_session_id_seq');

comment on table lease_account_session is
'注册用户/承租人登录状态session';

comment on column lease_account_session.Id is
'主键id';

comment on column lease_account_session.Device_Id is
'登录设备ID';

comment on column lease_account_session.Account_Id is
'用户主键id';

comment on column lease_account_session.Phone is
'手机号(账号)';

comment on column lease_account_session.Real_Name is
'真实姓名';

comment on column lease_account_session.Session_Current is
'当前token';

comment on column lease_account_session.Session_Code is
'验证码';

comment on column lease_account_session.Session_Login_Time is
'最近登录时间';

comment on column lease_account_session.Session_Limit_Time is
'token有效时间';

/*==============================================================*/
/* Table: lease_account_credit                                  */
/*==============================================================*/
create table lease_account_credit (
   Id                   INT8                 not null,
   Account_Id           INT8                 null,
   Id_Card_Address      varchar(100)         null,
   Live_Address         varchar(100)         null,
   Zip_Code             varchar(100)         null,
   Housing_Type         INT8                 null,
   Housing_Type_Other_Describe varchar(100)         null,
   Spouse_Name          varchar(100)         null,
   Spouse_Phone         varchar(100)         null,
   Spouse_Id_Card       varchar(100)         null,
   Spouse_Id_Card_Img_Obverse_Sid text         null,
   Spouse_Id_Card_Img_Reverse_Sid text         null,
   Marriage_Certificate_Img text         null,
   Emergency_Contact    text         null,
   Work_Unit            varchar(100)         null,
   Work_Unit_Phone      varchar(100)         null,
   Half_Year_Month_Income varchar(100)         null,
   Id_Card              varchar(100)         null,
   Id_Card_Img_Obverse_Side text         null,
   Id_Card_Img_Reverse_Side text         null,
   Driver_License_Number varchar(100)         null,
   Driver_License_Img   text         null,
   Bank_Id              varchar(100)         null,
   Branch_Bank          varchar(100)         null,
   Back_Card_Number     varchar(100)         null,
   Back_Card_Img        text         null,
   Bank_Statement_Img   text         null,
   Earnings_Proof_Img   text         null,
   Net_Car_Receivable_Log_Img text         null,
   Communication_List_Img text         null,
   Attoney_Power_Img    text         null,   
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_ACCOUNT_CREDIT primary key (Id)
);

CREATE SEQUENCE lease_account_credit_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_account_credit alter column id set default nextval('lease_account_credit_id_seq');

comment on table lease_account_credit is
'用户征信信息';

comment on column lease_account_credit.Id is
'主键id';

comment on column lease_account_credit.Account_Id is
'注册用户/承租人主键id';

comment on column lease_account_credit.Id_Card_Address is
'身份证地址';

comment on column lease_account_credit.Live_Address is
'实际居住地址';

comment on column lease_account_credit.Zip_Code is
'邮编';

comment on column lease_account_credit.Housing_Type is
'住房类型 0:自有无贷款;1:自有有贷款;2:租房;3:其他/数据字典的住房类型';

comment on column lease_account_credit.Housing_Type_Other_Describe is
'住房类型为其他的描述';

comment on column lease_account_credit.Spouse_Name is
'配偶姓名';

comment on column lease_account_credit.Spouse_Phone is
'配偶身份证号';

comment on column lease_account_credit.Spouse_Id_Card is
'配偶身份证号';

comment on column lease_account_credit.Spouse_Id_Card_Img_Obverse_Sid is
'配偶身份证照片正面';

comment on column lease_account_credit.Spouse_Id_Card_Img_Reverse_Sid is
'配偶身份证照片反面';

comment on column lease_account_credit.Marriage_Certificate_Img is
'结婚证照片';

comment on column lease_account_credit.Emergency_Contact is
'紧急联系人/json格式存放多个联系人/包括:紧急联系人姓名(Emergency_Contact_Name)；紧急联系人与本人关系(Emergency_Contact_Relationship)；急联系人手机(Emergency_Contact_Phone)';

comment on column lease_account_credit.Work_Unit is
'工作单位';

comment on column lease_account_credit.Work_Unit_Phone is
'工作单位固话';

comment on column lease_account_credit.Half_Year_Month_Income is
'近半年月均收入';

comment on column lease_account_credit.Id_Card is
'身份证号';

comment on column lease_account_credit.Id_Card_Img_Obverse_Side is
'身份证照片正面';

comment on column lease_account_credit.Id_Card_Img_Reverse_Side is
'身份证照片反面';

comment on column lease_account_credit.Driver_License_Number is
'驾驶证号';

comment on column lease_account_credit.Driver_License_Img is
'驾驶证照片';

comment on column lease_account_credit.Bank_Id is
'银行卡发卡行';

comment on column lease_account_credit.Branch_Bank is
'银行卡发卡行';

comment on column lease_account_credit.Back_Card_Number is
'银行卡号';

comment on column lease_account_credit.Back_Card_Img is
'银行卡照片';

comment on column lease_account_credit.Bank_Statement_Img is
'银行对账单照片';

comment on column lease_account_credit.Earnings_Proof_Img is
'收入证明照片';

comment on column lease_account_credit.Net_Car_Receivable_Log_Img is
'网约车应收流水截图';

comment on column lease_account_credit.Communication_List_Img is
'近三个月通信清单照片';

comment on column lease_account_credit.Attoney_Power_Img is
'征信授权书照片';
comment on column lease_car_color.Create_Time is
'创建日期';

comment on column lease_car_color.Update_Time is
'修改日期';

comment on column lease_car_color.Create_By is
'创建人';

comment on column lease_car_color.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_archive_location                                */
/*==============================================================*/
create table lease_archive_location (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Remarks              TEXT                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean               null,
   constraint PK_LEASE_ARCHIVE_LOCATION primary key (Id)
);

CREATE SEQUENCE lease_archive_location_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_archive_location alter column id set default nextval('lease_archive_location_id_seq');

comment on table lease_archive_location is
'归档位置';

comment on column lease_archive_location.Id is
'主键id';

comment on column lease_archive_location.Name is
'名称';

comment on column lease_archive_location.Remarks is
'备注';

comment on column lease_archive_location.Create_Time is
'创建日期';

comment on column lease_archive_location.Update_Time is
'修改日期';

comment on column lease_archive_location.Create_By is
'创建人';

comment on column lease_archive_location.Update_By is
'修改人';

comment on column lease_archive_location.Sort is
'排序';

comment on column lease_archive_location.Is_Enable is
'状态 0:禁用 1:启用';

/*==============================================================*/
/* Table: lease_bank                                            */
/*==============================================================*/
create table lease_bank (
   Id                   INT8                 not null,
   Code                 varchar(100)         null,
   Name                 varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean               null,
   Sort                 INT4                 null,
   Pin_Yin              varchar(100)         null,
   Short_Pin_Yin        varchar(100)         null,
   constraint PK_LEASE_BANK primary key (Id)
);

CREATE SEQUENCE lease_bank_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_bank alter column id set default nextval('lease_bank_id_seq');

comment on table lease_bank is
'银行';

comment on column lease_bank.Id is
'主键id';

comment on column lease_bank.Code is
'银行编码';

comment on column lease_bank.Name is
'银行名称';

comment on column lease_bank.Create_Time is
'创建日期';

comment on column lease_bank.Update_Time is
'修改日期';

comment on column lease_bank.Create_By is
'创建人';

comment on column lease_bank.Update_By is
'修改人';

comment on column lease_bank.Is_Enable is
'是否开放';

comment on column lease_bank.Sort is
'排序';

comment on column lease_bank.Pin_Yin is
'拼音全称';

comment on column lease_bank.Short_Pin_Yin is
'拼音简称';

/*==============================================================*/
/* Table: lease_branch_company                                  */
/*==============================================================*/
create table lease_branch_company (
   Id                   INT8                 not null,
   Number               varchar(100)         null,
   Name                 varchar(100)         null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Address              varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean               null,
   Contacts             varchar(100)         null,
   Contact_Phone        varchar(100)         null,
   Company_Code         varchar(100)         null,
   Parent_Id            INT8                 null,
   Sort                 INT4                 null,
   constraint PK_LEASE_BRANCH_COMPANY primary key (Id)
);

CREATE SEQUENCE lease_branch_company_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_branch_company alter column id set default nextval('lease_branch_company_id_seq');

comment on table lease_branch_company is
'分公司';

comment on column lease_branch_company.Id is
'主键id';

comment on column lease_branch_company.Number is
'编号';

comment on column lease_branch_company.Name is
'公司名称';

comment on column lease_branch_company.Province_Id is
'省份ID';

comment on column lease_branch_company.Province_Name is
'省份名称';

comment on column lease_branch_company.City_Id is
'城市ID';

comment on column lease_branch_company.City_Name is
'城市名称';

comment on column lease_branch_company.Area_Id is
'区域ID';

comment on column lease_branch_company.Area_Name is
'区域名称';

comment on column lease_branch_company.Address is
'详细地址';

comment on column lease_branch_company.Create_Time is
'创建日期';

comment on column lease_branch_company.Update_Time is
'修改日期';

comment on column lease_branch_company.Create_By is
'创建人';

comment on column lease_branch_company.Update_By is
'修改人';

comment on column lease_branch_company.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_branch_company.Contacts is
'联系人';

comment on column lease_branch_company.Contact_Phone is
'联系人手机';

comment on column lease_branch_company.Company_Code is
'公司编号';

comment on column lease_branch_company.Parent_Id is
'父级ID';

comment on column lease_branch_company.Sort is
'排序';

/*==============================================================*/
/* Table: lease_car                                             */
/*==============================================================*/
create table lease_car (
   Id                   INT8                 not null,
   Contract_Number      varchar(100)         null,
   Car_Buy_Financinger_Id INT8                 null,
   Brands_Id            INT8                 null,
   Series_Id            INT8                 null,
   Model_Id             INT8                 null,
   Color_Id             INT8                 null,
   Card_Frame_Number    varchar(100)         null,
   Engine_Number        varchar(100)         null,
   Manufacture_Time     timestamp            null,
   Certificate_Number   varchar(100)         null,
   Invoice_Number       varchar(100)         null,
   Accessory_Id         INT8                 null,
   Mortgage_Type_Id     INT8                 null,
   Mortgage_Type_Name   varchar(100)         null,
   Buy_Card_Capital_Type_Id INT8                 null,
   Buy_Card_Capital_Type_Name varchar(100)         null,
   Belonger_Tpye        INT4                 null,
   Belonger_Company_Header_Id INT8                 null,
   Insurance_Beneficiary_Type INT4                 null,
   Beneficiary_Company_Header_Id INT8                 null,
   Beneficia_Financinger_Id INT8                 null,
   Plate_Number         varchar(100)         null,
   Registration_Number  varchar(100)         null,
   Registration_Number_Img varchar(100)         null,
   Gps_Supplier_Id      INT8                 null,
   Price                DECIMAL(20,2)        null,
   Purchase_Tax_Rate    DECIMAL(20,2)        null,
   Purchase_Tax         DECIMAL(20,2)        null,
   On_Plate_Cost        DECIMAL(20,2)        null,
   Gps_Cost             DECIMAL(20,2)        null,
   Mortgage_Cost        DECIMAL(20,2)        null,
   Vehicle_Vessel_Tax   DECIMAL(20,2)        null,
   Other_Cost           DECIMAL(20,2)        null,
   Storehouse_Id        INT8                 null,
   Dealer_Id            INT8                 null,
   Storehouse_Status    INT4                 null,
   Lease_Status         INT4                 null,
   Is_Enable            boolean               null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Insurance_Status     boolean               null,
   Gps_Status           boolean               null,
   Plate_Status         boolean               null,
   In_Storehouse_Time   TIMESTAMP            null,
   Sale_Channel_Type    INT4                 null,
   Sale_Channel_Id      INT8                 null,
   Sale_Time            TIMESTAMP            null,
   Remarks              text                 null,
   Contract_Id          INT8                 null,
   Invoicing_Tax        DECIMAL(10,2)        null,
   Invoiced_Car_Price   DECIMAL(10,2)        null,
   Branch_Company_Id    INT8                 null,
   Mortgage_Status      BOOL                 null,
   Storehouse_Type      INT4                 null,
   Deal_Status          varchar(100)         null,
   Car_Condition        INT4                 default 1,
   constraint PK_LEASE_CAR primary key (Id)
);

CREATE SEQUENCE lease_car_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car alter column id set default nextval('lease_car_id_seq');

comment on table lease_car is
'车辆信息';

comment on column lease_car.Id is
'主键id';

comment on column lease_car.Contract_Number is
'采购合同编号';

comment on column lease_car.Car_Buy_Financinger_Id is
'融资方主键id';

comment on column lease_car.Brands_Id is
'品牌主键Id';

comment on column lease_car.Series_Id is
'系列主键Id';

comment on column lease_car.Model_Id is
'车型主键Id';

comment on column lease_car.Color_Id is
'颜色';

comment on column lease_car.Card_Frame_Number is
'车架号';

comment on column lease_car.Engine_Number is
'发动机号';

comment on column lease_car.Manufacture_Time is
'出厂日期';

comment on column lease_car.Certificate_Number is
'合格证号';

comment on column lease_car.Invoice_Number is
'发票号';

comment on column lease_car.Accessory_Id is
'随车物料';

comment on column lease_car.Plate_Number is
'车牌号';

comment on column lease_car.Registration_Number is
'车辆登记证';

comment on column lease_car.Registration_Number_Img is
'车辆登记证';

comment on column lease_car.Gps_Supplier_Id is
'GPS供应商主键id';

comment on column lease_car.Price is
'不含税车价';

comment on column lease_car.Purchase_Tax_Rate is
'GPS费用';

comment on column lease_car.Purchase_Tax is
'GPS费用';

comment on column lease_car.On_Plate_Cost is
'GPS费用';

comment on column lease_car.Gps_Cost is
'GPS费用';

comment on column lease_car.Mortgage_Cost is
'抵押费用';

comment on column lease_car.Vehicle_Vessel_Tax is
'抵押费用';

comment on column lease_car.Other_Cost is
'其他费用';

comment on column lease_car.Storehouse_Id is
'仓库主键id';

comment on column lease_car.Dealer_Id is
'经销商主键Id';

comment on column lease_car.Storehouse_Status is
'库存状态0:未入仓;1:已出仓;2:公司仓库;3:经销商仓库';

comment on column lease_car.Lease_Status is
'状态0:已过户;1:已回收';

comment on column lease_car.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_car.Create_Time is
'创建日期';

comment on column lease_car.Update_Time is
'修改日期';

comment on column lease_car.Create_By is
'创建人';

comment on column lease_car.Update_By is
'修改人';

comment on column lease_car.Sort is
'排序';

comment on column lease_car.Sale_Channel_Type is
'合同编号-HC融租字';

comment on column lease_car.Sale_Channel_Id is
'合同编号-HC融租字';

/*==============================================================*/
/* Table: lease_car_brands                                      */
/*==============================================================*/
create table lease_car_brands (
   Id                   INT8                 not null,
   Number               varchar(100)         null,
   Name                 varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean               null,
   constraint PK_LEASE_CAR_BRANDS primary key (Id)
);

CREATE SEQUENCE lease_car_brands_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_brands alter column id set default nextval('lease_car_brands_id_seq');

comment on table lease_car_brands is
'车辆品牌';

comment on column lease_car_brands.Id is
'主键id';

comment on column lease_car_brands.Number is
'编号';

comment on column lease_car_brands.Name is
'品牌名称';

comment on column lease_car_brands.Create_Time is
'创建日期';

comment on column lease_car_brands.Update_Time is
'修改日期';

comment on column lease_car_brands.Create_By is
'创建人';

comment on column lease_car_brands.Update_By is
'修改人';

comment on column lease_car_brands.Sort is
'排序';

comment on column lease_car_brands.Is_Enable is
'状态 0:禁用 1:启用';

/*==============================================================*/
/* Table: lease_car_buy_financinger                             */
/*==============================================================*/
create table lease_car_buy_financinger (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Financing_Mode       INT8                 null,
   Financing_Quota      DECIMAL(20,2)        null,
   Financing_Proportion DECIMAL(20,2)        null,
   Contacts             varchar(100)         null,
   Phone                varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Address              varchar(100)         null,
   Is_Enable            boolean               null,
   constraint PK_LEASE_CAR_BUY_FINANCINGER primary key (Id)
);

CREATE SEQUENCE lease_car_buy_financinger_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_buy_financinger alter column id set default nextval('lease_car_buy_financinger_id_seq');

comment on table lease_car_buy_financinger is
'购车融资方';

comment on column lease_car_buy_financinger.Id is
'主键id';

comment on column lease_car_buy_financinger.Name is
'名称';

comment on column lease_car_buy_financinger.Financing_Mode is
'融资方式(数据字典里面的数据)';

comment on column lease_car_buy_financinger.Financing_Quota is
'融资额度（元）';

comment on column lease_car_buy_financinger.Financing_Proportion is
'融资比例（%）';

comment on column lease_car_buy_financinger.Contacts is
'联系人';

comment on column lease_car_buy_financinger.Phone is
'电话';

comment on column lease_car_buy_financinger.Create_Time is
'创建日期';

comment on column lease_car_buy_financinger.Update_Time is
'修改日期';

comment on column lease_car_buy_financinger.Create_By is
'创建人';

comment on column lease_car_buy_financinger.Update_By is
'修改人';

comment on column lease_car_buy_financinger.Sort is
'排序';

comment on column lease_car_buy_financinger.Province_Id is
'省份ID';

comment on column lease_car_buy_financinger.Province_Name is
'省份名称';

comment on column lease_car_buy_financinger.City_Id is
'城市ID';

comment on column lease_car_buy_financinger.City_Name is
'城市名称';

comment on column lease_car_buy_financinger.Area_Id is
'区域ID';

comment on column lease_car_buy_financinger.Area_Name is
'区域名称';

comment on column lease_car_buy_financinger.Address is
'详细地址';

comment on column lease_car_buy_financinger.Is_Enable is
'状态 0:禁用 1:启用';

/*==============================================================*/
/* Table: lease_car_color                                       */
/*==============================================================*/
create table lease_car_color (
   Id                   INT8                 not null,
   Number               varchar(100)         null,
   Name                 varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean               null,
   constraint PK_LEASE_CAR_COLOR primary key (Id)
);

CREATE SEQUENCE lease_car_color_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_color alter column id set default nextval('lease_car_color_id_seq');

comment on table lease_car_color is
'车辆颜色';

comment on column lease_car_color.Id is
'主键id';

comment on column lease_car_color.Number is
'编号';

comment on column lease_car_color.Name is
'车型名称';

comment on column lease_car_color.Create_Time is
'创建日期';

comment on column lease_car_color.Update_Time is
'修改日期';

comment on column lease_car_color.Create_By is
'创建人';

comment on column lease_car_color.Update_By is
'修改人';

comment on column lease_car_color.Sort is
'排序';

comment on column lease_car_color.Is_Enable is
'状态 0:禁用 1:启用';

/*==============================================================*/
/* Table: lease_car_insurance                                   */
/*==============================================================*/
create table lease_car_insurance (
   Id                   INT8                 not null,
   Car_Id               INT8                 null,
   Insurance_Company_Id INT8                 null,
   Insurance_Type_Id    INT8                 null,
   Type                 INT4                 null,
   Insurance_Number     VARCHAR(100)         null,
   Premium              DECIMAL(20,2)        null,
   Sum_Insured          DECIMAL(20,2)        null,
   Policy_Scanner_Img   VARCHAR(100)         null,
   Effective_Time       TIMESTAMP            null,
    Year                 INT4                 null,
   Tax_Allowances        DECIMAL(20,2)        null,
   Vat_Invoice_Number      VARCHAR(100)         null,
   Ticket_Invoice_Number   VARCHAR(100)        null,
   Ticket_Tax_Amount     DECIMAL(20,2)        null,
   No_Vat_Policy_Amount     DECIMAL(20,2)        null,
   No_Ordinary_Tax_Policy     DECIMAL(20,2)        null,
   constraint PK_LEASE_CAR_INSURANCE primary key (Id)
);

CREATE SEQUENCE lease_car_insurance_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_insurance alter column id set default nextval('lease_car_insurance_id_seq');

comment on table lease_car_insurance is
'车辆保险信息';

comment on column lease_car_insurance.Id is
'主键id';

comment on column lease_car_insurance.Car_Id is
'车辆主键Id';

comment on column lease_car_insurance.Insurance_Company_Id is
'保险公司主键Id';

comment on column lease_car_insurance.Insurance_Type_Id is
'险种主键Id';

comment on column lease_car_insurance.Type is
'类型 0:第1年;1:第2年;2:第3年';

comment on column lease_car_insurance.Insurance_Number is
'保单号';

comment on column lease_car_insurance.Premium is
'保费';

comment on column lease_car_insurance.Sum_Insured is
'保额';

comment on column lease_car_insurance.Policy_Scanner_Img is
'保单扫描件';

/*==============================================================*/
/* Table: lease_car_inventory                                   */
/*==============================================================*/
create table lease_car_inventory (
   Id                   INT8                 not null,
   Brands_Id            INT8                 null,
   Series_Id            INT8                 null,
   Model_Id             INT8                 null,
   Storehouse_Id        INT8                 null,
   Current_Inventory_Number INT4                 null,
   Lease_Number         INT4                 null,
   Transfer_Storehouse_Number INT4                 null,
   In_Storehouse_Operator_Id INT8                 null,
   In_Storehouse_Operator_Name VARCHAR(100)         null,
   constraint PK_LEASE_CAR_INVENTORY primary key (Id)
);

CREATE SEQUENCE lease_car_inventory_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_inventory alter column id set default nextval('lease_car_inventory_id_seq');

comment on table lease_car_inventory is
'库存';

comment on column lease_car_inventory.Id is
'主键id';

comment on column lease_car_inventory.Brands_Id is
'品牌主键Id';

comment on column lease_car_inventory.Series_Id is
'系列主键Id';

comment on column lease_car_inventory.Model_Id is
'车型主键Id';

/*==============================================================*/
/* Table: lease_car_maintain_rule                               */
/*==============================================================*/
create table lease_car_maintain_rule (
   Id                   INT8                 not null,
   Kilometre_Number     INT4                 null,
   Months_Number        INT4                 null,
   Remarks              text                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean               null,
   constraint PK_LEASE_CAR_MAINTAIN_RULE primary key (Id)
);

CREATE SEQUENCE lease_car_maintain_rule_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_maintain_rule alter column id set default nextval('lease_car_maintain_rule_id_seq');

comment on table lease_car_maintain_rule is
'保养规则';

comment on column lease_car_maintain_rule.Id is
'主键id';

comment on column lease_car_maintain_rule.Kilometre_Number is
'编号';

comment on column lease_car_maintain_rule.Months_Number is
'品牌主键id';

comment on column lease_car_maintain_rule.Remarks is
'车型名称';

comment on column lease_car_maintain_rule.Create_Time is
'创建日期';

comment on column lease_car_maintain_rule.Update_Time is
'修改日期';

comment on column lease_car_maintain_rule.Create_By is
'创建人';

comment on column lease_car_maintain_rule.Update_By is
'修改人';

comment on column lease_car_maintain_rule.Sort is
'排序';

comment on column lease_car_maintain_rule.Is_Enable is
'状态 0:禁用 1:启用';

/*==============================================================*/
/* Table: lease_car_model                                       */
/*==============================================================*/
create table lease_car_model (
   Id                   INT8                 not null,
   Number               varchar(100)         null,
   Series_Id            INT8                 null,
   Complete_Model_Name  varchar(100)         null,
   Item_Type  			varchar(100)         null,
   Particular_Year      varchar(100)         null,
   Business_Model_Name  varchar(100)         null,
   Model_Code           varchar(100)         null,
   Fuel_Type            INT8                 null,
   Remarks              text                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean               null,
   Dict_Id_Output_Volume INT8                 null,
   Maintain_Rule_Id     INT8                 null,
   constraint PK_LEASE_CAR_MODEL primary key (Id)
);

CREATE SEQUENCE lease_car_model_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_model alter column id set default nextval('lease_car_model_id_seq');

comment on table lease_car_model is
'车辆车型';

comment on column lease_car_model.Id is
'主键id';

comment on column lease_car_model.Number is
'编号';

comment on column lease_car_model.Series_Id is
'品牌主键id';

comment on column lease_car_model.Complete_Model_Name is
'完整型号';

comment on column lease_car_model.Item_Type is
'标的物类型';

comment on column lease_car_model.Particular_Year is
'年份';

comment on column lease_car_model.Business_Model_Name is
'商业型号';

comment on column lease_car_model.Model_Code is
'型号代码';

comment on column lease_car_model.Fuel_Type is
'燃料类型/字典表的燃料类型主键id';

comment on column lease_car_model.Remarks is
'备注';

comment on column lease_car_model.Create_Time is
'创建日期';

comment on column lease_car_model.Update_Time is
'修改日期';

comment on column lease_car_model.Create_By is
'创建人';

comment on column lease_car_model.Update_By is
'修改人';

comment on column lease_car_model.Sort is
'排序';

comment on column lease_car_model.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_car_model.Dict_Id_Output_Volume is
'排量/数据字典的排量';

comment on column lease_car_model.Maintain_Rule_Id is
'保养规则/数据字典的排量';

/*==============================================================*/
/* Table: lease_car_model_color                                 */
/*==============================================================*/
create table lease_car_model_color (
   Id                   INT8                 not null,
   Car_Model_Id         INT8                 null,
   Car_Color_Id         INT8                 null,
   Price         		DECIMAL(20,2)        null,
   Branch_Company_Id         INT8                 null,
   constraint PK_LEASE_CAR_MODEL_COLOR primary key (Id)
);

CREATE SEQUENCE lease_car_model_color_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_model_color alter column id set default nextval('lease_car_model_color_id_seq');

comment on table lease_car_model_color is
'车辆车型-车辆颜色-价格';

comment on column lease_car_model_color.Id is
'主键id';

comment on column lease_car_model_color.Car_Model_Id is
'车型主键id';

comment on column lease_car_model_color.Car_Color_Id is
'颜色主键id';

comment on column lease_car_model_color.Price is
'价格';

comment on column lease_car_model_color.Branch_Company_Id is
'分公司主键id';

/*==============================================================*/
/* Table: lease_car_series                                      */
/*==============================================================*/
create table lease_car_series (
   Id                   INT8                 not null,
   Number               varchar(100)         null,
   Brands_Id            INT8                 null,
   Name                 varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean               null,
   constraint PK_LEASE_CAR_SERIES primary key (Id)
);

CREATE SEQUENCE lease_car_series_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_series alter column id set default nextval('lease_car_series_id_seq');

comment on table lease_car_series is
'车辆系列';

comment on column lease_car_series.Id is
'主键id';

comment on column lease_car_series.Number is
'编号';

comment on column lease_car_series.Brands_Id is
'品牌主键id';

comment on column lease_car_series.Name is
'品牌名称';

comment on column lease_car_series.Create_Time is
'创建日期';

comment on column lease_car_series.Update_Time is
'修改日期';

comment on column lease_car_series.Create_By is
'创建人';

comment on column lease_car_series.Update_By is
'修改人';

comment on column lease_car_series.Sort is
'排序';

comment on column lease_car_series.Is_Enable is
'状态 0:禁用 1:启用';

/*==============================================================*/
/* Table: lease_car_supplier                                    */
/*==============================================================*/
create table lease_car_supplier (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Internal_Number      varchar(100)         null,
   Advantage            varchar(100)         null,
   Contacts             varchar(100)         null,
   Contact_Phone        varchar(100)         null,
   Recommender          varchar(100)         null,
   Recommender_Phone    varchar(100)         null,
   Cooperate_Time       timestamp            null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Address              varchar(100)         null,
   Is_Enable            boolean               null,
   Account_Name         varchar(100)         null,
   Bank_Name            varchar(100)         null,
   Account              varchar(100)         null,
   constraint PK_LEASE_CAR_SUPPLIER primary key (Id)
);

CREATE SEQUENCE lease_car_supplier_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_supplier alter column id set default nextval('lease_car_supplier_id_seq');

comment on table lease_car_supplier is
'车辆供应商';

comment on column lease_car_supplier.Id is
'主键id';

comment on column lease_car_supplier.Name is
'供应商名称';

comment on column lease_car_supplier.Internal_Number is
'内部编号';

comment on column lease_car_supplier.Advantage is
'供应商优势';

comment on column lease_car_supplier.Contacts is
'联系人';

comment on column lease_car_supplier.Contact_Phone is
'联系人电话';

comment on column lease_car_supplier.Recommender is
'推荐人';

comment on column lease_car_supplier.Recommender_Phone is
'推荐人电话';

comment on column lease_car_supplier.Cooperate_Time is
'开始合作日期';

comment on column lease_car_supplier.Create_Time is
'创建日期';

comment on column lease_car_supplier.Update_Time is
'修改日期';

comment on column lease_car_supplier.Create_By is
'创建人';

comment on column lease_car_supplier.Update_By is
'修改人';

comment on column lease_car_supplier.Sort is
'排序';

comment on column lease_car_supplier.Province_Id is
'省份ID';

comment on column lease_car_supplier.Province_Name is
'省份名称';

comment on column lease_car_supplier.City_Id is
'城市ID';

comment on column lease_car_supplier.City_Name is
'城市名称';

comment on column lease_car_supplier.Area_Id is
'区域ID';

comment on column lease_car_supplier.Area_Name is
'区域名称';

comment on column lease_car_supplier.Address is
'详细地址';

comment on column lease_car_supplier.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_car_supplier.Account_Name is
'户名';

comment on column lease_car_supplier.Bank_Name is
'开户行';

comment on column lease_car_supplier.Account is
'账号';

/*==============================================================*/
/* Table: lease_company_header                                  */
/*==============================================================*/
create table lease_company_header (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Address              varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean               null,
   Contacts             varchar(100)         null,
   Contact_Information  varchar(100)         null,
   Sort                 INT4                 null,
   constraint PK_LEASE_COMPANY_HEADER primary key (Id)
);

CREATE SEQUENCE lease_company_header_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_company_header alter column id set default nextval('lease_company_header_id_seq');

comment on table lease_company_header is
'合同方-公司抬头';

comment on column lease_company_header.Id is
'主键id';

comment on column lease_company_header.Name is
'保险公司名称';

comment on column lease_company_header.Province_Id is
'省份ID';

comment on column lease_company_header.Province_Name is
'省份名称';

comment on column lease_company_header.City_Id is
'城市ID';

comment on column lease_company_header.City_Name is
'城市名称';

comment on column lease_company_header.Area_Id is
'区域ID';

comment on column lease_company_header.Area_Name is
'区域名称';

comment on column lease_company_header.Address is
'详细地址';

comment on column lease_company_header.Create_Time is
'创建日期';

comment on column lease_company_header.Update_Time is
'修改日期';

comment on column lease_company_header.Create_By is
'创建人';

comment on column lease_company_header.Update_By is
'修改人';

comment on column lease_company_header.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_company_header.Contacts is
'联系人';

comment on column lease_company_header.Contact_Information is
'联系方式';

comment on column lease_company_header.Sort is
'排序';

/*==============================================================*/
/* Table: lease_company_receivables_info                        */
/*==============================================================*/
create table lease_company_receivables_info (
   Id                   INT8                 not null,
   Account_Name         varchar(100)         null,
   Bank_Id              INT8                 null,
   Account              varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean               null,
   constraint PK_LEASE_COMPANY_RECEIVABLES_I primary key (Id)
);

CREATE SEQUENCE lease_company_receivables_info_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_company_receivables_info alter column id set default nextval('lease_company_receivables_info_id_seq');

comment on table lease_company_receivables_info is
'公司收款信息';

comment on column lease_company_receivables_info.Id is
'主键id';

comment on column lease_company_receivables_info.Account_Name is
'户名';

comment on column lease_company_receivables_info.Bank_Id is
'开户行';

comment on column lease_company_receivables_info.Account is
'账号';

comment on column lease_company_receivables_info.Create_Time is
'创建日期';

comment on column lease_company_receivables_info.Update_Time is
'修改日期';

comment on column lease_company_receivables_info.Create_By is
'创建人';

comment on column lease_company_receivables_info.Update_By is
'修改人';

comment on column lease_company_receivables_info.Sort is
'排序';

comment on column lease_company_receivables_info.Is_Enable is
'状态 0:禁用 1:启用';

/*==============================================================*/
/* Table: lease_contract                                        */
/*==============================================================*/
create table lease_contract (
   Id                   INT8                 not null,
   Scheme_Order_Id      INT8                 null,
   Sale_Channel_Type    INT4                 null,
   Sale_Channel_Id      INT8                 null,
   Contract_Number_Year varchar(100)         null,
   Contract_Number      varchar(100)         null,
   Contract_Key         varchar(100)         null,
   Complete_Contract_Number      varchar(100)         null,
   Pay_Staging_Time     timestamp            null,
   Lease_Start_Time     timestamp            null,
   Lease_End_Time       timestamp            null,
   Staging_Contain_Monthly_Rent boolean               null,
   Company_Header_Id    INT8                 null,
   Account_Contact_Adress varchar(100)         null,
   Guarantee_Name       varchar(100)         null,
   Guarantee_Id_Card    varchar(100)         null,
   Guarantee_Contact_Address varchar(100)         null,
   Third_Party_Liability_Insurance DECIMAL(20,2)        null,
   Card_Check_Accept_Img varchar(100)         null,
   Guarantee_Contact    varchar(100)         null,
   Guarantee_Contact_Name varchar(100)         null,
   Guarantee_Contact_Phone varchar(100)         null,
   Guarantee_Zip_Code varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Status               INT4                 DEFAULT 3,
   Back_Status          INT4                 null,
   Branch_Company_Id    INT8                 null,
   Contract_Baseinfo_Id INT8                 null,
   Id_Card_Img          TEXT                 null,
   Car_Accept_Img       TEXT                 null,
   Contract_Type       INT4                 null,
   Vsersion_Number      INT4                 DEFAULT 0,
   Deal_Status varchar(100)         null,
   Parent_Id            INT8                 null,
   Source_Type          INT4                 null,
   Price_Difference     decimal(10,2)        null,
   Remarks              text                 null,
   constraint PK_LEASE_CONTRACT primary key (Id)
);

CREATE SEQUENCE lease_contract_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract alter column id set default nextval('lease_contract_id_seq');

comment on table lease_contract is
'融租合同';

comment on column lease_contract.Id is
'主键id';

comment on column lease_contract.Scheme_Order_Id is
'融租订单主键id';

comment on column lease_contract.Sale_Channel_Type is
'销售渠道 0: 直销; 1:经销商';

comment on column lease_contract.Sale_Channel_Id is
'销售渠道 为:经销商/经销商主键id';

comment on column lease_contract.Contract_Number_Year is
'合同编号-年';

comment on column lease_contract.Contract_Number is
'合同编号-号';

comment on column lease_contract.Complete_Contract_Number is
'完整合同编号';

comment on column lease_contract.Contract_Key is
'合同ID';

comment on column lease_contract.Pay_Staging_Time is
'收到首期日期';

comment on column lease_contract.Lease_Start_Time is
'租赁起始日期';

comment on column lease_contract.Lease_End_Time is
'租赁结束日期';

comment on column lease_contract.Staging_Contain_Monthly_Rent is
'首期包含第一个月租金';

comment on column lease_contract.Company_Header_Id is
'承租人紧急联系人手机';

comment on column lease_contract.Account_Contact_Adress is
'承租人紧急联系人手机';

comment on column lease_contract.Guarantee_Name is
'担保人姓名';

comment on column lease_contract.Guarantee_Id_Card is
'担保人身份证号';

comment on column lease_contract.Guarantee_Contact_Address is
'担保人联系地址';

comment on column lease_contract.Third_Party_Liability_Insurance is
'续保第三方责任险最低保额（元）';

comment on column lease_contract.Card_Check_Accept_Img is
'车辆交付验收确认书 图片';

comment on column lease_contract.Guarantee_Contact is
'担保人手机';

comment on column lease_contract.Guarantee_Contact_Name is
'担保人紧急联系人姓名';

comment on column lease_contract.Guarantee_Contact_Phone is
'担保人紧急联系人手机';

comment on column lease_contract.Guarantee_Zip_Code is
'担保人邮编';

comment on column lease_contract.Create_Time is
'创建日期';

comment on column lease_contract.Update_Time is
'修改日期';

comment on column lease_contract.Create_By is
'创建人';

comment on column lease_contract.Update_By is
'修改人';

comment on column lease_contract.Sort is
'排序';

comment on column lease_contract.Status is
'合同状态 0:还款中 1:挂靠中 2:已结束 2:未开始还款 4:提前还款';

comment on column lease_contract.Back_Status is
'备份 合同状态,合同修改会切换状态，备份给Status还原上次的状态';

comment on column lease_contract.Branch_Company_Id is
'分公司主键Id';

comment on column lease_contract.Contract_Baseinfo_Id is
'融租合同模板主键id';

comment on column lease_contract.Id_Card_Img is
'手持身份证照片';

comment on column lease_contract.Car_Accept_Img is
'交付车辆照片';

comment on column lease_contract.Complete_Contract_Number is
'完整合同编号';

comment on column lease_contract.Contract_Type is
'合同类型（1 标准 2 准合同）';

comment on column lease_contract.Vsersion_Number is
'数据版本号';

comment on column lease_contract.Deal_Status is
'合同处置方案状态 对应 lease_contract_status 表的Source和Status的组合';

comment on column lease_contract.Parent_Id is
'父合同主键Id';

comment on column lease_contract.Source_Type is
'合同来源类型 0 原始合同 1 改期数 2 续期 3 转租';

comment on column lease_contract.Price_Difference is
'新旧合同差价';

comment on column lease_contract.Remarks is
'备注';

/*==============================================================*/
/* Table: lease_contract_archive_location                       */
/*==============================================================*/
create table lease_contract_archive_location (
   Id                   INT8                 not null,
   Contract_Id          INT8                 null,
   Archive_Location_Id  INT8                 null,
   Archive_Number       VARCHAR(100)         null,
    Level                INT2                 null,
   constraint PK_LEASE_CONTRACT_ARCHIVE_LOCA primary key (Id)
);

CREATE SEQUENCE lease_contract_archive_location_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_archive_location alter column id set default nextval('lease_contract_archive_location_id_seq');

comment on table lease_contract_archive_location is
'融租合同-归档信息';

comment on column lease_contract_archive_location.Id is
'主键id';

comment on column lease_contract_archive_location.Contract_Id is
'融租合同主键Id';

comment on column lease_contract_archive_location.Archive_Location_Id is
'归档位置主键Id';

comment on column lease_contract_archive_location.Archive_Number is
'备注';

/*==============================================================*/
/* Table: lease_contract_baseinfo                               */
/*==============================================================*/
create table lease_contract_baseinfo (
   Id                   INT8                 not null,
   Name  varchar(100)         null,
   Contract_Party_Name  varchar(100)         null,
   Contract_Branch_Company varchar(100)         null,
   Contract_Party_Adress varchar(100)         null,
   Legal_Person			 varchar(100)         null,
   Important_Event_Price DECIMAL(20,2)        null,
   Check_Time			 varchar(100)         null,
   Down_Payment_Time_Limit varchar(100)         null,
   Loan_Deposit         DECIMAL(20,2)        null,
   Appoint_Area         varchar(100)         null,
   Rent_Overdue_Time_Limit varchar(100)         null,
   Car_Lessee_City      varchar(100)         null,
   City_Inside_Recovery_Cost DECIMAL(20,2)        null,
   City_Outside_Recovery_Cost DECIMAL(20,2)        null,
   Province_Inside_Recovery_Cost DECIMAL(20,2)        null,
   Day_Custodian_Cost   DECIMAL(20,2)        null,
   Continuity_Overdue   varchar(100)         null,
   Cumulative_Overdue   varchar(100)         null,
   Default_Interest     DECIMAL(20,2)        null,
   License_Monthly_Rent DECIMAL(20,2)        null,
   Contract_Party_Contact_Address text                null,
   Account_Name         varchar(100)         null,
   Bank_Id              INT8                 null,
   Branch_Bank          varchar(100)         null,
   Account              varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean              null,
   Remarks              text                 null,
   Branch_Company_Id            INT8                 null,
   constraint PK_LEASE_CONTRACT_BASEINFO primary key (Id)
);

CREATE SEQUENCE lease_contract_baseinfo_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_baseinfo alter column id set default nextval('lease_contract_baseinfo_id_seq');

comment on table lease_contract_baseinfo is
'融租合同模板';

comment on column lease_contract_baseinfo.Id is
'主键id';

comment on column lease_contract_baseinfo.Name is
'模板名称';

comment on column lease_contract_baseinfo.Contract_Party_Name is
'出租人';

comment on column lease_contract_baseinfo.Contract_Branch_Company is
'出租人分公司';

comment on column lease_contract_baseinfo.Contract_Party_Adress is
'出租人住所';

comment on column lease_contract_baseinfo.Legal_Person is
'法定代表人';

comment on column lease_contract_baseinfo.Important_Event_Price is
'重大事件金额';

comment on column lease_contract_baseinfo.Check_Time is
'检测定期';

comment on column lease_contract_baseinfo.Down_Payment_Time_Limit is
'交首款天数期限';

comment on column lease_contract_baseinfo.Loan_Deposit is
'原件出借押金';

comment on column lease_contract_baseinfo.Appoint_Area is
'约定区域';

comment on column lease_contract_baseinfo.Rent_Overdue_Time_Limit is
'租金逾期回收期限';

comment on column lease_contract_baseinfo.Car_Lessee_City is
'车辆承租城市';

comment on column lease_contract_baseinfo.City_Inside_Recovery_Cost is
'市内回收费';

comment on column lease_contract_baseinfo.City_Outside_Recovery_Cost is
'市外回收费';

comment on column lease_contract_baseinfo.Province_Inside_Recovery_Cost is
'省内回收费';

comment on column lease_contract_baseinfo.Day_Custodian_Cost is
'日保管费';

comment on column lease_contract_baseinfo.Continuity_Overdue is
'连续逾期';

comment on column lease_contract_baseinfo.Cumulative_Overdue is
'累计逾期';

comment on column lease_contract_baseinfo.Default_Interest is
'提前还款罚息金额';

comment on column lease_contract_baseinfo.License_Monthly_Rent is
'挂靠牌照月租';

comment on column lease_contract_baseinfo.Contract_Party_Contact_Address is
'出租人联系地址/json格式存放多个地址';

comment on column lease_contract_baseinfo.Account_Name is
'户名';

comment on column lease_contract_baseinfo.Bank_Id is
'开户行';

comment on column lease_contract_baseinfo.Branch_Bank is
'分行';

comment on column lease_contract_baseinfo.Account is
'账号';

comment on column lease_contract_baseinfo.Create_Time is
'创建日期';

comment on column lease_contract_baseinfo.Update_Time is
'修改日期';

comment on column lease_contract_baseinfo.Create_By is
'创建人';

comment on column lease_contract_baseinfo.Update_By is
'修改人';

comment on column lease_contract_baseinfo.Sort is
'排序';

comment on column lease_contract_baseinfo.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_contract_baseinfo.Is_Enable is
'所属分公司主键id';

/*==============================================================*/
/* Table: lease_contract_status                                 */
/*==============================================================*/
create table lease_contract_status (
   Id                   INT8                 not null,
   Status               INT8                 null,
   Source               INT4                 null,
   Create_Time          TIMESTAMP            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_CONTRACT_STATUS primary key (Id)
);

comment on table lease_contract_status is
'贷后合同管理的结束处置；贷后车辆管理的丢失、报废、结束处置 会操作出现各种状态，
Source 和 Status 是组合关系。
Source-Status:
0-0还款中,0-1挂靠中,0-2已结束,0-3未开始还款,0-4提前还款
1-1已回收待处置,1-2退回,1-3待改期数,1-4断供（待转租/待转卖）,1-5取消回收
2-1丢失中,2-2找回续租,2-3找回断供（待转租/待转卖）,2-4丢失结束,2-5取消丢失
3-1登记为报废中,3-2报废结束,3-3取消报废登记
4-1还款中,4-2待过户,4-3过户结束,4-4待挂靠结束,4-5提前还款结束,4-6其他到期结束';

CREATE SEQUENCE lease_contract_status_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_status alter column id set default nextval('lease_contract_status_id_seq');

comment on table lease_contract_status is
'融资合同状态流水';

comment on column lease_contract_status.Id is
'主键id';

comment on column lease_contract_status.Status is
'状态;0:订单生成;1:订单审批中;2:订单全部审批通过;3:已生成合同';

comment on column lease_contract_status.Status_Type is
'状态类型';

comment on column lease_contract_status.Create_Time is
'状态操作日期';

comment on column lease_contract_status.Update_Time is
'修改日期';

comment on column lease_contract_status.Create_By is
'创建人';

comment on column lease_contract_status.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_dealer                                          */
/*==============================================================*/
create table lease_dealer (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Guarantee_Amount     DECIMAL(20,2)        null,
   Commission     DECIMAL(20,2)        null,
   Car_Number           INT4                 null,
   Contacts             varchar(100)         null,
   Phone                varchar(100)         null,
   Recommender          varchar(100)         null,
   Recommender_Phone    varchar(100)         null,
   Remarks              TEXT                 null,
   Cooperate_Time       timestamp            null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Address              varchar(100)         null,
   Is_Enable            boolean               null,
   Parent_Id            INT8                 null,
   Grade                INT4                 null,
   Branch_Company_Id            INT8                 null,
   constraint PK_LEASE_DEALER primary key (Id)
);

CREATE SEQUENCE lease_dealer_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_dealer alter column id set default nextval('lease_dealer_id_seq');

comment on table lease_dealer is
'经销商';

comment on column lease_dealer.Id is
'主键id';

comment on column lease_dealer.Name is
'名称';

comment on column lease_dealer.Guarantee_Amount is
'保证金额';

comment on column lease_dealer.Commission is
'每单佣金';

comment on column lease_dealer.Car_Number is
'可提车数量';

comment on column lease_dealer.Contacts is
'联系人';

comment on column lease_dealer.Phone is
'电话';

comment on column lease_dealer.Recommender is
'推荐人';

comment on column lease_dealer.Recommender_Phone is
'推荐人电话';

comment on column lease_dealer.Remarks is
'备注';

comment on column lease_dealer.Cooperate_Time is
'开始合作日期';

comment on column lease_dealer.Create_Time is
'创建日期';

comment on column lease_dealer.Update_Time is
'修改日期';

comment on column lease_dealer.Create_By is
'创建人';

comment on column lease_dealer.Update_By is
'修改人';

comment on column lease_dealer.Sort is
'排序';

comment on column lease_dealer.Province_Id is
'省份ID';

comment on column lease_dealer.Province_Name is
'省份名称';

comment on column lease_dealer.City_Id is
'城市ID';

comment on column lease_dealer.City_Name is
'城市名称';

comment on column lease_dealer.Area_Id is
'区域ID';

comment on column lease_dealer.Area_Name is
'区域名称';

comment on column lease_dealer.Address is
'详细地址';

comment on column lease_dealer.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_dealer.Parent_Id is
'父级经销商主键id';

comment on column lease_dealer.Branch_Company_Id is
'所属分公司主键id';

/*==============================================================*/
/* Table: lease_dict                                            */
/*==============================================================*/
create table lease_dict (
   Id                   INT8                 not null,
   Parent_Id            varchar(100)         null,
   Label                varchar(100)         null,
   Value                varchar(100)         null,
   Type                 varchar(100)         null,
   Description          varchar(100)         null,
   Marked_graph         varchar(100)         null,
   Sort                 INT4                 null,
   Create_By            INT8                 null,
   Create_Time          timestamp            null,
   Update_By            INT8                 null,
   Update_Time          timestamp            null,
   Is_Enable            boolean               null,
   constraint PK_LEASE_DICT primary key (Id)
);

CREATE SEQUENCE lease_dict_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_dict alter column id set default nextval('lease_dict_id_seq');

comment on table lease_dict is
'数据字典';

comment on column lease_dict.Id is
'主键id';

comment on column lease_dict.Parent_Id is
'父级id';

comment on column lease_dict.Label is
'标签名';

comment on column lease_dict.Value is
'数据值';

comment on column lease_dict.Type is
'类型:OutputVolume:排量;FinancingMode:融资方式;FuelType:燃料类型;MortgageType:抵押类型;BuyCardCapitalType:购车资金类型;HousingType:住房类型;SchemeType:方案可选类型;StagingNumber:分期数;CarAccessory:随车物料;PayWay:支付方式;OverdueRate:滞纳金日息利率';

comment on column lease_dict.Description is
'描述';

comment on column lease_dict.Marked_graph is
'标识图';

comment on column lease_dict.Sort is
'排序';

comment on column lease_dict.Create_By is
'创建人';

comment on column lease_dict.Create_Time is
'创建时间';

comment on column lease_dict.Update_By is
'修改人';

comment on column lease_dict.Update_Time is
'修改时间';

comment on column lease_dict.Is_Enable is
'是否启用';

/*==============================================================*/
/* Table: lease_gps_supplier                                    */
/*==============================================================*/
create table lease_gps_supplier (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Contacts             varchar(100)         null,
   Contact_Phone        varchar(100)         null,
   Address              varchar(100)         null,
   Is_Enable            boolean               null,
   constraint PK_LEASE_GPS_SUPPLIER primary key (Id)
);

CREATE SEQUENCE lease_gps_supplier_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_gps_supplier alter column id set default nextval('lease_gps_supplier_id_seq');

comment on table lease_gps_supplier is
'GPS供应商';

comment on column lease_gps_supplier.Id is
'主键id';

comment on column lease_gps_supplier.Name is
'供应商名称';

comment on column lease_gps_supplier.Create_Time is
'创建日期';

comment on column lease_gps_supplier.Update_Time is
'修改日期';

comment on column lease_gps_supplier.Create_By is
'创建人';

comment on column lease_gps_supplier.Update_By is
'修改人';

comment on column lease_gps_supplier.Sort is
'排序';

comment on column lease_gps_supplier.Province_Id is
'省份ID';

comment on column lease_gps_supplier.Province_Name is
'省份名称';

comment on column lease_gps_supplier.City_Id is
'城市ID';

comment on column lease_gps_supplier.City_Name is
'城市名称';

comment on column lease_gps_supplier.Area_Id is
'区域ID';

comment on column lease_gps_supplier.Area_Name is
'区域名称';

comment on column lease_gps_supplier.Contacts is
'联系人';

comment on column lease_gps_supplier.Contact_Phone is
'联系方式';

comment on column lease_gps_supplier.Address is
'详细地址';

comment on column lease_gps_supplier.Is_Enable is
'状态 0:禁用 1:启用';

/*==============================================================*/
/* Table: lease_insurance_company                               */
/*==============================================================*/
create table lease_insurance_company (
   Id                   INT8                 not null,
   Number               varchar(100)         null,
   Name                 varchar(100)         null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Address              varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean               null,
   Contacts             varchar(100)         null,
   Contact_Information  varchar(100)         null,
   Sort                 INT4                 null,
   constraint PK_LEASE_INSURANCE_COMPANY primary key (Id)
);

CREATE SEQUENCE lease_insurance_company_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_insurance_company alter column id set default nextval('lease_insurance_company_id_seq');

comment on table lease_insurance_company is
'保险公司';

comment on column lease_insurance_company.Id is
'主键id';

comment on column lease_insurance_company.Number is
'编号';

comment on column lease_insurance_company.Name is
'保险公司名称';

comment on column lease_insurance_company.Province_Id is
'省份ID';

comment on column lease_insurance_company.Province_Name is
'省份名称';

comment on column lease_insurance_company.City_Id is
'城市ID';

comment on column lease_insurance_company.City_Name is
'城市名称';

comment on column lease_insurance_company.Area_Id is
'区域ID';

comment on column lease_insurance_company.Area_Name is
'区域名称';

comment on column lease_insurance_company.Address is
'详细地址';

comment on column lease_insurance_company.Create_Time is
'创建日期';

comment on column lease_insurance_company.Update_Time is
'修改日期';

comment on column lease_insurance_company.Create_By is
'创建人';

comment on column lease_insurance_company.Update_By is
'修改人';

comment on column lease_insurance_company.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_insurance_company.Contacts is
'联系人';

comment on column lease_insurance_company.Contact_Information is
'联系方式';

comment on column lease_insurance_company.Sort is
'排序';

/*==============================================================*/
/* Table: lease_insurance_type                                  */
/*==============================================================*/
create table lease_insurance_type (
   Id                   INT8                 not null,
   Number               varchar(100)         null,
   Insurance_Company_Id INT8                 null,
   Name                 varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean               null,
   Default_Insurance_Type  INT2               null,
   Ticket_Amount           INT2               null,
   Remarks            varchar(100)            null,
   constraint PK_LEASE_INSURANCE_TYPE primary key (Id)
);

CREATE SEQUENCE lease_insurance_type_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_insurance_type alter column id set default nextval('lease_insurance_type_id_seq');

comment on table lease_insurance_type is
'险种';

comment on column lease_insurance_type.Id is
'主键id';

comment on column lease_insurance_type.Number is
'编号';

comment on column lease_insurance_type.Insurance_Company_Id is
'保险公司主键id';

comment on column lease_insurance_type.Name is
'险种名称';

comment on column lease_insurance_type.Create_Time is
'创建日期';

comment on column lease_insurance_type.Update_Time is
'修改日期';

comment on column lease_insurance_type.Create_By is
'创建人';

comment on column lease_insurance_type.Update_By is
'修改人';

comment on column lease_insurance_type.Sort is
'排序';

comment on column lease_insurance_type.Is_Enable is
'状态 0:禁用 1:启用';

/*==============================================================*/
/* Table: lease_invoice_header                                  */
/*==============================================================*/
create table lease_invoice_header (
   Id                   INT8                 not null,
   Account_Name         varchar(100)         null,
   Bank_Id              INT8                 null,
   Account              varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean               null,
   Personal_id          INT8                 null,
   constraint PK_LEASE_INVOICE_HEADER primary key (Id)
);

CREATE SEQUENCE lease_invoice_header_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_invoice_header alter column id set default nextval('lease_invoice_header_id_seq');

comment on table lease_invoice_header is
'发票抬头信息';

comment on column lease_invoice_header.Id is
'主键id';

comment on column lease_invoice_header.Account_Name is
'户名';

comment on column lease_invoice_header.Bank_Id is
'开户行';

comment on column lease_invoice_header.Account is
'账号';

comment on column lease_invoice_header.Create_Time is
'创建日期';

comment on column lease_invoice_header.Update_Time is
'修改日期';

comment on column lease_invoice_header.Create_By is
'创建人';

comment on column lease_invoice_header.Update_By is
'修改人';

comment on column lease_invoice_header.Sort is
'排序';

comment on column lease_invoice_header.Is_Enable is
'状态 0:禁用 1:启用';

/*==============================================================*/
/* Table: lease_maintenance_partner                             */
/*==============================================================*/
create table lease_maintenance_partner (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Contacts             varchar(100)         null,
   Phone                varchar(100)         null,
   Remarks              TEXT                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Address              varchar(100)         null,
   Is_Enable            boolean               null,
   Branch_Company_Id              INT8                 null,
   constraint PK_LEASE_MAINTENANCE_PARTNER primary key (Id)
);

CREATE SEQUENCE lease_maintenance_partner_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_maintenance_partner alter column id set default nextval('lease_maintenance_partner_id_seq');

comment on table lease_maintenance_partner is
'保养维护合作方';

comment on column lease_maintenance_partner.Id is
'主键id';

comment on column lease_maintenance_partner.Name is
'名称';

comment on column lease_maintenance_partner.Contacts is
'联系人';

comment on column lease_maintenance_partner.Phone is
'电话';

comment on column lease_maintenance_partner.Remarks is
'备注';

comment on column lease_maintenance_partner.Create_Time is
'创建日期';

comment on column lease_maintenance_partner.Update_Time is
'修改日期';

comment on column lease_maintenance_partner.Create_By is
'创建人';

comment on column lease_maintenance_partner.Update_By is
'修改人';

comment on column lease_maintenance_partner.Sort is
'排序';

comment on column lease_maintenance_partner.Province_Id is
'省份ID';

comment on column lease_maintenance_partner.Province_Name is
'省份名称';

comment on column lease_maintenance_partner.City_Id is
'城市ID';

comment on column lease_maintenance_partner.City_Name is
'城市名称';

comment on column lease_maintenance_partner.Area_Id is
'区域ID';

comment on column lease_maintenance_partner.Area_Name is
'区域名称';

comment on column lease_maintenance_partner.Address is
'详细地址';

comment on column lease_maintenance_partner.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_maintenance_partner.Branch_Company_Id is
'所属分公司主键id';

/*==============================================================*/
/* Table: lease_package                                         */
/*==============================================================*/
create table lease_package (
   Id                   INT8                 not null,
   Down_Payment         DECIMAL(20,2)        null,
   Balance_Payment      DECIMAL(20,2)        null,
   Staging_Number_Id       INT8                 null,
   Monthly_Rent         DECIMAL(20,2)        null,
   Client_Manager_Remarks VARCHAR(100)         null,
   Type                 INT4                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean               null,
   Sort                 INT4                 null,
   constraint PK_LEASE_PACKAGE primary key (Id)
);

CREATE SEQUENCE lease_package_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_package alter column id set default nextval('lease_package_id_seq');

comment on table lease_package is
'套餐';

comment on column lease_package.Id is
'主键id';

comment on column lease_package.Down_Payment is
'首期金额（元）';

comment on column lease_package.Balance_Payment is
'尾款（元）';

comment on column lease_package.Staging_Number_Id is
'分期数';

comment on column lease_package.Monthly_Rent is
'月租';

comment on column lease_package.Client_Manager_Remarks is
'客户经理/渠道备注';

comment on column lease_package.Type is
'类型 0:默认套餐;1:定制套餐';

comment on column lease_package.Create_Time is
'创建日期';

comment on column lease_package.Update_Time is
'修改日期';

comment on column lease_package.Create_By is
'创建人';

comment on column lease_package.Update_By is
'修改人';

comment on column lease_package.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_package.Sort is
'排序';

/*==============================================================*/
/* Table: lease_scheme                                          */
/*==============================================================*/
create table lease_scheme (
   Id                   INT8                 not null,
   Brands_Id            INT8                 null,
   Series_Id            INT8                 null,
   Model_Id             INT8                 null,
   Color_Id             INT8                 null,
   Scheme_Name          VARCHAR(100)         null,
   Branch_Company_Id    INT8                 null,
   Annual_Interest     DECIMAL(20,2)        null,
   Total_Amount	       DECIMAL(20,2)        null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean               null,
   Sort                 INT4                 null,
  Late_Interest_Rate    DECIMAL(20,2)         null,
   constraint PK_LEASE_SCHEME primary key (Id)
);

CREATE SEQUENCE lease_scheme_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme alter column id set default nextval('lease_scheme_id_seq');

comment on table lease_scheme is
'融租方案';

comment on column lease_scheme.Id is
'主键id';

comment on column lease_scheme.Brands_Id is
'品牌主键Id';

comment on column lease_scheme.Series_Id is
'系列主键Id';

comment on column lease_scheme.Model_Id is
'车型主键Id';

comment on column lease_scheme.Color_Id is
'颜色主键Id';

comment on column lease_scheme.Scheme_Name is
'修改人';

comment on column lease_scheme.Total_Amount is
'全包价（元） 包含全部费用价格：裸车成本，手续费、服务费、保险费、上牌费、购置税、车船税';

comment on column lease_scheme.Create_Time is
'创建日期';

comment on column lease_scheme.Update_Time is
'修改日期';

comment on column lease_scheme.Create_By is
'创建人';

comment on column lease_scheme.Update_By is
'修改人';

comment on column lease_scheme.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_scheme.Sort is
'排序';

/*==============================================================*/
/* Table: lease_scheme_car                                      */
/*==============================================================*/
create table lease_scheme_car (
   Id                   INT8                 not null,
   Scheme_Id            INT8                 null,
   Car_Id               INT8                 null,
   constraint PK_LEASE_SCHEME_CAR primary key (Id)
);

CREATE SEQUENCE lease_scheme_car_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_car alter column id set default nextval('lease_scheme_car_id_seq');

comment on table lease_scheme_car is
'融租方案-车辆';

comment on column lease_scheme_car.Id is
'主键id';

comment on column lease_scheme_car.Scheme_Id is
'融租方案主键Id';

comment on column lease_scheme_car.Car_Id is
'车辆主键Id';

/*==============================================================*/
/* Table: lease_scheme_order                                    */
/*==============================================================*/
create table lease_scheme_order (
   Id                   INT8                 not null,
   Sn                   VARCHAR(100)         null,
   Scheme_Id            INT8                 null,
   Card_Id              INT8                 null,
   Car_Price            DECIMAL(20,2)        null,
   Totle_Car_Price      DECIMAL(20,2)        null,
   Lease_Price          DECIMAL(20,2)        null,
   Monthly_Rent          DECIMAL(20,2)        null,
   Contract_Party_Id    INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Status               INT4                 null,
   Comprehensive_Quote  DECIMAL(20,2)        null,
   Pay_Date             INT4                 null,
   Commission           DECIMAL(20,2)        null, 
   Receive_Margin       DECIMAL(20,2)        null,
   Period_Count       	INT4         		 null,
   Parent_Id            INT8                 null,
   constraint PK_LEASE_SCHEME_ORDER primary key (Id)
);

CREATE SEQUENCE lease_scheme_order_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_order alter column id set default nextval('lease_scheme_order_id_seq');

comment on table lease_scheme_order is
'融租方案申请订单';

comment on column lease_scheme_order.Id is
'主键id';

comment on column lease_scheme_order.Sn is
'订单号';

comment on column lease_scheme_order.Scheme_Id is
'融租方案主键Id';

comment on column lease_scheme_order.Car_Price is
'汽车价格';

comment on column lease_scheme_order.Totle_Car_Price is
'全包价（元）';

comment on column lease_scheme_order.Lease_Price is
'租金总额';

comment on column lease_scheme_order.Monthly_Rent is
'月租';

comment on column lease_scheme_order.Card_Id is
'车辆主键Id';

comment on column lease_scheme_order.Contract_Party_Id is
'出租人/合同方主键id';

comment on column lease_scheme_order.Create_Time is
'创建日期';

comment on column lease_scheme_order.Update_Time is
'修改日期';

comment on column lease_scheme_order.Create_By is
'创建人';

comment on column lease_scheme_order.Update_By is
'修改人';

comment on column lease_scheme_order.Sort is
'排序';

comment on column lease_scheme_order.Status is
'订单状态';

comment on column lease_scheme_order.Comprehensive_Quote is
'扣款日';

comment on column lease_scheme_order.Pay_Date is
'扣款日';

comment on column lease_scheme_order.Commission is
'渠道佣金';

comment on column lease_scheme_order.Receive_Margin is
'实收保证金';

comment on column lease_scheme_order.Period_Count is
'分期数';

comment on column lease_scheme_order.Parent_Id is
'父订单主键Id';

/*==============================================================*/
/* Table: lease_scheme_order_status                             */
/*==============================================================*/
create table lease_scheme_order_status (
   Id                   INT8                 not null,
   Status               INT8                 null,
   Status_Type          INT8                 null,
   Create_Time          TIMESTAMP            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_SCHEME_ORDER_STATUS primary key (Id)
);

CREATE SEQUENCE lease_scheme_order_status_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_order_status alter column id set default nextval('lease_scheme_order_status_id_seq');

comment on table lease_scheme_order_status is
'融资方案申请订单状态流水';

comment on column lease_scheme_order_status.Id is
'主键id';

comment on column lease_scheme_order_status.Status is
'状态;0:订单生成;1:订单审批中;2:订单全部审批通过;3:已生成合同';

comment on column lease_scheme_order_status.Status_Type is
'状态类型';

comment on column lease_scheme_order_status.Create_Time is
'状态操作日期';

comment on column lease_scheme_order_status.Update_Time is
'修改日期';

comment on column lease_scheme_order_status.Create_By is
'创建人';

comment on column lease_scheme_order_status.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_scheme_package                                  */
/*==============================================================*/
create table lease_scheme_package (
   Id                   INT8                 not null,
   Scheme_Id            INT8                 null,
   Package_Id           INT8                 null,
   constraint PK_LEASE_SCHEME_PACKAGE primary key (Id)
);

CREATE SEQUENCE lease_scheme_package_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_package alter column id set default nextval('lease_scheme_package_id_seq');

comment on table lease_scheme_package is
'融租方案-套餐';

comment on column lease_scheme_package.Id is
'主键id';

comment on column lease_scheme_package.Scheme_Id is
'融租方案主键Id';

comment on column lease_scheme_package.Package_Id is
'套餐主键Id';

/*==============================================================*/
/* Table: lease_storehouse                                      */
/*==============================================================*/
create table lease_storehouse (
   Id                   INT8                 not null,
   Number               varchar(100)         null,
   Company_Id           INT8         null,
   Max_Card_Sum         varchar(100)         null,
   Name                 varchar(100)         null,
   Contacts             varchar(100)         null,
   Contact_Phone        varchar(100)         null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Address              varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean               null,
   Parent_Id            INT8                 null,
   Sort                 INT4                 null,
   Belong_Type          INT4                 null,
   Belong_Id            INT8                 null,
   constraint PK_LEASE_STOREHOUSE primary key (Id)
);

CREATE SEQUENCE lease_storehouse_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_storehouse alter column id set default nextval('lease_storehouse_id_seq');

comment on table lease_storehouse is
'仓库';

comment on column lease_storehouse.Id is
'主键id';

comment on column lease_storehouse.Number is
'编号';

comment on column lease_storehouse.Company_Id is
'分公司主键id';

comment on column lease_storehouse.Max_Card_Sum is
'最大停车量';

comment on column lease_storehouse.Name is
'仓库名称';

comment on column lease_storehouse.Contacts is
'联系人';

comment on column lease_storehouse.Contact_Phone is
'联系人手机';

comment on column lease_storehouse.Province_Id is
'省份ID';

comment on column lease_storehouse.Province_Name is
'省份名称';

comment on column lease_storehouse.City_Id is
'城市ID';

comment on column lease_storehouse.City_Name is
'城市名称';

comment on column lease_storehouse.Area_Id is
'区域ID';

comment on column lease_storehouse.Area_Name is
'区域名称';

comment on column lease_storehouse.Address is
'详细地址';

comment on column lease_storehouse.Create_Time is
'创建日期';

comment on column lease_storehouse.Update_Time is
'修改日期';

comment on column lease_storehouse.Create_By is
'创建人';

comment on column lease_storehouse.Update_By is
'修改人';

comment on column lease_storehouse.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_storehouse.Parent_Id is
'父级ID';

comment on column lease_storehouse.Sort is
'排序';

comment on column lease_storehouse.Belong_Type is
'所属 0:公司仓库;1:经销商/二网';

comment on column lease_storehouse.Belong_Id is
'所属 主键id';


/*==============================================================*/
/* Table: lease_rule                                            */
/*==============================================================*/
create table lease_rule (
   Id                   INT8                 not null,
   Rule_Name            VARCHAR(100)         null,
   Rule_Type            VARCHAR(100)         null,
   Rule_Value           DECIMAL(20,2)        null,
   Rule_Value_1         DECIMAL(20,2)        null,
   Remarks              text                 null,
   Start_Time           timestamp            null,
   End_Time             timestamp            null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean               null,
   constraint PK_LEASE_RULE primary key (Id)
);

CREATE SEQUENCE lease_rule_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_rule alter column id set default nextval('lease_rule_id_seq');

comment on table lease_rule is
'规则表';

comment on column lease_rule.Id is
'主键id';

comment on column lease_rule.Rule_Name is
'规则名称';

comment on column lease_rule.Rule_Type is
'规则类型 0:年利息; 1:首付最低';

comment on column lease_rule.Rule_Value is
'规则值';

comment on column lease_rule.Rule_Value_1 is
'规则值1';

comment on column lease_rule.Remarks is
'备注';

comment on column lease_rule.Start_Time is
'规则开始日期';

comment on column lease_rule.End_Time is
'规则结束日期';

comment on column lease_rule.Create_Time is
'创建日期';

comment on column lease_rule.Update_Time is
'修改日期';

comment on column lease_rule.Create_By is
'创建人';

comment on column lease_rule.Update_By is
'修改人';

comment on column lease_rule.Sort is
'排序';

comment on column lease_rule.Is_Enable is
'状态 0:禁用 1:启用';


/*==============================================================*/
/* Table: lease_area                                            */
/*==============================================================*/
create table lease_area (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Parent_Id            INT8                 null,
   Short_Name           varchar(100)         null,
   Level                INT4                 null,
   Merger_Name          varchar(100)         null,
   Code                 varchar(100)         null,
   Zip_Code             varchar(100)         null,
   Pin_Yin              varchar(100)         null,
   Short_PY             varchar(100)         null,
   Model                varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean              null,
   Is_Hot               boolean              null,
   constraint PK_LEASE_AREA primary key (Id)
);

CREATE SEQUENCE lease_area_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_area alter column Id set default nextval('lease_area_id_seq');

comment on table lease_area is
'地区';

comment on column lease_area.Id is
'主键id';

comment on column lease_area.Code is
'区号';

comment on column lease_area.Zip_Code is
'邮编';

comment on column lease_area.Pin_Yin is
'简称拼音';

comment on column lease_area.Short_PY is
'简称拼音';

comment on column lease_area.Model is
'模块，指定位置可用';

comment on column lease_area.Create_Time is
'创建日期';

comment on column lease_area.Update_Time is
'修改日期';

comment on column lease_area.Create_By is
'创建人';

comment on column lease_area.Update_By is
'修改人';

comment on column lease_area.Sort is
'排序';

comment on column lease_area.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_area.Is_Hot is
'是否热门 0 否 1 是';


/*==============================================================*/
/* Table: lease_purchase_payment_history                        */
/*==============================================================*/
create table lease_purchase_payment_history (
   Id                   INT8                 not null,
   Purchase_Contract_Id INT8                 null,
   Buy_Card_Capital_Type_Id INT8                 null,
   Buy_Card_Capital_Type_Name varchar(100)         null,
   Car_Buy_Financinger_Id INT8                 null,
   Effective_Time       TIMESTAMP            null,
   Contract_Number      varchar(100)         null,
   Down_Payment         DECIMAL(20,2)        null,
   Hire_Purchase        DECIMAL(20,2)        null,
   Contract_Car_Price   DECIMAL(20,2)        null,
   Lease_Price          DECIMAL(20,2)        null,
   Staging_Number_Id    INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean              null,
   Sort                 INT4                 null,
   constraint PK_LEASE_PURCHASE_PAYMENT_HIST primary key (Id)
);

CREATE SEQUENCE lease_purchase_payment_history_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_purchase_payment_history alter column id set default nextval('lease_purchase_payment_history_id_seq');

comment on table lease_purchase_payment_history is
'采购融租还款记录';

comment on column lease_purchase_payment_history.Id is
'主键id';

comment on column lease_purchase_payment_history.Purchase_Contract_Id is
'采购合同主键Id';

comment on column lease_purchase_payment_history.Buy_Card_Capital_Type_Id is
'购车资金类型/资金来源/字典表的抵押类型主键id';

comment on column lease_purchase_payment_history.Buy_Card_Capital_Type_Name is
'购车资金类型/资金来源/字典表的抵押类型名称';

comment on column lease_purchase_payment_history.Car_Buy_Financinger_Id is
'融资方主键id';

comment on column lease_purchase_payment_history.Effective_Time is
'生效日期';

comment on column lease_purchase_payment_history.Contract_Number is
'合同编号';

comment on column lease_purchase_payment_history.Down_Payment is
'首付款';

comment on column lease_purchase_payment_history.Hire_Purchase is
'留购价款';

comment on column lease_purchase_payment_history.Contract_Car_Price is
'合同车价';

comment on column lease_purchase_payment_history.Lease_Price is
'租金';

comment on column lease_purchase_payment_history.Staging_Number_Id is
'分期数/字典表的分期数主键id';

comment on column lease_purchase_payment_history.Create_Time is
'创建日期';

comment on column lease_purchase_payment_history.Update_Time is
'修改日期';

comment on column lease_purchase_payment_history.Create_By is
'创建人';

comment on column lease_purchase_payment_history.Update_By is
'修改人';

comment on column lease_purchase_payment_history.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_purchase_payment_history.Sort is
'排序';


/*==============================================================*/
/* Table: lease_scheme_order_account                            */
/*==============================================================*/
create table lease_scheme_order_account (
   Id                   INT8                 not null,
   Scheme_Order_Id      INT8                 null,
   Account_Id           INT8                 null,
   Account_Name         varchar(100)         null,
   Account_Contact      varchar(100)         null,
   Is_Default_Pay       int2              null,
   constraint PK_LEASE_SCHEME_ORDER_ACCOUNT primary key (Id)
);

CREATE SEQUENCE lease_scheme_order_account_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_order_account alter column id set default nextval('lease_scheme_order_account_id_seq');

comment on table lease_scheme_order_account is
'融租方案申请订单-承租人  ，一个申请单会有多个申请人';

comment on column lease_scheme_order_account.Id is
'主键id';

comment on column lease_scheme_order_account.Scheme_Order_Id is
'融租方案申请订单主键id';

comment on column lease_scheme_order_account.Account_Id is
'注册用户/下单人/承租人主键id';

comment on column lease_scheme_order_account.Account_Name is
'注册用户/下单人/承租人姓名';

comment on column lease_scheme_order_account.Account_Contact is
'注册用户/下单人/承租人联系方式';

comment on column lease_scheme_order_account.Is_Default_Pay is
'是否默认扣款 1是 0否';


/*==============================================================*/
/* Table: lease_purchase_contract                               */
/*==============================================================*/
create table lease_purchase_contract (
   Id                   INT8                 not null,
   Buy_Card_Capital_Type_Id INT8                 null,
   Buy_Card_Capital_Type_Name varchar(100)         null,
   Contract_Number      varchar(100)         null,
   Car_Buy_Financinger_Id INT8                 null,
   Company_Header_Id    INT8                 null,
   Effective_Time       TIMESTAMP            null,
   Car_Supplier_Id      INT8                 null,
   Brands_Id            INT8                 null,
   Series_Id            INT8                 null,
   Model_Id             INT8                 null,
   Totle_Amount         INT4                 null,
   Unit_Price           DECIMAL(20,2)        null,
   Subscription_Price   DECIMAL(20,2)        null,
   Totle_Price          DECIMAL(20,2)        null,
   Remarks              text                 null,
   Scanner_Img          VARCHAR(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean              null,
   Sort                 INT4                 null,
   constraint PK_LEASE_PURCHASE_CONTRACT primary key (Id)
);

CREATE SEQUENCE lease_purchase_contract_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_purchase_contract alter column id set default nextval('lease_purchase_contract_id_seq');

comment on table lease_purchase_contract is
'采购合同';

comment on column lease_purchase_contract.Id is
'主键id';

comment on column lease_purchase_contract.Contract_Number is
'合同编号-HC融租字';

comment on column lease_purchase_contract.Car_Buy_Financinger_Id is
'出租人/合同方主键id';

comment on column lease_purchase_contract.Company_Header_Id is
'承租人紧急联系人手机';

comment on column lease_purchase_contract.Car_Supplier_Id is
'品牌主键Id';

comment on column lease_purchase_contract.Brands_Id is
'品牌主键Id';

comment on column lease_purchase_contract.Series_Id is
'系列主键Id';

comment on column lease_purchase_contract.Model_Id is
'车型主键Id';

comment on column lease_purchase_contract.Totle_Amount is
'车型主键Id';

comment on column lease_purchase_contract.Unit_Price is
'车型主键Id';

comment on column lease_purchase_contract.Subscription_Price is
'车型主键Id';

comment on column lease_purchase_contract.Totle_Price is
'车型主键Id';

comment on column lease_purchase_contract.Remarks is
'车型主键Id';

comment on column lease_purchase_contract.Scanner_Img is
'车型主键Id';

comment on column lease_purchase_contract.Create_Time is
'创建日期';

comment on column lease_purchase_contract.Update_Time is
'修改日期';

comment on column lease_purchase_contract.Create_By is
'创建人';

comment on column lease_purchase_contract.Update_By is
'修改人';

comment on column lease_purchase_contract.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_purchase_contract.Sort is
'排序';



/*==============================================================*/
/* Table: lease_allinpay_batch                                  */
/*==============================================================*/
create table lease_allinpay_batch (
   Id                   INT8                 not null,
   Batch_Number         VARCHAR(100)         null,
   Receivable_Price     DECIMAL(20,2)        null,
   Receipts_Price       DECIMAL(20,2)        null,
   Fail_Price       	DECIMAL(20,2)        null,
   Number               INT4                 null,
   Success_Number       INT4                 null,
   Fail_Number          INT4                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_ALLINPAY_BATCH primary key (Id)
);

CREATE SEQUENCE lease_allinpay_batch_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_batch alter column id set default nextval('lease_allinpay_batch_id_seq');

comment on table lease_allinpay_batch is
'通联批量代收批次统计';

comment on column lease_allinpay_batch.Id is
'主键id';

comment on column lease_allinpay_batch.Batch_Number is
'批次号/批扣流水';

comment on column lease_allinpay_batch.Receivable_Price is
'应扣总额';

comment on column lease_allinpay_batch.Receipts_Price is
'实扣总额/成功总额';

comment on column lease_allinpay_batch.Fail_Price is
'失败总额';

comment on column lease_allinpay_batch.Number is
'总数量';

comment on column lease_allinpay_batch.Success_Number is
'成功数量';

comment on column lease_allinpay_batch.Fail_Number is
'失败数量';

comment on column lease_allinpay_batch.Create_Time is
'创建日期/操作日期';

comment on column lease_allinpay_batch.Update_Time is
'修改日期/操作日期';

comment on column lease_allinpay_batch.Create_By is
'创建人/操作人';

comment on column lease_allinpay_batch.Update_By is
'修改人/操作人';



/*==============================================================*/
/* Table: lease_allinpay_log                                    */
/*==============================================================*/
create table lease_allinpay_log (
   Id                   INT8                 not null,
   Repayment_Id         INT8                 null,
   Repayment_Status_Id  INT8                 null,
   Contract_Id  		INT8                 null,
   Account_Id  			INT8                 null,
   Totle_Price          DECIMAL(20,2)        null,
   Real_Price           DECIMAL(20,2)        null,
   Pay_Way              INT4                 null,
   Pay_Type             INT4                 null,
   Overdue              BOOL                 null,
   Overdue_Day          INT4                 null,
   Real_Overdue_Day     INT4                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Status               INT4              null,
   Ret_Code             VARCHAR(100)         null,
   Err_Msg              VARCHAR(500)         null,
   Back_Time            timestamp            null,
   Single_Or_Batch      INT4                 null,
   Allinpay_Batch_Id    INT8                 null,
   Remarks    			text                 null,
   Req_Sn             	VARCHAR(100)         null,
   Sn             	  	VARCHAR(100)         null,
   Update_Type          INT4              null,
   Controller_Source          INT4              null,
   constraint PK_LEASE_ALLINPAY_LOG primary key (Id)
);

CREATE SEQUENCE lease_allinpay_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_log alter column id set default nextval('lease_allinpay_log_id_seq');

comment on table lease_allinpay_log is
'通联代收流水';

comment on column lease_allinpay_log.Id is
'主键id';

comment on column lease_allinpay_log.Repayment_Id is
'款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id';

comment on column lease_allinpay_log.Repayment_Status_Id is
'支付状态汇总管理主键id';

comment on column lease_allinpay_log.Contract_Id is
'融租合同主键id';

comment on column lease_allinpay_log.Account_Id is
'承租人主键id';

comment on column lease_allinpay_log.Totle_Price is
'合计金额';

comment on column lease_allinpay_log.Real_Price is
'实际金额';

comment on column lease_allinpay_log.Pay_Way is
'支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他';

comment on column lease_allinpay_log.Pay_Type is
'款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/还款到最后一期的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款';

comment on column lease_allinpay_log.Overdue is
'是否逾期';

comment on column lease_allinpay_log.Overdue_Day is
'逾期天数';

comment on column lease_allinpay_log.Real_Overdue_Day is
'实际逾期天数';

comment on column lease_allinpay_log.Create_Time is
'创建日期/操作日期';

comment on column lease_allinpay_log.Update_Time is
'修改日期/操作日期';

comment on column lease_allinpay_log.Create_By is
'创建人/操作人';

comment on column lease_allinpay_log.Update_By is
'修改人/操作人';

comment on column lease_allinpay_log.Status is
'通联支付状态/0:已提交;1:成功;2:失败';

comment on column lease_allinpay_log.Ret_Code is
'通联支付反馈状态码';

comment on column lease_allinpay_log.Err_Msg is
'通联支付反馈状态描述';

comment on column lease_allinpay_log.Back_Time is
'通联支付反馈状态日期';

comment on column lease_allinpay_log.Single_Or_Batch is
'单笔或批量/0:单笔; 1:批量';

comment on column lease_allinpay_log.Allinpay_Batch_Id is
'所属批量代收批次主键id';

comment on column lease_allinpay_log.Remarks is
'备注';

comment on column lease_allinpay_log.Req_Sn is
'通联返回的 文件名/可用于通联流水查询';

comment on column lease_allinpay_log.Sn is
'记录序号 通联批量代收 每条数据的 序号';

comment on column lease_allinpay_log.Update_Type is
'0:合同未作修改 ; 1:合同已作修改';

comment on column lease_allinpay_log.Controller_Source is
'操作来源 0:单笔; 1:批量;2:手动批扣';



/*==============================================================*/
/* Table: lease_overdue_log                                     */
/*==============================================================*/
create table lease_overdue_log (
   Id                   INT8                 not null,
   Type                 INT4                 null,
   Contract_Id          INT8                 null,
   Account_Id           INT8                 null,
   Repayment_Id         INT8                 null,
   Price                DECIMAL(20,2)        null,
   Overdue_Day          INT4                 null,
   Repayment_Time       timestamp            null,
   Now_Time             timestamp            null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Payment_Result       INT4              null,
   constraint PK_LEASE_OVERDUE_LOG primary key (Id)
);

CREATE SEQUENCE lease_overdue_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_overdue_log alter column id set default nextval('lease_overdue_log_id_seq');

comment on table lease_overdue_log is
'逾期记录';

comment on column lease_overdue_log.Id is
'主键id';

comment on column lease_overdue_log.Type is
'款项类型 0:月租;1:挂靠';

comment on column lease_overdue_log.Contract_Id is
'融租合同ID';

comment on column lease_overdue_log.Account_Id is
'承租人ID';

comment on column lease_overdue_log.Repayment_Id is
'融租合同-还款计划明细主键id';

comment on column lease_overdue_log.Price is
'金额';

comment on column lease_overdue_log.Overdue_Day is
'逾期时间/单位天';

comment on column lease_overdue_log.Repayment_Time is
'还款日期/即逾期起始时间';

comment on column lease_overdue_log.Now_Time is
'当前日期/即逾期结束时间';

comment on column lease_overdue_log.Create_Time is
'创建日期';

comment on column lease_overdue_log.Update_Time is
'修改日期';

COMMENT ON COLUMN lease_overdue_log.payment_result IS 
'扣款结果  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败';


/*==============================================================*/
/* Table: lease_allinpay_status_log                             */
/*==============================================================*/
create table lease_allinpay_status_log (
   Id                   INT8                 not null,
   Allinpay_Log_Id      INT8                 null,
   Create_Time          timestamp            null,
   Create_By            INT8                 null,
   Ret_Code             VARCHAR(100)         null,
   Err_Msg              VARCHAR(500)         null,
   Back_Time            timestamp            null,
   Type            		INT4                 null,
   Payment_Result       INT4                 null,
   Payment_Result_Msg   text         		 null,
   constraint PK_LEASE_ALLINPAY_STATUS_LOG primary key (Id)
);

CREATE SEQUENCE lease_allinpay_status_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_status_log alter column id set default nextval('lease_allinpay_status_log_id_seq');

comment on table lease_allinpay_status_log is
'代收状态流水';

comment on column lease_allinpay_status_log.Id is
'主键id';

comment on column lease_allinpay_status_log.Allinpay_Log_Id is
'代收流水主键id';

comment on column lease_allinpay_status_log.Create_Time is
'创建日期/操作日期';

comment on column lease_allinpay_status_log.Create_By is
'创建人/操作人';

comment on column lease_allinpay_status_log.Ret_Code is
'通联返回的 明细 状态码';

comment on column lease_allinpay_status_log.Err_Msg is
'通联返回的 明细 状态结果描述';

comment on column lease_allinpay_status_log.Back_Time is
'通联支付反馈状态日期';

comment on column lease_allinpay_status_log.Type is
'类型 0:提交通联单笔扣款的结果;1:提交通联批量扣款的结果;2:轮询通联的结果';

comment on column lease_allinpay_status_log.Payment_Result is
'支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败';

comment on column lease_allinpay_status_log.Payment_Result_Msg is
'状态结果描述  失败原因描述';



/*==============================================================*/
/* Table: lease_scheme_repayment                                */
/*==============================================================*/
create table lease_scheme_repayment (
   Id                   INT8                 not null,
   "contract_id" int8,
	"lessee_id" int8,
	"period" int8,
	"return_principal" numeric(20,2),
	"return_interest" numeric(20,2),
	"total" numeric(20,2),
	"residual_principal" numeric(20,2),
	"repayment_date" date,
	"overdue" int2 DEFAULT 1,
	"overdue_day" int4 DEFAULT 0,
	"loan_amount" numeric(20,2),
	"annual_interest" numeric(20,2),
	"create_time" timestamp(6),
	"update_time" timestamp(6),
	"create_by" int8,
	"update_by" int8,
	"sort" int4,
	"is_enable" bool,
	CONSTRAINT "LEASE_SCHEME_REPAYMENT" PRIMARY KEY ("id")
);

CREATE SEQUENCE lease_scheme_repayment_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_repayment alter column id set default nextval('lease_scheme_repayment_id_seq');

COMMENT ON TABLE "public"."lease_scheme_repayment" IS '根据融租合同数据生成月租还款计划明细';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."id" IS '主键id';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."contract_id" IS '合同主键ID';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."lessee_id" IS '承租人主键Id';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."period" IS '分期数';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."return_principal" IS '归还本金';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."return_interest" IS '归还利息';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."total" IS '合计';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."residual_principal" IS '剩余本金';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."repayment_date" IS '还款日期';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."overdue" IS '是否逾期 0 是 1 否';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."overdue_day" IS '逾期天数';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."loan_amount" IS '贷款金额';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."annual_interest" IS '年利率';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."create_time" IS '创建日期';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."update_time" IS '修改日期';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."create_by" IS '创建人';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."update_by" IS '修改人';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."sort" IS '排序';

COMMENT ON COLUMN "public"."lease_scheme_repayment"."is_enable" IS '状态 0:禁用 1:启用';



/*==============================================================*/
/* Table: lease_scheme_vehicle                                  */
/*==============================================================*/
create table lease_scheme_vehicle (
   Id                   INT8                 not null,
   Scheme_Id            INT8                 null,
   Brands_Id            INT8                 null,
   Series_Id            INT8                 null,
   Model_Id             INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean              null,
   Sort                 INT4                 null,
   constraint PK_LEASE_SCHEME_VEHICLE primary key (Id)
);

CREATE SEQUENCE lease_scheme_vehicle_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_vehicle alter column id set default nextval('lease_scheme_vehicle_id_seq');

comment on table lease_scheme_vehicle is
'融租方案-适用车型';

comment on column lease_scheme_vehicle.Id is
'主键id';

comment on column lease_scheme_vehicle.Brands_Id is
'品牌主键Id';

comment on column lease_scheme_vehicle.Series_Id is
'系列主键Id';

comment on column lease_scheme_vehicle.Model_Id is
'车型主键Id';

comment on column lease_scheme_vehicle.Create_Time is
'创建日期';

comment on column lease_scheme_vehicle.Update_Time is
'修改日期';

comment on column lease_scheme_vehicle.Create_By is
'创建人';

comment on column lease_scheme_vehicle.Update_By is
'修改人';

comment on column lease_scheme_vehicle.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_scheme_vehicle.Sort is
'排序';


/*==============================================================*/
/* Table: lease_scheme_area                                     */
/*==============================================================*/
create table lease_scheme_area (
   Id                   INT8                 not null,
   Scheme_Id            INT8                 null,
   Province_Id          INT8                 null,
   Province_Name        varchar(100)         null,
   City_Id              INT8                 null,
   City_Name            varchar(100)         null,
   Area_Id              INT8                 null,
   Area_Name            varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean              null,
   Sort                 INT4                 null,
   constraint PK_LEASE_SCHEME_AREA primary key (Id)
);

CREATE SEQUENCE lease_scheme_area_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_area alter column id set default nextval('lease_scheme_area_id_seq');

comment on table lease_scheme_area is
'融租方案-适用地区';

comment on column lease_scheme_area.Id is
'主键id';

comment on column lease_scheme_area.Province_Id is
'省份ID';

comment on column lease_scheme_area.Province_Name is
'省份名称';

comment on column lease_scheme_area.City_Id is
'城市ID';

comment on column lease_scheme_area.City_Name is
'城市名称';

comment on column lease_scheme_area.Area_Id is
'区域ID';

comment on column lease_scheme_area.Area_Name is
'区域名称';

comment on column lease_scheme_area.Create_Time is
'创建日期';

comment on column lease_scheme_area.Update_Time is
'修改日期';

comment on column lease_scheme_area.Create_By is
'创建人';

comment on column lease_scheme_area.Update_By is
'修改人';

comment on column lease_scheme_area.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_scheme_area.Sort is
'排序';



/*==============================================================*/
/* Table: lease_car_dict_accessory                              */
/*==============================================================*/
create table lease_car_dict_accessory (
   Id                   INT8                 not null,
   Car_Id               INT8                 null,
   Dict_Id              INT8                 null,
   constraint PK_LEASE_CAR_DICT_ACCESSORY primary key (Id)
);

CREATE SEQUENCE lease_car_dict_accessory_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_car_dict_accessory alter column id set default nextval('lease_car_dict_accessory_id_seq');

comment on table lease_car_dict_accessory is
'车辆信息-随车物料';

comment on column lease_car_dict_accessory.Id is
'主键id';

comment on column lease_car_dict_accessory.Car_Id is
'车辆主键Id';

comment on column lease_car_dict_accessory.Dict_Id is
'字典表随车物料主键id';


/*==============================================================*/
/* Table: lease_use_used                                        */
/*==============================================================*/
create table lease_use_used (
   Id                   INT8                 not null,
   Use_Id               INT8                 null,
   Use_Name             varchar(100)         null,
   Used_Id              INT8                 null,
   Used_Name            varchar(100)         null,
   Use_Type             varchar(100)         null,
   Used_Type            varchar(100)         null,
   constraint PK_LEASE_USE_USED primary key (Id)
);

CREATE SEQUENCE lease_use_used_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_use_used alter column id set default nextval('lease_use_used_id_seq');

comment on table lease_use_used is
'比如 某个分公司 被 融租合同模板 使用，这几记录两者，方便删除限制';

comment on column lease_use_used.Id is
'主键id';

comment on column lease_use_used.Use_Id is
'使用者主键id';

comment on column lease_use_used.Use_Name is
'使用者名称';

comment on column lease_use_used.Used_Id is
'被使用者主键id';

comment on column lease_use_used.Used_Name is
'被使用者名称';

comment on column lease_use_used.Use_Type is
'使用者类型';

comment on column lease_use_used.Used_Type is
'被使用者类型';


/*==============================================================*/
/* Table: lease_user                                            */
/*==============================================================*/
create table lease_user (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Sex                  INT4                 null,
   Phone                varchar(100)         null,
   Real_Name            varchar(100)         null,
   Email                varchar(100)         null,
   Salt                 varchar(100)         null,
   Password             varchar(100)         null,
   Icon                 varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   status               INT4                 DEFAULT 0,
   constraint PK_LEASE_USER primary key (Id)
);

CREATE SEQUENCE lease_user_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_user alter column id set default nextval('lease_user_id_seq');

comment on table lease_user is
'后台用户';

comment on column lease_user.Id is
'主键id';

comment on column lease_user.Name is
'用户名称/姓名';

comment on column lease_user.Sex is
'性别:0:女,1:男';

comment on column lease_user.Phone is
'手机号(账号)';

comment on column lease_user.Real_Name is
'真实姓名';

comment on column lease_user.Email is
'邮箱地址';

comment on column lease_user.Salt is
'加密盐';

comment on column lease_user.Password is
'密码';

comment on column lease_user.Icon is
'头像';

comment on column lease_user.Create_Time is
'创建日期';

comment on column lease_user.Update_Time is
'修改日期';

comment on column lease_user.Create_By is
'创建人';

comment on column lease_user.Update_By is
'修改人';

comment on column lease_user.Sort is
'排序';

comment on column lease_user.Status is
'账号状态:0使用中、1锁定、2注销、3禁用';

/*==============================================================*/
/* Table: lease_user_session                                    */
/*==============================================================*/
create table lease_user_session (
   Id                   INT8                 not null,
   Device_Id            varchar(100)         null,
   User_Id              INT8                 null,
   Phone                varchar(100)         null,
   Real_Name            varchar(100)         null,
   Session_Current      varchar(100)         null,
   Session_Code         varchar(100)         null,
   Session_Login_Time   TIMESTAMP            null,
   Session_Limit_Time   TIMESTAMP            null,
   constraint PK_LEASE_USER_SESSION primary key (Id)
);

CREATE SEQUENCE lease_user_session_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_user_session alter column id set default nextval('lease_user_session_id_seq');

comment on table lease_user_session is
'后台用户登录状态session';

comment on column lease_user_session.Id is
'主键id';

comment on column lease_user_session.Device_Id is
'登录设备ID';

comment on column lease_user_session.User_Id is
'用户主键id';

comment on column lease_user_session.Phone is
'手机号(账号)';

comment on column lease_user_session.Real_Name is
'真实姓名';

comment on column lease_user_session.Session_Current is
'当前token';

comment on column lease_user_session.Session_Code is
'验证码';

comment on column lease_user_session.Session_Login_Time is
'最近登录时间';

comment on column lease_user_session.Session_Limit_Time is
'token有效时间';




/*==============================================================*/
/* Table: lease_scheme_repayment_status                               */
/*==============================================================*/
create table lease_scheme_repayment_status (
   Id                   INT8                 not null,
   Repayment_Id         INT8                 null,
   Contract_Id          INT8                 null,
   Totle_Price			DECIMAL(20,2)		 null,
   Pay_Way              INT4                 null,
   Type                 INT4                 null,
   Payment_Result       INT4                 null,
   Payment_Result_Msg   text                 null,
   Req_Sn               VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   Create_Time          date            	 null,
   Create_By            INT8                 null,
   Update_Time          timestamp            null,
   Update_By            INT8                 null,
   constraint PK_lease_scheme_repayment_status primary key (Id)
);

CREATE SEQUENCE lease_scheme_repayment_status_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_repayment_status alter column id set default nextval('lease_scheme_repayment_status_id_seq');

comment on table lease_scheme_repayment_status is
'支付状态汇总管理,月供的状态、滞纳金的状态、挂靠费的状态、提前还款的状态、尾付的状态，一个合同的某一期对应的这几种款项只有一个状态，可能每一种款项会操作多次扣款因为会失败了再重新操作扣款，每次操作的状态都更新。申请挂靠即时初始化这个表的挂靠数据，生成合同即时初始化这个表的月供数据';

comment on column lease_scheme_repayment_status.Id is
'主键id';

comment on column lease_scheme_repayment_status.Repayment_Id is
'款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款主键id';

comment on column lease_scheme_repayment_status.Contract_Id is
'融租合同主键id';

comment on column lease_scheme_repayment_status.Totle_Price is
'合计金额';

comment on column lease_scheme_repayment_status.Pay_Way is
'支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他';

comment on column lease_scheme_repayment_status.Type is
'款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/月租的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款';

comment on column lease_scheme_repayment_status.Payment_Result is
'支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败';

comment on column lease_scheme_repayment_status.Payment_Result_Msg is
'状态结果描述  失败原因描述';

comment on column lease_scheme_repayment_status.Req_Sn is
'通联返回的 文件名/可用于通联流水查询/最后一次操作的文件名，有可能一个款项操作了多次';

comment on column lease_scheme_repayment_status.Sn is
'记录序号 通联批量代收 每笔金额的 序号/最后一次操作的序号，有可能一个款项操作了多次';

comment on column lease_scheme_repayment_status.Create_Time is
'创建日期';

comment on column lease_scheme_repayment_status.Create_By is
'创建人';

comment on column lease_scheme_repayment_status.Update_Time is
'修改日期';

comment on column lease_scheme_repayment_status.Update_By is
'修改人';




drop table lease_scheme_car_financinger;

/*==============================================================*/
/* Table: lease_scheme_car_financinger                          */
/*==============================================================*/
create table lease_scheme_car_financinger (
   Id                   INT8                 not null,
   Car_Buy_Financinger_Id INT8                 null,
   Car_Id               INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean              null,
   constraint PK_LEASE_SCHEME_CAR_FINANCINGE primary key (Id)
);

CREATE SEQUENCE lease_scheme_car_financinger_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_car_financinger alter column id set default nextval('lease_scheme_car_financinger_id_seq');

comment on table lease_scheme_car_financinger is
'一辆车会切换融资方，即会关联多个融资方';

comment on column lease_scheme_car_financinger.Id is
'主键id';

comment on column lease_scheme_car_financinger.Car_Buy_Financinger_Id is
'融资方主键id';

comment on column lease_scheme_car_financinger.Car_Id is
'车辆主键Id';

comment on column lease_scheme_car_financinger.Create_Time is
'创建日期/开始合作日期';

comment on column lease_scheme_car_financinger.Update_Time is
'修改日期/开始合作日期';

comment on column lease_scheme_car_financinger.Create_By is
'创建人';

comment on column lease_scheme_car_financinger.Update_By is
'修改人';

comment on column lease_scheme_car_financinger.Sort is
'排序';

comment on column lease_scheme_car_financinger.Is_Enable is
'状态 0:禁用 1:启用';




/*==============================================================*/
/* Table: lease_contract_link                                   */
/*==============================================================*/
create table lease_contract_link (
   Id                   INT8                 not null,
   Contract_Id          INT8                 null,
   Repayment_Date       INT4                 null,
   Totle_Price          DECIMAL(20,2)        null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_CONTRACT_LINK primary key (Id)
);

CREATE SEQUENCE lease_contract_link_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_link alter column id set default nextval('lease_contract_link_id_seq');

comment on table lease_contract_link is
'租期结束且融租合同贷后管理登记为挂靠用户';

comment on column lease_contract_link.Id is
'主键id';

comment on column lease_contract_link.Contract_Id is
'融租合同主键id';

comment on column lease_contract_link.Repayment_Date is
'还款日期';

comment on column lease_contract_link.Totle_Price is
'合计';

comment on column lease_contract_link.Create_Time is
'创建日期';

comment on column lease_contract_link.Update_Time is
'修改日期';

comment on column lease_contract_link.Create_By is
'创建人';

comment on column lease_contract_link.Update_By is
'修改人';





/*==============================================================*/
/* Table: lease_contract_link_repayment                         */
/*==============================================================*/
create table lease_contract_link_repayment (
   Id                   INT8                 not null,
   Contract_Id          INT8                 null,
   Contract_Link_Id     INT8                 null,
   Account_Id           INT8                 null,
   Totle_Price          DECIMAL(20,2)        null,
   Repayment_Date       date            	 null,
   Overdue              INT4                 null,
   Overdue_Day          INT4                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean              null,
   constraint PK_LEASE_CONTRACT_LINK_REPAYME primary key (Id)
);

CREATE SEQUENCE lease_contract_link_repayment_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_link_repayment alter column id set default nextval('lease_contract_link_repayment_id_seq');

comment on table lease_contract_link_repayment is
'挂靠还款时间跟月租还款时间相同，首次操作还款则添加一条记录，即一个扣款日一条记录，类似还款计划明细，假如没有操作扣款而被检测到过期则自动添加一条过期月份的记录';

comment on column lease_contract_link_repayment.Id is
'主键id';

comment on column lease_contract_link_repayment.Contract_Id is
'融租合同主键ID';

comment on column lease_contract_link_repayment.Contract_Link_Id is
'融租合同 挂靠主键ID';

comment on column lease_contract_link_repayment.Account_Id is
'承租人ID';

comment on column lease_contract_link_repayment.Totle_Price is
'合计';

comment on column lease_contract_link_repayment.Repayment_Date is
'还款日期';

comment on column lease_contract_link_repayment.Overdue is
'是否逾期 0 是 1 否';

comment on column lease_contract_link_repayment.Overdue_Day is
'逾期时间/单位秒';

comment on column lease_contract_link_repayment.Create_Time is
'创建日期';

comment on column lease_contract_link_repayment.Update_Time is
'修改日期';

comment on column lease_contract_link_repayment.Create_By is
'创建人';

comment on column lease_contract_link_repayment.Update_By is
'修改人';

comment on column lease_contract_link_repayment.Sort is
'排序';

comment on column lease_contract_link_repayment.Is_Enable is
'状态 0:禁用 1:启用';







/*==============================================================*/
/* Table: lease_contract_advance                       */
/*==============================================================*/
create table lease_contract_advance (
   Id                   INT8                 not null,
   Contract_Id          INT8                 null,
   Repayment_Id         INT8                 null,
   Period               INT4                 null,
   Repayment_Date       date            null,
   Residual_Principal   DECIMAL(20,2)        null,
   Default_Interest     DECIMAL(20,2)        null,
   Receipts_Price       DECIMAL(20,2)        null,
   Payment_Result       INT4                 null,
   Payment_Result_Msg   text                 null,
   Req_Sn               VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_CONTRACT_ADVANCE primary key (Id)
);

CREATE SEQUENCE lease_contract_advance_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_advance alter column id set default nextval('lease_contract_advance_id_seq');

comment on table lease_contract_advance is
'融租合同贷后管理登记为提前还款,因为提前还款款项包括尾款，罚息，剩余本金，做一个提前还款汇总记录，方便处理几种款项的支付状态';

comment on column lease_contract_advance.Id is
'主键id';

comment on column lease_contract_advance.Contract_Id is
'融租合同主键id';

comment on column lease_contract_advance.Repayment_Id is
'融租合同-还款计划明细主键id/合同还款期数';

comment on column lease_contract_advance.Period is
'分期数/合同还款期数';

comment on column lease_contract_advance.Repayment_Date is
'还款日期';

comment on column lease_contract_advance.Residual_Principal is
'剩余本金';

comment on column lease_contract_advance.Default_Interest is
'提前还款罚款';

comment on column lease_contract_advance.Receipts_Price is
'实收金额';

comment on column lease_contract_advance.Payment_Result is
'支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败';

comment on column lease_contract_advance.Payment_Result_Msg is
'状态结果描述  失败原因描述';

comment on column lease_contract_advance.Req_Sn is
'通联返回的 文件名/可用于通联流水查询';

comment on column lease_contract_advance.Sn is
'记录序号 通联批量代收 每条数据的 序号';

comment on column lease_contract_advance.Create_Time is
'创建日期';

comment on column lease_contract_advance.Update_Time is
'修改日期';

comment on column lease_contract_advance.Create_By is
'创建人';

comment on column lease_contract_advance.Update_By is
'修改人';



/*==============================================================*/
/* Table: lease_allinpay_query_log                              */
/*==============================================================*/
create table lease_allinpay_query_log (
   Id                   INT8                 not null,
   Allinpay_Log_Id      INT8                 null,
   Repayment_Id         INT8                 null,
   Repayment_Status_Id  INT8                 null,
   Contract_Id          INT8                 null,
   Status               INT4                 null,
   Ret_Code             VARCHAR(100)         null,
   Err_Msg              VARCHAR(500)         null,
   Back_Time            timestamp            null,
   Req_Sn               VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   constraint PK_LEASE_ALLINPAY_QUERY_LOG primary key (Id)
);

CREATE SEQUENCE lease_allinpay_query_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_query_log alter column id set default nextval('lease_allinpay_query_log_id_seq');

comment on table lease_allinpay_query_log is
'通联轮询流水，通联轮询款项支付状态，支付的时候记录的代收流水的状态不是通联最后的支付状态，通联规定每笔款都要在支付后10分钟查询结果，这里就记录查询结果的状态，每一条代收流水都对应一条轮询流水';

comment on column lease_allinpay_query_log.Id is
'主键id';

comment on column lease_allinpay_query_log.Allinpay_Log_Id is
'代收流水主键id';

comment on column lease_allinpay_query_log.Repayment_Id is
'款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id';

comment on column lease_allinpay_query_log.Repayment_Status_Id is
'支付状态汇总管理主键id';

comment on column lease_allinpay_query_log.Contract_Id is
'融租合同主键id';

comment on column lease_allinpay_query_log.Status is
'通联支付状态/0:已提交;1:成功;2:失败';

comment on column lease_allinpay_query_log.Ret_Code is
'通联支付反馈状态码';

comment on column lease_allinpay_query_log.Err_Msg is
'通联支付反馈状态描述';

comment on column lease_allinpay_query_log.Back_Time is
'通联支付反馈状态日期';

comment on column lease_allinpay_query_log.Req_Sn is
'通联返回的 文件名/可用于通联流水查询';

comment on column lease_allinpay_query_log.Sn is
'记录序号 通联批量代收 每条数据的 序号';



/*==============================================================*/
/* Table: lease_contract_repayment_except                       */
/*==============================================================*/
create table lease_contract_repayment_except (
   Id                   INT8                 not null,
   Contract_Id          INT8                 null,
   Repayment_Id         INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_CONTRACT_REPAYMENT_EX primary key (Id)
);

CREATE SEQUENCE lease_contract_repayment_except_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_repayment_except alter column id set default nextval('lease_contract_repayment_except_id_seq');

comment on table lease_contract_repayment_except is
'融租合同 不用系统处理扣款的月租，录入的合同数据如果是不需要系统处理租金扣款，则记录，因为有些合同数据是线下处理了收款';

comment on column lease_contract_repayment_except.Id is
'主键id';

comment on column lease_contract_repayment_except.Contract_Id is
'融租合同主键id';

comment on column lease_contract_repayment_except.Repayment_Id is
'融租合同-还款计划明细主键id';

comment on column lease_contract_repayment_except.Create_Time is
'创建日期';

comment on column lease_contract_repayment_except.Update_Time is
'修改日期';

comment on column lease_contract_repayment_except.Create_By is
'创建人';

comment on column lease_contract_repayment_except.Update_By is
'修改人';





/*==============================================================*/
/* Table: lease_sms_log                                         */
/*==============================================================*/
create table lease_sms_log (
   Id                   INT8                 not null,
   Name                 varchar(100)         null,
   Phone                varchar(100)         null,
   Message              text         		 null,
   Create_Time          timestamp            null,
   Create_By            INT8                 null,
   Status               INT4                 null,
   Type                 INT4                 null,
   constraint PK_LEASE_SMS_LOG primary key (Id)
);

CREATE SEQUENCE lease_sms_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_sms_log alter column id set default nextval('lease_sms_log_id_seq');

comment on table lease_sms_log is
'短信日志';

comment on column lease_sms_log.Id is
'主键id';

comment on column lease_sms_log.Name is
'户名';

comment on column lease_sms_log.Phone is
'开户行';

comment on column lease_sms_log.Message is
'账号';

comment on column lease_sms_log.Create_Time is
'创建日期';

comment on column lease_sms_log.Create_By is
'创建人';

comment on column lease_sms_log.Status is
'发送状态（0 成功 1 失败）';

comment on column lease_sms_log.Type
'类型（0 系统自动 1 手动）';






/*==============================================================*/
/* Table: lease_contract_sms                                    */
/*==============================================================*/
create table lease_contract_sms (
   Id                   INT8                 not null,
   Contract_Id          INT8                 null,
   Sms_Id               INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_CONTRACT_SMS primary key (Id)
);

CREATE SEQUENCE lease_contract_sms_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_sms alter column id set default nextval('lease_contract_sms_id_seq');

comment on table lease_contract_sms is
'融租合同-短信日志';

comment on column lease_contract_sms.Id is
'主键id';

comment on column lease_contract_sms.Contract_Id is
'融租合同主键Id';

comment on column lease_contract_sms.Sms_Id is
'归档位置主键Id';

comment on column lease_contract_sms.Create_Time is
'创建日期';

comment on column lease_contract_sms.Update_Time is
'修改日期';

comment on column lease_contract_sms.Create_By is
'创建人';

comment on column lease_contract_sms.Update_By is
'修改人';




/*==============================================================*/
/* Table: lease_contract_baseinfo_use                           */
/*==============================================================*/
create table lease_contract_baseinfo_use (
   Id                   INT8                 not null,
   Contract_Party_Name  varchar(100)         null,
   Contract_Branch_Company varchar(100)         null,
   Contract_Party_Adress varchar(100)         null,
   Legal_Person         varchar(100)         null,
   Down_Payment_Time_Limit varchar(100)         null,
   Loan_Deposit         DECIMAL(10,2)        null,
   Check_Time           varchar(100)         null,
   Important_Event_Price DECIMAL(10,2)        null,
   Appoint_Area         varchar(100)         null,
   Rent_Overdue_Time_Limit varchar(100)         null,
   Car_Lessee_City      varchar(100)         null,
   City_Inside_Recovery_Cost DECIMAL(10,2)        null,
   City_Outside_Recovery_Cost DECIMAL(10,2)        null,
   Province_Inside_Recovery_Cost DECIMAL(10,2)        null,
   Day_Custodian_Cost   DECIMAL(10,2)        null,
   Cumulative_Overdue   varchar(100)         null,
   Default_Interest     DECIMAL(10,2)        null,
   License_Monthly_Rent DECIMAL(10,2)        null,
   Contract_Party_Contact_Address text                 null,
   Account_Name         varchar(100)         null,
   Bank_Id              INT8                 null,
   Account              varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean              null,
   Remarks              text                 null,
   Branch_Company_Id    INT8                 null,
   constraint PK_LEASE_CONTRACT_BASEINFO_USE primary key (Id)
);

CREATE SEQUENCE lease_contract_baseinfo_use_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_baseinfo_use alter column id set default nextval('lease_contract_baseinfo_use_id_seq');

comment on table lease_contract_baseinfo_use is
'融租合同使用模板';

comment on column lease_contract_baseinfo_use.Id is
'主键id';

comment on column lease_contract_baseinfo_use.Account_Name is
'户名';

comment on column lease_contract_baseinfo_use.Bank_Id is
'开户行';

comment on column lease_contract_baseinfo_use.Account is
'账号';

comment on column lease_contract_baseinfo_use.Create_Time is
'创建日期';

comment on column lease_contract_baseinfo_use.Update_Time is
'修改日期';

comment on column lease_contract_baseinfo_use.Create_By is
'创建人';

comment on column lease_contract_baseinfo_use.Update_By is
'修改人';

comment on column lease_contract_baseinfo_use.Sort is
'排序';

comment on column lease_contract_baseinfo_use.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_contract_baseinfo_use.Remarks is
'状态 0:禁用 1:启用';





/*==============================================================*/
/* Table: lease_scheme_car_financinger                          */
/*==============================================================*/
create table lease_scheme_car_financinger (
   Id                   INT8                 not null,
   Car_Buy_Financinger_Id INT8                 null,
   Car_Id               INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean              null,
   constraint PK_LEASE_SCHEME_CAR_FINANCINGE primary key (Id)
);

CREATE SEQUENCE lease_scheme_car_financinger_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_car_financinger alter column id set default nextval('lease_scheme_car_financinger_id_seq');

comment on table lease_scheme_car_financinger is
'车辆-购车融资方';

comment on column lease_scheme_car_financinger.Id is
'主键id';

comment on column lease_scheme_car_financinger.Car_Buy_Financinger_Id is
'保险公司主键id';

comment on column lease_scheme_car_financinger.Car_Id is
'险种名称';

comment on column lease_scheme_car_financinger.Create_Time is
'创建日期';

comment on column lease_scheme_car_financinger.Update_Time is
'修改日期';

comment on column lease_scheme_car_financinger.Create_By is
'创建人';

comment on column lease_scheme_car_financinger.Update_By is
'修改人';

comment on column lease_scheme_car_financinger.Sort is
'排序';

comment on column lease_scheme_car_financinger.Is_Enable is
'状态 0:禁用 1:启用';



/*==============================================================*/
/* Table: lease_allinpay_status_sms                             */
/*==============================================================*/
create table lease_allinpay_status_sms (
   Id                   INT8                 not null,
   Query_Log_Id         INT8                 null,
   Used_Id		        INT8                 null,
   Sms_Id               INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Type			        INT4                 null,
   constraint PK_LEASE_ALLINPAY_STATUS_SMS primary key (Id)
);

CREATE SEQUENCE lease_allinpay_status_sms_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_status_sms alter column id set default nextval('lease_allinpay_status_sms_id_seq');

comment on table lease_allinpay_status_sms is
'短信通知日志，包括通联扣款结果，通联规定每笔款都要在支付后10分钟查询结果，如果要发送短信提醒就要在查询的时候发送，现在做法是根据通联轮询流水处理短信发送，即是未发送短信的通联轮询流水则后台自动操作发送，这张表就记录发送的数据；';

comment on column lease_allinpay_status_sms.Id is
'主键id';

comment on column lease_allinpay_status_sms.Query_Log_Id is
'通联轮询流水主键Id';

comment on column lease_allinpay_status_sms.Used_Id is
'发送数据方的主键Id 即是 月租还款计划明细主键id';

comment on column lease_allinpay_status_sms.Sms_Id is
'短信日志主键Id';

comment on column lease_allinpay_status_sms.Create_Time is
'创建日期';

comment on column lease_allinpay_status_sms.Update_Time is
'修改日期';

comment on column lease_allinpay_status_sms.Create_By is
'创建人';

comment on column lease_allinpay_status_sms.Update_By is
'修改人';

comment on column lease_allinpay_status_sms.Type is
'短信类型：0:通联轮询 ; 1:手动发送逾期提醒 ; 2:自动提前扣款提醒; 3:扣款失败通知';

/*==============================================================*/
/* Table: lease_account_company                                 */
/*==============================================================*/
create table lease_account_company (
   Id                   INT8                 not null,
   Account_Id           INT8                 null,
   Company_Name         varchar(100)         null,
   Business_License_Number varchar(100)         null,
   Business_License_Img varchar(100)         null,
   Company_Registration_Address varchar(100)         null,
   Company_Phone        varchar(100)         null,
   Legal_Person_Id_Card varchar(100)         null,
   Legal_Person_Name    varchar(100)         null,
   Legal_Person_Address varchar(100)         null,
   Legal_Person_Phone   varchar(100)         null,
   Contacts_Name        varchar(100)         null,
   Contacts_Address     varchar(100)         null,
   Contacts_Phone       varchar(100)         null,
   Bank_Account_Name    varchar(100)         null,
   Bank_Id              INT8         		 null,
   Branch_Bank          varchar(100)         null,
   Back_Card_Number     varchar(100)         null,
   Back_Card_Img        text         		 null,
   Remark               text                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Emergency_Contact    text         		 null,
   constraint PK_LEASE_ACCOUNT_COMPANY primary key (Id)
);

CREATE SEQUENCE lease_account_company_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_account_company alter column id set default nextval('lease_account_company_id_seq');

comment on table lease_account_company is
'注册公司类型用户/承租人';

comment on column lease_account_company.Id is
'主键id';

comment on column lease_account_company.Account_Id is
'注册用户/承租人主键id';

comment on column lease_account_company.Company_Name is
'公司名称';

comment on column lease_account_company.Business_License_Number is
'营业执照号';

comment on column lease_account_company.Business_License_Img is
'营业执图片';

comment on column lease_account_company.Company_Registration_Address is
'公司注册地址';

comment on column lease_account_company.Company_Phone is
'公司固话';

comment on column lease_account_company.Legal_Person_Id_Card is
'法人身份证号码';

comment on column lease_account_company.Legal_Person_Name is
'法人姓名';

comment on column lease_account_company.Legal_Person_Address is
'法人地址';

comment on column lease_account_company.Legal_Person_Phone is
'法人电话';

comment on column lease_account_company.Contacts_Address is
'联系人地址';

comment on column lease_account_company.Contacts_Phone is
'联系电话';

comment on column lease_account_company.Bank_Account_Name is
'户名';

comment on column lease_account_company.Bank_Id is
'银行卡发卡行';

comment on column lease_account_company.Branch_Bank is
'银行卡发卡行';

comment on column lease_account_company.Back_Card_Number is
'银行卡号';

comment on column lease_account_company.Back_Card_Img is
'银行卡照片';

comment on column lease_account_company.Remark is
'备注';

comment on column lease_account_company.Create_Time is
'创建日期';

comment on column lease_account_company.Update_Time is
'修改日期';

comment on column lease_account_company.Create_By is
'创建人';

comment on column lease_account_company.Update_By is
'修改人';

comment on column lease_account_company.Sort is
'排序';

comment on column lease_account_company.Emergency_Contact is
'紧急联系人/json格式存放多个联系人/包括:紧急联系人姓名(Emergency_Contact_Name)；紧急联系人与本人关系(Emergency_Contact_Relationship)；急联系人手机(Emergency_Contact_Phone)；紧急联系人与本人关系(Emergency_Contact_Address)';


/*==============================================================*/
/* Table: lease_user_login_log                                  */
/*==============================================================*/
create table lease_user_login_log (
   Id                   INT8                 not null,
   Device_Id            varchar(100)         null,
   Phone                varchar(100)         null,
   User_Id              INT8                 null,
   Login_In_Time        TIMESTAMP            null,
   Login_Out_Time       TIMESTAMP            null,
   Login_Ip             varchar(100)         null,
   Login_Error          text                 null,
   Session_Current      varchar(100)         null,
   constraint PK_LEASE_USER_LOGIN_LOG primary key (Id)
);

CREATE SEQUENCE lease_user_login_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_user_login_log alter column id set default nextval('lease_user_login_log_id_seq');

comment on table lease_user_login_log is
'后台用户登录日志';

comment on column lease_user_login_log.Id is
'主键id';

comment on column lease_user_login_log.Device_Id is
'登录设备ID';

comment on column lease_user_login_log.Phone is
'登录账号';

comment on column lease_user_login_log.User_Id is
'用户主键id';

comment on column lease_user_login_log.Login_In_Time is
'登录时间';

comment on column lease_user_login_log.Login_Out_Time is
'退出登录时间';

comment on column lease_user_login_log.Login_Ip is
'登录IP';

comment on column lease_user_login_log.Login_Error is
'登录结果';

comment on column lease_user_login_log.Session_Current is
'当前token';



create table lease_wx_customer (
Id                   INT8                 not null,
Name                 VARCHAR(100)         null,
Openid               VARCHAR(100)         null,
Phone                VARCHAR(100)         null,
Province_Id          INT8                 null,
Province_Name        varchar(100)         null,
City_Id              INT8                 null,
City_Name            varchar(100)         null,
Area_Id              INT8                 null,
Area_Name            varchar(100)         null,
Deal                 INT2    null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            boolean              null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_CUSTOMER primary key (Id)
);


CREATE SEQUENCE lease_wx_customer_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_customer  alter column id set default nextval('lease_wx_customer_id_seq');

comment on table lease_wx_customer is
'小程序预约客户';

comment on column lease_wx_customer.Id is
'主键id';

comment on column lease_wx_customer.Name is
'姓名';

comment on column lease_wx_customer.Openid is
'微信openid';

comment on column lease_wx_customer.Phone is
'手机号码';

comment on column lease_wx_customer.Province_Id is
'省份ID';

comment on column lease_wx_customer.Province_Name is
'省份名称';

comment on column lease_wx_customer.City_Id is
'城市ID';

comment on column lease_wx_customer.City_Name is
'城市名称';

comment on column lease_wx_customer.Area_Id is
'区域ID';

comment on column lease_wx_customer.Area_Name is
'区域名称';

comment on column lease_wx_customer.Deal is
'是否处理';

comment on column lease_wx_customer.Create_Time is
'创建日期';

comment on column lease_wx_customer.Update_Time is
'修改日期';

comment on column lease_wx_customer.Create_By is
'创建人';

comment on column lease_wx_customer.Update_By is
'修改人';

comment on column lease_wx_customer.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_customer.Sort is
'排序';


create table lease_wx_agent (
Id                   INT8                 not null,
Name                 VARCHAR(100)         null,
Openid               VARCHAR(100)         null,
Phone                VARCHAR(100)         null,
Province_Id          INT8                 null,
Province_Name        varchar(100)         null,
City_Id              INT8                 null,
City_Name            varchar(100)         null,
Area_Id              INT8                 null,
Area_Name            varchar(100)         null,
Deal                 INT2    null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            boolean              null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_AGENT primary key (Id)
);

CREATE SEQUENCE lease_wx_agent_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_agent  alter column id set default nextval('lease_wx_agent_id_seq');

comment on table lease_wx_agent is
'小程序代理加盟';

comment on column lease_wx_agent.Id is
'主键id';

comment on column lease_wx_agent.Name is
'姓名';

comment on column lease_wx_agent.Phone is
'手机号码';

comment on column lease_wx_agent.Openid is
'微信openid';

comment on column lease_wx_agent.Province_Id is
'省份ID';

comment on column lease_wx_agent.Province_Name is
'省份名称';

comment on column lease_wx_agent.City_Id is
'城市ID';

comment on column lease_wx_agent.City_Name is
'城市名称';

comment on column lease_wx_agent.Area_Id is
'区域ID';

comment on column lease_wx_agent.Area_Name is
'区域名称';

comment on column lease_wx_agent.Deal is
'是否处理';

comment on column lease_wx_agent.Create_Time is
'创建日期';

comment on column lease_wx_agent.Update_Time is
'修改日期';

comment on column lease_wx_agent.Create_By is
'创建人';

comment on column lease_wx_agent.Update_By is
'修改人';

comment on column lease_wx_agent.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_agent.Sort is
'排序';


create table lease_wx_car (
Id                   INT8                 not null,
Car_Name             VARCHAR(100)         null,
Market_Price         DECIMAL(10,2)        null,
Main_Img              TEXT         null,
Car_Structure        VARCHAR(100)         null,
Long_Width_Height    VARCHAR(100)         null,
Engine               VARCHAR(100)         null,
Transmission         varchar(100)         null,
Drive_Mode           varchar(100)         null,
Fuel_Mode            varchar(100)         null,
Fuel                 varchar(100)         null,
Detail_Img           varchar(100)         null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            boolean              null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_CAR primary key (Id)
);

CREATE SEQUENCE lease_wx_car_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_car alter column id set default nextval('lease_wx_car_id_seq');

comment on table lease_wx_car is
'小程序车辆信息';

comment on column lease_wx_car.Id is
'主键id';

comment on column lease_wx_car.Car_Name is
'车辆名称';

comment on column lease_wx_car.Market_Price is
'市场指导价';

comment on column lease_wx_car.Main_Img is
'主图';

comment on column lease_wx_car.Car_Structure is
'车身结构';

comment on column lease_wx_car.Long_Width_Height is
'长宽高';

comment on column lease_wx_car.Engine is
'省份ID';

comment on column lease_wx_car.Transmission is
'省份名称';

comment on column lease_wx_car.Drive_Mode is
'城市ID';

comment on column lease_wx_car.Fuel_Mode is
'城市名称';

comment on column lease_wx_car.Fuel is
'区域ID';

comment on column lease_wx_car.Detail_Img is
'区域名称';

comment on column lease_wx_car.Create_Time is
'创建日期';

comment on column lease_wx_car.Update_Time is
'修改日期';

comment on column lease_wx_car.Create_By is
'创建人';

comment on column lease_wx_car.Update_By is
'修改人';

comment on column lease_wx_car.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_car.Sort is
'排序';


create table lease_wx_car_scheme (
Id                   INT8                 not null,
Car_Id               INT8                 null,
Down_Payment         DECIMAL(10,2)        null,
Market_Price         DECIMAL(10,2)        null,
Monthly_Rent         DECIMAL(10,2)        null,
Balance_Payment         DECIMAL(10,2)        null,
Staging_Number       INT4                 null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            boolean              null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_CAR_SCHEME primary key (Id)
);

CREATE SEQUENCE lease_wx_car_scheme_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_car_scheme  alter column id set default nextval('lease_wx_car_scheme_id_seq');

comment on table lease_wx_car_scheme is
'小程序车辆信息-融租方案';

comment on column lease_wx_car_scheme.Id is
'主键id';

comment on column lease_wx_car_scheme.Car_Id is
'车辆id';

comment on column lease_wx_car_scheme.Down_Payment is
'首付';

comment on column lease_wx_car_scheme.Market_Price is
'市场价';

comment on column lease_wx_car_scheme.Monthly_Rent is
'月供';

comment on column lease_wx_car_scheme.Balance_Payment is
'尾付';

comment on column lease_wx_car_scheme.Staging_Number is
'分期数';

comment on column lease_wx_car_scheme.Create_Time is
'创建日期';

comment on column lease_wx_car_scheme.Update_Time is
'修改日期';

comment on column lease_wx_car_scheme.Create_By is
'创建人';

comment on column lease_wx_car_scheme.Update_By is
'修改人';

comment on column lease_wx_car_scheme.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_car_scheme.Sort is
'排序';


create table lease_wx_home_img (
Id                   INT8                 not null,
Title                VARCHAR(100)         null,
Img                  TEXT        null,
URL                  VARCHAR(100)         null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            boolean              null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_HOME_IMG primary key (Id)
);

CREATE SEQUENCE lease_wx_home_img_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_home_img alter column id set default nextval('lease_wx_home_img_id_seq');

comment on table lease_wx_home_img is
'小程序首页轮换图';

comment on column lease_wx_home_img.Id is
'主键id';

comment on column lease_wx_home_img.Title is
'标题';

comment on column lease_wx_home_img.Img is
'图片';

comment on column lease_wx_home_img.URL is
'链接';

comment on column lease_wx_home_img.Create_Time is
'创建日期';

comment on column lease_wx_home_img.Update_Time is
'修改日期';

comment on column lease_wx_home_img.Create_By is
'创建人';

comment on column lease_wx_home_img.Update_By is
'修改人';

comment on column lease_wx_home_img.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_home_img.Sort is
'排序';


create table lease_wx_company_profile (
Id                   INT8                 not null,
Company_Profile      TEXT         null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            boolean              null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_COMPANY_PROFILE primary key (Id)
);

CREATE SEQUENCE lease_wx_company_profile_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_company_profile  alter column id set default nextval('lease_wx_company_profile_id_seq');


comment on table lease_wx_company_profile is
'小程序公司简介';

comment on column lease_wx_company_profile.Id is
'主键id';

comment on column lease_wx_company_profile.Company_Profile is
'公司简介';

comment on column lease_wx_company_profile.Create_Time is
'创建日期';

comment on column lease_wx_company_profile.Update_Time is
'修改日期';

comment on column lease_wx_company_profile.Create_By is
'创建人';

comment on column lease_wx_company_profile.Update_By is
'修改人';

comment on column lease_wx_company_profile.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_company_profile.Sort is
'排序';


create table lease_wx_title (
Id                   INT8                 not null,
Home_Title           TEXT         null,
Home_Slogan          TEXT         null,
Agent_Title          TEXT         null,
Car_Title            TEXT         null,
Cardetail_Title      TEXT         null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            boolean              null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_TITLE primary key (Id)
);
CREATE SEQUENCE lease_wx_title_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_title  alter column id set default nextval('lease_wx_title_id_seq');

comment on table lease_wx_title is
'小程序标题和口号';

comment on column lease_wx_title.Id is
'主键id';

comment on column lease_wx_title.Create_Time is
'创建日期';

comment on column lease_wx_title.Update_Time is
'修改日期';

comment on column lease_wx_title.Create_By is
'创建人';

comment on column lease_wx_title.Update_By is
'修改人';

comment on column lease_wx_title.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_title.Sort is
'排序';


create table lease_wx_agent_img (
Id                   INT8                 not null,
Agent_Img             TEXT         null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            boolean              null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_AGENT_IMG primary key (Id)
);

CREATE SEQUENCE lease_wx_agent_img_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_agent_img  alter column id set default nextval('lease_wx_agent_img_id_seq');


comment on table lease_wx_agent_img is
'小程序加盟代理';

comment on column lease_wx_agent_img.Id is
'主键id';

comment on column lease_wx_agent_img.Agent_Img is
'加盟代理路径';

comment on column lease_wx_agent_img.Create_Time is
'创建日期';

comment on column lease_wx_agent_img.Update_Time is
'修改日期';

comment on column lease_wx_agent_img.Create_By is
'创建人';

comment on column lease_wx_agent_img.Update_By is
'修改人';

comment on column lease_wx_agent_img.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_agent_img.Sort is
'排序';


create table lease_wx_company_contact (
Id                   INT8                 not null,
Contact_Us           VARCHAR(100)         null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            boolean              null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_COMPANY_CONTACT primary key (Id)
);

CREATE SEQUENCE lease_wx_company_contact_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_company_contact  alter column id set default nextval('lease_wx_company_contact_id_seq');


comment on table lease_wx_company_contact is
'小程序联系我们';

comment on column lease_wx_company_contact.Id is
'主键id';

comment on column lease_wx_company_contact.Contact_Us is
'联系我们';

comment on column lease_wx_company_contact.Create_Time is
'创建日期';

comment on column lease_wx_company_contact.Update_Time is
'修改日期';

comment on column lease_wx_company_contact.Create_By is
'创建人';

comment on column lease_wx_company_contact.Update_By is
'修改人';

comment on column lease_wx_company_contact.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_company_contact.Sort is
'排序';



create table lease_wx_buy_description (
Id                   INT8                 not null,
Buy_Img               TEXT         null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            boolean              null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_BUY_DESCRIPTION primary key (Id)
);

CREATE SEQUENCE lease_wx_buy_description_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_buy_description  alter column id set default nextval('lease_wx_buy_description_id_seq');


comment on table lease_wx_buy_description is
'小程序购买说明';

comment on column lease_wx_buy_description.Id is
'主键id';

comment on column lease_wx_buy_description.Buy_Img is
'图片路径';

comment on column lease_wx_buy_description.Create_Time is
'创建日期';

comment on column lease_wx_buy_description.Update_Time is
'修改日期';

comment on column lease_wx_buy_description.Create_By is
'创建人';

comment on column lease_wx_buy_description.Update_By is
'修改人';

comment on column lease_wx_buy_description.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_buy_description.Sort is
'排序';


create table lease_wx_level (
Id                   INT8                 not null,
Name                 VARCHAR(100)          null,
Type                 INT4                 null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            INT4                 null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_LEVEL primary key (Id)
);

CREATE SEQUENCE lease_wx_level_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_level  alter column id set default nextval('lease_wx_level_id_seq');

comment on table lease_wx_level is
'小程序一级区域';

comment on column lease_wx_level.Id is
'主键id';

comment on column lease_wx_level.Create_Time is
'创建日期';

comment on column lease_wx_level.Update_Time is
'修改日期';

comment on column lease_wx_level.Create_By is
'创建人';

comment on column lease_wx_level.Update_By is
'修改人';

comment on column lease_wx_level.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_level.Sort is
'排序';


create table lease_wx_secondary (
Id                   INT8                 not null,
Level_Id             INT8                 null,
Name                 VARCHAR(100)          null,
Type                 INT4                 null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            INT4                 null,
Sort                 INT4                 null,
constraint PK_LEASE_WX_SECONDARY primary key (Id)
);

CREATE SEQUENCE lease_wx_secondary_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_secondary  alter column id set default nextval('lease_wx_secondary_id_seq');

comment on table lease_wx_secondary is
'小程序二级区域';

comment on column lease_wx_secondary.Id is
'主键id';

comment on column lease_wx_secondary.Create_Time is
'创建日期';

comment on column lease_wx_secondary.Update_Time is
'修改日期';

comment on column lease_wx_secondary.Create_By is
'创建人';

comment on column lease_wx_secondary.Update_By is
'修改人';

comment on column lease_wx_secondary.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_secondary.Sort is
'排序';


create table lease_wx_stores (
Id                   INT8                 not null,
Secondary_Id         INT8                 null,
Name                 VARCHAR(100)          null,
Type                 INT4                 null,
Stores_Level         INT4                 null,
Address              VARCHAR(100)         null,
Img                  TEXT                 null,
Phone                VARCHAR(20)          null,
Create_Time          timestamp            null,
Update_Time          timestamp            null,
Create_By            INT8                 null,
Update_By            INT8                 null,
Is_Enable            INT4                 null,
Sort                 INT4                 null,
Is_Contract_Award    INT4                 null,
Cooperation_Start_Time    timestamp            null,
Cooperation_Year_Limit    INT8            null,
Cooperation_End_Time    timestamp            null,
Business_License_Img    varchar(100)          null,
Business_License_Number    varchar(100)          null,
Charge_Person_Name    varchar(100)          null,
Charge_Person_Id_Card    varchar(100)          null,
Business_License_Adress    varchar(100)          null,
constraint PK_LEASE_WX_STORES primary key (Id)
);


CREATE SEQUENCE lease_wx_stores_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_wx_stores  alter column id set default nextval('lease_wx_stores_id_seq');

comment on table lease_wx_stores is
'小程序门店';

comment on column lease_wx_stores.Id is
'主键id';

comment on column lease_wx_stores.Secondary_Id is
'二级区域id';

comment on column lease_wx_stores.Name is
'门店名称';

comment on column lease_wx_stores.Type is
'类型（1 区域 2 门店）';

comment on column lease_wx_stores.Stores_Level is
'网点级别 1:1级 2:2级';

comment on column lease_wx_stores.Address is
'地址';

comment on column lease_wx_stores.Img is
'图片';

comment on column lease_wx_stores.Phone is
'联系电话';

comment on column lease_wx_stores.Create_Time is
'创建日期';

comment on column lease_wx_stores.Update_Time is
'修改日期';

comment on column lease_wx_stores.Create_By is
'创建人';

comment on column lease_wx_stores.Update_By is
'修改人';

comment on column lease_wx_stores.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_wx_stores.Sort is
'排序';

comment on column lease_wx_stores.Is_Contract_Award is
'合同签约 0:否 1:是';

comment on column lease_wx_stores.Cooperation_Start_Time is
'合作开始日';

comment on column lease_wx_stores.Cooperation_Year_Limit is
'合作年限';

comment on column lease_wx_stores.Cooperation_End_Time is
'合作结束日';

comment on column lease_wx_stores.Business_License_Img is
'营业执照图片';

comment on column lease_wx_stores.Business_License_Number is
'营业执照编号';

comment on column lease_wx_stores.Charge_Person_Name is
'负责人';

comment on column lease_wx_stores.Charge_Person_Id_Card is
'负责人身份证';

comment on column lease_wx_stores.Business_License_Adress is
'营业执照地址';



create table lease_update_monthlyrent (
   Id                   INT8                 not null,
   Contract_Id          INT8                 null,
   User_Id              INT8                 null,
   New_Monthlyrent      DECIMAL(20,2)        null,
   Old_Monthlyrent      DECIMAL(20,2)        null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_UPDATE_MONTHLYRENT primary key (Id)
);


CREATE SEQUENCE lease_update_monthlyrent_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_update_monthlyrent  alter column id set default nextval('lease_update_monthlyrent_id_seq');


comment on table lease_update_monthlyrent is
'小程序融租合同-短信日志';

comment on column lease_update_monthlyrent.Id is
'主键id';

comment on column lease_update_monthlyrent.Contract_Id is
'融租合同主键Id';

comment on column lease_update_monthlyrent.User_Id is
'用户主键Id';

comment on column lease_update_monthlyrent.Create_Time is
'创建日期';

comment on column lease_update_monthlyrent.Update_Time is
'修改日期';

comment on column lease_update_monthlyrent.Create_By is
'创建人';

comment on column lease_update_monthlyrent.Update_By is
'修改人';


/*==============================================================*/
/* Table: lease_account_bank_card                               */
/*==============================================================*/
create table lease_account_bank_card (
   Id                   INT8                 not null,
   Account_Id           INT8                 null,
   Bank_Account_Name    varchar(100)         null,
   Bank_Id              INT8                 null,
   Branch_Bank          varchar(100)         null,
   Back_Card_Number     varchar(100)         null,
   Back_Card_Img        TEXT                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            boolean              null,
   Sort                 INT4                 null,
   Bank_Phone		varchar(100)         null,
   constraint PK_LEASE_ACCOUNT_BANK_CARD primary key (Id)
);


CREATE SEQUENCE lease_account_bank_card_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_account_bank_card  alter column id set default nextval('lease_account_bank_card_id_seq');

comment on table lease_account_bank_card is
'承租人银行卡';

comment on column lease_account_bank_card.Id is
'主键id';

comment on column lease_account_bank_card.Account_Id is
'注册用户/承租人主键id';

comment on column lease_account_bank_card.Bank_Account_Name is
'银行户名';

comment on column lease_account_bank_card.Bank_Id is
'银行主键Id';

comment on column lease_account_bank_card.Branch_Bank is
'银行支行名称';

comment on column lease_account_bank_card.Back_Card_Number is
'银行卡号';

comment on column lease_account_bank_card.Back_Card_Img is
'银行卡图片';

comment on column lease_account_bank_card.Create_Time is
'创建日期';

comment on column lease_account_bank_card.Update_Time is
'修改日期';

comment on column lease_account_bank_card.Create_By is
'创建人';

comment on column lease_account_bank_card.Update_By is
'修改人';

comment on column lease_account_bank_card.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_account_bank_card.Sort is
'排序';

comment on column lease_account_bank_card.Bank_Phone is
'银行预留手机号';

CREATE TABLE lease_account_credit_level (
id              int8            NOT NULL,
account_id      int8            NOT NULL,
level           varchar(100)    COLLATE "default",
remark          text            COLLATE "default",
update_time     timestamp(6),
create_time     timestamp(6)    NOT NULL,
CONSTRAINT lease_account_credit_level_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE lease_account_credit_level_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_account_credit_level  alter column id set default nextval('lease_account_credit_level_id_seq');

COMMENT ON TABLE lease_account_credit_level IS '承租人信用评级';

COMMENT ON COLUMN lease_account_credit_level.id IS '承租人信用评级表id';

COMMENT ON COLUMN lease_account_credit_level.account_id IS '注册用户/承租人主键id';

COMMENT ON COLUMN lease_account_credit_level.level IS '信用评级（A,B,C）';

COMMENT ON COLUMN lease_account_credit_level.remark IS '备注';

COMMENT ON COLUMN lease_account_credit_level.update_time IS '更新时间';

COMMENT ON COLUMN lease_account_credit_level.create_time IS '创建时间';


/*==============================================================*/
/* Table: lease_account_bank_pay_sin                            */
/*==============================================================*/
create table lease_account_bank_pay_sin (
   Id                   INT8                 not null,
   Account_Id           INT8                 null,
   Account_Name         varchar(100)         null,
   Bank_Card_Id          INT8                null,
   Tel                  varchar(100)         null,
   Id_Card              varchar(100)         null,
   Bank_Code            varchar(100)         null,
   Bank_Name            varchar(100)         null,
   Bank_Card_Number     varchar(100)         null,
   Bank_Id              INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Status               INT4                 null,
   Req_Sn	        varchar(100)         null,
   Req_Code	        varchar(100)         null,
   Req_Msg	        varchar(100)         null,
   Agrm_No	        varchar(100)         null,
   Srcreq_Sn	        varchar(100)         null,
   Rnpa_RetRetCode	varchar(100)         null,
   Rnpa_RetErrmsg	varchar(100)         null,
   Type               	INT4		     null,
   Source               INT4                 null,
   Bank_Phone		varchar(100)         null,
   constraint PK_LEASE_ACCOUNT_BANK_PAY_SIN primary key (Id)
);

CREATE SEQUENCE lease_account_bank_pay_sin_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_account_bank_pay_sin  alter column id set default nextval('lease_account_bank_pay_sin_id_seq');

comment on table lease_account_bank_pay_sin is
'承租人银行卡通联支付签约';

comment on column lease_account_bank_pay_sin.Id is
'主键id';

comment on column lease_account_bank_pay_sin.Account_Id is
'注册用户/承租人主键id';

comment on column lease_account_bank_pay_sin.Bank_Card_Id is
'承租人银行卡主键id';

comment on column lease_account_bank_pay_sin.Account_Name is
'姓名';

comment on column lease_account_bank_pay_sin.Tel is
'手机号';

comment on column lease_account_bank_pay_sin.Id_Card is
'身份证号';

comment on column lease_account_bank_pay_sin.Bank_Code is
'银行代码';

comment on column lease_account_bank_pay_sin.Bank_Name is
'银行名称';

comment on column lease_account_bank_pay_sin.Bank_Card_Number is
'银行卡号';

comment on column lease_account_bank_pay_sin.Bank_Id is
'银行主键Id';

comment on column lease_account_bank_pay_sin.Create_Time is
'创建日期';

comment on column lease_account_bank_pay_sin.Update_Time is
'修改日期';

comment on column lease_account_bank_pay_sin.Create_By is
'创建人';

comment on column lease_account_bank_pay_sin.Update_By is
'修改人';

comment on column lease_account_bank_pay_sin.Status is
'状态 0:未签约 1:已签约 2签约中 3:签约失败';

comment on column lease_account_bank_pay_sin.Req_Code is
'签约通联请求状态码';

comment on column lease_account_bank_pay_sin.Req_Msg is
'签约通联请求状态描述';

comment on column lease_account_bank_pay_sin.Agrm_No is
'协议号';

comment on column lease_account_bank_pay_sin.Srcreq_Sn is
'原请求流水、对应申请请求报文中的REQ_SN';

comment on column lease_account_bank_pay_sin.Rnpa_Code is
'签约通联处理状态码';

comment on column lease_account_bank_pay_sin.Rnpa_Msg is
'签约通联处理状态描述';

comment on column lease_account_bank_pay_sin.Type is
'类型: 0系统承租人授权、1:新增承租人授权';

comment on column lease_account_bank_pay_sin.Source is
'操作来源: 0后台系统操作、1:PC、小程序网页操作';


/*==============================================================*/
/* Table: lease_account_bankpaysin_log                          */
/*==============================================================*/
create table lease_account_bankpaysin_log (
   Id                   INT8                 not null,
   Account_Id           INT8                 null,
   Bank_Pay_Sin_Id      INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Status               INT4                 null,
   Req_Sn               varchar(100)         null,
   Agrm_No              varchar(100)         null,
   Req_Msg              varchar(100)         null,
   Req_Code             varchar(100)         null,
   Srcreq_Sn            varchar(100)         null,
   Rnpa_Code            varchar(100)         null,
   Rnpa_Msg             varchar(100)         null,
   constraint PK_LEASE_ACCOUNT_BANKPAYSIN_LO primary key (Id)
);

CREATE SEQUENCE lease_account_bankpaysin_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_account_bankpaysin_log  alter column id set default nextval('lease_account_bankpaysin_log_id_seq');

comment on table lease_account_bankpaysin_log is
'承租人银行卡通联支付签约日志';

comment on column lease_account_bankpaysin_log.Id is
'主键id';

comment on column lease_account_bankpaysin_log.Account_Id is
'注册用户/承租人主键id';

comment on column lease_account_bankpaysin_log.Bank_Pay_Sin_Id is
'承租人银行卡通联支付签约主键id';

comment on column lease_account_bankpaysin_log.Create_Time is
'创建日期';

comment on column lease_account_bankpaysin_log.Update_Time is
'修改日期';

comment on column lease_account_bankpaysin_log.Create_By is
'创建人';

comment on column lease_account_bankpaysin_log.Update_By is
'修改人';

comment on column lease_account_bankpaysin_log.Status is
'状态 0:未签约 1:已签约 2签约中 3:签约失败';

comment on column lease_account_bankpaysin_log.Req_Sn is
'签约流水号';

comment on column lease_account_bankpaysin_log.Agrm_No is
'协议号';

comment on column lease_account_bankpaysin_log.Req_Msg is
'签约通联请求状态描述';

comment on column lease_account_bankpaysin_log.Req_Code is
'签约通联请求状态码';

comment on column lease_account_bankpaysin_log.Srcreq_Sn is
'原请求流水、对应申请请求报文中的REQ_SN';

comment on column lease_account_bankpaysin_log.Rnpa_Code is
'签约通联处理状态码';

comment on column lease_account_bankpaysin_log.Rnpa_Msg is
'签约通联处理状态描述';


/*==============================================================*/
/* Table: lease_bank_allinpay_price_limit                       */
/*==============================================================*/
create table lease_bank_allinpay_price_limit (
   Id                   INT8                 not null,
   Bank_Id              INT8                 null,
   Pay_Way              INT4                 null,
   Price_Limit          DECIMAL(20,2)        null,
   Day_Price_Limit      DECIMAL(20,2)        null,
   Day_Sum              INT4                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_BANK_ALLINPAY_PRICE_LIMIT primary key (Id)
);

CREATE SEQUENCE lease_bank_allinpay_price_limit_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_bank_allinpay_price_limit  alter column id set default nextval('lease_bank_allinpay_price_limit_id_seq');

comment on table lease_bank_allinpay_price_limit is
'通联支付银行额度，包括通联代扣、通联协议支付 的限额';

comment on column lease_bank_allinpay_price_limit.Id is
'主键id';

comment on column lease_bank_allinpay_price_limit.Bank_Id is
'银行主键Id';

comment on column lease_bank_allinpay_price_limit.Pay_Way is
'支付方式 4:通联代扣;9:通联协议支付';

comment on column lease_bank_allinpay_price_limit.Price_Limit is
'每笔金额额度';

comment on column lease_bank_allinpay_price_limit.Day_Price_Limit is
'每日金额额度';

comment on column lease_bank_allinpay_price_limit.Day_Sum_Limit is
'每日笔数额度';

comment on column lease_bank_allinpay_price_limit.Create_Time is
'创建日期';

comment on column lease_bank_allinpay_price_limit.Update_Time is
'修改日期';

comment on column lease_bank_allinpay_price_limit.Create_By is
'创建人';

comment on column lease_bank_allinpay_price_limit.Update_By is
'修改人';


/*==============================================================*/
/* Table: lease_allinpay_split_connect                          */
/*==============================================================*/
create table lease_allinpay_split_connect (
   Id                   INT8                 not null,
   Repayment_Id         INT8                 null,
   Contract_Id          INT8                 null,
   Single_Or_Batch      INT4                 null,
   Batch_Number         VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   Totle_Price          DECIMAL(20,2)        null,
   Number		            INT4                 null,
   Pay_Way              INT4                 null,
   Create_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_Time          timestamp            null,
   Update_By            INT8                 null,
   constraint PK_LEASE_ALLINPAY_SPLIT_CONNEC primary key (Id)
);

CREATE SEQUENCE lease_allinpay_split_connect_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_split_connect  alter column id set default nextval('lease_allinpay_split_connect_id_seq');

comment on table lease_allinpay_split_connect is
'通联支付（协议支付、代扣），已经超额的还款计划明细则被记录';

comment on column lease_allinpay_split_connect.Id is
'主键id';

comment on column lease_allinpay_split_connect.Repayment_Id is
'款项主键id，融租合同-还款计划明细主键id';

comment on column lease_allinpay_split_connect.Contract_Id is
'融租合同主键id';

comment on column lease_allinpay_split_connect.Single_Or_Batch is
'单笔或批量/0:单笔; 1:批量/是否是批扣提交的拆分';

comment on column lease_allinpay_split_connect.Single_Or_Batch is
'扣款提交时的批次号/批扣流水';

comment on column lease_allinpay_split_connect.Sn is
'扣款提交时的记录序号 通联批量代收 每笔金额的 序号/可以看作Sn相同的是同一笔交易操作';

comment on column lease_allinpay_split_connect.Totle_Price is
'总额';

comment on column lease_allinpay_split_connect.Number is
'数量';

comment on column lease_allinpay_split_connect.Pay_Way is
'扣款提交时的支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他';

comment on column lease_allinpay_split_connect.Create_Time is
'创建日期';

comment on column lease_allinpay_split_connect.Create_By is
'创建人';

comment on column lease_allinpay_split_connect.Update_Time is
'修改日期';

comment on column lease_allinpay_split_connect.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_allinpay_split                                  */
/*==============================================================*/
create table lease_allinpay_split (
   Id                   INT8                 not null,
   Repayment_Id         INT8                 null,
   Contract_Id          INT8                 null,
   Account_Id           INT8                 null,
   Split_Connect_Id     INT8                 null,
   Pay_Way              INT4                 null,
   Payment_Result       INT4                 null,
   Totle_Price          DECIMAL(20,2)        null,
   Payment_Result_Msg   text                 null,
   Req_Sn               VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   Status               INT4                 null,
   Repayment_Date       date            	 null,
   Is_Over_Time         INT4                 null,
   Sequence_Number_Start      INT4                 null,
   Sequence_Number_End      INT4                 null,
   Create_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_Time          timestamp            null,
   Update_By            INT8                 null,
   constraint PK_LEASE_ALLINPAY_SPLIT primary key (Id)
);

CREATE SEQUENCE lease_allinpay_split_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_split  alter column id set default nextval('lease_allinpay_split_id_seq');

comment on table lease_allinpay_split is
'通联支付（协议支付、代扣）每笔交易金额超过限额则需要将总金额拆分成多笔小金额交易，每张银行卡都会有限额。此表记录拆分后的每笔交易明细。';

comment on column lease_allinpay_split.Id is
'主键id';

comment on column lease_allinpay_split.Repayment_Id is
'款项主键id，融租合同-还款计划明细主键id';

comment on column lease_allinpay_split.Contract_Id is
'融租合同主键id';

comment on column lease_allinpay_split.Account_Id is
'承租人主键id';

comment on column lease_allinpay_split.Split_Connect_Id is
'记录通联支付超额的还款计划明细主键id';

comment on column lease_allinpay_split.Pay_Way is
'支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付';

comment on column lease_allinpay_split.Payment_Result is
'支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败';

comment on column lease_allinpay_split.Totle_Price is
'金额';

comment on column lease_allinpay_split.Payment_Result_Msg is
'状态结果描述  失败原因描述';

comment on column lease_allinpay_split.Req_Sn is
'通联返回的 文件名/可用于通联流水查询/最后一次操作的文件名，有可能一个款项操作了多次';

comment on column lease_allinpay_split.Sn is
'记录序号 通联批量代收 每笔金额的 序号/最后一次操作的序号，有可能一个款项操作了多次';

comment on column lease_allinpay_split.Status is
'状态 0:无操作1:挂起 2:取消挂起';

comment on column lease_allinpay_split.Repayment_Date is
'扣款日/扣款时间';

comment on column lease_allinpay_split.Is_Over_Time is
'是否已过扣款时间 0否 1是';

comment on column lease_allinpay_split.Sequence_Number_Start is
'交易明细序号总数';

comment on column lease_allinpay_split.Sequence_Number_End is
'交易明细序号顺序';

comment on column lease_allinpay_split.Create_Time is
'创建日期/操作日期';

comment on column lease_allinpay_split.Create_By is
'创建人/操作人';

comment on column lease_allinpay_split.Update_Time is
'修改日期';

comment on column lease_allinpay_split.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_allinpay_split_log                              */
/*==============================================================*/
create table lease_allinpay_split_log (
   Id                   INT8                 not null,
   Allinpay_Split_Id    INT8                 null,
   Repayment_Id         INT8                 null,
   Contract_Id          INT8                 null,
   Totle_Price          DECIMAL(20,2)        null,
   Pay_Way              INT4                 null,
   Status               INT4                 null,
   Ret_Code             VARCHAR(100)         null,
   Err_Msg              VARCHAR(500)         null,
   Back_Time            timestamp            null,
   Single_Or_Batch      INT4                 null,
   Allinpay_Batch_Id    INT8                 null,
   Req_Sn               VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Remarks              text                 null,
   constraint PK_LEASE_ALLINPAY_SPLIT_LOG primary key (Id)
);

CREATE SEQUENCE lease_allinpay_split_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_split_log  alter column id set default nextval('lease_allinpay_split_log_id_seq');

comment on table lease_allinpay_split_log is
'通联支付超额拆分交易明细 支付流水，每一次操作扣款都记录流水';

comment on column lease_allinpay_split_log.Id is
'主键id';

comment on column lease_allinpay_split_log.Allinpay_Split_Id is
'通联支付超额拆分交易明细主键id';

comment on column lease_allinpay_split_log.Repayment_Id is
'款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id';

comment on column lease_allinpay_split_log.Contract_Id is
'融租合同主键id';

comment on column lease_allinpay_split_log.Totle_Price is
'扣款金额';

comment on column lease_allinpay_split_log.Pay_Way is
'支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付';

comment on column lease_allinpay_split_log.Status is
'通联支付状态/0:已提交;1:成功;2:失败';

comment on column lease_allinpay_split_log.Ret_Code is
'通联支付反馈状态码';

comment on column lease_allinpay_split_log.Err_Msg is
'通联支付反馈状态描述';

comment on column lease_allinpay_split_log.Back_Time is
'通联支付反馈状态日期';

comment on column lease_allinpay_split_log.Single_Or_Batch is
'单笔或批量/0:单笔; 1:批量';

comment on column lease_allinpay_split_log.Allinpay_Batch_Id is
'所属批量代收批次主键id';

comment on column lease_allinpay_split_log.Req_Sn is
'通联返回的 文件名/可用于通联流水查询';

comment on column lease_allinpay_split_log.Sn is
'记录序号 通联批量扣款 每笔金额的 序号';

comment on column lease_allinpay_split_log.Create_Time is
'创建日期';

comment on column lease_allinpay_split_log.Update_Time is
'修改日期';

comment on column lease_allinpay_split_log.Create_By is
'创建人';

comment on column lease_allinpay_split_log.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_allinpay_split_batch                            */
/*==============================================================*/
create table lease_allinpay_split_batch (
   Id                   INT8                 not null,
   Batch_Number         VARCHAR(100)         null,
   Receivable_Price     DECIMAL(20,2)        null,
   Receipts_Price       DECIMAL(20,2)        null,
   Fail_Price           DECIMAL(20,2)        null,
   Number               INT4                 null,
   Success_Number       INT4                 null,
   Fail_Number          INT4                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_ALLINPAY_SPLIT_BATCH primary key (Id)
);

CREATE SEQUENCE lease_allinpay_split_batch_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_split_batch  alter column id set default nextval('lease_allinpay_split_batch_id_seq');

comment on table lease_allinpay_split_batch is
'通联支付超额拆分交易明细 批量支付批次统计';

comment on column lease_allinpay_split_batch.Id is
'主键id';

comment on column lease_allinpay_split_batch.Batch_Number is
'批次号/批扣流水';

comment on column lease_allinpay_split_batch.Receivable_Price is
'应扣总额';

comment on column lease_allinpay_split_batch.Receipts_Price is
'实扣总额/成功总额';

comment on column lease_allinpay_split_batch.Fail_Price is
'失败总额';

comment on column lease_allinpay_split_batch.Number is
'数量';

comment on column lease_allinpay_split_batch.Success_Number is
'成功数量';

comment on column lease_allinpay_split_batch.Fail_Number is
'失败数量';

comment on column lease_allinpay_split_batch.Create_Time is
'创建日期';

comment on column lease_allinpay_split_batch.Update_Time is
'修改日期';

comment on column lease_allinpay_split_batch.Create_By is
'创建人';

comment on column lease_allinpay_split_batch.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_allinpay_split_status_log                       */
/*==============================================================*/
create table lease_allinpay_split_status_log (
   Id                   INT8                 not null,
   Allinpay_Split_Log_Id      INT8                 null,
   Create_Time          timestamp            null,
   Create_By            INT8                 null,
   Ret_Code             VARCHAR(100)         null,
   Err_Msg              VARCHAR(500)         null,
   Back_Time            timestamp            null,
   Type                 INT4                 null,
   Payment_Result       INT4                 null,
   Payment_Result_Msg   text                 null,
   constraint PK_LEASE_ALLINPAY_SPLIT_STATUS primary key (Id)
);

CREATE SEQUENCE lease_allinpay_split_status_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_split_status_log  alter column id set default nextval('lease_allinpay_split_status_log_id_seq');

comment on table lease_allinpay_split_status_log is
'通联支付超额拆分交易明细 支付状态流水';

comment on column lease_allinpay_split_status_log.Id is
'主键id';

comment on column lease_allinpay_split_status_log.Allinpay_Split_Log_Id is
'通联支付超额拆分交易明细 支付流水 主键id';

comment on column lease_allinpay_split_status_log.Create_Time is
'创建日期';

comment on column lease_allinpay_split_status_log.Create_By is
'创建人';

comment on column lease_allinpay_split_status_log.Ret_Code is
'通联支付反馈状态码';

comment on column lease_allinpay_split_status_log.Err_Msg is
'通联支付反馈状态描述';

comment on column lease_allinpay_split_status_log.Back_Time is
'通联支付反馈状态日期';

comment on column lease_allinpay_split_status_log.Type is
'代收状态流水 类型 0:提交通联单笔扣款(代扣)的结果;1:提交通联批量扣款(代扣)的结果;2:轮询通联单笔扣款(代扣)的结果;3:轮询通联批量扣款(代扣)的结果;4:提交通联单笔扣款(协议支付)的结果;5:提交通联批量扣款(协议支付)的结果';

comment on column lease_allinpay_split_status_log.Payment_Result is
'支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败';

comment on column lease_allinpay_split_status_log.Payment_Result_Msg is
'状态结果描述  失败原因描述';

/*==============================================================*/
/* Table: lease_allinpay_split_query_log                        */
/*==============================================================*/
create table lease_allinpay_split_query_log (
   Id                   INT8                 not null,
   Allinpay_Split_Log_Id      INT8                 null,
   Repayment_Id         INT8                 null,
   Allinpay_Split_Id  INT8                 null,
   Contract_Id          INT8                 null,
   Status               INT4                 null,
   Ret_Code             VARCHAR(100)         null,
   Err_Msg              VARCHAR(500)         null,
   Back_Time            timestamp            null,
   Req_Sn               VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   constraint PK_LEASE_ALLINPAY_SPLIT_QUERY_ primary key (Id)
);

CREATE SEQUENCE lease_allinpay_split_query_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_split_query_log  alter column id set default nextval('lease_allinpay_split_query_log_id_seq');

comment on table lease_allinpay_split_query_log is
'通联支付超额拆分交易明细 通联轮询流水';

comment on column lease_allinpay_split_query_log.Id is
'主键id';

comment on column lease_allinpay_split_query_log.Allinpay_Split_Log_Id is
'通联支付超额拆分交易明细 支付流水 主键id';

comment on column lease_allinpay_split_query_log.Repayment_Id is
'款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id';

comment on column lease_allinpay_split_query_log.Allinpay_Split_Id is
'通联支付超额拆分交易明细主键id';

comment on column lease_allinpay_split_query_log.Contract_Id is
'融租合同主键id';

comment on column lease_allinpay_split_log.Status is
'通联支付状态/0:已提交;1:成功;2:失败';

comment on column lease_allinpay_split_log.Ret_Code is
'通联支付反馈状态码';

comment on column lease_allinpay_split_log.Err_Msg is
'通联支付反馈状态描述';

comment on column lease_allinpay_split_log.Back_Time is
'通联支付反馈状态日期';

comment on column lease_allinpay_split_log.Req_Sn is
'通联返回的 文件名/可用于通联流水查询';

comment on column lease_allinpay_split_log.Sn is
'记录序号 通联批量扣款 每笔金额的 序号';


/*==============================================================*/
/* Table: lease_allinpay_split_connect                          */
/*==============================================================*/
create table lease_allinpay_split_connect (
   Id                   INT8                 not null,
   Repayment_Id         INT8                 null,
   Contract_Id          INT8                 null,
   Single_Or_Batch      INT4                 null,
   Batch_Number         VARCHAR(100)         null,
   Totle_Price          DECIMAL(20,2)        null,
   Number		        INT4                 null,
   Pay_Way              INT4                 null,
   Create_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_Time          timestamp            null,
   Update_By            INT8                 null,
   constraint PK_LEASE_ALLINPAY_SPLIT_CONNEC primary key (Id)
);

CREATE SEQUENCE lease_allinpay_split_connect_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_allinpay_split_connect  alter column id set default nextval('lease_allinpay_split_connect_id_seq');

comment on table lease_allinpay_split_connect is
'通联支付（协议支付、代扣），已经超额的还款计划明细则被记录';

comment on column lease_allinpay_split_connect.Id is
'主键id';

comment on column lease_allinpay_split_connect.Repayment_Id is
'款项主键id，融租合同-还款计划明细主键id';

comment on column lease_allinpay_split_connect.Contract_Id is
'融租合同主键id';

comment on column lease_allinpay_split_connect.Single_Or_Batch is
'单笔或批量/0:单笔; 1:批量/是否是批扣提交的拆分';

comment on column lease_allinpay_split_connect.Single_Or_Batch is
'扣款提交时的批次号/批扣流水';

comment on column lease_allinpay_split_connect.Totle_Price is
'总额';

comment on column lease_allinpay_split_connect.Number is
'数量';

comment on column lease_allinpay_split_connect.Pay_Way is
'扣款提交时的支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他';

comment on column lease_allinpay_split_connect.Create_Time is
'创建日期';

comment on column lease_allinpay_split_connect.Create_By is
'创建人';

comment on column lease_allinpay_split_connect.Update_Time is
'修改日期';

comment on column lease_allinpay_split_connect.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_manual_deductions_statist                       */
/*==============================================================*/
create table lease_manual_deductions_statist (
   Id                   INT8                 not null,
   Number               VARCHAR(100)                 DEFAULT 0,
   Total_Sum            INT4                 DEFAULT 0,
   Success_Number            INT4                 DEFAULT 0,
   Fail_Number            INT4                 DEFAULT 0,
   Total_Price          DECIMAL(20,2)        DEFAULT 0,
   Receipts_Price          DECIMAL(20,2)        DEFAULT 0,
   Fail_Price          DECIMAL(20,2)        DEFAULT 0,
   Is_Check             INT4                 DEFAULT 0,
   Is_Pay               INT4                 DEFAULT 0,
   Is_Download_Result   INT4                 DEFAULT 0,
   Is_Import_Again      INT4                 DEFAULT 0,
   Create_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_Time          timestamp            null,
   Update_By            INT8                 null,
   Remarks              text                 null,
   constraint PK_LEASE_MANUAL_DEDUCTIONS_STA primary key (Id)
);

CREATE SEQUENCE lease_manual_deductions_statist_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_manual_deductions_statist  alter column id set default nextval('lease_manual_deductions_statist_id_seq');

comment on table lease_manual_deductions_statist is
'手动扣款统计';

comment on column lease_manual_deductions_statist.Id is
'主键id';

comment on column lease_manual_deductions_statist.Number is
'任务ID/编号';

comment on column lease_manual_deductions_statist.Total_Sum is
'总数量';

comment on column lease_manual_deductions_statist.Success_Number is
'成功数量';

comment on column lease_manual_deductions_statist.Fail_Number is
'失败数量';

comment on column lease_manual_deductions_statist.Total_Price is
'总金额/应扣总额';

comment on column lease_manual_deductions_statist.Receipts_Price is
'已扣总额/实扣总额/成功总额';

comment on column lease_manual_deductions_statist.Fail_Price is
'失败总额';

comment on column lease_manual_deductions_statist.Is_Check is
'是否已下载核对 0否 1是';

comment on column lease_manual_deductions_statist.Is_Pay is
'是否已提交支付 0否 1是';

comment on column lease_manual_deductions_statist.Is_Download_Result is
'是否已下载结果 0否 1是';

comment on column lease_manual_deductions_statist.Is_Import_Again is
'重新上传状态 0不能操作 ; 1能操作';

comment on column lease_manual_deductions_statist.Create_Time is
'创建日期';

comment on column lease_manual_deductions_statist.Create_By is
'创建人';

comment on column lease_manual_deductions_statist.Update_Time is
'修改日期';

comment on column lease_manual_deductions_statist.Update_By is
'修改人';

comment on column lease_manual_deductions_statist.Remarks is
'备注';

/*==============================================================*/
/* Table: lease_manual_deductions_data                          */
/*==============================================================*/

create table lease_manual_deductions_data (
   Id                   INT8                 not null,
   Statist_Id           INT8                 not null,
   Repayment_Id         INT8                 null,
   Repayment_Status_Id  INT8                 null,
   Contract_Id          INT8                 null,
   Branch_Company       VARCHAR(100)         null,
   Bank_Account_Name    VARCHAR(100)         null,
   Bank_Phone           VARCHAR(100)         null,
   Really_Bank_Phone           VARCHAR(100)         null,
   Bank_Code            VARCHAR(100)         null,
   Back_Card_Number     VARCHAR(100)         null,
   Agrm_No              VARCHAR(100)         null,
   Id_Card              VARCHAR(100)         null,
   Total_Price          DECIMAL(20,2)        null,
   Overdue_Day          INT4                 null,
   Plate_Number         varchar(100)         null,
   Repayment_Date       timestamp            null,
   Really_Repayment_Date timestamp            null,
   Payment_Result       INT4                 null,
   Payment_Result_Msg   VARCHAR(100)         null,
   Req_Sn               VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   Pay_Way              INT4                 null,
   Is_Operation         INT4                 null,
   Is_Operation_Msg     VARCHAR(100)         null,
   Is_Exist_Contract    INT4                 null,
   Is_Sign              INT4                 null,
   Is_Excess_Limit      INT4                 null,
   Is_Price_Err         INT4                 null,
   Is_Repayment_Date_Err INT4                 null,
   Is_Bank_Phone_Err    INT4                 null,
   Create_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_Time          timestamp            null,
   Update_By            INT8                 null,
   constraint PK_LEASE_MANUAL_DEDUCTIONS_DAT primary key (Id)
);

CREATE SEQUENCE lease_manual_deductions_data_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_manual_deductions_data  alter column id set default nextval('lease_manual_deductions_data_id_seq');

comment on table lease_manual_deductions_data is
'手动扣款提交的数据';

comment on column lease_manual_deductions_data.Id is
'主键id';

comment on column lease_manual_deductions_data.Statist_Id is
'手动扣款统计主键id';

comment on column lease_manual_deductions_data.Repayment_Id is
'款项主键id，融租合同-还款计划明细主键id， 如果提交的车牌有合同则记录';

comment on column lease_manual_deductions_data.Repayment_Status_Id is
'支付状态汇总管理主键id，如果提交的车牌有合同则记录';

comment on column lease_manual_deductions_data.Contract_Id is
'融租合同主键id ，如果提交的车牌有合同则记录';

comment on column lease_manual_deductions_data.Branch_Company is
'注册用户/承租人主键id/下单人';

comment on column lease_manual_deductions_data.Bank_Account_Name is
'银行卡用户名';

comment on column lease_manual_deductions_data.Bank_Phone is
'银行预留手机号';

comment on column lease_manual_deductions_data.Really_Bank_Phone is
'系统银行预留手机号';

comment on column lease_manual_deductions_data.Bank_Code is
'银行编码';

comment on column lease_manual_deductions_data.Back_Card_Number is
'银行编码';

comment on column lease_manual_deductions_data.Agrm_No is
'签约协议号';

comment on column lease_manual_deductions_data.Id_Card is
'身份证号';

comment on column lease_manual_deductions_data.Total_Price is
'总金额';

comment on column lease_manual_deductions_data.Overdue_Day is
'逾期天数';

comment on column lease_manual_deductions_data.Plate_Number is
'车牌号';

comment on column lease_manual_deductions_data.Repayment_Date is
'扣款日期';

comment on column lease_manual_deductions_data.Really_Repayment_Date is
'系统当月扣款日期';

comment on column lease_manual_deductions_data.Payment_Result is
'支付状态/结果  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败';

comment on column lease_manual_deductions_data.Payment_Result_Msg is
'状态结果描述  失败原因描述';

comment on column lease_manual_deductions_data.Req_Sn is
'通联返回的 文件名/可用于通联流水查询';

comment on column lease_manual_deductions_data.Sn is
'记录序号 通联批量代收 每笔金额的 序号';

comment on column lease_manual_deductions_data.Pay_Way is
'支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付';

comment on column lease_manual_deductions_data.Is_Operation is
'能否提交 0否 1是';

comment on column lease_manual_deductions_data.Is_Operation_Msg is
'能否提交原因';

comment on column lease_manual_deductions_data.Is_Exist_Contract is
'合同是否存在 0否 1是';

comment on column lease_manual_deductions_data.Is_Sign is
'银行卡是否签约 0否 1是';

comment on column lease_manual_deductions_data.Is_Excess_Limit is
'是否超额 0否 1是';

comment on column lease_manual_deductions_data.Is_Price_Err is
'金额是否异常 0否 1是';

comment on column lease_manual_deductions_data.Is_Repayment_Date_Err is
'扣款日是否异常 0否 1是';

comment on column lease_manual_deductions_data.Is_Bank_Phone_Err is
'银行预留手机是否异常 0否 1是';

comment on column lease_manual_deductions_data.Create_Time is
'创建日期';

comment on column lease_manual_deductions_data.Create_By is
'创建人';

comment on column lease_manual_deductions_data.Update_Time is
'修改日期';

comment on column lease_manual_deductions_data.Update_By is
'修改人';


/*==============================================================*/
/* Table: lease_manual_deductions_pay_log                       */
/*==============================================================*/
create table lease_manual_deductions_pay_log (
   Id                   INT8                 not null,
   Data_Id              INT8                 not null,
   Total_Price          DECIMAL(20,2)        null,
   Pay_Way              INT4                 null,
   Status               INT4                 null,
   Ret_Code             VARCHAR(100)         null,
   Err_Msg              VARCHAR(500)         null,
   Back_Time            timestamp            null,
   Req_Sn               VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_MANUAL_DEDUCTIONS_PAY primary key (Id)
);

CREATE SEQUENCE lease_manual_deductions_pay_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_manual_deductions_pay_log  alter column id set default nextval('lease_manual_deductions_pay_log_id_seq');

comment on table lease_manual_deductions_pay_log is
'手动扣款，每一次操作扣款都记录流水';

comment on column lease_manual_deductions_pay_log.Id is
'主键id';

comment on column lease_manual_deductions_pay_log.Data_Id is
'手动扣款提交的数据主键id';

comment on column lease_manual_deductions_pay_log.Total_Price is
'金额';

comment on column lease_manual_deductions_pay_log.Pay_Way is
'支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他';

comment on column lease_manual_deductions_pay_log.Status is
'通联支付状态/0:已提交;1:成功;2:失败';

comment on column lease_manual_deductions_pay_log.Ret_Code is
'通联支付反馈状态码';

comment on column lease_manual_deductions_pay_log.Err_Msg is
'通联支付反馈状态描述';

comment on column lease_manual_deductions_pay_log.Back_Time is
'通联支付反馈状态日期';

comment on column lease_manual_deductions_pay_log.Req_Sn is
'通联返回的 文件名/可用于通联流水查询';

comment on column lease_manual_deductions_pay_log.Sn is
'记录序号 通联批量代收 每笔金额的 序号';

comment on column lease_manual_deductions_pay_log.Create_Time is
'创建日期';

comment on column lease_manual_deductions_pay_log.Update_Time is
'修改日期';

comment on column lease_manual_deductions_pay_log.Create_By is
'创建人';

comment on column lease_manual_deductions_pay_log.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_manual_deducti_status_log                       */
/*==============================================================*/
create table lease_manual_deducti_status_log (
   Id                   INT8                 not null,
   Pay_Log_Id           INT8                 null,
   Ret_Code             VARCHAR(100)         null,
   Err_Msg              VARCHAR(500)         null,
   Back_Time            timestamp            null,
   Type                 INT4                 null,
   Payment_Result       INT4                 null,
   Payment_Result_Msg   text                 null,
   Create_Time          timestamp            null,
   Create_By            INT8                 null,
   constraint PK_LEASE_MANUAL_DEDUCTI_STATUS primary key (Id)
);

CREATE SEQUENCE lease_manual_deducti_status_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_manual_deducti_status_log  alter column id set default nextval('lease_manual_deducti_status_log_id_seq');

comment on table lease_manual_deducti_status_log is
'手动扣款支付状态流水';

comment on column lease_manual_deducti_status_log.Id is
'主键id';

comment on column lease_manual_deducti_status_log.Pay_Log_Id is
'手动扣款支付流水主键id';

comment on column lease_manual_deducti_status_log.Ret_Code is
'通联支付反馈状态码';

comment on column lease_manual_deducti_status_log.Err_Msg is
'通联支付反馈状态描述';

comment on column lease_manual_deducti_status_log.Back_Time is
'通联支付反馈状态日期';

comment on column lease_manual_deducti_status_log.Type is
'状态流水 类型 0:提交手动扣款的结果;1:轮询手动扣款的结果';

comment on column lease_manual_deducti_status_log.Payment_Result is
'支付状态/结果  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败';

comment on column lease_manual_deducti_status_log.Payment_Result_Msg is
'状态结果描述  失败原因描述';

comment on column lease_manual_deducti_status_log.Create_Time is
'创建日期';

comment on column lease_manual_deducti_status_log.Create_By is
'创建人';


/*==============================================================*/
/* Table: lease_manual_deductio_query_log                       */
/*==============================================================*/
create table lease_manual_deductio_query_log (
   Id                   INT8                 not null,
   Data_Id              INT8                 not null,
   Pay_Log_Id           INT8                 null,
   Status               INT4                 null,
   Ret_Code             VARCHAR(100)         null,
   Err_Msg              VARCHAR(500)         null,
   Back_Time            timestamp            null,
   Req_Sn               VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   constraint PK_LEASE_MANUAL_DEDUCTIO_QUERY primary key (Id)
);

CREATE SEQUENCE lease_manual_deductio_query_log_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_manual_deductio_query_log  alter column id set default nextval('lease_manual_deductio_query_log_id_seq');

comment on table lease_manual_deductio_query_log is
'手动扣款通联轮询款项支付状态，支付的时候记录的代收流水的状态不是通联最后的支付状态，通联规定每笔款都要在支付后10分钟查询结果，这里就记录查询结果的状态，每一条支付流水都对应一条轮询流水';

comment on column lease_manual_deductio_query_log.Id is
'主键id';

comment on column lease_manual_deductio_query_log.Data_Id is
'手动扣款提交的数据主键id';

comment on column lease_manual_deductio_query_log.Pay_Log_Id is
'手动扣款支付流水主键id';

comment on column lease_manual_deductio_query_log.Status is
'通联支付状态/0:已提交;1:成功;2:失败';

comment on column lease_manual_deducti_status_log.Ret_Code is
'通联支付反馈状态码';

comment on column lease_manual_deducti_status_log.Err_Msg is
'通联支付反馈状态描述';

comment on column lease_manual_deducti_status_log.Back_Time is
'通联支付反馈状态日期';

comment on column lease_manual_deductions_pay_log.Req_Sn is
'通联返回的 文件名/可用于通联流水查询';

comment on column lease_manual_deductions_pay_log.Sn is
'记录序号 通联批量代收 每笔金额的 序号';

/*==============================================================*/
/* Table: lease_scheme_repayment_history                               */
/*==============================================================*/
create table lease_scheme_repayment_history (
	Id                   INT8                 not null,
	History_Id int8,
	Contract_Id int8,
	Lessee_Id int8,
	Period int4,
	Return_Principal numeric(20,2),
	Return_Interest numeric(20,2),
	Total numeric(20,2),
	Residual_Principal numeric(20,2),
	Repayment_Date date,
	Overdue int2 DEFAULT 1,
	Overdue_Day int4 DEFAULT 0,
	Loan_Amount numeric(20,2),
	Annual_Interest numeric(20,2),
	Create_Time    timestamp            null,
	Update_Time    timestamp            null,
	Create_By int8,
	Update_By int8,
	History_Create_Time    timestamp            null,
	History_Update_Time    timestamp            null,
	History_Create_By int8,
	History_Update_By int8,
	Sort int4,
	Is_Enable bool,
	Vsersion_Number      INT4                 DEFAULT 0,
	CONSTRAINT "PK_LEASE_SCHEME_REPAYMENT_HISTORY" PRIMARY KEY ("id")
);

CREATE SEQUENCE lease_scheme_repayment_history_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_repayment_history alter column id set default nextval('lease_scheme_repayment_history_id_seq');

COMMENT ON TABLE lease_scheme_repayment_history IS '根据融租合同数据生成月租还款计划明细 历史';

COMMENT ON COLUMN lease_scheme_repayment_history.Id IS '主键id';

COMMENT ON COLUMN lease_scheme_repayment_history.History_Id IS '上一版本的还款计划明细主键ID';

COMMENT ON COLUMN lease_scheme_repayment_history.Contract_Id IS '合同主键ID';

COMMENT ON COLUMN lease_scheme_repayment_history.Lessee_Id IS '承租人主键Id';

COMMENT ON COLUMN lease_scheme_repayment_history.Period IS '分期数';

COMMENT ON COLUMN lease_scheme_repayment_history.Return_Principal IS '归还本金';

COMMENT ON COLUMN lease_scheme_repayment_history.Return_Interest IS '归还利息';

COMMENT ON COLUMN lease_scheme_repayment_history.Total IS '合计';

COMMENT ON COLUMN lease_scheme_repayment_history.Residual_Principal IS '剩余本金';

COMMENT ON COLUMN lease_scheme_repayment_history.Repayment_Date IS '还款日期';

COMMENT ON COLUMN lease_scheme_repayment_history.Overdue IS '是否逾期 0 是 1 否';

COMMENT ON COLUMN lease_scheme_repayment_history.Overdue_Day IS '逾期天数';

COMMENT ON COLUMN lease_scheme_repayment_history.Loan_Amount IS '贷款金额';

COMMENT ON COLUMN lease_scheme_repayment_history.Annual_Interest IS '年利率';

COMMENT ON COLUMN lease_scheme_repayment_history.Create_Time IS '创建日期';

COMMENT ON COLUMN lease_scheme_repayment_history.Update_Time IS '修改日期';

COMMENT ON COLUMN lease_scheme_repayment_history.Create_By IS '创建人';

COMMENT ON COLUMN lease_scheme_repayment_history.Update_By IS '修改人';

COMMENT ON COLUMN lease_scheme_repayment_history.History_Create_Time IS '上一版本的创建日期';

COMMENT ON COLUMN lease_scheme_repayment_history.History_Update_Time IS '上一版本的修改日期';

COMMENT ON COLUMN lease_scheme_repayment_history.History_Create_By IS '上一版本的创建人';

COMMENT ON COLUMN lease_scheme_repayment_history.History_Update_By IS '上一版本的修改人';

COMMENT ON COLUMN lease_scheme_repayment_history.Sort IS '排序';

COMMENT ON COLUMN lease_scheme_repayment_history.Is_Enable IS '状态 0:禁用 1:启用';

comment on column lease_scheme_repayment_history.Vsersion_Number IS '数据版本号';

/*==============================================================*/
/* Table: lease_scheme_repayment_status                               */
/*==============================================================*/
create table lease_scheme_repayment_status_h (
   Id                   INT8                 not null,
   History_Repayment_Status_Id         INT8                 null,
   Repayment_Id         INT8                 null,
   Contract_Id          INT8                 null,
   Totle_Price			DECIMAL(20,2)		 null,
   Pay_Way              INT4                 null,
   Type                 INT4                 null,
   Payment_Result       INT4                 null,
   Payment_Result_Msg   text                 null,
   Req_Sn               VARCHAR(100)         null,
   Sn                   VARCHAR(100)         null,
   Create_Time          timestamp(6)            	 null,
   Create_By            INT8                 null,
   Update_Time          timestamp            null,
   Update_By            INT8                 null,
   History_Create_Time          timestamp(6)            	 null,
   History_Create_By            INT8                 null,
   History_Update_Time          timestamp            null,
   History_Update_By            INT8                 null,
   Vsersion_Number      INT4                 DEFAULT 0,
   constraint PK_LEASE_SCHEME_REPAYMENT_STATUS_H primary key (Id)
);

CREATE SEQUENCE lease_scheme_repayment_status_h_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_scheme_repayment_status_h alter column id set default nextval('lease_scheme_repayment_status_h_id_seq');

comment on table lease_scheme_repayment_status_h is
'支付状态汇总管理 历史';

comment on column lease_scheme_repayment_status_h.Id is
'主键id';

comment on column lease_scheme_repayment_status_h.Repayment_Id is
'款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款主键id';

comment on column lease_scheme_repayment_status_h.History_Repayment_Status_Id is
'上一版本的支付状态汇总管理主键id';

comment on column lease_scheme_repayment_status_h.Contract_Id is
'融租合同主键id';

comment on column lease_scheme_repayment_status_h.Totle_Price is
'合计金额';

comment on column lease_scheme_repayment_status_h.Pay_Way is
'支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他';

comment on column lease_scheme_repayment_status_h.Type is
'款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/月租的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款';

comment on column lease_scheme_repayment_status_h.Payment_Result is
'支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败';

comment on column lease_scheme_repayment_status_h.Payment_Result_Msg is
'状态结果描述  失败原因描述';

comment on column lease_scheme_repayment_status_h.Req_Sn is
'通联返回的 文件名/可用于通联流水查询/最后一次操作的文件名，有可能一个款项操作了多次';

comment on column lease_scheme_repayment_status_h.Sn is
'记录序号 通联批量代收 每笔金额的 序号/最后一次操作的序号，有可能一个款项操作了多次';

comment on column lease_scheme_repayment_status_h.Create_Time is
'创建日期';

comment on column lease_scheme_repayment_status_h.Create_By is
'创建人';

comment on column lease_scheme_repayment_status_h.Update_Time is
'修改日期';

comment on column lease_scheme_repayment_status_h.Update_By is
'修改人';

COMMENT ON COLUMN lease_scheme_repayment_status_h.History_Create_Time IS '上一版本的创建日期';

COMMENT ON COLUMN lease_scheme_repayment_status_h.History_Update_Time IS '上一版本的修改日期';

COMMENT ON COLUMN lease_scheme_repayment_status_h.History_Create_By IS '上一版本的创建人';

COMMENT ON COLUMN lease_scheme_repayment_status_h.History_Update_By IS '上一版本的修改人';

comment on column lease_scheme_repayment_status_h.Vsersion_Number IS '数据版本号';


/*==============================================================*/
/* Table: lease_contract_deal_end                               */
/*==============================================================*/
create table lease_contract_deal_end (
   Id                   INT8                 not null,
   Contract_Id          INT8                 null,
   Car_Id               INT8                 null,
   Deal_Way             INT8                 null,
   Deal_Remarks         text                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_CONTRACT_DEAL_END primary key (Id)
);

CREATE SEQUENCE lease_contract_deal_end_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_deal_end alter column id set default nextval('lease_contract_deal_end_id_seq');

comment on table lease_contract_deal_end is
'贷后合同管理-结束处置';

comment on column lease_contract_deal_end.Id is
'主键id';

comment on column lease_contract_deal_end.Contract_Id is
'融租合同主键id';

comment on column lease_contract_deal_end.Car_Id is
'车辆主键id';

comment on column lease_contract_deal_end.Deal_Way is
'处置方案 0还款中 1待过户 2过户结束 3待挂靠结束 4提前还款结束 5其他到期结束';

comment on column lease_contract_deal_end.Deal_Remarks is
'处置备注';

comment on column lease_contract_deal_end.Create_Time is
'创建日期';

comment on column lease_contract_deal_end.Update_Time is
'修改日期';

comment on column lease_contract_deal_end.Create_By is
'创建人';

comment on column lease_contract_deal_end.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_contract_car_callback                           */
/*==============================================================*/
create table lease_contract_car_callback (
   Id                   INT8                 not null,
   Dual_Number          INT4         null,
   Contract_Id          INT8                 null,
   Car_Id               INT8                 null,
   Reason               TEXT                 null,
   Approval_Opinion     TEXT                 null,
   Remarks              text                 null,
   Callback_Name        VARCHAR(100)         null,
   Callback_Time        timestamp            null,
   Callback_Way         INT4                 null,
   Deal_Way             INT4                 default 1,
   Car_Guidance_Price   DECIMAL(20,2)        null,
   Driving_License      timestamp            null,
   Kilometre_Number     INT4                 null,
   Residual_Principal   DECIMAL(20,2)        null,
   Evaluation_Price     DECIMAL(20,2)        null,
   Jq_Insurance_ExpireDate timestamp            null,
   Commercial_Insurance_ExpireDate timestamp            null,
   Sec_Commercial_Insurance_Expire timestamp            null,
   Monthly_Rent         DECIMAL(20,2)        null,
   Liquidated_Damages   DECIMAL(20,2)        null,
   Callback_Expenses    DECIMAL(20,2)        null,
   Monthly_Rent_Deposit DECIMAL(20,2)        null,
   Callback_Cost        DECIMAL(20,2)        null,
   Violation_Expenses   DECIMAL(20,2)        null,
   Deal_Remarks         text                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_CONTRACT_CAR_CALLBACK primary key (Id)
);

CREATE SEQUENCE lease_contract_car_callback_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_car_callback alter column id set default nextval('lease_contract_car_callback_id_seq');

comment on table lease_contract_car_callback is
'贷后车辆管理-收车';

comment on column lease_contract_car_callback.Id is
'主键id';

comment on column lease_contract_car_callback.Dual_Number is
'处理编号';

comment on column lease_contract_car_callback.Contract_Id is
'融租合同主键id';

comment on column lease_contract_car_callback.Car_Id is
'车辆主键id';

comment on column lease_contract_car_callback.Reason is
'收车原因';

comment on column lease_contract_car_callback.Approval_Opinion is
'资产部收车审批意见';

comment on column lease_contract_car_callback.Remarks is
'备注';

comment on column lease_contract_car_callback.Callback_Name is
'收车人';

comment on column lease_contract_car_callback.Callback_Time is
'收车时间';

comment on column lease_contract_car_callback.Callback_Way is
'收车方式 0客户交回 0赎车收回 2委托收回 3自主收回';

comment on column lease_contract_car_callback.Deal_Way is
'处置方式 0已回收待处置 1退回 2待改期数 3断供（待转租/待转卖） 4取消回收';

comment on column lease_contract_car_callback.Car_Guidance_Price is
'车辆指导价';

comment on column lease_contract_car_callback.Driving_License is
'行驶证注册日期';

comment on column lease_contract_car_callback.Kilometre_Number is
'公里数';

comment on column lease_contract_car_callback.Residual_Principal is
'贷款剩余本金';

comment on column lease_contract_car_callback.Evaluation_Price is
'评估价';

comment on column lease_contract_car_callback.Jq_Insurance_ExpireDate is
'交强险到期日期';

comment on column lease_contract_car_callback.Commercial_Insurance_ExpireDate is
'商业险#1到期日期';

comment on column lease_contract_car_callback.Sec_Commercial_Insurance_Expire is
'商业险#2到期日期';

comment on column lease_contract_car_callback.Monthly_Rent is
'月租';

comment on column lease_contract_car_callback.Liquidated_Damages is
'违约金';

comment on column lease_contract_car_callback.Callback_Expenses is
'收车费';

comment on column lease_contract_car_callback.Monthly_Rent_Deposit is
'月租押金';

comment on column lease_contract_car_callback.Callback_Cost is
'收车成本';

comment on column lease_contract_car_callback.Violation_Expenses is
'违章处理';

comment on column lease_contract_car_callback.Deal_Remarks is
'处置备注';

comment on column lease_contract_car_callback.Create_Time is
'创建日期';

comment on column lease_contract_car_callback.Update_Time is
'修改日期';

comment on column lease_contract_car_callback.Create_By is
'创建人';

comment on column lease_contract_car_callback.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_contract_car_lose                               */
/*==============================================================*/
create table lease_contract_car_lose (
   Id                   INT8                 not null,
   Dual_Number          INT4         null,
   Contract_Id          INT8                 null,
   Car_Id               INT8                 null,
   Remarks              text                 null,
   Deal_Way             INT4                 default 1,
   Deal_Remarks         text                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_CONTRACT_CAR_LOSE primary key (Id)
);

CREATE SEQUENCE lease_contract_car_lose_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_car_lose alter column id set default nextval('lease_contract_car_lose_id_seq');

comment on table lease_contract_car_lose is
'贷后车辆管理-丢失';

comment on column lease_contract_car_lose.Id is
'主键id';

comment on column lease_contract_car_callback.Dual_Number is
'处理编号';

comment on column lease_contract_car_lose.Contract_Id is
'融租合同主键id';

comment on column lease_contract_car_lose.Car_Id is
'车辆主键id';

comment on column lease_contract_car_lose.Remarks is
'丢失备注';

comment on column lease_contract_car_lose.Deal_Way is
'处置方式 0丢失中 1找回续租 2找回断供（待转租/待转卖） 3丢失结束 4取消丢失';

comment on column lease_contract_car_lose.Deal_Remarks is
'处置备注';

comment on column lease_contract_car_lose.Create_Time is
'创建日期';

comment on column lease_contract_car_lose.Update_Time is
'修改日期';

comment on column lease_contract_car_lose.Create_By is
'创建人';

comment on column lease_contract_car_lose.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_contract_car_scrap                              */
/*==============================================================*/
create table lease_contract_car_scrap (
   Id                   INT8                 not null,
   Dual_Number          INT4        null,
   Contract_Id          INT8                 null,
   Car_Id               INT8                 null,
   Remarks              text                 null,
   Deal_Way             INT4                 default 1,
   Deal_Remarks         text                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_CONTRACT_CAR_SCRAP primary key (Id)
);

CREATE SEQUENCE lease_contract_car_scrap_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_car_scrap alter column id set default nextval('lease_contract_car_scrap_id_seq');

comment on table lease_contract_car_scrap is
'贷后车辆管理-报废';

comment on column lease_contract_car_scrap.Id is
'主键id';

comment on column lease_contract_car_scrap.Dual_Number is
'处理编号';

comment on column lease_contract_car_scrap.Contract_Id is
'融租合同主键id';

comment on column lease_contract_car_scrap.Car_Id is
'车辆主键id';

comment on column lease_contract_car_scrap.Remarks is
'报废备注';

comment on column lease_contract_car_scrap.Deal_Way is
'处置方式 0登记为报废中 1报废结束 2取消报废登记';

comment on column lease_contract_car_scrap.Deal_Remarks is
'处置备注';

comment on column lease_contract_car_scrap.Create_Time is
'创建日期';

comment on column lease_contract_car_scrap.Update_Time is
'修改日期';

comment on column lease_contract_car_scrap.Create_By is
'创建人';

comment on column lease_contract_car_scrap.Update_By is
'修改人';

/*==============================================================*/
/* Table: lease_contract_income_expe                            */
/*==============================================================*/
create table lease_contract_income_expe (
   Id                   INT8                 not null,
   Contract_Id          INT8                 null,
   Car_Id               INT8                 null,
   Type                 INT4                 null,
   Name                 VARCHAR(100)         null,
   Price                DECIMAL(20,2)        null,
   Source               INT4                 null,
   Source_Id               INT8                 null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   constraint PK_LEASE_CONTRACT_INCOME_EXPE primary key (Id)
);

CREATE SEQUENCE lease_contract_income_expe_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_contract_income_expe alter column id set default nextval('lease_contract_income_expe_id_seq');

comment on table lease_contract_income_expe is
'贷后车辆管理-收入和支出';

comment on column lease_contract_income_expe.Id is
'主键id';

comment on column lease_contract_income_expe.Contract_Id is
'融租合同主键id';

comment on column lease_contract_income_expe.Car_Id is
'车辆主键id';

comment on column lease_contract_income_expe.Type is
'类型0收入/1支出';

comment on column lease_contract_income_expe.Name is
'款项名称';

comment on column lease_contract_income_expe.Price is
'金额';

comment on column lease_contract_income_expe.Source is
'所属来源1:丢失 2:报废 3:结束处置';

comment on column lease_contract_income_expe.Source_Id is
'所属来源主键Id';

comment on column lease_contract_income_expe.Create_Time is
'创建日期';

comment on column lease_contract_income_expe.Update_Time is
'修改日期';

comment on column lease_contract_income_expe.Create_By is
'创建人';

comment on column lease_contract_income_expe.Update_By is
'修改人';

create table lease_organization_structure (
   Id                   INT8                 not null,
   Number               varchar(100)         null,
   Name                 varchar(100)         null,
   Parent_Id            INT8                 null,
   Leader_Id            INT8                 null,
   Leader_Name          varchar(100)         null,
   Leader_Phone         varchar(100)         null,
   Assistant_Id         INT8                 null,
   Assistant_Name       varchar(100)         null,
   Assistant_Phone      varchar(100)         null,
   Parent_Leader_Id     INT8                 null,
   Parent_Leader_Name   varchar(100)         null,
   Parent_Leader_Phone  varchar(100)         null,
   Deputy_Leade_Id      INT8                 null,
   Deputy_Leader_Name   varchar(100)         null,
   Deputy_Leader_Phone  varchar(100)         null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Is_Enable            INT4	             default 1,
   Sort                 INT4                 null,
   Remark               TEXT                 null,
   Type                 varchar(100)         null,
   Lft                  INT4                 null,
   Rgt                  INT4                 null,
   Level                INT4                 null,
   Is_Default           INT4	             default 0,
   constraint PK_LEASE_ORGANIZATION_STRUCTUR primary key (Id)
);

CREATE SEQUENCE lease_organization_structure_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_organization_structure  alter column id set default nextval('lease_organization_structure_id_seq');

comment on table lease_organization_structure is
'组织结构';

comment on column lease_organization_structure.Id is
'主键id';

comment on column lease_organization_structure.Number is
'编号';

comment on column lease_organization_structure.Name is
'名称';

comment on column lease_organization_structure.Parent_Id is
'父级Id';

comment on column lease_organization_structure.Leader_Id is
'主管主键Id/后台用户主键Id';

comment on column lease_organization_structure.Leader_Name is
'主管名称';

comment on column lease_organization_structure.Leader_Phone is
'主管手机';

comment on column lease_organization_structure.Assistant_Id is
'助理主键Id/后台用户主键Id';

comment on column lease_organization_structure.Assistant_Name is
'助理名称';

comment on column lease_organization_structure.Assistant_Phone is
'助理手机';

comment on column lease_organization_structure.Parent_Leader_Id is
'上级主管主键Id/后台用户主键Id';

comment on column lease_organization_structure.Parent_Leader_Name is
'上级主管名称';

comment on column lease_organization_structure.Parent_Leader_Phone is
'上级主管手机';

comment on column lease_organization_structure.Deputy_Leade_Id is
'分管副总主键Id/后台用户主键Id';

comment on column lease_organization_structure.Deputy_Leader_Name is
'分管副总名称';

comment on column lease_organization_structure.Deputy_Leader_Phone is
'分管副总手机';

comment on column lease_organization_structure.Create_Time is
'创建日期';

comment on column lease_organization_structure.Update_Time is
'修改日期';

comment on column lease_organization_structure.Create_By is
'创建人';

comment on column lease_organization_structure.Update_By is
'修改人';

comment on column lease_organization_structure.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_organization_structure.Sort is
'排序';

comment on column lease_organization_structure.Remark is
'描述';

comment on column lease_organization_structure.Type is
'类型/公司:company、部门:department、组:group';

comment on column lease_organization_structure.Lft is
'左编码值';

comment on column lease_organization_structure.Rgt is
'右编码值';

comment on column lease_organization_structure.Level is
'层级';

comment on column lease_organization_structure.Is_Default is
'是否默认/0:否;1:是 / 默认的数据不删除';


create table lease_autho_role (
   Id                   INT8				 not null,
   Name                 varchar(100)         null,
   Code                 varchar(100)         null,
   Type                 INT4                  null,
   Create_Time          timestamp            null,
   Update_Time          timestamp            null,
   Create_By            INT8                 null,
   Update_By            INT8                 null,
   Sort                 INT4                 null,
   Is_Enable            boolean              null,
   Remark               text                 null,
   constraint PK_LEASE_AUTHO_ROLE primary key (Id)
);

CREATE SEQUENCE lease_autho_role_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_autho_role  alter column id set default nextval('lease_autho_role_id_seq');

comment on table lease_autho_role is
'角色';

comment on column lease_autho_role.Id is
'主键Id';

comment on column lease_autho_role.Name is
'角色名';

comment on column lease_autho_role.Code is
'角色代码';

comment on column lease_autho_role.Type is
'角色类型：0职位、1补充';

comment on column lease_autho_role.Create_Time is
'创建日期';

comment on column lease_autho_role.Update_Time is
'修改日期';

comment on column lease_autho_role.Create_By is
'创建人';

comment on column lease_autho_role.Update_By is
'修改人';

comment on column lease_autho_role.Sort is
'排序';

comment on column lease_autho_role.Is_Enable is
'状态 0:禁用 1:启用';

comment on column lease_autho_role.Remark is
'角色描述';

create table lease_autho_user_role (
   Id                   INT8				 not null,
   User_Id              INT8                 null,
   Role_Id              INT8                 null,
   Type                 INT4                 null,
   constraint LEASE_AUTHO_USER_ROLE_PKEY primary key (Id)
);

CREATE SEQUENCE lease_autho_user_role_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_autho_user_role  alter column id set default nextval('lease_autho_user_role_id_seq');

comment on table lease_autho_user_role is
'用户对应的角色';

comment on column lease_autho_user_role.Id is
'主键Id';

comment on column lease_autho_user_role.User_Id is
'用户主键id';

comment on column lease_autho_user_role.Role_Id is
'角色主键id';

comment on column lease_autho_user_role.Type is
'类型 0职能角色 1补充角色';

create table lease_autho_role_organization (
   Id                   INT8                 not null,
   Role_Id              INT8                 null,
   Organization_Structure_Id INT8                 null,
   Organization_Structure_Type VARCHAR(100)         null,
   constraint PK_LEASE_AUTHO_ROLE_ORGANIZATI primary key (Id)
);

CREATE SEQUENCE lease_autho_role_organization_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_autho_role_organization  alter column id set default nextval('lease_autho_role_organization_id_seq');

comment on table lease_autho_role_organization is
'角色-公司、部门、组中间表。用于控制角色查看指定公司、部门的数据';

comment on column lease_autho_role_organization.Id is
'主键Id';

comment on column lease_autho_role_organization.Role_Id is
'角色主键ID';

comment on column lease_autho_role_organization.Organization_Structure_Id is
'关联对象主键Id（公司、部门、组）';

comment on column lease_autho_role_organization.Organization_Structure_Type is
'关联对象类型（公司:company、部门:department、组:group）';

create table lease_autho_user_organization (
   Id                   INT8                 not null,
   User_Id              INT8                 null,
   Organization_Structure_Id INT8                 null,
   Organization_Structure_Type VARCHAR(100)         null,
   constraint PK_LEASE_AUTHO_USER_ORGANIZATI primary key (Id)
);

CREATE SEQUENCE lease_autho_user_organization_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
alter table lease_autho_user_organization  alter column id set default nextval('lease_autho_user_organization_id_seq');

comment on table lease_autho_user_organization is
'用户-公司、部门、组中间表，用户所属的组织';

comment on column lease_autho_user_organization.Id is
'主键Id';

comment on column lease_autho_user_organization.User_Id is
'用户主键ID';

comment on column lease_autho_user_organization.Organization_Structure_Id is
'关联对象主键Id（公司、部门、组）';

comment on column lease_autho_user_organization.Organization_Structure_Type is
'关联对象类型（公司:company、部门:department、组:group）';




