package javaconfig;

import kr.or.ddit.ioc.dao.IocAnnotationDao;
import kr.or.ddit.ioc.dao.IocDao;
import kr.or.ddit.ioc.service.IocService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages={"kr.or.ddit.ioc"})
//@Component, @Controller, @Service, @Repository
public class JavaAnnotationConfig {

	@Bean(name={"iocDao"})
	public IocAnnotationDao getIocDao(){
		return new IocAnnotationDao();
	}
	
	@Bean(name={"iocService"})
	public IocService getIocService() {
		IocService iocService = new IocService();
		iocService.setIocDao(getIocDao());
		
		return iocService;
	}
	
}
