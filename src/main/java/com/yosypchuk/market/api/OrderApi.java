package com.yosypchuk.market.api;

import com.yosypchuk.market.model.dto.OrderDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("Order management API")
@RequestMapping("/api/v1/order")
public interface OrderApi {

    @ApiOperation("Create user order")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 409, message = "Conflict")
    })
    OrderDTO createOrder(@RequestBody @Valid OrderDTO orderDTO);

    @ApiOperation("Get all orders")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    @ApiResponse(code = 200, message = "OK")
    List<OrderDTO> getAllOrders();

    @ApiOperation("Get all user's orders")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/all")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    List<OrderDTO> getAllUserOrders(@PathVariable Long userId);

    @ApiOperation("Delete order")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{orderId}/delete")
    @ApiResponses({
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    ResponseEntity<Void> removeOrder(@PathVariable Long orderId);

    @ApiOperation("Reject order")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{orderId}/reject")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    ResponseEntity<Void> rejectOrder(@PathVariable Long orderId);
}
