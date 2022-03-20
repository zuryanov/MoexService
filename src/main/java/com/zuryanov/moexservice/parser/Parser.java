package com.zuryanov.moexservice.parser;

import com.zuryanov.moexservice.dto.BondDto;

import java.util.List;

public interface Parser {
    List<BondDto> parse(String ratesAsString);
}
