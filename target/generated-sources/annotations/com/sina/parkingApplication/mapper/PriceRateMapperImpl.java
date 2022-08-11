package com.sina.parkingApplication.mapper;

import com.sina.parkingApplication.dto.request.PriceRateRequestDTO;
import com.sina.parkingApplication.dto.response.PriceRateResponseDTO;
import com.sina.parkingApplication.model.PriceRate;
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
public class PriceRateMapperImpl implements PriceRateMapper {

    @Override
    public PriceRate toPriceRate(PriceRateRequestDTO priceRateRequestDTO) {
        if ( priceRateRequestDTO == null ) {
            return null;
        }

        PriceRate priceRate = new PriceRate();

        priceRate.setId( priceRateRequestDTO.getId() );
        priceRate.setVersion( priceRateRequestDTO.getVersion() );
        priceRate.setCreatedDate( priceRateRequestDTO.getCreatedDate() );
        priceRate.setCreatedBy( priceRateRequestDTO.getCreatedBy() );
        priceRate.setLastModifiedDate( priceRateRequestDTO.getLastModifiedDate() );
        priceRate.setLastModifiedBy( priceRateRequestDTO.getLastModifiedBy() );
        priceRate.setHourlyRate( priceRateRequestDTO.getHourlyRate() );
        priceRate.setDailyRate( priceRateRequestDTO.getDailyRate() );
        priceRate.setMonthlyRate( priceRateRequestDTO.getMonthlyRate() );

        return priceRate;
    }

    @Override
    public List<PriceRate> toPriceRateList(List<PriceRateRequestDTO> priceRateRequestDTOList) {
        if ( priceRateRequestDTOList == null ) {
            return null;
        }

        List<PriceRate> list = new ArrayList<PriceRate>( priceRateRequestDTOList.size() );
        for ( PriceRateRequestDTO priceRateRequestDTO : priceRateRequestDTOList ) {
            list.add( toPriceRate( priceRateRequestDTO ) );
        }

        return list;
    }

    @Override
    public PriceRateResponseDTO toPriceRateResponseDTO(PriceRate priceRate) {
        if ( priceRate == null ) {
            return null;
        }

        PriceRateResponseDTO priceRateResponseDTO = new PriceRateResponseDTO();

        priceRateResponseDTO.setId( priceRate.getId() );
        priceRateResponseDTO.setVersion( priceRate.getVersion() );
        priceRateResponseDTO.setCreatedDate( priceRate.getCreatedDate() );
        priceRateResponseDTO.setCreatedBy( priceRate.getCreatedBy() );
        priceRateResponseDTO.setLastModifiedDate( priceRate.getLastModifiedDate() );
        priceRateResponseDTO.setLastModifiedBy( priceRate.getLastModifiedBy() );
        priceRateResponseDTO.setHourlyRate( priceRate.getHourlyRate() );
        priceRateResponseDTO.setDailyRate( priceRate.getDailyRate() );
        priceRateResponseDTO.setMonthlyRate( priceRate.getMonthlyRate() );

        return priceRateResponseDTO;
    }

    @Override
    public List<PriceRateResponseDTO> toPriceRateResponseDTOList(List<PriceRate> priceRateList) {
        if ( priceRateList == null ) {
            return null;
        }

        List<PriceRateResponseDTO> list = new ArrayList<PriceRateResponseDTO>( priceRateList.size() );
        for ( PriceRate priceRate : priceRateList ) {
            list.add( toPriceRateResponseDTO( priceRate ) );
        }

        return list;
    }
}
