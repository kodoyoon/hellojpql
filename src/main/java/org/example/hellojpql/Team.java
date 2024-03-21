package org.example.hellojpql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id@GeneratedValue
    private Long id;
    private String name;
    @BatchSize(size = 100)
    @OneToMany(mappedBy = "team")
    private List<Member> memebrs = new ArrayList<>();

    public List<Member> getMemebrs() {
        return memebrs;
    }

    public void setMembers(List<Member> memebrs) {
        this.memebrs = memebrs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
