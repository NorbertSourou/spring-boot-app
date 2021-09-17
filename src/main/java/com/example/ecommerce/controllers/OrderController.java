package com.example.ecommerce.controllers;

import com.example.ecommerce.model.*;
import com.example.ecommerce.service.CustomerService;
import com.example.ecommerce.service.OrderItemService;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/{id}/order")
    public List<Order> orderList(@PathVariable int id) {
        return customerService.get(id).get().getOrders();
    }

    @PostMapping("/{id}/order")
    public ResponseEntity addOrder(@PathVariable int id, @RequestBody Order order) {


        order.setCustomer(customerService.get(id).get());
        orderService.addOrder(order);
        List<OrderItem> orderItems = order.getOrderItem();
        for (OrderItem item :
                orderItems) {
            item.setOrders(order);
//            item.setProduct(item.getProduct());
            orderItemService.addOrderItem(item);
        }
        return new ResponseEntity(new ExceptionResponse(new Date(), "Order ajouté avec succès"), HttpStatus.CREATED);

    }

}
