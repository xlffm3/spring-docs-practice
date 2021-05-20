package practice.docs.spring.binding;

import java.beans.PropertyEditorSupport;

public class TargetEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        System.out.println("log jipark");
        Target target = (Target) getValue();
        return String.valueOf(target.getMoney());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Target target = new Target(Integer.parseInt(text));
        System.out.println("log jipark" + text);
        setValue(target);
    }
}
