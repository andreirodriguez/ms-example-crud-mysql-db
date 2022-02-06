package pe.example.customers.application.domain;

public class Pagination {
	
	public Pagination(String sort)
	{
		this.sort = (sort == null) ? "" : sort;
	}
	
    public Pagination(int pageIndex, int pageSize, String sort)
    {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.sort = (sort == null) ? "" : sort;
    }	
	
	private int pageIndex;
	private int pageSize;
	private int pageCount;
	private String sort;
	private int total = 0;
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getTotal()
	{
		return total;
	}
	public void setTotal(int total)
	{
        if (this.pageSize > 0)
            this.pageCount = (total / this.pageSize + ((total % this.pageSize == 0) ? 0 : 1));
        else
            this.pageCount = 1;
		
		this.total = total;
	}
}
