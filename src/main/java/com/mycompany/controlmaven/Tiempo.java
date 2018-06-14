
package com.mycompany.controlmaven;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class Tiempo {
    
    private String titulo;
    private Element temperatura;
    private Element estado;
    
    public void temperatura(){
        try{
            //Conexión con la web
            Document doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();
            //Extraemos el el contenido de la etiqueta title
            titulo = doc.title();
            //Mostramos los contenidos de las etiquetas que nos interesan
            temperatura = doc.select("div.today_nowcard-temp").first();
            estado = doc.select("div.today_nowcard-phrase").first();
            //Visualizamos el resultado
            JOptionPane.showMessageDialog(null, "Hoy está "+estado.text()+", Temperatura "+temperatura.text()+"Cº Datos sacados de "+titulo);
        }catch(IOException ex){
            System.out.println(ex);
        }
        
    }
}
