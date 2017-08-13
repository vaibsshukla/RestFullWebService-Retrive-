package org.ws.tutorial.wc.model;

import java.util.List;

import org.displaytag.pagination.PaginatedList;

public interface PaginatedExtended extends PaginatedList{
	
	public void setList(List list);
	public void setPageNumber(int pageNumber);
	public void setObjectsPerPage(int objectsPerPage);
	public void setFullListSize(int fullListSize);
}
