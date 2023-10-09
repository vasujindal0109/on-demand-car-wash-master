package com.green.car.wash.company.washer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.green.car.wash.company.washer.model.OrderDetails;
import com.green.car.wash.company.washer.model.WashPacks;

import java.util.Arrays;
import java.util.List;

@Service
public class WasherService {
    @Autowired
    private RestTemplate restTemplate;
    String url1="http://ADMIN/admins";
    //Url to access the methods of Order Service
    String url="http://ORDER/orders";

    /** Only the methods that use rest template are below this comment **/
    //To see all the WashPacks
    public List<WashPacks> getAllWP(){
        WashPacks[] wp=restTemplate.getForObject(url1+"/all/findWP",WashPacks[].class);
        return (Arrays.asList(wp));
    }
    //To see the Unassigned orders
    public List<OrderDetails> getUnassignedOrders(){
        OrderDetails[] unassignedList = restTemplate.getForObject(url+"/findUnassigned",OrderDetails[].class);
        return Arrays.asList(unassignedList);
    }
    //To update the status of the order by Washer
    public OrderDetails updateStatus(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails,headers);
        OrderDetails od = restTemplate.exchange(url+"/updateStatus/completed", HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
        return od;
    }
    //To assign a washer to the order by washer
    public OrderDetails assignSelf(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> assignedWasher = new HttpEntity<>(orderDetails,headers);
        OrderDetails od = restTemplate.exchange(url+"/assignWasher", HttpMethod.PUT,assignedWasher,OrderDetails.class).getBody();
        return od;
    }
}
