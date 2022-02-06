package pe.example.customers.api.query;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pe.example.customers.application.domain.Pagination;

public class PaginationQuery {
	private int pageIndex;
	private int pageSize;
	private String sort;	
	private Pagination pagination;
	
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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public Pagination getPagination()
	{
        if (this.pagination == null)
        {
            if (this.pageIndex > 0 && this.pageSize > 0)
                this.pagination = new Pagination(this.pageIndex, this.pageSize, this.sort);
            else
                this.pagination = new Pagination(this.sort);
        }

        return this.pagination;
	}
	
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }		
}
