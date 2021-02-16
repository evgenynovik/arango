package com.javaperformer.dao.domain;

import com.arangodb.springframework.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("interfaces")
public class Interface {

    @Id
    private String id;
    private String mkey;
    private String name;
    private String parent_mkey;
    private String type;
    private boolean state;
    @Relations(edges = InterfaceToNE.class, lazy = true)
    private NetworkElement networkElement;

    @Relations(edges = InterfaceToNE.class, lazy = true)
    private List<Interface> interFaces;
}
