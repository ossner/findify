package SearchObjects;

import java.util.ArrayList;
import java.util.List;

public class MethodObject extends SearchObject {
    private boolean isStatic;
    private List<FieldObject> parameters;
    private String returnType;

    public MethodObject(String name, byte visibility, String path, int line, List<String> content, boolean isStatic, String returnType) {
        super(name, visibility, path, content, line);
        this.isStatic = isStatic;
        this.returnType = returnType;
        this.parameters = new ArrayList<FieldObject>();
    }

    public void setParameters(List<FieldObject> parameters) {
        this.parameters = parameters;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public String getReturnType() {
        return returnType;
    }

    public List<FieldObject> getParameters() {
        return parameters;
    }

    // TODO: 23-Nov-19 implement Attributes and Getters

    public String toString() {
        return "METHOD:\nName: " + getName() + "\nreturn type: " + getReturnType() + "\nvisibility: "
                + getVisibility() + "\nisStatic: " + isStatic() + "\n" + parameters.toString();
    }
}
