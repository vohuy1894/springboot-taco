package com.example.taco;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date placedAt;
    @NotBlank(message = "Delivery name required")
    private String deliveryName;

    @NotBlank(message = "Delivery street required")
    private String deliveryStreet;

    @NotBlank(message = "Delivery city required")
    private String deliveryCity;

    @NotBlank(message = "Delivery state required")
    private String deliveryState;

    @NotBlank(message = "Delivery zip code required")
    @Digits(integer = 5, fraction = 0, message = "Invalid zip code")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @NotBlank(message = "Cc number required")
    @Digits(integer = 3, fraction = 0, message = "Invalid zip code")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }

}
