package com.javaperformer.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceDTO implements Serializable {
    private String id;
    private String mkey;
    private String name;
    private String parent_mkey;
    private String type;
    private boolean state;
}
