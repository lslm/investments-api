package com.lslm.investmentsapi.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bdr_investments")
public class BDRInvestment extends Asset {
    private String ticker;
    private int quote;
    private BigDecimal pricePerQuote;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getQuote() {
        return quote;
    }

    public void setQuote(int quote) {
        this.quote = quote;
    }

    public BigDecimal getPricePerQuote() {
        return pricePerQuote;
    }

    public void setPricePerQuote(BigDecimal pricePerQuote) {
        this.pricePerQuote = pricePerQuote;
    }
}