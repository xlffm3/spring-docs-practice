package practice.docs.spring.binding.editor;

import practice.docs.spring.binding.Target;

import java.beans.PropertyEditorSupport;

public class TargetEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Target target = (Target) getValue();
        return String.valueOf(target.getMoney());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Target target = new Target(Integer.parseInt(text));
        setValue(target);
    }
}
