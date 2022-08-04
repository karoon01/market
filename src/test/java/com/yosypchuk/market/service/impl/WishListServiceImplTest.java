package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.model.dto.ProductDTO;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.User;
import com.yosypchuk.market.model.entity.WishList;
import com.yosypchuk.market.repository.ProductRepository;
import com.yosypchuk.market.repository.UserRepository;
import com.yosypchuk.market.repository.WishListRepository;
import com.yosypchuk.market.utils.test.TestWishListDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.yosypchuk.market.utils.test.TestWishListDataUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WishListServiceImplTest {
    @InjectMocks
    private WishListServiceImpl wishListService;
    @Mock
    private WishListRepository wishListRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ProductRepository productRepository;

    @Test
    void testAddProductToWishList() {
        //given
        WishList expectedWishList = TestWishListDataUtil.createWishList();

        when(userRepository.findById(MOCK_USER.getId())).thenReturn(Optional.of(MOCK_USER));
        when(productRepository.findById(MOCK_PRODUCT.getId())).thenReturn(Optional.of(MOCK_PRODUCT));
        doNothing().when(wishListRepository).addProductToWishList(MOCK_USER.getId(), MOCK_PRODUCT.getId());
        //when
        wishListService.addProductToWishList(MOCK_USER.getId(), MOCK_PRODUCT.getId());

        //then
        verify(wishListRepository, times(1)).addProductToWishList(MOCK_USER.getId(), MOCK_PRODUCT.getId());
    }

    @Test
    void testAddProductToWishListThrowsExceptionIfUserDoesntExist() {
        //when
        when(userRepository.findById(MOCK_USER.getId())).thenReturn(Optional.empty());

        //then
        assertThrows(EntityNotFoundException.class, () -> wishListService.addProductToWishList(MOCK_USER.getId(), MOCK_PRODUCT.getId()));
    }

    @Test
    void testAddProductToWishListThrowsExceptionIfProductDoesntExist() {
        //when
        when(userRepository.findById(MOCK_USER.getId())).thenReturn(Optional.of(MOCK_USER));
        when(productRepository.findById(MOCK_PRODUCT.getId())).thenReturn(Optional.empty());

        //then
        assertThrows(EntityNotFoundException.class, () -> wishListService.addProductToWishList(MOCK_USER.getId(), MOCK_PRODUCT.getId()));
    }

    @Test
    void testRemoveProductFromWishList() {
        //given
        WishList wishList = TestWishListDataUtil.createWishList();

        when(userRepository.findById(MOCK_USER.getId())).thenReturn(Optional.of(MOCK_USER));
        when(productRepository.findById(MOCK_PRODUCT.getId())).thenReturn(Optional.of(MOCK_PRODUCT));
        doNothing().when(wishListRepository).deleteProductFromWishList(MOCK_USER.getId(), MOCK_PRODUCT.getId());

        //when
        wishListService.removeProductFromWishList(MOCK_USER.getId(), MOCK_PRODUCT.getId());

        //then
        verify(wishListRepository, times(1)).deleteProductFromWishList(MOCK_USER.getId(), MOCK_PRODUCT.getId());
    }

    @Test
    void testRemoveProductFromWishListThrowsExceptionIfUserDoesntExist() {
        //when
        when(userRepository.findById(MOCK_USER.getId())).thenReturn(Optional.empty());

        //then
        assertThrows(EntityNotFoundException.class, () -> wishListService.removeProductFromWishList(MOCK_USER.getId(), MOCK_PRODUCT.getId()));
    }

    @Test
    void testRemoveProductFromWishListThrowsExceptionIfProductDoesntExist() {
        //when
        when(userRepository.findById(MOCK_USER.getId())).thenReturn(Optional.of(MOCK_USER));
        when(productRepository.findById(MOCK_PRODUCT.getId())).thenReturn(Optional.empty());

        //then
        assertThrows(EntityNotFoundException.class, () -> wishListService.removeProductFromWishList(MOCK_USER.getId(), MOCK_PRODUCT.getId()));
    }

    @Test
    void testGetAllUserProductsFromWishList() {
        //given
        List<Product> productList = List.of(MOCK_PRODUCT, MOCK_PRODUCT_SECOND);

        when(userRepository.findById(MOCK_USER.getId())).thenReturn(Optional.of(MOCK_USER));
        when(wishListRepository.findAllByUserId(MOCK_USER.getId())).thenReturn(productList);

        //when
        List<ProductDTO> products = wishListService.getAllUserProductsFromWishList(MOCK_USER.getId());

        //then
        assertThat(products, hasSize(2));
    }

    @Test
    void testGetAllUserProductsFromWishListThrowsExceptionIfUserDoesntExist() {
        //when
        when(userRepository.findById(MOCK_USER.getId())).thenReturn(Optional.empty());

        //then
        assertThrows(EntityNotFoundException.class, () -> wishListService.getAllUserProductsFromWishList(MOCK_USER.getId()));
    }
}
