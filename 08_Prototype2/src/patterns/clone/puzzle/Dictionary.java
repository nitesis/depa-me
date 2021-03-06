package patterns.clone.puzzle;

public class Dictionary implements Cloneable {
	public String language;
	public final int size;
	public String[] words;

	public Dictionary(String language, int size) {
		this.language = language;
		this.size = size;
		this.words = new String[size];
		for (int i = 0; i < size; i++)
			this.words[i] = "sample word " + i;
	}
	
	//Copy-Konstruktor: Time used: 0.061
	public Dictionary(Dictionary dict) {
		language = dict.language;
		size = dict.size;
		words = new String[dict.size];
		for (int i = 0; i < size; i++)
			this.words[i] = dict.words[i];
	}

//	@Override
	//Java Cloning: Time used: 0.025
//	public Object clone() {
//		try {
//			Dictionary d = (Dictionary) super.clone();
//			if (words != null) {
//				d.words = words.clone();
//			}
//			return d;
//		} catch (CloneNotSupportedException e) {
//			throw new InternalError();
//		}
//	}
	
	@Override
	public Object clone() { // Variante mit Copy-Konstruktoren
		return new Dictionary(this);
	}
}
