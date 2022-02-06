package pe.example.customers.application.mapper;

import java.util.ArrayList;
import java.util.List;

import pe.example.customers.api.request.CustomerRequest;
import pe.example.customers.api.response.CustomerResponse;
import pe.example.customers.application.domain.Customer;

public class CustomerMapper {

	public static CustomerResponse ToSelectCustomerResponse(Customer i) {
		CustomerResponse o = new CustomerResponse();

		o.setId(i.getId());
		o.setTitle(i.getTitle());
		o.setComment(i.getComment());
		o.setAmountSell(i.getAmountSell());
		o.setRegisterUserId(i.getRegisterUserId());
		o.setRegisterUserFullname(i.getRegisterUserFullname());
		o.setRegisterDatetime(i.getRegisterDatetime());
		o.setActive(i.getActive());

		return o;
	}

	public static List<CustomerResponse> ToArraySelectCustomerResponse(List<Customer> l) {
		List<CustomerResponse> o = new ArrayList<CustomerResponse>();

		for(Customer i:l)
			o.add(CustomerMapper.ToSelectCustomerResponse(i));

		return o;
	}

	public static CustomerResponse ToListCustomerResponse(Customer i) {
		CustomerResponse o = new CustomerResponse();

		o.setId(i.getId());
		o.setTitle(i.getTitle());
		o.setComment(i.getComment());
		o.setAmountSell(i.getAmountSell());
		o.setRegisterUserId(i.getRegisterUserId());
		o.setRegisterUserFullname(i.getRegisterUserFullname());
		o.setRegisterDatetime(i.getRegisterDatetime());
		o.setActive(i.getActive());

		return o;
	}

	public static List<CustomerResponse> ToArrayListCustomerResponse(List<Customer> l) {
		List<CustomerResponse> o = new ArrayList<CustomerResponse>();

		for(Customer i:l)
			o.add(CustomerMapper.ToListCustomerResponse(i));

		return o;
	}

	public static Customer FromCustomerRequest(CustomerRequest i) {
		Customer o = new Customer();

		o.setId(i.getId());
		o.setTitle(i.getTitle());
		o.setComment(i.getComment());
		o.setAmountSell(i.getAmountSell());
		o.setRegisterUserId(i.getRegisterUserId());
		o.setRegisterUserFullname(i.getRegisterUserFullname());
		o.setRegisterDatetime(i.getRegisterDatetime());
		o.setActive(i.getActive());

		return o;
	}

	public static CustomerResponse ToRegisterCustomerResponse(Customer i) {
		CustomerResponse o = new CustomerResponse();

		o.setId(i.getId());
		o.setTitle(i.getTitle());
		o.setComment(i.getComment());
		o.setAmountSell(i.getAmountSell());
		o.setRegisterUserId(i.getRegisterUserId());
		o.setRegisterUserFullname(i.getRegisterUserFullname());
		o.setRegisterDatetime(i.getRegisterDatetime());
		o.setActive(i.getActive());

		return o;
	}

}