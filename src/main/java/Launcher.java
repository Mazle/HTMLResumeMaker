package main.java;

import main.java.model.beans.SeekerDescription;
import main.java.presenter.JavaTestPresenter;
import main.java.view.HTMLCreater;
import main.java.view.HTMLCreaterImpl;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by PalibinFamily on 11.06.2018.
 * первым параметром указать путь до файла properties
 */
public class Launcher {
    public static void main(String[] args) {
        try {
            String filepath= "log4j.properties";
            FileInputStream testStream = new FileInputStream(filepath);
            PropertyConfigurator.configure(filepath);
        } catch (FileNotFoundException e) {
            System.out.println("there is no external config for log4j. Binding default internal config.");
            System.out.println(System.getProperty("java.class.path"));
            PropertyConfigurator.configure(Launcher.class.getResourceAsStream("/resources/log4j.properties"));
        }
        JavaTestPresenter presenter = new JavaTestPresenter(args[0]);
        SeekerDescription seekerDescription = presenter.getResumeContent();

        // just test
        HTMLCreater view = new HTMLCreaterImpl();
        view.createHTMLFileFromTemplate(seekerDescription,"./outfile.html");
    }
}
