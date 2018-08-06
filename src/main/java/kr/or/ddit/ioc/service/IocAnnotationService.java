package kr.or.ddit.ioc.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import kr.or.ddit.ioc.dao.IocDaoInf;

@Service("iocAnnotationService")
public class IocAnnotationService implements IocServiceInf{

	@Resource(name="iocDao")
	private IocDaoInf iocDao;

	@Override
	public String hello() {
		return iocDao.hello();
	}
	
	public IocAnnotationService() {
	}

	public IocDaoInf getIocDao() {
		return iocDao;
	}

	public void setIocDao(IocDaoInf iocDao) {
//		this.iocDao = iocDao;
	}
	
}
