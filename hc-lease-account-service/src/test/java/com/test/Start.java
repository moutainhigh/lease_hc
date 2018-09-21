package com.test;

import java.math.BigDecimal;

public class Start {
	/*
	static{  
        PropertyConfigurator.configure("src/main/resources/config/log4j.properties");
    }
	*/
	public static void main(String[] args) {
		
		//com.alibaba.dubbo.container.Main.main(args);
/*

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring*/
/*.xml"});
		LeaseAccountMapper leaseAccountMapper = (LeaseAccountMapper) context.getBean("leaseAccountMapper");
		System.out.println(leaseAccountMapper.selectByPrimaryKey(1l));
*/
		System.out.print(debx(new BigDecimal(10000), new BigDecimal(0.015), 36));
	}

	private static BigDecimal debx(BigDecimal total, BigDecimal monthRate, int terms) {
		BigDecimal tmp = monthRate.add(new BigDecimal(1)).pow(terms);
		return total.multiply(monthRate).multiply(tmp).divide(tmp.subtract(new BigDecimal(1)), 2, BigDecimal.ROUND_HALF_UP);
	}

}
