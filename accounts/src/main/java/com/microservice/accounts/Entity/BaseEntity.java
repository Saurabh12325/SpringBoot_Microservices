package com.microservice.accounts.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Data
@Setter
@ToString
public class BaseEntity {
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String createdBy;
    private String updatedAt;
    private String updatedBy;
}
