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
	public List<memberVO> getUserInfoBySeq(memberVO _memberVO) throws Exception {
		return memberDAO.selectUserInfoBySeq(_memberVO);
	}
	public List<memberVO> searchUser(memberVO _memberVO) throws Exception {
		return memberDAO.searchUser(_memberVO);
	}
	public List<memberVO> searchUsern(memberVO _memberVO) throws Exception {
		return memberDAO.searchUsern(_memberVO);
	}
	public List<memberVO> searchgreen(memberVO _memberVO) throws Exception {
		return memberDAO.searchgreen(_memberVO);
	}
	public void insertUser(memberVO _memberVO) throws Exception {
		memberDAO.insertUser(_memberVO);
	}
	public void updateUser(memberVO _memberVO) throws Exception {
		memberDAO.updateUser(_memberVO);
	}
}
