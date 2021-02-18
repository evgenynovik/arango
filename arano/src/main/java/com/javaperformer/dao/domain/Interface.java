package com.javaperformer.dao.domain;

import com.arangodb.springframework.annotation.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Document("interfaces")
public class Interface extends BaseEntity {

    private String parent_mkey;
    private String type;
    private boolean state;
    @Relations(edges = InterfaceToNE.class, lazy = true)
    private NetworkElement networkElement;

    @Relations(edges = InterfaceToNE.class, lazy = true)
    private List<Interface> interFaces;

    @Builder
    public Interface(String id, String mkey, String name, String parent_mkey, String type, boolean state,
                     NetworkElement networkElement, List<Interface> interFaces) {
        super(id, mkey, name);
        this.parent_mkey = parent_mkey;
        this.type = type;
        this.state = state;
        this.networkElement = networkElement;
        this.interFaces = interFaces;
    }
}
