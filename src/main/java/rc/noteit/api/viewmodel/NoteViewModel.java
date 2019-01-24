package rc.noteit.api.viewmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteViewModel {
    private String id;

    @NotNull
    @Min(3)
    private String title;

    @NotNull
    private String text;

    @NotNull
    private String notebookId;

    private Date lastModifiedOn;
}
