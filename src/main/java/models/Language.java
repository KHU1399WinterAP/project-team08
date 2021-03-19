
  
package models;

   

import java.util.Properties;

public class Language {
	public final String PATH;
	
	private Properties properties = null;
	
	public Properties getProperties() {
		return properties;
	}
	
	public void setProperties(Properties properties) {
		if (this.properties != null)
			return;
		
		this.properties = properties;
	}
	
	public Language(String PATH) {
		this.PATH = PATH;
	}
}

