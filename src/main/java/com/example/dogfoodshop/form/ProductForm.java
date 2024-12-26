package com.example.dogfoodshop.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductForm {
    @NotBlank(message = "商品名を入力してください")
    private String name;

    @NotBlank(message = "商品説明を入力してください")
    private String description;

    @NotNull(message = "価格を入力してください")
    @Min(value = 0, message = "価格は0以上を入力してください")
    private BigDecimal price;

    @NotNull(message = "在庫数を入力してください")
    @Min(value = 0, message = "在庫数は0以上を入力してください")
    private Integer stock;

    @NotNull(message = "カテゴリーを選択してください")
    private Long categoryId;

    private String imageUrl;
}