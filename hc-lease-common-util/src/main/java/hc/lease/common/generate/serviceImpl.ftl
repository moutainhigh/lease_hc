package ${packageName}.${moduleName}.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${packageName}.${moduleName}.service.api.${ClassName}Service;
import ${packageName}.${moduleName}.model.${ClassName};
import ${packageName}.${moduleName}.dao.${ClassName}Mapper;

import java.util.List;
import java.util.Map;

/**
 * ${functionName}ServiceImpl
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Service("${className}Service")
public class ${ClassName}ServiceImpl implements ${ClassName}Service {

	@Autowired
	private ${ClassName}Mapper ${className}Mapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = ${className}Mapper.deleteByPrimaryKey(id);
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
        int row = ${className}Mapper.deleteBatchById(ids);
        return row;
    }

    public ${ClassName} insert(${ClassName} ${className}) throws GMException {
        ${className}.setCreateTime(DateTime.now().toDate());
        ${className}.setUpdateTime(DateTime.now().toDate());
        int row = ${className}Mapper.insert(${className});
        return ${className};
    }

    public ${ClassName} insertSelective(${ClassName} ${className}) throws GMException {
        ${className}.setCreateTime(DateTime.now().toDate());
        ${className}.setUpdateTime(DateTime.now().toDate());
        int row = ${className}Mapper.insertSelective(${className});
        return ${className};
    }

    public int insertList(List<${ClassName}> list) throws GMException {
        int row = ${className}Mapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(${ClassName} ${className}) throws GMException {
        ${className}.setUpdateTime(DateTime.now().toDate());
        int row = ${className}Mapper.updateByPrimaryKeySelective(${className});
        return row;
    }

    public int updateByPrimaryKey(${ClassName} ${className}) throws GMException {
        ${className}.setUpdateTime(DateTime.now().toDate());
        int row = ${className}Mapper.updateByPrimaryKey(${className});
        return row;
    }

    public ${ClassName} selectByPrimaryKey(Long id) throws GMException {
        ${ClassName} ${className} = ${className}Mapper.selectByPrimaryKey(id);
        return ${className};
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <${ClassName}> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<${ClassName}> ${className}List = ${className}Mapper.findPage(paramsMap);
        PageInfo<${ClassName}> page = new PageInfo<${ClassName}>(${className}List);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <${ClassName}> findAll(Map<String, Object> paramsMap) throws GMException {
        List<${ClassName}> ${className}List = ${className}Mapper.findAll(paramsMap);
        return ${className}List;
    }

}
