package ${packageName}.${moduleName}.controller${subModuleName};

import com.github.pagehelper.PageInfo;
import ${packageName}.${moduleName}.adapter.api.${ClassName}Adapter;
import ${packageName}.${moduleName}.model.${ClassName};

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.aop.ValidatedAnnotation;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 * ${functionName}Controller
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Api(value = "${ClassName}Controller", description = "${functionName}")
@Controller
@RequestMapping(value = "/api/admin/${className}")
public class ${ClassName}Controller {

	@Autowired
	private ${ClassName}Adapter ${className}Adapter;

    /**
    * 初始化编辑页面的参数
    *
    * @return
    * @throws GMException
    */
    @ApiOperation("初始化编辑页面的参数")
    @RequestMapping(value = "/insertViewParames", method = RequestMethod.GET)
    @ResponseBody
    public ResultHashMap insertViewParames() throws GMException {
        Map<String, Object> insertViewParames = ${className}Adapter.insertViewParames(null);
        Object object = ListUtil.objectIsNullToMap(insertViewParames);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
    * 新增
    */
    @ApiOperation("新增")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    public ResultHashMap insertSelective(@Validated @RequestBody ${ClassName} ${className}) throws GMException {
        ResultHashMap resultHashMap = ${className}Adapter.insertSelective(${className});
        return resultHashMap;
    }

    /**
    * 修改
    */
    @ApiOperation("修改")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    public ResultHashMap updateByPrimaryKeySelective(@Validated @RequestBody ${ClassName} ${className}) throws GMException {
        int row = ${className}Adapter.updateByPrimaryKeySelective(${className});
        System.out.println("***********updateByPrimaryKeySelective***************");
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_UPDATE);
        return resultHashMap;
    }

    /**
    * 根据ID删除记录
    *
    * @param id
    * @return
    * @throws Exception
    */
    @ApiOperation("删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    public ResultHashMap deleteByPrimaryKey(@RequestParam Long id) throws GMException {
        int row = ${className}Adapter.deleteByPrimaryKey(id);
        System.out.println("***********deleteByPrimaryKey***************");
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_DELETE);
        return resultHashMap;
    }

    /**
    * 根据ID删除记录.批量删除
    *
    * @param ${className}
    * @return
    * @throws GMException
    */
    @ApiOperation("根据ID删除记录.批量删除")
    @RequestMapping(value = "/deleteBatchById", method = RequestMethod.POST)
    @ResponseBody
    public ResultHashMap deleteBatchById(@RequestBody ${ClassName} ${className}) throws GMException {
        int row = ${className}Adapter.deleteBatchById(${className}.getIds());
        System.out.println("***********deleteByPrimaryKey***************");
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_DELETE);
        return resultHashMap;
    }

    /**
    * 详细信息/修改回显信息
    */
    @ApiOperation("详细信息/修改回显信息")
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    @ResponseBody
    public ResultHashMap details(@RequestParam Long id) throws Exception {
        ${ClassName} ${className} = ${className}Adapter.selectByPrimaryKey(id);
        Object object = ListUtil.objectIsNullToList(${className});
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
    * 分页/数据列表
    *
    * @return
    */
    @ApiOperation("分页/数据列表")
    @RequestMapping(value = "/findPage", method = RequestMethod.GET)
    @ResponseBody
    public ResultHashMap findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) throws GMException {
        PageInfo<${ClassName}> page = ${className}Adapter.findPage(pageNum, pageSize, null);
        Object object = ListUtil.objectIsNullToMap(page);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    @ApiOperation("分页/数据列表")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultHashMap findAll() throws GMException {
    List<${ClassName}> list = ${className}Adapter.findAll(null);
        Object object = ListUtil.objectIsNullToMap(list);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
        }

}
