package com.microservice.accounts.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Data
@Setter
@ToString
public class BaseEntity {
    private String createdAt;
    private String createdBy;
    private String updatedAt;
    private String updatedBy;
}
