package com.naveenmittal.bookmyshow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private Long amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    private Long referenceNumber;

    public Payment(Long id, Long amount, PaymentProvider paymentProvider, PaymentMode paymentMode,
            Long referenceNumber) {
        super(id);
        this.amount = amount;
        this.paymentProvider = paymentProvider;
        this.paymentMode = paymentMode;
        this.referenceNumber = referenceNumber;
    }

    public Payment() {

    }
}
