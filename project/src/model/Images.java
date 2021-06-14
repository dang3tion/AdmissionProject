package model;

public class Images {
	private String title;
	private String url;
	private String state;

	public Images(String title, String url, String state) {
		super();
		this.title = title;
		this.url = url;
		this.state = state;
	}

	public Images() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Images [title=" + title + ", url=" + url + ", state=" + state + "]";
	}

}
