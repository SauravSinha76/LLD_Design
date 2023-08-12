package repositories;

import lombok.AllArgsConstructor;
import model.Slab;
import model.VehicalType;

import java.util.*;

@AllArgsConstructor
public class SlabRepository {

    private Map<Integer, Slab> map;

    public SlabRepository() {
        map = new HashMap<>();
    }

    public List<Slab> getSlabByVehicleType(VehicalType vehicalType){
        List<Slab> slabs = new ArrayList<>();

        for (Map.Entry<Integer, Slab> integerSlabEntry : map.entrySet()) {
            if(integerSlabEntry.getValue().getVehicalType().equals(vehicalType)){
                slabs.add(integerSlabEntry.getValue());
            }
        }

        slabs.sort(new Comparator<Slab>() {
            @Override
            public int compare(Slab o1, Slab o2) {
                return o1.getStartHour() - o2.getStartHour();
            }
        });
        return slabs;
    }
}
