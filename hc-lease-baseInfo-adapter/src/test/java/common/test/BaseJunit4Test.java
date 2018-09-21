package common.test;

import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.model.LeaseContractBaseinfo;
import com.hc.lease.baseInfo.service.api.LeaseContractBaseinfoService;
import com.hc.lease.common.core.exception.GMException;

import javax.annotation.Resource;

//@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
//@ContextConfiguration({"/META-INF/spring/App*.xml"}) //加载配置文件

//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//@Transactional
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//------------
public class BaseJunit4Test {
    @Resource  //自动注入,默认按名称
    private LeaseContractBaseinfoService leaseContractBaseinfoService;

    //@Test   //标明是测试方法
    //@Transactional   //标明此方法需使用事务
    //@Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void insert() throws GMException {
        PageInfo<LeaseContractBaseinfo> leaseContractBaseinfoList = leaseContractBaseinfoService.findPage(1, 1, null);
    }
}
