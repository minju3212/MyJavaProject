package workshop.book.entity;

public class Magazine extends Publication{
	private String PublishingPeriod;
	
	public Magazine() {
		
	}

	public Magazine(String title, String publishingDate, int page, int price, String PublishingPeriod) {
		super(title, publishingDate, page, price);
		this.PublishingPeriod = PublishingPeriod;
	}
	
	public String getPublishingPeriod() {
		return PublishingPeriod;
	}
	
	public void setPublishingPeriod(String publishingPeriod) {
		this.PublishingPeriod = publishingPeriod;
	}
	
}
