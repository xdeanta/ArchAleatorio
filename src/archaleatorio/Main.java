package archaleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        //Escritura del fichero
        RandomAccessFile f = new RandomAccessFile("texto1.txt","rw");
        String[] codes = {"p1","p2","p3"};
        String[] descs = {"parafusos","cravos ","tachas"};
        String aux=null;
        int[] precios = { 3,4,5 };

        for(int i=0;i<3;i++){
            aux=String.format("%-" + 3 + "s", codes[i]);
            aux=aux.replace(' ','0');
            f.writeChars(aux);
            aux=String.format("%-" + 10 + "s", descs[i]);
            aux=aux.replace(' ','0');
            f.writeChars(aux);
            f.writeInt(precios[i]);
        }

        //Lectura del fichero

        char in;
        String cod="";
        String desc="";
        int precio;
        /*Product[] prod=new Product[3];
        f.seek(0); //Lectura desde el principio del fichero
        
        for(int j=0;j<3;j++){ // bucle para recorrer cada registo sabiendo el numero total de registros
        //Se puede reemplazar con un indexado utilizando la formula: (Posicion-1)*tamaño del registro en bytes (30 bytes en este caso)
            for(int i=0;i<3;i++) {
                in=f.readChar();
                cod=cod+in;
            }
            cod=cod.replace("0","");
            for(int i=0;i<10;i++) {
                in=f.readChar();
                desc=desc+in;
            }
            desc=desc.replaceAll("0","");
            precio=f.readInt();
            prod[j]=new Product(cod,desc,precio);
            cod= desc ="";
        }
        for(int i=0;i<3;i++){
            System.out.println(prod[i]);
        }
        */
        // Acceso al registro de producto 2 dentro del fichero
        f.seek((2-1)*30); // formula: (posicion-1)*30 bytes para el indexado dentro del archivo
        for(int i=0;i<3;i++){ //campo codigo
            in=f.readChar();
            cod=cod+in;
        }
        for(int i=0;i<10;i++){ // campo descripcion
            in=f.readChar();
            desc=desc+in;
        }
        //Saneamiento de los strings
        cod=cod.replaceAll("0", ""); 
        desc=desc.replaceAll("0", "");
        precio=f.readInt();
        /*System.out.println(cod);
        System.out.println(desc);
        System.out.println(precio);*/
        //Creacion es objeto producto
        Product p2 = new Product(cod,desc,precio);
        System.out.println(p2);
        f.close();
    }
}
