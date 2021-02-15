package com.javaperformer.dao.domain;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("network_elements")
public class NetworkElement {
    @Id
    private String id;
    private String mkey;
    private String name;
    private LocalDate date;
    @Relations(edges = Interface.class, lazy = true)
    private List<NetworkElement> childs;
}
