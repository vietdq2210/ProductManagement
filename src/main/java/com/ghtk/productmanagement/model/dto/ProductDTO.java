package com.ghtk.productmanagement.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ghtk.productmanagement.model.entity.Category;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ProductDTO {
    private String name;
    private Integer price;
    private String sku;
    private String description;
    @JsonProperty("category_id")
    private Long categoryId;
}
