package com.zuryanov.moexservice.dto;

import com.zuryanov.moexservice.model.Stock;
import lombok.Value;

import java.util.List;

@Value
public class StocksDto {
    List<Stock> stocks;
}
