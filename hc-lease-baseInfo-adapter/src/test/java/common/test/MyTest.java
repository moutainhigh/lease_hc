package common.test;

import com.hc.lease.baseInfo.adapter.api.*;
import com.hc.lease.baseInfo.model.LeaseCarModel;
import com.hc.lease.baseInfo.vo.LeaseCarModelColorPriceVo;
import com.hc.lease.common.core.exception.GMException;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MyTest {

    public static void main(String[] args) throws GMException, IOException, FileUploadBase.FileSizeLimitExceededException, IllegalAccessException {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/*.xml"});

        LeaseCarBrandsAdapter leaseCarBrandsAdapter = (LeaseCarBrandsAdapter) context.getBean("leaseCarBrandsAdapter");

        LeaseCarModelAdapter leaseCarModelAdapter = (LeaseCarModelAdapter) context.getBean("leaseCarModelAdapter");

        LeaseDealerAdapter leaseDealerAdapter = (LeaseDealerAdapter) context.getBean("leaseDealerAdapter");

        LeaseAreaAdapter leaseAreaAdapter = (LeaseAreaAdapter) context.getBean("leaseAreaAdapter");

        LeaseRuleAdapter leaseRuleAdapter = (LeaseRuleAdapter) context.getBean("leaseRuleAdapter");

        LeaseContractBaseinfoAdapter leaseContractBaseinfoAdapter = (LeaseContractBaseinfoAdapter) context.getBean("leaseContractBaseinfoAdapter");

        LeaseBankAdapter leaseBankAdapter = (LeaseBankAdapter) context.getBean("leaseBankAdapter");
        //leaseBankAdapter.findAll(null);

        //leaseContractBaseinfoAdapter.findPage(1,3,null);

        //leaseCarBrandsAdapter.deleteByPrimaryKey(2l);

        /*
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("ruleType", RuleType.TYPE_DEFAULTINTEREST);
        Map<String, Object> leaseRuleList = leaseContractBaseinfoAdapter.insertViewParames(null);
        */


        //leaseCarModelAdapter.findPage(1, 5, null);

        LeaseCarModel record = new LeaseCarModel();
        record.setCompleteModelName("xxx2");
        List<LeaseCarModelColorPriceVo> getLeaseCarModelColorPriceVoList = new ArrayList<LeaseCarModelColorPriceVo>();

        LeaseCarModelColorPriceVo leaseCarModelColorPriceVo = new LeaseCarModelColorPriceVo();
        leaseCarModelColorPriceVo.setCarColorId(1l);
        leaseCarModelColorPriceVo.setPrice(new BigDecimal(1500000000));
        getLeaseCarModelColorPriceVoList.add(leaseCarModelColorPriceVo);

        record.setLeaseCarModelColorPriceJson("[{\"carColorId\":1,\"price\":150000000000000000000},{\"carColorId\":2,\"price\":160000000000000000000}]");
        record.setLeaseCarModelColorPriceVoList(getLeaseCarModelColorPriceVoList);
        leaseCarModelAdapter.insertSelective(record);

        //leaseCarModelAdapter.findPage(1, 2, null);
        //leaseCarModelAdapter.selectById(1l);

        /*
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        //paramsMap.put("isEnable", true);
        paramsMap.put("model", AreaModel.MODEL_DEALER);
        Map<String, Object> insertViewParames = leaseDealerAdapter.insertViewParames(paramsMap);
        */

        /*
        LeaseCarModel leaseCarModel = new LeaseCarModel();
        leaseCarModel.setId(29l);
        leaseCarModel.setCompleteModelName("XDXD");
        leaseCarModelAdapter.updateByPrimaryKeySelective(leaseCarModel);
        */


        //leaseAreaAdapter.findAreaByEnableAndModel(paramsMap);

        //Map<String, Object> insertViewParames = leaseCarModelAdapter.insertViewParames(null);


        //leaseCarModelAdapter.findAll(null);

        /*
        List<Long> ids = new ArrayList<Long>();
        ids.add(1l);
        ids.add(2l);
        leaseDealerAdapter.deleteBatchById(ids);
        */

        //leaseCarModelAdapter.findPage(1, 2, null);

        /*
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("grade",2);
        PageInfo<LeaseDealer> page = leaseDealerAdapter.findPage(1, 5, paramsMap);
        */

        /*
        LeaseCarBrands leaseCarBrands = new LeaseCarBrands();
        leaseCarBrands.setName("aaaa");
        leaseCarBrandsAdapter.insertSelective(leaseCarBrands);
        */
        //leaseCarBrandsAdapter.findPage(1,3,null);


        /*
        Field[] fields = DictType.class.getDeclaredFields();
        DictType dictType = new DictType();
        for(Field f:fields){
            System.out.println(f.getName());
            System.out.println(f.get(dictType));
        }
        */

    }
}
