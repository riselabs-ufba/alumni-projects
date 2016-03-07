package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.BugTrack;

public interface IBugTrackFacade {
	public BugTrack insertBugTrack(BugTrack bugTrack);

	public void updateBugTrack(BugTrack bugTrack);
	
	public List<BugTrack> findBugTrack(BugTrack query);
	
}
