package Model.PropertiesFileSource;

import Model.Beans.SeekerDescription;
import Model.DAOFactory;
import Model.SeekerDescriptionHandler;

/**
 * Created by PalibinFamily on 12.06.2018.
 * данный класс, как упоминал ранее в описании класса предка, просто является маршрутизатором, создающим экземпляры
 * классов обработчиков сущностей. В нашем случае - обработчика контента резюме.
 */
public class PropertiesFileDAOFactory extends DAOFactory {
    @Override
    public SeekerDescriptionHandler getSeekerDescriptionHandler() {
        return new PropertyResumeContentHandler();
    }
}
