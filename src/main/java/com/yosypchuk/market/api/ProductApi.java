package com.yosypchuk.market.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;

@Api("Product management API")
@RequestMapping("/api/v1/product")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface ProductApi {
}
