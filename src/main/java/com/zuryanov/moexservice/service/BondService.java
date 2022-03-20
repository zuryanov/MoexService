package com.zuryanov.moexservice.service;

import com.zuryanov.moexservice.dto.FigiesDto;
import com.zuryanov.moexservice.dto.StocksDto;
import com.zuryanov.moexservice.dto.StocksPricesDto;
import com.zuryanov.moexservice.dto.TickersDto;

public interface BondService {

    StocksDto getBondsFromMoex(TickersDto tickersDto);

    StocksPricesDto getPricesByFigies(FigiesDto figiesDto);
}
