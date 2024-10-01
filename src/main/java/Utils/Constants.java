package Utils;

public enum Constants {
	  CHROME("Chrome"),
	  FIREFOX("Firefox"),
	  SEARCH_RESULTS("search results");

	  private String value;

	  private Constants(String value) {
	    this.value = value;
	  }

	  public String getValue() {
	    return value;
	  }
	}