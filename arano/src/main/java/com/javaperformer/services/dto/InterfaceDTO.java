package com.javaperformer.services.dto;

import com.javaperformer.dao.domain.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceDTO implements Serializable {

    private String id;
    private String mkey;
    @NotNull(message = "Please provide a correct name")
    @Size(min = 3, max = 40, message = "Please provide a correct name")
    private String name;
    private String parent_mkey;
    @NotNull(message = "Please provide a correct type")
    @Pattern(regexp = "(?:LOGICAL|PHYSICAL)", message = "Please provide a correct type")
    private String type;
    private boolean state;
}
