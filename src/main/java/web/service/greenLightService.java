package web.service;

import java.util.List;

public interface greenLightService {

	public List<greenLightVO> chkGreenLight(greenLightVO _greenLightVO) throws Exception;
	public List<greenLightVO> chkDoubleLight(greenLightVO _greenLightVO) throws Exception;
	public List<greenLightVO> countLight(greenLightVO _greenLightVO) throws Exception;
	public void insertGreenLight(greenLightVO _greenLightVO) throws Exception;
	
}
