package com.microservice.accounts.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

@Entity
@Data
@Getter
@Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer extends BaseEntity {
    @Id
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;
}
