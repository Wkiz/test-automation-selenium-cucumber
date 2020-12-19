package Utils;

public enum Constants {
	  CHROME("Chrome"),
	  FIREFOX("Firefox"),
	  SEARCH_RESULTS("search results");

	  private String valor;

	  private Constants(String valor) {
	    this.valor = valor;
	  }

	  public String getValor() {
	    return valor;
	  }
	}