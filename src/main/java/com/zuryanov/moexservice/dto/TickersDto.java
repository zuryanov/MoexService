package com.zuryanov.moexservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class TickersDto {
    private List<String> tickers;
}
