package com.sina.parkingApplication.controller;


import com.sina.parkingApplication.common.PagingData;
import com.sina.parkingApplication.dto.request.VehicleRequestDTO;
import com.sina.parkingApplication.dto.response.VehicleResponseDTO;
import com.sina.parkingApplication.mapper.VehicleMapper;
import com.sina.parkingApplication.model.Vehicle;
import com.sina.parkingApplication.service.IVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/vehicle")
@AllArgsConstructor
public class VehicleController {

    private IVehicleService vehicleService;
    private final VehicleMapper vehicleMapper;


    @PostMapping
    public VehicleResponseDTO addVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleRequestDTO);
        Vehicle saved = vehicleService.addVehicle(vehicle);
        return vehicleMapper.toParkingResponseDTO(saved);
    }

    @GetMapping(value = "/{page}/{size}")
    public PagingData<VehicleResponseDTO> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Vehicle> vehiclePage = vehicleService.paging(page, size);
        int totalPage = vehiclePage.getTotalPages();
        List<Vehicle> data = vehiclePage.getContent();
        List<VehicleResponseDTO> vehicleResponseDTOList = vehicleMapper.toVehicleResponseDTOList(data);
        return new PagingData<>(totalPage, page, vehicleResponseDTOList);
    }

    @GetMapping(value = "/{id}")
    public VehicleResponseDTO findvehicle(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicle(id);
        return vehicleMapper.toParkingResponseDTO(vehicle);
    }

    @PutMapping
    public VehicleResponseDTO updateVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleRequestDTO);
        Vehicle saved = vehicleService.updateVehicle(vehicle);
        return vehicleMapper.toParkingResponseDTO(saved);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }
}
