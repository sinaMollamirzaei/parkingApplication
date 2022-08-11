package com.sina.parkingApplication.mapper;

import com.sina.parkingApplication.dto.request.ParkingRequestDTO;
import com.sina.parkingApplication.dto.response.ParkingResponseDTO;
import com.sina.parkingApplication.model.Parking;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-11T13:38:47+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ParkingMapperImpl implements ParkingMapper {

    @Override
    public Parking toParking(ParkingRequestDTO parkingRequestDTO) {
        if ( parkingRequestDTO == null ) {
            return null;
        }

        Parking parking = new Parking();

        parking.setId( parkingRequestDTO.getId() );
        parking.setVersion( parkingRequestDTO.getVersion() );
        parking.setCreatedDate( parkingRequestDTO.getCreatedDate() );
        parking.setCreatedBy( parkingRequestDTO.getCreatedBy() );
        parking.setLastModifiedDate( parkingRequestDTO.getLastModifiedDate() );
        parking.setLastModifiedBy( parkingRequestDTO.getLastModifiedBy() );
        parking.setBasePrice( parkingRequestDTO.getBasePrice() );

        return parking;
    }

    @Override
    public List<Parking> toParkingList(List<ParkingRequestDTO> parkingRequestDTOList) {
        if ( parkingRequestDTOList == null ) {
            return null;
        }

        List<Parking> list = new ArrayList<Parking>( parkingRequestDTOList.size() );
        for ( ParkingRequestDTO parkingRequestDTO : parkingRequestDTOList ) {
            list.add( toParking( parkingRequestDTO ) );
        }

        return list;
    }

    @Override
    public ParkingResponseDTO toParkingResponseDTO(Parking Parking) {
        if ( Parking == null ) {
            return null;
        }

        ParkingResponseDTO parkingResponseDTO = new ParkingResponseDTO();

        parkingResponseDTO.setId( Parking.getId() );
        parkingResponseDTO.setVersion( Parking.getVersion() );
        parkingResponseDTO.setCreatedDate( Parking.getCreatedDate() );
        parkingResponseDTO.setCreatedBy( Parking.getCreatedBy() );
        parkingResponseDTO.setLastModifiedDate( Parking.getLastModifiedDate() );
        parkingResponseDTO.setLastModifiedBy( Parking.getLastModifiedBy() );
        parkingResponseDTO.setBasePrice( Parking.getBasePrice() );

        return parkingResponseDTO;
    }

    @Override
    public List<ParkingResponseDTO> toParkingResponseDTOList(List<Parking> parkingList) {
        if ( parkingList == null ) {
            return null;
        }

        List<ParkingResponseDTO> list = new ArrayList<ParkingResponseDTO>( parkingList.size() );
        for ( Parking parking : parkingList ) {
            list.add( toParkingResponseDTO( parking ) );
        }

        return list;
    }
}
