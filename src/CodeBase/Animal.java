package CodeBase;

public interface Animal<T, S>{
	String name = "";
	int    age  = 0;

	private String getName() {
	    return name;
    }
}
