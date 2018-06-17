package View;

import Model.Beans.SeekerDescription;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Данный клас производит обработку html шаблона с помощью библиотеки org.freemarker:freemarker:2.3.23
 * Файл шаблона src/view/index.html должен содержать теги ${имя_свойства_переменной_content}
 * например ${telNumber} для content.telNumber. Переменная content должна быть javabean.
 * При отсутствии тега в переменной content срабатывает TemplateExceptionHandler.RETHROW_HANDLER
 * свойства типа List указываются в шаблоне следующим образом:
 * <ul>
 * <#list telNumber as telNumberItem>
 *   <li>${telNumberItem}
 * </#list>
 * </ul>
 * Данный пример отобразится как лист с точками
 */
public class HTMLCreaterImpl implements HTMLCreater {
    private Configuration cfg;
    private Template template = null;
    private Writer file = null;
    @Override
    public void createHTMLFileFromTemplate(SeekerDescription content, String outputFileName) {

        configurationInit();
        loadTemplate();
        createFile(outputFileName);
        loadContent(content, file, outputFileName);

    }

    private void closeFile(Writer file, String outputFileName) {
        try {
            file.flush();
            file.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Невозможно произвести запись в файл "+outputFileName);
            return;
        }
    }

    private void loadContent(SeekerDescription content, Writer file, String outputFileName) {
        try {
            template.process(content, file);
        } catch (TemplateException e) {
            //e.printStackTrace();
            return;
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Невозможно произвести запись в файл "+outputFileName);
            return;
        }
        closeFile(file, outputFileName);
    }

    private void createFile(String outputFileName) { try {
        file = new OutputStreamWriter(new FileOutputStream(new File(outputFileName)), StandardCharsets.UTF_8);
    } catch (IOException e) {
        //e.printStackTrace();
        System.out.println("Невозможно создать файл "+outputFileName);
        return;
    }
    }

    private void configurationInit (){
        cfg = new Configuration(Configuration.VERSION_2_3_23);
        ClassLoader classLoader = getClass().getClassLoader();
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    }

    private void loadTemplate () {
        try {
            template = cfg.getTemplate("Resourses/index.html");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Шаблон index.html не найден");
            return;
        }
    }
}
