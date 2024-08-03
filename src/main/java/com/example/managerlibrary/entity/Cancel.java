package com.example.managerlibrary.entity;

import jakarta.persistence.*;
import com.example.managerlibrary.enums.CancelEnum;

@Entity
@Table(name = "Cancel")
public class Cancel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private CancelEnum status;

    public Cancel() {
        this.status = CancelEnum.NOACTIVE; // Default status
    }

    @Override
    public String toString() {
        return "Cancel{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

    public Cancel(int id, CancelEnum status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CancelEnum getStatus() {
        return status;
    }

    public void setStatus(CancelEnum status) {
        this.status = status;
    }
}
