package criacionais.singleton;

public class ConfiguracaoApp {
     private static volatile ConfiguracaoApp instance;
     private String idioma;
     private String tema;
     private String versao;

     private ConfiguracaoApp(){}

     public String getIdioma(){
	return this.idioma;
     }
     public String getTema(){
	return this.tema;
     }
     public String getVersao(){
	return this.versao;
     }
     public void setIdioma(String idioma){
	this.idioma = idioma;
     }
     public void setTema(String tema){
	this.tema = tema;
     }
     public void setVersao(String versao){
	this.versao = versao;
     }
     public static ConfiguracaoApp getInstance() {
       if (instance == null) {
         synchronized (ConfiguracaoApp.class) {
            if (instance == null) {
                instance = new ConfiguracaoApp();
            }
         }
       }
         return instance;
     }

}


     	
	
