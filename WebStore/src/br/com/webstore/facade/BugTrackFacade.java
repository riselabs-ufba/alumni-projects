package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.BugTrackDao;
import br.com.webstore.dao.UsuarioDao;
import br.com.webstore.model.BugTrack;

public class BugTrackFacade implements IBugTrackFacade{
	// @Inject
	private BugTrackDao bugTrackDao;
	
	public BugTrackFacade(){
		this.bugTrackDao = new BugTrackDao();
	}

	@Override
	public BugTrack insertBugTrack(BugTrack bugTrack) {
		return bugTrackDao.insert(bugTrack);
	}

	@Override
	public void updateBugTrack(BugTrack bugTrack) {
		bugTrackDao.update(bugTrack);
	}

	@Override
	public List<BugTrack> findBugTrack(BugTrack query) {
		return bugTrackDao.getList();
	}

}
