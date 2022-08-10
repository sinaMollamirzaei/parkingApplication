package com.sina.parkingApplication.mapper;

import com.sina.parkingApplication.dto.request.ParkingDetailRequestDTO;
import com.sina.parkingApplication.dto.response.ParkingDetailResponseDTO;
import com.sina.parkingApplication.model.ParkingDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-10T17:14:13+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ParkingDetailMapperImpl implements ParkingDetailMapper {

    @Autowired
    private ParkingMapper parkingMapper;
    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private PriceRateMapper priceRateMapper;

    @Override
    public ParkingDetail toParkingDetail(ParkingDetailRequestDTO parkingDetailRequestDTO) {
        if ( parkingDetailRequestDTO == null ) {
            return null;
        }

        ParkingDetail parkingDetail = new ParkingDetail();

        parkingDetail.setParking( parkingMapper.toParking( parkingDetailRequestDTO.getParkingRequestDTO() ) );
        parkingDetail.setVehicle( vehicleMapper.toVehicle( parkingDetailRequestDTO.getVehicleRequestDTO() ) );
        parkingDetail.setPriceRate( priceRateMapper.toPriceRate( parkingDetailRequestDTO.getPriceRateRequestDTO() ) );
        parkingDetail.setId( parkingDetailRequestDTO.getId() );
        parkingDetail.setVersion( parkingDetailRequestDTO.getVersion() );
        parkingDetail.setCreatedDate( parkingDetailRequestDTO.getCreatedDate() );
        parkingDetail.setCreatedBy( parkingDetailRequestDTO.getCreatedBy() );
        parkingDetail.setLastModifiedDate( parkingDetailRequestDTO.getLastModifiedDate() );
        parkingDetail.setLastModifiedBy( parkingDetailRequestDTO.getLastModifiedBy() );
        parkingDetail.setTimeIn( parkingDetailRequestDTO.getTimeIn() );
        parkingDetail.setTimeOut( parkingDetailRequestDTO.getTimeOut() );

        return parkingDetail;
    }

    @Override
    public List<ParkingDetail> toParkingDetailList(List<ParkingDetailRequestDTO> parkingDetailRequestDTOList) {
        if ( parkingDetailRequestDTOList == null ) {
            return null;
        }

        List<ParkingDetail> list = new ArrayList<ParkingDetail>( parkingDetailRequestDTOList.size() );
        for ( ParkingDetailRequestDTO parkingDetailRequestDTO : parkingDetailRequestDTOList ) {
            list.add( toParkingDetail( parkingDetailRequestDTO ) );
        }

        return list;
    }

    @Override
    public ParkingDetailResponseDTO toParkingDetailResponseDTO(ParkingDetail parkingDetail) {
        if ( parkingDetail == null ) {
            return null;
        }

        ParkingDetailResponseDTO parkingDetailResponseDTO = new ParkingDetailResponseDTO();

        parkingDetailResponseDTO.setParkingResponseDTO( parkingMapper.toParkingResponseDTO( parkingDetail.getParking() ) );
        parkingDetailResponseDTO.setVehicleResponseDTO( vehicleMapper.toParkingResponseDTO( parkingDetail.getVehicle() ) );
        parkingDetailResponseDTO.setPriceRateResponseDTO( priceRateMapper.toPriceRateResponseDTO( parkingDetail.getPriceRate() ) );
        parkingDetailResponseDTO.setId( parkingDetail.getId() );
        parkingDetailResponseDTO.setVersion( parkingDetail.getVersion() );
        parkingDetailResponseDTO.setCreatedDate( parkingDetail.getCreatedDate() );
        parkingDetailResponseDTO.setCreatedBy( parkingDetail.getCreatedBy() );
        parkingDetailResponseDTO.setLastModifiedDate( parkingDetail.getLastModifiedDate() );
        parkingDetailResponseDTO.setLastModifiedBy( parkingDetail.getLastModifiedBy() );
        parkingDetailResponseDTO.setTimeIn( parkingDetail.getTimeIn() );
        parkingDetailResponseDTO.setTimeOut( parkingDetail.getTimeOut() );

        return parkingDetailResponseDTO;
    }

    @Override
    public List<ParkingDetailResponseDTO> toParkingDetailResponseDTOList(List<ParkingDetail> parkingDetailList) {
        if ( parkingDetailList == null ) {
            return null;
        }

        List<ParkingDetailResponseDTO> list = new ArrayList<ParkingDetailResponseDTO>( parkingDetailList.size() );
        for ( ParkingDetail parkingDetail : parkingDetailList ) {
            list.add( toParkingDetailResponseDTO( parkingDetail ) );
        }

        return list;
    }
}
