package services;

import lombok.AllArgsConstructor;
import model.Gate;
import repositories.GateRepository;
@AllArgsConstructor
public class GateService {

    private GateRepository gateRepository;


    public Gate getGate(int id){
        return gateRepository.getGateById(id);
    }
}
