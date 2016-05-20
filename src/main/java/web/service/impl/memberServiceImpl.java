package web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.service.memberService;
import web.service.memberVO;

@Service
@Transactional
public class memberServiceImpl implements memberService {
	
	@Resource(name = "memberDAO")
	private memberDAO memberDAO;

	public List<memberVO> getUser(memberVO _memberVO) throws Exception {
		return memberDAO.selectUser(_memberVO);
	}
	public void insertUser(memberVO _memberVO) throws Exception {
		memberDAO.insertUser(_memberVO);
	}
}
