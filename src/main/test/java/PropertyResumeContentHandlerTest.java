import main.java.model.beans.SeekerDescription;
import main.java.model.propertiesFileSource.PropertyResumeContentHandler;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
//здесь трудно придумать какой то адекватный тест. Нечего, как бы, тестировать.. Поэтому воткнул такой.
public class PropertyResumeContentHandlerTest {
    @Test
    public void getTestDescription(){
        PropertyResumeContentHandler forTest = new PropertyResumeContentHandler();
        SeekerDescription description = forTest.getSeekerDescription("src/main/test/java/testDescription");
        SeekerDescription model = new SeekerDescription();
        ArrayList<String> testContent = new ArrayList<>();
        testContent.add("test");
        model.setAdditionalEducation(testContent);
        model.setBirthDate(testContent);
        model.setCodeExample(testContent);
        model.setEducation(testContent);
        model.setFio(testContent);
        model.seteMail(testContent);
        model.setSkills(testContent);
        model.setTarget(testContent);
        model.setTelNumber(testContent);
       assertEquals(model.getAdditionalEducation(),description.getAdditionalEducation());
        assertEquals(model.getFio(),description.getFio());
        assertEquals(model.getBirthDate(),description.getBirthDate());
        assertEquals(model.getCodeExample(),description.getCodeExample());
        assertEquals(model.geteMail(),description.geteMail());
        assertEquals(model.getEducation(),description.getEducation());
        assertEquals(model.getTarget(),description.getTarget());
        assertEquals(model.getSkills(),description.getSkills());
        assertEquals(model.getTelNumber(),description.getTelNumber());
    }
}
