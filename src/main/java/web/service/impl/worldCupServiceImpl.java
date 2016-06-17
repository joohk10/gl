package web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.service.worldCupService;

@Service
@Transactional
public class worldCupServiceImpl implements worldCupService {

	@Resource(name = "worldCupDAO")
	private worldCupDAO worldCupDAO;
}
