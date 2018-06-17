package Presenter;

import Model.Beans.SeekerDescription;
import Model.DAOFactory;
import Model.SeekerDescriptionHandler;

/**
 * Created by PalibinFamily on 11.06.2018.
 */
public class JavaTestPresenter {
    private String inputFilePath;
    private SeekerDescriptionHandler handler;

    public JavaTestPresenter(String inputFilePath) {
        this.inputFilePath = inputFilePath;
        handler = DAOFactory.getDAOFactory(DAOFactory.FROM_PROPERTIES_FILE).getSeekerDescriptionHandler();
    }

    public SeekerDescription getResumeContent() {
        return handler.getSeekerDescription(this.inputFilePath);
    }
}
