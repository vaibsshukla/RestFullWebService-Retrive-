package org.ws.tutorial.wc.model;

import java.util.List;

import org.apache.log4j.Logger;
import org.displaytag.properties.SortOrderEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CustomPaginated implements PaginatedExtended {
	
	private static Logger logger = Logger.getLogger(CustomPaginated.class);

	private List list;
	private int pageNumber;
	private int objectsPerPage;
	private int fullListSize;

	public CustomPaginated() {
	}
	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public int getPageNumber() {
		// TODO Auto-generated method stub
		return pageNumber;
	}
	@Override
	public int getObjectsPerPage() {
		// TODO Auto-generated method stub
		return objectsPerPage;
	}
	@Override
	public int getFullListSize() {
		// TODO Auto-generated method stub
		return fullListSize;
	}
	@Override
	public String getSortCriterion() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SortOrderEnum getSortDirection() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getSearchId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	@Override
	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = objectsPerPage;
	}
	@Override
	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
	}
	
}
