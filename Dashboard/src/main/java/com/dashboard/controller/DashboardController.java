package com.dashboard.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dashboard.model.OrderDTO;
import com.dashboard.model.TransactionDTO;
import com.dashboard.model.FeeDTO;
import com.dashboard.service.DashboardService;

@Controller
public class DashboardController {
    
    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);
    
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/")
    public String dashboard(@RequestParam(required = false, defaultValue = "orders") String tab, Model model) {
        try {
            model.addAttribute("currentTab", tab);

            switch (tab) {
                case "orders":
                    List<OrderDTO> orders = dashboardService.getAllOrders()
                        .block(Duration.ofSeconds(10));
                    model.addAttribute("orders", orders != null ? orders : new ArrayList<>());
                    break;
                    
                case "transactions":
                    List<TransactionDTO> transactions = dashboardService.getAllTransactions()
                        .block(Duration.ofSeconds(10));
                    model.addAttribute("transactions", transactions != null ? transactions : new ArrayList<>());
                    break;
                    
                case "fees":
                    List<FeeDTO> fees = dashboardService.getAllFees()
                        .collectList()
                        .block(Duration.ofSeconds(10));
                    model.addAttribute("fees", fees != null ? fees : new ArrayList<>());
                    break;
            }
        } catch (Exception e) {
            log.error("Error fetching dashboard data: ", e);
            model.addAttribute("errorMessage", "Error loading dashboard data: " + e.getMessage());
            
            
            switch (tab) {
                case "orders":
                    model.addAttribute("orders", new ArrayList<>());
                    break;
                case "transactions":
                    model.addAttribute("transactions", new ArrayList<>());
                    break;
                case "fees":
                    model.addAttribute("fees", new ArrayList<>());
                    break;
            }
        }
        return "dashboard";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(OrderDTO orderDTO, Model model) {
        try {
            dashboardService.placeOrder(orderDTO)
                .block(Duration.ofSeconds(10));
            model.addAttribute("successMessage", "Order placed successfully!");
        } catch (Exception e) {
            log.error("Error placing order: ", e);
            model.addAttribute("errorMessage", "Error placing order: " + e.getMessage());
        }
        return "redirect:/?tab=orders";
    }
} 