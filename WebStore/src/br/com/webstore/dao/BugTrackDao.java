//#if ${Event} == "T"
package br.com.webstore.dao;

import br.com.webstore.model.BugTrack;

public class BugTrackDao extends GenericDao<BugTrack, Integer>{
	public BugTrackDao() {
		super(BugTrack.class);
	}

}
//#endif