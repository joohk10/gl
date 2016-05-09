package web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import web.service.TestService;
import web.service.testVO;
import web.service.impl.TestDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestServiceImpl implements TestService {

	@Resource(name = "TestDAO")
	private TestDAO testDAO;
	
	public Map<String, Object> list(testVO _testVO) throws Exception{
		List<testVO> list = testDAO.selectEmpList(_testVO);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("List", list);
		
		return map;
	}
}
