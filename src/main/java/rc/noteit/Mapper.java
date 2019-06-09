package rc.noteit;

import org.springframework.stereotype.Component;
import rc.noteit.api.viewmodel.NoteViewModel;
import rc.noteit.api.viewmodel.NotebookViewModel;
import rc.noteit.db.NotebookRepository;
import rc.noteit.model.Note;
import rc.noteit.model.Notebook;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Component that handles all mappings in this project
 * - entity to view model
 * - view model to entity
 * <p>
 * All mappings are handled here, but in production code this is not the
 * best approach. You can take a look at ModelMapper project or at least split mapping classes
 * across many files.
 */

@Component
public class Mapper {
    private NotebookRepository notebookRepository;

    public Mapper(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    public NoteViewModel convertToNoteViewModel(Note entity) {
        NoteViewModel viewModel = new NoteViewModel();
        viewModel.setTitle(entity.getTitle());
        viewModel.setId(entity.getId().toString());
        viewModel.setLastModifiedOn(entity.getLastModifiedOn());
        viewModel.setText(entity.getText());
        viewModel.setNotebookId(entity.getNotebook().getId().toString());

        return viewModel;
    }

    public Note convertToNoteEntity(NoteViewModel viewModel) {
        if(viewModel.getId() == null) {
            viewModel.setId(UUID.randomUUID().toString());
        }

        Notebook notebook = this.notebookRepository.findById(UUID.fromString(viewModel.getNotebookId())).get();

        final Note note = new Note(viewModel.getId(), viewModel.getTitle(), viewModel.getText(), notebook);
        return note;
    }

    public NotebookViewModel convertToNotebookViewModel(Notebook entity) {
        NotebookViewModel viewModel = new NotebookViewModel();
        viewModel.setId(entity.getId().toString());
        viewModel.setName(entity.getName());
        viewModel.setNbNotes(entity.getNotes().size());

        return viewModel;
    }

    public Notebook convertToNotebookEntity(NotebookViewModel viewModel) {
        if(viewModel.getId() == null) {
            viewModel.setId(UUID.randomUUID().toString());
        }
        return new Notebook(UUID.fromString(viewModel.getId()), viewModel.getName(), new ArrayList<>());
    }
}
