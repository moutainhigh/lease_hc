package ${packageName}.${moduleName}.adapter.api;

import ${packageName}.${moduleName}.model.${ClassName};
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * ${functionName}Adapter
 * @author ${classAuthor}
 * @version ${classVersion}
 */

public interface ${ClassName}Adapter extends BaseAdapter<${ClassName}> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
    * 列表页面 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParamesListPage(Map<String, Object> paramsMap) throws GMException;

}
