/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package ${packageName}.${moduleName}.dao${subModuleName};

import org.springframework.stereotype.Repository;
import com.thinkgem.jeesite.common.persistence.Parameter;
import com.thinkgem.jeesite.common.persistence.BaseDao;
import ${packageName}.${moduleName}.entity${subModuleName}.${ClassName};

/**
 * ${functionName}DAO接口
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Repository
public class ${ClassName}Dao extends BaseDao<${ClassName}> {

	public int deleteById(Long id){
		return update("delete from ${ClassName} where id = :p1", new Parameter(id));
	}
}
