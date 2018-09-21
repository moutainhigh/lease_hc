package com.hc.lease.baseInfo.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseCarModelAdapter;
import com.hc.lease.baseInfo.model.*;
import com.hc.lease.baseInfo.service.api.*;
import com.hc.lease.baseInfo.vo.LeaseCarModelColorPriceVo;
import com.hc.lease.baseInfo.vo.LeaseCarModels;
import com.hc.lease.common.core.constant.DictType;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.CarModelImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarModelTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆车型AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseCarModelAdapter")
public class LeaseCarModelAdapterImpl implements LeaseCarModelAdapter {

    @Autowired
    private LeaseCarModelService leaseCarModelService;

    @Autowired
    private LeaseCarBrandsService leaseCarBrandsService;

    @Autowired
    private LeaseCarSeriesService leaseCarSeriesService;

    @Autowired
    private LeaseDictService leaseDictService;

    @Autowired
    private LeaseCarMaintainRuleService leaseCarMaintainRuleService;

    @Autowired
    private LeaseCarModelColorService leaseCarModelColorService;

    @Autowired
    private LeaseCarColorService leaseCarColorService;

    @Autowired
    private LeaseBranchCompanyService leaseBranchCompanyService;

    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;

    /**
     * 检测数据是否被使用
     *
     * @param id
     * @return
     * @throws GMException
     */
    public Map<String, Object> checkByModelIdIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_CAR_MODEL);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);

        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseCarModel leaseCarModel = leaseCarModelService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseCarModel.getCompleteModelName());
                exceptionMessageList.add(exceptionMessageMap);
            } else {
                item = false;
            }
        } else {
            item = false;
        }
        backMap.put("isExist", item);
        backMap.put("exceptionMessageList", exceptionMessageList);
        return backMap;
    }

    /**
     * 根据名称检测数据是否存在
     *
     * @param name
     * @return
     * @throws GMException
     */
    public boolean checkByNameIsExist(String name, Long id) throws GMException {
        boolean item = false;
        Map params = Maps.newHashMap();
        params.put("name", name);
        params.put("id", id);
        List<LeaseCarModel> leaseCarModelList = leaseCarModelService.findByName(params);
        if (leaseCarModelList != null) {
            if (leaseCarModelList.size() > 0) {
                item = true;
            } else {
                item = false;
            }
        } else {
            item = false;
        }
        return item;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        Map<String, Object> map = Maps.newHashMap();
        List<LeaseCarBrands> leaseCarBrandsList = leaseCarBrandsService.insertViewParames(paramsMap);//车辆品牌
        List<LeaseCarSeries> leaseCarSeriesList = leaseCarSeriesService.insertViewParames(paramsMap);//车辆系列
        List<LeaseDict> leaseDictFuelTypeList = leaseDictService.findByType(DictType.TYPE_FUELTYPE);//燃料类型
        List<LeaseDict> leaseDictOutputVolumeList = leaseDictService.findByType(DictType.TYPE_OUTPUTVOLUME);//排量
        List<LeaseCarMaintainRule> leaseCarMaintainRuleList = leaseCarMaintainRuleService.insertViewParames(paramsMap);//保养规则
        List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.findAll(paramsMap);//颜色和价格
        List<LeaseCarColor> leaseCarColorList = leaseCarColorService.insertViewParames(paramsMap);
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(paramsMap);

        map.put("leaseCarBrandsList", leaseCarBrandsList);
        map.put("leaseCarSeriesList", leaseCarSeriesList);
        map.put("leaseDictFuelTypeList", leaseDictFuelTypeList);
        map.put("leaseDictOutputVolumeList", leaseDictOutputVolumeList);
        map.put("leaseCarMaintainRuleList", leaseCarMaintainRuleList);
        map.put("leaseCarModelColorList", leaseCarModelColorList);
        map.put("leaseCarColorList", leaseCarColorList);
        map.put("leaseBranchCompanyList", leaseBranchCompanyList);

        return map;
    }

    /**
     * 根据ID删除记录
     *
     * @param id .
     * @return
     * @throws GMException
     */
    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByModelIdIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseCarModelService.deleteByPrimaryKey(id);
        leaseCarModelColorService.deleteByModelId(id);
        leaseCommonService.delUseUsed(id, null, UsedType.TYPE_LEASE_CAR_MODEL, null);//删除使用者数据
        return row;
    }

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     * @throws GMException
     */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseCarModelService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCarModel record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getCompleteModelName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "completeModelName");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCarModelService.insert(record);

        /*
        // json转List/处理车型颜色价格
        String leaseCarModelColorPriceJson = (String) record.getLeaseCarModelColorPriceJson();
        if (StringUtils.isNotBlank(leaseCarModelColorPriceJson)) {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, LeaseCarModelColorPriceVo.class);
            List<LeaseCarModelColorPriceVo> list = null;
            try {
                list = (List<LeaseCarModelColorPriceVo>) mapper.readValue(leaseCarModelColorPriceJson, javaType);
            } catch (JsonParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorList = new ArrayList<LeaseCarModelColorPriceVo>();
            for (LeaseCarModelColorPriceVo leaseCarModelColorPriceVo : list) {
                Long colorId = leaseCarModelColorPriceVo.getCarColorId();
                BigDecimal price = leaseCarModelColorPriceVo.getPrice();
                leaseCarModelColorList.add(new LeaseCarModelColorPriceVo(record.getId(), colorId, price));
                leaseCarModelColorService.insertSelective(new LeaseCarModelColor(record.getId(), colorId, price));
            }
        }
        */

       /* if (record.getLeaseCarModelColorPriceVoList() != null) {
            if (record.getLeaseCarModelColorPriceVoList().size() > 0) {
                ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorList = new ArrayList<LeaseCarModelColorPriceVo>();
                for (LeaseCarModelColorPriceVo leaseCarModelColorPriceVo : record.getLeaseCarModelColorPriceVoList()) {
                    Long colorId = leaseCarModelColorPriceVo.getCarColorId();
                    BigDecimal price = leaseCarModelColorPriceVo.getPrice();
                    Long branchCompanyId = leaseCarModelColorPriceVo.getBranchCompanyId();
                    leaseCarModelColorList.add(new LeaseCarModelColorPriceVo(record.getId(), colorId, price, branchCompanyId));
                    leaseCarModelColorService.insertSelective(new LeaseCarModelColor(record.getId(), colorId, price, branchCompanyId));

                    //插入使用和被使用的数据
                    leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), colorId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_COLOR);

                    //插入使用和被使用的数据
                    leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), branchCompanyId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_BRANCH_COMPANY);

                }
            }
        }
*/

        Object object = ListUtil.objectIsNullToMap(null);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), record.getSeriesId(), record.getSeriesName(), UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_SERIES);

        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCarModel record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getCompleteModelName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "completeModelName");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCarModelService.insertSelective(record);

        /*
        // json转List/处理车型颜色价格
        String leaseCarModelColorPriceJson = (String) record.getLeaseCarModelColorPriceJson();
        if (StringUtils.isNotBlank(leaseCarModelColorPriceJson)) {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, LeaseCarModelColorPriceVo.class);
            List<LeaseCarModelColorPriceVo> list = null;
            try {
                list = (List<LeaseCarModelColorPriceVo>) mapper.readValue(leaseCarModelColorPriceJson, javaType);
            } catch (JsonParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorList = new ArrayList<LeaseCarModelColorPriceVo>();
            for (LeaseCarModelColorPriceVo leaseCarModelColorPriceVo : list) {
                Long colorId = leaseCarModelColorPriceVo.getCarColorId();
                BigDecimal price = leaseCarModelColorPriceVo.getPrice();
                leaseCarModelColorList.add(new LeaseCarModelColorPriceVo(record.getId(), colorId, price));
                leaseCarModelColorService.insertSelective(new LeaseCarModelColor(record.getId(), colorId, price));
            }
        }
        */

       /* if (record.getLeaseCarModelColorPriceVoList() != null) {
            if (record.getLeaseCarModelColorPriceVoList().size() > 0) {
                ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorList = new ArrayList<LeaseCarModelColorPriceVo>();
                for (LeaseCarModelColorPriceVo leaseCarModelColorPriceVo : record.getLeaseCarModelColorPriceVoList()) {
                    Long colorId = leaseCarModelColorPriceVo.getCarColorId();
                    BigDecimal price = leaseCarModelColorPriceVo.getPrice();
                    Long branchCompanyId = leaseCarModelColorPriceVo.getBranchCompanyId();
                    leaseCarModelColorList.add(new LeaseCarModelColorPriceVo(record.getId(), colorId, price, branchCompanyId));
                    leaseCarModelColorService.insertSelective(new LeaseCarModelColor(record.getId(), colorId, price, branchCompanyId));

                    //插入使用和被使用的数据
                    leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), colorId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_COLOR);

                    //插入使用和被使用的数据
                    leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), branchCompanyId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_BRANCH_COMPANY);

                }
            }
        }*/


        Object object = ListUtil.objectIsNullToMap(null);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), record.getSeriesId(), record.getSeriesName(), UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_SERIES);

        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseCarModel selectByPrimaryKey(Long id) throws GMException {
        LeaseCarModel LeaseCarModel = leaseCarModelService.selectByPrimaryKey(id);

        ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorPriceVo = leaseCarModelColorService.selectByModelId(id);
        LeaseCarModel.setLeaseCarModelColorPriceVoList(leaseCarModelColorPriceVo == null ? new ArrayList<LeaseCarModelColorPriceVo>() : leaseCarModelColorPriceVo);

        return LeaseCarModel;
    }

    public Map<String, Object> selectById(Long id) throws GMException {
        Map<String, Object> leaseCarModelMap = leaseCarModelService.selectById(id);
        return leaseCarModelMap;
    }


    public ResultHashMap insertSelective(LeaseCarModel leaseCarModel, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(leaseCarModel.getCompleteModelName(), leaseCarModel.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "completeModelName");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        leaseCarModel.setCreateBy(userSession.getUserId());
        leaseCarModel.setUpdateBy(userSession.getUserId());
        leaseCarModel = leaseCarModelService.insertSelective(leaseCarModel);


        if (leaseCarModel.getLeaseCarModelColorPriceVoList() != null) {
            if (leaseCarModel.getLeaseCarModelColorPriceVoList().size() > 0) {
                ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorList = new ArrayList<LeaseCarModelColorPriceVo>();
                for (LeaseCarModelColorPriceVo leaseCarModelColorPriceVo : leaseCarModel.getLeaseCarModelColorPriceVoList()) {
                    Long colorId = leaseCarModelColorPriceVo.getCarColorId();
                    //leaseCarModelColorList.add(new LeaseCarModelColorPriceVo(leaseCarModel.getId(), colorId, price, branchCompanyId));
                    leaseCarModelColorService.insertSelective(new LeaseCarModelColor(leaseCarModel.getId(),colorId));

                    //插入使用和被使用的数据
                    leaseCommonService.insertUseUsed(leaseCarModel.getId(), leaseCarModel.getCompleteModelName(), colorId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_COLOR);

                }
            }
        }


        Object object = ListUtil.objectIsNullToMap(null);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(leaseCarModel.getId(), leaseCarModel.getCompleteModelName(), leaseCarModel.getSeriesId(), leaseCarModel.getSeriesName(), UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_SERIES);

        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseCarModel record, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(record.getCompleteModelName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "completeModelName");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        record.setUpdateBy(userSession.getUserId());
        int row = leaseCarModelService.updateByPrimaryKeySelective(record);

        leaseCarModelColorService.deleteByModelId(record.getId());
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CAR_MODEL);

        if (record.getLeaseCarModelColorPriceVoList() != null) {
            if (record.getLeaseCarModelColorPriceVoList().size() > 0) {
                ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorList = new ArrayList<LeaseCarModelColorPriceVo>();
                for (LeaseCarModelColorPriceVo leaseCarModelColorPriceVo : record.getLeaseCarModelColorPriceVoList()) {
                    Long colorId = leaseCarModelColorPriceVo.getCarColorId();
                    //leaseCarModelColorList.add(new LeaseCarModelColorPriceVo(record.getId(), colorId, price, branchCompanyId));
                    leaseCarModelColorService.insertSelective(new LeaseCarModelColor(record.getId(), colorId));

                    //插入使用和被使用的数据
                    leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), colorId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_COLOR);

                    //插入使用和被使用的数据
                    //leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), branchCompanyId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_BRANCH_COMPANY);

                }
            }
        }

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), record.getSeriesId(), record.getSeriesName(), UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_SERIES);

        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseCarModelService.disableByPrimaryKey(params);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseCarModel record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getCompleteModelName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "completeModelName");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCarModelService.updateByPrimaryKeySelective(record);

        leaseCarModelColorService.deleteByModelId(record.getId());
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CAR_MODEL);

      /*  if (record.getLeaseCarModelColorPriceVoList() != null) {
            if (record.getLeaseCarModelColorPriceVoList().size() > 0) {
                ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorList = new ArrayList<LeaseCarModelColorPriceVo>();
                for (LeaseCarModelColorPriceVo leaseCarModelColorPriceVo : record.getLeaseCarModelColorPriceVoList()) {
                    Long colorId = leaseCarModelColorPriceVo.getCarColorId();
                    BigDecimal price = leaseCarModelColorPriceVo.getPrice();
                    Long branchCompanyId = leaseCarModelColorPriceVo.getBranchCompanyId();
                    leaseCarModelColorList.add(new LeaseCarModelColorPriceVo(record.getId(), colorId, price, branchCompanyId));
                    leaseCarModelColorService.insertSelective(new LeaseCarModelColor(record.getId(), colorId, price, branchCompanyId));


                    //插入使用和被使用的数据
                    leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), colorId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_COLOR);

                    //插入使用和被使用的数据
                    leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), branchCompanyId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_BRANCH_COMPANY);

                }
            }
        }*/

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), record.getSeriesId(), record.getSeriesName(), UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_SERIES);

        return row;
    }

    public int updateByPrimaryKey(LeaseCarModel record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getCompleteModelName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "completeModelName");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCarModelService.updateByPrimaryKey(record);

      /*  leaseCarModelColorService.deleteByModelId(record.getId());
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CAR_MODEL);
        if (record.getLeaseCarModelColorPriceVoList() != null) {
            if (record.getLeaseCarModelColorPriceVoList().size() > 0) {
                ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorList = new ArrayList<LeaseCarModelColorPriceVo>();
                for (LeaseCarModelColorPriceVo leaseCarModelColorPriceVo : record.getLeaseCarModelColorPriceVoList()) {
                    Long colorId = leaseCarModelColorPriceVo.getCarColorId();
                    BigDecimal price = leaseCarModelColorPriceVo.getPrice();
                    Long branchCompanyId = leaseCarModelColorPriceVo.getBranchCompanyId();
                    leaseCarModelColorList.add(new LeaseCarModelColorPriceVo(record.getId(), colorId, price, branchCompanyId));
                    leaseCarModelColorService.insertSelective(new LeaseCarModelColor(record.getId(), colorId, price, branchCompanyId));

                    //插入使用和被使用的数据
                    leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), colorId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_COLOR);

                    //插入使用和被使用的数据
                    leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), branchCompanyId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_BRANCH_COMPANY);

                }
            }
        }*/

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), record.getSeriesId(), record.getSeriesName(), UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_SERIES);

        return row;
    }

    public int insertList(List<LeaseCarModel> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarModel> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCarModel> page = leaseCarModelService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseCarModel> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarModel> list = leaseCarModelService.findAll(paramsMap);
        return list;
    }

    /**
     * 导出车辆录入模板需要的数据
     *
     * @param params
     * @return
     * @throws GMException
     */
    @Override
    public List<String> findExportExcelModel(Map params) throws GMException {
        List<String> list = leaseCarModelService.findExportExcelModel(params);
        return list;
    }

    public int updateSort(LeaseCarModels leaseCarModels) {
        if(leaseCarModels.getLeaseCarModels()!=null && leaseCarModels.getLeaseCarModels().size()>0){
            List<LeaseCarModel> leaseCarModelList=leaseCarModels.getLeaseCarModels();
            for (LeaseCarModel  leaseCarModel: leaseCarModelList) {
                leaseCarModelService.updateSort(leaseCarModel);
            }
        }


        return 0;
    }

    public int updateMarketPriceByPrimaryKey(Map<String, Object> paramsMap) {
        leaseCarModelService.updateMarketPriceByPrimaryKey(paramsMap);
        return 0;
    }

    public List<LeaseCarModel> findAllNoPage(Map params) {
        List<LeaseCarModel> leaseCarModelList= leaseCarModelService.findAllNoPage(params);
        return leaseCarModelList;
    }

    public CarModelImportExcelBackInfo importExcelCarModel(List<LeaseCarModelTemplate> leaseCarModelTemplates, UserSession userSession) throws GMException {
        CarModelImportExcelBackInfo carModelImportExcelBackInfo = null;
        if (leaseCarModelTemplates != null) {
            if (leaseCarModelTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseCarModelTemplates.size(); i++) {
                    LeaseCarModelTemplate  leaseCarModelTemplate = leaseCarModelTemplates.get(i);
                    String brandName = leaseCarModelTemplate.getBrandName();
                    String seriesName = leaseCarModelTemplate.getSeriesName();
                    String completeModelName = leaseCarModelTemplate.getCompleteModelName();
                    String marketPrice = leaseCarModelTemplate.getMarketPrice();
                    String businessModelName = leaseCarModelTemplate.getBusinessModelName();
                    String itemType = leaseCarModelTemplate.getItemType();
                    String particularYear = leaseCarModelTemplate.getParticularYear();
                    String modelCode = leaseCarModelTemplate.getModelCode();
                    String fuelTypeName = leaseCarModelTemplate.getFuelTypeName();
                    String outputVolumeName=null;
                    if(leaseCarModelTemplate.getOutputVolumeName()!=null){
                         outputVolumeName = leaseCarModelTemplate.getOutputVolumeName().toString();
                    }


                    if (StringUtils.isBlank(brandName) ||StringUtils.isBlank(seriesName) ||StringUtils.isBlank(completeModelName) ||
                            StringUtils.isBlank(marketPrice)) {
                        leaseCarModelTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                   /* if (StringUtils.isBlank(brandName) ||StringUtils.isBlank(seriesName) ||StringUtils.isBlank(completeModelName) ||
                            StringUtils.isBlank(marketPrice)|| StringUtils.isBlank(businessModelName) ||StringUtils.isBlank(itemType)
                            ||StringUtils.isBlank(particularYear) || StringUtils.isBlank(modelCode) || StringUtils.isBlank(fuelTypeName)
                            ||StringUtils.isBlank(outputVolumeName)) {
                        leaseCarModelTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }*/

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseCarModelTemplate.getBrandName());
                    List<LeaseCarBrands> leaseCarBrandses = leaseCarBrandsService.findByName(params);
                    if(leaseCarBrandses==null || leaseCarBrandses.size()==0){
                        leaseCarModelTemplate.setUpdateState("失败,车辆品牌不存在");
                        failNum++;
                        continue;
                    }
                    Map<String,Object> param=Maps.newHashMap();
                    param.put("name",leaseCarModelTemplate.getSeriesName());
                    List<LeaseCarSeries> carSeries = leaseCarSeriesService.findByName(param);
                    if(carSeries==null || carSeries.size()==0){
                        leaseCarModelTemplate.setUpdateState("失败,车辆系列不存在");
                        failNum++;
                        continue;
                    }
                    List<LeaseDict> leaseDicts=null;
                    if(StringUtils.isNotEmpty(leaseCarModelTemplate.getFuelTypeName())) {
                        Map<String, Object> map = Maps.newHashMap();
                        map.put("name", leaseCarModelTemplate.getFuelTypeName());
                        map.put("type", DictType.TYPE_FUELTYPE);
                       leaseDicts = leaseDictService.findByValueAndType(map);
                        if (leaseDicts == null || leaseDicts.size() == 0) {
                            leaseCarModelTemplate.setUpdateState("失败,燃料类型不存在");
                            failNum++;
                            continue;
                        }
                    }
                    List<LeaseDict> dictList=null;
                    if(StringUtils.isNotEmpty(outputVolumeName)) {
                        Map<String, Object> maps = Maps.newHashMap();
                        maps.put("name", leaseCarModelTemplate.getOutputVolumeName().toString());
                        maps.put("type", DictType.TYPE_OUTPUTVOLUME);
                       dictList = leaseDictService.findByValueAndType(maps);
                        if (dictList == null || dictList.size() == 0) {
                            leaseCarModelTemplate.setUpdateState("失败,排量数值不存在");
                            failNum++;
                            continue;
                        }
                    }

                    //Long colorId=null;

                  /*  List<Long> colorIdList=new ArrayList<>();
                    if(leaseCarModelTemplate.getColorName()!=null) {
                        Map<String, Object> colorMap = Maps.newHashMap();
                        String[] colorName = leaseCarModelTemplate.getColorName().split(",");
                        for (String s : colorName) {
                        colorMap.put("name", s);
                        List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(colorMap);
                         if(leaseCarColorList == null || leaseCarColorList.size() == 0) {
                             leaseCarModelTemplate.setUpdateState("失败,颜色不存在");
                             failNum++;
                             break;
                           }
                           if(leaseCarColorList!=null && leaseCarColorList.size()>0){
                               Long colorId = leaseCarColorList.get(0).getId();
                               colorIdList.add(colorId);
                           }
                        }
                    }*/

                    Map<String, Object> modelMap = Maps.newHashMap();
                    modelMap.put("name",completeModelName);
                    List<LeaseCarModel> modelList = leaseCarModelService.findByName(modelMap);
                    if(modelList!=null&&modelList.size()>0){
                        LeaseCarModel leaseCarModel=new LeaseCarModel();
                        leaseCarModel.setId(modelList.get(0).getId());
                        //leaseCarModel.setSeriesId(carSeries.get(0).getId());
                        leaseCarModel.setCompleteModelName(completeModelName);
                        leaseCarModel.setMarketPrice(new BigDecimal(marketPrice));
                        leaseCarModel.setBusinessModelName(businessModelName);
                        leaseCarModel.setItemType(itemType);
                        leaseCarModel.setParticularYear(particularYear);
                        leaseCarModel.setModelCode(modelCode);
                        if(StringUtils.isNotEmpty(leaseCarModelTemplate.getFuelTypeName())) {
                            leaseCarModel.setFuelType(leaseDicts.get(0).getId());
                        }
                        if(StringUtils.isNotEmpty(outputVolumeName)) {
                            leaseCarModel.setDictIdOutputVolume(dictList.get(0).getId());
                        }
                        //leaseCarModel.setColorId(colorId);
                        leaseCarModel.setColorPriceRemarks(leaseCarModelTemplate.getColorPriceRemarks());
                         leaseCarModelService.updateByPrimaryKeySelective(leaseCarModel);
                        leaseCarModelColorService.deleteByModelId(modelList.get(0).getId());
                        leaseUseUsedService.deleteByUse(modelList.get(0).getId(), UseType.TYPE_LEASE_CAR_MODEL);
                        //车型-颜色
                       /* if(colorIdList!=null && colorIdList.size()>0) {
                            for (Long colorId : colorIdList) {
                                LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                                leaseCarModelColor.setCarModelId(modelList.get(0).getId());
                                leaseCarModelColor.setCarColorId(colorId);
                                leaseCarModelColorService.insertSelective(leaseCarModelColor);
                                leaseCommonService.insertUseUsed(modelList.get(0).getId(), completeModelName, colorId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_COLOR);
                            }
                        }*/
                    }else {
                        LeaseCarModel leaseCarModel = new LeaseCarModel();
                        leaseCarModel.setSeriesId(carSeries.get(0).getId());
                        leaseCarModel.setCompleteModelName(completeModelName);
                        leaseCarModel.setMarketPrice(new BigDecimal(marketPrice));
                        leaseCarModel.setBusinessModelName(businessModelName);
                        leaseCarModel.setItemType(itemType);
                        leaseCarModel.setParticularYear(particularYear);
                        leaseCarModel.setModelCode(modelCode);
                        if(StringUtils.isNotEmpty(leaseCarModelTemplate.getFuelTypeName())) {
                            leaseCarModel.setFuelType(leaseDicts.get(0).getId());
                        }
                        if(StringUtils.isNotEmpty(outputVolumeName)) {
                            leaseCarModel.setDictIdOutputVolume(dictList.get(0).getId());
                        }
                       /* leaseCarModel.setFuelType(leaseDicts.get(0).getId());
                        leaseCarModel.setDictIdOutputVolume(dictList.get(0).getId());*/
                        //leaseCarModel.setColorId(colorId);
                        leaseCarModel.setColorPriceRemarks(leaseCarModelTemplate.getColorPriceRemarks());
                        LeaseCarModel record = leaseCarModelService.insertSelective(leaseCarModel);

                        //车型-颜色
                        /*if (colorIdList != null && colorIdList.size() > 0) {
                            for (Long colorId : colorIdList) {
                                LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                                leaseCarModelColor.setCarModelId(record.getId());
                                leaseCarModelColor.setCarColorId(colorId);
                                leaseCarModelColorService.insertSelective(leaseCarModelColor);
                                leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), colorId, null, UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_COLOR);
                            }
                        }*/
                        leaseCommonService.insertUseUsed(record.getId(), record.getCompleteModelName(), record.getSeriesId(), record.getSeriesName(), UseType.TYPE_LEASE_CAR_MODEL, UsedType.TYPE_LEASE_CAR_SERIES);

                    }
                    successNum++;
                    leaseCarModelTemplate.setUpdateState("成功");

                }
                carModelImportExcelBackInfo = new CarModelImportExcelBackInfo();
                carModelImportExcelBackInfo.setFailNum(failNum);//失败数量
                carModelImportExcelBackInfo.setSuccessNum(successNum);//成功数量
                carModelImportExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                carModelImportExcelBackInfo.setLeaseCarModelTemplates(leaseCarModelTemplates);
            }
        }
        return carModelImportExcelBackInfo;
    }
}
