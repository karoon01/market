package com.yosypchuk.market.api;

import com.yosypchuk.market.model.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("User management API")
@RequestMapping("/api/v1/user")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface UserApi {
    @ApiOperation("Get user by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    UserDTO getUserById(@PathVariable Long id);

    @ApiOperation("Get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    @ApiResponse(code = 200, message = "OK")
    List<UserDTO> getAllUsers();

    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    UserDTO updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO);

    @ApiOperation("Delete user by id")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    ResponseEntity<Void> deleteUser(@PathVariable Long id);
}
