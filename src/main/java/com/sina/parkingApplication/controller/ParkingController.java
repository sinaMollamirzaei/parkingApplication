package com.sina.parkingApplication.controller;


import com.sina.parkingApplication.common.PagingData;
import com.sina.parkingApplication.dto.request.ParkingRequestDTO;
import com.sina.parkingApplication.dto.response.ParkingResponseDTO;
import com.sina.parkingApplication.mapper.ParkingMapper;
import com.sina.parkingApplication.model.Parking;
import com.sina.parkingApplication.service.IParkingService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/parking")
@AllArgsConstructor
public class ParkingController {

    private final IParkingService parkingService;
    private final ParkingMapper parkingMapper;


    @PostMapping
    public ParkingResponseDTO addParking(@RequestBody ParkingRequestDTO parkingRequestDTO) {
        Parking parking = parkingMapper.toParking(parkingRequestDTO);
        Parking saved = parkingService.addParking(parking);
        return parkingMapper.toParkingResponseDTO(saved);
    }

    @GetMapping(value = "/{page}/{size}")
    public PagingData<ParkingResponseDTO> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Parking> parkingPage = parkingService.paging(page, size);
        int totalPage = parkingPage.getTotalPages();
        List<Parking> data = parkingPage.getContent();
        List<ParkingResponseDTO> parkingResponseDTOList = parkingMapper.toParkingResponseDTOList(data);
        return new PagingData<>(totalPage, page, parkingResponseDTOList);
    }

    @GetMapping(value = "/{id}")
    public ParkingResponseDTO findParking(@PathVariable Long id) {
        Parking parking = parkingService.getParking(id);
        return parkingMapper.toParkingResponseDTO(parking);
    }

    @PutMapping
    public ParkingResponseDTO updateParking(@RequestBody ParkingRequestDTO parkingRequestDTO) {
        Parking parking = parkingMapper.toParking(parkingRequestDTO);
        Parking saved = parkingService.updateParking(parking);
        return parkingMapper.toParkingResponseDTO(saved);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteParking(@PathVariable Long id){
        parkingService.deleteParking(id);
    }
}
