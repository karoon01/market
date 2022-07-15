package com.yosypchuk.market.api;

import com.yosypchuk.market.model.dto.AuthRequestDTO;
import com.yosypchuk.market.model.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api("Authorization and authentication management API")
@RequestMapping("/api/v1/auth")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface AuthApi {
    @ApiOperation("Register user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    UserDTO register(@RequestBody @Valid UserDTO userDTO);

    @ApiOperation("Sign in user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/register")
    ResponseEntity<UserDTO> login(@RequestBody @Valid AuthRequestDTO request);

}
