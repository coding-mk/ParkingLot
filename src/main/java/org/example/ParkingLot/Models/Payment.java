package org.example.ParkingLot.Models;

import java.util.Date;

public class Payment extends BaseModel{
    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private Date time;
    private String referenceNumber;
}
