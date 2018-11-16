package hello.model;

import java.util.ArrayList;

/**
 * Created by PalibinFamily on 12.06.2018.
 * ВНИМАНИЕ!
 * Setters возвращают измененный экземпляр ResumeContent, а не просто устанавливают значения полей. Сделано для удобной
 * установке значений поей, по типу:
 * ourContent.setFio
 *           .setBirthDate
 *           .setTelNumber
 *           ...
 *           .setCodeExample
  */
//todo: сделать поддержку ассоциативных массивов в сеттерах
public class SeekerDescription {
    private String fio;
    private String birthDate;
    private String imgSrc;
    private ArrayList<String> telNumber;
    private ArrayList<String> eMail;
    private ArrayList<String> target;
    private ArrayList<String> experience;
    private ArrayList<String> education;
    private ArrayList<String> additionalEducation;
    private ArrayList<String> skills;
    private ArrayList<String> codeExample;

    public String getFio() {
        return fio;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public ArrayList<String> getTelNumber() {
        return telNumber;
    }

    public ArrayList<String> geteMail() {
        return eMail;
    }

    public ArrayList<String> getTarget() {
        return target;
    }

    public ArrayList<String> getExperience() {
        return experience;
    }

    public ArrayList<String> getEducation() {
        return education;
    }

    public ArrayList<String> getAdditionalEducation() {
        return additionalEducation;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public ArrayList<String> getCodeExample() {
        return codeExample;
    }

    public SeekerDescription setFio(String fio) {

        this.fio = fio;
        return this;
    }

    public SeekerDescription setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public SeekerDescription setTelNumber(ArrayList<String> telNumber) {
        this.telNumber = telNumber;
        return this;
    }

    public SeekerDescription seteMail(ArrayList<String> eMail) {
        this.eMail = eMail;
        return this;
    }

    public SeekerDescription setTarget(ArrayList<String> target) {
        this.target = target;
        return this;
    }

    public SeekerDescription setExperience(ArrayList<String> experience) {
        this.experience = experience;
        return this;
    }

    public SeekerDescription setEducation(ArrayList<String> education) {
        this.education = education;
        return this;
    }

    public SeekerDescription setAdditionalEducation(ArrayList<String> additionalEducation) {
        this.additionalEducation = additionalEducation;
        return this;
    }

    public SeekerDescription setSkills(ArrayList<String> skills) {
        this.skills = skills;
        return this;
    }

    public SeekerDescription setCodeExample(ArrayList<String> codeExample) {
        this.codeExample = codeExample;
        return this;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public SeekerDescription setImgSrc(ArrayList<String> imgSrc) {
        this.imgSrc = imgSrc.get(0);
        return this;
    }

    //Устанавли
    public void useFieldSetter(String field)

}
