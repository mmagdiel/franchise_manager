package co.com.neurotrak.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDocument {
    private String uuid;
    private String name;
    private Integer stock = 0;
    private Double price = 0.0;
    private String description;
}
