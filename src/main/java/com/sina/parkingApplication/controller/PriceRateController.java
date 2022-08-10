package com.sina.parkingApplication.controller;


import com.sina.parkingApplication.common.PagingData;
import com.sina.parkingApplication.dto.request.PriceRateRequestDTO;
import com.sina.parkingApplication.dto.response.PriceRateResponseDTO;
import com.sina.parkingApplication.mapper.PriceRateMapper;
import com.sina.parkingApplication.model.PriceRate;
import com.sina.parkingApplication.service.IPriceRateService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/priceRate")
@AllArgsConstructor
public class PriceRateController {

    private final IPriceRateService priceRateService;
    private final PriceRateMapper priceRateMapper;


    @PostMapping
    public PriceRateResponseDTO addPriceRate(@RequestBody PriceRateRequestDTO priceRateRequestDTO) {
        PriceRate priceRate = priceRateMapper.toPriceRate(priceRateRequestDTO);
        PriceRate saved = priceRateService.addPriceRate(priceRate);
        return priceRateMapper.toPriceRateResponseDTO(saved);
    }

    @GetMapping(value = "/{page}/{size}")
    public PagingData<PriceRateResponseDTO> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<PriceRate> priceRatePage = priceRateService.paging(page, size);
        int totalPage = priceRatePage.getTotalPages();
        List<PriceRate> data = priceRatePage.getContent();
        List<PriceRateResponseDTO> priceRateResponseDTOList = priceRateMapper.toPriceRateResponseDTOList(data);
        return new PagingData<>(totalPage, page, priceRateResponseDTOList);
    }

    @GetMapping(value = "/{id}")
    public PriceRateResponseDTO findPriceRate(@PathVariable Long id) {
        PriceRate priceRate = priceRateService.getPriceRate(id);
        return priceRateMapper.toPriceRateResponseDTO(priceRate);
    }

    @PutMapping
    public PriceRateResponseDTO updatePriceRate(@RequestBody PriceRateRequestDTO priceRateRequestDTO) {
        PriceRate priceRate = priceRateMapper.toPriceRate(priceRateRequestDTO);
        PriceRate saved = priceRateService.updatePriceRate(priceRate);
        return priceRateMapper.toPriceRateResponseDTO(saved);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePriceRate(@PathVariable Long id) {
        priceRateService.deletePriceRate(id);
    }
}
