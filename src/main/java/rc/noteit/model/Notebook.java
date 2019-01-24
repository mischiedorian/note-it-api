package rc.noteit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Notebook")
public class Notebook {
    @Id
    private UUID id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notebook", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Note> notes;


    public Notebook() {
        this.id = UUID.randomUUID();
        this.notes = new ArrayList<>();
    }

    public int getNbOfNotes() {
        return this.notes.size();
    }

}
