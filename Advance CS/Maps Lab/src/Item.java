
public class Item implements Comparable<Item> {
	private String itemName;
	private String companyName;

	public Item(String itemName, String companyName) {
		this.itemName = itemName;
		this.companyName = companyName;
	}

	public String getItemName() {
		return itemName;
	}

	public String getCompanyName() {
		return companyName;
	}
	public String toString() {
		return "Item: "+itemName+" - Company: "+companyName+" - Price: ";
	}
	@Override
	public boolean equals(Object o) {
		Item t = (Item) o;
		if (hashCode() == t.hashCode()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		for (int i = 0; i < itemName.length()-1; i++) {
			hashCode += ((int) itemName.toCharArray()[i]) * 31;
		}
		return hashCode;
	}

	@Override
	public int compareTo(Item t) {
		if (itemName.equals(t.getItemName()) && companyName.equals(t.getCompanyName())) {
			return 0;
		} else if (itemName.compareTo(t.getItemName()) == 0) {
			return companyName.compareTo(t.getCompanyName());
		} else {
			return itemName.compareTo(t.getItemName());
		}
	}

}
