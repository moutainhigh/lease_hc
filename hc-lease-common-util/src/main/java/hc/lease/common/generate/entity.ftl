/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package ${packageName}.${moduleName}.entity${subModuleName};

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.common.persistence.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

/**
 * ${functionName}Entity
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Entity
@Table(name = "${tableName}")
public class ${ClassName} extends BaseEntity<${ClassName}> {
	
	private static final long serialVersionUID = 1L;
	private Long id; 		// 编号，主键采用native策略，必须在要对应表设置该键的自增长
	private String name; 	// 名称

	public ${ClassName}() {
		super();
	}

	public ${ClassName}(Long id){
		this();
		this.id = id;
	}
	
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "native")
	@Column(name = "id", unique = true, nullable = false, insertable = true, updatable = true, length = 19)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	 
	@Length(min=1, max=20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}


