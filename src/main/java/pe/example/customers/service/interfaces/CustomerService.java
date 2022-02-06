package pe.example.customers.service.interfaces;

import java.util.List;

import pe.example.customers.application.domain.Customer;
import pe.example.customers.application.domain.Pagination;

public interface CustomerService {

	Customer getSelect(int id);

	List<Customer> getSelect(int id, Pagination pagination);

	List<Customer> getList(int id, Pagination pagination);

	void setRegister(Customer o);

	void setUpdate(int id,Customer o);

}