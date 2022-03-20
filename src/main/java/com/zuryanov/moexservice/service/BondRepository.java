package com.zuryanov.moexservice.service;

import com.zuryanov.moexservice.dto.BondDto;
import com.zuryanov.moexservice.exception.LimitRequestsException;
import com.zuryanov.moexservice.moexclient.CorporateBondsClient;
import com.zuryanov.moexservice.moexclient.GovBondsClient;
import com.zuryanov.moexservice.parser.Parser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BondRepository {

    private final CorporateBondsClient corporateBondsClient;
    private final GovBondsClient govBondsClient;
    private final Parser parser;

    @Cacheable(value = "corps")
    public List<BondDto> getCorporateBonds() {
        log.info("Getting corporate bonds from Moex");
        String xmlFromMoex =  corporateBondsClient.getBondsFromMoex();
        List<BondDto> bondDtos = parser.parse(xmlFromMoex);
        if (bondDtos.isEmpty()) {
            log.error("Moex isn't answering for getting corporate bounds.");
            throw new LimitRequestsException("Moex isn't answering for getting corporate bonds.");
        }
        return bondDtos;
    }

    @Cacheable(value = "govs")
    public List<BondDto> getGovBonds() {
        log.info("Getting government bonds from Moex");
        String xmlFromMoex =  govBondsClient.getBondsFromMoex();
        List<BondDto> bondDtos = parser.parse(xmlFromMoex);
        if (bondDtos.isEmpty()) {
            log.error("Moex isn't answering for getting governments bounds.");
            throw new LimitRequestsException("Moex isn't answering for getting governments bonds.");
        }
        return bondDtos;
    }
}
