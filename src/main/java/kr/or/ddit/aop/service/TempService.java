package kr.or.ddit.aop.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.aop.dao.TempDaoInf;

import org.springframework.stereotype.Service;

@Service("tempService")
public class TempService implements TempServiceInf {

	
	@Resource(name="tempDao")
	private TempDaoInf tempDao;
	
	
	@Override
	public List getAllStrudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStudnet(Map<String, String> map) {
		
		int insertCnt = 0;
		
		// 첫번째 학생 입력
		insertCnt += tempDao.insertStudnet(map);
		
		// 첫번째 학생 입력후 강제 예외 발생
		try{
			throw new RuntimeException();
		} catch(Exception e) {
			throw new RuntimeException();
		}
		
		// 두번째 학생 입력
//		map.put("id", "");
//		insertCnt += tempDao.insertStudnet(map);
		
//		return insertCnt;
	}

}
