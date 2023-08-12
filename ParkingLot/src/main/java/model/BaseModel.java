package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    private  int id;
    private LocalDateTime insertedAt;
    private  LocalDateTime updatedAt;

    public BaseModel(int id) {
        this.id = id;
        this.insertedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}
