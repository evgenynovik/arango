package com.javaperformer.dao.domain;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
    @From
    private NetworkElement child;
    @To
    private NetworkElement parent;
}
