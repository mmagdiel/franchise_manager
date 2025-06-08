package co.com.neurotrak.api.resource;

import co.com.neurotrak.model.franchise.Franchise;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class FranchiseResource {
    public List<Franchise> data;
    public Integer status;
    public String  message;
}