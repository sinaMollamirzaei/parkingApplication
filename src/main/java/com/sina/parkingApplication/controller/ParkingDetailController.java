package com.sina.parkingApplication.controller;


import com.sina.parkingApplication.common.PagingData;
import com.sina.parkingApplication.dto.request.ParkingDetailRequestDTO;
import com.sina.parkingApplication.dto.response.ParkingDetailResponseDTO;
import com.sina.parkingApplication.mapper.ParkingDetailMapper;
import com.sina.parkingApplication.model.ParkingDetail;
import com.sina.parkingApplication.service.IParkingDetailService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/parkingDetail")
@AllArgsConstructor
public class ParkingDetailController {

    private final IParkingDetailService parkingDetailService;
    private final ParkingDetailMapper parkingDetailMapper;

    @PostMapping
    public ParkingDetailResponseDTO addParkingDetail(@RequestBody ParkingDetailRequestDTO parkingDetailRequestDTO) {
        ParkingDetail parkingDetail = parkingDetailMapper.toParkingDetail(parkingDetailRequestDTO);
        ParkingDetail saved = parkingDetailService.registerRequest(parkingDetail);
        return parkingDetailMapper.toParkingDetailResponseDTO(saved);
    }

    @GetMapping(value = "/{page}/{size}")
    public PagingData<ParkingDetailResponseDTO> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<ParkingDetail> parkingDetailPage = parkingDetailService.paging(page, size);
        int totalPage = parkingDetailPage.getTotalPages();
        List<ParkingDetail> data = parkingDetailPage.getContent();
        List<ParkingDetailResponseDTO> parkingDetailResponseDTOList = parkingDetailMapper.toParkingDetailResponseDTOList(data);
        return new PagingData<>(totalPage, page, parkingDetailResponseDTOList);
    }

    @GetMapping(value = "/{plateNumber}/{page}/{size}")
    public PagingData<ParkingDetailResponseDTO> findAllByVehicleId(@PathVariable String plateNumber, @PathVariable Integer page, @PathVariable Integer size) {
        Page<ParkingDetail> parkingDetailPage = parkingDetailService.reportVehicleTraffic(plateNumber, page, size);
        int totalPage = parkingDetailPage.getTotalPages();
        List<ParkingDetail> data = parkingDetailPage.getContent();
        List<ParkingDetailResponseDTO> parkingDetailResponseDTOList = parkingDetailMapper.toParkingDetailResponseDTOList(data);
        return new PagingData<>(totalPage, page, parkingDetailResponseDTOList);
    }

    @GetMapping(value = "/{id}")
    public ParkingDetailResponseDTO findParkingDetail(@PathVariable Long id) {
        ParkingDetail parkingDetail = parkingDetailService.getParkingDetail(id);
        return parkingDetailMapper.toParkingDetailResponseDTO(parkingDetail);
    }

    @PutMapping
    public ParkingDetailResponseDTO updateParkingDetail(@RequestBody ParkingDetailRequestDTO parkingDetailRequestDTO) {
        ParkingDetail parkingDetail = parkingDetailMapper.toParkingDetail(parkingDetailRequestDTO);
        ParkingDetail saved = parkingDetailService.exitRequest(parkingDetail);
        return parkingDetailMapper.toParkingDetailResponseDTO(saved);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteParkingDetail(@PathVariable Long id) {
        parkingDetailService.deleteParkingDetail(id);
    }
}
