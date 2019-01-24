package rc.noteit.api.viewmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotebookViewModel {
    private String id;

    @NotNull
    private String name;

    private int nbNotes;
}
