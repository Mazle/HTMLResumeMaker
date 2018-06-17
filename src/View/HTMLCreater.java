package View;

import Model.Beans.SeekerDescription;

/**
 * Created by PalibinFamily on 13.06.2018.
 */
public interface HTMLCreater {
    public void createHTMLFileFromTemplate(SeekerDescription content, String outputFileName);
}
