package co.com.neurotrak.api.resource;

import co.com.neurotrak.model.franchise.Franchise;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FranchiseElement {
    public Franchise data;
    public Integer status;
    public String  message;
}