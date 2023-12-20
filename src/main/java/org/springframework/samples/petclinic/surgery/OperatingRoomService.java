package org.springframework.samples.petclinic.surgery;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperatingRoomService {
    private OperatingRoomRepository repo;

    public OperatingRoomService(OperatingRoomRepository tr){
        this.repo=tr;
    }

    @Transactional(readOnly = true)
    public List<OperatingRoom> getAll() {
        return this.repo.findAll();
    }

    @Transactional
    public OperatingRoom save(OperatingRoom t) {
        return this.repo.save(t);
    }
}
