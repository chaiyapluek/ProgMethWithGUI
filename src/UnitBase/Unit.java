package UnitBase;

public abstract class Unit {

	private String name;
	private String _class;
	private String url;
	private String iconUrl;
	private int id;

	public Unit(String name, String _class) {
		this.name = name;
		this._class = _class;
		this.id = 0;
	}
	
	public abstract String toString();
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getIconUrl() {
		return iconUrl;
	}
	
	public void setIconUrl(String url) {
		iconUrl = url;
	}
	
	public String get_Class() {
		return this._class;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
