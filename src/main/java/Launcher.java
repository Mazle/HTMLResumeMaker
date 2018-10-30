package main.java;

import main.java.model.beans.SeekerDescription;

import org.apache.log4j.PropertyConfigurator;
import main.java.presenter.JavaTestPresenter;
import main.java.view.HTMLCreater;
import main.java.view.HTMLCreaterImpl;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;

/**
 * Created by PalibinFamily on 11.06.2018.
 * первым параметром указать путь до файла properties
 */
public class Launcher {
    public static void main(String[] args) {
        DOMConfigurator.configure("log4j.properties");
        System.out.println(new File(".").getAbsolutePath());
        JavaTestPresenter presenter = new JavaTestPresenter(args[0]);
        SeekerDescription seekerDescription = presenter.getResumeContent();

        // just test
        HTMLCreater view = new HTMLCreaterImpl();
        view.createHTMLFileFromTemplate(seekerDescription,"./outfile.html");
    }
}
