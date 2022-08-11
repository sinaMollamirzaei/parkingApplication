package com.sina.parkingApplication.service.impl;import com.sina.parkingApplication.common.SearchCriteria;import com.sina.parkingApplication.common.exception.NotFoundException;import com.sina.parkingApplication.model.Parking;import com.sina.parkingApplication.model.ParkingDetail;import com.sina.parkingApplication.model.PriceRate;import com.sina.parkingApplication.model.Vehicle;import com.sina.parkingApplication.repository.ParkingDetailRepository;import com.sina.parkingApplication.service.IParkingDetailService;import com.sina.parkingApplication.service.IParkingService;import com.sina.parkingApplication.service.IPriceRateService;import com.sina.parkingApplication.service.IVehicleService;import com.sina.parkingApplication.specification.ParkingDetailSpecification;import lombok.AllArgsConstructor;import lombok.extern.slf4j.Slf4j;import org.springframework.data.domain.Page;import org.springframework.data.domain.PageRequest;import org.springframework.data.domain.Sort;import org.springframework.stereotype.Service;import java.text.SimpleDateFormat;import java.util.List;import java.util.Optional;@AllArgsConstructor@Service@Slf4jpublic class ParkingDetailService implements IParkingDetailService {    private final ParkingDetailRepository parkingDetailRepository;    private final IVehicleService vehicleService;    private final IParkingService parkingService;    private final IPriceRateService priceRateService;    @Override    public ParkingDetail registerRequest(ParkingDetail parkingDetail) {        Vehicle vehicle = vehicleService.getVehicle(parkingDetail.getVehicle().getId());        Parking parking = parkingService.getParking(parkingDetail.getParking().getId());        PriceRate priceRate = priceRateService.getPriceRate(parkingDetail.getPriceRate().getId());        parkingDetail.setVehicle(vehicle);        parkingDetail.setParking(parking);        parkingDetail.setPriceRate(priceRate);        return parkingDetailRepository.save(parkingDetail);    }    @Override    public void deleteParkingDetail(Long parkingDetailId) {        ParkingDetail parkingDetail = getParkingDetail(parkingDetailId);        parkingDetailRepository.delete(parkingDetail);    }    @Override    public ParkingDetail exitRequest(ParkingDetail parkingDetail) {        ParkingDetail savedBefore = getParkingDetail(parkingDetail.getId());        savedBefore.setTimeIn(parkingDetail.getTimeIn());        savedBefore.setTimeOut(parkingDetail.getTimeOut());        return parkingDetailRepository.save(savedBefore);    }    @Override    public ParkingDetail getParkingDetail(Long parkingDetailId) {        Optional<ParkingDetail> optionalParkingDetail = parkingDetailRepository.findById(parkingDetailId);        if (optionalParkingDetail.isPresent()) {            return optionalParkingDetail.get();        }        throw new NotFoundException("parkDetail not found");    }    @Override    public Page<ParkingDetail> paging(Integer page, Integer size) {        return parkingDetailRepository.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));    }    @Override    public Page<ParkingDetail> reportVehicleTraffic(String plateNumber, Integer page, Integer size) {        return parkingDetailRepository.findAllByVehicle_PlateNumber(plateNumber, PageRequest.of(page, size, Sort.by("id").ascending()));    }    @Override    public ParkingDetail calculateFinalPrice(ParkingDetail parkingDetail) {        ParkingDetail savedBefore = getParkingDetail(parkingDetail.getId());        Parking parking = parkingService.getParking(savedBefore.getParking().getId());        PriceRate priceRate = priceRateService.getPriceRate(savedBefore.getPriceRate().getId());        SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");        long time_difference = savedBefore.getTimeOut().getTime() - savedBefore.getTimeIn().getTime();        long hours_difference = (time_difference / (1000 * 60 * 60)) % 24;        long days_difference = (time_difference / (1000 * 60 * 60 * 24)) % 365;        long days_differenceNew = 0;        if (days_difference > 30) {            days_differenceNew = days_difference % 30;        }        long months_difference = days_difference / 30;        log.info("hourly " + hours_difference + "--- days " + days_differenceNew + "--- month " + months_difference);        savedBefore.setFinalPrice(parking.getBasePrice() + (hours_difference * priceRate.getHourlyRate()) + (days_differenceNew * priceRate.getDailyRate()) + (months_difference * priceRate.getMonthlyRate()));        log.info("basePrice " + parking.getBasePrice() + "--- hourlyRate " + hours_difference * priceRate.getHourlyRate() + "--- dailyRate " + days_differenceNew * priceRate.getDailyRate() + "---monthlyRate " + months_difference * priceRate.getMonthlyRate());        return parkingDetailRepository.save(savedBefore);    }    @Override    public List<ParkingDetail> search(List<SearchCriteria> searchCriteria) {        ParkingDetailSpecification parkingDetailSpecification = new ParkingDetailSpecification();        searchCriteria.forEach(criteria -> parkingDetailSpecification.add(criteria));        return parkingDetailRepository.findAll(parkingDetailSpecification);    }}