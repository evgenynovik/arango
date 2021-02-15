package com.javaperformer.dao.domain;

import com.arangodb.springframework.annotation.Document;
import lombok.*;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document("networks")
public class NetworkElement {
    @Id
    private String id;

    private String name;
    private String surname;
    private boolean alive;
    private Integer age;
}
