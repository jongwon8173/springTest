package kr.or.ddit.ioc.dao;

import org.springframework.stereotype.Repository;


@Repository("iocDao")
public class IocAnnotationDao implements IocDaoInf{

	@Override
	public String hello() {
		
		return "sayHello";
	}
	

}
