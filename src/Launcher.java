import Model.Beans.SeekerDescription;
import Presenter.JavaTestPresenter;
import View.HTMLCreater;
import View.HTMLCreaterImpl;

/**
 * Created by PalibinFamily on 11.06.2018.
 * первым параметром указать путь до файла properties
 */
public class Launcher {
    public static void main(String[] args) {
        JavaTestPresenter presenter = new JavaTestPresenter(args[0]);
        SeekerDescription seekerDescription = presenter.getResumeContent();

        // just test
        HTMLCreater view = new HTMLCreaterImpl();
        view.createHTMLFileFromTemplate(seekerDescription,"./outfile.html");
    }
}
