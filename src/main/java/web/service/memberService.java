package web.service;

import java.util.List;

public interface memberService {
	
	public List<memberVO> getUser(memberVO _memberVO) throws Exception;
	public List<memberVO> getUserInfoBySeq(memberVO _memberVO) throws Exception;
	public void insertUser(memberVO _memberVO) throws Exception;
}