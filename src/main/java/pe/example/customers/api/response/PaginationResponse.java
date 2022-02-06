package pe.example.customers.api.response;

import java.util.List;

import pe.example.customers.application.domain.Pagination;

public class PaginationResponse<T> 
{
    public PaginationResponse(Pagination pagination, List<T> items)
    {
        this.pagination = pagination;
        this.items = items;
    }

    private Pagination pagination;
    private List<T> items;
    
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
}
