package com.javaperformer.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Id
    private String id;
    private String mkey;
    private String name;
}
