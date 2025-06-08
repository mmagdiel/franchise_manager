package co.com.neurotrak.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubsidiaryDocument {
    private String uuid;
    private String name;
    private String description;
    private Integer quantity = 0;
    private Set<ProductDocument> products = new HashSet<>();
}
