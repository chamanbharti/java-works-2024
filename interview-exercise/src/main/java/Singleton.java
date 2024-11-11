
public class Singleton {
	
	private static Singleton instance = null;//new Singleton();
	private Singleton() {
		
	}
	public static Singleton getInstance() {
		//return instance;
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1.hashCode()+":"+s2.hashCode());
	}

}
