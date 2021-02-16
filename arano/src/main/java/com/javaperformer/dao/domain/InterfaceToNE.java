package com.javaperformer.dao.domain;

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
@AllArgsConstructor
@NoArgsConstructor
@Edge("interfacesToNE")
public class InterfaceToNE {

    @Id
    private String id;
    @From
    private Interface interFace;
    @To
    private NetworkElement networkElement;
}
