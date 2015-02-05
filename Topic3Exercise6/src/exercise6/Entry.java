package exercise6;

public class Entry {
	
	private String title;
	private String text;
	private String tag;
	
	public Entry(String title, String body, String tag) {
		super();
		this.title = title;
		this.text = body;
		this.tag = tag;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Entry [title=" + title + ", text=" + text + ", tag=" + tag + "]";
	}
	
}
