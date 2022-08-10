package com.sina.parkingApplication.mapper;

import com.sina.parkingApplication.dto.request.VehicleRequestDTO;
import com.sina.parkingApplication.dto.response.VehicleResponseDTO;
import com.sina.parkingApplication.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-10T17:14:12+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public Vehicle toVehicle(VehicleRequestDTO vehicleRequestDTO) {
        if ( vehicleRequestDTO == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setId( vehicleRequestDTO.getId() );
        vehicle.setVersion( vehicleRequestDTO.getVersion() );
        vehicle.setCreatedDate( vehicleRequestDTO.getCreatedDate() );
        vehicle.setCreatedBy( vehicleRequestDTO.getCreatedBy() );
        vehicle.setLastModifiedDate( vehicleRequestDTO.getLastModifiedDate() );
        vehicle.setLastModifiedBy( vehicleRequestDTO.getLastModifiedBy() );
        vehicle.setPlateNumber( vehicleRequestDTO.getPlateNumber() );
        vehicle.setCarClass( vehicleRequestDTO.getCarClass() );

        return vehicle;
    }

    @Override
    public List<Vehicle> toVehicleList(List<VehicleRequestDTO> vehicleRequestDTOList) {
        if ( vehicleRequestDTOList == null ) {
            return null;
        }

        List<Vehicle> list = new ArrayList<Vehicle>( vehicleRequestDTOList.size() );
        for ( VehicleRequestDTO vehicleRequestDTO : vehicleRequestDTOList ) {
            list.add( toVehicle( vehicleRequestDTO ) );
        }

        return list;
    }

    @Override
    public VehicleResponseDTO toParkingResponseDTO(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();

        vehicleResponseDTO.setId( vehicle.getId() );
        vehicleResponseDTO.setVersion( vehicle.getVersion() );
        vehicleResponseDTO.setCreatedDate( vehicle.getCreatedDate() );
        vehicleResponseDTO.setCreatedBy( vehicle.getCreatedBy() );
        vehicleResponseDTO.setLastModifiedDate( vehicle.getLastModifiedDate() );
        vehicleResponseDTO.setLastModifiedBy( vehicle.getLastModifiedBy() );
        vehicleResponseDTO.setPlateNumber( vehicle.getPlateNumber() );
        vehicleResponseDTO.setCarClass( vehicle.getCarClass() );

        return vehicleResponseDTO;
    }

    @Override
    public List<VehicleResponseDTO> toVehicleResponseDTOList(List<Vehicle> vehicleList) {
        if ( vehicleList == null ) {
            return null;
        }

        List<VehicleResponseDTO> list = new ArrayList<VehicleResponseDTO>( vehicleList.size() );
        for ( Vehicle vehicle : vehicleList ) {
            list.add( toParkingResponseDTO( vehicle ) );
        }

        return list;
    }
}
