package ${packageName}.${moduleName}.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${packageName}.${moduleName}.adapter.api.${ClassName}Adapter;
import ${packageName}.${moduleName}.service.api.${ClassName}Service;
import ${packageName}.${moduleName}.model.${ClassName};

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * ${functionName}AdapterImpl
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Service("${className}Adapter")
public class ${ClassName}AdapterImpl implements ${ClassName}Adapter {

	@Autowired
	private ${ClassName}Service ${className}Service;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        if (paramsMap == null) paramsMap = Maps.newHashMap();

        Map<String, Object> backMap = Maps.newHashMap();
        return backMap;
    }

    /**
    * 列表页面 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParamesListPage(Map<String, Object> paramsMap) throws GMException {
    return null;
    }

    /**
    * 根据ID删除记录
    *
    * @param id .
    * @return
    * @throws GMException
    */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = ${className}Service.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = ${className}Service.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(${ClassName} record) throws GMException {
        record = ${className}Service.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(${ClassName} record) throws GMException {
        record = ${className}Service.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(${ClassName} record) throws GMException {
        int row = ${className}Service.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(${ClassName} record) throws GMException {
        int row = ${className}Service.updateByPrimaryKey(record);
        return row;
    }

    public ${ClassName} selectByPrimaryKey(Long id) throws GMException {
        ${ClassName} ${className} = ${className}Service.selectByPrimaryKey(id);
        return ${className};
    }

    public int insertList(List<${ClassName}> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<${ClassName}> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<${ClassName}> page = ${className}Service.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<${ClassName}> findAll(Map<String, Object> paramsMap) throws GMException {
        List<${ClassName}> ${className}List = ${className}Service.findAll(paramsMap);
        return ${className}List;
    }

}
