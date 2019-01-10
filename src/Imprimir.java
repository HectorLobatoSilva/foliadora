
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lobat
 */
public class Imprimir {
    Font fuente = new Font("Dialog", Font.BOLD, 12);
    PrintJob pj;
    Graphics pagina;

    /**
     * ******************************************************************
     * A continuación el constructor de la clase. Aquí lo único que	* hago es
     * tomar un objeto de impresion.	*
	*******************************************************************
     */
    Imprimir() {
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
    }

    /**
     * ******************************************************************
     * A continuación el método "imprimir(String)", el encargado de * colocar en
     * el objeto gráfico la cadena que se le pasa como * parámetro y se imprime.
     * *
	*******************************************************************
     */
    public void Paguina(String Cadena) {
        //LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
        try {
            pagina = pj.getGraphics();
            pagina.setFont(fuente);
            pagina.setColor(Color.black);

            pagina.drawString(Cadena, 500, 750);

            pagina.dispose();
        } catch (Exception e) {
//            System.out.println("LA IMPRESION HA SIDO CANCELADA...");
                System.out.println(e.getMessage());
        }
    }//FIN DEL PROCEDIMIENTO imprimir(String...)
    
    public void terminar(){
        pj.end();
    }
    
    public String folear(int hojas){
        String salida = "";
        if(hojas < 10){
            salida = "00000"+hojas;
        }else if(hojas >= 10 && hojas <= 99){
            salida = "0000"+hojas;
        }else if(hojas >= 100 && hojas <= 999){
            salida = "000"+hojas;
        }else if(hojas >= 1000 && hojas <= 9999){
            salida = "00"+hojas;
        }else if(hojas >= 10000 && hojas <= 99999){
            salida = "0"+hojas;
        }else if(hojas >= 100000 && hojas <= 999999){
            salida = ""+hojas;
        }
        return salida;
    }
    
    public String folear2(int hoja){
        String salida = "";
        if(hoja < 10){
            salida = "00000"+hoja+(char)(hoja+64);
        }else if(hoja >= 10 && hoja <= 99){
            salida = "0000"+hoja+(char)(hoja+64);;
        }else if(hoja >= 100 && hoja <= 999){
            salida = "000"+hoja+(char)(hoja+64);;
        }else if(hoja >= 1000 && hoja <= 9999){
            salida = "00"+hoja+(char)(hoja+64);;
        }else if(hoja >= 10000 && hoja <= 99999){
            salida = "0"+hoja+(char)(hoja+64);;
        }else if(hoja >= 100000 && hoja <= 999999){
            salida = ""+hoja+(char)(hoja+64);;
        }
        return salida;
    }
}
