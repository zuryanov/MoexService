package com.zuryanov.moexservice.controller;

import com.zuryanov.moexservice.dto.FigiesDto;
import com.zuryanov.moexservice.dto.StocksDto;
import com.zuryanov.moexservice.dto.StocksPricesDto;
import com.zuryanov.moexservice.dto.TickersDto;
import com.zuryanov.moexservice.service.BondService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bonds")
public class MoexBondController {

    private final BondService bondService;

    @PostMapping("/getBondsByTickers")
    public StocksDto getBondsFromMoex(@RequestBody TickersDto tickersDto) {
        return bondService.getBondsFromMoex(tickersDto);
    }

    @PostMapping("/prices")
    public StocksPricesDto getPricesByFigies(@RequestBody FigiesDto figiesDto) {
        return bondService.getPricesByFigies(figiesDto);
    }
}
