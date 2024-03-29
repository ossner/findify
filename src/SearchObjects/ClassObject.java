package SearchObjects;

import java.util.ArrayList;
import java.util.List;

public class ClassObject extends SearchObject {
    private Boolean isChild;
    private Boolean hasGeneric;
    private Boolean isImplemented;
    private List<FieldObject> attributes;
    private List<ClassObject> classes;
    private List<MethodObject> methods;
    private InheritanceType inheritanceType;
    private ClassType classType;

    //Constructor for normal Class without inheritance, generic, implementing
    // Class
    public ClassObject(String name, String path, AccessModifier accessModifier,
                       int line) {
        super(name, accessModifier, path, line);
        this.classes = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }

    public ClassObject(String name, AccessModifier accessModifier,
                       Boolean isChild, Boolean hasGeneric,
                       Boolean isImplemented, InheritanceType inheritanceType,
                       ClassType classType, List<FieldObject> attributes) {
        super(name, accessModifier);
        this.isChild = isChild;
        this.hasGeneric = hasGeneric;
        this.isImplemented = isImplemented;
        this.inheritanceType = inheritanceType;
        this.classType = classType;
        this.attributes = attributes;
    }

    //constructor for GUI
    public ClassObject(String name, AccessModifier accessModifier,
                       Boolean isChild, Boolean hasGeneric,
                       Boolean isImplemented, InheritanceType inheritanceType,
                       ClassType classType, List<FieldObject> attributes, String[] tags) {
        super(name, accessModifier, tags);
        this.isChild = isChild;
        this.hasGeneric = hasGeneric;
        this.isImplemented = isImplemented;
        this.inheritanceType = inheritanceType;
        this.classType = classType;
        this.attributes = attributes;
    }

    public ClassObject(String name, String path, AccessModifier accessModifier,
                       int line, Boolean isChild, Boolean hasGeneric) {
        super(name, accessModifier, path, line);
        this.isChild = isChild;
        this.hasGeneric = hasGeneric;
        this.classes = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }

    public Boolean isChild() {
        return isChild;
    }

    public Boolean hasGeneric() {
        return hasGeneric;
    }

    public Boolean isImplemented() {
        return isImplemented;
    }

    public List<FieldObject> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<FieldObject> attributes) {
        this.attributes = attributes;
    }

    public List<ClassObject> getClasses() {
        return classes;
    }

    /**
     * Setters for Lists of Class-, Method-, and AttributeObject
     * Useful for the ClassParser that will browse the content of
     * the class and find internal classes, methods, and attributes.
     * It will then use the setters.
     */
    public void setClasses(List<ClassObject> classes) {
        this.classes = classes;
    }

    public List<MethodObject> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodObject> methods) {
        this.methods = methods;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public InheritanceType getInheritanceType() {
        return inheritanceType;
    }

    public void setInheritanceType(InheritanceType inheritanceType) {
        this.inheritanceType = inheritanceType;
    }

    public Boolean isHasGeneric() {
        return hasGeneric;
    }

    public void setChild(Boolean child) {
        isChild = child;
    }

    public void setHasGeneric(Boolean hasGeneric) {
        this.hasGeneric = hasGeneric;
    }

    public void setImplemented(Boolean implemented) {
        isImplemented = implemented;
    }

    @Override
    public String toString() {
        return "CLASS: " + getName() + "\nvisibility: " +
                getAccessModifier() + "\nisChild: " + isChild +
                "\nisImplemented: " + isImplemented + "\nHas Generics: " +
                hasGeneric + "\n" + classType + "\n" + inheritanceType + "\n" +
                getAttributes().toString() + "\n" + getMethods().toString();
        //"\n" + getClasses().toString();
    }

    @Override
    public double getSimilarity(SearchObject searchObject) {
        ClassObject classObject = ((ClassObject) searchObject);
        double similarity = 1;
        if (getName() != null)
            similarity *= semanticWeb.getSimilarity(getName(), classObject.getName());

        if (getAccessModifier() != null)
            if (classObject.getAccessModifier() != null &&
                    getAccessModifier() == classObject.getAccessModifier())
                similarity *= 0.9;
            else similarity *= 0.1;

        if (isChild != null)
            if (classObject.isChild != null &&
                    isChild == classObject.isChild)
                similarity *= 0.9;
            else similarity *= 0.1;

        if (hasGeneric != null)
            if (classObject.hasGeneric != null &&
                    hasGeneric == classObject.hasGeneric)
                similarity *= 0.9;
            else similarity *= 0.1;

        if (getInheritanceType() != null)
            if (classObject.getInheritanceType() != null &&
                    getInheritanceType() == classObject.getInheritanceType())
                similarity *= 0.9;
            else similarity *= 0.1;

        if (getClassType() != null)
            if (classObject.getClassType() != null &&
                    getClassType() == classObject.getClassType())
                similarity *= 0.9;
            else similarity *= 0.1;

        if (getTags() != null)
            if (classObject.getTags() != null)
                similarity *= getStringSimilarity(getTags(), classObject.getTags());
            else similarity *= 0.1;
        return similarity;
    }

    public enum InheritanceType {
        ABSTRACT, FINAL, DEFAULT
    }

    public enum ClassType {
        ENUM, INTERFACE, DEFAULT
    }
}