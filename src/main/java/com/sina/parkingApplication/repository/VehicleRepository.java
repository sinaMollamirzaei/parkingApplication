package com.sina.parkingApplication.repository;import com.sina.parkingApplication.model.Vehicle;import org.springframework.data.repository.PagingAndSortingRepository;public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {}