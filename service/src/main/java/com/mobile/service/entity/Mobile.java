package com.mobile.service.entity;

import lombok.*;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mobile {

    private UUID id;

    private String name;
}
