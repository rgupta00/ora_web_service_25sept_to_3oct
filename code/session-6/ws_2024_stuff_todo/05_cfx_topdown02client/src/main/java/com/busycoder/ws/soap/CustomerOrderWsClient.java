package com.busycoder.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.busycoder.ws.soap.impl.CustomerOrdersPortTypeImplService;
import com.busycoder.ws.trainings.CustomerOrdersPortType;
import com.busycoder.ws.trainings.GetOrdersRequest;
import com.busycoder.ws.trainings.GetOrdersResponse;
import com.busycoder.ws.trainings.Order;


public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		
		CustomerOrdersPortTypeImplService service = new CustomerOrdersPortTypeImplService(
				new URL("http://localhost:8080/wsdlfirstws/customerorderservice?wsdl"));
		
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersPortTypeImplPort();

		GetOrdersRequest request = new GetOrdersRequest();
		
		request.setCustomerId(BigInteger.valueOf(1));
		
		GetOrdersResponse response = customerOrdersWsImplPort.getOrders(request);
		List<Order> orders = response.getOrder();
		System.out.println("Number of orders for the customer are:" + orders.size());

	}

}
