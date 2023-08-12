package services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Slab;
import model.VehicalType;
import repositories.SlabRepository;

import java.util.List;

@AllArgsConstructor
@Getter
public class SlabService {
    private SlabRepository repository;

    public List<Slab> getSlabsByVehicleType(VehicalType vehicalType){
        return repository.getSlabByVehicleType(vehicalType);
    }


}
