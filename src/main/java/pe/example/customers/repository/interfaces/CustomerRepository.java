package pe.example.customers.repository.interfaces;

import java.util.List;
import java.util.Map;

import pe.example.customers.application.domain.Customer;
import pe.example.customers.application.domain.Pagination;

public interface CustomerRepository {

	Customer getSearch(Map<String,Object> parametersJson);

	List<Customer> getSearch(Map<String,Object> parametersJson,Pagination pagination);

	List<Customer> getFindAll(Map<String,Object> parametersJson,Pagination pagination);

	void setInsertUpdate(Customer o);

}