package DTO.entities;

public class WareHouseBook {
	private Warehouse w;
	private Publisher p;
	private Book b;
	public WareHouseBook(Warehouse w, Publisher p, Book b)
	{
		super();
		this.w= w;
		this.p = p;
		this.b = b;
	}
	public WareHouseBook()
	{
		super();
	}
	public Warehouse getW() {
		return w;
	}
	public void setW(Warehouse w) {
		this.w = w;
	}
	public Publisher getP() {
		return p;
	}
	public void setP(Publisher p) {
		this.p = p;
	}
	public Book getB() {
		return b;
	}
	public void setB(Book b) {
		this.b = b;
	}
	
}
