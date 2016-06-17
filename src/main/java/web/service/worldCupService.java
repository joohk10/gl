package web.service;

import java.util.List;

public interface worldCupService {
	public List<memberVO> getWorldCupMember(worldCupVO _worldCupVO) throws Exception;
}
