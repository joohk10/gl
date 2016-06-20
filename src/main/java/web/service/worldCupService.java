package web.service;

import java.util.List;

public interface worldCupService {
	public List<worldCupVO> chkWorldCup(worldCupVO _worldCupVO) throws Exception;
	public List<memberVO> getWorldCupMember(worldCupVO _worldCupVO) throws Exception;
	public List<memberVO> getWorldCupOldMember(worldCupVO _worldCupVO) throws Exception;
	public void insertWorldCupLog(worldCupVO _worldCupVO) throws Exception;
	public void updateWorldCupLog(worldCupVO _worldCupVO) throws Exception;
}
