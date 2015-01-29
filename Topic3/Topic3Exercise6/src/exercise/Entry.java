package exercise;

public class Entry {
	private String title;
	private String body;
	private String tag;

	public Entry() {
	}

	public Entry(String title, String body, String tag) {
		this.title = title;
		this.body = body;
		this.tag = tag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
