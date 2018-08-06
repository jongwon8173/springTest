package kr.or.ddit.aop.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("tempDao")
public class TempDao implements TempDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public List getAllStrudent() {
		return template.selectList("temp.getAllStudent");
	}

	@Override
	public int insertStudnet(Map<String, String> map) {
		System.out.println("====================================================");
		System.out.println(map.get("id") + " // " + map.get("name") + " // " + map.get("call_cnt"));
		
		return template.insert("temp.insertStudent", map);
		
	}

}
