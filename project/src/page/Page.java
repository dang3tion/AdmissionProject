package page;

public class Page {
	private int page = 0;
	private int maxPageItem = 10;
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getMaxPageItem() {
		return maxPageItem;
	}
	
	public void setMaxPageItem(int maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	
	public int getOffset() {
		return page*maxPageItem;
	}
	
}
