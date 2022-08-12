package com.sina.parkingApplication.model;import com.sina.parkingApplication.common.BaseEntity;import lombok.Data;import lombok.EqualsAndHashCode;import lombok.ToString;import org.hibernate.envers.Audited;import javax.persistence.*;import java.util.List;@Entity@Data@Table(name = PriceRate.PRICE_RATE_TBL)@Auditedpublic class PriceRate extends BaseEntity {    public static final String PRICE_RATE_TBL = "price_rate_tbl";    private Long hourlyRate;    private Long dailyRate;    private Long monthlyRate;    @ToString.Exclude    @EqualsAndHashCode.Exclude    @OneToMany(mappedBy = "priceRate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)    private List<ParkingDetail> parkingDetail;}