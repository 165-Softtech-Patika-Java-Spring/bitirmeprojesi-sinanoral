package com.softtech.mapper;

import com.softtech.model.entity.Product;
import com.softtech.model.requestDto.ProductCreateDto;
import com.softtech.model.requestDto.ProductUpdateDto;
import com.softtech.model.responseDto.ProductGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    List<ProductGetDto> productListToProductGetDtoList(List<Product> products);

    @Mapping(source = "category.name", target = "category")
    ProductGetDto productToProductGetDto(Product product);

    @Mapping(source = "categoryId", target = "category.id")
    Product productCreateDtoProduct(ProductCreateDto productCreateDto);

    @Mapping(source = "categoryId", target = "category.id")
    Product productUpdateDtoToProduct(ProductUpdateDto productUpdateDto);
}