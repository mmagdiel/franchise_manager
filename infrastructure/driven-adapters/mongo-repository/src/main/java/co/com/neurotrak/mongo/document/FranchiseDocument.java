package co.com.neurotrak.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranchiseDocument {
    private String uuid;
    private String name;
    private Date createAt;
    private Date updateAt;
    private Integer quantity = 0;
    private Set<SubsidiaryDocument> subsidiaries = new HashSet<>();
}
